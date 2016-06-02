package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDTO;
import board.model.BoardService;
import controller.Controller;

public class WriteController implements Controller {
	BoardService service = BoardService.getInstance();
	boolean flag = false;
	String resultKey;

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		BoardDTO dto = new BoardDTO();
		dto.setWriter(req.getParameter("writer"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		
		try {
			service.insert(dto);
			resultKey = "/result/write";
			flag = flag;
			System.out.println("flag");
		} catch (Exception e) {
			e.printStackTrace();
			flag = !flag;
		}
		return resultKey;
	}

	@Override
	public boolean isForward() {
		return flag;
	}

}
