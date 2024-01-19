<%-- 
    Document   : login
    Created on : Jan 18, 2024, 3:40:05 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login form</h1>
        <h3 style="color: red">${requestScope.error}</h3>
        <c:set var="cookie" value="${pageContext.request.cookies}"/>
        <form action="LoginServlet" method="post">
            Enter username:<input type="text" name="user"
                                  value="${cookie.cuser.value}"/><br/> 
            Enter password:<input type="password" name="pass"
                                  value="${cookie.cpass.value}"/><br/> 
            <input type="checkbox" 
                   ${(cookie.crem!=null?'checked':'')}name="rem" value="ON"/>Remember me<br/>
            <input type="submit" name="LOGIN"/> 
            <input type="reset" value="Reset"/><br/>
        </form>
        <a href="register.jsp">Click here to Sign Up</a>
    </body>
</html>
