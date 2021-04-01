package net.gamedev.battleship;

import net.gamedev.battleship.model.Game;
import net.gamedev.battleship.model.GameManager;
import net.gamedev.battleship.model.GameStatus;
import net.gamedev.battleship.model.Player;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        openNext(response, request);
    }

    private void openRegistration(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/registration.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var playerName = request.getParameter("playerName");
        if (playerName == null || playerName.isBlank() || playerName.strip().length() < 3) {
            request.setAttribute("isPlayerNameCorrect", true);
            request.setAttribute("playerName", playerName);
            openRegistration(request, response);
        } else {
            var player = new Player(playerName);
            var mgr = (GameManager) request.getServletContext().getAttribute(GameManager.ATTR);
            var game = mgr.join(player);
            request.getSession().setAttribute(Player.ATTR, player);
            request.getSession().setAttribute(Game.ATTR, game);
            openNext(response, request);
        }
    }

    private void openNext(HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        if (game == null) {
            openRegistration(request, response);
        } else if (game.getStatus() == GameStatus.INCOMPLETE) {
            openRegistrationAwait(request, response);
        } else {
            openPlacement(request, response);
        }

    }

    private void openPlacement(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("placement");
    }

    private void openRegistrationAwait(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/registration-await.jsp")
                .forward(request, response);
    }
}
