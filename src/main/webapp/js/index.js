/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Get the modal
//var modal = document.getElementById("myModal");
//
//// Get the button that opens the modal
//var btn = document.getElementById("myBtn");
//
//// Get the <span> element that closes the modal
//var span = document.getElementsByClassName("close")[0];
//
//// When the user clicks the button, open the modal 
//btn.onclick = function() {
//  modal.style.display = "block";
//};
//
//// When the user clicks on <span> (x), close the modal
//span.onclick = function() {
//  modal.style.display = "none";
//};
//
//// When the user clicks anywhere outside of the modal, close it
//window.onclick = function(event) {
//  if (event.target === modal) {
//    modal.style.display = "none";
//  }
//};

/////////////////////////////////////////////

function initHandlers() {
    
    $("#btRefresh").on("click", function(){
        console.log("#btRefresh.click");
        refreshGrid();
    });
    
    $("#btNewRecord").on("click", function(){
        console.log("#btNewRecord.click");
        openForm('Insert');
    });
    
    $('#contactsTable').on('click', '.btTabDelete', function(){
        console.log("#contactsTable.click.btTabDelete");
        var row = $(this).closest("tr");
        var valId=row.find(".c_r_id").text();
        console.log("ID = "+valId);
        handleDelete(valId);
        //row.empty();
    });
    
    $('#contactsTable').on('click', '.btTabUpdate', function(){
        console.log("#contactsTable.click.btTabUpdate");
        var row = $(this).closest("tr");
        var valId=row.find(".c_r_id").text();
        var valFullName=row.find(".c_r_full_name").text();
        var valAddress=row.find(".c_r_address").text();
        var valPhone=row.find(".c_r_phone").text();
        console.log("ID = "+valId);
        openForm('Update', valId, valFullName, valAddress, valPhone);
    });

}

function openForm(modeName, pId=0, pFullName="", pAddress="", pPhone="") {
     $(' <div class="form-style-6">\n\
        <form>\n\
            <input id="inId" type="text" name="id" hidden >\n\
            <input id="inFullName" type="text" name="fullName" placeholder="ФИО">\n\
            <input id="inPhone"  type="text" name="phoneN" placeholder="Номер телефона">\n\
            <input id="inAddress" type="text" name="address" placeholder="Адрес">\n\
            <br>\n\
        </form>\n\
        </div>').dialog({
            modal: true ,
            dialogClass: "commit"+modeName,
            buttons: [{
                    text: "ЗАПИСАТЬ",
                    click: function () {
                        var dialogClass = $(this).dialog( "option", "dialogClass" );

                        var valId = $('#inId').val();
                        var valFullName = $('#inFullName').val();
                        var valPhone = $('#inPhone').val();
                        var valAddress = $('#inAddress').val();

                        if (dialogClass==='commitInsert') { 
                            console.log('Create');
                            handleInsert(valFullName, valAddress, valPhone);
                        };

                        if (dialogClass==='commitUpdate') { 
                            console.log('Update');
                            handleUpdate(valId, valFullName, valAddress, valPhone);
                        };

                        $(this).dialog('close');
                    }
                }],
            open: function(event, ui) {
                $(this).find('input[name="id"]').val(pId);
                $(this).find('input[name="fullName"]').val(pFullName);
                $(this).find('input[name="phoneN"]').val(pPhone);
                $(this).find('input[name="address"]').val(pAddress);
            }
        });
}

function handleList(data) {
    $('#contactsTable tr[class="rowData"]').remove();
    $(data).each(function(name, value) {
        console.log('handleList -- value='+value);
        var tableRow=
           '<tr class="rowData">\n\
                <td class="c_r_id">'+value.id+'</td>\n\
                <td class="c_r_full_name">'+value.fullName+'</td>\n\
                <td class="c_r_address">'+value.address+'</td>\n\
                <td class="c_r_phone">'+value.phoneNumber+'</td>\n\
                <td><button class="btTabUpdate" type="button">ИЗМЕНИТЬ</button></td>\n\
                <td><button class="btTabDelete" type="button">УДАЛИТЬ</button></td>\n\
            </tr>';
        $("#contactsTable").append(tableRow);
    });
    //tableRow = tableRow+'<td><button class="btTabUpdate" type="button">ИЗМЕНИТЬ</button></td><td><button class="btTabDelete" type="button">УДАЛИТЬ</button></td></tr>';
    //$("#contactsTable").append(tableRow);
};

function handleDelete(pId) {
    $.ajax({
       type: "POST",
       url: document.URL+"delete",
       data: {id:pId},
       dataType: "json"
    })
    .always(function(){
        refreshGrid();
    })
}

function handleInsert(pFullName, pAddress, pPhone) {
    $.ajax({
       type: "POST",
       url: document.URL+"add",
       data: {fullName: pFullName, address: pAddress, phone: pPhone},
       dataType: "json"
    })
    .always(function(){
        refreshGrid();
    })

}

function handleUpdate(pId, pFullName, pAddress, pPhone) {
    $.ajax({
       type: "POST",
       url: document.URL+"edit",
       data: {id:pId, fullName: pFullName, address: pAddress, phone: pPhone},
       dataType: "json"
    })
    .always(function(){
        refreshGrid();
    })
}

function refreshGrid() {
    
     $.ajax({
        type: "GET",
        url: document.URL+"list",
        dataType: "json"
    })
    .done(function(response){
        handleList(response);

    })
    .fail(function (xhr, status, errorThrown) {
        console.log( "ERR: "+xhr);
        console.log( "ERR: "+status);
        console.log( "ERR: "+errorThrown);
    }); 
    
}

$( document ).ready(function() {
    console.log( "ready! || docURL :" + document.URL );
    initHandlers();
    refreshGrid();
})





