package com.example.spring_boot.controller;


import com.example.spring_boot.model.Student;
import com.example.spring_boot.service.ICodeGymClassService;
import com.example.spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String showList(Model model, @RequestParam(required = false, defaultValue = "0")int page) { // handle method
        Sort sort = Sort.by("name").descending();

        Pageable pageable = PageRequest.of(page , 2, sort);
        Page<Student> list = iStudentService.showList(pageable);
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
