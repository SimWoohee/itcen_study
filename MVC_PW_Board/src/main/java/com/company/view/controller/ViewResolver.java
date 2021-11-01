package com.company.view.controller;

public class ViewResolver {
	
		public String prefix;	//���λ� "./" �ʱ�ȭ
		public String suffix;	//���̻� ".jsp" �ʱ�ȭ
		
		//setter �޼ҵ常 �ʿ�
		public void setPrefix(String prefix) {
			this.prefix = prefix;
		}
		public void setSuffix(String suffix) {
			this.suffix = suffix;
		}
		
		
		//����� ���� �޼ҵ�
		/*
		 *  �������� �� => ./getBoardList.jsp
		 *  ./ => ���λ� setPrefix("./");
		 *  .jsp => ���̻� setSuffix(".jsp")
		 */
		public String getView(String viewName) {
			return prefix + viewName + suffix;
		}
		
		

}
