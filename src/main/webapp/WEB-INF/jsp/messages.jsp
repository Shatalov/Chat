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
     Select recipient

     <input type="radio" name="IdRadioGroup" value="Default" id="IdDefault" checked />To everybody
     <input type='radio' name='IdRadioGroup' value="Users"  id="IdUsers"/> To receiver


     <select id="user_select" name="user_select"/>

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
//        $("#testMessageBtn").click(function () {

//            var messageID = $("#messageId").val();
        setInterval(onTimeOutFunction, 5000);

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

                      var resText= $('#messageTextArea').val() + textOut + "\n";

                       $('#messageTextArea').html(resText);

                   }
            });
        }
        var NameSpaceName = function()
        {

            $("#postMessageBtn").click(function () {
                var messageText = $("#messageText").val();
                var allVal = 'toAll';
                var usVal = "userId";

                if( $("#IdDefault").is(":checked")) {
                  console.log("Sending to all");
                    var message = {text:messageText, toAll:true, toUserId:0,  userId:UserID};
                }else{

                    var toUserId = $("#user_select option:selected").val();
                    var message = {text:messageText, toAll:false, toUserId:toUserId,  userId:UserID};
                }
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

        $("#IdUsers").change(function setInvisibleSelect() {

            if( $("#IdDefault").is(":checked")) {
//                $("#user_select").attr("disabled","disabled");
                $("#user_select").disabled = true;
            }
        });

        $("#IdUsers").change(function getUsers() {
            if( $("#IdUsers").is(":checked")) {
                $("#user_select").disabled = false;
//                $("#user_select").attr("","");

                $.getJSON(
                    "/data/messages/users/"+ UserID,
                    function (usersData) {
                        if (usersData == null) {
                        } else {
                            console.log("Users received: "+ JSON.stringify(usersData));
                            console.log("One User: " + usersData[0].userId + " "+   usersData[0].nickName);
//                          (long userId, String nickName)

//                           // var data = JSON().parse(usersData);
//
//                            $.each(data, function(key, value) {
//                                $('#user_select').append($("", {
//                                    value: key,
//                                    text: value
//                                }));
//                            });

//                            var new_options = '';
//                            $.each(usersData, function(key, value) {
//                                new_options += '' + value + '';
//                            });
//                            $('#user_select').html(new_options);

                            var select = $('#user_select');
                               if(select.prop) {
                                var options = select.prop('options');
                            }
                        else {
                                var options = select.attr('options');
                            }
                            $.each(usersData, function(val, text) {
                                options[options.length] = new Option(text, val);
                            });
                        }
                    });
            }
        } );


    });

 </script>