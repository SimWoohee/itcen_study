package com.company.business.board;

import java.sql.Date;

/*
 * 개발자가 구현하는 모든 클래스는 최상위 클래스인 object 클래스로부터 상속을 받는다
 * 그러므로 Object 클래스의 모든 메소드를 BoardDO 자식 클래스에서 재정의하여 사용할수 있음
 * Object 클래스의 toString()메소드를 재정의하여 사용!
 * 
 */

public class BoardDO {
	
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int cnt;
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	
	@Override
	public String toString() {
		return "BoardDO [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content + ", regdate="
				+ regdate + ", cnt=" + cnt + "]";
	}
	
	
	
	
	
	

}
