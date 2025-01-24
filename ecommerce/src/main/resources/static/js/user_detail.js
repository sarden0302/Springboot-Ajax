$(document).ready(function() {
    const userId = new URLSearchParams(window.location.search).get("id");
    console.log("userId : " + userId);
    $.ajax({
        url: `/api/user/${userId}`,
        method: "GET",
        success : function(data) {
            if(data) {
                $('#user-detail-container').html(`
                    
                `);
            } else {
                $('#user-detail-container').html('현재 데이터가 비어있습니다.');
            }
        },
        error: function(error) {
            alert('사용자 정보 가져오던 중 에러가 발생했습니다.');
        }

    })
})