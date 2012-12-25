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

     <TEXTAREA id="messageTextArea" name="TextArea" ROWS=30 COLS=70></TEXTAREA>

    <%--<input type="text" id="messageId"/>--%>
    <%--<button id="testMessageBtn">Find message</button>--%>
     <br>
     Enter you message
    <input type="text" size=60 id="messageText"/>
     <br>
    <button id="postMessageBtn">Post</button>
      <br>
   </div>
</body>
</html>


<script language="javascript">
    $(function () {
        console.log("Setting up the client-side services...");
//        $("#testMessageBtn").click(function () {

//            var messageID = $("#messageId").val();
        setInterval(onTimeOutFunction, 10000);

        function onTimeOutFunction(){
            $.getJSON(
            "/data/messages/" + UserID,
               function (data) {
                   if (data == null) {
                   } else {
                       console.log("Message processed successfully");
                       console.log("Object received: " + JSON.stringify(data));

                       var textOut = data.userNickPostedMessage + " : ";

                       if (data.toAllResp == false) {
                           textOut += data.toUserNick + " : ";
                       }
                       textOut += data.textResp;

                       $('#messageTextArea').val($('#messageTextArea').val() + textOut );

                   }
            });
        }
        var NameSpaceName = function()
        {

            $("#postMessageBtn").click(function () {
                var messageText = $("#messageText").val();
                var allVal = 'toAll';
                var usVal = "userId";
                var message = {text:messageText, toAll:true, toUserId:333,  userId:UserID};
    //            var message = {text:messageText, userId:UserID};
                var messageString = JSON.stringify(message);

    //            (String text, boolean toAll, long toUserId, long userId)
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
           }();

    });
</script>