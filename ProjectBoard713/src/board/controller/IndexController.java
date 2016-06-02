package board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardService;
import controller.Controller;

public class IndexController implements Controller{
	BoardService service = BoardService.getInstance();
	String resultKey;
	
	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		List list = null;
		
		try {
			list = service.selectAll();
			resultKey = "/result/index";
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


