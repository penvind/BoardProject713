package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public interface Controller {
	
	/**
	 * ������Ʈ ���
	 * 
	 * @param req
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String execute(HttpServletRequest req) throws ServletException, IOException;
	
	public boolean isForward();
}
	