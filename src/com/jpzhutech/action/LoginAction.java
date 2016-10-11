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
System.out.println(adminService.getUUID(admin));  //调试判断是否正确的得到了adminService对象
		
		
		return null;   //返回的视图
		
	}
}
