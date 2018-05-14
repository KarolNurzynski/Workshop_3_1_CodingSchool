package pl.coderslab.controller;

import pl.coderslab.model.dao.SolutionDao;
import pl.coderslab.model.entity.Solution;
import pl.coderslab.other.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/solution-details")
public class SoultionDetailsServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DbUtil.getConn()){

            SolutionDao solutionDao = new SolutionDao();
            Solution solution = solutionDao.loadById(id);

            request.setAttribute("solution",solution);
            getServletContext().getRequestDispatcher("/solution-details.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
