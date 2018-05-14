package pl.coderslab.controller;

import pl.coderslab.model.dao.ExerciseDao;
import pl.coderslab.model.dao.User_GroupDao;
import pl.coderslab.model.entity.Exercise;
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

@WebServlet("/adminexercises")
public class AdminExercisesServlet7 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        ExerciseDao exerciseDao = new ExerciseDao();
        try (Connection conn = DbUtil.getConn()){

            if (action.equals("add")) {
                exerciseDao.create(new Exercise(title, description));
            }
            if (action.equals("edit")) {
                int id = Integer.parseInt(request.getParameter("id"));
                exerciseDao.update(new Exercise(id, title, description));
            }

            Exercise[] exercises = exerciseDao.loadAll();
            request.setAttribute("exercises",exercises);
            getServletContext().getRequestDispatcher("/adminexercises.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (Connection conn = DbUtil.getConn()){

            ExerciseDao exerciseDao = new ExerciseDao();
            Exercise[] exercises = exerciseDao.loadAll();

            request.setAttribute("exercises",exercises);
            getServletContext().getRequestDispatcher("/adminexercises.jsp").forward(request,response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
