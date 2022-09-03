<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Must Eat</title>
<!-- jQuery Script -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<!-- Maphighlight Script -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/maphilight/1.4.0/jquery.maphilight.min.js"></script>
		<!-- favicon -->
<link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath()%>/favicon-32x32.png">
	<link rel="icon" type="image/png" sizes="32x32" href="<%=request.getContextPath()%>/favicon-32x32.png">
    


</head>
<style>
	.map-area{
        background-image: url("<%=request.getContextPath()%>/resources/image/cy/bg9.jpg");
 	}
</style>
<body>

	<div class="map-area" align="center">
	
		<div>
			<h2>Welcome To MUST</h2>
		</div>

<!-- Image Map Generated by http://www.image-map.net/ -->
<img src="<%=request.getContextPath() %>/resources/image/수도권.png" usemap="#image-map" class="metropolitan-area" >

<map name="image-map" id="metropolitan" class="metropolitan-area">

    <area  alt="안성시 맛집" title="안성시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=안성시" coords="678,929,692,915,691,896,678,891,672,882,680,874,674,859,683,852,695,850,712,862,721,859,727,846,742,835,748,824,756,824,768,838,797,837,807,847,826,853,836,853,838,829,845,817,853,821,865,838,880,838,892,858,876,878,862,885,853,908,839,915,833,938,815,946,783,949,777,964,757,979,736,975,722,958,698,932,691,930" shape="poly">
    <area  alt="용산시 맛집" title="용산시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=용산시" coords="672,846,674,852,683,846,704,846,715,858,725,844,739,829,745,820,760,818,769,834,797,832,812,845,822,850,833,845,833,826,842,812,829,808,816,791,801,785,788,770,788,752,782,744,774,749,760,749,760,738,754,729,756,714,760,703,754,697,741,697,738,706,722,709,718,702,710,697,700,706,683,706,662,709,656,718,662,727,660,741,650,752,651,762,665,770,689,779,698,793,697,808,694,818,684,829,671,837,674,852,672,846" shape="poly">
    <area  alt="이천시 맛집" title="이천시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=이천시" coords="806,782,818,785,835,803,860,814,874,835,885,834,882,806,885,786,901,779,909,765,903,753,900,741,909,730,909,721,895,712,888,700,859,683,835,697,816,718,806,741,797,747,797,767" shape="poly">
    <area  alt="여주군 맛집" title="여주군 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=여주군" coords="838,661,836,645,848,638,860,644,867,650,879,653,894,644,906,645,914,655,939,655,954,667,988,659,1002,667,1005,680,1033,692,1033,765,1014,805,991,824,965,826,962,849,954,862,916,884,886,885,900,867,901,859,891,835,886,808,889,791,906,782,915,765,909,756,907,743,917,733,915,721,898,711,892,697,860,679" shape="poly">
    <area  alt="양평군 맛집" title="양평군 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=양평군" coords="788,576,782,562,795,541,812,529,826,507,824,483,844,488,857,510,870,518,867,542,880,559,906,551,924,551,935,533,930,513,933,500,961,498,997,529,1033,529,1045,539,1065,539,1079,556,1076,577,1050,586,1047,598,1061,620,1065,635,1055,668,1038,685,1011,674,1009,665,989,655,956,662,939,651,917,651,909,639,895,638,882,648,870,647,863,639,848,632,835,639,827,630,836,615,821,583,806,573" shape="poly">
    <area  alt="가평군 맛집" title="가평군 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=가평군" coords="885,554,872,543,874,512,862,507,851,486,826,479,803,459,792,432,780,432,766,421,774,407,765,391,769,380,783,378,789,368,788,345,795,339,807,341,824,327,819,310,827,301,845,297,862,268,879,279,904,280,914,297,912,309,927,312,947,325,945,359,933,371,903,378,897,404,920,445,920,485,929,497,926,512,931,533,921,547,905,547" shape="poly">
    <area  alt="포천시 맛집" title="포천시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=포천시" coords="783,345,785,363,779,374,769,375,761,388,769,407,760,421,750,418,741,430,732,433,725,427,710,425,701,432,688,433,678,421,689,404,678,383,695,374,701,362,715,353,712,336,690,329,672,306,688,295,694,275,686,256,691,251,710,254,721,233,715,221,727,187,745,189,757,171,774,181,772,199,783,215,827,210,860,224,865,245,859,263,845,292,825,298,813,307,819,322,807,336,795,336" shape="poly">
    <area  alt="연천군 맛집" title="연천군 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=연천시" coords="626,315,618,324,595,321,597,312,612,301,611,286,594,283,586,294,574,298,568,289,557,287,555,294,548,305,531,293,516,304,502,296,499,278,520,259,530,259,542,250,539,219,580,191,584,154,652,100,670,99,680,109,673,118,676,129,697,124,705,133,705,153,723,167,723,182,712,218,717,229,705,248,690,244,682,255,690,275,686,288,670,303,664,293,650,291,635,294,630,304" shape="poly">
    <area  alt="파주시 맛집" title="파주시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=안성시" coords="593,309,604,303,609,294,593,289,584,300,571,307,565,295,556,295,556,307,548,310,531,300,518,307,516,331,499,339,486,325,487,307,477,297,463,310,434,313,418,327,425,341,451,347,465,365,455,374,433,365,422,375,424,410,434,425,436,442,442,450,437,468,468,463,481,468,495,466,501,456,524,453,536,459,553,453,553,444,565,438,563,422,556,412,554,397,577,368,577,345,587,325" shape="poly">
    <area  alt="김포시 맛집" title="김포시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=김포시" coords="416,410,430,424,428,441,434,453,431,468,422,485,436,500,460,504,474,523,496,532,501,544,481,547,445,542,425,515,405,518,390,536,367,542,351,526,339,523,323,492,333,465,336,439,346,425,378,416,401,422" shape="poly">
    <area  alt="광주시 맛집" title="광주시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=광주시" coords="683,699,689,689,712,671,716,645,704,629,725,624,744,617,759,604,777,600,786,585,803,583,815,589,827,617,819,633,829,645,830,661,850,680,832,694,810,717,801,739,792,744,789,738,780,739,774,746,765,746,766,735,760,729,760,711,766,705,759,692,741,692,735,702,722,705,719,697,712,692,698,702" shape="poly">
    <area  alt="하남시 맛집" title="하남시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=하남시" coords="730,618,745,611,760,597,775,595,783,582,779,568,766,573,738,571,727,579,710,579,697,577,691,583,686,589,686,598,684,609,704,621,718,620" shape="poly">
    <area  alt="구리시 맛집" title="구리시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=구리시" coords="721,571,732,554,725,545,709,536,704,520,695,509,677,506,657,512,665,524,666,542,681,556,698,562,706,571" shape="poly">
    <area  alt="남양주시 맛집" title="남양주시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=남양주시" coords="660,508,656,492,672,480,689,457,691,439,703,439,712,430,721,432,727,441,742,436,750,424,760,425,774,435,786,436,796,461,819,484,821,507,807,526,794,540,778,559,766,567,745,562,741,544,732,542,712,533,710,520,700,506,678,501" shape="poly">
    <area  alt="의정부시 맛집" title="의정부시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=의정부시" coords="618,430,612,438,613,450,625,460,625,480,650,488,668,476,683,456,688,438,674,422,647,435,630,435" shape="poly">
    <area  alt="양주시 맛집" title="양주시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=양주시" coords="592,324,581,347,581,365,563,388,556,398,562,416,568,435,572,453,565,463,562,476,562,486,584,486,597,476,618,477,621,462,612,453,607,438,616,425,631,433,648,433,671,418,681,404,669,385,654,371,633,365,619,357,613,327" shape="poly">
    <area  alt="고양시 맛집" title="고양시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=고양시" coords="566,441,557,447,556,456,536,463,524,456,502,459,499,468,480,473,466,466,436,474,430,483,437,494,460,498,475,516,498,526,504,541,530,542,556,533,563,504,583,506,592,515,607,515,607,495,618,482,598,479,587,488,560,489,557,476,562,463,569,451" shape="poly">
    <area  alt="성남시 맛집" title="성남시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=성남시" coords="622,697,631,685,630,664,631,647,659,629,677,618,697,629,712,648,709,667,686,686,678,699,659,702,653,715,640,709,634,708,628,705" shape="poly">
    <area  alt="부천시 맛집" title="부천시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=부천시" coords="507,626,507,609,515,591,521,573,505,557,481,557,469,576,472,608,484,618" shape="poly">
    <area  alt="광명시 맛집" title="광명시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=광명시" coords="510,611,516,598,524,606,549,606,549,627,542,639,533,655,519,650,512,642,510,627" shape="poly">
    <area  alt="시흥시 맛집" title="시흥시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=시흥시" coords="486,624,478,638,439,668,457,673,469,680,489,682,507,676,527,680,539,671,534,661,516,655,509,645,507,630,495,627" shape="poly">
    <area  alt="안산시 맛집" title="안산시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=안산시" coords="551,675,542,675,525,686,507,680,489,687,466,686,452,678,433,675,422,693,428,714,465,717,490,733,510,728,524,734,536,734,548,731,563,731,571,719,559,711,545,710,530,702,536,687,545,683" shape="poly">
    <area  alt="군포시 맛집" title="군포시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=군포시" coords="551,685,537,691,534,700,545,706,560,708,572,715,583,717,592,711,592,702,587,688,581,682,569,671,557,671" shape="poly">
    <area  alt="의왕시 맛집" title="의왕시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=의왕시" coords="597,697,619,694,627,685,625,665,630,642,610,655,592,664,586,677" shape="poly">
    <area  alt="과천시 맛집" title="과천시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=과천시" coords="580,627,589,648,590,659,603,651,647,624,637,617,627,618,615,615,601,632" shape="poly">
    <area  alt="안양시 맛집" title="안양시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=안양시" coords="546,667,537,659,545,644,556,630,553,609,572,623,580,642,586,659,580,665,580,676,568,662,557,667" shape="poly">
    <area  alt="평택시 맛집" title="평택시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=평택시" coords="545,866,534,872,536,886,523,895,510,896,492,906,509,916,518,933,531,948,548,960,565,963,587,954,622,950,642,950,656,945,674,925,688,912,686,898,677,895,669,883,674,874,669,860,666,839,659,836,651,828,640,830,627,824,613,827,613,836,607,851,607,862,592,866" shape="poly">
    <area  alt="수원시 맛집" title="수원시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=수원시" coords="619,708,628,708,633,714,650,719,654,728,654,737,644,748,645,759,636,765,627,757,616,761,609,768,597,768,589,763,583,748,572,743,569,733,577,721,587,721,595,714,595,704,607,701,618,701" shape="poly">
    <area  alt="서울 맛집" title="서울 맛집" href="<%=request.getContextPath() %>/seoul.st" coords="593,522,583,529,577,549,568,557,556,558,545,546,536,556,545,567,549,573,554,596,562,590,568,593,572,605,578,613,597,613,615,605,622,602,627,607,630,616,644,610,656,607,671,594,663,584,677,567,659,552,647,534,645,508,619,504,610,532,604,532" shape="poly">
    <area  alt="어디죠?" title="어디죠?" href="<%=request.getContextPath() %>/searchCity.st?map=어디죠?" coords="622,330,630,319,634,301,651,297,659,300,668,310,686,333,704,339,706,351,698,357,689,373,672,378,659,369,636,362,625,351" shape="poly">
    <area  alt="화성시 맛집" title="화성시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=화성시" coords="660,808,672,805,678,798,691,790,686,783,666,775,655,771,646,764,638,769,627,763,617,764,610,771,599,772,586,765,581,753,569,748,566,737,554,734,541,739,529,740,514,734,500,736,493,747,478,750,455,741,431,749,423,770,429,818,442,829,453,825,469,806,490,802,495,815,491,823,479,821,468,830,467,843,472,851,459,863,459,879,481,891,486,902,507,893,519,893,529,884,529,872,541,861,585,862,603,859,603,849,607,840,609,825,621,820,615,813,608,797,609,785,631,784,642,790,646,797" shape="poly">
    <area  alt="오산시 맛집" title="오산시 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=오산시" coords="673,808,659,810,645,799,640,791,630,785,612,788,610,796,613,806,621,817,631,822,641,826,652,825,659,831,669,832,686,817,691,804,691,791,679,799" shape="poly">
    <area  alt="인천 맛집" title="인천 맛집" href="<%=request.getContextPath() %>/searchCity.st?map=인천시" coords="267,519,263,527,265,536,271,543,271,552,265,558,269,570,277,576,279,587,288,587,299,586,305,579,314,576,325,561,331,556,333,549,343,549,352,559,369,566,371,578,379,587,391,586,397,591,404,589,417,595,423,592,427,601,412,611,406,645,393,655,395,666,391,671,396,674,405,675,414,684,417,691,421,699,420,705,409,709,411,723,409,728,400,724,397,729,397,737,386,747,377,763,370,763,368,755,357,757,340,746,322,731,319,717,310,717,298,711,295,692,303,673,308,653,294,645,290,650,279,662,269,669,254,669,230,679,227,688,213,698,209,743,214,755,210,765,203,765,198,773,191,771,183,776,175,772,158,761,152,756,149,745,147,703,137,699,85,725,79,731,72,729,64,737,57,737,45,715,38,706,19,676,11,663,5,655,4,645,0,528,0,519,6,514,19,515,26,520,36,527,44,523,41,518,49,515,56,499,59,468,52,462,52,451,60,445,63,424,84,413,93,414,112,429,122,427,132,423,140,433,148,434,176,411,183,413,188,411,192,403,208,404,217,416,231,431,244,442,251,442,256,447,252,457,262,467,268,476,266,488,259,491,260,503,265,509" shape="poly">

</map>

</div>

	<script>
		
		$(function() {
			$(".metropolitan-area").maphilight();
		});
	
	</script>

</body>
</html>