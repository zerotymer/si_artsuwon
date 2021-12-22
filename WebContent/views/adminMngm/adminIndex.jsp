<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.84.0">
    <title>관리자 로그인</title>
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/sign-in/">

    <!-- Bootstrap core CSS -->
	<link href="/assets/css/bootstrap.min.css" rel="stylesheet">

    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    <!-- Custom styles for this template -->
    <link href="/assets/css/adminLogin.css" rel="stylesheet">
  </head>
  
 <body class="text-center">
	<main class="form-signin">
  		<form action="/adminMngm/adminLogin.do" method="post">
	    	<img class="mb-4" src="/assets/images/adminLoginIcon.png" alt="" width="80" height="80">
	    	<h1 class="h3 mb-3 fw-normal" style="color:black"><b>사이트 관리자 로그인</b></h1>
	
		    <div class="form-floating" style="padding-bottom:3px;">
		      <input type="text" class="form-control" id="floatingInput" placeholder="Id" name="adminId">
		      <label for="floatingInput">아이디</label>
		    </div>
		    
		    <div class="form-floating">
		      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="adminPwd">
		      <label for="floatingPassword">비밀번호</label>
		    </div>
		    
		  
	    	<button class="w-100 btn btn-lg btn-primary" type="submit">로그인</button>
  		</form>
	</main>
    
  </body>
</html>
