package com.haeun.ch1301;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IdController {
	@RequestMapping("/")
	//요청 처리 메소드
	public String index() {
		return "index";
	}
	//method 쓸 때 앞에 value 명시(안하면 405에러)
	@RequestMapping(value = "/idoutput", method = RequestMethod.GET) //요청이 오면
	public String idoutput(@RequestParam("id") String id, Model model) {
		System.out.println("GET 방식 실행됨!");
		model.addAttribute("id", id);	
		
		return "idoutput";
	}
	
	@RequestMapping(value = "/idoutput", method = RequestMethod.POST) //요청이 오면
	//매개변수, 반환타입만 다르게(오버로딩)
	public String idoutput(HttpServletRequest request, Model model) {
		
		System.out.println("POST 방식 실행됨!");
		String id = request.getParameter("id");
		model.addAttribute("id", id);	
		
		return "idoutput";
	}
	
	@RequestMapping("/join")	//join 요청이 들어오면
	public String join() {
		return "join";
	}
	
	@RequestMapping("/joinOk")
	//@ModelAttribute 어노테이션으로 객체 이름 변경
	public String joinOk(@ModelAttribute("sInfo") StudentInformationThird studentInformationThird) {
		return "joinOk";
	}
}
