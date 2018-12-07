package net.skhu.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


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
public class StudentController {
	
	private String fileLocation;
	
	@Autowired StudentMapper studentMapper;
	@Autowired MyCellMapper myCellMapper;
	
	@RequestMapping("user/index")
    public String index(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String loginId = authentication.getName();
		
		model.addAttribute("student", studentMapper.findById(loginId));
		
		MyFile myFile = new MyFile();
		model.addAttribute("myFile", myFile);
		
		
		return "user/index";
    }
	
	@RequestMapping(value="user/index", method=RequestMethod.POST)
	public String index(Model model, MyFile myFile) throws IOException {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String loginId = authentication.getName();
		
		model.addAttribute("student", studentMapper.findById(loginId));
		
		System.out.println(myFile.getFile());
		InputStream in = myFile.getFile().getInputStream();
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		fileLocation = path.substring(0,path.length()-1) + myFile.getFile().getOriginalFilename();
		FileOutputStream f = new FileOutputStream(fileLocation);
		System.out.println("파일로케이션 : " + fileLocation);
		int ch = 0;
		while((ch = in.read()) != -1) {
			f.write(ch);
			
		}
		f.flush();
		f.close();

		FileInputStream uploadFile = new FileInputStream(new File(fileLocation));
		Workbook workbook = new XSSFWorkbook(uploadFile); //xlsx
		Sheet sheet = workbook.getSheetAt(0);
		List<MyCell> data = new ArrayList<MyCell>();
		int rowMax = sheet.getPhysicalNumberOfRows();
		
		
		for(int rowIndex=1; rowIndex<rowMax; rowIndex++) {
			XSSFRow row = (XSSFRow)sheet.getRow(rowIndex);
			int cellMax = row.getLastCellNum();
			//공백이 있는 경우 인식x
			List<Object> list = new ArrayList<Object>();
			MyCell myCell = new MyCell();
			
			for(int cellIndex=0; cellIndex<cellMax; cellIndex++) {
				XSSFCell cell = row.getCell(cellIndex);
				switch(cell.getCellTypeEnum()) {
				case NUMERIC:
					list.add((int)cell.getNumericCellValue());
					break;
				case STRING:
					list.add((String)cell.getStringCellValue());
					break;
				default:
					list.add(" ");
					break;
				}
				
 			}
			
	        System.out.println("list에 담기 성공");
	        myCell.setId(loginId); 
			myCell.setYear((int)list.get(0));
			myCell.setSemester((String)list.get(1));
			myCell.setSubjectId((String)list.get(2));
			myCell.setSubjectName((String)list.get(3));
			myCell.setCompleteType((String)list.get(4));
			myCell.setSubjectScore((int)list.get(5));
			myCell.setGrade((String)list.get(6));
			
			data.add(myCell);
		}
		System.out.println("데이터 저장 성공");
		myCellMapper.insert(data);
		workbook.close();
		return "user/index";
	}
	
	@RequestMapping("user/studentEdit")
	public String studentEdit(Model model) {
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		String id = authentication.getName();
		
		Student student = studentMapper.findById(id);
		model.addAttribute("student", student);
		
		return "user/studentEdit";
	}
	
	@RequestMapping(value="user/studentEdit", method=RequestMethod.POST)
	public String studentEdit(Student student) {
		
		studentMapper.update(student);
		
		return "redirect:index";
	}
	
	
	

}
