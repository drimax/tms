<html lang="en"><head>
    <meta charset="utf-8">
    <link rel="icon" type="image/png" href="assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">


    <meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0" name="viewport">
    <meta name="viewport" content="width=device-width">


    <!-- Bootstrap core CSS     -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet">


    <!-- Data table css     -->
    <link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.16/css/jquery.dataTables.css">

    <!-- Animation library for notifications   -->
    <link href="assets/css/animate.min.css" rel="stylesheet">

    <!--  Light Bootstrap Table core CSS    -->
    <link href="assets/css/light-bootstrap-dashboard.css" rel="stylesheet">


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet">


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="http://fonts.googleapis.com/css?family=Roboto:400,700,300" rel="stylesheet" type="text/css">
    <link href="assets/css/pe-icon-7-stroke.css" rel="stylesheet">

    <script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/common.js"></script><script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/util.js"></script><script type="text/javascript" charset="UTF-8" src="https://maps.googleapis.com/maps-api-v3/api/js/31/0/stats.js"></script></head>
<body style="">
<div class="sidebar" data-color="azure" data-image="assets/img/sidebar-5.jpg">

    <!--
		Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag
	-->
    <div class="sidebar-wrapper">
        <div class="logo">
            <a href="http://www.creative-tim.com" class="simple-text">
                Sithumina Transport
            </a>
        </div>

        <ul class="nav">
            <li class="deactive">
                <a href="dashboard.html">
                    <i class="pe-7s-graph"></i>
                    <p>Home</p>
                </a>
            </li>
            <li>
                <a href="user-accout.html">
                    <i class="pe-7s-user"></i>
                    <p>User Accounts</p>
                </a>
            </li>
            <li>
                <a href="manageEmployee.html">
                    <i class="pe-7s-user"></i>
                    <p>Employee</p>
                </a>
            </li>
            <li></li><li class="">
            <a href="manageVehicle.html">
                <i class="pe-7s-note2"></i>
                <p>Vehicle</p>
            </a>
        </li>
            <li >
                <a href="manageRoute.html">
                    <i class="pe-7s-news-paper"></i>
                    <p>Route</p>
                </a>
            </li>
            <li>
                <a href="manageProduct.html">
                    <i class="pe-7s-science"></i>
                    <p>Product</p>
                </a>
            </li>
            <li class="active">
                <a href="manageFleet.html">
                    <i class="pe-7s-map-marker"></i>
                    <p>Fleets</p>
                </a>
            </li>
            <li>
                <a href="table.html">
                    <i class="pe-7s-note2"></i>
                    <p>Report Generator</p>
                </a>
            </li>
            <li>
                <a href="notifications.html">
                    <i class="pe-7s-bell"></i>
                    <p>Notifications</p>
                </a>
            </li>
            <li class="active-pro">
                <a href="upgrade.html">
                    <i class="pe-7s-rocket"></i>
                    <p>Upgrade to PRO</p>
                </a>
            </li>
        </ul>
    </div>
    <div class="sidebar-background" style="background-image: url(assets/img/sidebar-5.jpg) "></div></div>
<div>
    <form action="/logout" method="post">
        <button type="submit" class="btn btn-danger">Log Out</button>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    </form>
