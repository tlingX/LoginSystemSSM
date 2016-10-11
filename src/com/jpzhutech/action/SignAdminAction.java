package com.jpzhutech.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.jpzhutech.entity.Admin;
import com.jpzhutech.javamail.GMailAuthenticator;
import com.jpzhutech.service.impl.AdminService;

@SuppressWarnings("deprecation")
public class SignAdminAction extends AbstractCommandController{
	private AdminService adminService ;   //业务层的方法
	
	
	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	//在该方法中我们希望将表单中的数据Admin对象封装起来，此时必须使用该类的无参数构造函数，并使用setCommandClass方法去构造
    public SignAdminAction() {
		this.setCommandClass(Admin.class);
		System.out.println(Admin.class);
	}
	
   /* 
    //当在你的实体的定义中不能将Date数据类型进行转换时，请使用该方法，在本例中实现将String封装为Date类型
    @Override
    protected void initBinder(HttpServletRequest request,
    		ServletRequestDataBinder binder) throws Exception {
    	binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true) );
    }
    */
    
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object object, BindException exception)
			throws Exception {
		Admin admin = (Admin) object;  //将数据封装起来
System.out.println("表单提交过来时的数据是:"+admin.toString());

			if (adminService.addAdmin(admin)) {    //调用该方法，将数据持久到数据库中，如果持久化成功，则发送邮件给当前的注册用户
				try {
					String host = "smtp.qq.com"; // 邮件服务器
					String from = "13101900@qq.com"; // 发送邮件的QQ
					String authcode = "fgoobvssrkuibjhe"; // 对于QQ的个人邮箱而言，密码使用的是客户端的授权码，而不是用户的邮箱密码
					Properties props = System.getProperties();
					props.put("mail.smtp.host", host);
					props.setProperty("mail.transport.protocol", "smtp"); // 发送邮件协议名称
					props.put("mail.smtp.auth", "true"); // 开启授权
					props.put("mail.smtp.user", from);
					props.put("mail.smtp.password", authcode);
					props.put("mail.smtp.port", "587"); // smtp邮件服务器的端口号，必须是587,465端口调试时失败
					props.setProperty("mail.smtp.ssl.enable", "true");

					Session session = Session.getDefaultInstance(props,
							new GMailAuthenticator("13101900@qq.com",
									"fgoobvssrkuibjhe"));

					props.put("mail.debug", "true");

					MimeMessage message = new MimeMessage(session);
					Address fromAddress = new InternetAddress(from);
					Address toAddress = new InternetAddress(admin.getEmail());

					message.setFrom(fromAddress);
					message.setRecipient(Message.RecipientType.TO, toAddress);

					message.setSubject("注册成功确认邮件");
					message.setSentDate(new Date());
					//发送的链接包括其写入到数据库中的UUID，也就是链接localhost:8080/Login_Sys/ActivateServlet和UUID的拼接，#连接两个字符串
					//获取UUID
System.out.println(adminService.getUUID(admin));
					message.setContent("<h1>恭喜你注册成功，请点击下面的连接激活账户</h1><h3><a href='http://localhost:8080/Login_Sys_Spring_SpringMVC_c3p0/Activate.action?code="+adminService.getUUID(admin)+"'>http://localhost:8080/Login_Sys_Spring_SpringMVC_c3p0/Activate</a></h3>","text/html;charset=utf-8");
					Transport transport = session.getTransport();
					transport.connect(host, from, authcode);
					message.saveChanges();
					Transport.send(message);
					transport.close();

				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}

			} 
	    
//封装一个ModelAndView对象，提供转发视图的功能
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("message", "增加管理员成功");
	    modelAndView.setViewName("sign_success");      //成功之后跳转到该界面，采用逻辑视图，必须要配置视图解析器
		return modelAndView;  //该方法一定要返回modelAndView
	}

}
