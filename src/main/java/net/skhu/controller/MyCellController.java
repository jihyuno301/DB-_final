package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import net.skhu.dto.MyCell;
import net.skhu.dto.MyFile;
import net.skhu.dto.Student;

import net.skhu.mapper.MyCellMapper;
import net.skhu.mapper.StudentMapper;

@Controller
public class MyCellController {
	
	@Autowired MyCellMapper myCellMapper;
	
	@RequestMapping("user/list")
	public String list(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String loginId = authentication.getName();
		
		model.addAttribute("list", myCellMapper.findAllById(loginId));
		
		return "user/list";
	}
	
	@RequestMapping("user/searchIndex")
	public String search() {
		return "user/search";
	}
	
	@RequestMapping("user/search")
	public String search(Model model, @RequestParam("subjectName") String subjectName) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String loginId = authentication.getName();
		
		model.addAttribute("myCell", myCellMapper.findBySubjectName(loginId, subjectName));
		
		return "user/search";
	}
}
