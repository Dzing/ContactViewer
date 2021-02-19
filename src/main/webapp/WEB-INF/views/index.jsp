<%-- 
    Document   : index
    Created on : 16 февр. 2021 г., 23:16:07
    Author     : Balamut
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Contact viewer</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">   
        <script src="https://code.jquery.com/jquery-3.5.1.js" type="text/javascript"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js" type="text/javascript"></script>
        <script src="js/index.js" type="text/javascript"></script>
    </head>
    
    
    
    <body>

        <div id="menu">
            <button id="btNewRecord">СОЗДАТЬ</button>
            <button id="btRefresh">ОБНОВИТЬ</button>
        </div>
        
        <div id="mainGrid"> 
        <table id="contactsTable" class="display">

            <!-- Header Table -->
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Full name</th>
                    <th>Address</th>
                    <th>Phone number</th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            </tbody>
            <!-- Footer Table -->
            <tfoot>
                <tr>
                    <th>Id</th>
                    <th>Full name</th>
                    <th>Address</th>
                    <th>Phone number</th>
                    <th></th>
                    <th></th>
                </tr>
            </tfoot>
        
        </table>
        </div>
        
        
   
       
    </body>
    
    
</html>
