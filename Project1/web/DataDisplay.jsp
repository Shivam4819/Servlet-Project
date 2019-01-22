<!DOCTYPE html>
<%@page import="Database.DatabaseConnector" %>

<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="cssfile/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="cssfile/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="cssfile/datatables-plugins/dataTables.bootstrap.css" rel="stylesheet">

    <!-- DataTables Responsive CSS -->
    <link href="cssfile/datatables-responsive/dataTables.responsive.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="cssfile/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="cssfile/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


</head>

<body>

    <div id="wrapper">

       

        <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>Rendering engine</th>
                                        <th>Browser</th>
                                        <th>Platform(s)</th>
                                        <th>Engine version</th>
                                        
                                    </tr>
                                </thead>
                                <%
                                    String name=null,email=null,phone=null,rollno=null;
                                %>
                                <%
                                    DatabaseConnector data=new DatabaseConnector();
                                    data.initializeDbConnection();
                                    try {
                                            data.resultSet=data.smt.executeQuery("SELECT * FROM record ");
                                            while(data.resultSet.next()){
                                                name=data.resultSet.getString("name");
                                                email=data.resultSet.getString("email");
                                                phone=data.resultSet.getString("phone_no");
                                                rollno=data.resultSet.getString("rollno");
                                            %>
                                                <tbody>
                                                <tr class="odd gradeX">
                                                <td><%=name %></td>
                                                <td><%=email%></td>
                                                <td><%=phone %></td>
                                                <td><%=rollno %></td>

                                                </tr>
                                                </tbody>
                                            <%
                                            }
                                        } catch (Exception e) {
                                        }
                                        finally{
                                           data.closeDbConnection(data.connection);
                                        }
                                                                         
                                %>
                                
                            </table>
                            <!-- /.table-responsive -->
                           
                        </div>
                    </div>
                </div>
            </div>
        </div>
    
    </div>
    
</body>

</html>