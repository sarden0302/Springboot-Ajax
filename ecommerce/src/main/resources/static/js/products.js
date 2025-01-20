$(document).ready(function () {
    $.ajax({
        url: '/api/products',
        method: 'GET',
        success:
            function (products) {
                if (products) {
                    let productInfo = '';
                    $.each(products, function(index, product) {
                        console.log("index : " + index +", product : " + product)
                        productInfo += `
                        <div class="card">
                            <img src="${product.image}" alt="${product.title}">
                            <h3>${product.title}</h3>
                            <p>${product.price}</p>
                        </div>
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