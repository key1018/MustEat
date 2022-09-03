package com.mz.mybatis.member.model.dao;

import java.sql.Connection;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mz.mybatis.member.model.vo.Member;
import com.mz.mybatis.member.model.vo.MyPage;
import com.mz.mybatis.member.model.vo.Point;
import com.mz.mybatis.member.model.vo.StoreScrap;

public class MemberDao {
	
	// mybatis용 MemberDao
	
	
	// 은영
	/**
	 * 회원 정보 수정 처리
	 * @param m : 수정하고자하는 회원 정보가 담긴 Member 객체
	 * @return : 수정 성공여부가 담긴 int형 변수 (성공 : 1 | 실패 : 0)
	 */
	public int updateMember(SqlSession sqlSession, Member m) {

		return sqlSession.update("memberMapper.updateMember", m);
		
		
	}
	
	// 은영
	/**
	 * 수정된 회원정보 조회
	 * @param memId : 조회하고자하는 회원 아이디
	 * @return : 수정된 회원 정보가 담긴 Member 객체
	 */
	public Member selectUpdateMember(SqlSession sqlSession, String memId) {
		
		return sqlSession.selectOne("memberMapper.selectUpdateMember", memId);
		
	}
	
	/**
	 * 회원 탈퇴 요청 처리하는 Dao
	 * @param withdraw : 탈퇴 사유
	 * @param memId : 탈퇴할 회원 아이디
	 * @param deletePwd : 탈퇴시 확인할 회원 비밀번호
	 * @return : 탈퇴 성공여부가 담긴 int형 변수 (성공 : 1 | 실패 : 0)
	 */
	public int deleteMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.update("memberMapper.deleteMember", m);
		
	}
	
	// 은영
	/**
	 * 마이페이지 리뷰, 적립금, 가고싶다, 팔로우 횟수 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 마이페이지 정보가 담긴 MyPage 객체
	 */
	public MyPage selectMyPage(SqlSession sqlSession, String memId) {
		
		return sqlSession.selectOne("memberMapper.selectMyPage", memId);
		
	}
	
	/**
	 * 회원정보 수정시 닉네임 중복체크
	 * @param checkNick : 중복체크할 닉네임
	 * @return : 중복인 경우 : 1 | 아닌 경우 : 0
	 */
	public int nickCheck(SqlSession sqlSession, String checkNick) {
		
		return sqlSession.selectOne("memberMapper.nickCheck", checkNick);
		
	}
	
	/**
	 * 마이페이지에서 적립금 내역 중 최신 2개 조회하는 Dao
	 * @param memId : 로그인한 회원아이디 
	 * @return : 적립금 내역이 담긴 ArrayList<Point> 객체
	 */
	public ArrayList<Point> selectNewPoint(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("memberMapper.selectNewPoint", memId);
	}
	
	/**
	 * 마이페이지 식당 스크랩 중 최신 2개 조회하는 Dao
	 * @param memId : 로그인한 회원 아이디
	 * @return : 식당 스크랩 리스트가 들어간 ArrayList<StoreScrap> 객체 
	 */
	public ArrayList<StoreScrap> selectNewScrap(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("memberMapper.selectNewScrap", memId);
		
	}
}
