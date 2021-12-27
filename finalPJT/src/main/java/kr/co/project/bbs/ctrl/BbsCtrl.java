package kr.co.project.bbs.ctrl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.project.bbs.model.vo.BbsVO;
import kr.co.project.bbs.service.BbsService;

@Controller
public class BbsCtrl {
	@Resource(name="bbsS")
	private BbsService service;
	
	@RequestMapping(value="bbs_list", method=RequestMethod.GET)
	public String list(Model model) {
		System.out.println(">>> bbs ctrl list");
		List<Object> list = service.listService();
		
		model.addAttribute("boards", list);
		return "listAll";
	}
	
	@RequestMapping(value="bbs_read", method=RequestMethod.GET)
	public String read(Model model, BbsVO bbs) {
		System.out.println(">>> bbs ctrl read");
		service.upCntService(bbs);
		Object obj = service.readService(bbs);
		
		model.addAttribute("bbs", obj);
		return "read2";
	}
	
	@RequestMapping(value="bbs_registerForm", method=RequestMethod.GET)
	public String registerForm(Model model) {
		System.out.println(">>> bbs ctrl registerForm");
		
		return "register";
	}
}
