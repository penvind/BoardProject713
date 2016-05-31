package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pool.MySqlPoolManager;

public class TestMySql {
	public static void main(String[] args) {
		MySqlPoolManager pool = MySqlPoolManager.getInstance();
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			Connection con = pool.getConnection();

			con = DriverManager.getConnection("jdbc:mysql://localhost",
					"root", "");
			
			String sql = "use boardproject";
			
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			if (st.execute("show tables")) {
				rs = st.getResultSet();
			}

			while (rs.next()) {
				String str = rs.getString(1);
				System.out.println(str);
			}
		} catch (SQLException sqex) {
			System.out.println("SQLException: " + sqex.getMessage());
			System.out.println("SQLState: " + sqex.getSQLState());
		}
		
		/*BoardDAO dao = new BoardDAO();
		List list = dao.selectAll();
		System.out.println(list.size());*/
	}
		
		
}
