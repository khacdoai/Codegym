package com.example.sping_boot.controller;


import com.example.sping_boot.model.Student;
import com.example.sping_boot.service.ICodeGymClassService;
import com.example.sping_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodeGymClassService iCodeGymClassService;


    @GetMapping()
    public ResponseEntity<?> showList(@RequestParam(required = false, defaultValue = "0") int page) { // handle method
        Sort sort = Sort.by("name").descending();
        // Page là trang hiện tại
        // Pagesize là số lượng record mỗi trang
        // sort là trường cần sắp xếp.
        Pageable pageable = PageRequest.of(page, 2, sort);
        Page<Student> list = iStudentService.showList(pageable);
        List<Student> list1 = list.getContent();
        // Tương tự request.setAttribute()
//        model.addAttribute("list", list);
        return new  ResponseEntity<>(list1, HttpStatus.OK);
    }
    @GetMapping("search")
    public String searchByName(Model model, @RequestParam(required = false, defaultValue = "0")int page, String name){
        Sort sort = Sort.by("name").descending();

        Pageable pageable = PageRequest.of(page, 2,sort);
        Page<Student> list = iStudentService.SearchByName(pageable,name);
        model.addAttribute("list",list);
        return "result";
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll());
        model.addAttribute("student", new Student());
        return "create";
    }

    @PostMapping("create")
    public ResponseEntity<?> add(@RequestBody Student student) {
        iStudentService.add(student);
        return new  ResponseEntity<>(HttpStatus.CREATED);
    }

}
