package com.mz.mybatis.store.model.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mz.mybatis.store.model.vo.StoreReview;

public class StoreDao {
	
	/**
	 * 마이페이지에서 가게 리뷰 중 최신 2개글 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 조회된 밀키트 리뷰가 담긴 ArrayList<StoreReview> 객체
	 */
	public ArrayList<StoreReview> selectNewStoreReview(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("storeMapper.selectNewStoreReview", memId);
		
	}

}
