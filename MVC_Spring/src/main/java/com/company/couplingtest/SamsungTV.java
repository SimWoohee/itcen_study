package com.company.couplingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 	TV인터페이스의 구현 클래스
 */
@Component
public class SamsungTV implements TV{
	
	@Autowired
	private Sonyspeaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("삼성TV(1) 객체 생성");
	}
	
	public SamsungTV(Sonyspeaker speaker) {
		this.speaker = speaker;
		System.out.println("삼성TV(2) 객체 생성");
	}
	
	//다중 매핑!
	public SamsungTV(Sonyspeaker speaker,int price) {
		System.out.println("삼성TV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
		
	}
	//재정의
	@Override
	public void powerOn() {
		System.out.println("삼성TV  ====> 전원 켠다(TV 가격 : )" + price + "원");
		
	}

	@Override
	public void powerOff() {
		System.out.println("삼성TV  ====> 전원 끈다");
		
	}

	@Override
	public void volumnUp() {
		//speaker = new SonySpeaker();
		speaker.volumnUp();
		
	}

	@Override
	public void volumnDown() {
		//speaker = new SonySpeaker();
		speaker.volumnDown();
		
	}
	
	

}