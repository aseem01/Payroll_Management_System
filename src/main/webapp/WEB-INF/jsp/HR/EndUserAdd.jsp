<%-- 
    Document   : dashboard
    Created on : Apr 16, 2019, 2:37:11 PM
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
                            <li ><a href="dasboardHR">Home</a></li>
                            <li><a href="EndUserAdd">Employee Add</a></li>
                            <li><a href="EndUserView">Employee View</a></li>
                            <li><a href="EndUserEmployeeInfo">Employee Information</a></li>
                        </ul>

                    </div>

                </div>
                <div class="col-md-10" style="    margin-left: -12px;">
                    <div class="w3-card-4" style="margin-top: -9px; height: 498px;">
                        <form action="AddEmployeeForm" ModelAttribute="EmployeeRecord" method="POST">
                            <p style="color: red">${error}</p>
                            <div class="row" >
                                <div class="col-md-6">
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3" >FullName</label>
                                        <div class="col-sm-8">
                                            <input type="text" name="name" class="form-control" placeholder="Please Enter Fullname" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3" >Email</label>
                                        <div class="col-sm-8">
                                            <input type="email" name="email" class="form-control" placeholder="Please Enter Email" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3" >Contact</label>
                                        <div class="col-sm-8">
                                            <input type="number" name="contact" class="form-control" placeholder="Please Enter Contact" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3" >Address</label>
                                        <div class="col-sm-8">
                                            <input type="text" name="address" class="form-control" placeholder="Please Enter Address" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-3" >Designation</label>
                                        <div class="col-sm-8">
                                            <select name="designation" class="form-control">
                                                <option value="">--Select--</option>
                                                <c:forEach var="user" items="${emp}">
                                                        <option value="${user.salaryId}">${user.designation}</option>
                                                    </c:forEach>
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                </div>
                                <div class="col-md-6">
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-4" >Father's Name</label>
                                        <div class="col-sm-8">
                                            <input type="text" name="fathername" class="form-control" placeholder="Please Enter Father's" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-4" >Mother's Name</label>
                                        <div class="col-sm-8">
                                            <input type="text" name="mothername" class="form-control" placeholder="Please Enter Mother's" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-4" >Account Number</label>
                                        <div class="col-sm-8">
                                            <input type="number" name="accNo" class="form-control" placeholder="Please Enter Account" autofocus required>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                    <div class="form-group">
                                        <label class="control-label col-sm-4" >Last Education</label>
                                        <div class="col-sm-8">
                                            <select name="education" class="form-control">
                                                <option value="">--Select--</option>
                                                <option value="M.Sc">M.Sc</option>
                                                <option value="B.Sc">B.Sc</option>
                                                <option value="H.S.C">H.S.C</option>
                                                <option value="S.S.C">S.S.C</option>
                                            </select>
                                        </div>
                                    </div>
                                    <br>
                                    <br>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-offset-5 col-md-2">
                                    <input type="submit" class="btn btn-success" value="Add" style="text-align: center">
                                    
                                </div>
                            </div>
                        
                            
                        </form>

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
