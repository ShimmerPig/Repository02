package com.demo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ResultEnum;
import com.demo.entity.Girl;
import com.demo.exception.GirlException;
import com.demo.repository.GirlRepository;

@Service
public class GirlService {
	@Autowired
	private GirlRepository girlRepository;
	
	@Transactional
	public void insertTwo() {
		Girl girl1=new Girl();
		girl1.setCupSize("A");
		girl1.setAge(12);
		girlRepository.save(girl1);
		
		Girl girl2=new Girl();
		girl2.setCupSize("G");
		girl2.setAge(44);
		girlRepository.save(girl2);
	}
	
	public void getAge(Integer id) throws Exception{
		Optional<Girl> girl=girlRepository.findById(id);
		Integer age=girl.get().getAge();
		if(age<10) {
			throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
		}else if(age>10&&age<16) {
			throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
		}
	}
}
