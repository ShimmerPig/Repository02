package com.demo.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Girl;
import com.demo.entity.Result;
import com.demo.repository.GirlRepository;
import com.demo.service.GirlService;
import com.demo.utils.ResultUtil;

@RestController
public class GirlController {
	
	@Autowired
	private GirlRepository girlRepository;
	
	@Autowired
	private GirlService girlService;
	
	//查询所有的女生列表
	@GetMapping(value="/girls")
	public List<Girl>girlList(){
		return girlRepository.findAll();
	}
	
	//新增女生
	@PostMapping(value="/girls")
	public Result<Girl> girlAdd(@Valid Girl girl,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
		}
		girl.setCupSize(girl.getCupSize());
		girl.setAge(girl.getAge());
		return ResultUtil.success(girlRepository.save(girl));
	}
	
	//通过id查询一个女生
	@GetMapping(value="/girls/{id}")
	public Optional<Girl> girlFindOne(@PathVariable("id") Integer id) {
		return girlRepository.findById(id);
	}
	
	//更新
	@PostMapping(value="/girls/{id}")
	public Girl girlUpdate(@PathVariable("id") Integer id,
			@RequestParam("cupSize") String cupSize,
			@RequestParam("age") Integer age) {
		Girl girl=new Girl();
		girl.setId(id);
		girl.setCupSize(cupSize);
		girl.setAge(age);
		return girlRepository.save(girl);
	}
	
	//删除
	@DeleteMapping(value="/girls/{id}")
	public void girlDelete(@PathVariable("id") Integer id) {
		girlRepository.deleteById(id);
	}
	
	//通过年龄查询女生列表
	@GetMapping(value="/girls/age/{age}")
	public List<Girl>girlListByAge(@PathVariable("age") Integer age){
		return girlRepository.findByAge(age);
	}
	
	//同时插入两个女生
	@PostMapping(value="/girls/two")
	public void girlTwo() {
		girlService.insertTwo();
	}
	
	//获取女生年龄并进行判断
	@GetMapping(value="girls/getAge/{id}")
	public void getAge(@PathVariable("id") Integer id) throws Exception {
		girlService.getAge(id);
	}
}
