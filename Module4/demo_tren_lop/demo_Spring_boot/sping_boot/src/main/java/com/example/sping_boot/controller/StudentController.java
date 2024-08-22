package com.example.sping_boot.controller;


import com.example.sping_boot.model.Student;
import com.example.sping_boot.service.ICodeGymClassService;
import com.example.sping_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodeGymClassService iCodeGymClassService;


    @GetMapping()
    public String showList(Model model) { // handle method
        List<Student> list = iStudentService.showList();
//        Tương tự request.setAttribute()
        model.addAttribute("list", list);
        return "result";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll());
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping( "create")
    public String add(@ModelAttribute("student") Student student,
                      RedirectAttributes redirectAttributes) {
        iStudentService.add(student);
        redirectAttributes.addFlashAttribute("msg", "Thành Công");
        return "redirect:/";
    }

}
