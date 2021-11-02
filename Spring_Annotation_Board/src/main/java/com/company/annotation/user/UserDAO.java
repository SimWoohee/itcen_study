package com.company.annotation.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.company.annotation.common.JDBCUtil;
import com.company.annotation.common.PasswordEncUtil;

public class UserDAO {

	// DB 관련 변수 선언
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	//추가
	//회원 가입 시 패스워드를 암호화 시킨 데이터를 저장할 암호변수 선언
	String pwEncrypt;
	
	//추가
	//SQL 명령어
	private final String USERS_INSERT = "insert into users values(?,?,?,?,?)"; 
	

	//SQL 명령어
	private final String USER_GET
			= "select * from users where id=? and password=?";
	

	// 로그인 user 조회(select) 메소드 구현
	public UserDO getUser(UserDO userObj) {
		UserDO user = null;
		try {
			System.out.println("===> getUser() 기능 처리됨!");
			conn = JDBCUtil.getConnction();
			pstmt = conn.prepareStatement(USER_GET);
			pstmt.setString(1, userObj.getId());
			pstmt.setString(2, userObj.getPassword());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				user = new UserDO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				//추가
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		return user;
	}
	
	//11.02 추가
	//회원가입 인서트
	public boolean insertUser(UserDO userObj) {
		System.out.println("====> insertUser() 기능 처리!");
		boolean flag = false;
		UserDO user = null;
		
		try {
		  conn = JDBCUtil.getConnction();
		  pstmt = conn.prepareStatement(USERS_INSERT);
		  pstmt.setString(1, userObj.getId());
		  pstmt.setString(2, userObj.getPassword());
		  //암호화된 password 넣기
		  pwEncrypt = PasswordEncUtil.encryptSHA256(userObj.getPassword());
		  pstmt.setString(3, pwEncrypt);
		  pstmt.setString(4, userObj.getName());
		  pstmt.setString(5, userObj.getRole());
		  
		  int i = pstmt.executeUpdate();
		  
		  if(i > 0 ) {
			  flag = true;
		  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(pstmt, conn);
		}
		
		return flag;
	}

}