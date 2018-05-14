package pl.coderslab.model.entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User_Group {
	
	private int id;
	private String name;
	
	public User_Group() {}
	
	public User_Group(String name) {
		this.name = name;
	}

    public User_Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
