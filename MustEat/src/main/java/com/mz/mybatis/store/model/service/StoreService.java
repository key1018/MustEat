package com.mz.mybatis.store.model.service;

import java.util.ArrayList;

import com.mz.mybatis.store.model.vo.StoreReview;

public interface StoreService {
	
	// 1. 마이페이지에서 가게 리뷰 중 최신 2개 게시글 조회
	public ArrayList<StoreReview> selectNewStoreReview(String memId);

}
