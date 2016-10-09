<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head>
  
  <body>
    成功的注册新用户
    ${requestScope.message}
    <%
       out.println("注册成功");
     %>
    
  </body>
</html>
