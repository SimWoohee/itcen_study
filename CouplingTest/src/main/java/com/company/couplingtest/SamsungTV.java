package com.company.couplingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 * 	TV인터페이스의 구현 클래스
 *  
 *  클래스 선언부 위에 @Component를 설정해 줌으로써 스프링컨테이너는
 *  해당 클래스를 bean으로 생성하고 관리한다.
 */
@Component("tv")	
public class SamsungTV implements TV{
	
	@Autowired
	private SonySpeaker speaker;
	
	public void setSpeaker(SonySpeaker speaker) {
		System.out.println("======> setSpeaker() 호출");
		this.speaker = speaker;
	}
	private int price;
	
	
	public SamsungTV() {
		System.out.println("삼성TV(1) 객체 생성");
	}
	
	/*
	 * public SamsungTV(SonySpeaker speaker) { this.speaker = speaker;
	 * System.out.println("삼성TV(2) 객체 생성"); }
	 */	
	/*
	 * public SamsungTV(SonySpeaker speaker,int price) {
	 * System.out.println("삼성TV(3) 객체 생성"); this.speaker = speaker; this.price =
	 * price;
	 * 
	 * }
	 */
	
	public void setPrice(int price) {
		System.out.println("======> setPrice() 호출");
		this.price = price;
	}
	

	//재정의
	@Override
	public void powerOn() {
		System.out.println("삼성TV  ====> 전원 켠다(TV 가격 : " + price + "원)");
		
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
