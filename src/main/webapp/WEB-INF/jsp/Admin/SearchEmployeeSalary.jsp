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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Homepage</title>
        <link rel="stylesheet" href="resources/css/jquery.alerts.css" type="text/css" />
        <link rel="stylesheet" href="resources/css/style.css" type="text/css" />
        <link rel="stylesheet" href="resources/css/bootstrap.min.css" type="text/css" />

        <script src="resources/js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="resources/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="resources/js/jquery.alerts.js" type="text/javascript"></script>
        <script src="resources/js/sweetAlert.js" type="text/javascript"></script>
        <script src="resources/js/jquery.ui.draggable.js" type="text/javascript"></script>
        <script src="resources/js/co_op.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
        <script>
            $(document).ready(function () {
                $("#viewsearch").click(function () {
                    var valPt = $("#viewsearch").val();
                    //window.alert("val : "+valPt);

                    if (valPt === "Designation")
                    {

                        $(".Designation").slideDown(100);
                        $(".EmployeeId").slideUp(100);
                    } else if (valPt === "Employee ID")
                    {
                        // window.alert("val : "+valPt);
                        $(".EmployeeId").slideDown(100);
                        $(".Designation").slideUp(100);
                    }
                });
                
                
                
                

            });
        </script>
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
                    <div class="w3-card-4" style="height:500px;background: #2ecccc">
                        <form action="ViewEmployeeSalary" method="POST">
                             
                            <table align="center">
                                <tr><td>&nbsp; </td> <td>&nbsp; </td>
                                    <td> <br></td>
                                    <td> <br></td>
                                </tr>
                                <tr><td>&nbsp; </td> <td>&nbsp; </td>
                                    <p style="color: red;text-align: center">${error}</p>
                                    <td><br></td>
                                </tr>
                                <tr><td>&nbsp; </td> <td>&nbsp; </td>
                                    <td> <br></td>
                                    <td> <br></td>
                                </tr>
                                <tr>  <td>&nbsp; </td> <td>&nbsp; </td>
                                    <td>  <label>Search Option &nbsp;</label></td>
                                    <td>

                                        <select id="viewsearch" type="text" name="viewsearch" class="form-control"  placeholder="Select"  autofocus  required>
                                            <option value="">--Select--</option>
                                            <option value="Designation">Designation</option>
                                            <option value="Employee ID">Employee ID</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td> <br></td>
                                    <td> <br></td>
                                </tr>
                                <tr class="Designation">  <td>&nbsp; </td> <td>&nbsp; </td>

                                    <td> <label>Designation &nbsp;</label></td>
                                    <td>
                                        <select name="DesignationEmployee" class="form-control"  placeholder="Select"  autofocus>
                                            <option value="">--Select--</option>
                                            <option value="Officer">Officer</option>
                                            <option value="Senior Officer">Senior Officer</option>
                                            <option value="Executive Officer">Executive Officer</option>
                                            <option value="Senior Executive Officer">Senior Executive Officer</option>
                                            <option value="Assistant Vice President">Assistant Vice President</option>
                                             <option value="Senior Assistant Vice President">Senior Assistant Vice President</option>
                                            <option value="Vice President">Vice President</option>
                                            <option value="Managing Director">Managing Director</option>
                                        </select>
                                    </td>

                                    <td></td>


                                </tr>
                                <tr>
                                    <td> <br></td>
                                    <td> <br></td>
                                </tr>

                                <tr class="EmployeeId">  <td>&nbsp; </td> <td>&nbsp; </td>

                                    <td> <label>Employee ID &nbsp;</label></td>
                                    <td>
                                        <input  name="Employeeid"  type="number" id="name" class="form-control"  placeholder="Select"  autofocus />
                                    </td>

                                    <td></td>


                                </tr>
                                <tr>
                                    <td> <br></td>
                                    <td> <br></td>
                                </tr>
                                <tr>  <td>&nbsp; </td> <td>&nbsp; </td>

                                    <td> <label> &nbsp;</label></td>
                                    <td>
                                        <input type="submit" value="Submit" class="btn btn-primary" />
                                    </td>

                                    <td></td>


                                </tr>
                            </table>
                            
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
