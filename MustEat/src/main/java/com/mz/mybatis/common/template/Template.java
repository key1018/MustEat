package com.mz.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	
	// mybatis용 template(mybatis에서 제공하는 sqlSession)
	
	// sqlSession 하나로 commit, rollback, close처리 가능
	public static SqlSession getSqlSession() {
		
		// mybatis-config.xml 파일 읽어들여서
		// 해당 DB와 접속된 SqlSession 객체 생성해서 반환
		
		SqlSession sqlSession = null;
		
		// config파일 읽어들이기
		try {
			InputStream stream = Resources.getResourceAsStream("/config/mybatis-config.xml");
			
			sqlSession = new SqlSessionFactoryBuilder().build(stream).openSession(false); // 수동commit
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
		
	}
	

}
