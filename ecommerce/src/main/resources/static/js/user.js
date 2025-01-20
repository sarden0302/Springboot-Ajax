$(document).ready(function () {
    $.ajax({
        url: '/api/users',
        method: 'GET',
        success: function(users) {
            if (users) {
                let userInfo = '';
                $.each(users, function(index, user) {
                   userInfo += `
                    <div class="card">
                        <h3>${user.lastname}${user.firstname}</h3>
                        <p>user.phone</p>
                        <a href="/cart?userId=${user.id}">장바구니 확인하기</a>
                    </div>
                   `
                });
                $('#user-container').html(userInfo);
            } else {
                $('#user-container').html('<p>현재 회원 수는 0명입니다.</p>');
            }
        }, error: function () {
            $('#user-container').append('<p>서버에서 데이터를 가져올 수 없습니다.</p>')
            alert('유저 정보 가져오던 중 문제가 발생했습니다. 잠시 후에 다시 시도해주세요.');
        }
    });
});