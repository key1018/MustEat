<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.mz.mybatis.product.model.vo.Basket"%>
<%
	Basket bs = (Basket)request.getAttribute("bs");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/buttoncssNomal.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="icon" type="image/png" sizes="32x32" href="../../favicon-32x32.png?">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
   
    
    <style>
        .wrap1212{
            margin: auto;
            width: 80%;
            border: 2px solid rgb(223, 194, 241);
        }

        .basketdiv {
    width: 100%;
    border-top: 1px solid #e0e0e0;
    float: left;
    font-size: 0.9375em;
    margin-bottom: 20px;
}
    .basketdiv .row.head {
        border-bottom: 2px solid #888;
        box-sizing: border-box;
        background-color: #f4f4f4;
        font-weight: 500;
    }
    .basketdiv .data {
        border-bottom: 1px dashed #888;
        box-sizing: border-box;
        cursor: pointer;
        float: left;
        width: 100%;
    }
    .basketdiv .data .empty{
        text-align: center;
        padding: 12px 0;
    }
    .basketdiv .row.head .subdiv {
        background-color: #f4f4f4;
    }
    .basketdiv .row > .subdiv {
        display: block;
        float: left;
    }
    .basketdiv .row > .subdiv:nth-child(1) {
        width: 50%;
    }
    .basketdiv .row > .subdiv:nth-child(2) {
        width: 40%;
    }
    .basketdiv .row > .subdiv:nth-child(3) {
        width: 10%;
    }
    .basketdiv2 .row > .subdiv:nth-child(1) {
        width: 60%;
    }
    .basketdiv2 .row > .subdiv:nth-child(2) {
        width: 40%;
    }
    .basketdiv .row > div > div {
        display: block;
        float: left;
        text-align: center;
        margin: 0;
        padding: 12px 0;
    }
    .basketdiv .row.data > div > div {
        height: 60px;
        line-height: 60px;
    }
        .basketdiv .data .num .updown {
            color: #0075ff;
            font-size: 2em;
            letter-spacing: -5px;
        }
        .basketdiv .check {
            width: 10%;
        }
    .basketdiv .check input[type=checkbox] {
        transform: scale(1.5);
    }
    .basketdiv .img{
        width: 20%;
    }
    .basketdiv .pname{
        width: 70%;
    }
    .basketdiv2 .pname {
        width: 80%;
    }
    .basketdiv .basketprice {
        width: 33%;
    }
    .basketdiv .num {
        width: 33%;
      min-width: 105px;
    }
    .basketdiv .sum {
        width: 34%;
      max-width: 80px;
        color: #0000aa;
    }
    .basketdiv .point {
        width: 50%;
    }
    .basketdiv2 .basketprice {
        width: 25%;
    }

    .basketdiv2 .num {
        width: 25%;
    }

    .basketdiv2 .sum {
        width: 25%;
        color: #0000aa;
    }

    .basketdiv2 .point {
        width: 25%;
    }
    .basketdiv .basketcmd{
        width: 100%;
    }
    .basketdiv .data .pname {
        text-align: left !important;
      line-height: 1.2 !important;
    }
    .basketdiv .data .price, .basketdiv .data .sum, .basketdiv .data .point {
        text-align: right;
    }
    .baseform > tbody > tr > td:first-child {
        width: 100px;
    }

.buttongroup {
    padding: 11px 0;
    margin: 50px 0;
}
.narrowbuttongroup{
    margin: 15px 0;
}
    .buttongroup.center {
        text-align: center;
    }
    .buttongroup input[type=text], .buttongroup input[type=password] {
        height: 30px;
    }
    .buttongroup button, .buttongroup a {
        margin-right: 5px;
    }
        .buttongroup button:last-child, .buttongroup a:last-child {
            margin-right: 0;
        }

    .abutton, .abutton:link, .abutton:visited, .abutton:active, input[type=button] {
        background-color: #383838;
        border: 1px solid #888888;
        color: #ffffff;
        cursor: pointer;
        letter-spacing: -1px;
        padding: 3px 5px;
        margin: 2px 3px;
        width: auto;
        word-break: keep-all;
        border-radius: 5px;
        text-decoration: none;
        font-size: 0.9375em;
    }

