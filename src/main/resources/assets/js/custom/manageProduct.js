/**
 * Created by RAVI KALUARACHCHI on 12/12/2017.
 */
/**
 * Created by RAVI KALUARACHCHI on 12/8/2017.
 */
//var clickedRow = false;
//var table;


$(document).ready(function(){

    table = $('#productTable').DataTable( {
        processing : true,
        ajax: {
            url: "/product/getAllProducts",
            "type" : "POST",
            "data":function () {
                var productSearchCriteria = {};
                productSearchCriteria.productId = $( "#searchProductId" ).val();
                return productSearchCriteria;
            },
            dataSrc: function (json) {

                console.log(json.tableData);
                return json.tableData;
            }
        },
        columns: [
            { title: "Product Id" , data: "productId"},
            { title: "Product Category", data: "productCategory"},
            { title: "Description",data: "productDescription" },
            { title: "Weight", data: "productWeight" },
            { title: "Product Name", data: "productName" },
            { title: "Profit", data: "productProfit" },
            { title: "Status", data:"productStatus"}
        ],
        columnDefs: [
            {
                targets: [ 0 ],
                visible: false,
                searchable: false
            }
        ]
    } );

    // table click event
    $('#productTable tbody').on('click', 'tr', function () {
        var data = table.row( this ).data();
        fillFormData(data);
        if ( $(this).hasClass('selected') ) {
            $(this).removeClass('selected');
            clickedRow = false;
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
            clickedRow = true;
        }
        disableUpdate(false);
        disableDelete(false);
    } );


    console.log("............. come to product page");
    $( "#productSave" ).click(function() {
        var productDTO = {};
        productDTO.productId = $( "#productId" ).val();
        productDTO.productCategory = $( "#productCategory" ).val();
        productDTO.productDescription = $( "#productDescription" ).val();
        productDTO.productWeight = $( "#productWeight" ).val();
        productDTO.productName = $( "#productName" ).val();
        productDTO.productProfit = $( "#productProfit" ).val();
        productDTO.productStatus = $("#productStatus").val();

        $.ajax({
            url : '/product/saveProduct', // or whatever
            dataType : 'json',
            type: 'post',
            data: productDTO,
            success : function (response) {
                if(response.success){
                    alert("Successfully Saved the Product ");
                    productClear(true);
                } else {
                    alert("Error Saving Product  !!!");
                }
            }
        })
        ;
    });

    $( "#productUpdate" ).click(function() {
        var productDTO = {};
        productDTO.productId = $( "#productId" ).val();
        productDTO.productCategory = $( "#productCategory" ).val();
        productDTO.productDescription = $( "#productDescription" ).val();
        productDTO.productWeight = $( "#productWeight" ).val();
        productDTO.productName = $( "#productName" ).val();
        productDTO.productProfit = $( "#productProfit" ).val();
        productDTO.productStatus = $("#productStatus").val();

        $.ajax({
            url : '/product/updateProduct', // or whatever
            dataType : 'json',
            type: 'post',
            data: productDTO,
            success : function (response) {
                if(response.success){
                    alert("Successfully Updated the Product ");
                    productClear(true);
                } else {
                    alert("Error Updating Product  !!!");
                }
            }
        })
        ;
    });

    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    $( "#productUpdate" ).hide();
    $( "#productSave" ).show();

});


function productAdd() {
    resetForm();
    disableFormData(false);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#productSave" ).show();
    $( "#productUpdate" ).hide();

}

function resetForm() {
    $(':input','#productForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
}

function disableFormData(disable) {
    $("#productId").prop('disabled', disable);
    $("#productCategory").prop('disabled', disable);
    $("#productDescription").prop('disabled', disable);
    $("#productWeight").prop('disabled', disable);
    $("#productName").prop('disabled', disable);
    $("#productProfit").prop('disabled', disable);
    $("#productStatus").prop('disabled', disable);


}

function fillFormData(row) {
    $("#productId").val(row.productId);
    $("#productCategory").val(row.productCategory);
    $("#productDescription").val(row.productDescription);
    $("#productWeight").val(row.productWeight);
    $("#productName").val(row.productName);
    $("#productProfit").val(row.productProfit);
    $("#productStatus").val(row.productStatus);
}


function disableUpdate(disable) {
    $("#productUpdateButton").prop('disabled', disable);

}

function disableDelete(disable) {
    $("#productDeleteButton").prop('disabled', disable);

}

function productClear(disable) {
    $("#productDeleteButton").prop('disabled', disable);
    resetForm();
    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#productUpdate" ).hide();
    $( "#productSave" ).show();

}

function productUpdate(){
    if(clickedRow){
        disableFormData(true);
        $("#productCategory").prop('disabled', false);
        $( "#productUpdate" ).show();
        $( "#productSave" ).hide();

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function productDelete(){
    if(clickedRow){
        if (confirm("Are you sure to delete the selected product") == true) {
            var productDTO = {};
            productDTO.productId = $( "#productId" ).val();
            productDTO.productCategory = $( "#productCategory" ).val();
            productDTO.productDescription = $( "#productDescription" ).val();
            productDTO.productWeight = $( "#productWeight" ).val();
            productDTO.productName = $( "#productName" ).val();
            productDTO.productProfit = $( "#productProfit" ).val();
            productDTO.productStatus = $( "#productStatus" ).val();
            
            $.ajax({
                url : '/product/deleteProduct', // or whatever
                dataType : 'json',
                type: 'post',
                data: productDTO,
                success : function (response) {
                    if(response.success){
                        alert("Successfully deleted the Product ");
                        productClear(true);
                    } else {
                        alert("Error while deleting Product  !!!");
                    }
                }
            })
            ;
        }

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function searchProduct(){
    table.ajax.reload();
}



