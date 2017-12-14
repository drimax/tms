/**
 * Created by RAVI KALUARACHCHI on 12/8/2017.
 */
//var clickedRow = false;
//var table;


$(document).ready(function(){

    table = $('#routeTable').DataTable( {
        processing : true,
        ajax: {
            url: "/route/getAllRoutes",
            "type" : "POST",
            "data":function () {
                var routeSearchCriteria = {};
                routeSearchCriteria.routeId = $( "#searchRouteId" ).val();
                return routeSearchCriteria;
            },
            dataSrc: function (json) {

                console.log(json.tableData);
                return json.tableData;
            }
        },
        columns: [
            { title: "route Id" , data: "routeId"},
            { title: "Route Name", data: "routeName"},
            { title: "Origin",data: "routeOrigin" },
            { title: "Destination", data: "routeDestination" },
            { title: "Distance", data: "routeDistance" },
            { title: "Duration", data: "routeDuration" },
            { title: "Status" ,data: "routeStatus" }
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
    $('#routeTable tbody').on('click', 'tr', function () {
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
    $( "#routeSave" ).click(function() {
        var routeDTO = {};
        routeDTO.routeId = $( "#routeId" ).val();
        routeDTO.routeName = $( "#routeName" ).val();
        routeDTO.routeOrigin = $( "#routeOrigin" ).val();
        routeDTO.routeDestination = $( "#routeDestination" ).val();
        routeDTO.routeDistance = $( "#routeDistance" ).val();
        routeDTO.routeDuration = $( "#routeDuration" ).val();
        routeDTO.routeStatus = $( "#routeStatus" ).val();

        $.ajax({
            url : '/route/saveRoute', // or whatever
            dataType : 'json',
            type: 'post',
            data: routeDTO,
            success : function (response) {
                if(response.success){
                    alert("Successfully Saved the Route ");
                    routeClear(true);
                } else {
                    alert("Error Saving Route  !!!");
                }
            }
        })
        ;
    });

    $( "#routeUpdate" ).click(function() {
        var routeDTO = {};
        routeDTO.routeId = $( "#routeId" ).val();
        routeDTO.routeName = $( "#routeName" ).val();
        routeDTO.routeOrigin = $( "#routeOrigin" ).val();
        routeDTO.routeDestination = $( "#routeDestination" ).val();
        routeDTO.routeDistance = $( "#routeDistance" ).val();
        routeDTO.routeDuration = $( "#routeDuration" ).val();
        routeDTO.status = $( "#routeStatus" ).val();

        $.ajax({
            url : '/route/updateRoute', // or whatever
            dataType : 'json',
            type: 'post',
            data: routeDTO,
            success : function (response) {
                if(response.success){
                    alert("Successfully Updated the Route ");
                    routeClear(true);
                } else {
                    alert("Error Updating Route  !!!");
                }
            }
        })
        ;
    });

    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    $( "#routeUpdate" ).hide();
    $( "#routeSave" ).show();

});


function routeAdd() {
    resetForm();
    disableFormData(false);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#routeSave" ).show();
    $( "#routeUpdate" ).hide();

}

function resetForm() {
    $(':input','#routeForm')
        .not(':button, :submit, :reset, :hidden')
        .val('')
        .removeAttr('checked')
        .removeAttr('selected');
}

function disableFormData(disable) {
    $("#routeName").prop('disabled', disable);
    $("#routeOrigin").prop('disabled', disable);
    $("#routeDestination").prop('disabled', disable);
    $("#routeDistance").prop('disabled', disable);
    $("#routeDuration").prop('disabled', disable);
    $("#routeStatus").prop('disabled', disable);


}

function fillFormData(row) {
    $("#routeId").val(row.routeId);
    $("#routeName").val(row.routeName);
    $("#routeOrigin").val(row.routeOrigin);
    $("#routeDestination").val(row.routeDestination);
    $("#routeDistance").val(row.routeDistance);
    $("#routeDuration").val(row.routeDuration);
    $("#routeStatus").val(row.status);

}


function disableUpdate(disable) {
    $("#routeUpdateButton").prop('disabled', disable);

}

function disableDelete(disable) {
    $("#routeDeleteButton").prop('disabled', disable);

}

function routeClear(disable) {
    $("#routeDeleteButton").prop('disabled', disable);
    resetForm();
    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#routeUpdate" ).hide();
    $( "#routeSave" ).show();

}

function routeUpdate(){
    if(clickedRow){
        disableFormData(true);
        $("#routeDuration").prop('disabled', false);
        $("#status").prop('disabled', false);
        $("#routeDistance").prop('disabled', false);
        $( "#routeUpdate" ).show();
        $( "#routeSave" ).hide();

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function routeDelete(){
    if(clickedRow){
        if (confirm("Are you sure to delete the selected route") == true) {
            var routeDTO = {};
            routeDTO.routeId = $( "#routeId" ).val();
            routeDTO.routeName = $( "#routeName" ).val();
            routeDTO.routeOrigin = $( "#routeOrigin" ).val();
            routeDTO.routeDestination = $( "#routeDestination" ).val();
            routeDTO.routeDistance = $( "#routeDistance" ).val();
            routeDTO.routeDuration = $( "#routeDuration" ).val();
            routeDTO.status = $( "#routeStatus" ).val();
            $.ajax({
                url : '/route/deleteRoute', // or whatever
                dataType : 'json',
                type: 'post',
                data: routeDTO,
                success : function (response) {
                    if(response.success){
                        alert("Successfully deleted the Route ");
                        routeClear(true);
                    } else {
                        alert("Error while deleting Route  !!!");
                    }
                }
            })
            ;
        }

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function searchRoute(){
    table.ajax.reload();
}



