<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.artsuwon.adminPfmc.model.vo.Performance"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>관리자 페이지</title>
    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="/assets/fonts/fontawesome-all.min.css">
    <link rel="stylesheet" href="/assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="/assets/fonts/fontawesome5-overrides.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script src="https://code.jquery.com/jquery-3.5.1.js" 
integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
</head>

<body id="page-top">
	<%
		HashMap<String,Object> pfmcListMap = (HashMap<String,Object>)request.getAttribute("pfmcListMap");
	
		ArrayList<Performance> pfmcList = (ArrayList<Performance>)pfmcListMap.get("pfmcList");
		String pageNavi = (String)pfmcListMap.get("pageNavi");
		int currentPage = (int)request.getAttribute("currentPage");
	%>
	
    <div id="wrapper">
        <!--사이드 네비바 include-->
        <%@include file="/views/adminCommon/yj_side_navi.jsp" %>
        
        <!-- 컨텐츠 영역 -->
        <div class="d-flex flex-column" id="content-wrapper">
            <div id="content">
            	<!--상단 네비바 include-->
            	<%@include file="/views/adminCommon/top_navi.jsp" %>
                
                
                <!-- 컨테이너 -->
                <div class="container-fluid">
                    <div class="card shadow">
                        <form>
                        	<div class="card-header py-3">
		                        <span><b>공연일시 </b></span><input type="date" name="startDate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                        <span><b>공연분류 </b>
		                        <select name="">
		                        	<option value="">정기공연/관현악</option>
		                        	<option value="">시민공연/특별공연</option>
		                        	<option value="">시민공연/찾아가는음악회</option>
		                        	<option value="">교육공연/일반인교육</option>
		                        </select>
		                        </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                        <span><b>공연명 </b></span><input type="text" name="showName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		                        
	                            <button class="btn btn-primary" type="submit">공연 조회</button>&nbsp;&nbsp;&nbsp;
	                            <button type="button" onclick="location.href='/views/adminPfmc/pfmcInsertForm.jsp';" class="btn btn-primary" >공연 등록</button>
	                        </div>
                     	</form>
                        
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-6 text-nowrap">
                                    <div id="dataTable_length" class="dataTables_length" aria-controls="dataTable">
	                                    <select>
		                                    <option value="12" selected="">최근순</option>
		                                    <option value="13">공연번호순</option>
		                                    <option value="14">가격순</option>
	                            		</select>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="table-responsive table mt-2" id="dataTable" role="grid" aria-describedby="dataTable_info">
                                <table class="table my-0" id="dataTable">
                                    <thead>
                                        <tr>
                                            <th>No</th>
                                            <th>공연 분류</th>
                                            <th>공연 제목</th>
                                            <th>공연일시</th>
                                            <th>공연 장소</th>
                                            <th></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <%for(Performance pfmc:pfmcList){ %>
                                        <tr>
                                            <td><%=pfmc.getNum() %></td>
                                            <td><%=pfmc.getCategory() %></td>
                                            <td>
	                                            <strong><a href="/adminPfmc/showPfmcInfo.do?pfmcNo=<%=pfmc.getPfmcNo()%>"
	                                            id="pfmcNo<%=pfmc.getPfmcNo()%>"><%=pfmc.getTitle() %></a></strong>
	                                        </td>
                                            <td><%=pfmc.getPfmcDate() %></td>
                                            <td><%=pfmc.getLocation() %></td>
                                            <td><button type="button" onclick="deletePfmc(this);" class="btn btn-danger"
                                            style="font-size:13px; padding-top:4px;padding-bottom:0px;" value=<%=pfmc.getPfmcNo()%>>삭제</button></td>
                                        </tr>
                                    <%} %>
                                    </tbody>
                                </table>
                            </div>
                            
                            <!-- 공연 삭제 -->
                            <script>
	                            function deletePfmc (e) {
	                            	var pfmcNo = $(e).attr('value');
	                            	console.log(pfmcNo);
	                            	var pfmcTitle = $('#pfmcNo'+pfmcNo).text();
	                            	var choice = confirm(pfmcTitle + " 을(를) 삭제하시겠습니까?");
	                            	
	                            	if(choice){
	                            		$.ajax({
	                            			url : "/adminPfmc/deletePfmc.do",
	                            			data : {"pfmcNo": pfmcNo},
	                            			type : "get",
	                            			success : function(resultRow){
	                            				if(resultRow>0){
	                            					alert('삭제되었습니다.');
	                            					location.reload(); //새로고침
	                            				}else{
	                            					alert('삭제에 실패했습니다.');
	                            				}
	                            			},
	                            			error : function(){
	                            				console.log('ajax 통신 실패');
	                            			}
	                            		});
	                            	    
	                            	}else{
	                            	    alert("삭제가 취소되었습니다.");
	                            	}
	                            }
                            </script>
                            
              <div class="row">
                  <div class="col-md-6 align-self-center">
                     <p id="dataTable_info" class="dataTables_info" role="status" aria-live="polite">총 <%=pfmcList.get(0).getTotalCount() %> 건</p>
                  </div>
                    
                     <div class="col-md-6">
	                     <nav class="d-lg-flex justify-content-lg-end dataTables_paginate paging_simple_numbers">
	                          <ul class="pagination">
	                          	  <%=pageNavi %>
	                          </ul>
	                     </nav>
                     </div>
              </div>
           </div>
         </div>
        </div>
      </div>
            
            
            <footer class="bg-white sticky-footer">
                <div class="container my-auto">
                    <div class="text-center my-auto copyright"><span>Copyright © Brand 2021</span></div>
                </div>
            </footer>
            
        </div><a class="border rounded d-inline scroll-to-top" href="#page-top"><i class="fas fa-angle-up"></i></a>
    </div>
    
    <script src="<%=request.getContextPath()%>/assets/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/assets/js/theme.js"></script>
</body>
</html>

