package pl.coderslab.model.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.jbcrypt.BCrypt;

public class User {	
	
	private int id;
	private String username;
	private String email;
	private String password;
	private int user_group_id;
	
	public User() {}
	
	public User(String username, String email, String password, int user_group_id) {
		this.username = username;
		this.email = email;
		this.setPassword(password);
		this.user_group_id = user_group_id;
	}

    public User(int id, String username, String email, String password, int user_group_id) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.user_group_id = user_group_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = BCrypt.hashpw(password, BCrypt.gensalt());
	}

	public int getUser_group_id() {
		return user_group_id;
	}

	public void setUser_group_id(int user_group_id) {
		this.user_group_id = user_group_id;
	}
	
}


