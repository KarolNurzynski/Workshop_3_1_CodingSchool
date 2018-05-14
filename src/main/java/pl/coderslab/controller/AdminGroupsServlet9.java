package pl.coderslab.controller;

import pl.coderslab.model.dao.User_GroupDao;
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

@WebServlet("/admingroups")
public class AdminGroupsServlet9 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String name = request.getParameter("name");

        User_GroupDao user_groupDao = new User_GroupDao();
        try (Connection conn = DbUtil.getConn()){

            if (action.equals("add")) {
                user_groupDao.create(new User_Group(name));
            }
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                user_groupDao.update(new User_Group(id, name));
            }

            User_Group[] user_groups = user_groupDao.loadAll();
            request.setAttribute("user_groups",user_groups);
            getServletContext().getRequestDispatcher("/admingroups.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (Connection conn = DbUtil.getConn()){

            User_GroupDao user_groupDao = new User_GroupDao();
            User_Group[] user_groups = user_groupDao.loadAll();

            request.setAttribute("user_groups",user_groups);
            getServletContext().getRequestDispatcher("/admingroups.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
