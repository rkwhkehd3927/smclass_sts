<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

	<!-- GNB -->
	<div id="gnb">
		
		<div id="top">
			<ul>
				<li class="brand t1"><a href="#" id="topNavi1">JARDIN’s BRAND</a>
					<ul id="topSubm1">
						<li><a href="#">클래스</a></li>
						<li><a href="#">홈스타일 카페모리</a></li>
						<li><a href="#">드립커피백</a></li>
						<li><a href="#">카페리얼 커피</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">카페리얼 음료</a></li>
						<li><a href="#">마일드커피백</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">카페포드</a></li>
						<li><a href="#">모히또파티</a></li>
						<li><a href="#">테이크아웃 카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi2">원두</a>
					<ul id="topSubm2">
						<li><a href="#">클래스</a></li>
						<li><a href="#">로스터리샵</a></li>
						<li><a href="#">커피휘엘</a></li>
						<li><a href="#">산지별 생두</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi3">원두커피백</a>
					<ul id="topSubm3">
						<li><a href="#">드립커피 로스트</a></li>
						<li><a href="#">오리지널커피백</a></li>
						<li><a href="#">마일드커피백</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi4">인스턴트</a>
					<ul id="topSubm4">
						<li><a href="#">까페모리</a></li>
						<li><a href="#">홈스타일카페모리</a></li>
						<li><a href="#">포타제</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi5">음료</a>
					<ul id="topSubm5">
						<li><a href="#">까페리얼</a></li>
						<li><a href="#">워터커피</a></li>
						<li><a href="#">모히또</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi6">커피용품</a>
					<ul id="topSubm6">
						<li><a href="#">종이컵</a></li>
						<li><a href="#">커피필터</a></li>
						<li><a href="#">머신 등</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi7">선물세트</a></li>
				<li class="t2"><a href="#" id="topNavi8">대량구매</a></li>
			</ul>
		</div>

		<script type="text/javascript">initTopMenu();</script>
	</div>
	<!-- //GNB -->

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="/">HOME</a></li>
				<li><a href="/event/event">EVENT</a></li>
				<li class="last">진행중 이벤트</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">EVENT<span>이벤트</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">진행중 이벤트</a></li>
					<li><a href="#" id="leftNavi2">종료된 이벤트</a></li>
					<li class="last"><a href="#" id="leftNavi3">당첨자 발표</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(1,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="mypage">
					<h2><strong>진행중 이벤트</strong><span>쟈뎅샵의 특별한 혜택이 가득한 이벤트에 참여해 보세요.</span></h2>
					
					<div class="viewDivMt">
						<div class="viewHead">
							<div class="subject">
								<ul>
									<li>${edto.etitle}</li>
								</ul>
							</div>
							<div class="day">
								<p class="txt">이벤트 기간
								<span>
								<fmt:formatDate value="${edto.stdate}" pattern="yyyy-MM-dd"/>
								~ 
								<fmt:formatDate value="${edto.enddate}" pattern="yyyy-MM-dd"/>
								</span></p>
							</div>
						</div>

						<div class="viewContents">
							${edto.econtent}
							<br/>
							<img src="/upload/board/${edto.efile2}" alt="" />
						</div>
					</div>


					<!-- 이전다음글 -->
					<div class="pnDiv web">
						<table summary="이전다음글을 선택하여 보실 수 있습니다." class="preNext" border="1" cellspacing="0">
							<caption>이전다음글</caption>
							<colgroup>
							<col width="100px" />
							<col width="*" />
							<col width="100px" />
							</colgroup>
							<tbody>
								<tr>
									<th class="pre">PREV</th>
									<td><a href="#">상품 재입고는 언제 되나요?</a></td>
									<td>&nbsp;</td>
								</tr>

								<tr>
									<th class="next">NEXT</th>
									<td>다음 글이 없습니다.</td>
									<td>&nbsp;</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- //이전다음글 -->

					<script>
					  $(function(){
						  let chk = 0;  // 화면창 열림 체크
						  let cno; // like 전역변수
						  let id;
				 		  let cdate;
						  let ccontent;
						  let eno;
						 	
						  
						  // 댓글쓰기
						  $(".replyBtn").click(function(){
						  		if("${session_id}"==null){
								  alert("로그인을 하셔야 댓글을 사용할 수 있습니다.");
								  if(confirm("로그인 페이지로 이동할까요?")){
									  location.href="/member/login";
								  }
								  return;
							  	}
							  
							 if($(".replyType").val().length<1){
								 alert("댓글을 입력하셔야 저장이 가능합니다.");
								 $(".replyType").focus();
								 return;
							 }
							 alert("댓글을 저장합니다.");
							 console.log("총 개수: "+Number($(".allCount").text())+1);
							 let cpw = $(".replynum").val();
							 let ccontent = $(".replyType").val();
							 let eno = "${edto.eno}";
							
							 //ajax
							 $.ajax({
								url:"/event/cwrite", //링크주소
								type:"post",         //타입
								data:{"eno":eno,"cpw":cpw,"ccontent":ccontent}, //파라미터
								dataType:"json", //리턴받을 값의 형태
								success:function(data){
									console.log(data.cno);
									console.log(data.ccontent);
									console.log(data.cdate);
									cno= data.cno;
									id = data.id;
									cdate = data.cdate;
									ccontent = data.ccontent;
									
									// 데이터 html 코드 생성
									let hdata = "";
									
									hdata += '<ul id="'+cno+'">';
									hdata += '<li class="name">'+id+'<span> [ '+
											moment(cdate).format("YYYY-MM-DD HH:mm:ss")
											+' ]</span></li>';
									hdata += '<li class="txt">'+ccontent+'</li>';
									hdata += '<li class="btn">';
									hdata += '<a class="rebtn updateBtn">수정</a>&nbsp';
									hdata += '<a class="rebtn deleteBtn">삭제</a>';
									hdata += '</li>';
									hdata += '</ul>';
									
									$(".replyBox").prepend(hdata);
									
									// 총 개수 +1
									let allCount = Number($(".allCount").text())+1;
									$(".allCount").text(allCount);
									
									// 입력된 글 삭제
									$(".replynum").val("");
									$(".replyType").val("");
								},
								error:function(){
									alert("댓글저장 실패");
								}
								
							 }); // ajax
						  }); // replyBtn
						  
						  
						  // 댓글 삭제 - 정적형태: 화면표시가 되면 추가된 html 소스에는 적용안됨
// 						  ${".deleteBtn"}.click(function(){
// 						  }); // deleteBtn
						  
						  // 댓글 삭제 - 동적형태: 추가적인 html 소스에서도 적용 가능
						  $(document).on("click",".deleteBtn",function(){
							 	console.log($(this).closest("ul").attr("id"));
							 	let cno = $(this).closest("ul").attr("id");
							 	if(confirm(cno+"번 댓글을 삭제하시겠습니까?")){
							 		alert(cno+"번 게시글이 삭제되었습니다.");
							 		
							 		$.ajax({
							 			url:"/event/cdelete", //링크주소
										type:"post",         //타입
										data:{"cno":cno}, //파라미터
										dataType:"text", //리턴받을 값의 형태
										success:function(data){
											console.log(data.result);
											
											$("#"+cno).remove();
											
											// 총 개수 +1
											let allCount = Number($(".allCount").text())-1;
											$(".allCount").text(allCount);
										
										},
										error:function(){
											alert("댓글저장 실패");
										}
							 			
							 		}); // ajax
							 	} // if
							 	
						  });  // deleteBtn
						  
						  // updateBtn
						  $(document).on("click",".updateBtn",function(){
							  	if(chk==1){
							  		alert("다른 수정화면이 열려있습니다. 닫은 후 수정이 가능합니다.");
							  		return;
							  	}
							  	chk=1;
							  
// 							  	console.log($(this).closest("ul").attr("id"));
							 	cno = $(this).closest("ul").attr("id");
							 	cdate = $(this).closest("ul").children("name").children("span").text();
// 							 	id = "aaa";
							 	ccontent = $(this).closest("ul").children(".txt").text();
							 	
							 	console.log(cno);
							 	console.log(id);
							 	console.log(cdate);
							 	console.log(ccontent);
							 	console.log($(this).closest("ul").children("name"))
							 	
							 	alert(cno+"번 수정화면 버튼 클릭");
							 	
							 	let hdata = `
							 		<li class="name">`+id+`<span>  `+cdate+`</span></li> 
							 		<li class="txt"><textarea class="replyType">`+ccontent+`</textarea></li> 
							 		<li class="btn"> 
								 		<a class="rebtn saveBtn">완료</a> 
								 		<a class="rebtn cancelBtn">취소</a> 
							 		</li> 
							 	`;
							 	
							 	$("#"+cno).html(hdata);
						  }) // updateBtn
						  
						  
						  // 수정화면 취소
						  $(document).on("click",".cancelBtn",function(){
							  alert(cno+"번 취소 버튼 클릭");
							  console.log(id);
							  console.log(cdate);
							  console.log(ccontent);
							  
							  let hdata = `
							  
								  	<li class="name">`+id+` <span>`+cdate+`</span></li>
									<li class="txt">`+ccontent+`</li>
									<li class="btn">
										<a class="rebtn updateBtn">수정</a>
										<a class="rebtn deleteBtn">삭제</a>
									</li>
							  `;
							  
							  $("#"+cno).html(hdata);	
							  chk=0;
							  
							  
						  }); // cancelBtn
						  
						  // 댓글 수정 저장
						  $(document).on("click",".saveBtn",function(){
							 alert(cno+"번 댓글 수정 완료")
// 							 let eno = "${edto.eno}";
							 ccontent = $(this).closest("ul").children(".txt").children(".replyType").val();
// 						  	 let cpw = $(".replynum").val();
							  
							  	 //ajax
								 $.ajax({
									url:"/event/cupdate", // 링크주소
									type:"post",         // 타입
									data:{"eno":eno,"cno":cno,"ccontent":ccontent}, // 파라미터
									dataType:"json", // 리턴받을 값의 형태
									success:function(data){
										console.log(data.cno);
										console.log(data.ccontent);
										console.log(data.cdate);
										
// 										let cno = data.cno;
// 										let id = data.id;
// 										let ccontent = data.ccontent;
// 										let cdate = data.cdate;
										
										// 데이터 html 코드 생성
										let hdata = "";
										
										hdata += '<li class="name">'+id+'<span> [ '+
												moment(cdate).format("YYYY-MM-DD HH:mm:ss")
												+' ]</span></li>';
										hdata += '<li class="txt">'+ccontent+'</li>';
										hdata += '<li class="btn">';
										hdata += '<a class="rebtn updateBtn">수정</a>&nbsp';
										hdata += '<a class="rebtn deleteBtn">삭제</a>';
										hdata += '</li>';
										
										$("#"+cno).html(hdata);
										
									},
									error:function(){
										alert("댓글저장 실패");
									}
									
								 }); // ajax
								 
								 chk=0;
							  
						  }); //saveBtn
							  
					  }); // function
					</script>

					<!-- 댓글-->
					<div class="replyWrite">
						<ul>
							<li class="in">
								<p class="txt">총 <span class="orange allCount">${clist.size()}</span> 개의 댓글이 달려있습니다.</p>
								<p class="password">비밀번호&nbsp;&nbsp;<input type="password" class="replynum" /></p>
								<textarea class="replyType"></textarea>
							</li>
							<li class="btn"><a class="replyBtn">등록</a></li>
						</ul>
						<p class="ntic">※ 비밀번호를 입력하시면 댓글이 비밀글로 등록 됩니다.</p>
					</div>

					<div class="replyBox">
					
					
						<c:forEach items="${clist}" var="cdto">
							<c:if test="${session_id == cdto.id }">
								<ul id="${cdto.cno}">
									<li class="name">${cdto.id} <span>[${cdto.cdate }]</span></li>
									<li class="txt">${cdto.ccontent }</li>
									<li class="btn">
										<a class="rebtn updateBtn">수정</a>
										<a class="rebtn deleteBtn">삭제</a>
									</li>
								</ul>
							</c:if>
							
							<c:if test="${session_id != cdto.id }">
								<ul>
									<li class="name">${cdto.id} <span>[${cdto.cdate }]</span></li>
									<c:if test="${cdto.cpw != null }">
									<li class="txt">
										<a class="passwordBtn"><span class="orange">※ 비밀글입니다.</span></a>
									</li>
									</c:if>
									<c:if test="${cdto.cpw == null }">
										<li class="txt">${cdto.ccontent }</li>
									</c:if>
								</ul>
							</c:if>
						</c:forEach>

						<ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt">대박!!! 이거 저한테 완전 필요한 이벤트였어요!!</li>
							<li class="btn">
								<a href="#" class="rebtn">수정</a>
								<a href="#" class="rebtn">삭제</a>
							</li>
						</ul>
						
							<!-- 댓글 수정, 비밀글 창 -->
						
<!-- 						<ul> -->
<!-- 							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li> -->
<!-- 							<li class="txt"><textarea class="replyType"></textarea></li> -->
<!-- 							<li class="btn"> -->
<!-- 								<a href="#" class="rebtn saveBtn">완료</a> -->
<!-- 								<a href="#" class="rebtn cancelBtn">취소</a> -->
<!-- 							</li> -->
<!-- 						</ul> -->

						<ul>
							<li class="name">jjabcde <span>[2014-03-04&nbsp;&nbsp;15:01:59]</span></li>
							<li class="txt">
								<a class="passwordBtn"><span class="orange">※ 비밀글입니다.</span></a>
							</li>
						</ul>
					</div>
					<!-- //댓글 -->


					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bRight">
							<ul>
								<li><a href="/event/event" class="sbtnMini mw">목록</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->
					
				</div>
			</div>
			<!-- //contents -->


<script type="text/javascript" src="../js/jquery.fancybox-1.3.4.pack.js"></script>
<link rel="stylesheet" type="text/css" href="../css/jquery.fancybox-1.3.4.css" />
<script type="text/javascript">
$(function(){
	
	var winWidth = $(window).width();
	if(winWidth > 767){
		var layerCheck = 540;
	}else{
		var layerCheck = 320;
	}

	$(".passwordBtn").fancybox({
		'autoDimensions'    : false,
		'showCloseButton'	: false,
		'width' : layerCheck,
		'padding' : 0,
		'type'			: 'iframe',
		'onComplete' : function() {
			$('#fancybox-frame').load(function() { // wait for frame to load and then gets it's height
			$('#fancybox-content').height($(this).contents().find('body').height());
			});
		}
	});


});
</script>

		</div>
	</div>
	<!-- //container -->

<%@ include file="../footer.jsp" %>
