package net.gamedev.battleship;

import net.gamedev.battleship.model.Task;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Random;

@WebServlet(name = "CalcServlet", urlPatterns = "/calc")
public class CalcServlet extends HttpServlet {
    public static Random random = new Random();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        var randNumber1 = random.nextInt(900) + 100;
        var randNumber2 = random.nextInt(900) + 100;

        var task = new Task();
        task.setRandNumber1(randNumber1);
        task.setRandNumber2(randNumber2);
        task.setExpectedResult(randNumber1 + randNumber2);
        request.getSession().setAttribute(Task.ATTR, task);

        forw(request, response);

    }

    private void forw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/calc.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        var task = (Task) request.getSession().getAttribute(Task.ATTR);
        var userStrNum = request.getParameter("result");
        var userNum = Integer.parseInt(userStrNum);

        task.setActualResult(userNum);
        String message;


        if (task.getExpectedResult() == userNum) {

            message = "correct";

        } else {

            message = "Incorrect";

        }
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/result.jsp")
                .forward(request, response);
    }
}


