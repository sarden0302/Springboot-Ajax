$(document).ready(function () {
    $.ajax({
        url: '/api/users',
        method: 'GET',
        success: function(users) {
            if (users) {
                let userInfo = '';
                $.each(users, function(index, user) {
                   userInfo += `
                   <p>${user.id}</p>
                   `;
                });
                $('#user-container').html(userInfo);
            } else {
                $('#user-container').html("현재 회원 수는 0명입니다.");
            }
        }, error: function () {
            alert('유저 정보 가져오던 중 문제가 발생했습니다. 잠시 후에 다시 시도해주세요.');
        }
    });
});