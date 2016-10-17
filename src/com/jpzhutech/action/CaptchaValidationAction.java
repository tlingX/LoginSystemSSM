package com.jpzhutech.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
public class CaptchaValidationAction {

	@RequestMapping(value = "validate.action")
	public void validate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 从request域中得到该对象
		ImageCaptchaService service = (ImageCaptchaService) request
				.getSession().getAttribute("service");
System.out.println(service == null ? "service对象没有获取到"
				: "service对象正确的获取到");
System.out.println(service.toString());

		// 接收响应的参数
		String userCaptchaResponse = request.getParameter("japtcha");
System.out.println("userCaptchaResponse究竟是什么？" + userCaptchaResponse);
		// 返回验证码输入正确与否的状态
		boolean validate_state = service.validateResponseForID(
				request.getSession(true).getId(), userCaptchaResponse)
				.booleanValue();

		if (validate_state) {
System.out.println("验证码正确");
			request.getRequestDispatcher("/signin.action").forward(request,
					response);
		} else {
System.out.println("验证码错误");
			request.getRequestDispatcher("/validate_error.jsp").forward(
					request, response);
			;
		}
	}
}
