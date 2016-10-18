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
   
      function showInfo(){   //该函数实现当鼠标点击时，会显示附加的信息
           //alert("聚焦");
           //获取span元素
          var spanObject = document.getElementById("showinfo");
           // alert(spanObject);  //调试语句
           spanObject.innerHTML = "用户名至少6位，由字母、数字、下划线构成".fontcolor("green") ;
      }
      
      function hideInfo(){    //该函数实现当鼠标不聚焦时，会显示附加的信息
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
      function refreshWindows(){   //该函数的未注释的部分实现了局部刷新功能，注释掉的部分实现的是整个window窗口的刷新
           //alert("哈哈");
           //点击图片刷新
           //window.location.reload();   //这些功能在后续都想要替换，看能不能只刷新局部，目前看来使用JS不能实现
           document.getElementsByTagName("img")[0].setAttribute("src", "${pageContext.request.contextPath }/ImageCreate.action");
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
                <td><input type="text" name="userName"  id="userNameText" placeholder="用户名"/></td>
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
                <!-- 设置当鼠标移动到该段文字上时，变成一个小手形状，当点击文字时，刷新验证码 -->
                <td style="cursor:pointer;" ><a onclick="refreshWindows()"><font size="1px" color="green">看不清楚？点击换一张</font></a></td> 
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
