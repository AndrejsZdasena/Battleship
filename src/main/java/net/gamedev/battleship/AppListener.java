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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        var mgr = new GameManager();
        sce.getServletContext().setAttribute(GameManager.ATTR, mgr);
    }

}
