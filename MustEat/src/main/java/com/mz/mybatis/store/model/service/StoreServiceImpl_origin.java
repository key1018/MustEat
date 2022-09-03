package com.mz.mybatis.store.model.service;

import static com.mz.mybatis.common.JDBCTemplate.close;
import static com.mz.mybatis.common.JDBCTemplate.commit;
import static com.mz.mybatis.common.JDBCTemplate.getConnection;
import static com.mz.mybatis.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mz.mybatis.common.model.vo.PageInfo;
import com.mz.mybatis.store.model.dao.StoreDao_origin;
import com.mz.mybatis.store.model.vo.Editor;
import com.mz.mybatis.store.model.vo.Store;
import com.mz.mybatis.store.model.vo.StoreReview;

public class StoreServiceImpl_origin {
	//메소드 위에 주석으로 이름 달아두기!!!
	public int StoreReviewPaging() {
		Connection conn = getConnection();
		int listCount = new StoreDao_origin().StoreReviewPaging(conn);
		close(conn);
		return listCount;
	}
	//채윤(식당 상세조회수)
	public int increaseCount(int storeNo) {
		Connection conn = getConnection();
		int result = new StoreDao_origin().increaseCount(conn,storeNo);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	//채윤(에디터상세조회수)
		public int increaseCountE(int editorNo) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().increaseCountE(conn,editorNo);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		//채윤(식당리뷰상세조회수)
		public int increaseCountR(int reviewNo) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().increaseCountR(conn,reviewNo);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
	//채윤 (식당 리뷰 목록 조회/ StoreReviewListController와 연결)
	public ArrayList<StoreReview> selectStoreReviewList(PageInfo pi){
		Connection conn = getConnection();
		ArrayList<StoreReview> list = new StoreDao_origin().selectStoreReviewList(conn,pi);
		close(conn);
		return list;
	}
	//채윤 (식당 리뷰 검색/ UserReviewController와 연결)
	public ArrayList<StoreReview> userStoreReview(String type, String keyword){
		
		Connection conn = getConnection();
		ArrayList<StoreReview> list = new StoreDao_origin().userStoreReview(conn, type, keyword);
		close(conn);
		return list;
	}
	
	//채윤 (식상 상세조회/ StoreDetailController와 연결)
	public Store selectStore(int storeNo) {
		Connection conn = getConnection();
		Store s = new StoreDao_origin().selectStore(conn, storeNo);
		close(conn);
		return s;
	}
	
	public ArrayList<StoreReview> selectStoreReview(int storeNo) {
		Connection conn = getConnection();
		ArrayList<StoreReview> review = new StoreDao_origin().selectStoreReview(conn, storeNo);
		close(conn);
		return review;
	}
	
	//채윤 (식당 조회 상세위함)
		public ArrayList<Store> forDetailList(){
			
			Connection conn = getConnection();
			ArrayList<Store> fdlist = new StoreDao_origin().forDetailList(conn);
			close(conn);
			return fdlist;
		}
	

	// 은영
	/**
	 * 마이페이지에서 가게 리뷰 중 최신 2개글 조회하는 Dao
	 * @param memId : 로그인한 회원 아이디
	 * @return : 조회된 밀키트 리뷰가 담긴 ArrayList<StoreReview> 객체
	 */
	public ArrayList<StoreReview> selectNewStoreReview(String memId) {
		
		Connection conn = getConnection();
		
		ArrayList<StoreReview> srList = new StoreDao_origin().selectNewStoreReview(conn, memId);
		
		close(conn);
		
		return srList;
		
	}

	//채윤 식당 메인2페이지

	public ArrayList<Store> selectStoreList(){
		Connection conn = getConnection();
		ArrayList<Store> list = new StoreDao_origin().selectStoreList(conn);
		
		close(conn);
		return list;
	}
	
	//채윤 메인2 식당 검색
	public ArrayList<Store> userStoreSearch(String type, String keyword){
		
		Connection conn = getConnection();
		ArrayList<Store> list = new StoreDao_origin().userStoreSearch(conn, type, keyword);
		close(conn);
		return list;
	}
	
	//채윤 식당리뷰 페이징..
	
			public int StoreReviewListCount() {
				Connection conn = getConnection();
				int listCount = new StoreDao_origin().StoreReviewListCount(conn);
				close(conn);
				return listCount;
			}
	
	
	

	// 서원 관리자 식당조회 
	public ArrayList<Store> selectAdminStorelist() {
		Connection conn = getConnection();
		ArrayList<Store> list = new StoreDao_origin().selectAdminStorelist(conn); 
		close(conn);
		return list;
	}
	
	
	
	
	
	//채윤 써머노트 등록
	public int insertEditor(Editor e) {
		Connection conn = getConnection();
		int result = new StoreDao_origin().insertPost(conn, e);
		
		if(result > 0) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	
	//채윤 에디터글 리스트 조회
	public ArrayList<Editor> editorWritelist(){
		Connection conn = getConnection();
		ArrayList<Editor> list = new StoreDao_origin().editorWritelist(conn);
		
		close(conn);
		return list;
	}
	
	
	//채윤 에디터글 상세조회
	public Editor selectDetailEdior(int editorNo) {
		Connection conn = getConnection();
		Editor e = new StoreDao_origin().selectDetailEdior(conn, editorNo);
		close(conn);
		return e;
	}
	
	
	//채윤 식당리뷰 등록
		public int insertStoreReview(String html,StoreReview sr ) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().insertStoreReview(conn, html,sr);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
	//채윤 식당 세선
		public Store storeSession(String storename, String storeno) {
			Connection conn = getConnection();
			Store s = new StoreDao_origin().storeSession(conn, storename, storeno);
			close(conn);
			return s;
		}
		
	//채윤 식당 리뷰 상세조회
		public StoreReview storeReviewDetail(int reNo) {
			Connection conn = getConnection();
			StoreReview sr = new StoreDao_origin().storeReviewDetail(conn, reNo);
			close(conn);
			return sr;
			
		}
		
		
	//서원 관리자 식당 등록
		public int storelistInsert(Store se) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().storelistInsert(conn, se);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
		
	// 서원 관리자 식당 상세 조회
		public Store selectStoreFormList(int storeNo) {
			Connection conn = getConnection();
			Store s = new StoreDao_origin().selectStoreFormList(conn, storeNo);
			close(conn);
			return s;
		}
		
		
		
		//채윤 식당리뷰 세선
				public StoreReview storeReviewSession(String reviewNo) {
					Connection conn = getConnection();
					StoreReview sr= new StoreDao_origin().storeReviewSession(conn,reviewNo);
					close(conn);
					return sr;
				}
				
	// 서원 관리자 식당 수정
		public int storelistUpdate(Store s) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().storelistUpdate(conn, s);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			
			close(conn);
			
			return result;
		}
			
	// 서원 관리자 식당 삭제
		public int storelistDelete(int storeNo) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().storelistDelete(conn, storeNo);
			
			if(result > 0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			
			return result;		
		}
		
	// 서원 사용자 식당 조회
		public ArrayList<Store> storelistSearch() {
			Connection conn = getConnection();
			ArrayList<Store> list = new StoreDao_origin().storelistSearch(conn);
			
			close(conn);
			return list;
		}

		
//	//////////////@@@@리뷰관리@@@@@/////////////////////
//		
		//회원번호별 조회
		public ArrayList<StoreReview> selectList(PageInfo pi, String search){
			Connection conn = getConnection();
			ArrayList<StoreReview> list = new StoreDao_origin().selectList(conn, pi, search);
			close(conn); 
			return list;
		}
		
		//신고횟수별 조회
		public ArrayList<StoreReview> selectList1(PageInfo pi, String search){
			Connection conn = getConnection();
			ArrayList<StoreReview> list = new StoreDao_origin().selectList1(conn, pi, search);
			close(conn);
			return list;
		}
		
		// 게시일별 조회
		public ArrayList<StoreReview> selectList2(PageInfo pi, String search){
			Connection conn = getConnection();
			ArrayList<StoreReview> list = new StoreDao_origin().selectList2(conn, pi, search);
			close(conn);
			return list;
		}
		
		// 리뷰 총수
		public int selectListCount(String search) {
			Connection conn = getConnection();
			int listCount = new StoreDao_origin().selectListCount(conn, search);
			close(conn);
			return listCount;
		}
		
		// 태민 체크박스 선택된 리뷰삭제
		
		public int rwithdrawalMember(String userNo) {
			Connection conn = getConnection();
			int result = new StoreDao_origin().rwithdrawalMember(conn, userNo);
			if(result>0) {
				commit(conn);
			}else {
				rollback(conn);
			}
			close(conn);
			return result;
		}
		
		
		// 태민 리뷰 검색
//		public ArrayList<StoreReview> searchList(PageInfo pi, String input){
//			Connection conn = getConnection();
//			ArrayList<StoreReview> list = new StoreDao_origin().searchList(conn, pi, input);
//			close(conn);
//			return list;
//		}
		
//		////////////////////////////
		
		
		// 서원 식당검색 페이지 별점 조회
//		public int selectStoreRate(int storeNo) {
//			Connection conn = getConnection();
//			int storeRate = new StoreDao_origin().selectStoreRate(conn, storeNo);
//			close(conn);
//			return storeRate;
//		}

		
		// 은영
		/**
		 * 지도에서 해당 지역 누르면 지역 페이지로 이동하는 Service
		 * @param city : 사용자가 누른 지역명
		 * @return : 해당 지역에 있는 식당 목록 정보가 담긴 ArrayList<Store>
		 */
		public ArrayList<Store> searchCity(String city){
			
			Connection conn = getConnection();
			
			ArrayList<Store> list = new StoreDao_origin().searchCity(conn, city);
			
			close(conn);
			
			return list;
			

		}

		
		// 서원 관리자 식당 검색
		public ArrayList<Store> selectStoreAdminSearch(String keyword) {
			
			Connection conn = getConnection();
			ArrayList<Store> list = new StoreDao_origin().selectStoreAdminSearch(conn, keyword);
			close(conn);
			return list;
			
		}
		
		// 식당 사용자 식당 검색
		public ArrayList<Store> selectStorelistSearchForm(String keyword) {
			Connection conn = getConnection();
			ArrayList<Store> list = new StoreDao_origin().selectStorelistSearchForm(conn, keyword);
			close(conn);
			return list;
		}
		
		
		
		
		
		


		// 은영
		/**
		 * 지도에서 해당 지역 누르면 지역이 조회되는 Service
		 * @param city : 사용자가 누른 지역명
		 * @return : 해당 지역 정보가 담긴 Store 객체
		 */
		public Store selectCity(String city) {
			
			Connection conn = getConnection();
			
			Store s = new StoreDao_origin().selectCity(conn, city);
			
			close(conn);
			
			return s;
			
		}
		

	//채윤 메인페이지 조회	
	/*
	 * public ArrayList<Store> mainpage(String map){ Connection conn =
	 * getConnection(); ArrayList<Store> list = new StoreDao_origin().mainpage(conn, map);
	 * 
	 * close(conn); return list; }
	 */

	// 서원 관리자 식당 조회 페이징 처리
//	public int selectStoreAdminListCount() {
//		Connection conn = getConnection();
//		int listCount = new StoreDao_origin().selectStoreAdminListCount(conn);
//		close(conn);
//		return listCount;
//	}
		
		

}
