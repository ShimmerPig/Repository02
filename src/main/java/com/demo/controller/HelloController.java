package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.domain.GirlProperties;

@RestController
@RequestMapping(value="/hi")
public class HelloController {
//	@Value("${cupSize}")
//	private String cupSize;
//	@Value("${content}")
//	private String content;
	
	@Autowired
	private GirlProperties girlProperties;
	
	
//	@RequestMapping(value= {"/say/{id}","/ssay/{id}"})
//	public String say(@PathVariable("id") Integer id) {
//		return "id:"+id;
//	}
	@RequestMapping(value= "say")
	public String say(@RequestParam("id") Integer myId) {
		return "id:"+ myId;
	}
}
