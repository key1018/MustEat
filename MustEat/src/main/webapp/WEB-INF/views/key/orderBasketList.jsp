<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mz.mybatis.product.model.vo.*, java.util.ArrayList, java.text.DecimalFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MustEat 주문현황</title>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/orderList.css">
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/buttoncssNomal.css">
<link rel="icon" type="image/png" sizes="32x32" href="${pageContext.servletContext.contextPath}/favicon-32x32.png">
<style>
	.paySection {
		display:none;
	}
	.viewMore{
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

	<!-- 장바구니 해당 카테고리에 속하는 목록들만 보여지는 페이지 -->

	<jsp:include page="../common/menubar.jsp" />
	
		<!-- 나의 주문/배송현황 메뉴바 -->
	<div class="orderDetail-area">

	  <div class="shippingStatusContainer">
	
	    <div class="title">
	      나의 주문/배송 현황
	    </div>
	
	    <div class="status">
	      <div class="item">
	        <div>
	          <div class="number orderStatus" onclick="orderStatus('basket');">${orderStatus.basket }</div>
	          <div class="text">장바구니</div>
	        </div>
	      </div>     
	
	      <div class="item">
	        <div> <!-- href 예시 : $lt;%=request.getContextPath() %>/orderList.or?status=$lt;% list.getStatus().equals("배송준비중"); %> -->
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
	
	<!-- 주문현황 리스트 -->
	  <!-- 바깥쪽 for문 -->
	  <c:forEach var="b" items="${basketMonth }">
	    <div class="orderDetailArea">
	
	    <div class="paySection orderMonth">
	      <h4>${b.month }</h4>
	    </div>
	
	    <!-- 안쪽 for문 -->
	    <c:forEach var="bk" items="${basketList }">
		 	
		 	<c:if test="${bk.month == b.month }">
	    <div class="paySection">
	
	      <div class="goodsGroup">
	
	        <ul class="goodsList">
	
	          <li class="goodsPayItem">
	          
			  <div class="checkGoods">
				<input type="checkbox" class="check" name="check" value="${bk.basketNo }">
	          </div>
	          
	            <div class="goodsItem">
		    	
	
	            <div class="goodsInfo" onclick="orderDetail();">
	              <a href="해당 상품 주문상세페이지" class="goods">
	                <p class="goodsName">${bk.productName }</p>
	                <ul class="info">
	                  <li class="goodsPrice">${bk.price }원
	                    <span class="goodsAmount">/ ${bk.count }개</span>
	                  </li>
	                  <li class="goodsDate" style="font-weight:bold;">${bk.basketDate }</li>
	                </ul>
	              </a>
	              <span class="goodsStatus">구매 전</span>
	            </div>
	          </div>
	
	          <div class="sellerInfo">
	
	            <div class="inner">
	            <span class="orderNo" style="font-weight:bold;">
	                상품번호<br>
	                [${bk.productCode }]
	              </span>
	              <span class="seller">${bk.seller }</span>
	              <span class="tel">${bk.sellerPhone }</span>
	            </div>
	          </div>
	
	          <div class="orderButton">
                <form action="cartdirect.do">
                   <input type="hidden" value="${bk.basketNo }" name="basNo">
                  <button type="submit" class="plain-btn btn" id="buy" style="font-size:12px; width:100px; margin: 10px 0px;">구매하기</button>
                  <button type="button" class="plain-btn btn" id="updateBasket" data-toggle="modal" data-target="#updateModal" style="display:none;">주문수정</button>
                  <a class="plain-btn btn" onclick="return deleteCart(${bk.basketNo});" style="font-size:12px; width:100px;">상품삭제</a>
               </form>
             </div>
	      

		 <script>
  
			// '장바구니, 상품준비중, 배송중, 배송완료, 상품취소' 클릭하면 실행하는 함수
			   function orderStatus(status) { // 실행시 전달되는 값을 담는 매개변수
				location.href="orderStatusList.pro?status=" + status;
			}
			
			function deleteCart(basketNo) {
				if(confirm("상품을 삭제하시겠습니까?")) {
					
					$.ajax({
						url : "deleteBasket.pro",
						data : { no:basketNo },
						success : function(result) {
							
							if(result == 1) {
								location.reload(); // 기존페이지에서 그대로 삭제처리됨
							} else {
								alert("상품을 삭제하는데 실패했습니다. 다시 시도해주세요.");
							}
							console.log("ajax 통신 성공");
							
						},
						error : function(result) {
							console.log("ajax 통신 실패");
						}
					});
					
				} else {
					return false;
				}
			}
			
		
		</script>
	          
	
	          </li>
	
	        </ul>
	
	      </div>
	
	    </div>
	    	</c:if>
	   	</c:forEach>
	    <!-- 안쪽 for문 끝-->
	
	  </div>
	  </c:forEach>
	  <!-- 바깥쪽 for문 끝-->
	  
	  <div class="line" style="border-bottom: 2px solid #ebe9e9;"></div>
 	  
 	  <div class="chooseAll">
	  	<button type="button" id="buy" class="choose btn1" onclick="chkClick();">전체 선택</button>
	  	<input type="checkbox" id="checkAll" name="checkAll" onclick="chooseAll(this);" style="display:none;">
	  	<button type="button" id="chooseBuy" class="chooseBuy btn1" onclick="chooseBuy();">선택한 상품 구매하기</button>
	  	<button type="button" id="delete" class="choose btn1" onclick="return chooseDelete();">선택 삭제</button>
	  </div>
	  
	  <%-- 
	  <!-- 상품 '더보기' 영역!!! -->
	  <% if ( bList.size() >= 10) { %> <!-- 상품 10개 이하면 안보이도록 설정 -->
	  <div class="viewMore">
	  	<a href='#' id='load' class='btn1'>더 보기</a>
	  </div>
 	  <% }  %>
 	  
 	 <c:if test="${basketList.size() >= 5 }">
	 	  <div class="viewMore">
		  	<a href='#' id='load' class='btn1'>더 보기</a>
		  </div>
	 </c:if>
	 --%>
	 	<!-- 상품 '더보기' 영역!!! -->
		<c:if test="${fn:length(basketList ) >= 8}">
	 	  <div class="viewMore">
		  	<a href='#' id='load' class='btn1'>더 보기</a>
		  </div>
		 </c:if>

	 
 	<script>

	// '전체 선택'누를 때 발생하는 함수
	function chkClick() {
		$("#checkAll").click();  // <input type="checkbox" id="checkAll" 요소 클릭
	}

	
	// '전체 선택' 클릭 후 체크박스가 클릭되어질 때 실행하는 함수
	function chooseAll(checkAll) {
		
		if( $("#checkAll").checked ) {
			$(this).attr("checked", false);
		} else {
			$(this).attr("checked", true);
		}
		
		let checkInput = document.getElementsByName("check");
		
		checkInput.forEach( (checkbox) => {
			checkbox.checked = checkAll.checked;
		})
	}
	

	// '선택 삭제' 버튼 클릭시 발생하는 함수
	function chooseDelete(){
		
		if(confirm("선택한 상품을 삭제하시겠습니까?")) {
			
			let checkArr = [];
			
		$(".check").each(function() {
				if($(this).prop("checked")) {
					checkArr.push( $(this).val() );
				}
			});
		
		const basketNo = checkArr.toString();
		console.log(basketNo);
			
		$.ajax({
			url : "deleteBasket.pro",
			data : { no:basketNo },
			success : function(result) {
					location.reload();
			},
			error : function() {
				console.log("ajax 통신 실패");
			}
		});
			
		} else {
			return false;
		}
		
	};

		$(function(){
			
			<!-- 상품 10개 이상이면 보이도록 설정 => 더보기로 상품 목록 펼치기 -->
			    $(".paySection").slice(0, 10).show(); // 처음에 상품목록 10개씩 보이기
			    $("#load").click(function(e){ // '더보기' 버튼 클릭시 함수 실행
				        e.preventDefault();
				        $(".paySection:hidden").slice(0, 8).show(); // 상품 목록 8개씩 보이기
				        if($(".paySection:hidden").length == 0){ // 상품 목록 리스트 전부 조회하면 사라짐
				           $("#load").fadeOut();
				        }
				    });
			
			});
		
   </script>	
   

</body>
</html>

</body>
</html>