$(document).ready(function() {
    const id = new URLSearchParams(window.location.search).get("id");
    console.log("userId : " + id);
    $.ajax({
        url: `/api/products/${id}`,
        method: "GET",
        success : function(data) {
            if(data) {
                $('#product-detail-container').html(`
                    <div>이름 : ${data.title}</div>
                    <div>이름 : ${data.description}</div>
                    <div>이름 : ${data.category}</div>
                    <div>이름 : ${data.price}</div>
                    <div>이름 : ${data.image}</div>
    
                `);
            } else {
                $('#product-detail-container').html('현재 데이터가 비어있습니다.');
            }
        },
        error: function(error) {
            alert('사용자 정보 가져오던 중 에러가 발생했습니다.');
        }

    })
})