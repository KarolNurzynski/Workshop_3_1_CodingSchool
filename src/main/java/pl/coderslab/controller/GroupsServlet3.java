package pl.coderslab.controller;

import pl.coderslab.model.dao.SolutionDao;
import pl.coderslab.model.dao.User_GroupDao;
import pl.coderslab.model.entity.Solution;
import pl.coderslab.model.entity.User_Group;
import pl.coderslab.other.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/groups")
public class GroupsServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (Connection conn = DbUtil.getConn()){

            User_GroupDao user_groupDao = new User_GroupDao();
            User_Group[] user_groups = user_groupDao.loadAll();

            request.setAttribute("user_groups",user_groups);
            getServletContext().getRequestDispatcher("/groups.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
