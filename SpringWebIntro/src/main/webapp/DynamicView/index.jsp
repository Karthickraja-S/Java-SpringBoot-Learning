<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Spring Web App</title>
    <link rel="stylesheet" href="style.css" type="text/css">
</head>
<body>
<h1> Spring Web App Homepage</h1>
    <form action="/v3/getData">
        <label for="empId">Enter employee ID to get the Details : </label>
        <input type="text" name="empId" id="empId"> <br>
        <input type="submit" value="Submit">
    </form>

<br><br><br><br><br>

    <form action="/v4/addData" method="POST">
            <label for="empId">Enter employee ID : </label>
            <input type="text" name="empId" id="empId"> <br>
            <label for="name">Enter employee Name : </label>
            <input type="text" name="name" id="name"> <br>
            <input type="submit" value="Submit">
        </form>
</body>
</html>