package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import board.model.BoardDTO;
import board.model.BoardService;

public class DeleteController implements Controller{
	BoardService service = BoardService.getInstance();
	String resultKey;

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int idx = Integer.parseInt(req.getParameter("idx"));
		
		try {
			service.delete(idx);
			resultKey = "/result/delete";
			
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
