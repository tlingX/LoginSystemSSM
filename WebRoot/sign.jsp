<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>注册</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/signin.action" method="post">
        <table border="2" align="center">
            <tr>
                <th>用户名</th>
                <td><input type="text" name="userName" /></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input type="password" name="pwd" /></td>
            </tr>
            <tr>
                <th>邮箱</th>
                <td><input type="text" name="email" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="提交" /></td>
            </tr>
        
        </table>
    </form>
  </body>
</html>
