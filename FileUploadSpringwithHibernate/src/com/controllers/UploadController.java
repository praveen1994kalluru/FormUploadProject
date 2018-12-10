package com.controllers;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home.htm")
public class UploadController {
    @GetMapping
	public String home(){
    	System.out.println("upload controller");
	   return "register";
   }
}
