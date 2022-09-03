package com.mz.mybatis.product.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import com.mz.mybatis.product.model.vo.Basket;
import com.mz.mybatis.product.model.vo.OrderDetail;
import com.mz.mybatis.product.model.vo.OrderPro;
import com.mz.mybatis.product.model.vo.ProductReview;

public class ProductDao {
	
	/**
	 * 장바구니, 상품준비중, 배송중, 배송완료, 상품취소, 구매확정 주문 수량 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 배송현황에 따른 주문 수량 정보가 담긴 OrderPro 객체
	 */
	public OrderPro countOrder(SqlSession sqlSession, String memId) {
		
		return sqlSession.selectOne("productMapper.countOrder", memId);
		
	}
	
	/**
	 * 마이페이지 주문상세 리스트 중 최신 2개 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 주문상세 리스트가 들어간 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectNewOrder(SqlSession sqlSession, String memId){

		return (ArrayList)sqlSession.selectList("productMapper.selectNewOrder", memId);
		
	}
	
	/**
	 * 마이페이지에서 밀키트 리뷰 중 최신 2개글 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 조회된 밀키트 리뷰가 담긴 ArrayList<ProductReview> 객체
	 */
	public ArrayList<ProductReview> selectNewProductReview(SqlSession sqlSession, String memId){
		
		return (ArrayList)sqlSession.selectList("productMapper.selectNewProductReview", memId);
	}
	
	/**
	 * 장바구니 목록에서 '월'만 조회하는 Dao
	 * @param memId : 로그인한 회원 아이디
	 * @return : 장바구니 담은 '월'이 담긴 ArrayList<Basket> 객체
	 */
	public ArrayList<Basket> selectMonth(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("productMapper.selectMonth", memId);
		
	}
	
	/**
	 * 장바구니에 담긴 상품 목록들을 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 장바구니에 담긴 상품 목록이 담긴 ArrayList<Basket> 객체
	 */
	public ArrayList<Basket> selectBasketList(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("productMapper.selectBasketList", memId);
		
	}
	
	/**
	 * 상품준비중, 배송중, 배송완료에서 '월'만 조회
	 * @param str : 배송현황이 담긴 문자열 (상품준비중, 배송중, 배송완료)
	 * @param memId : 로그인한 회원 아이디
	 * @return : 배송현황에 따라 진행된 '월'이 담긴 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectOrderMonth(SqlSession sqlSession, String str, String memId){
		
		HashMap<String, String> map = new HashMap<>();
		map.put("deliveryStatus", str);
		map.put("memId", memId);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectOrderMonth", map);
		
	}
	
	/**
	 * 상품준비중, 배송중, 배송완료에서 상품 목록을 조회
	 * @param str : 배송현황이 담긴 문자열 (상품준비중, 배송중, 배송완료)
	 * @param memId : 로그인한 회원 아이디
	 * @return : 배송현황에 따라 담긴 상품 목록들이 담긴 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectOrderList(SqlSession sqlSession, String str, String memId){
		
		HashMap<String, String> map = new HashMap<>();
		map.put("deliveryStatus", str);
		map.put("memId", memId);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectOrderList", map);
		
	}
	
	/**
	 * 주문 전체 '월'만 조회 요청하는 Service
	 * @param memId : 로그인한 회원 아이디
	 * @return : 주문한 '월'이 들어가있는 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectAllOrderMonth(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("productMapper.selectAllOrderMonth", memId);
		
	}
	
	/**
	 * 주문 전체 목록 요청
	 * @param memId : 로그인한 회원 아이디
	 * @return : 주문 목록이 들어가있는 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectAllOrderList(SqlSession sqlSession, String memId) {
		
		return (ArrayList)sqlSession.selectList("productMapper.selectAllOrderList", memId);
		
	}
	
	/**
	 * 장바구니 상품 삭제처리하는 Dao
	 * @param memNo : 로그인한 회원 번호
	 * @param no : 삭제처리하고자하는 장바구니 번호
	 * @return : 장바구니 삭제여부가 담긴 int형 변수
	 */
	public int deleteBasket(SqlSession sqlSession, String no) {
		
		return sqlSession.delete("productMapper.deleteBasket", no);
		
	}
	
	/**
	 * 상품준비중, 배송중, 배송완료에서 '구매확정'처리
	 * @param orderNo : 사용자가 선택한 주문번호
	 * @return : 구매확정 성공여부가 담긴 int형 변수(성공 : 1 | 실패 : 0)
	 */
	public int updatePurchaseConfirm(SqlSession sqlSession, int orderNo) {
		
		return sqlSession.update("productMapper.updatePurchaseConfirm", orderNo);
		
	}
	
	/**
	 * 상품준비중, 배송중, 배송완료에서 '구매취소'처리
	 * @param orderNo : 사용자가 선택한 주문번호
	 * @return : 구매취소 성공여부가 담긴 int형 변수(성공 : 1 | 실패 : 0)
	 */
	public int updatePurchaseCancel(SqlSession sqlSession, int orderNo) {
		
		return sqlSession.update("productMapper.updatePurchaseCancel", orderNo);
		
	}
	
	/**
	 * 주문 상세 페이지에서 주문 페이지에 담긴 정보들을 조회
	 * @param memId : 로그인한 회원 아이디
	 * @param orderNo : 주문 번호 (해당 번호의 주문 상세페이지로 이동)
	 * @return : 해당 주문 번호에 속해있는 주문 페이지 정보가 담겨있는 OrderDetail객체
	 */
	public OrderDetail selectOrderDetail(SqlSession sqlSession, String memId, int orderNo) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("memId", memId);
		map.put("orderNo", orderNo);
		
		return sqlSession.selectOne("productMapper.selectOrderDetail", map);
		
	}
	
	/**
	 * 주문 상세 페이지 조회
	 * @param memId : 로그인한 회원 아이디
	 * @param orderNo : 주문 번호 (해당 번호의 주문 상세페이지로 이동)
	 * @return : 해당 주문 번호에 속해있는 주문 상세 정보가 담겨있는 ArrayList<OrderDetail>객체
	 */
	public ArrayList<OrderDetail> selectOrderDetailList(SqlSession sqlSession, String memId, int orderNo) {
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("memId", memId);
		map.put("orderNo", orderNo);
		
		return (ArrayList)sqlSession.selectList("productMapper.selectOrderDetail", map);
		
	}

}
