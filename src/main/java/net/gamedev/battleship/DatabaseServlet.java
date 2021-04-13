package net.gamedev.battleship;

import net.gamedev.battleship.model.Dashboard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DatabaseServlet", urlPatterns = "/database")
public class DatabaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (
                Connection con = DriverManager.getConnection("jdbc:h2:~/Battleship", "sa", "");
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DASHBOARD")
        ) {
            List<Dashboard> dashboardList = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String playerName = rs.getString("PLAYER");
                String winOrLose = rs.getString("WIN_OR_LOSE");
                Time score = rs.getTime("SCORE");

                Dashboard dashboard = new Dashboard(id);

                dashboard.setId(id);
                dashboard.setPlayerName(playerName);
                dashboard.setWinOrLose(winOrLose);
                dashboard.setScore(score);

                dashboardList.add(dashboard);

                request.setAttribute("dashboard", dashboardList);
                request.getRequestDispatcher("/WEB-INF/dashboard.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
