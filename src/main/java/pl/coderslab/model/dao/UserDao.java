package pl.coderslab.model.dao;

import org.mindrot.jbcrypt.BCrypt;
import pl.coderslab.model.entity.User;
import pl.coderslab.other.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

	private static final String CREATE = "INSERT INTO users(username, email, password, user_group_id) VALUES (?,?,?,?);";
	private static final String LOAD_BY_ID = "SELECT * FROM users where id=?;";
	private static final String LOAD_ALL = "SELECT * FROM users;";
    private static final String LOAD_ALL_BY_GROUP_ID = "SELECT * FROM users where user_group_id=?;";
	private static final String UPDATE = "UPDATE users SET username=?, email=?, password=?, user_group_id=? where id = ?;";
	private static final String DELETE = "DELETE FROM users WHERE id= ?;";

    public void create(User user) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(CREATE, new String[] {"id"})) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getUser_group_id());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getInt(1));	//tablica String[] ma tylko jedna pozycje - "id" - stad 1
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
    }

    public User loadById(Integer id) {
        User user = new User();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setUser_group_id(rs.getInt("user_group_id"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return user;
    }

    public User[] loadAll() {
        ArrayList<User> users = new ArrayList<User>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setUser_group_id(rs.getInt("user_group_id"));
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return users.toArray(new User[users.size()]);
    }

    public User[] loadAllByGroupId(int user_group_id) {
        ArrayList<User> users = new ArrayList<User>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL_BY_GROUP_ID)) {
            ps.setInt(1, user_group_id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    user.setEmail(rs.getString("email"));
                    user.setUser_group_id(rs.getInt("user_group_id"));
                    users.add(user);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return users.toArray(new User[users.size()]);
    }

    public void update(User user) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setInt(4, user.getUser_group_id());
            ps.setInt(5, user.getId());
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


