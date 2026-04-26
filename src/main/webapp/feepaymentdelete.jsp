<html>
<head>
<title>Delete Payment</title>
<style>
body { font-family: Arial; background:#f4f6f9; }
.container {
    width:300px;
    margin:100px auto;
    background:white;
    padding:20px;
    border-radius:10px;
    box-shadow:0px 0px 10px gray;
}
input {
    width:100%;
    padding:10px;
    margin:10px 0;
}
button {
    width:100%;
    padding:10px;
    background:red;
    color:white;
    border:none;
}
h2 { text-align:center; }
</style>
</head>

<body>
<div class="container">
<h2>Delete Payment</h2>

<form action="deleteFee" method="post">
Payment ID:<input type="text" name="paymentId">
<button type="submit">Delete</button>
</form>
</div>
</body>
</html>