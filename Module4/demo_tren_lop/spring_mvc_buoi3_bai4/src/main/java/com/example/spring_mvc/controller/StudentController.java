package com.example.spring_mvc.controller;

import com.example.spring_mvc.model.Student;
import com.example.spring_mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @ModelAttribute("hobbies")
    public List<String> getHobbies(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("LOL-T1");
        hobbies.add("PL-MU");
        hobbies.add("Shopping");
        System.out.println(hobbies);
        return  hobbies;
    }

    @GetMapping()
    public String showList(Model model) { // handle method
        List<Student> list = iStudentService.showList();
//        Tương tự request.setAttribute()
        model.addAttribute("list", list);
        return "result";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        List<String> hobbies = new ArrayList<>();
        hobbies.add("LOL-T1");
        hobbies.add("PL-MU");
        hobbies.add("Shopping");
        model.addAttribute(hobbies);
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("create")
    public String add(@ModelAttribute("student") Student student,
                      RedirectAttributes redirectAttributes) {
//        Student student = new Student(3,name,email);
        iStudentService.add(student);
        redirectAttributes.addFlashAttribute("msg", "Thành Công");
        return "redirect:/";
    }

}
