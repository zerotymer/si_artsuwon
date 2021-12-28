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
                        <p class="text-primary m-0 fw-bold">공연 등록</p>
                    </div>
                    
                    <div class="card-body">
                        <form action="/adminPfmc/insertPfmc.do" method="post" enctype="multipart/form-data">
                            <div class="row">
                                <div class="col">
                                    <div class="mb-3">
                                    	<label class="form-label" for="category" style="margin-bottom:0;"><strong>공연 분류</strong><br></label>
                                    	<select class="form-select" name="category">
                                            <option value="정기공연/관현악">정기공연/관현악</option>
                                            <option value="정기공연/실내악">정기공연/실내악</option>
                                            <option value="시민공연/특별공연">시민공연/특별공연</option>
                                            <option value="시민공연/찾아가는음악회">시민공연/찾아가는음악회</option>
                                            <option value="교육공연/일반인교육">교육공연/일반인교육</option>
                                        </select>
                                    </div>
                                </div>
                                
                                <div class="col">
                                    <div class="mb-3">
	                                    <label class="form-label" for="title" style="margin-bottom:0;"><strong>공연 제목</strong><br></label>
	                                    <input class="form-control" type="text" name="title">
                                    </div>
                                </div>
                           </div>
                            
                            
                                <div class="row">
                                    <div class="col">
                                        <div class="mb-3">
	                                        <label class="form-label" for="conductor" style="margin-bottom:0;"><strong>지휘자</strong><br></label>
	                                        <input class="form-control" type="text" name="conductor">
                                        </div>
                                    </div>
                                    
                                    <div class="col">
                                        <div class="mb-3"><label class="form-label" for="collaborator" style="margin-bottom:0;"><strong>협연자</strong><br></label>
                                        <input class="form-control" type="text" name="collaborator"></div>
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
                                                        	<input class="form-control" type="text" id="time" placeholder="hh:mm" style="text-align:center;">
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
                                
                                <!-- 동적 테이블 -->
                                  <script>
                                      function tableCreate(){
										var tc = new Array();
										var html = '';
													
										var pfmcDate = $("#pfmcDate").val();
										var time = $("#time").val();
										var location = $("#location").val();
										var price = $("#price").val();
										var restriction = $("#restriction").val();
										
										html += '<tr style="text-align:center;">';
										html += '<td><input type="hidden" name="pfmcDate" value="' + pfmcDate + '">'+pfmcDate+'</td>';
										html += '<td><input type="hidden" name="pfmctime" value="'+time+'">'+time+'</td>';
										html += '<td><input type="hidden" name="location" value="'+location+'">'+location+'</td>';
										html += '<td><input type="hidden" name="price" value="'+price+'">'+price+'</td>';
										html += '<td><input type="hidden" name="restriction" value="'+restriction+'">'+restriction+'</td>';
										html += '<td>'+'<button class="btn btn-outline-danger btn-sm" type="button" id="delete">삭제</button></td>';
										html += '</tr>';
													
										$("#dynamicTable").append(html);
													
										$("#pfmcDate").val('');
										$("#time").val('');
										$("#location").val('');
										$("#price").val('');
										$("#restriction").val('');
									}
                               	  </script>
                               
	                               <!-- 동적 테이블 삭제 -->
	                               <script>
	                                  	$(document).on('click','#delete',function(){
	                                  		$('#dynamicTable tbody tr:last').remove();
	                                  	})
	                               </script> 
	                               
	                               
                                 
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>프로그램 설명</strong><br></label>
	                                 <textarea class="form-control" id="signature" rows="4" name="programs"></textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>공연 소개</strong><br></label>
	                                 <textarea class="form-control" id="signature-1" rows="4" name="introduction"></textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>프로그램 노트</strong><br></label>
	                                 <textarea class="form-control" id="signature-2" rows="4" name="programNote"></textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>연관 패키지</strong><br></label>
	                                 <textarea class="form-control" id="signature-4" rows="4" name="relatedPackage"></textarea>
                                </div>
                                <div class="mb-3">
	                                 <label class="form-label" for="signature" style="margin-bottom:0;"><strong>메모</strong><br></label>
	                                 <textarea class="form-control" id="signature-3" rows="4" name="memo"></textarea>
                                </div>
                                
                                <div class="mb-3">
                                	<label class="form-label" for="signature" style="margin-bottom:0;"><strong>사진</strong><br></label>
                                	<input class="form-control" type="file" name="file">
                                </div>
                                 
                                
                            <button class="btn btn-primary" type="submit">등록하기</button>
                            </form>
                                <div class="mb-3"></div>
                                 
                                  
                                  
                                 <!-- 사진 등록 용량 안내 -->
                                  <script>
                                   document.getElementById('file').onchange=function(){
                                		var file = document.getElementById('file');
                                		var fileSize = file.files[0].size/1024/1024;
                                		document.getElementById("size").innerHTML = "("+(fileSize.toFixed(3))+"MB)";
                                		}
                                   

                                	document.getElementById('fileSubmitBtn').onclick=function(){
                                		var file = document.getElementById('file');
                                		var fileSize = file.files[0].size;
                                		if(fileSize>(50*1024*1024)){
                                			alert('업로드 가능한 최대 사이즈는 50MB입니다');
                                			return false;
                                		}else{
                                			return true;
                                		}
                                	};	
                                  </script>
                                  
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

