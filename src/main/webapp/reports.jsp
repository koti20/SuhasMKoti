<html>
<head>
<title>Reports</title>
<style>
body { font-family: Arial; background:#f4f6f9; }
.container {
    width:400px;
    margin:50px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}
button {
    width:100%;
    padding:10px;
    background:green;
    color:white;
    border:none;
}
h2 { text-align:center; }
</style>
</head>

<body>
<div class="container">
<h2>Reports</h2>

<a href="ReportServlet?type=overdue">View Overdue Students</a><br><br>

<form action="ReportServlet" method="get">
<input type="hidden" name="type" value="total">

From Date:<input type="date" name="fromDate">
To Date:<input type="date" name="toDate">

<button type="submit">Total Collection</button>
</form>
</div>
</body>
</html>