package kr.ac.kopo.kopo03.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.kopo.kopo03.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String menu(Model model) {
	    model.addAttribute("menu", boardService.viewAll());
	    return "index";
	}
}
