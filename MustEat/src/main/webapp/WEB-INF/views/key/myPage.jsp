<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="com.mz.mybatis.member.model.vo.* , java.util.ArrayList
		  , com.mz.mybatis.store.model.vo.StoreReview, com.mz.mybatis.product.model.vo.*
		  , java.text.DecimalFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MustEat MyPage</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath}/resources/css/myPage.css" />
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/buttoncssNomal.css">
<link rel="icon" type="image/png" sizes="32x32"
	href="${pageContext.servletContext.contextPath}/favicon-32x32.png">
</head>
<body>


	<jsp:include page="../common/menubar.jsp" />

	<div class="myPage-area">

		<div class="purpleContainer">
			<div class="myPage-user">

				<c:choose>
					<c:when test="${empty loginUser.memImgPath }">
						<img id="noneIcon" src="${pageContext.servletContext.contextPath}/resources/image/user.png">
					</c:when>
					<c:when test="${loginUser.memImgPath == '/MustEat/resources/image/user.png' }">
						<!-- 기본 이미지로 변경시 -->
						<img id="noneIcon" src="${pageContext.servletContext.contextPath}/resources/image/user.png">
					</c:when>
					<c:otherwise>
						<!-- 프로필을 변경할 때 (기본이미지가 아닐 떄) -->
						<img src="${loginUser.memImgPath }" id="userIcon">
					</c:otherwise>
				</c:choose>

				<div class="userInfo">
					<div class="name">
						${loginUser.memName }님 반갑습니다!
						<button type="button" class="btn1" onclick="myPageOpen();">내정보</button>
					</div>
					<div class="grade">
						<strong>등급 : ${loginUser.memGrade } 리뷰어</strong>
					</div>
				</div>
			</div>

		  <script>
	      	
	      	function myPageOpen() {
	      		location.href = "updateForm.me";
	      	}
	      
	      </script>

		</div>

		<div class="summaryContainer">
			<div class="item">
				<div class="number">${myPage.storeReview }건</div>
				<div class="summary">식당 리뷰</div>
			</div>
			<div class="item">
				<div class="number">${myPage.productReview }건</div>
				<div class="summary">밀키트 리뷰</div>
			</div>
			<div class="item">
				<div class="number">${myPage.mpsPoint }</div>
				<div class="summary">적립금</div>
			</div>
			<div class="item">
				<div class="number">${myPage.storeScrap }곳</div>
				<div class="summary">가고싶다</div>
			</div>

			<!-- 채윤 팔로우 조회 연결 -->
			<div class="item" OnClick="location.href ='myfollow.me'" style="cursor: pointer;">
				<div class="number">${myPage.follow }명</div>
				<div class="summary">팔로우</div>
			</div>

		</div>
		<div class="shippingStatusContainer">
			<div class="title">나의 주문/배송 현황</div>
			<div class="status">

				<div class="item">
					<div>
						<div class="number basket" onclick="orderStatus('basket');">${orderStatus.basket }</div>
						<div class="text">장바구니</div>
					</div>
				</div>

				<div class="item">
					<div>
						<div class="number orderStatus"
							onclick="orderStatus('preparing');">${orderStatus.orderReady }</div>
						<div class="text">상품준비중</div>
					</div>
				</div>

				<div class="item">
					<div>
						<div class="number orderStatus" onclick="orderStatus('transit');">${orderStatus.orderTransit }</div>
						<div class="text">배송중</div>
					</div>
				</div>

				<div class="item">
					<div>
						<div class="number orderStatus"
							onclick="orderStatus('delivered');">${orderStatus.orderDelivered }</div>
						<div class="text">배송완료</div>
					</div>
				</div>

				<div class="item">
					<div>
						<div class="number orderCancel" onclick="orderStatus('cancel');">${orderStatus.orderCancel }</div>
						<div class="text">상품취소</div>
					</div>
				</div>

			</div>
		</div>

		<script>
  
		  // '장바구니, 상품준비중, 배송중, 배송완료, 상품취소' 클릭하면 실행하는 함수
		 	function orderStatus(status) { // 실행시 전달되는 값을 담는 매개변수
			  location.href="orderStatusList.pro?status=" + status;
		  }
  
  		</script>

		<div class="listContainer">

			<div class="myPageList">

				<a href="reviewlist.me" class="listTitle">식당 리뷰</a> 
				<a href="reviewlist.me" class="listMore">더보기 ></a>

				<table class="list" style="width:100%;">
					<thead>
						<tr>
							<th class="categoryTh" style="width: 500px">제목</th>
							<th class="categoryTh" style="width: 200px">식당명</th>
							<th class="categoryTh" style="width: 150px">좋아요수</th>
							<th class="categoryTh" style="width: 200px">작성일자</th>
						</tr>
					</thead>

					<tbody>
						<!-- 반복문 처리!!! -->
						<c:forEach var="sr" items="${storeReview }">
							<tr>
								<td class="categoryTd categoryTitle">${sr.reviewTitle }</td>
								<td class="categoryTd categoryTitle">${sr.storeName }</td>
								<td class="categoryTd categoryContent">${sr.scrapCount }</td>
								<td class="categoryTd categoryContent">${sr.reviewEnrollDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div class="myPageList">

				<a href="" class="listTitle">밀키트 리뷰</a> <a href="" class="listMore">더보기 ></a>

				<table class="list" style="width:100%;">
					<thead>
						<tr>
							<th class="categoryTh" style="width: 600px">상품명</th>
							<th class="categoryTh" style="width: 150px">좋아요수</th>
							<th class="categoryTh" style="width: 200px">작성일자</th>
						</tr>
					</thead>

					<tbody>
						<!-- 반복문 처리!!! -->
						<c:forEach var="pr" items="${productReview }">
							<tr>
								<td class="categoryTd categoryTitle">${pr.productName }</td>
								<td class="categoryTd categoryContent">${pr.scrapCount }</td>
								<td class="categoryTd categoryContent">${pr.prReviewEnrollDate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div class="myPageList">

				<a href="mpsuserlist.me" class="listTitle">적립금</a> 
				<a href="mpsuserlist.me" class="listMore">더보기 ></a>

				<table class="list" style="width:100%;">
					<thead>
						<tr>
							<th class="categoryTh" style="width: 300px">상세내용</th>
							<th class="categoryTh" style="width: 210px">적립 및 사용 금액</th>
							<th class="categoryTh" style="width: 220px">일자</th>
							<th class="categoryTh" style="width: 210px">구분</th>
						</tr>
					</thead>

					<tbody>
						<!-- 반복문 처리!!! -->
						<c:forEach var="p" items="${mpsPoint }">
							<tr>
								<td class="categoryTd categoryTitle">${p.mpsCategory }</td>
								<td class="categoryTd categoryContent">${p.mpsRecord }원</td>
								<td class="categoryTd categoryContent">${p.suDate }</td>
								<td class="categoryTd categoryContent">${p.mpsStatus }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div class="myPageList">

				<a href="orderList.pro" class="listTitle">주문상세</a> 
				<a href="orderList.pro" class="listMore">더보기 ></a>

				<table class="list" style="width:100%;">
					<thead>
						<tr>
							<th class="categoryTh" style="width: 470px">상품명</th>
							<th class="categoryTh" style="width: 160px">결제금액</th>
							<th class="categoryTh" style="width: 160px">구매일자</th>
							<th class="categoryTh" style="width: 160px">진행상태</th>
						</tr>
					</thead>

					<tbody>
						<!-- 반복문 처리!!! -->
						<c:forEach var="opl" items="${orderList }">
							<tr>
								<td class="categoryTd categoryTitle">${opl.productName }</td>
								<td class="categoryTd categoryContent">${opl.totalPrice }원</td>
								<td class="categoryTd categoryContent">${opl.orderDate }</td>
								<td class="categoryTd categoryContent">${opl.deliveryStatus }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

			<div class="myPageList">

				<a href="list.ss" class="listTitle">가고싶다</a> 
				<a href="list.ss" class="listMore">더보기 ></a>

				<table class="list" style="width:100%;">
					<thead>
						<tr>
							<th class="categoryTh" style="width: 300px">음식점</th>
							<th class="categoryTh" style="width: 500px">주소</th>
							<th class="categoryTh" style="width: 150px">평점</th>
						</tr>
					</thead>

					<tbody>
						<!-- 반복문 처리!!! -->
						<c:forEach var="ss" items="${scrapList }">
							<tr>
								<td class="categoryTd categoryTitle">${ss.storeName }</td>
								<td class="categoryTd categoryContent">${ss.storeAddress }</td>
								<td class="categoryTd categoryContent">${ss.reviewRate }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>

		</div>

	</div>
</body>
</html>