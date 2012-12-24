<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<html>
<head>
    <script src="http://code.jquery.com/jquery.js"></script>
    <%--&lt;%&ndash;<script src="${pageContext.request.servletPath}../../../js/messages.js"></script>&ndash;%&gt;--%>
    <%--<script src="<c:url value="/js/messages.js"/>"></script>--%>
    <%--<script src="../../js/messages.js"></script>--%>
    <%--<script src="/js/messages.js"></script>--%>

</head>

<body>
 <div align='center'>
    <h1>Chat</h1>

    <script language="javascript">
        var UserID = "<%= request.getAttribute("userID") %>";
    </script>

    <br>

    <TEXTAREA id="messageTextArea" ROWS=300 COLS=72></TEXTAREA>
    <br>

    <%--<input type="text" id="messageId"/>--%>
    <%--<button id="testMessageBtn">Find message</button>--%>

     Enter you message
    <input type="text" size=72 id="messageText"/>
     <br>
    <button id="postMessageBtn">Post</button>
      <br>
   </div>
</body>
</html>


<script language="javascript">
    $(function () {
        console.log("Setting up the client-side services...");
        $("#testMessageBtn").click(function () {

            var messageID = $("#messageId").val();

            $.get("/data/messages/" + messageID, function (data) {
                console.log("Message processed successfully");
                console.log("Object received: " + JSON.stringify(data));
            });
        });

        $("#postMessageBtn").click(function () {
            var messageText = $("#messageText").val();
            var message = {text:messageText, userId:666};
            var messageString = JSON.stringify(message);
            $.ajax({
                        type:"POST",
                        url:"/data/messages/",
                        contentType:"application/json; charset=utf-8",
                        data:messageString,
                        success:function () {
                            console.log("Message has been successfully posted");
                        }

                    }
            );
        });
    });
</script>