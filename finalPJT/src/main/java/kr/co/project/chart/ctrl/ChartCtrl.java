package kr.co.project.chart.ctrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ChartCtrl {
	@RequestMapping(value="chart_line", method=RequestMethod.GET)
	public String line(Model model) {
		System.out.println(">>> ctrl chart line");
		Map<String, List<Integer>> map = new HashMap();
		List<Integer> list01 = new ArrayList();
		list01.add(99999);
		list01.add(99999);
		list01.add(99999);
		list01.add(99999);
		list01.add(99999);
		list01.add(99999);
		list01.add(99999);
		list01.add(99999);
		map.put("Installation", list01);
		model.addAttribute("datas",map);
		return "line";
	}
}
