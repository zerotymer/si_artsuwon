<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
    <script>
        var result = ${requestScope['result']};
        if (result) {
            alert('결제가 정상적으로 완료되었습니다.');
            this.window.close();
        } else {
            alert('결제가 정상적으로 완료되지 않았습니다.');
            this.window.close();
        }
    </script>
</body>
</html>