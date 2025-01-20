$(document).ready(function () {
    const userId = new URLSearchParams(window.location.search).get('userId');


    $.ajax({
        url: `/api/carts?userId=${userId}`,
        method: 'GET',
        success: function (carts) {
            if (carts) {
                let cartInfo = '';
                $.each(carts, function(index, cart) {
                    cartInfo += `
                       <div class="card">
                            <h3>${cart.title}</h3>
                            <h3>${cart.price}</h3>
                            <h3>${cart.quantity}</h3>
                       </div>
                   `;
                });
                $('#cart-container').html(cartInfo);

            } else {
                $('#cart-container').html("현재 장바구니는 비어있습니다.");
            }
        },
        error: function () {
            alert('장바구니 데이터를 불러올 수 없습니다.');
        }
    });
});