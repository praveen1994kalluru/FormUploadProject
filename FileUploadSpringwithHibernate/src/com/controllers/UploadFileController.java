package com.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.entitys.User;
import com.service.RegiterService;

@Controller
@RequestMapping("/up.htm")
public class UploadFileController {
	@Autowired
	private RegiterService service;
	@PostMapping
  public String saveUser(@RequestParam("name") String name,@RequestParam("image") CommonsMultipartFile image,HttpSession session) throws IOException{
		String viewName;
		String path=session.getServletContext().getRealPath("/");
		String fileName=image.getOriginalFilename();
	  System.out.println("uploadfilecontroller");
	  byte[] brr=image.getBytes();
	  BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(new File(path+"/"+fileName)));
	  bos.write(brr);
	  bos.flush();
	  bos.close();
	  User user=new User();
	  user.setUsername(name);
	  user.setContent(brr);
	  int i=service.saveUSer(user);
	  if(i==1){
		  viewName="success";
	  }else{
		  viewName="fail";
	  }
	  return viewName;
  }
}
