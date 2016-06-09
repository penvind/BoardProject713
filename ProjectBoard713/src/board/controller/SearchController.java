package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import board.model.BoardDTO;
import board.model.BoardService;
import controller.Controller;

public class SearchController implements Controller {
	BoardService service = BoardService.getInstance();
	String resultKey;
	String keyColumn;
	String keyword;

	@Override
	public String execute(HttpServletRequest req) throws ServletException,
			IOException {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		keyColumn = req.getParameter("keyColumn");
		keyword = req.getParameter("keyword");
		
		try {
			list = service.selectSearch(keyColumn, keyword);
			System.out.println("sarchController list data : " + list);
			resultKey = "/result/search";
			req.setAttribute("keyword", keyword);
			req.setAttribute("index", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultKey;
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
