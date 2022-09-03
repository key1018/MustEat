package com.mz.mybatis.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mz.mybatis.member.model.service.MemberServiceImpl;
import com.mz.mybatis.member.model.vo.Member;
import com.mz.mybatis.member.model.vo.MyPage;
import com.mz.mybatis.member.model.vo.Point;
import com.mz.mybatis.member.model.vo.StoreScrap;
import com.mz.mybatis.product.model.service.ProductServiceImpl;
import com.mz.mybatis.product.model.vo.OrderPro;
import com.mz.mybatis.product.model.vo.ProductReview;
import com.mz.mybatis.store.model.service.StoreServiceImpl;
import com.mz.mybatis.store.model.vo.StoreReview;

/**
 * Servlet implementation class MyPageForm
 */
@WebServlet("/myPage.me")
public class MyPageForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 은영
		// 마이페이지 보여주는 요청처리하는 Servlet
		
		String memId = ((Member)request.getSession().getAttribute("loginUser")).getMemId(); // 회원 아이디 담는 변수
		
		// 마이페이지 리뷰, 적립금, 가고싶다, 팔로우 건수
		MyPage m = new MemberServiceImpl().selectMyPage(memId);
		
		// 상품 배송 현황에 따른 주문 갯수
		OrderPro op = new ProductServiceImpl().countOrder(memId);
		
		// 마이페이지에서 가게 리뷰 중 최신 2개 게시글 조회
		ArrayList<StoreReview> srList = new StoreServiceImpl().selectNewStoreReview(memId);
		// 마이페이지에서 밀키트 리뷰 중 최신 2개 게시글 조회
		ArrayList<ProductReview> proList = new ProductServiceImpl().selectNewProductReview(memId);
		// 마이페이지에서 적립금 내역 최신 2개 조회
		ArrayList<Point> mpsList = new MemberServiceImpl().selectNewPoint(memId);
		// 마이페이지에서 주문상세 내역 최신 2개 조회
		ArrayList<OrderPro> opList = new ProductServiceImpl().selectNewOrder(memId);
		// 마이페이지 가고싶다 내역 최신 2개 조회
		ArrayList<StoreScrap> ssList = new MemberServiceImpl().selectNewScrap(memId);
				
		request.setAttribute("myPage", m);
		request.setAttribute("storeReview", srList);
		request.setAttribute("productReview", proList);
		request.setAttribute("mpsPoint", mpsList);
		request.setAttribute("orderList", opList);
		request.setAttribute("scrapList", ssList);
		request.setAttribute("orderStatus", op);

		
		request.getRequestDispatcher("WEB-INF/views/key/myPage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
