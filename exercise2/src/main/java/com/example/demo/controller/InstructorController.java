package com.example.demo.controller;

import com.example.demo.model.Instructor;
import com.example.demo.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.Table;
import java.util.List;

@Controller
@Table(name="instructor")
public class InstructorController {
    private InstructorService instructorService;
    @Autowired
    public InstructorController(InstructorService instructorService){
    super();
    this.instructorService=instructorService;
    }
    @GetMapping("/list")
    public String getInstructor(Model model)
    {
        List<Instructor> list=instructorService.getAllInstructor();
        model.addAttribute("instructors", list);
        return "list-instructors";
    }


}