.abutton-alt {
    background-color: #d3e2c6;
}

.red {
    color:#b00;
}
.blue {
  color: #0075ff;
}
.basketrowcmd, .sumcount, .summoney{
  text-align: right;
  margin-bottom: 10px;
}
.sumcount, .summoney{
  font-size: 1.25em;
    font-weight: bold;
}
.buttongroup{
  text-align: center;
}
.buttongroup a{
  text-decoration: none;
}
.cmd a, .cmd span {
    padding: 12px 30px;
    box-sizing: border-box;
    margin-top: 10px;
    font-size: 1.2em;
    color: #000;
    background-color: #f4f4f4;
    border: 1px solid #e0e0e0;
    text-align: center;
}
.cmd.small a, .cmd.small span {
    padding: 6px 20px;
    font-size: 0.8125em;
}

.orderform .p_num {
    text-align: right;
    width: 40px;
    font-size: 1em;
}

.outer{
    margin-top: 10%;
}

#sum_p_price{
    background-color:white;
    color: blueviolet;
    border: 1px  blueviolet;
    height: 33px;
    padding-top: 2%;
}

    </style>
</head>
<body>

    <%@ include file="../common/menubar.jsp"%>
    
        <div class="wrap1212">
        <form action="<%=contextPath%>/addressInsert.do" id="insertAddress">
            <div class="outer" align="center">
            
                <b>????????????</b><br>
                <table style="margin: top 10% ;">
                   
                    <tbody>
                        <tr>
                            <th>* ??????</th>
                            <td><input type="text" id="name" name="name" required></td>
                        </tr>
                         <tr>
                            <th>* ?????????</th>
                            <td><input type="text" id="phone" name="phone" placeholder="-??? ????????? ??????????????????." required></td>
                        </tr>
                        <tr>
                        <tr>
                            <th>* ?????????</th>
                            <td><input type="email" id="email" name="email" placeholder="example@must.eat" required></td>
                         </tr>
                            <th>* ??????</th>
                            <td>
                                <input type="text" name="addressCode" id="sample6_postcode" placeholder="????????????" required>
                                <input type="button" onclick="sample6_execDaumPostcode()" value="???????????? ??????"><br>
                                <input type="text" name="address" id="sample6_address" placeholder="??????" style="width:240px" required><br>
                                <input type="text" name="addressRef" id="sample6_extraAddress" placeholder="????????????" style="width:240px" required><br>
                                <input type="text" name="addressDetail" id="sample6_detailAddress" placeholder="????????????" style="width:240px" required><br>
                               	
                            </td>    
                        </tr>
                        <tr>
                            <th> ????????? ????????????</th>
                            <td><textarea name="memo" cols="30" rows="10" style="resize: none ;"></textarea></td>
                        
                    </tbody>
                </table>
                <input type="radio" id="delivery" name="deli" value="????????????">  ?????? ??????
                <input type="radio" id="delivery" name="deli" value="????????????">  ?????? ??????
            
           
           
            <br><br>
            <div style="background-color:rgb(231, 216, 241)">
               <div class="bigtext right-align box blue summoney"><%=bs.getProductName()%></div>
               <div class="bigtext right-align box blue summoney"><%=bs.getCount()%>???</div>
                
                <hr>
                <input type="hidden" name="tPrice" value="<%=bs.getPrice()%>">
                <input type="hidden" name="tCount" value="<%=bs.getCount()%>">
                <div class="bigtext right-align box blue summoney" style="color: black;">?????????: 2500???</div>
                <div class="bigtext right-align box blue summoney" style="color: black;">?????????: <input type="text" name="mile" id="mile" style="width:70px" value="0"></div>
                <div class="bigtext right-align box blue summoney" style="color: black;" id="totalPrice">????????? ??????: 
                   
                </div>
				
				
                
                <script>
                   let tPrice = $("input[name='tPrice']").val();
                   let tCount = $("input[name='tCount']").val();
                   let sum = tPrice*tCount;
                   let del = 2500;
                   
                   $("#totalPrice").text('????????? ??????: ' + sum + "???")

                   $(function(){
                    let mile = $(this).val();
                        let tSum = sum - mile+del;

                        $("#sum_p_price").text('???????????? ?????? : ' + tSum + "???")
                        $("#price").val(tSum)
                    $("#mile").keyup(function(){
                        let mile = $(this).val();
                        let tSum = sum - mile + del;

                        $("#sum_p_price").text('???????????? ?????? : ' + tSum + "???")
						$("#price").val(tSum)
                    })
                   })
                </script>
                
                
                <input type="hidden" name="price" id="price">
                
                <div class="bigtext right-align box blue summoney" id="sum_p_price" >???????????? ??????: ???</div>
                <input type="hidden" name="pName" id="pName" value="<%=bs.getProductName()%>">
                <input type="hidden" name="count" value="<%=bs.getCount()%>">
        
            
                
      
    
            </div>
        </div>
       </form>
       
            
                    
            
                    <div class="buttongroup center-align cmd">
                        <% if(loginUser == null){ // ???????????? ??????????????? ?????? %>
                            <button class="btn1" onclick="noPay();">????????????</button>
                        <% }else{ // ???????????? ???????????? ?????? %>
                            <button class="btn1" onclick="requestPay()">????????????</button>
                        <% } %>
                    </div>
            
                
   </div>
   <script>
        function noPay(){
            alert("?????????????????? ?????????.")
        }
   </script>
    
   <script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // ???????????? ???????????? ????????? ??????????????? ????????? ????????? ???????????? ??????.

                // ??? ????????? ?????? ????????? ?????? ????????? ????????????.
                // ???????????? ????????? ?????? ?????? ????????? ??????('')?????? ????????????, ?????? ???????????? ?????? ??????.
                var addr = ''; // ?????? ??????
                var extraAddr = ''; // ???????????? ??????

                //???????????? ????????? ?????? ????????? ?????? ?????? ?????? ?????? ????????????.
                if (data.userSelectedType === 'R') { // ???????????? ????????? ????????? ???????????? ??????
                    addr = data.roadAddress;
                } else { // ???????????? ?????? ????????? ???????????? ??????(J)
                    addr = data.jibunAddress;
                }

                // ???????????? ????????? ????????? ????????? ???????????? ??????????????? ????????????.
                if(data.userSelectedType === 'R'){
                    // ??????????????? ?????? ?????? ????????????. (???????????? ??????)
                    // ???????????? ?????? ????????? ????????? "???/???/???"??? ?????????.
                    if(data.bname !== '' && /[???|???|???]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // ???????????? ??????, ??????????????? ?????? ????????????.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // ????????? ??????????????? ?????? ??????, ???????????? ????????? ?????? ???????????? ?????????.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // ????????? ??????????????? ?????? ????????? ?????????.
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                // ??????????????? ?????? ????????? ?????? ????????? ?????????.
                document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("sample6_address").value = addr;
                // ????????? ???????????? ????????? ????????????.
                document.getElementById("sample6_detailAddress").focus();
            }
        }).open();
    }
</script>


 <!-- jQuery -->
  <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
  <!-- iamport.payment.js -->
  <script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<script>
    function requestPay() {
    	
    	console.log("???????????? ??????");
        
        var IMP = window.IMP; // ?????? ??????
       IMP.init("imp53614451"); // ???: imp00000000
      // IMP.request_pay(param, callback) ????????? ??????
      IMP.request_pay({ // param
          pg: "html5_inicis",
          pay_method: "card",
          merchant_uid: 'merchant_' + new Date().getTime(),
          name: $("#pName").val(),
          amount: $("#price").val(),
          buyer_email: $("#email").val(),
          buyer_name: $("#name").val(),
          buyer_tel: $("#phone").val(),
          buyer_addr: $("#sample6_address").val(),
          buyer_postcode: $("#sample6_postcode").val()
      }, function (rsp) { // callback
    	  console.log('function ???');
          if (rsp.success) {
              $("#insertAddress").submit();
          } else {
              alert("?????? ??????");
          }
      });
        
        
    }
    
  
    
  </script>


   

</body>
</html>