<html>
<head>
<title>Add Payment</title>
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
input, select {
    width:100%;
    padding:10px;
    margin:8px 0;
}
button {
    width:100%;
    padding:10px;
    background:#3498db;
    color:white;
    border:none;
}
button:hover { background:#2980b9; }
h2 { text-align:center; }
</style>
</head>

<body>
<div class="container">
<h2>Add Fee Payment</h2>

<form action="addFee" method="post">
Student ID:<input type="text" name="studentId">
Name:<input type="text" name="studentName">
Date:<input type="date" name="paymentDate">
Amount:<input type="text" name="amount">

Status:
<select name="status">
<option>Paid</option>
<option>Overdue</option>
</select>

<button type="submit">Add</button>
</form>
</div>
</body>
</html>