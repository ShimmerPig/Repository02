package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.entity.Girl;

//女上仓库的接口
public interface GirlRepository extends JpaRepository<Girl, Integer>{
	public List<Girl>findByAge(Integer age);
}
