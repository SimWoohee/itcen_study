package com.company.couplingtest;

import org.springframework.stereotype.Component;

@Component("sony")
public class SonySpeaker implements TV{

	public SonySpeaker() {
		System.out.println("소니스피커 객체 생성");
	}
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void volumnUp() {
		System.out.println("소니스피커 볼륨 업");
		
	}

	@Override
	public void volumnDown() {
		System.out.println("소니스피커 볼륨 다운");
		
	}

}
