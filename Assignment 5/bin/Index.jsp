<html>
<head>
    <title>Student Result Calculation</title>
</head>
<body>
<h1>Student Result Calculation</h1>
<form action="result.jsp" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="subject1">Subject 1:</label>
    <input type="number" id="subject1" name="subject1" min="0" max="100" required><br><br>

    <label for="subject2">Subject 2:</label>
    <input type="number" id="subject2" name="subject2" min="0" max="100" required><br><br>

    <label for="subject3">Subject 3:</label>
    <input type="number" id="subject3" name="subject3" min="0" max="100" required><br><br>

    <label for="subject4">Subject 4:</label>
    <input type="number" id="subject4" name="subject4" min="0" max="100" required><br><br>

    <label for="subject5">Subject 5:</label>
    <input type="number" id="subject5" name="subject5" min="0" max="100" required><br><br>

    <input type="submit" value="Calculate Result">
</form>
</body>
</html>
