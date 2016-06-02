package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDTO;
import board.model.BoardService;
import controller.Controller;

public class DetailController implements Controller {
	BoardService service = BoardService.getInstance();
	String resultKey;

	@Override
	public String execute(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		int idx = Integer.parseInt(req.getParameter("idx"));
		BoardDTO dto = null;
		
		try {
			dto = service.selectByIdx(idx);
			System.out.println("dto : " + dto);
			resultKey = "/result/detail";
			req.setAttribute("dto", dto);
		} catch (Exception e) {
			e.printStackTrace();
			resultKey = "/board/error";
			req.setAttribute("error", e);
		}
		return resultKey;
	}

	@Override
	public boolean isForward() {
		return true;
	}

}
