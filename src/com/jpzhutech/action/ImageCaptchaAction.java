package com.jpzhutech.action;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.octo.captcha.service.image.ImageCaptchaService;

@Controller
public class ImageCaptchaAction {

	@RequestMapping(value="ImageCreate.action")
	public void ImageCreate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// set content type as jpeg
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "no-cache");
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		ImageCaptchaService service = SampleImageCaptchaService.getInstance();
		Logger logger = Logger.getGlobal();
		System.out.println(service.toString());
		// 把这个service对象放入request域中
		request.getSession().setAttribute("service", service);

		// create the image using session ID
		logger.fine("tring to get image captcha service");
		BufferedImage bufferedImage = service.getImageChallengeForID(request
				.getSession(true).getId());

		ServletOutputStream servletOutputStream = response.getOutputStream();

		// write the image to the servlet output stream
		logger.fine("tring to output buffered image to servlet output stream");
		ImageIO.write(bufferedImage, "jpg", servletOutputStream);

		try {
			// 把这个service对象放入request域中
			request.getSession().setAttribute("service", service);
			servletOutputStream.flush();
		} finally {
			servletOutputStream.close();
		}
	}
}
