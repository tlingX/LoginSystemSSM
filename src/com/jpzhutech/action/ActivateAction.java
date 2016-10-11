package com.jpzhutech.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jpzhutech.entity.Admin;
import com.jpzhutech.service.impl.AdminService;

@Controller
public class ActivateAction {

	private AdminService adminService;
	
	
	public AdminService getAdminService() {
		return adminService;
	}


	@Resource(name="adminServiceID")
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}


	@RequestMapping(value="/Activate.action")
	public String activate(HttpServletRequest request,Model model){   //使用request参数得到URL中?后面的UUID，后续会将UUID使用MD5算法加密
System.out.println("成功的跳转到激活页面");
        //检查是否能否得到激活链接?之后的UUID内容
System.out.println("得到的?之后的串为:"+request.getQueryString());
		
	    //切割得到用户的UUID
		String[] split = request.getQueryString().split("=");
System.out.println("切割出来的UUID为"+split[1]);
		//实现通过UUID到数据库中查找对应的用户，方法名为findByUUID
		Admin admin = adminService.findByUUID(split[1]);
System.out.println("获得的admin用户为:"+admin);

		//实现根据得到的用户信息，修改其用户的状态，方法名为updateState，更新当前点击链接的用户的状态为true
		adminService.updateState(admin);
System.out.println("更新状态之后的admin对象为："+admin);

		
		return "activate_success";
	}
	
	@Test
	public void test(){
		System.out.println(adminService);
	}
}
