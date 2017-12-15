/**
 * Created by RAVI KALUARACHCHI on 11/28/2017.
 */
//var clickedRow = false;
//var table;

$(document).ready(function(){

    table = $('#employeeTable').DataTable( {
        processing : true,

        ajax: {
            url: "/employee/getAllEmployees",
            "type" : "POST",
            "data":function () {
                var employeeSearchCriteria = {};
                employeeSearchCriteria.id1 = $( "#serchid1" ).val();
                return employeeSearchCriteria;
            },
            dataSrc: function (json) {

                console.log(json.tableData);
                return json.tableData;
            }
        },

        columns: [
            { title: "id" , data: "id1"},
            { title: "First Name",data: "employeeFirstName" },
            { title: "Last Name",data: "employeeLastName" },
            { title: "NIC", data: "employeeNIC"},
            { title: "EPF No", data: "employeeEPF"},

            { title: "Address", data: "employeeAddress1" },
            //{ title: "Address", data: "employeeAddress2" },
            //{ title: "Address", data: "employeeAddress3" },
            { title: "Phone No",data : "employeePhoneNumber" },
            { title: "Mobile No",data : "employeeMobileNumber" },
            { title: "Basic Salary",data : "employeeBasicSalary" },
            { title: "Allowance",data : "employeeAllowance" },
            { title: "Email", data: "employeeEmail" },
            { title: "Designation", data: "employeeDesignation" },
            { title: "Status", data: "status" }

        ],
        columnDefs: [
            {
                targets: [ 0 ],
                visible: false,
                searchable: false
            },
            {
                targets: [ 2 ],
                visible: false,
                searchable: false
            },
            {
                targets: [ 3 ],
                visible: false,
                searchable: false
            },
            {
                targets: [ 5 ],
                visible: false,
                searchable: false
            }

        ]
    } );


    //employee table click event
    $('#employeeTable tbody').on ('click', 'tr', function () {
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


$( "#employeeSave" ).click(function() {
    var employeeDTO = {};
    employeeDTO.employeeFirstName = "adsada";
    employeeDTO.employeeLastName = $("#employeeLastName").val();
    employeeDTO.employeeNIC = $("#employeeNIC").val();
    employeeDTO.employeeEpfNo = $("#employeeEPF").val();
    employeeDTO.employeeAddress1 = $("#employeeAddress1").val();
    employeeDTO.employeeAddress2 = $("#employeeAddress2").val();
    employeeDTO.employeeAddress3 = $("#employeeAddress3").val();
    employeeDTO.employeePhoneNumber = $("#employeePhoneNumber").val();
    employeeDTO.employeeMobileNumber = $("#employeeMobileNumber").val();
    employeeDTO.employeeEmail = $("#employeeEmail").val();
    employeeDTO.employeeBasicSalary = $("#employeeBasicSalary").val();
    employeeDTO.employeeAllowance = $("#employeeAllowance").val();
    employeeDTO.employeeDesignation = $("#employeeDesignation").val();
    employeeDTO.Status = $("#status").val();


    $.ajax({
        url : '/employee/saveEmployees', // or whatever
        dataType : 'json',
        type: 'post',
        data: employeeDTO,
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

    alert("complete Saving Employee  !!!");

});



$( "#employeeUpdate" ).click(function() {
    var employeeDTO = {};
    employeeDTO.id = $( "#id1" ).val();
    employeeDTO.employeeFirstName = $( "#employeeFirstName" ).val();
    employeeDTO.employeeLastName = $( "#employeeLastName" ).val();
    employeeDTO.employeeNIC = $( "#employeeNIC" ).val();
    employeeDTO.employeeEpfNo = $("#employeeEPF").val();
    employeeDTO.employeeAddress1 = $( "#employeeAddress1" ).val();
    //employeeDTO.employeeAddress2 = $( "#employeeAddress2" ).val();
    //employeeDTO.employeeAddress3 = $( "#employeeAddress3" ).val();
    employeeDTO.employeePhoneNumber = $( "#employeePhoneNumber" ).val();
    employeeDTO.employeeMobileNumber = $( "#employeeMobileNumber" ).val();
    employeeDTO.employeeEmail = $( "#employeeEmail" ).val();
    employeeDTO.employeeBasicSalary = $( "#employeeBasicSalary" ).val();
    employeeDTO.employeeAllowance = $( "#employeeAllowance" ).val();
    employeeDTO.employeeDesignation = $( "#employeeDesignation" ).val();
    employeeDTO.Status = $( "#status" ).val();

    $.ajax({
        url : '/employee/updateEmployee', // or whatever
        dataType : 'json',
        type: 'post',
        data: employeeDTO,
        success : function (response) {
            if(response.success){
                alert("Successfully Updated the Employee ");
                employeeClear(true);
            } else {
                alert("Error Updating Employee  !!!");
            }
        }
    })
    ;
    });

    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    $( "#employeeUpdate" ).hide();
    $( "#employeeSave" ).show();
});

    function employeeAdd() {
        resetForm();
        disableFormData(false);
        disableUpdate(true);
        disableDelete(true);
        table.ajax.reload();
        $( "#employeeSave" ).show();
        $( "#employeeUpdate" ).hide();

    }

    function resetForm() {
        $(':input','#employeeForm')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .removeAttr('checked')
            .removeAttr('selected');
    }

    function disableFormData(disable) {
        $("#employeeFirstName").prop('disabled', disable);
        $("#employeeLastName").prop('disabled', disable);
        $("#employeeNIC").prop('disabled', disable);
        $("#employeeEPF").prop('disabled',disable);
        $("#employeeAddress1").prop('disabled', disable);
        //$("#employeeAddress2").prop('disabled', disable);
        //$("#employeeAddress3").prop('disabled', disable);
        $("#employeePhoneNumber").prop('disabled', disable);
        $("#employeeMobileNumber").prop('disabled', disable);
        $("#employeeEmail").prop('disabled', disable);
        $("#employeeBasicSalary").prop('disabled', disable);
        $("#employeeAllowance").prop('disabled', disable);
        $("#employeeDesignation").prop('disabled', disable);
        $("#status").prop('disabled', disable);


    }

    function fillFormData(row) {
        $("#id1").val(row.id);
        $("#employeeFirstName").val(row.employeeFirstName);
        $("#employeeLastName").val(row.employeeLastName);
        $("#employeeNIC").val(row.employeeNIC);
        $("#employeeEPF").val(row.employeeEpfNo);
        $("#employeeAddress1").val(row.employeeAddress1);
        //$("#employeeAddress2").val(row.employeeAddress2);
        //$("#employeeAddress3").val(row.employeeAddress3);
        $("#employeePhoneNumber").val(row.employeePhoneNumber);
        $("#employeeMobileNumber").val(row.employeeMobileNumber);
        $("#employeeEmail").val(row.employeeEmail);
        $("#employeeBasicSalary").val(row.employeeBasicSalary);
        $("#employeeAllowance").val(row.employeeAllowance);
        $("#employeeDesignation").val(row.employeeDesignation);
        $("#status").val(row.status);


    }

function disableUpdate(disable) {
    $("#employeeUpdateButton").prop('disabled', disable);

}

function disableDelete(disable) {
    $("#employeeDeleteButton").prop('disabled', disable);

}

function employeeClear(disable) {
    $("#employeeDeleteButton").prop('disabled', disable);
    resetForm();
    disableFormData(true);
    disableUpdate(true);
    disableDelete(true);
    table.ajax.reload();
    $( "#employeeUpdate" ).hide();
    $( "#employeeSave" ).show();

}

function employeeUpdate(){
    if(clickedRow){
        disableFormData(true);
        $("#status").prop('disabled', false);
        $( "#employeeUpdate" ).show();
        $( "#employeeSave" ).hide();

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function employeeDelete(){
    if(clickedRow){
        if (confirm("Are you sure to delete the selected vehicle") == true) {
            var employeeDTO = {};
            employeeDTO.id1 = $( "#id1" ).val();
            employeeDTO.employeeFirstName = $( "#employeeFirstName" ).val();
            employeeDTO.employeeLastName = $( "#employeeLastName" ).val();
            employeeDTO.employeeNIC = $( "#employeeNIC" ).val();
            employeeDTO.employeeEpfNo = $("#employeeEPF").val();
            employeeDTO.employeeAddress1 = $( "#employeeAddress1" ).val();
            //employeeDTO.employeeAddress2 = $( "#employeeAddress2" ).val();
            //employeeDTO.employeeAddress3 = $( "#employeeAddress3" ).val();
            employeeDTO.employeePhoneNumber = $( "#employeePhoneNumber" ).val();
            employeeDTO.employeeMobileNumber = $( "#employeeMobileNumber" ).val();
            employeeDTO.employeeEmail = $( "#employeeEmail" ).val();
            employeeDTO.employeeBasicSalary = $( "#employeeBasicSalary" ).val();
            employeeDTO.employeeAllowance = $( "#employeeAllowance" ).val();
            employeeDTO.employeeDesignation = $( "#employeeDesignation" ).val();
            employeeDTO.Status = $( "#status" ).val();
            $.ajax({
                url : '/employee/deleteEmployee', // or whatever
                dataType : 'json',
                type: 'post',
                data: employeeDTO,
                success : function (response) {
                    if(response.success){
                        alert("Successfully deleted the Employee ");
                        employeeClear(true);
                    } else {
                        alert("Error while deleting Employee  !!!");
                    }
                }
            })
            ;
        }

    } else {
        alert("Please Select a Row first !!!!");
    }
}

function searchEmployee(){
    table.ajax.reload();
}


