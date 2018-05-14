package pl.coderslab.model.dao;

import pl.coderslab.model.entity.Solution;
import pl.coderslab.other.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SolutionDao {

	private static final String CREATE = "INSERT INTO solution(created, updated, description, exercise_id, users_id) VALUES (?,?,?,?,?);";
	private static final String LOAD_BY_ID = "SELECT * FROM solution where id=?;";
	private static final String LOAD_ALL = "SELECT * FROM solution;";
    private static final String LOAD_ALL_LIMIT = "SELECT * FROM solution ORDER BY updated desc LIMIT ?";
    private static final String LOAD_ALL_BY_USER_ID = "SELECT * FROM solution where users_id=?";
	private static final String UPDATE = "UPDATE solution SET created=?, updated=?, description=?, exercise_id=?, users_id=? where id = ?;";
	private static final String DELETE = "DELETE FROM solution WHERE id= ?;";

    public void create(Solution solution) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(CREATE, new String[] {"id"})) {
            ps.setString(1, solution.getCreated());
            ps.setString(2, solution.getUpdated());
            ps.setString(3, solution.getDescription());
            ps.setInt(4, solution.getExercise_id());
            ps.setInt(5, solution.getUsers_id());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                solution.setId(rs.getInt(1));	//tablica String[] ma tylko jedna pozycje - "id" - stad 1
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
    }

    public Solution loadById(Integer id) {
        Solution solution = new Solution();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    solution.setId(rs.getInt("id"));
                    solution.setCreated(rs.getString("created"));
                    solution.setUpdated(rs.getString("updated"));
                    solution.setDescription(rs.getString("description"));
                    solution.setExercise_id(rs.getInt("exercise_id"));
                    solution.setUsers_id(rs.getInt("users_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return solution;
    }

    public Solution[] loadAll() {
        ArrayList<Solution> solutions = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Solution solution = new Solution();
                    solution.setId(rs.getInt("id"));
                    solution.setCreated(rs.getString("created"));
                    solution.setUpdated(rs.getString("updated"));
                    solution.setDescription(rs.getString("description"));
                    solution.setExercise_id(rs.getInt("exercise_id"));
                    solution.setUsers_id(rs.getInt("users_id"));
                    solutions.add(solution);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return solutions.toArray(new Solution[solutions.size()]);
    }

    public Solution[] loadAll(int limit) {
        ArrayList<Solution> solutions = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL_LIMIT)) {
            ps.setInt(1, limit);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Solution solution = new Solution();
                    solution.setId(rs.getInt("id"));
                    solution.setCreated(rs.getString("created"));
                    solution.setUpdated(rs.getString("updated"));
                    solution.setDescription(rs.getString("description"));
                    solution.setExercise_id(rs.getInt("exercise_id"));
                    solution.setUsers_id(rs.getInt("users_id"));
                    solutions.add(solution);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return solutions.toArray(new Solution[solutions.size()]);
    }

    public Solution[] loadAllByUserId(int id) {
        ArrayList<Solution> solutions = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL_BY_USER_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Solution solution = new Solution();
                    solution.setId(rs.getInt("id"));
                    solution.setCreated(rs.getString("created"));
                    solution.setUpdated(rs.getString("updated"));
                    solution.setDescription(rs.getString("description"));
                    solution.setExercise_id(rs.getInt("exercise_id"));
                    solution.setUsers_id(rs.getInt("users_id"));
                    solutions.add(solution);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return solutions.toArray(new Solution[solutions.size()]);
    }

    public void update(Solution solution) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, solution.getCreated());
            ps.setString(2, solution.getUpdated());
            ps.setString(3, solution.getDescription());
            ps.setInt(4, solution.getExercise_id());
            ps.setInt(5, solution.getUsers_id());
            ps.setInt(6, solution.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
    }

    public void delete(Integer id) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(DELETE)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
    }


}
