package com.jpzhutech.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.jpzhutech.entity.Admin;
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
	    adminService.addAdmin(admin);   //调用该方法，将数据持久到数据库中
	    
//封装一个ModelAndView对象，提供转发视图的功能
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("message", "增加管理员成功");
	    modelAndView.setViewName("sign_success");      //成功之后跳转到该界面，采用逻辑视图，必须要配置视图解析器
		return modelAndView;  //该方法一定要返回modelAndView
	}

}
