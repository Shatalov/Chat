$(document).ready(function () {

    console.log("In the enterChat.js");

    $("#nickNameEnterBtn").click(function () {
        console.log("User clicked the Enter button!");
        var nickNameVal = $("#nickName").val();
        var nickName = {nickName: nickNameVal};

        $.ajax({
                type: "GET",
                url: "./data/userNickName/",
                contentType: "application/json; charset=utf-8",
                data: nickName,
                success: function () {
                    console.log("User has successfully given his data");
                }

            }
        );
    });
 });