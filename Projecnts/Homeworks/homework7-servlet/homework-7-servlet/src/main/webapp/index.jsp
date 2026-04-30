<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<br/>
<a href="task1">Task1</a>
<br/>
<p>Введіть три різних числа:</p>
<form action="task2" method="get">
    <input type="number" name="number1" required>
    <input type="number" name="number2" required>
    <input type="number" name="number3" required>
    <button type="submit">Показати максимальне значеня</button>
</form>
</body>
</html>