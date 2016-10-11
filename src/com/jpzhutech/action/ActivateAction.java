package com.jpzhutech.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ActivateAction {

	@RequestMapping(value="/Activate.action")
	public String activate(){
System.out.println("成功的跳转到激活页面");
		return null;
	}
}
