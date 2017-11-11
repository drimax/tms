


$(document).ready(function(){

    $('#vehicleTable').DataTable( {
        processing : true,
        ajax: {
            url: "/vehicle/getAllVehicles",
            "type" : "GET",
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
        vehicleDTO.Status = $( "#Status" ).val();

        $.ajax({
                url : '/vehicle/saveVehicle', // or whatever
                dataType : 'json',
                type: 'post',
                data: vehicleDTO,
                success : function (response) {
                    alert("The server says: " + response.success);
                }
            })
        ;
    });

});

