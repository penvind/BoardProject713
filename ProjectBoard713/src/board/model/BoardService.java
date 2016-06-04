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
	
	/**
	 * get list
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<BoardDTO> selectAll() throws Exception{
		return dao.selectAll();
	}
	
	public BoardDTO selectByIdx(int idx) throws Exception{
		return  dao.selectByIdx(idx);
	}
	
	public int insert(BoardDTO dto) throws Exception{
		return dao.insert(dto);
	}
	
	public int delete(int idx) throws Exception{
		return dao.delete(idx);
	}
	
	public int update(BoardDTO dto) throws Exception{
		return dao.update(dto);
	}
	
}
