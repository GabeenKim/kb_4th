package servlet.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView handleRequesAndView(HttpServletRequest request, HttpServletResponse response);
}
