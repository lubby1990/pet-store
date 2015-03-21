package com.lubby.db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

public class DBUtil {
	private DataSource dataSource;
	private Connection conn;

	public DBUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Connection getConnection() {
		try {
			this.conn = this.dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.conn;
	}
}
