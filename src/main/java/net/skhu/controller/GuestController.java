package net.skhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;

@Controller
public class GuestController {
	
	@Autowired StudentMapper studentMapper;
    @RequestMapping({"/", "guest/index"})
    public String index() {
        return "guest/index";
    }

    @RequestMapping(value="guest/sign", method=RequestMethod.GET)
    public String sign(Model model) {
    	Student student = new Student();
    	model.addAttribute("student", student);
    	return "guest/sign";
    	
    }
    
    @RequestMapping(value="guest/sign", method=RequestMethod.POST)
    public String sign(Model model, Student student) {
		studentMapper.insert(student);
		return "guest/index";
    	
    }
    
    
    @RequestMapping("guest/login")
    public String login() {
        return "guest/login";
    }

}
