<%@page import="vo.Admin"%>
<%@page import="vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Table - Brand</title>
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/untitled.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>
<body>


	<div id="wrapper">
		<!--사이드 네비바 include-->
         <%@include file="/views/admin/side_navi.jsp" %>
    
        	<!-- 컨텐츠 영역 -->
       		<div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
            	<!--상단 네비바 include-->
       			<%@include file="/views/admin/top_navi.jsp" %>
	   




	<%
	Notice notice =(Notice)request.getAttribute("notice"); 
	%>
	
	
	<% 
	int currentPage =(int)request.getAttribute("currentPage");
	
	%>
	
	
	 <% 
                 //admin객체에서 id 확인 수정버튼 활성화 
                 Admin admin = (Admin)session.getAttribute("admin"); %> 
           
	
	
	
	<div class="card shadow">
    <div class="col-xxl-1">
        <div id="page" class="page"></div>
    </div>
    <section class="article-clean">
        <div class="container">
            <div class="row text-capitalize" style="padding-top: 70px;height: auto;padding-bottom: 15%;">
                <div class="col-lg-10 col-xl-8 offset-lg-1 offset-xl-2" style="margin-top: -50px;">
                    <section class="article-list">
                        <div class="container">
                            <p class="text-center"><span class="by">공지사항</span><span class="date"></span></p>
                            <hr />
                          <H3>  <p class="text-center" style="color: rgb(0,0,0);"><%=notice.getNoticeTitle() %></p></H3>
                            <p class="text-center"><span class="date"><%=notice.getRegDate() %></span><span class="by">| </span> 조회수 : <%=notice.getViewCount() %></p>
                            <div style="padding: 0px;padding-left: 0;margin: 48px 0px 0px 488.8px;margin-left: 69%;margin-top: 47px;margin-right: 0px;font-size: 12px;padding-right: 0px;">
                                
                                
                                <div class="btn-group" role="group" style="border-style: none;border-color: var(--bs-gray-100);margin-right: 26px;padding-right: 0px;margin-top: 0px;padding-top: 0px;">
                                <button class="btn btn-light btn-sm" id="textUpdateBtn" type="submit" style="width: 61px;height: 28px;margin: 2px;padding: 2px 2px;padding-left: 3px;opacity: 1;filter: brightness(90%) contrast(200%) saturate(113%);margin-left: 0;border-style: none;border-color: rgb(252,252,252);border-top-style: none;border-top-color: rgb(255,255,255);border-right-style: none;border-right-color: rgb(255,255,255);border-bottom-style: none;border-bottom-color: rgb(255,255,255);
                                border-left-style: none;border-left-color: rgb(255,255,255);font-size: 13px;text-align: right; id="modifyBtn">수정</button>
                                <button class="btn btn-light btn-sm"  id="deleteBtn" type="Button" style="width: 61px;height: 28px;margin: 2px;padding: 2px 2px;padding-left: 3px;opacity: 1;filter: brightness(90%) contrast(200%) saturate(113%);margin-left: 0;border-style: none;border-color: rgb(252,252,252);border-top-style: none;border-top-color: rgb(255,255,255);border-right-style: none;border-right-color: rgb(255,255,255);border-bottom-style: none;border-bottom-color: rgb(255,255,255);border-left-style: none;border-left-color: rgb(255,255,255);font-size: 13px;text-align: center;">삭제</button>
                                <button class="btn btn-light btn-sm" id="menuBtn" type="Button" style="width: 61px;height: 28px;margin: 2px;padding: 2px 2px;padding-left: 3px;opacity: 1;filter: brightness(90%) contrast(200%) saturate(113%);margin-left: 0;border-style: none;border-color: rgb(252,252,252);border-top-style: none;border-top-color: rgb(255,255,255);border-right-style: none;border-right-color: rgb(255,255,255);border-bottom-style: none;border-bottom-color: rgb(255,255,255);border-left-style: none;border-left-color: rgb(255,255,255);font-size: 13px;text-align: left;">
                               	목록</button></div>
                            </div>
                            <hr style="width: 100%;" />
                            <p class="text-center"><span class="by"> <span class="fileReName"><%=notice.getFileRename() %></span> </span>
                             <span class="fileSize"><%=notice.getFileSize() %></span>
                            </p>
                        </div>
                        
                    </section>
                    <hr />
                    <div class="intro"></div>
                    <div class="text" style="padding-bottom: 8%;padding-top: 10px;">
      
                        
                     <p class="form-control-sm" style="width: 100%;height: 500px;" placeholder="내용을 입력하세요" wrap="soft" readonly><%=notice.getNoticeContent() %></p>
                        
                       <figure class="figure d-block"></figure>                      
                        <hr/>
                    </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
    
    <input type="hidden" name="boardNo" value="<%=notice.getNoticeNo() %>"/>
    
    
    
</div>
			<script>
			$('#textUpdateBtn').click(function(){







				});




			</script>
			<!--삭제하는 버튼  -->
			
			<script>
			$('#deleteBtn').click(function(){

				if(window.confirm('정말로 삭제하시겠습니까?'))
				{// 삭제를 하기위한 폼태그 생성 - post 방식으로 처리하기 위함
				
					var formTag= document.createElement("form");
					formTag.setAttribute("action","/board/noticePostDelete.do");
					formTag.setAttribute("method","post");
					
					var inputTag = document.createElement("input");
					inputTag.setAttribute("type","hidden");
					inputTag.setAttribute("name","noticeNo");				
					inputTag.setAttribute("value","<%=notice.getNoticeNo()%>");
					
					formTag.appendChild(inputTag);
					
					//해당 문서안에 새롭게 만든 formTag를 추가시켜줘야한다.(연결시켜준다라는 의미)
					document.body.appendChild(formTag);
					
					formTag.submit();
					
				}else
				{
						alert('삭제를 취소하였습니다');	
				}
				
				
			});
			
			
			</script>






 
                      
                         
                            
                            	</div> 
                            </div>
                        </div>
                    </div>
                </section>
            </div>
           <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span><br><br>webmaster :&nbsp;<a href="mailto:artsuwon@artsuwon.or.kr">artsuwon@artsuwon.or.kr</a><br>Copyrightⓒ2015 Suwon Philhamonic Orchestra &amp; Suwon City Chorale &amp; Suwon Civic Troupe<br><br></span></div>
                </div>
            </footer>
            
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    <script src="//<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/theme.js"></script>

</body>

</html>