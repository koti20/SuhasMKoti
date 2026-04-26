<%@ page import="java.util.*,model.FeePayment" %>
<html>
<head>
<title>Report Result</title>
<style>
body { font-family: Arial; background:#f4f6f9; }
table {
    width:60%;
    margin:20px auto;
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

<h2>Report Result</h2>

<%
List<FeePayment> list = (List<FeePayment>) request.getAttribute("list");
Double total = (Double) request.getAttribute("total");

if(list != null){
%>
<table>
<tr><th>Name</th><th>Amount</th></tr>
<%
for(FeePayment fp : list){
%>
<tr>
<td><%= fp.getStudentName() %></td>
<td><%= fp.getAmount() %></td>
</tr>
<% } %>
</table>
<% } %>

<%
if(total != null){
%>
<h3 style="text-align:center;">Total Collection: <%= total %></h3>
<% } %>

</body>
</html>