package com.mz.mybatis.product.model.service;

import static com.mz.mybatis.common.template.Template.getSqlSession;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import com.mz.mybatis.product.model.dao.ProductDao;
import com.mz.mybatis.product.model.vo.Basket;
import com.mz.mybatis.product.model.vo.OrderDetail;
import com.mz.mybatis.product.model.vo.OrderPro;
import com.mz.mybatis.product.model.vo.ProductReview;

public class ProductServiceImpl implements ProductService{
	
	private ProductDao pDao = new ProductDao();

	@Override
	/**
	 * 장바구니, 상품준비중, 배송중, 배송완료, 상품취소, 구매확정 주문 수량 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 배송현황에 따른 주문 수량 정보가 담긴 OrderPro 객체
	 */
	public OrderPro countOrder(String memId) {
		
		SqlSession sqlSession = getSqlSession();
		
		OrderPro op = pDao.countOrder(sqlSession, memId);
		
		sqlSession.close();
		
		return op;
		
	}

	@Override
	/**
	 * 마이페이지 주문상세 리스트 중 최신 2개 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 주문상세 리스트가 들어간 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectNewOrder(String memId) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<OrderPro> list= pDao.selectNewOrder(sqlSession, memId);
		
		sqlSession.close();
		
		return list;
		
	}

	@Override
	/**
	 * 마이페이지에서 밀키트 리뷰 중 최신 2개글 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 조회된 밀키트 리뷰가 담긴 ArrayList<ProductReview> 객체
	 */
	public ArrayList<ProductReview> selectNewProductReview(String memId) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<ProductReview> list= pDao.selectNewProductReview(sqlSession, memId);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	/**
	 * 장바구니 목록에서 '월'만 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 장바구니 담은 '월'이 담긴 ArrayList<Basket> 객체
	 */
	public ArrayList<Basket> selectMonth(String memId) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Basket> month = pDao.selectMonth(sqlSession, memId);
		
		sqlSession.close();
		
		return month;
	}

	@Override
	/**
	 * 장바구니에 담긴 상품 목록들을 조회
	 * @param memId : 로그인한 회원 아이디
	 * @return : 장바구니에 담긴 상품 목록이 담긴 ArrayList<Basket> 객체
	 */
	public ArrayList<Basket> selectBasketList(String memId) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<Basket> list = pDao.selectBasketList(sqlSession, memId);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	/**
	 * 상품준비중, 배송중, 배송완료에서 '월'만 조회
	 * @param str : 배송현황이 담긴 문자열 (상품준비중, 배송중, 배송완료)
	 * @param memId : 로그인한 회원 아이디
	 * @return : 배송현황에 따라 진행된 '월'이 담긴 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectOrderMonth(String str, String memId) {
		
		SqlSession sqlSession = getSqlSession();
		
		ArrayList<OrderPro> month = pDao.selectOrderMonth(sqlSession, str, memId);
		
		sqlSession.close();
		
		return month;
	}

	@Override
	/**
	 * 상품준비중, 배송중, 배송완료에서 상품 목록을 조회
	 * @param str : 배송현황이 담긴 문자열 (상품준비중, 배송중, 배송완료)
	 * @param memId : 로그인한 회원 아이디
	 * @return : 배송현황에 따라 담긴 상품 목록들이 담긴 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectOrderList(String str, String memId) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<OrderPro> list = pDao.selectOrderList(sqlSession, str, memId);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	/**
	 * 주문 전체 '월'만 조회 요청하는 Service
	 * @param memId : 로그인한 회원 아이디
	 * @return : 주문한 '월'이 들어가있는 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectAllOrderMonth(String memId) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<OrderPro> month = pDao.selectAllOrderMonth(sqlSession, memId);
		
		sqlSession.close();
		
		return month;
	}

	@Override
	/**
	 * 주문 전체 목록 요청
	 * @param memId : 로그인한 회원 아이디
	 * @return : 주문 목록이 들어가있는 ArrayList<OrderPro> 객체
	 */
	public ArrayList<OrderPro> selectAllOrderList(String memId) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<OrderPro> list = pDao.selectAllOrderList(sqlSession, memId);
		
		sqlSession.close();
		
		return list;
	}

	@Override
	/**
	 * 장바구니 상품 삭제처리하는 Dao
	 * @param memNo : 로그인한 회원 번호
	 * @param no : 삭제처리하고자하는 장바구니 번호
	 * @return : 장바구니 삭제여부가 담긴 int형 변수
	 */
	public int deleteBasket(String no) {
		
		// delete => 처리된 행 수 반환 => int형 변수
		
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.deleteBasket(sqlSession, no);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		return result;
	}

	@Override
	/**
	 * 상품준비중, 배송중, 배송완료에서 '구매확정'처리
	 * @param orderNo : 사용자가 선택한 주문번호
	 * @return : 구매확정 성공여부가 담긴 int형 변수(성공 : 1 | 실패 : 0)
	 */
	public int updatePurchaseConfirm(int orderNo) {

		// update => 처리된 행 수 반환 => int형 변수
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.updatePurchaseConfirm(sqlSession, orderNo);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		return result;
		
	}

	@Override
	/**
	 * 상품준비중, 배송중, 배송완료에서 '구매취소'처리
	 * @param orderNo : 사용자가 선택한 주문번호
	 * @return : 구매취소 성공여부가 담긴 int형 변수(성공 : 1 | 실패 : 0)
	 */
	public int updatePurchaseCancel(int orderNo) {

		// update => 처리된 행 수 반환 => int형 변수
		SqlSession sqlSession = getSqlSession();
		
		int result = pDao.updatePurchaseCancel(sqlSession, orderNo);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		return result;
		
	}

	@Override
	/**
	 * 주문 상세 페이지에서 주문 페이지에 담긴 정보들을 조회
	 * @param memId : 로그인한 회원 아이디
	 * @param orderNo : 주문 번호 (해당 번호의 주문 상세페이지로 이동)
	 * @return : 해당 주문 번호에 속해있는 주문 페이지 정보가 담겨있는 OrderDetail객체
	 */
	public OrderDetail selectOrderDetail(String memId, int orderNo) {

		SqlSession sqlSession = getSqlSession();
		
		OrderDetail od = pDao.selectOrderDetail(sqlSession, memId, orderNo);
		
		sqlSession.close();
		
		return od;
	}

	@Override
	/**
	 * 주문 상세 페이지 조회
	 * @param memId : 로그인한 회원 아이디
	 * @param orderNo : 주문 번호 (해당 번호의 주문 상세페이지로 이동)
	 * @return : 해당 주문 번호에 속해있는 주문 상세 정보가 담겨있는 ArrayList<OrderDetail>객체
	 */
	public ArrayList<OrderDetail> selectOrderDetailList(String memId, int orderNo) {

		SqlSession sqlSession = getSqlSession();
		
		ArrayList<OrderDetail> list = pDao.selectOrderDetailList(sqlSession, memId, orderNo);
		
		sqlSession.close();
		
		return list;
	}

}
