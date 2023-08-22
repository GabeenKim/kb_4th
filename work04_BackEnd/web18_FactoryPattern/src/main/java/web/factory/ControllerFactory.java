package web.factory;

import web.controller.Controller;
import web.controller.FindController;
import web.controller.LoginController;
import web.controller.RegisterController;
import web.controller.UpdateController;

/*
 *	Controller(컴포넌트)를 만드는 공장. -> ControllerFactory
 *	이곳에서 Register Controller, Find Controller, Update Controller 등을 각각 생성한다. 
 *
 * 	1) 4개의 컨트롤러를 생성 --> ControllerFactory가 4개 필요? 
 *  2) 몇 개의 컨트롤러를 생성하든 --> ControllerFactory 1개 필요?
 *  
 *  => 2)이 올바른 방법. 따라서 1개만 필요하기에 싱글톤 패턴으로 작성해야 함. 
 */
public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	
	private ControllerFactory() {
		System.out.println("Creating ControllerFactory...");
	}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	//클라이언트의 요청에 따라서 서로 다른 컨트롤러를 공장에서 생성해낸다. 
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("register")) {
			controller = new RegisterController();
			System.out.println("RegisterController..Creating...OK");
			
		}else if(command.equals("find")) {
			controller = new FindController();
			System.out.println("FindController..Creating...OK");
			
		}else if(command.equals("update")) {
			controller = new UpdateController();
			System.out.println("UpdateController..Creating...OK");
			
		}else if(command.equals("login")) {
			controller = new LoginController();
			System.out.println("LoginController..Creating...OK");
		}
		
		return controller;
		
	}
}
