$(document).ready(function () {
    $.ajax({
        url: '/api/products',
        method: 'GET',
        success:
            function (products) {
                if (products) {
                    let productInfo = '';
                    $.each(products, function(index, product) {
                        productInfo += `
                   <p>${product.id}</p>
                   `;
                    });
                    $('#product-container').html(productInfo);
                } else {
                    $('#product-container').html("현재 회원 수는 0명입니다.");
                }


            },
        error: function () {

        }
    });
});