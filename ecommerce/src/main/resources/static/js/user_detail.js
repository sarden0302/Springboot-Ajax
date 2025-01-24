$(document).ready(function() {
    const userId = new URLSearchParams(window.location.search).get("id");
    console.log("userId : " + userId);
    $.ajax({
        url: `/api/user/${userId}`,
        method: "GET",
        success : function(data) {
            if(data) {
                $('#user-detail-container').html(`
                    <p>${data.firstname} ${data.lastname}</p>
                    <p>${data.email}</p>
                    <p>${data.username}</p>
                    <p>${data.password}</p>
                    <p>${data.phone}</p>
                    <p>${data.city}</p>
                    <p>${data.street}</p>
                    <a href="/user/edit?id=${data.id}">정보 수정하기</a>
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