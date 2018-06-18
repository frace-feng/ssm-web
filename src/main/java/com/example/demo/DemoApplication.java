package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

//开启组件扫描，自动配置
@SpringBootApplication
//映射扫描
@MapperScan(value = { "com.example.demo.dao" })
public class DemoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		//负责启动引导应用程序
		SpringApplication.run(DemoApplication.class, args);
	}
	//将boot应用程序部署到tomcat容器中
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
}
