package com.jpzhutech.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



import org.springframework.web.bind.annotation.RequestMethod;

import com.jpzhutech.entity.Admin;
import com.jpzhutech.service.impl.AdminService;

@Controller
public class LoginAction {
	
	private AdminService adminService;  //调用dao中的方法，怎么获取其对象成为一个十分棘手的问题
	
	

	public AdminService getAdminService() {
		return adminService;
	}

	@Resource(name="adminServiceID")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	@RequestMapping(value="/login.action",method=(RequestMethod.POST))   //只接收POST方法的提交方式
	public String Login(Admin admin,Model model){
System.out.println("登录的邮箱为："+admin.getEmail());  //调试是否通过参数正确的接收到了email属性值
System.out.println("登录的密码为:"+admin.getPwd());
System.out.println(adminService.getUUID(admin));  //调试判断是否正确的得到了adminService对象
		
		if(adminService.findByEmail(admin) == null){
			//说明email在数据库中不存在，也就是说用户根本没有注册过
			return "email_error";
		}else if(!admin.getPwd().equals(adminService.findPwd(admin))){  //如果从客户端传来的密码和根据email在数据库中查找得到的密码不一样，则报错
            //说明密码错误，跳转到密码错误的提示页面
System.out.println("密码错误");
			return  "password_error";
		}else if(!adminService.getUserState(admin)){   //查看是否成功的点击链接激活账户
System.out.println(!adminService.getUserState(admin));
			return "activate";
		}else{   //成功的登录
System.out.println("成功的登录");
			return "login_success";
		}
		
		
	}
}
