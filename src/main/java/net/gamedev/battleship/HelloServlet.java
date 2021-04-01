package net.gamedev.battleship;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        var userName = req.getParameter("name");
        if (userName == null || userName.isBlank()) {
            userName = "World";
        }
        req.setAttribute("name", userName);
        req.getRequestDispatcher("/WEB-INF/hello.jsp")
                .forward(req, resp);
        //out.println("Hello "+userName+"!");

    }

}
