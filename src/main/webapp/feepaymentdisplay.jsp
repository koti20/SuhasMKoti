<%@ page import="java.util.*,model.FeePayment" %>
<html>
<head>
<title>Display</title>
<style>
body { font-family: Arial; background:#f4f6f9; }
table {
    width:90%;
    margin:30px auto;
    border-collapse:collapse;
}
th {
    background:#2c3e50;
    color:white;
}
td, th {
    padding:10px;
    border:1px solid #ccc;
    text-align:center;
}
h2 { text-align:center; }
</style>
</head>

<body>

<h2>Fee Payment Records</h2>

<table>
<tr>
<th>ID</th><th>Student ID</th><th>Name</th><th>Date</th><th>Amount</th><th>Status</th>
</tr>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("list");

if(list != null){
for(FeePayment fp : list){
%>
<tr>
<td><%= fp.getPaymentId() %></td>
<td><%= fp.getStudentId() %></td>
<td><%= fp.getStudentName() %></td>
<td><%= fp.getPaymentDate() %></td>
<td><%= fp.getAmount() %></td>
<td><%= fp.getStatus() %></td>
</tr>
<% }} %>

</table>

</body>
</html>