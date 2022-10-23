<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.mz.mybatis.product.model.vo.OrderPro, java.util.ArrayList, java.text.DecimalFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MustEat 주문현황</title>
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/orderList.css">
<link rel="stylesheet"
	href="${pageContext.servletContext.contextPath}/resources/css/buttoncssNomal.css">
<link rel="icon" type="image/png" sizes="32x32"
	href="${pageContext.servletContext.contextPath}/favicon-32x32.png">
<style>
.paySection {
	display: none;
}

.viewMore {
	display: block;
	width: 100%;
	padding: 18px 0;
	color: #000;
	font-size: 13px;
	border: none 0;
	text-align: center;
}
</style>
</head>
<body>

	<!-- 배송준비중에 해당 카테고리에 속하는 목록들만 보여지는 페이지 -->

	<jsp:include page="../common/menubar.jsp" />

	<!-- 나의 주문/배송현황 메뉴바 -->
	<div class="orderDetail-area"
		style="font-family: 'OTWelcomeRA' !important;">

		<div class="shippingStatusContainer">

			<div class="title">나의 주문/배송 현황</div>

			<div class="status">
				<div class="item">
					<div>
						<div class="number orderStatus" onclick="orderStatus('basket');">${orderStatus.basket }</div>
						<div class="text">장바구니</div>
					</div>
				</div>

				<div class="item">
					<div>
						<div class="number orderStatus" onclick="orderStatus('preparing');">${orderStatus.orderReady }</div>
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
						<div class="number orderStatus" onclick="orderStatus('delivered');">${orderStatus.orderDelivered }</div>
						<div class="text">배송완료</div>
					</div>
				</div>

				<div class="item">
					<div>
						<div class="number orderStatus" onclick="orderStatus('cancel');">${orderStatus.orderCancel }</div>
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

		<!-- 주문현황 리스트 -->
		<!-- 바깥쪽 for문 -->
		<c:forEach var="om" items="${orderMonth }">
			<div class="orderDetailArea"
				style="font-family: 'OTWelcomeRA' !important;">

				<div class="paySection orderMonth">
					<h4>${om.orderMonth }</h4>
				</div>

				<!-- 안쪽 for문 -->
				<c:forEach var="ol" items="${orderList }">
					<c:if test="${om.orderMonth == ol.orderMonth }">
						<div class="paySection">
							<div class="goodsGroup">
								<ul class="goodsList">
									<li class="goodsPayItem">
										<div class="goodsItem">
											<div class="goodsInfo">
												<table class="goodsList">
													<tr>
														<td>
															<a href="detail.pro?orderNo=${ol.orderNo }" class="goods"> 
															<span class="goodsName">${ol.productName }</span>
															</a>
														</td>
													</tr>
													<tr>
														<td class="goodsPrice">
															<fmt:formatNumber value="${ol.totalPrice }" pattern="#,###" />
															<span class="goodsAmount">/ ${ol.orderQuentity }개</span> 
															<span class="orderDate">${ol.orderDate }</span>
														</td>
													</tr>
													<tr>
														<td>
															<c:choose>
																<c:when test="${ol.orderStatus != 1 }">
																	<span class="goodsStatus">${ol.deliveryStatus }</span>
																</c:when>
																<c:otherwise>
																	<span class="goodsStatus">구매확정</span>
																</c:otherwise>
															</c:choose>
														</td>
													</tr>
												</table>
											</div>
										</div>

										<div class="sellerInfo">
											<div class="inner">
												<span class="orderNo" style="font-weight: bold;"> 주문번호<br> [${ol.orderNo }]</span> 
												<span class="seller">${ol.seller }</span> 
												<span class="tel">${ol.sellerPhone }</span>
											</div>
										</div>

										<div class="orderButton">
											<c:if test="${ol.orderStatus != 1 }">
												<a class="plain-btn btn" id="orderConfirm"
													onclick="return purchaseConfirm(${ol.orderNo }, '${ol.deliveryStatus }');">구매확정</a>
											</c:if>

											<c:if test="${ol.orderStatus != 1 }">
												<!-- 상품준비중일때만 구매취소 가능 -->
												<a class="plain-btn btn" id="orderCancel"
													onclick="return purchaseCancel(${ol.orderNo }, '${ol.deliveryStatus }');">구매취소</a>
											</c:if>

											<c:if test="${ol.orderStatus == 1 }">
												<!-- 구매확정시 보이도록 설정 -->
												<a href="detail.li?no=${ol.productCode}"
													class="plain-btn btn">리뷰작성</a>
											</c:if>
										</div> 
									</li>
								</ul>
							</div>
						</div>
						
						<script>
					          	
					           // 구매확정/취소 버튼 누르면 실행되는 함수
					          	function purchaseConfirm(orderNo, status){
					          		if(confirm("구매 확정하시겠습니까?\n확정 후 취소 불가능합니다.")) {
					          			location.href="purchaseConfirm.pro?status=" + status  + "&orderNo=" + orderNo;
					          		} else {
					          			return false;
					          		}
					           }
					           
					           function purchaseCancel(orderNo, status) {
					          		if(confirm("구매 취소하시겠습니까?\n취소 후 재구매가능합니다.")) {
					          			location.href="purchaseCancel.pro?status=" + status  + "&orderNo=" + orderNo;
					          		} else {
					          			return false;
					          		}
					           }
				          
				        </script>
	          
					</c:if>
				</c:forEach>
				<!-- 안쪽 for문 끝-->
			</div>
		</c:forEach>
		<!-- 바깥쪽 for문 끝-->

		<!-- 상품 '더보기' 영역!!! -->
		<c:if test="${fn:length(orderList) >= 5 }">
			<div class="viewMore">
				<a href='#' id='load' class='btn1'>더 보기</a>
			</div>
		</c:if>

		<script>

			<!-- 상품 5개 이상이면 보이도록 설정 => 더보기로 상품 목록 펼치기 -->
			$(function(){
				
				    $(".paySection").slice(0, 5).show(); // 처음에 상품목록 5개씩 보이기
				    $("#load").click(function(e){ // '더보기' 버튼 클릭시 함수 실행
					        e.preventDefault();
					        $(".paySection:hidden").slice(0, 5).show(); // 상품 목록 5개씩 보이기
					        if($(".paySection:hidden").length == 0){ // 상품 목록 리스트 전부 조회하면 사라짐
					           $("#load").fadeOut();
					        }
					    });
				
			});
		
   		</script>
	</div>

</body>
</html>