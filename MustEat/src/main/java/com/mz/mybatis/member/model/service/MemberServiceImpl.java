package com.mz.mybatis.member.model.service;

import static com.mz.mybatis.common.JDBCTemplate.close;
import static com.mz.mybatis.common.JDBCTemplate.commit;
import static com.mz.mybatis.common.JDBCTemplate.getConnection;
import static com.mz.mybatis.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mz.mybatis.common.template.Template;
import com.mz.mybatis.member.model.dao.MemberDao;
import com.mz.mybatis.member.model.dao.MemberDao_origin;
import com.mz.mybatis.member.model.vo.Member;
import com.mz.mybatis.member.model.vo.MyPage;
import com.mz.mybatis.member.model.vo.Point;
import com.mz.mybatis.member.model.vo.StoreScrap;

public class MemberServiceImpl implements MemberService {
	
	// mapper파일들이 자동적으로 읽어들여지므로 Dao클래스 전역으로 생성하기
	private MemberDao mDao = new MemberDao();

	@Override
	/**
	 * 은영
	 * 회원 정보 수정 처리하는 Service
	 * @param m : 수정하고자하는 회원 정보가 담긴 Member 객체
	 * @return : 수정된 회원 정보가 담긴 Member 객체
	 */
	public Member updateMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession(); // mybatis-config.xml, xxx-mapper.xml 문서들도 읽어들여짐

		int result = mDao.updateMember(sqlSession, m);
		
		Member updateMem = null;
		
		if(result > 0) {
			updateMem = mDao.selectUpdateMember(sqlSession, m.getMemId());
		}
		
		return updateMem;
		
		
	}
	
	/**
	 * 회원 정보 수정시 닉네임 중복처리하는 Servlet
	 * @param checkNick : 중복체크할 닉네임
	 * @return : 중복 값이 있으면 1 없으면 0
	 */
	public int nickCheck(String checkNick) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.nickCheck(sqlSession, checkNick);
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	// 은영
	/**
	 * 회원 탈퇴 요청 처리하는 Service
	 * @param withdraw : 탈퇴 사유
	 * @param memId : 탈퇴할 회원 아이디
	 * @param deletePwd : 탈퇴시 확인할 회원 비밀번호
	 * @return : 탈퇴 성공여부가 담긴 int형 변수 (성공 : 1 | 실패 : 0)
	 */
	public int deleteMember(Member m) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDao.deleteMember(sqlSession, m);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		return result;
		
	}

	@Override
	// 은영
	/**
	 * 마이페이지 리뷰, 적립금, 가고싶다, 팔로우 횟수 조회하는 Service
	 * @param memId : 로그인한 회원 아이디
	 * @return : 마이페이지 정보가 담긴 MyPage 객체
	 */
	public MyPage selectMyPage(String memId) {

		
		SqlSession sqlSession = Template.getSqlSession();
		
		MyPage my = mDao.selectMyPage(sqlSession, memId);
		
		sqlSession.close();
		
		return my;
		
	}

	@Override
	// 은영
	/**
	 * 마이페이지에서 적립금 내역 중 최신 2개 조회하는 Service
	 * @param memId : 로그인한 회원아이디 
	 * @return : 적립금 내역이 담긴 ArrayList<Point> 객체
	 */
	public ArrayList<Point> selectNewPoint(String memId) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<Point> p = mDao.selectNewPoint(sqlSession, memId);
		
		sqlSession.close();
		
		return p;
	}

	@Override
	// 은영
	/**
	 * 마이페이지 식당 스크랩 중 최신 2개 조회하는 Dao
	 * @param memId : 로그인한 회원 아이디
	 * @return : 식당 스크랩 리스트가 들어간 ArrayList<StoreScrap> 객체 
	 */
	public ArrayList<StoreScrap> selectNewScrap(String memId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<StoreScrap> ss= mDao.selectNewScrap(sqlSession, memId);
		
		sqlSession.close();
		
		return ss;
		
	}


}
