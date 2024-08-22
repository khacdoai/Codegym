package com.example.demo_bai_1.controller;

import com.example.demo_bai_1.model.Student;
import com.example.demo_bai_1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class StudenController {
    @Autowired
    private IStudentService studentService;

    @GetMapping()
    public String showList(Model model){
        List<Student> list = studentService.showList();
        model.addAttribute("list", list);
        return "list";
    }
    @GetMapping("/edit")
    public String showFormEdit(Model model, @RequestParam int id){
        Student student = studentService.selectStudent(id);
        model.addAttribute("student",student);
        return "edit";
    }
    @PostMapping("/edit")
    public String edit(@RequestParam int id, @RequestParam String hoTen, @RequestParam String email, @RequestParam String diaChi){
        Student student = new Student(id,hoTen,email,diaChi);
        studentService.updateStudent(id,student);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        studentService.deleteStudent(id);
        return "redirect:/";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        model.addAttribute("student" , new Student());
        return "create";
    }
    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student")Student student, RedirectAttributes redirectAttributes ){
        studentService.createStudent(student);
        return  "redirect:/";
    }
    @GetMapping("/search")
    public String searchStudent(Model model, @RequestParam String hoTen){
        List<Student> list = studentService.searchStudent(hoTen);
        model.addAttribute("list",list);
        return "list";
    }
}
