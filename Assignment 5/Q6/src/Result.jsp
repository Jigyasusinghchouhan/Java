<html>
<head>
    <title>Student Result Calculation</title>
</head>
<body>
<h1>Student Result Calculation</h1>
<%
    String name = request.getParameter("name");
    int subject1 = Integer.parseInt(request.getParameter("subject1"));
    int subject2 = Integer.parseInt(request.getParameter("subject2"));
    int subject3 = Integer.parseInt(request.getParameter("subject3"));
    int subject4 = Integer.parseInt(request.getParameter("subject4"));
    int subject5 = Integer.parseInt(request.getParameter("subject5"));

    int totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
    double percentage = (double) totalMarks / 5;
%>

<p>Name: <%= name %></p>
<p>Subject 1: <%= subject1 %></p>
<p>Subject 2: <%= subject2 %></p>
<p>Subject 3: <%= subject3 %></p>
<p>Subject 4: <%= subject4 %></p>
<p>Subject 5: <%= subject5 %></p>
<p>Total Marks: <%= totalMarks %></p>
<p>Percentage: <%= String.format("%.2f", percentage) %> %</p>
</body>
</html>
