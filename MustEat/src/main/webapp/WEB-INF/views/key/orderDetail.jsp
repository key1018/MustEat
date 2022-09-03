<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.mz.mybatis.product.model.vo.OrderDetail, java.text.DecimalFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	OrderDetail od = (OrderDetail)request.getAttribute("detail");
	ArrayList<OrderDetail> list = (ArrayList<OrderDetail>)request.getAttribute("list");
	
 	DecimalFormat df = new DecimalFormat("#,##0"); // 가격 천단위로 보여지도록 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MustEat 주문상세페이지</title>
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/myPage.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/orderDetail.css" />
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/buttoncssNomal.css">
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.servletContext.contextPath}/favicon-32x32.png">
</head>
<body>
	
	<jsp:include page="../common/menubar.jsp" />
	
	<!-- 주문된 상품의 상세페이지 -->
	
      <div class="orderDetail-area" style="font-family: 'OTWelcomeRA' !important;">
        
      <h3 class="detailTitle">주문 상세정보</h3>

		
        <ul class="order_detail">
          <li>
            <div>주문일자</div>
            <div class="orderDate"><strong>${detail.orderDate }</strong></div>
          </li>

          <li>
            <div>주문번호</div>
             <div class="orderNo"><strong>${detail.orderNo }</strong>
             </div>
          </li>
        </ul>
        
        
        <table class="orderTb" width="100%">

        <thead>
          <tr>

            <th width="100"><strong>상품주문번호</strong></th>
            <th width="300">상품정보</th>
            <th width="100">상품금액(수량)</th>
            <th width="100" class="send">배송비/판매자</th>
            <th width="100" class="orderStatus">진행상태</th>

          </tr>
        </thead>

        <tbody>

       <c:forEach var="odl" items="${list }">
          <tr class="group">

            <td>
              <span class="thm ordernum2">${odl.orderNo }</span>
            </td>
            <td class="product">
          <div id="productName" align="left"> 
            ${odl.productName }
          </div>
          </td>
          
            <td class="money">
              <em class="thm">${odl.price }</em>원<br>
                <span>(${odl.amount }개)</span>
            </td>
            <td class="sellerInfo" rowspan="1">
              <div class="send">
                  <div class="deliveryPrice">${odl.deliveryPrice }원</div> 
                  <div class="seller">${odl.seller }</div>
                  <div class="tel">
                    <span>${odl.sellerPhone }</span>
                  </div>
              </div>
            </td>

            <td class="orderStatus">
             ${odl.deliveryStatus }
            </td>

          </tr>
          </c:forEach>
          
        </tbody>

        </table>

        <h4 class="title">주문/결제 금액 정보</h4>
        
          <table class="orderPrice" width="100%">
        
          <tr class="money">
            <td class="first_money" colspan="6">
                <div class="price_list">
                  <dl class="first">
                    <dt><strong>최초 주문금액</strong></dt>
                    <dd>
                      <!-- 주문금액 -->
                      <ul class="price_list">
                        <li>
                          <span>상품금액</span>
                          <p class="thm"><em>${detail.price }</em>원</p>
                        </li>
                        <li>
                          <span>배송비</span>
                          <p class="thm"><em>${detail.deliveryPrice }</em>원</p>
                        </li>
                        <li>
                          <span>적립금사용</span>
                          <p class="thm"><em>${detail.discountPrice }</em>원</p>
                        </li>
                      </ul>
                    </dd>
                  </dl>
              </div>
              <br>
            </td>

            <td class="last_money" colspan="6" style="vertical-align:top;">
                <div class="total_price">
                  <dl class="total">
                    <dt><strong>최종 주문금액</strong></dt>
                  </dl>
                    <!-- 주문금액 -->
                    <div class="total_price">
                        <p><em>${detail.totalPrice }</em>원</p>
                   </div>
                </div>
            </td>
          </tr>

          </table>

        <h4 class="title">배송지 정보</h4>
        <table class="orderPlace" width="100%">

            <tr>
              <th width="15%" height="50px;" class="deliveryTh">수령인</th>
              <td width="55%" height="50px;">${detail.delName }</td>
              <th class="deliveryInfo" width="30%"  height="50px;">주문자 정보
                <button type="button" class="btn1" onclick="updateMem();">회원정보수정</button>
              </th>
            </tr>
            
            <script>
            	
            	function updateMem() {
            		location.href="updateForm.me";
            	}
            
            </script>

            <tr>
              <th height="30px;" class="deliveryTh">연락처</th>
              <td>
                <span class="tel">${detail.delPhone }</span>
                <span></span>
              </td>
              <!-- 주문자 정보 -->
              <td class="deliveryInfo" rowspan="3">
                <div class="orderName">${detail.memName }</div>
                <div class="orderPhone">${detail.memPhone }</div>
              </td> 
            </tr>

            <tr>
              <th height="70px;" class="deliveryTh">배송지</th>
              <td class="address">
                ${detail.addressCode }<br> <!--우편번호-->
                ${detail.address }<br> <!-- 주소 -->
                ${detail.addressDetail } ${detail.addressRef } <!-- 상세주소 -->
              </td>
            </tr>
            
            <tr class="gap3">
              <th height="30px;" class="deliveryTh">배송메모</th>
              <c:choose>
	              <c:when test="${detail.memo == null }">
	              	<td> </td>
	              </c:when>
	              <c:otherwise>
	              	<td>${detail.memo }</td>
	              </c:otherwise>
              </c:choose>
            </tr>
        
        </table>	
        
         <br><br>
         
      </div>

       
       
  </body>
</html>