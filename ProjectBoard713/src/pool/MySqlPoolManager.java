package pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MySqlPoolManager {
	private static MySqlPoolManager instance;
	InitialContext initCtx;
	DataSource ds;
	
	public MySqlPoolManager() {
		try {
			initCtx = new InitialContext();
			ds = (DataSource) initCtx.lookup("java:comp/env/jdbc/mySQL");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}

	public static MySqlPoolManager getInstance(){
		if(instance == null){
			instance = new MySqlPoolManager();
		}
		return instance;
	}

	public Connection getConnection(){
		Connection con = null;
		
		try {
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	// 사용후 반납 DML일 경우
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
