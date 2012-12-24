<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <script src="http://code.jquery.com/jquery.js"></script>
    <%--<script src="${pageContext.request.servletPath}../../../js/messages.js"></script>--%>
    <%--<script src="../js/messages.js"></script>--%>
    <script src="/js/messages.js"></script>

</head>

<body>

<h1>Messages page</h1>

fhfhfhf
<script language="javascript">
    var UserID = "<%= request.getAttribute("userIDDDD") %>";
//     alert(UserID);
    var Us = "Fafa";
</script>

<br>
<form:form commandName="user">
    <table>
        <tr>
            <td>First Name:</td>
            <td><form:input path="userId" /></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><form:input path="nickName" /></td>
        </tr>
        <%--<tr>--%>
            <%--<td colspan="3">--%>
                <%--<input type="submit" value="Save Changes" />--%>
            <%--</td>--%>
        <%--</tr>--%>
    </table>
</form:form>


<TEXTAREA id="messageTextArea" ROWS=5 COLS=72></TEXTAREA>
<br>

<input type="text" id="messageId"/>
<button id="testMessageBtn">Find message</button>

<input type="text" id="messageText"/>
<button id="postMessageBtn">Post</button>



</body>
</html>
