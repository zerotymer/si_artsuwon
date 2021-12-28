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
    <title>공연 정보</title>
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
  <div id="wrapper">
    <!--사이드 네비바 include-->
    <%@include file="/views/adminCommon/yj_side_navi.jsp" %>
    
    <!-- 컨텐츠 영역 -->
    <div class="d-flex flex-column" id="content-wrapper">
        <div id="content">
       		<!--상단 네비바 include-->
       		<%@include file="/views/adminCommon/top_navi.jsp" %>
            
      <!-- 컨테이너 -->
     <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="card shadow mb-3">
                    <div class="card-header py-3">
                        <p class="text-primary m-0 fw-bold">공연 정보</p>
                    </div>
                    
                    <div class="card-body">
                        <form action="/adminPfmc/updatePfmc.do" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="pfmcNo" value="${requestScope.pfmcNo}">
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3">
                                    	<label class="form-label" for="category" style="margin-bottom:0;"><strong>공연 분류</strong><br></label>
                                    	<select class="form-select" name="category">
                                            <option value="정기공연/관현악" <c:if test="${requestScope.pfmc.category=='정기공연/관현악'}">selected</c:if>>정기공연/관현악</option>
                                            <option value="시민공연/특별공연" <c:if test="${requestScope.pfmc.category=='시민공연/특별공연'}">selected</c:if>>시민공연/특별공연</option>
                                            <option value="시민공연/찾아가는음악회" <c:if test="${requestScope.pfmc.category=='시민공연/찾아가는음악회'}">selected</c:if>>시민공연/찾아가는음악회</option>
                                            <option value="교육공연/일반인교육" <c:if test="${requestScope.pfmc.category=='교육공연/일반인교육'}">selected</c:if>>교육공연/일반인교육</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="col">
                                    <div class="mb-3">
	                                    <label class="form-label" for="title" style="margin-bottom:0;"><strong>공연 제목</strong><br></label>
	                                    <input class="form-control" type="text" name="title" value="${requestScope.pfmc.title }">
                                    </div>
                                </div>
                           </div>
                            
                            
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3">
	                                        <label class="form-label" for="conductor" style="margin-bottom:0;"><strong>지휘자</strong><br></label>
	                                        <input class="form-control" type="text" name="conductor" value="${requestScope.pfmc.conductor }">
                                        </div>
                                    </div>
                                    
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label" for="collaborator" style="margin-bottom:0;"><strong>협연자</strong><br></label>
                                        <input class="form-control" type="text" name="collaborator" value="${requestScope.pfmc.collaborator }"></div>
                                    </div>
                                </div>
                                     
                              <!-- 상세 정보(아작스) -->
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3"></div>
                                        <label class="form-label" style="margin-bottom:0;"><strong>상세 정보</strong><br></label>
                                        <div class="table-responsive table mt-2" id="dataTable-1" role="grid" aria-describedby="dataTable_info">
                                            <table class="table my-0" id="dynamicTable" style="border-style:solid; border-width:1px;">
                                                <thead>
                                                    <tr style="text-align:center;">
                                                        <th style="width:8%;">공연일자</th>
                                                        <th style="width:8%;">시간</th>
                                                        <th style="width:23%;">장소</th>
                                                        <th>가격</th>
                                                        <th style="width:12%;">좌석제한</th>
                                                        <th style="width:6%;"></th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr style="text-align:center;">
                                                        <td>
                                                        	<input class="form-control" type="date" id="pfmcDate" style="text-align:center;">
                                                        </td>
                                                        
                                                        <td>
                                                        	<input class="form-control" type="text" id="pfmcTime" placeholder="hh:mm" style="text-align:center;">
                                                        </td>
                                                        
                                                        <td>
                                                        	<input class="form-control" type="text" id="location">
                                                        </td>
                                                        
                                                        <td>
                                                        	<input class="form-control" type="text" id="price">
                                                        </td>
                                                        
                                                        <td>
                                                        	<select class="form-select" name="restriction" id="restriction">
                                           						 <option value="제한없음">제한없음</option>
                                           						 <option value="1단계">1단계</option>
                                           						 <option value="2단계">2단계</option>
                                           						 <option value="3단계">3단계</option>
                                           					</select>
                                                        </td>
                                                        <td>
                                                        	<button class="btn btn-secondary btn-sm" type="button" onclick="tableCreate()">추가</button>
                                                        </td>
                                                        
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                
                          
                         <!-- 공연 스케줄 데이터 가져오기-->
                         <script>
                        	 window.onload = (function(){
                         		console.log('체크');
                         		$.ajax({
                             		url:"/adminPfmc/selectPfmcSkdl.do",
                             		data:{"pfmcNo":${requestScope.pfmcNo}},
                             		type:"get",
                             		dataType:"json",
                             		success:function(data){
                             			//한줄씩 만들어서 테이블에 append
	                           			var html = '';
	                           			$.each(data, function(index,item) {
	                           				html += '<tr style="text-align:center;">';
	                           				html += '<td><input type="hidden" name="pfmcDate" value="' + item.pfmcDate + '">'+item.pfmcDate+'</td>';
	                           				html += '<td><input type="hidden" name="pfmcTime" value="' + item.pfmcTime + '">'+item.pfmcTime+'</td>';
	                           				html += '<td><input type="hidden" name="location" value="' + item.location + '">'+item.location+'</td>';
	                           				html += '<td><input type="hidden" name="price" value="' + item.price + '">'+item.price+'</td>';
	                           				html += '<td><input type="hidden" name="restrictionName" value="' + item.restrictionName + '">'+item.restrictionName+'</td>';
	                           				html += '<td><button class="btn btn-outline-danger btn-sm" type="button" value="'+item.scheduleNo+'" onclick="skdlDelete(this);">삭제</button></td>';
	                           				html += '</tr>';
	                           			});
	                           			$("#dynamicTable").append(html);
                             		},
	                             		error:function(){
	                             			console.log('ajax통신 실패');
	                             	}
                         	});
                         });
                        </script>
                                
                        <!-- 동적 테이블에 스케줄 추가 -->
                         <script>
                            function tableCreate(){
							var tc = new Array();
							var html = '';
										
							var pfmcDate = $("#pfmcDate").val();
							var pfmcTime = $("#pfmcTime").val();
							var location = $("#location").val();
							var price = $("#price").val();
							var restriction = $("#restriction").val();
							
							if(pfmcDate==""){
								alert('공연일자를 입력하세요');
								return false;
							}else if(pfmcTime==""){
								alert('시간을 입력하세요');
								return false;
							}else if(location==""){
								alert('장소를 입력하세요');
								return false;
							}else if(price==""){
								alert('가격을 입력하세요');
								return false;
							}else if(restriction==null){
								alert("좌석제한을 선택하세요");
								return false;
							}
							
							$.ajax({
								url:"/adminPfmc/insertPfmcSkdl.do",
								data : {"pfmcNo" : ${requestScope.pfmcNo},
										"pfmcDate" : pfmcDate,
										"pfmcTime" : pfmcTime,
										"location" : location,
										"price" : price,
										"restriction" : restriction},
								type:"post",
								success:function(scheduleNo){
									html += '<tr style="text-align:center;">';
									html += '<td><input type="hidden" name="pfmcDate" value="' + pfmcDate + '">'+pfmcDate+'</td>';
									html += '<td><input type="hidden" name="pfmctime" value="'+pfmcTime+'">'+pfmcTime+'</td>';
									html += '<td><input type="hidden" name="location" value="'+location+'">'+location+'</td>';
									html += '<td><input type="hidden" name="price" value="'+price+'">'+price+'</td>';
									html += '<td><input type="hidden" name="restriction" value="'+restriction+'">'+restriction+'</td>';
									html += '<td><button class="btn btn-outline-danger btn-sm" type="button" value="'+scheduleNo+'" onclick="skdlDelete(this);">삭제</button></td>';
									html += '</tr>';
												
									$("#dynamicTable").append(html);
												
									$("#pfmcDate").val('');
									$("#pfmcTime").val('');
									$("#location").val('');
									$("#price").val('');
									$("#restriction").val('');
									},
								error:function(){
									console.log('ajax 통신 실패');
								}
							})
						}
                		</script>
                            
                            
                         <!-- 동적 테이블 삭제 -->
                         <script>
                           	function skdlDelete(e){
                               	var scheduleNo = $(e).attr('value');
                               	$.ajax({
                               		url:"/adminPfmc/deletePfmcSkdl.do",
                               		data:{"scheduleNo":scheduleNo},
                               		type:"get",
                               		success:function(resultRow){
                               			if(resultRow>0){
                               				//삭제할 로우 특정
                               				$(e).parents('tr').remove();
                               				//location.reload();
                               			}
                               		},
                               		error:function(){
                               			console.log('ajax 통신 실패');
                               		}
                               	})
                           	}
                         </script> 
                                 
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>프로그램 설명</strong><br></label>
	                                 <textarea class="form-control" rows="4" name="programs">${requestScope.pfmc.programs }</textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>공연 소개</strong><br></label>
	                                 <textarea class="form-control" rows="4" name="introduction">${requestScope.pfmc.introduction }</textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>프로그램 노트</strong><br></label>
	                                 <textarea class="form-control" rows="4" name="programNote">${requestScope.pfmc.programNote }</textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>연관 패키지</strong><br></label>
	                                 <textarea class="form-control" rows="4" name="relatedPackage">${requestScope.pfmc.relatedPackage }</textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>메모</strong><br></label>
	                                 <textarea class="form-control" rows="4" name="memo">${requestScope.pfmc.memo }</textarea>
                                </div>
                                
                                <div class="mb-3">
                                	<label class="form-label" for="signature" style="margin-bottom:0;"><strong>사진</strong><br></label>
                                	<input class="form-control" type="file" name="file">
                                	<div style="font-size:14px"><b>* 현재 등록된 파일 : </b>${requestScope.pfmc.photo }</div>
                                	<input type="hidden" name="prevPhoto" value="${requestScope.pfmc.photo }">
                                </div>
                                
                            <button class="btn btn-primary" type="submit">수정하기</button>
                            </form>
                                <div class="mb-3"></div>
                                  
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
    
    <script src="/assets/js/bootstrap.min.js"></script>
    <script src="/assets/js/theme.js"></script>
   
</body>
</html>

