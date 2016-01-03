package com.yuanbook.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.yuanbook.dao.BaseRepository;

public class BaseService<T>{
	
	@Autowired
	protected BaseRepository<T> repository;
	
	public void add(){
		System.out.println("add...");
		System.out.println(repository);
	}
	
}
