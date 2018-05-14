package pl.coderslab.controller;

import pl.coderslab.model.dao.SolutionDao;
import pl.coderslab.model.dao.UserDao;
import pl.coderslab.model.entity.Solution;
import pl.coderslab.model.entity.User;
import pl.coderslab.other.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/user-details")
public class UserDetailsServlet5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = DbUtil.getConn()){

            UserDao userDao = new UserDao();
            User user = userDao.loadById(id);

            SolutionDao solutionDao = new SolutionDao();
            Solution[] solutions = solutionDao.loadAllByUserId(id);

            request.setAttribute("user",user);
            request.setAttribute("solutions",solutions);
            getServletContext().getRequestDispatcher("/user-details.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
