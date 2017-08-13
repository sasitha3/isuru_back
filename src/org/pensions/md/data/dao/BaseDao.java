package org.pensions.md.data.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.pensions.md.data.MysqlDbConnManager;

public class BaseDao {
	
	private Connection connection = null;

	public BaseDao() {
		this.connection = MysqlDbConnManager.MANAGER.getConnection();
	}

	public Connection getConnection() {
		return this.connection;
	}
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
