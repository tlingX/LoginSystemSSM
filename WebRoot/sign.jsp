<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <title>注册</title>
   
   <script type="text/javascript">
      function showInfo(){
           //alert("聚焦");
           //获取span元素
          var spanObject = document.getElementById("showinfo");
           // alert(spanObject);  //调试语句
           spanObject.innerHTML = "用户名至少6位，由字母、数字、下划线构成".fontcolor("green") ;
      }
      
      function hideInfo(){
           //alert("不聚焦");
           //获取到span元素
          var spanObject = document.getElementById("showinfo");
          //聚焦移除时，不显示任何的文本
          spanObject.innerHTML = "";
          
          //验证输入的用户名是否不够6位
          var inputValue = document.getElementById("userNameText").value;
          
           if(inputValue.length < 6){
               spanObject.innerHTML = "用户名小于6位，请重新输入用户名".fontcolor("red");
           }
          }
  </script>
  
  </head>
  
  <body>
  <div></div>   <!--这个部分占20% -->
   <div style="">   <!-- 这个部分设计整个注册界面放置的位置 -->
    <form action="${pageContext.request.contextPath }/validate.action" method="post">
        <table border="0" align="center" >
            <tr>
                <th>用户名</th>
                <td><input type="text" name="userName" onfocus="showInfo()" onblur="hideInfo()" id="userNameText" placeholder="用户名"/></td>
                <td colspan="1"><span id="showinfo"></span></td>
            </tr>
            <tr>
                <th>密码</th>
                <td><input type="password" name="pwd" placeholder="密码" /></td>
            </tr>
            <tr>
                <th>邮箱</th>
                <td><input type="text" name="email" placeholder="电子邮件地址" type="email" /></td>
            </tr>
            
            
            <tr> 
                <td colspan="2" align="center"><img src="${pageContext.request.contextPath }/ImageCreate.action" /></td> 
            </tr> 
            <tr> 
                <th> 请输入您所看到的字符</th> 
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
    </div>
  </body>
</html>
