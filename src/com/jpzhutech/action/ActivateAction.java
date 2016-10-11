package com.jpzhutech.action;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivateAction {

	@RequestMapping(value="/Activate.action")
	public String activate(HttpServletRequest request){   //使用request参数得到URL中?后面的UUID，后续会将UUID使用MD5算法加密
System.out.println("成功的跳转到激活页面");
        //检查是否能否得到激活链接?之后的UUID内容
System.out.println("得到的?之后的串为:"+request.getQueryString());
		
	    //切割得到用户的UUID
		String[] split = request.getQueryString().split("=");
System.out.println("切割出来的UUID为"+split[1]);
		//实现通过UUID到数据库中查找对应的用户，方法名为findByUUID

		//实现根据得到的用户信息，修改其用户的状态，方法名为updateState


		return null;
	}
}
