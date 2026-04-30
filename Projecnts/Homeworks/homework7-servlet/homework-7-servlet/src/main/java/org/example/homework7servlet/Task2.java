package org.example.homework7servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/task2")
public class Task2 extends HttpServlet {
    private String message = "new task";

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String numStr1 = request.getParameter("number1");
        String numStr2 = request.getParameter("number2");
        String numStr3 = request.getParameter("number3");

        int num1 = Integer.parseInt(numStr1);
        int num2 = Integer.parseInt(numStr2);
        int num3 = Integer.parseInt(numStr3);

        int max = num1;
        if(num2 > max)
            max = num2;
        if(num3 > max)
            max = num3;

        String numMessage1 = String.valueOf(num1);
        String numMessage2 = String.valueOf(num2);
        String numMessage3 = String.valueOf(num3);

        if (num1 == max)
            numMessage1 = "<b>" + String.valueOf(num1) + "</b>";
        else if (num2 == max)
            numMessage2 = "<b>" + String.valueOf(num2) + "</b>";
        else
            numMessage3 = "<b>" + String.valueOf(num3) + "</b>";

        out.println("<html><body>");

        out.println("<p>Максимальне значення виділене жирним шрифтом</p>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>" + numMessage1 + "</td>");
        out.println("<td>" + numMessage2 + "</td>");
        out.println("<td>" + numMessage3 + "</td>");
        out.println("</tr>");
        out.println("</table>");

        out.println("<br/><a href='.'>Назад</a>");

        out.println("</body></html>");
    }
}
