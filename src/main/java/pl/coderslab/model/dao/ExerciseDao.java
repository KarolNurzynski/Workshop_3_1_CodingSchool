package pl.coderslab.model.dao;

import pl.coderslab.model.entity.Exercise;
import pl.coderslab.other.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExerciseDao {

	private static final String CREATE = "INSERT INTO exercise(title, description) VALUES (?,?)";
    private static final String LOAD_BY_ID = "SELECT * FROM exercise where id=?";
    private static final String LOAD_ALL = "SELECT * FROM exercise";
    private static final String UPDATE = "UPDATE exercise SET title=?, description=? where id = ?";
    private static final String DELETE = "DELETE FROM exercise WHERE id= ?";

	public void create(Exercise exercise)  {
		try (Connection conn = DbUtil.getConn();
			 PreparedStatement ps = conn.prepareStatement(CREATE, new String[] {"id"})) {
			ps.setString(1, exercise.getTitle());
			ps.setString(2, exercise.getDescription());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				exercise.setId(rs.getInt(1));	//tablica String[] ma tylko jedna pozycje - "id" - stad 1
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

    public Exercise loadById (Integer id) {
        Exercise exercise = new Exercise();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    exercise.setId(rs.getInt("id"));
                    exercise.setTitle(rs.getString("title"));
                    exercise.setDescription(rs.getString("description"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return exercise;
    }

    public Exercise[] loadAll() {
        List<Exercise> hotels = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Exercise exercise = new Exercise();
                    exercise.setId(rs.getInt("id"));
                    exercise.setTitle(rs.getString("title"));
                    exercise.setDescription(rs.getString("description"));
                    hotels.add(exercise);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return hotels.toArray(new Exercise[hotels.size()]);
    }

    public void update(Exercise exercise) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, exercise.getTitle());
            ps.setString(2, exercise.getDescription());
            ps.setInt(3, exercise.getId());
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
