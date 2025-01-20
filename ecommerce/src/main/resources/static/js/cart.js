$(document).ready(function () {
    const userId = new URLSearchParams(window.location.search).get('userId');

    $.ajax({
        url: `/api/carts?userId=1`,
        method: 'GET',
        success: function (carts) {
            if (carts) {
                let cartInfo = '';
                $.each(carts, function(index, cart) {
                    cartInfo += `
                   <p>${cart.cartId}</p>
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