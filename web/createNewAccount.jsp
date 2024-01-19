<%-- 
    Document   : createNewAccount
    Created on : Dec 21, 2023, 10:43:49 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
    </head>
    <body>
        <h1>Create New Account</h1>
<!--        <form action="DispatchServlet" method="POST">
            Username* <input type="text" name="txtUsername" value="${param.txtUsername}" /> (6 - 20 chars)<br/>
            <c:set var="errors" value="${requestScope.insertErr}"/>
            <c:if test="${not empty errors.usernameLengthErr}">
                <font color="red">
                    ${errors.usernameLengthErr}
                </font><br/>
            </c:if>      
            Password* <input type="password" name="txtPassword" value="" />(6 - 30 chars)<br/>
            <c:if test="${not empty errors.passwordLengthErr}">
                <font color="red">
                    ${errors.passwordLengthErr}
                </font><br/>
            </c:if>
            Confirm* <input type="password" name="txtConfirm" value="" /><br/>
            <c:if test="${not empty errors.confirmNotMatch}">
                <font color="red">
                    ${errors.confirmNotMatch}
                </font><br/>
            </c:if>
            Full name* <input type="text" name="txtFullname" value="" />(2 - 50 chars)<br/>
            <c:if test="${not empty errors.fullnameLengthErr}">
                <font color="red">
                    ${errors.fullnameLengthErr}
                </font><br/>
            </c:if>
            <input type="submit" value="Create New Account" name="btAction" />
            <input type="reset" value="Reset" />
        </form>-->
            <c:if test="${errors.usernameIsExist}">
                <font color="red">
                    ${errors.usernameIsExist}
                </font><br/>
            </c:if>
        
    </body>
</html>
