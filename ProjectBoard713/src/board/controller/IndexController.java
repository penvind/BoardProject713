package board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import board.common.PageUtil;
import board.model.BoardDTO;
import board.model.BoardService;
import controller.Controller;

public class IndexController implements Controller{
	BoardService service = BoardService.getInstance();
	PageUtil pg = PageUtil.getInstance();
	String resultKey;
	String keyColumn;
	
	int CurrentPage = pg.getCurrentPage();
	
	@Override
	public String execute(HttpServletRequest req)
			throws ServletException, IOException {
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		keyColumn = req.getParameter("keyColumn");
		String keyword = "";
		if(keyword != null) {
			keyword = req.getParameter("keyword");
		}
		if(req.getParameter("curPage") != null){
			CurrentPage = Integer.parseInt(req.getParameter("curPage"));
		}

		try {
			if(keyword != null){
				list = service.selectSearch(keyColumn, keyword);
				req.setAttribute("keyColumn", keyColumn);
				resultKey = "/result/index";
//				System.out.println("research list data : " + list);
			}else{
				list = service.selectAll();
				resultKey = "/result/index";
			}
			pg.init(list.size(), req, keyword,  keyColumn, CurrentPage);
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


