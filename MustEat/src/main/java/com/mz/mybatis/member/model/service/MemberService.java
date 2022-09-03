package com.mz.mybatis.member.model.service;

import java.util.ArrayList;

import com.mz.mybatis.member.model.vo.Member;
import com.mz.mybatis.member.model.vo.MyPage;
import com.mz.mybatis.member.model.vo.Point;
import com.mz.mybatis.member.model.vo.StoreScrap;

public interface MemberService {
	
	// 인터페이스의 모든 메소드는 추상메소드(미완성된 메소드)로만 작성해야됨

	// 1. 회원 정보 수정 처리용
	public Member updateMember(Member m);

	// 2. 회원 탈퇴 요청 처리용
	public int deleteMember(Member m);
	// String withdraw, String memId, String deletePwd 필요
	
	// 3. 마이페이지 리뷰, 적립금, 가고싶다, 팔로우 횟수 조회
	public MyPage selectMyPage(String memId);
	
	// 4. 마이페이지에서 적립금 내역 중 최신 2개 조회 처리용
	public ArrayList<Point> selectNewPoint(String memId);
	
	// 5. 마에피이제엇 식당스크랩 중 최신 2개 조회 처리용
	public ArrayList<StoreScrap> selectNewScrap(String memId);
	

	

}
