package com.mz.mybatis.product.model.service;

import java.util.ArrayList;

import com.mz.mybatis.product.model.vo.Basket;
import com.mz.mybatis.product.model.vo.OrderDetail;
import com.mz.mybatis.product.model.vo.OrderPro;
import com.mz.mybatis.product.model.vo.ProductReview;

public interface ProductService {
	
	// 1. 상품 배송 현황에 따른 주문 갯수
	public OrderPro countOrder(String memId);
	
	// 2. 마이페이지에서 주문상세 내역 최신 2개 조회
	public ArrayList<OrderPro> selectNewOrder(String memId);
	
	// 3. 마이페이지에서 밀키트 리뷰 중 최신 2개 게시글 조회
	public ArrayList<ProductReview> selectNewProductReview(String memId);
	
	// 4. 장바구니 담은 '월'만 조회
	public ArrayList<Basket> selectMonth(String memId);
	
	// 5. 장바구니 목록 
	public ArrayList<Basket> selectBasketList(String memId);
	
	// 6. 주문현황 '월'만 조회
	public ArrayList<OrderPro> selectOrderMonth(String str, String memId);
	
	// 7. 상품준비중, 배송중, 배송완료, 구매취소 목록
	public ArrayList<OrderPro> selectOrderList(String str, String memId);
	
	// 8. 전체 주문 현황 '월'만 조회
	public ArrayList<OrderPro> selectAllOrderMonth(String memId);
	
	// 9. 전체 주문 현황
	public ArrayList<OrderPro> selectAllOrderList(String memId);
	
	// 10. 장바구니 상품 선택 삭제 처리
	public int deleteBasket(String no);
	
	// 11. 상품준비중, 배송중, 배송완료에서 '구매확정'처리
	public int updatePurchaseConfirm(int orderNo);
	
	// 12. 상품준비중, 배송중, 배송완료에서 '구매취소'처리
	public int updatePurchaseCancel(int orderNo);
	 
	// 13. 주문 상세 페이지에서 주문 페이지에 담긴 정보들을 조회
	public OrderDetail selectOrderDetail(String memId, int orderNo);
	
	// 14. 주문 상세 페이지 조회처리
	public ArrayList<OrderDetail> selectOrderDetailList(String memId, int orderNo);
	 
}
