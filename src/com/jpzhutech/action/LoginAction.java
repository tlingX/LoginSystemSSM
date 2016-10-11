package com.jpzhutech.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



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



	@RequestMapping(value="/login.action")
	public String Login(Admin admin){
System.out.println("登录的邮箱为："+admin.getEmail());
System.out.println(adminService.getUUID(admin));
		return null;
		
	}
}
