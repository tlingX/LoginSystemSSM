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
    <form action="${pageContext.request.contextPath }/validate.action" method="post">
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
                <td colspan="2" align="center"><img src="${pageContext.request.contextPath }/ImageCreate.action" /></td> 
            </tr> 
            <tr> 
                <td> 请输入您所看到的字符 :</td> 
                <td><input type="text" name="japtcha" value="" />   <!-- 在session中保存了name属性的值japtcha -->
                    <%=request.getAttribute("ERROR") == null ? "" :       
                     request.getAttribute("ERROR")%>
                </td> 
            </tr> 
            
            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册" /></td>
            </tr>
        
        </table>
    </form>
  </body>
</html>
