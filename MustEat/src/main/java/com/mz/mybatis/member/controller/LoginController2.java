package com.mz.mybatis.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mz.mybatis.member.model.service.MemberServiceImpl_origin;
import com.mz.mybatis.member.model.vo.Member;

/**
 * Servlet implementation class LoginController2
 */
@WebServlet("/login2.me")
public class LoginController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//태민
		// 실제 로그인하는 컨트롤러
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		Member loginUser = new MemberServiceImpl_origin().loginMember(userId, userPwd);
		
		HttpSession session = request.getSession();
		
		if(loginUser == null) { // 로그인실패   
			
			RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/ltm/memberLogin.jsp");
			
			request.setAttribute("errorMsg", "아이디 또는 비밀번호를 잘못 입력했습니다. \n입력하신 내용을 다시 확인해주세요.");
			
			view.forward(request, response);
			
		}else { // 로그인성공  ==> ?
			
			if(loginUser.getMemStatus().equals("Y")) {
				
				session.setAttribute("loginUser", loginUser);
				response.sendRedirect(request.getContextPath()); 
				
			}else {
				
				session.setAttribute("loginUser", loginUser);
				RequestDispatcher view = request.getRequestDispatcher("WEB-INF/views/common/adminMenubar.jsp");
				view.forward(request, response);
				
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
