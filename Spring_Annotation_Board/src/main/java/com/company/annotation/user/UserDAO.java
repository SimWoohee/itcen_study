package com.company.annotation.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.annotation.common.JDBCUtil;
import com.company.annotation.common.PasswordEncUtil;

@Repository
public class UserDAO {

	@Autowired
	private SqlSession mybatis;
	
	String pwEncrypt;

	// 로그인 user 조회(select) 메소드 구현
	public UserDO getUser(UserDO userObj) {
		System.out.println("====>User.getUser() running ......");
		return mybatis.selectOne("UserMapper.getUser", userObj);
	}
	
	//11.02 추가
	//회원가입 인서트
	public void insertUser(UserDO userObj) {
		System.out.println("====>User.insertUser() running ......");
		  //암호화된 password 넣기
		  pwEncrypt = PasswordEncUtil.encryptSHA256(userObj.getPassword());
		  userObj.setPwencrypt(pwEncrypt);
		  System.out.println("PwEncr : " + userObj.getPwencrypt());
		  System.out.println("password : " + userObj.getPassword());
		  System.out.println("password : " + userObj.toString());
		  mybatis.insert("UserMapper.insertUser", userObj);
	}

}