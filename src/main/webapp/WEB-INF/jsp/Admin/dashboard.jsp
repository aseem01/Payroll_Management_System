<%-- 
    Document   : dashboard
    Created on : Apr 16, 2019, 2:37:11 PM
    Author     : Ashim Chakraborty
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payroll|DashBoard</title>
         <%@include file="head.jsp"%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    </head>

    <body>
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                     <img src="software/org_logo/DBBL-logo.jpg" style="height: 85px;width: 200px;float: left">
                    <a class="navbar-brand" href="#">
                        
                    </a>
                </div>
                <ul class="nav navbar-nav" >
                    <h2 style="margin-left: 450px; font-size: 30px;">Payroll Management System</h2>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <!--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>-->
                    <li><a href="logout"><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid">
            <div class="row">
                
                <div class="col-md-2" >
                    <div class="w3-card-4" style="height:500px;background: #2ecccc">

                        <ul class="nav nav-pills nav-stacked">
                            <li ><a href="dasboard">Home</a></li>
                            <li><a href="EmployeeSalarySearch">View Employee Salary</a></li>
                            <li><a href="TopTenSalaryEmployee">View Top 10 Salary</a></li>
                        </ul>

                    </div>
                    
                </div>
                <div class="col-md-10" style="    margin-left: -12px;">
                    <div class="w3-card-4">
                        
                       
                            <img src="software/user_image/payroll.jpg" style="height: 500px; width:100%" alt=""/>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="container-fluid" style="background: #f8f8f8">
                
                    <div class="footer" style="text-align:center;">
                        <div class="footer">
                            <div class="col-md-12" style="font-size: 13px">
                                <h4>Contact:</h4>
                                <p>Mobile : (8802) 47110465, 47115155, 47114795
                                    International: (8802) 47110465, 47115155</p>
                                <p>Fax: (8802) 9561889</p>
                                <p>E-mail : abc@dutchbanglabank.com</p>
                            </div>
                            <div class="col-md-6">

                            </div>
                        </div>
                    </div>
                
            </div>
        </div>



    </body>
</html>
