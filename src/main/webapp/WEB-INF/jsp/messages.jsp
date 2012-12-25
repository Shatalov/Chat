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
        var UserIDT = "<%= request.getAttribute("userID") %>";
    </script>

    <TEXTAREA id="messageTextArea" name="TextArea" ROWS=30 COLS=70></TEXTAREA>

     <br>
    Select recipient
    <br>
    <input type="radio" name="IdRadioGroup" value="Default" id="IdDefault" checked/>To everybody
    <input type='radio' name='IdRadioGroup' value="Users" id="IdUsers"/> To receiver


    <select id="user_select" name="user_select">
        <%--<option value= 1 >Myself</option>--%>
    </select>

    <br>
    <br>
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

        setInterval(onTimeOutFunction, 1000);

        function onTimeOutFunction() {
            $.getJSON(
                    "/data/messages/" + UserIDT,
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

                            var resText = $('#messageTextArea').val() + textOut + "\n";

                            $('#messageTextArea').html(resText);

                        }
                    });
        }

        var NameSpaceName = function () {

            $("#postMessageBtn").click(function () {
                var messageText = $("#messageText").val();
                var allVal = 'toAll';
                var usVal = "userId";

                if ($("#IdDefault").is(":checked")) {
                    console.log("Sending to all");
                    var message = {text:messageText, toAll:true, toUserId:0, userIdM:UserIDT};
                } else {

                    var toUserId = $("#user_select option:selected").val();
                    var message = {text:messageText, toAll:false, toUserId:toUserId, userIdM:UserIDT};
                }

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
        }();



        $("#IdUsers").change(function getUsers() {
            if ($("#IdUsers").is(":checked")) {
//
                $.getJSON(
                        "/data/messages/users/" + UserIDT,
                        function (usersData) {
                            if (usersData == null) {
                            } else {
                                console.log("Users received: " + JSON.stringify(usersData));
                                console.log("One User: " + usersData[0].idUser + " " + usersData[0].nickName);

                                var select = $('#user_select');
                                if (select.prop) {
                                    var options = select.prop('options');
                                }
                                else {
                                    var options = select.attr('options');
                                }
                                $.each(usersData, function (i) {
                                    options[options.length] = new Option(usersData[i].nickName, usersData[i].idUser);
                                });

                            }
                        });
            }
        });


    });

</script>