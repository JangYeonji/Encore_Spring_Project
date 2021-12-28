package kr.co.project.bbs.ctrl;

import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.project.bbs.model.vo.BbsVO;
import kr.co.project.bbs.model.vo.FilterVO;
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
	
	@RequestMapping(value="bbs_remove", method=RequestMethod.GET)
	public String remove(BbsVO bbs) {
		System.out.println(">>> bbs ctrl remove");
		int flag = service.removeService(bbs);
		
		return "redirect:/bbs_list";
	}
	@RequestMapping(value="bbs_register", method=RequestMethod.POST)
	public String register(BbsVO bbs) {
		System.out.println(">>> bbs ctrl register");
		int flag = service.registerService(bbs);
		
		return "redirect:/bbs_list";
	}
	
	@RequestMapping(value="bbs_modifyForm", method=RequestMethod.GET)
	public String modifyForm(BbsVO bbs, Model model) {
		System.out.println(">>> bbs ctrl modifyForm");
		Object obj = service.readService(bbs);
		model.addAttribute("bbs", obj);
		return "modify";
	}
	
	@RequestMapping(value="bbs_modify", method=RequestMethod.GET)
	public String modify(BbsVO bbs) {
		System.out.println(">>> bbs ctrl modify");
		int flag = service.updateService(bbs);
		System.out.println(bbs);
		//return "redirect:/bbs_list";
		return "redirect:/bbs_read?seq="+bbs.getSeq();
	}
	
	@RequestMapping(value="bbs_search", method=RequestMethod.POST)
	@ResponseBody   //Ajax ��� ������̼�
	public List<Object> search(FilterVO search) {
		System.out.println(">>> bbs ctrl search");
		System.out.println(">>> param : " + search.getSearchCondition() + ", " + search.getSearchKeyword());
		List<Object> list = service.searchService(search);
		
		return list;
	}
}
