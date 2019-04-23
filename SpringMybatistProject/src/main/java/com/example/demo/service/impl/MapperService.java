package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mapper.Mappers;
import com.example.demo.service.MapperServiceApp;

@Service
@Transactional
public class MapperService implements MapperServiceApp {

	@Autowired
	private Mappers mapper;	
	
	private Integer count = 0;

	@Override
	public String getTest() {
		// TODO Auto-generated method stub
		return mapper.getTest();
	}

	@Override
	public String getCount() {
		// TODO Auto-generated method stub
		return (count++).toString();
	}
}
