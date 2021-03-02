package com.company.yedam.config;

import javax.inject.Singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.company.yedam.di.AppleSpeaker;
import com.company.yedam.di.LgTV;
import com.company.yedam.di.SamsungTV;
import com.company.yedam.di.SonySpeaker;
import com.company.yedam.di.Speaker;
import com.company.yedam.di.TV;

//@Configuration
@EnableAspectJAutoProxy // java 기반의 방식
public class AppConfig {
	@Bean
	public Speaker speaker() {
		return new AppleSpeaker();
	}

	// speaker
	@Bean
	@Singleton
	public TV tvSvc() {
		SamsungTV tv = new SamsungTV();
		tv.setSpeaker(speaker());
		return tv;
	}
	// tv
}
