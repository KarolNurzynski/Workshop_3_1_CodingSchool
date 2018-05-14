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

@WebServlet("/")
public class StartServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int limit = Integer.parseInt(getServletContext().getInitParameter("number-solutions"));

        try (Connection conn = DbUtil.getConn()){

            SolutionDao solutionDao = new SolutionDao();
            Solution[] solutions = solutionDao.loadAll(limit);

            request.setAttribute("solutions",solutions);
            getServletContext().getRequestDispatcher("/start.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
