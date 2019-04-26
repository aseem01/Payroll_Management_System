<%-- 
    Document   : dashboard
    Created on : Apr 17, 2019, 2:37:11 PM
    Author     : Ashim Chakraborty
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <script src="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
        <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
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
                    <div class="w3-card-4" style="height:861px;background: #2ecccc">

                        <ul class="nav nav-pills nav-stacked">
                            <li ><a href="dasboardHR">Home</a></li>
                            <li><a href="EndUserAdd">Employee Add</a></li>
                            <li><a href="EndUserView">Employee View</a></li>
                            <li><a href="EndUserEmployeeInfo">Employee Information</a></li>
                        </ul>

                    </div>

                </div>
                <div class="col-md-10" style="    margin-left: -12px;">
                    <div class="w3-card-4">


                        <div class="col-md-1">

                        </div>
                        <div class="col-md-10">
                            <center><h2>Employee Information</h2></center>
                            <p style="text-align: center;color: #449d44" id="msg">${error}</p>
                            <hr>
                            <table id="mydata" class="table table-bordered table-hover">
                                <thead>
                                    <tr>
                                        <th style="width: 10%;text-align: center">Name</th>
                                        <th style="width: 10%;text-align: center">Acc No</th>
                                        <th style="width: 10%;text-align: center">Designation</th>
                                        <th style="width: 10%;text-align: center">Contact</th>
                                        <th style="width: 10%;text-align: ceneter">Basic Salary</th>
                                        <th style="width: 10%;text-align: center">House Rent</th>
                                        <th style="width: 10%;text-align: center">Health Care</th>
                                        <th style="width: 10%;text-align: center">Other's</th>
                                        <th style="width: 10%;text-align: center">Total Salary</th>
                                       

                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${emp}" var="user">
                                        <tr>
                                            <td algin="center">${user.name}</td>
                                            <td algin="center">${user.accNo}</td>
                                            <td align="center">${user.designation}</td>
                                            <td align="center">${user.contact}</td>
                                            <td align="center">${user.basicSalary}</td>
                                            <td align="center">${user.houseRent}</td>
                                            <td align="center">${user.healthCare}</td>
                                            <td align="center">${user.others}</td>
                                            <td align="center">${user.total}</td>
                                            

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <div class="col-md-1">

                        </div>

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
        <script>
            $(document).ready(function () {
                $('#mydata').DataTable();
            });
        </script>

        <!--        <script>
                    $(document).ready(function () {
                        $("#mydata").DataTable({
                            "pagingType": "simple_numbers",
                            language: {
                                search: "_INPUT_",
                                searchPlaceholder: "Search..."
                            }
                        });
        
                        $("#msg").delay(3000).slideUp(500);
                    });
        
        
                </script>-->

    </body>
</html>
