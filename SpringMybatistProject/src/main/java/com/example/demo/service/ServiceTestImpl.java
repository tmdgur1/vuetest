package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service("st")
public class ServiceTestImpl implements ServiceTest {

	@Override
	public String test() {
		// TODO Auto-generated method stub
		return "ok";
	}

}
