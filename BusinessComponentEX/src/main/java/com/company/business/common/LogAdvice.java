package com.company.business.common;

import org.springframework.stereotype.Component;

@Component
public class LogAdvice {
	public void printLog() {
		System.out.println("[공통 로그] 비즈니스 로직 전 기능 확인");
	}

}
