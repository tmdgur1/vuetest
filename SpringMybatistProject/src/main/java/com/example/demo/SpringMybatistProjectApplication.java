package com.example.demo;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.MapperServiceApp;
import com.example.demo.vo.VO;

@RestController
@ServletComponentScan
@SpringBootApplication
public class SpringMybatistProjectApplication {

	@Autowired()
	private MapperServiceApp a;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringMybatistProjectApplication.class, args);
	}
	
	@GetMapping("/count")
	public String getCount() {
		
		return a.getCount();
	}

	@GetMapping("/mapping")
	public String getMapping() {
		
		return a.getTest();
	}
	
	@GetMapping("/mapping2")
	public VO getMapping2() {
		
		VO vo = new VO();
		vo.a = "hello";
		vo.b = 10;
		
		return vo;
	}
	
	@GetMapping("/mapping3")
	public HashMap<String, String> getMapping3() {
		
		HashMap<String, String> map = new HashMap<>();
		map.put("1", "hello");
		map.put("2", "world");
		
		return map;
	}
}
