package com.yi.board.mvc;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerUsingURI extends HttpServlet{
	//command, Class map
	//ex)simple.do, mvc.simple.SimpleHandler
	private HashMap<String, CommandHandler> commandHandlerMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");//web.xml에 있는 param-name과 같아야함, properties내용을 가져오는 부분(properties의 주소)
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);//상대주소를 절대주소로 가져오는 부분
		try(FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		Iterator keyIter = prop.keySet().iterator();
		while(keyIter.hasNext()){
			String command = (String)keyIter.next();//properties 키 (simple.do)
			String handlerClassName = prop.getProperty(command); //properties 에 해당하는 값(mvc.simple.SimpleHandler)
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);//문자를 클래스화 하는 과정
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();//클래스 생성(new) 무슨클래스를 생성하는지 모르기때문에 자동생성을 위해
				commandHandlerMap.put(command, handlerInstance);//맵에 집어넣음
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String command = request.getRequestURI();// 요청들어온 uri를 가지고옴 ex)chapter16MVC/simple.do
		if(command.indexOf(request.getContextPath())==0){ //getContextPath()는 프로젝트이름을 반환, command가 프로젝트이름으로 시작한다면? if문 true
			command = command.substring(request.getContextPath().length()); //프로젝트이름이 짤리고 simple.do만 남음
		}
		
		CommandHandler handler = commandHandlerMap.get(command);//해당하는 클래스가 반환됨 (simple.do에 해당하는 SimpleHandler클래스)
		if(handler == null){//커맨드에 해당하는 클래스가 없을경우
			handler = new NullHandler();
		}
		String viewPage = null;
		try {
			viewPage = handler.process(request, response);//simpleForm.jsp가 viewPage에 입력
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		if(viewPage != null){
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}
}































