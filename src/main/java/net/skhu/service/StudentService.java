package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.dto.Student;
import net.skhu.mapper.StudentMapper;


@Service
public class StudentService {
	@Autowired StudentMapper studentMapper;
	

	public Student login(String id, String password) {
		Student student = studentMapper.findById(id);
		if(student == null) return null;
		if(student.getPassword().equals(password) == false ) return null;
		return student;
	}
}
