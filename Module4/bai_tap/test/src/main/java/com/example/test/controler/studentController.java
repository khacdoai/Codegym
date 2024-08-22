package com.example.test.controler;

import com.example.test.model.ClassStudent;
import com.example.test.model.Student;
import com.example.test.model.StudentDTO;
import com.example.test.repository.IClassStudentRepository;
import com.example.test.service.IClassStudentService;
import com.example.test.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class studentController {
    @Autowired
    private IClassStudentService iClassStudentService;
    @Autowired
    private IStudentService iStudentService;

    @GetMapping()
    public String showList(Model model, @RequestParam(required = false, defaultValue = "0")int page){
        Sort sort = Sort.by("ten").descending();
        Pageable pageable = PageRequest.of(page,5,sort);
        Page<Student> list = iStudentService.showList(pageable);
        model.addAttribute("list", list);
        model.addAttribute("student", new Student());
        return "result";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        List<ClassStudent> listClassStudet = iClassStudentService.showList();
        model.addAttribute("listClassStudet",listClassStudet);
        model.addAttribute("student",new Student());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("student")StudentDTO studentDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listClassStudet",iClassStudentService.showList());
            return "create";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO,student);
        iStudentService.add(student);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delete(@RequestParam int id){
        iStudentService.delete(Long.valueOf(id));
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate(Model model, @PathVariable Long id){
        List<ClassStudent> classStudentList = iClassStudentService.showList();
        Student student = iStudentService.selecterById(id);
        model.addAttribute("student", student);
        model.addAttribute("listClassStudent",classStudentList);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String Update(@Valid @ModelAttribute("student") StudentDTO studentDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model ){
        new StudentDTO().validate(studentDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listClassStudent",iClassStudentService.showList());
            return "update";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        iStudentService.update(student);

        return "redirect:/";
    }
    @GetMapping("/search")
    public String searchByName(Model model, @RequestParam(required = false) String name, @RequestParam(required = false, defaultValue = "0")int page){
        Sort sort = Sort.by("ten").descending();
        Pageable pageable = PageRequest.of(page,5,sort);
        Page<Student> list = iStudentService.searchByName(pageable,name);
        model.addAttribute("list", list);
        model.addAttribute("product", new Student());
        return "result";
    }

}
