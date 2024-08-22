package com.example.sping_boot.controller;


import com.example.sping_boot.model.Student;
import com.example.sping_boot.model.StudentDTO;
import com.example.sping_boot.service.ICodeGymClassService;
import com.example.sping_boot.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:63343")
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ICodeGymClassService iCodeGymClassService;


    @GetMapping()
    public ResponseEntity<?> showList(Model model, @RequestParam(required = false, defaultValue = "0") int page) { // handle method
        Sort sort = Sort.by("name").descending();
        // Page là trang hiện tại
        // Pagesize là số lượng record mỗi trang
        // sort là trường cần sắp xếp.
        Pageable pageable = PageRequest.of(page, 5, sort);
        Page<Student> listStudent = iStudentService.showList(pageable);
        List<Student> list = listStudent.getContent();
        // Tương tự request.setAttribute()
//        model.addAttribute("list", list);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("create")
    public String showCreateForm(Model model) {
        model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll());
        model.addAttribute("student", new StudentDTO());
        return "create";
    }

    @PostMapping("create")
    public ResponseEntity<?> add(@RequestBody StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        iStudentService.add(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @DeleteMapping("delete")
    public ResponseEntity<?> delete(@RequestParam Long id ){
        iStudentService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

}
