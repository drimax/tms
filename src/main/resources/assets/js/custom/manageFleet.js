/**
 * Created by RAVI KALUARACHCHI on 12/14/2017.
 */


$(document).ready(function(){


    var selectRoute = $("#selectRoute");

    $.ajax({
        url : '/route/getAllRoutes', // or whatever
        dataType : 'json',
        type: 'post',
        success : function (response) {
                $.each(response.tableData, function() {
                    selectRoute.append($("<option />").val(this.routeId).text(this.routeName));
                });

        }
    })

    var selectProduct = $("#selectProduct");

    $.ajax({
        url : '/product/getAllProducts', // or whatever
        dataType : 'json',
        type: 'post',
        success : function (response) {
            $.each(response.tableData, function() {
                selectProduct.append($("<option />").val(this.productId).text(this.productName));
            });

        }
    })

    var selectVehicle = $("#selectVehicle");

    $.ajax({
        url : '/vehicles/getAllVehicles', // or whatever
        dataType : 'json',
        type: 'post',
        success : function (response) {
            $.each(response.tableData, function() {
                selectVehicle.append($("<option />").val(this.Id).text(this.vehicleRegNo));
            });

        }
    })
});

