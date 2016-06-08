package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import board.model.BoardDTO;
import board.model.BoardService;
import controller.Controller;

public class UpdateController implements Controller{
	BoardService service = BoardService.getInstance();
	String resultKey;

	@Override
	public String execute(HttpServletRequest req)
			throws ServletException, IOException {
		BoardDTO dto = null;
		int idx = Integer.parseInt(req.getParameter("idx"));
		String check = req.getParameter("check");
		System.out.println("check °ª: " + check);
		
		try {
			dto = service.selectByIdx(idx);
			if(check != null){
				dto.setWriter(req.getParameter("writer"));
				dto.setTitle(req.getParameter("title"));
				dto.setContent(req.getParameter("content"));
				
				service.update(dto);
				resultKey = "/result/update";
				System.out.println("true resultKey : " + resultKey);
			}else if(check == null){
				resultKey = "/result/updatePage";
				System.out.println("false resultKey : " + resultKey);
			}
			req.setAttribute("dto", dto);
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
