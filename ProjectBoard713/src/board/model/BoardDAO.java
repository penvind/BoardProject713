package board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	Connection con;

	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	// List �샇?���?
	public List<BoardDTO> selectAll() throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			String sql = "select * from boardproject.board order by idx desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx				(rs.getInt("idx"));
				dto.setWriter			(rs.getString("writer"));
				dto.setTitle				(rs.getString("title"));
				dto.setRegdate		(rs.getString("regdate"));
				dto.setHit				(rs.getInt("hit"));
				
				list.add(dto);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 寃뚯?��?���? �븳 嫄� 媛��졇�삤湲�
	public BoardDTO selectByIdx(int idx) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardDTO dto = null;
		
		
		String sql = "select * from boardproject.board where idx=?";
		
		try {
//			System.out.println("selectIDX try");
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				dto = new BoardDTO();
				
				dto.setIdx			(rs.getInt("idx"));
				dto.setWriter		(rs.getString("writer"));
				dto.setTitle			(rs.getString("title"));
				dto.setContent	(rs.getString("content"));
				dto.setRegdate	(rs.getString("regdate"));
				dto.setHit			(rs.getInt("hit"));
			}
			
		} catch (SQLException e) {
			System.out.println("SQL e : " + e);
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return dto;
	}
	
	// 湲��벐湲�
	public int insert(BoardDTO dto) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "insert into boardproject.board(writer,title,content,regdate)";
		sql = sql + " values(?,?,?,now())";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
			result = pstmt.executeUpdate();
			
			System.out.println("reslut : " + result);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public int delete(int idx) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from boardproject.board where idx=?";
		
		try {
			System.out.println("delete check");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, idx);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int update(BoardDTO dto) throws Exception{
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "update boardproject.board set writer=?, title=?, content=? where idx=?";

		try {
			System.out.println("update check");
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
			pstmt.setInt(4, dto.getIdx());
			
			System.out.println("pstmt : " + pstmt);
			
			result = pstmt.executeUpdate();
			
			System.out.println("result :" + result);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	public List<BoardDTO> selectSearch(String keyColumn, String keyword) throws Exception{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		try {
			String sql = "select * from boardproject.board order by idx desc where ? like %?%";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, keyColumn);
			pstmt.setString(1, keyword);

			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx				(rs.getInt("idx"));
				dto.setWriter			(rs.getString("writer"));
				dto.setTitle				(rs.getString("title"));
				dto.setRegdate		(rs.getString("regdate"));
				dto.setHit				(rs.getInt("hit"));
				
				list.add(dto);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
