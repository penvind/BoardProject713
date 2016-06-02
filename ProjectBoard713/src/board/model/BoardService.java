package board.model;

import java.sql.Connection;
import java.util.List;

import pool.MySqlPoolManager;

public class BoardService {
	static private BoardService instance = new BoardService();
	BoardDAO dao;
	MySqlPoolManager pool = MySqlPoolManager.getInstance();

	public BoardService() {
		Connection con = pool.getConnection();
		dao = new BoardDAO(con);
	}
	
	public static BoardService getInstance(){
		return instance;
	}
	
	public List selectAll() throws Exception{
		List list = null;
		list = dao.selectAll();
		return list;
	}
	
	public BoardDTO selectByIdx(int idx) throws Exception{
		BoardDTO dto = null;
		dto = dao.selectByIdx(idx);
		
		return dto;
	}
	
	public int insert(BoardDTO dto) throws Exception{
		int result = 0;
		result = dao.insert(dto);
		return result;
	}
	
	public int delete(int idx) throws Exception{
		int result = 0;
		result = dao.delete(idx);
		return result;
		
	}
	
}
