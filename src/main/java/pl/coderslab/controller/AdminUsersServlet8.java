package pl.coderslab.controller;

import pl.coderslab.model.dao.UserDao;
import pl.coderslab.model.dao.User_GroupDao;
import pl.coderslab.model.entity.User;
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

@WebServlet("/adminusers")
public class AdminUsersServlet8 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int user_group_id = Integer.parseInt(request.getParameter("user_group_id"));

        UserDao userDao = new UserDao();
        try (Connection conn = DbUtil.getConn()){

            if (action.equals("add")) {
                userDao.create(new User(username, email, password, user_group_id));
            }
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                userDao.update(new User(id, username, email, password, user_group_id));
            }

            User[] users = userDao.loadAll();
            request.setAttribute("users",users);
            getServletContext().getRequestDispatcher("/adminusers.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try (Connection conn = DbUtil.getConn()){

            UserDao userDao = new UserDao();
            User[] users = userDao.loadAll();

            request.setAttribute("users",users);
            getServletContext().getRequestDispatcher("/adminusers.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
