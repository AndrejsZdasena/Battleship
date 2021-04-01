package net.gamedev.battleship;

import net.gamedev.battleship.model.Game;
import net.gamedev.battleship.model.GameStatus;
import net.gamedev.battleship.model.Player;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Set;

@WebServlet(name = "PlacementServlet", urlPatterns = "/placement")
public class PlacementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       openNext(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var player = (Player)req.getSession().getAttribute(Player.ATTR);
        var game = (Game) req.getSession().getAttribute(Game.ATTR);
        player.getPlayerField().clear();
        var addresses = req.getParameterValues("addr");
        if (addresses==null){
            req.setAttribute("incorrectShipPlacement", true);
            openPlacement(req, resp);
            return;
        }
        var shipAddresses = Set.of(addresses);
        player.setShips(shipAddresses);
        if (player.isPlayerFieldValid()){
            req.setAttribute("incorrectShipPlacement", true);
            openPlacement(req, resp);
            return;
        }

        game.checkGameStart();
        openNext(req,resp);
    }

    private void openNext(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        var player = (Player)request.getSession().getAttribute(Player.ATTR);
        var game = (Game) request.getSession().getAttribute(Game.ATTR);
        var opponent = game.opponentOf(player);
        if (game.getStatus() == GameStatus.IN_PROGRESS){
            openTurn(request, response);
        }else if (!player.isPlayerFieldValid()){
            openPlacement(request, response);
        }else{
            openPlacementAwait(request,response);
        }
    }

    private void openTurn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("turn");
    }

    private void openPlacementAwait(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/placement-await.jsp")
                .forward(request, response);
    }

    private void openPlacement(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/placement.jsp")
        .forward(request, response);
    }
}
