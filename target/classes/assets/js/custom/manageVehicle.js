

var clickedRow = false;
var table;

$(document).ready(function(){

    table = $('#vehicleTable').DataTable( {
        processing : true,
        ajax: {
            url: "/vehicle/getAllVehicles",
            "type" : "POST",
            "data":function () {
                var vehicleSearchCriteria = {};
                vehicleSearchCriteria.vehicleRegNo = $( "#serchVehicleRegNo" ).val();
                return vehicleSearchCriteria;
            },
            dataSrc: function (json) {

                console.log(json.tableData);
                return json.tableData;
            }
        },
        columns: [
            { title: "id" , data: "id"},
            { title: "Reg No", data: "vehcleRegNo"},
            { title: "Type",data: "vehicleType" },
            { title: "Capacity", data: "vehicleCapacity" },
            { title: "Fuel Type.", data: "vehicleFuelType" },
            { title: "Owner", data: "vehicleUser" },
            { title: "Chassis No", data: "vehicleChassisNo" },
            { title: "Engine No",data : "vehicleEngineNo" },
            { title: "Model", data: "vehicleModel" },
            { title: "Milage", data: "vehicleMilage" },
            { title: "Status" ,data: "status" }
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
    $('#vehicleTable tbody').on('click', 'tr', function () {
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


  console.log("............. come to vehicle page");
    $( "#vehicleSave" ).click(function() {
      var vehicleDTO = {};
        vehicleDTO.vehcleRegNo = $( "#id" ).val();
        vehicleDTO.vehcleRegNo = $( "#vehcleRegNo" ).val();
        vehicleDTO.vehicleType = $( "#vehicleType" ).val();
        vehicleDTO.vehicleCapacity = $( "#vehicleCapacity" ).val();
        vehicleDTO.vehicleFuelType = $( "#vehicleFuelType" ).val();
        vehicleDTO.vehicleUser = $( "#vehicleUser" ).val();
        vehicleDTO.vehicleChassisNo = $( "#vehicleChassisNo" ).val();
        vehicleDTO.vehicleEngineNo = $( "#vehicleEngineNo" ).val();
        vehicleDTO.vehicleModel = $( "#vehicleModel" ).val();
        vehicleDTO.vehicleMilage = $( "#vehicleMilage" ).val();
        vehicleDTO.Status = $( "#status" ).val();

        $.ajax({
                url : '/vehicle/saveVehicle', // or whatever
                dataType : 'json',
                type: 'post',
                data: vehicleDTO,
                success : function (response) {
                    if(response.success){
                        alert("Successfully Saved the Vehicle ");
                        vehicleClear(true);
                    } else {
                        alert("Error Saving Vehicle  !!!");
                    }
                }
            })
        ;
    });

    $( "#vehicleUpdate" ).click(function() {
        var vehicleDTO = {};
        vehicleDTO.id = $( "#id" ).val();
        vehicleDTO.vehcleRegNo = $( "#vehcleRegNo" ).val();
        vehicleDTO.vehicleType = $( "#vehicleType" ).val();
        vehicleDTO.vehicleCapacity = $( "#vehicleCapacity" ).val();
        vehicleDTO.vehicleFuelType = $( "#vehicleFuelType" ).val();
        vehicleDTO.vehicleUser = $( "#vehicleUser" ).val();
        vehicleDTO.vehicleChassisNo = $( "#vehicleChassisNo" ).val();
        vehicleDTO.vehicleEngineNo = $( "#vehicleEngineNo" ).val();
        vehicleDTO.vehicleModel = $( "#vehicleModel" ).val();
        vehicleDTO.vehicleMilage = $( "#vehicleMilage" ).val();
        vehicleDTO.Status = $( "#status" ).val();

        $.ajax({
            url : '/vehicle/updateVehicle', // or whatever
            dataType : 'json',
            type: 'post',
            data: vehicleDTO,
            success : function (response) {
                if(response.success){
                    alert("Successfully Updated the Vehicle ");
                    vehicleClear(true);
                } else {
                    alert("Error Updating Vehicle  !!!");
                }
            }
        })
        ;
    });

    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    $( "#vehicleUpdate" ).hide();
    $( "#vehicleSave" ).show();

});

function vehicleAdd() {
    resetForm();
    disableFormData(false);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#vehicleSave" ).show();
    $( "#vehicleUpdate" ).hide();

}

function resetForm() {
    $(':input','#vehicleForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
}

function disableFormData(disable) {
    $("#vehcleRegNo").prop('disabled', disable);
    $("#vehicleType").prop('disabled', disable);
    $("#vehicleCapacity").prop('disabled', disable);
    $("#vehicleFuelType").prop('disabled', disable);
    $("#vehicleUser").prop('disabled', disable);
    $("#vehicleChassisNo").prop('disabled', disable);
    $("#vehicleEngineNo").prop('disabled', disable);
    $("#vehicleModel").prop('disabled', disable);
    $("#status").prop('disabled', disable);
    $("#vehicleMilage").prop('disabled', disable);

}

function fillFormData(row) {
    $("#id").val(row.id);
    $("#vehcleRegNo").val(row.vehcleRegNo);
    $("#vehicleType").val(row.vehicleType);
    $("#vehicleCapacity").val(row.vehicleCapacity);
    $("#vehicleFuelType").val(getFuelType(row.vehicleFuelType));
    $("#vehicleUser").val(row.vehicleUser);
    $("#vehicleChassisNo").val(row.vehicleChassisNo);
    $("#vehicleEngineNo").val(row.vehicleEngineNo);
    $("#vehicleModel").val(row.vehicleModel);
    $("#status").val(row.status);
    $( "#vehicleMilage" ).val(row.vehicleMilage);

}

function getFuelType(fuel) {
    var fuelVal;
    switch(fuel) {
        case "PETROL":
            fuelVal = "P";
            break;
        case "DIESEL":
            fuelVal = "D";
            break;
        case "HYBRID":
            fuelVal = "H";
            break;
        case "ELECTRIC":
            fuelVal = "E";
            break;
        default:
            fuelVal = "";
    }
    return fuelVal;

}

function disableUpdate(disable) {
    $("#vehicleUpdateButton").prop('disabled', disable);
    
}

function disableDelete(disable) {
    $("#vehicleDeleteButton").prop('disabled', disable);

}

function vehicleClear(disable) {
    $("#vehicleDeleteButton").prop('disabled', disable);
    resetForm();
    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#vehicleUpdate" ).hide();
    $( "#vehicleSave" ).show();

}

function vehicleUpdate(){
    if(clickedRow){
        disableFormData(true);
        $("#vehicleUser").prop('disabled', false);
        $("#status").prop('disabled', false);
        $("#vehicleMilage").prop('disabled', false);
        $( "#vehicleUpdate" ).show();
        $( "#vehicleSave" ).hide();

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function vehicleDelete(){
    if(clickedRow){
        if (confirm("Are you sure to delete the selected vehicle") == true) {
            var vehicleDTO = {};
            vehicleDTO.id = $( "#id" ).val();
            vehicleDTO.vehcleRegNo = $( "#vehcleRegNo" ).val();
            vehicleDTO.vehicleType = $( "#vehicleType" ).val();
            vehicleDTO.vehicleCapacity = $( "#vehicleCapacity" ).val();
            vehicleDTO.vehicleFuelType = $( "#vehicleFuelType" ).val();
            vehicleDTO.vehicleUser = $( "#vehicleUser" ).val();
            vehicleDTO.vehicleChassisNo = $( "#vehicleChassisNo" ).val();
            vehicleDTO.vehicleEngineNo = $( "#vehicleEngineNo" ).val();
            vehicleDTO.vehicleModel = $( "#vehicleModel" ).val();
            vehicleDTO.vehicleMilage = $( "#vehicleMilage" ).val();
            vehicleDTO.Status = $( "#status" ).val();
            $.ajax({
                url : '/vehicle/deleteVehicle', // or whatever
                dataType : 'json',
                type: 'post',
                data: vehicleDTO,
                success : function (response) {
                    if(response.success){
                        alert("Successfully deleted the Vehicle ");
                        vehicleClear(true);
                    } else {
                        alert("Error while deleting Vehicle  !!!");
                    }
                }
            })
            ;
        }

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function searchVehicle(){
    table.ajax.reload();
}



