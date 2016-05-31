package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pool.MySqlPoolManager;

public class BoardDAO {
	MySqlPoolManager pool = MySqlPoolManager.getInstance();
	
	// List 호출
	public List<BoardDTO> selectAll(){
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		Connection con = pool.getConnection();
		try {
			String sql = "select * from boardproject.board order by idx desc";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				BoardDTO dto = new BoardDTO();
				
				dto.setIdx				(rs.getInt("idx"));
				dto.setWriter			(rs.getString("writer"));
				dto.setTitle			(rs.getString("title"));
				dto.setRegdate			(rs.getString("regdate"));
				dto.setHit				(rs.getInt("hit"));
				
				list.add(dto);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			pool.freeConnection(con, pstmt, rs);
		}
		return list;
	}
	
	// 게시물 한 건 가져오기
	public BoardDTO selectByIdx(int idx){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		con = pool.getConnection();
		BoardDTO dto = null;
		
//		System.out.println("selectIDX check");
		
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
				dto.setTitle		(rs.getString("title"));
				dto.setContent		(rs.getString("content"));
				dto.setRegdate		(rs.getString("regdate"));
				dto.setHit			(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			System.out.println("SQL e : " + e);
			e.printStackTrace();
		} finally{
			pool.freeConnection(con, pstmt, rs);
		}
		return dto;
	}
	
	// 글쓰기
	public int insert(BoardDTO dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		con = pool.getConnection();
		int result = 0;
		
		String sql = "insert into boardproject.board(writer,title,content,regdate)";
		sql = sql + " values(?,?,?,now())";
		
		try {
			con.setAutoCommit(false);
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			
			result = pstmt.executeUpdate();
			
			System.out.println("reslut : " + result);
			
			con.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
				result = 0;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally{
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	
	public int delete(int idx){
		Connection con = null;
		PreparedStatement pstmt = null;
		con = pool.getConnection();
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
	
	public int update(BoardDTO dto){
		Connection con = null;
		PreparedStatement pstmt = null;
		con = pool.getConnection();
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
		} finally {
			pool.freeConnection(con, pstmt);
		}
		return result;
	}
	
}
