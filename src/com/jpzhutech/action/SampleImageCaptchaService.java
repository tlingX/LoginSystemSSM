package com.jpzhutech.action;

import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class SampleImageCaptchaService {

		 private static ImageCaptchaService instance; 

		 /** 
		 * Get default manageable image captcha service 
		 * @return ImageCaptchaService 
		 */ 
		 public static ImageCaptchaService getInstance() { 
		 if (instance == null) { 
		    instance = new DefaultManageableImageCaptchaService(); 
		  } 
		    return instance; 
		  } 
}