</div>
<div class="wrapper">
    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
                                <p class="hidden-lg hidden-md">Dashboard</p>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-globe"></i>
                                <b class="caret hidden-sm hidden-xs"></b>
                                <span class="notification hidden-sm hidden-xs">5</span>
                                <p class="hidden-lg hidden-md">
                                    5 Notifications
                                    <b class="caret"></b>
                                </p>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="">
                                <i class="fa fa-search"></i>
                                <p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="">
                                <p>Account</p>
                            </a>
                        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <p>
                                    Dropdown
                                    <b class="caret"></b>
                                </p>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">
                                <p>Log out</p>
                            </a>
                        </li>
                        <li class="separator hidden-lg hidden-md"></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-5">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Fleet Management Page</h4>
                            </div>

                            <div class="content">
                                <form id="routeForm">
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <div class="pull-left">
                                                    <input id="fleetId" type="text" hidden>
                                                    <label>Fleet Name</label>
                                                    <input id="fleetName" type="text" class="form-control" placeholder="Enter fleet name" value="">
                                                    <br>
                                                    <div class="dropdown">
                                                        <label>Select Route</label>&nbsp &nbsp &nbsp
                                                        <select id="selectRoute" class="btn btn-default dropdown-toggle" >
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="dropdown">
                                                        <label>Select Product</label>&nbsp &nbsp &nbsp
                                                        <select id="selectProduct" class="btn btn-default dropdown-toggle" >
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="dropdown">
                                                        <label>Select Vehicle</label>&nbsp &nbsp &nbsp
                                                        <select id="selectVehicle" class="btn btn-default dropdown-toggle" >
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="dropdown">
                                                        <label>Select Driver</label>&nbsp &nbsp &nbsp
                                                        <select id="selectDriver" class="btn btn-default dropdown-toggle" >
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <div class="dropdown">
                                                        <label>Select Helper</label>&nbsp &nbsp &nbsp
                                                        <select id="selectHelper" class="btn btn-default dropdown-toggle" >
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <label>Start Time</label>
                                                    <input id="fleetStartTime" type="text" class="form-control" placeholder="Enter fleet start time" value="">
                                                    <br>
                                                    <label>Status</label>
                                                    <div class="dropdown">
                                                        <select id="fleetStatus" class="btn btn-default dropdown-toggle" >
                                                            <option value="ACT">Active</option>
                                                            <option value="INA">Inactive</option>
                                                        </select>
                                                    </div>
                                                    <br>
                                                    <button type="submit" id="routeSave" class="btn btn-info btn-fill pull-left">Save</button>
                                                    <button type="submit" id="routeUpdate" class="btn btn-info btn-fill pull-left">Update</button>
                                                    <br>
                                                    <br>
                                                    <div class="clearfix"></div>

                                                </div>
                                                <br> <br>


                                            </div>
                                        </div>
                                    </div>
                                    <div class="clearfix"></div>


                                </form>
                            </div>
                        </div>
                    </div>




                    <div class="col-md-7">
                        <div class="card card-user">
                            <div class="content">
                                <div class="pull-center">
                                    <label>Search Fleet</label>
                                    <input type="text" id="searchFleetId" class="form-control" placeholder="TYPE YOUR FLEET NAME HERE" name="search"><br>
                                    <button type="submit" onclick="searchFleet()" class="btn btn-info btn-fill pull-center">Search</button>&nbsp &nbsp &nbsp


                                    <br>
                                </div><br><br>

                                <div class="content table-responsive table-full-width">
                                    <table id="fleetTable" class="display" width="100%"></table>

                                    <br>
                                    <br>
                                    <div class="pull-center">
                                        <button type="submit" id="fleetAddButton" onclick="fleetAdd()" class="btn btn-info btn-fill pull-center">Add</button>&nbsp &nbsp &nbsp
                                        <button type="submit" id="fleetUpdateButton" onclick="fleetUpdate()" class="btn btn-info btn-fill pull-center">Edit</button>&nbsp &nbsp &nbsp
                                        <button type="submit" id="fleetDeleteButton" onclick="fleetDelete()" class="btn btn-info btn-fill pull-center">Delete</button>&nbsp &nbsp &nbsp
                                        <button type="submit" id="fleetClearButton" onclick="fleetClear()" class="btn btn-info btn-fill pull-center">Clear</button>
                                        <br>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>







            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        © <script>document.write(new Date().getFullYear())</script>2017 <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
                </div>
            </footer>

        </div>
    </div>






    <!--   Core JS Files   -->
    <script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
    <script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

    <!--  Checkbox, Radio & Switch Plugins -->
    <script src="assets/js/bootstrap-checkbox-radio-switch.js"></script>

    <!--  Charts Plugin -->
    <script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?sensor=false"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
    <script src="assets/js/light-bootstrap-dashboard.js"></script>

    <!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
    <script src="assets/js/demo.js"></script>

    <!-- JQuery data table adding -->
    <script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>

    <!-- Include the js file to the page-->
    <script src="assets/js/custom/manageFleet.js"></script>


</div>
</body></html>