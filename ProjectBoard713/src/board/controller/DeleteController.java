package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import board.model.BoardService;
import controller.Controller;

public class DeleteController implements Controller{
	BoardService service = BoardService.getInstance();
	String resultKey;

	@Override
	public String execute(HttpServletRequest req)
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
