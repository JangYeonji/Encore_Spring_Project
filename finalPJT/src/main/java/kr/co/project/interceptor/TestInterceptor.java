package kr.co.project.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TestInterceptor extends HandlerInterceptorAdapter{
	/*
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)   //controller 전
			throws Exception {
		System.out.println(">>> interceptor preHandle");
		response.sendRedirect("sign-in");
		return false;   //false는 controller 안태우고 view로 감
	}
	*/
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,   //controller 후
			ModelAndView modelAndView) throws Exception {
		System.out.println(">>> interceptor post");
	}

}
