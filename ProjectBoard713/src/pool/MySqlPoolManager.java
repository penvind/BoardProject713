package pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySqlPoolManager {
	private static MySqlPoolManager instance;

	public static MySqlPoolManager getInstance(){
		if(instance == null){
			instance = new MySqlPoolManager();
		}
		return instance;
	}

	public Connection getConnection(){
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			System.out.println("getConnection Success");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("e : "+ e);
		}
		return con;
	}
	
	public void freeConnection(Connection con, PreparedStatement pstmt){
		if (pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ( con != null ){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void freeConnection(Connection con, PreparedStatement pstmt, ResultSet rs){
		if ( rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null){
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if ( con != null ){
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
