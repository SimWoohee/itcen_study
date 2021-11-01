package com.company.view.controller;

import java.io.IOException;

import javax.naming.spi.Resolver;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//객체 참조변수 선언
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	//수동으로 필요 메소드 오버라이드 시키는 방법 => 먼저 i를 입력하고 Ctrl + space => constructor 메소드 클릭
	@Override
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
       
    public DispatcherServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1. 클라이언트의 요청 path 정보 추출
		//ex) "http://localhost:8080/MVC_PW_Board/login.do" 요청을 가정하여
		String uri = request.getRequestURI();	// /MVC_PW_Board/login.do값 저장
		String filePath = uri.substring(uri.lastIndexOf("/")); //마지막 "/"부터 추출하여 저장
		
		//2. handlerMapping을 통해서 filePath에 해당하는 Controller를 검색한다. 
		Controller ctrl = handlerMapping.getController(filePath);
		
		//3. 검색된 Controller를 실행한다
		//LoginController의 handleRequest 호출
		String viewName = ctrl.handleRequest(request, response);
		//getBoardList.do 리턴
		//getBoardList
		//4. viewResolver를 통해서 viewName에 해당하는 페이지 포워딩
		String view = null;
		
		if(viewName.contains(".do")) {
			view = viewName;
		}else {
			view = viewResolver.getView(viewName);
			
		}
		
		response.sendRedirect(view);
	}
	
}
