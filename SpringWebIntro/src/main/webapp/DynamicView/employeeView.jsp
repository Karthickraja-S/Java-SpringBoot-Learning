<%@page language="java"  %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
         <h2>Welcome To Employee Portal  </h2>

         <p> By session Object </p>
         <p> Name : <%= session.getAttribute("Data") %> <p> <br>

         <p> By JSTL </p>
         <p> ${Data} </p>
    </body>
</html>