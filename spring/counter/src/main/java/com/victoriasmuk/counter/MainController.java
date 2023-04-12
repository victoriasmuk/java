package com.victoriasmuk.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(HttpSession session) {
		
		if(session.getAttribute("count")==null) {
			session.setAttribute("count", 1);
		} else {
			Integer count = (Integer) session.getAttribute("count");
			count++;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	@RequestMapping("/clear")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/counter";
	}

}
