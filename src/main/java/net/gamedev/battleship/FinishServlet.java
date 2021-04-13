package net.gamedev.battleship;

import net.gamedev.battleship.model.CellStatus;
import net.gamedev.battleship.model.Game;
import net.gamedev.battleship.model.GameStatus;
import net.gamedev.battleship.model.Player;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FinishServlet", urlPatterns = "/finish")
public class FinishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openNext(request, response);
    }

    private void openNext(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        var player = (Player) request.getSession().getAttribute(Player.ATTR);

        if (game.isWinner(player)){
            openWinner(request,response);
        }else{
            openLooser(request, response);
        }

    }

    private void openLooser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/looser.jsp").forward(request, response);
    }

    private void openWinner(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/winner.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // so if no session is active no session is created
        if (session != null)
            session.setMaxInactiveInterval(1);
        //var push = request.getParameter("buttonClick");

        //if("button".equals(push)){
            response.sendRedirect("registration");
        //}

    }
}
