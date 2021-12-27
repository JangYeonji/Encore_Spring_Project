package kr.co.project.user.ctrl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.project.user.model.vo.UserVO;
import kr.co.project.user.service.UserService;

@Controller
public class UserCtrl {
	@Resource(name="userS")
	private UserService service;
	
	@RequestMapping(value="sign-in", method=RequestMethod.GET)
	public String loginForm() {
		System.out.println(">>> user ctrl loginForm");
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void login(UserVO user, HttpSession session, Model model) {
		System.out.println(">>> user ctrl login");
		System.out.println(">>> param : " + user.getId() + "\t" + user.getPwd());
		
		Object obj = service.loginService(user);
		//session.setAttribute("loginUser", obj);
		model.addAttribute("loginUser",obj);
		//return "home";
	}
	
	@RequestMapping(value="logout", method=RequestMethod.GET)
	public void logout(UserVO user, HttpSession session) {
		System.out.println(">>> user ctrl logout");
		
//		session.invalidate();
//		return "home";
	}
	
	@RequestMapping(value="joinForm", method=RequestMethod.GET)
	public String joinForm() {
		System.out.println(">>> user ctrl joinForm");
		return "join";
	}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(UserVO user) {
		System.out.println(">>> user ctrl join");
		System.out.println(">>> param : " + user.getId() + "\t" + user.getPwd() + "\t" + user.getName());
		
		int flag = service.joinService(user);
		if (flag!=0) {
			return "login";
		}else {
			return "join";
		}
		
	}
}
