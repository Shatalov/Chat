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