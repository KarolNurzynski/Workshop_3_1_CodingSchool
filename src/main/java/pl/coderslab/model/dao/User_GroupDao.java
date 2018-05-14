package pl.coderslab.model.dao;

import pl.coderslab.model.entity.User_Group;
import pl.coderslab.other.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_GroupDao {

	private static final String CREATE = "INSERT INTO user_group(name) VALUES (?);";
	private static final String LOAD_BY_ID = "SELECT * FROM user_group where id=?;";
	private static final String LOAD_ALL = "SELECT * FROM user_group;";
	private static final String UPDATE = "UPDATE user_group SET name=? where id = ?;";
	private static final String DELETE = "DELETE FROM user_group WHERE id= ?;";

	public void create(User_Group user_group) {
		try (Connection conn = DbUtil.getConn();
			 PreparedStatement ps = conn.prepareStatement(CREATE, new String[] {"id"})) {
			ps.setString(1, user_group.getName());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				user_group.setId(rs.getInt(1));	//tablica String[] ma tylko jedna pozycje - "id" - stad 1
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occured, try again!");
		}
	}

    public User_Group loadById(Integer id) {
        User_Group user_group = new User_Group();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_BY_ID)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    user_group.setId(rs.getInt("id"));
                    user_group.setName(rs.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return user_group;
    }

    public User_Group[] loadAll() {
        List<User_Group> user_groups = new ArrayList<>();
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(LOAD_ALL)) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    User_Group user_group = new User_Group();
                    user_group.setId(rs.getInt("id"));
                    user_group.setName(rs.getString("name"));
                    user_groups.add(user_group);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error occured, try again!");
        }
        return user_groups.toArray(new User_Group[user_groups.size()]);
    }

    public void update(User_Group user_group) {
        try (Connection conn = DbUtil.getConn();
             PreparedStatement ps = conn.prepareStatement(UPDATE)) {
            ps.setString(1, user_group.getName());
            ps.setInt(2, user_group.getId());
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
