package net.gamedev.battleship;

import net.gamedev.battleship.model.Game;
import net.gamedev.battleship.model.GameManager;
import net.gamedev.battleship.model.GameStatus;
import net.gamedev.battleship.model.Player;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebListener
public abstract class AppListener implements ServletContextListener, HttpSessionListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var mgr = new GameManager();
        sce.getServletContext().setAttribute(GameManager.ATTR, mgr);
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        //HttpSessionListener.super.sessionCreated(se);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("SESSION DESTROYED");
        var mgr = (GameManager) se.getSession().getServletContext().getAttribute(GameManager.ATTR);
        var game = (Game) se.getSession().getAttribute(Game.ATTR);
        var player = (Player) se.getSession().getAttribute(Player.ATTR);

        if(game == null || player == null){
            return;
        }

        mgr.surrender(game, player);
    }
}
