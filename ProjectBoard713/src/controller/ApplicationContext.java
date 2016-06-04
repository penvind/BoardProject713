package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationContext extends HttpServlet{
	FileInputStream fis;
	Properties props;
	
	public void init(ServletConfig config) throws ServletException{
		String mappingPath	= config.getInitParameter("mappingPath");
		ServletContext context = config.getServletContext();
		
		try {
			fis = new FileInputStream(context.getRealPath(mappingPath));
			props = new Properties();
			props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doRequest(req, res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doRequest(req, res);
	}

	protected void doRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html");
		
		// 요청에 해당하는 컨트롤러 검색
		String uri 					= req.getRequestURI();
		System.out.println("uri : " + uri);
		String controllerName 	= props.getProperty(uri);
		System.out.println("controllerName : "+controllerName);
		Class controllerClass 	= null;
		
		try {
			controllerClass 		= Class.forName(controllerName);
			System.out.println("controllerClass : " + controllerClass);
			Controller controller 	= (Controller) controllerClass.newInstance();
			String resultKey 		= controller.execute(req);
			String resultPage 		= props.getProperty(resultKey);		// key값으로 검색

			System.out.println("controller : " + controller);
//			System.out.println("req" + req);
//			System.out.println("res" + res);

			System.out.println("resultKey : "+ resultKey);
			System.out.println("resultPage : "+ resultPage);
			
			if(resultPage.equals(null)) System.out.println("resultPage 값이 없음");
			
			if(controller.isForward()){			// 요청 유지
				RequestDispatcher dis = req.getRequestDispatcher(resultPage);
				dis.forward(req, res);
				System.out.println("forward check");
				System.out.println("=====================================");
			}else{									// 요청 끊기
				res.sendRedirect(resultPage);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void destroy(){
		if(fis != null){
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
