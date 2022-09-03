package com.mz.mybatis.member.model.service;

import static com.mz.mybatis.common.JDBCTemplate.close;
import static com.mz.mybatis.common.JDBCTemplate.commit;
import static com.mz.mybatis.common.JDBCTemplate.getConnection;
import static com.mz.mybatis.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mz.mybatis.common.model.vo.PageInfo;
import com.mz.mybatis.member.model.dao.MemberDao;
import com.mz.mybatis.member.model.dao.MemberDao_origin;
import com.mz.mybatis.member.model.vo.Follow;
import com.mz.mybatis.member.model.vo.Member;
import com.mz.mybatis.member.model.vo.MyPage;
import com.mz.mybatis.member.model.vo.Point;
import com.mz.mybatis.member.model.vo.Report;
import com.mz.mybatis.member.model.vo.StoreScrap;

public class MemberServiceImpl_origin {
	//메소드 위에 이름 주석 꼭 달기!!!
	
	// 태민
	/**
	 * 로그인 처리하는 Service / LoginController2랑 연결
	 * @param userId : 사용자에게 입력받은 Id
	 * @param userPwd : 사용자에게 입력받은 Pwd
	 * @return : 입력받은 id/pwd 에 해당하는 회원정보 담긴 Member 객체  
	 */
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		Member m = new MemberDao_origin().loginMember(conn, userId, userPwd);
		close(conn);
		return m;
	}
	

	//태민 
	/**
	 * 아이디 찾기 처리하는 Service / FindIdController2랑 연결
	 * @param userName : 사용자에게 입력받은 유저이름
	 * @param userEmail : 사용자에게 입력받은 유저이메일
	 * @return : 입력받은 name/email에 해당하는 유저ID정보가 담긴 Member 객체
	 */
	public Member findId(String userName, String userEmail) {
		Connection conn = getConnection();
		Member m  = new MemberDao_origin().findId(conn, userName, userEmail);
		close(conn);
		return m;
	}
	
	
	//태민 
	/**
	 * 아이디 찾기 처리하는 Service / FindIdController2랑 연결
	 * @param userId : 사용자에게 입력받은 유저아이디
	 * @param userEmail : 사용자에게 입력받은 유저이메일
	 * @return : 입력받은 name/email에 해당하는 유저ID정보가 담긴 Member 객체
	 */
	public Member findPwd(String userId, String userEmail) {
		Connection conn = getConnection();
		Member m  = new MemberDao_origin().findPwd(conn, userId, userEmail);
		close(conn);
		return m;
	}
	
	//태민
	
	/**
	 * 회원가입시 아이디 중복검사 MemberEnrollIdCheck랑 연결
	 * @param checkId : 사용자가 입력한 id
	 * @return : 중복 값이 있으면 1 없으면 0
	 */
	public int idCheck(String checkId) {
		Connection conn = getConnection();
		int count = new MemberDao_origin().idCheck(conn, checkId);
		close(conn);
		return count;
	}
	
	//태민
	
	/**
	 * 회원가입시 닉네임 중복검사 MemberEnrollNIckCheck랑 연결
	 * @param checkId : 사용자가 입력한 닉네임
	 * @return 중복 값이 있으면 1 없으면 0
	 */
	public int nickCheck(String checkNick) {
		Connection conn = getConnection();
		int count = new MemberDao_origin().nickCheck(conn, checkNick);
		close(conn);
		return count;
	}
	
	//태민
	/**
	 * 회원가입시 이메일 중복검사 MemberEnrollEamilCheck랑 연결
	 * @param checkNick : 사용자가 입력한 이메일
	 * @return 중복 값이 있으면 1 없으면 0
	 */
	public int emailCheck(String checkEmail) {
		Connection conn = getConnection();
		int count = new MemberDao_origin().emailCheck(conn, checkEmail);
		close(conn);
		return count;
	}
	
	//태민
	/**
	 * 회원가입시 member 테이블에 insert하는 Service
	 * @param m
	 * @return
	 */
	public int insertMember(Member m) {
		Connection conn = getConnection();
		int result = new MemberDao_origin().insertMember(conn, m);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	// 태민
	/**
	 * 페이징처리하는중
	 * @param pi
	 * @return
	 */
	public ArrayList<Member> selectList(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().selectList(conn, pi, search);
		close(conn); 
		return list;
	}
	
	public ArrayList<Member> selectList1(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().selectList1(conn, pi, search);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> selectList2(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().selectList2(conn, pi, search);
		close(conn);
		return list;
	}
	
	public ArrayList<Member> selectList3(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().selectList2(conn, pi, search);
		close(conn);
		return list;
	}
	
	public int selectListCount(String search) {
		Connection conn = getConnection();
		int listCount = new MemberDao_origin().selectListCount(conn, search);
		close(conn);
		return listCount;
	}
	
	// 태민 체크박스 선택된 회원상태 블랙리스트로 변경
	
	public int withdrawalMember(String userNo) {
		Connection conn = getConnection();
		int result = new MemberDao_origin().withdrawalMember(conn, userNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int modifyDate(String userNo) {
		Connection conn = getConnection();
		int result2 = new MemberDao_origin().modifyDate(conn, userNo);
		if(result2>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result2;
	}
	
	// 태민 회원 검색
	public ArrayList<Member> searchList(PageInfo pi, String input){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().searchList(conn, pi, input);
		close(conn);
		return list;
	}
	
	
	////////////////////////태민 탈퇴상태 회원 관리//////////////////////
	
	//이름별 조회
	public ArrayList<Member> bselectList(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().bselectList(conn, pi, search);
		close(conn); 
		return list;
	}
	
	//탈퇴유형별 조회
	public ArrayList<Member> bselectList1(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().bselectList1(conn, pi, search);
		close(conn);
		return list;
	}
	
	// 탈퇴일별 조회
	public ArrayList<Member> bselectList2(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().bselectList2(conn, pi, search);
		close(conn);
		return list;
	}
	
	//탈퇴기간별 조회
	public ArrayList<Member> bselectList3(PageInfo pi, String search){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().bselectList3(conn, pi, search);
		close(conn);
		return list;
	}
	
	// 탈퇴상태 회원 총수
	public int bselectListCount(String search) {
		Connection conn = getConnection();
		int listCount = new MemberDao_origin().bselectListCount(conn, search);
		close(conn);
		return listCount;
	}
	
	// 태민 체크박스 선택된 회원정보삭제
	
	public int bwithdrawalMember(String userNo) {
		Connection conn = getConnection();
		int result = new MemberDao_origin().bwithdrawalMember(conn, userNo);
		if(result>0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	// 태민 체크박스 선택된 회원정보복구
	
		public int revivalMember(String userNo) {
			Connection conn = getConnection();
			int result = new MemberDao_origin().revivalMember(conn, userNo);
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		}
	

	
	// 태민 회원 검색
	public ArrayList<Member> bsearchList(PageInfo pi, String input){
		Connection conn = getConnection();
		ArrayList<Member> list = new MemberDao_origin().searchList(conn, pi, input);
		close(conn);
		return list;
	}
	
	////////////////////////////////////////////////////////////////////////////////
	
	// 은영
	/**
	 * 회원 정보 수정 처리하는 Service
	 * @param m : 수정하고자하는 회원 정보가 담긴 Member 객체
	 * @return : 수정된 회원 정보가 담긴 Member 객체
	 */
	public Member updateMember(Member m) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao_origin().updateMember(conn, m);
		
		Member updateMem = null;
		if(result > 0) {
			commit(conn);
			updateMem = new MemberDao_origin().selectUpdateMember(conn, m.getMemId());
		} else {
			rollback(conn);
		}
		
		return updateMem;
		
	}
	
	

	//채윤(신고 목록 조회 / ReportListController와 연결)
	public ArrayList<Report> selectReportList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Report> list = new MemberDao_origin().selectReportList(conn,pi);
		close(conn);
		return list;
	}
	
	// 은영
	/**
	 * 회원 탈퇴 요청 처리하는 Service
	 * @param withdraw : 탈퇴 사유
	 * @param memId : 탈퇴할 회원 아이디
	 * @param deletePwd : 탈퇴시 확인할 회원 비밀번호
	 * @return : 탈퇴 성공여부가 담긴 int형 변수 (성공 : 1 | 실패 : 0)
	 */
	public int deleteMember(String withdraw, String memId, String deletePwd) {
		
		Connection conn = getConnection();
		
		int result = new MemberDao_origin().deleteMember(conn, withdraw, memId, deletePwd);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;

	}
	
	// 은영
	/**
	 * 마이페이지 리뷰, 적립금, 가고싶다, 팔로우 횟수 조회하는 Service
	 * @param memId : 로그인한 회원 아이디
	 * @return : 마이페이지 정보가 담긴 MyPage 객체
	 */
	public MyPage selectMyPage(String memId) {
		
		Connection conn = getConnection();
		
		MyPage my = new MemberDao_origin().selectMyPage(conn, memId);
		
		close(conn);
		
		return my;
		
	}
	

	// 은영
	/**
	 * 마이페이지에서 적립금 내역 중 최신 2개 조회하는 Service
	 * @param memId : 로그인한 회원아이디 
	 * @return : 적립금 내역이 담긴 ArrayList<Point> 객체
	 */
	public ArrayList<Point> selectNewPoint(String memId) {
		
		Connection conn = getConnection();
		
		ArrayList<Point> mpsList = new MemberDao_origin().selectNewPoint(conn, memId);
		
		close(conn);
		
		return mpsList;
		
	}
	
	// 은영
	/**
	 * 마이페이지 식당 스크랩 중 최신 2개 조회하는 Dao
	 * @param memId : 로그인한 회원 아이디
	 * @return : 식당 스크랩 리스트가 들어간 ArrayList<StoreScrap> 객체 
	 */
	public ArrayList<StoreScrap> selectNewScrap(String memId) {
		
		Connection conn = getConnection();
		
		ArrayList<StoreScrap> ssList = new MemberDao_origin().selectNewScrap(conn, memId);
		
		close(conn);
		
		return ssList;
		

	}

		//채윤 팔로우 목록 조회
	public ArrayList<Follow> myFollowingList(int ffMNo){
		Connection conn = getConnection();
		ArrayList<Follow> flist = new MemberDao_origin().myFollowingList(conn, ffMNo);
		close(conn);
		return flist;
	}

	
	
	// 서원 관리자 적립금 조회
	public ArrayList<Point> membershipList(){
		Connection conn = getConnection();
		ArrayList<Point> list = new MemberDao_origin().membershipList(conn);
		close(conn);
		return list;		
	}
	
	// 서원 관리자 적립금 지급 조회
	public ArrayList<Point> membershipPayList(){
		Connection conn = getConnection();
		ArrayList<Point> list = new MemberDao_origin().membershipPayList(conn);
		close(conn);
		return list;
	}
	
	// 서원 관리자 적립금 지급하기 버튼 클릭시 적립금 지급
	
	
	// 서원 사용자 적립금 조회
	public ArrayList<Point> membershipUserList(int memNo){
		Connection conn = getConnection();
		ArrayList<Point> list = new MemberDao_origin().membershipUserList(conn, memNo);
		close(conn);
		return list;	
	}
	
	// 서원 사용자 적립금 조회 페이지 사용 가능한 적립금 조회
	public int membershipUseable(int memNo) {
		Connection conn = getConnection();
		int pu = new MemberDao_origin().membershipUseable(conn, memNo);
		close(conn);
		return pu;
	}
	
	// 서원 사용자 적립금 조회 페이지 소멸 예정 적립금 조회
	public int membershipDelete(int memNo) {
		Connection conn = getConnection();
		int pd = new MemberDao_origin().membershipDelete(conn, memNo);
		close(conn);
		return pd;
	}
	
	// 서원 사용자 리뷰 조회 
	public ArrayList<Member> memberReviewList(int memNo){
		Connection conn = getConnection();
		ArrayList<Member> reviewList = new MemberDao_origin().memberReviewList(conn, memNo);
		close(conn);
		return reviewList;	
	}
	
	// 서원 사용자 리뷰 조회 페이지 이번달 작성한 리뷰 조회
	public int memberReviewListMonth(int memNo) {
		Connection conn = getConnection();
		int month = new MemberDao_origin().memberReviewListMonth(conn, memNo);
		close(conn);
		return month;
	}
		
	// 서원 사용자 리뷰 조회 페이지 그동안 작성한 리뷰 조회
	public int memberReviewListTotal(int memNo) {
		Connection conn = getConnection();
		int total = new MemberDao_origin().memberReviewListTotal(conn, memNo);
		close(conn);
		return total;
	}
	
	
	
	
	
	//채윤 팔로우할 회원 목록 조회
	//채윤(신고 목록 조회 / ReportListController와 연결)
		public ArrayList<Member> selectFMemList() {
			Connection conn = getConnection();
			ArrayList<Member> list = new MemberDao_origin().selectFMemList(conn);
			close(conn);
			return list;
		} 
		
		
	//채윤 신고 등록
	public int reportInsert(Report rp) {
		Connection conn = getConnection();
		int result = new MemberDao_origin().reportInsert(conn, rp);
	
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	//채윤 가게찜 조회
	public ArrayList<StoreScrap> storeScrapList(int MNo){
		Connection conn = getConnection();
		ArrayList<StoreScrap> list = new MemberDao_origin().storeScrapList(conn, MNo);
		close(conn);
		return list;
	}
	
	//채윤 가게 찜 등록
		public int storeScrapInsert(StoreScrap ss) {
			Connection conn = getConnection();
			int result = new MemberDao_origin().storeScrapInsert(conn, ss);
		
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
		
		//채윤 팔로우 등록
	public int followInsert(Follow f) {
		Connection conn = getConnection();
		int result = new MemberDao_origin().followInsert(conn, f);
				
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
					
			close(conn);
					
			return result;
	}
	
	//채윤 신고 페이징..
	
		public int selectReportListCount() {
			Connection conn = getConnection();
			int listCount = new MemberDao_origin().selectReportListCount(conn);
			close(conn);
			return listCount;
		}
		
	//채윤 신고 삭제
	public int deleteReport(String delArr) {
		Connection conn = getConnection();
		int result = new MemberDao_origin().deleteReport(conn, delArr);
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	
	//채윤 언팔로우
		public int unfollow(int no) {
			
			Connection conn = getConnection();
			
			int result = new MemberDao_origin().unfollow(conn, no);
			
			if(result > 0) {
				commit(conn);
			} else {
				rollback(conn);
			}
			
			return result;
		}
}
