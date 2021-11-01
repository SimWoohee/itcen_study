package com.company.couplingtest;

public class TVUser {
	public static void main(String[] args) {
		
		//LgTV를 사용하고 싶으면 LgTV객체만 교체해주면 된다
		//TV tv = new LgTV(); 
		//시그니처 메소드가 같으므로 가능함!
		//객체는 각자의 객체를 불러오고 인터페이스로 저장할것!
		TV tv = new SamsungTV(); 
		
		tv.powerOn();
		tv.powerOff();
		tv.volumnUp();
		tv.volumnDown();
		
	}
}