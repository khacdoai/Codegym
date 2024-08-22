package com.example.springboot.controller;

import com.example.springboot.model.Student;
import com.example.springboot.model.StudentDTO;
import com.example.springboot.service.ICodeGymClassService;
import com.example.springboot.service.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class StudentController {
@Autowired
    private ICodeGymClassService iCodeGymClassService;
@Autowired
    private IStudentService iStudentService;

    @GetMapping()
    public Object showlist(Model model, @RequestParam(required = false, defaultValue = "0") int page){
    Pageable pageable = PageRequest.of(page,5);
    Page<Student> list = iStudentService.showlist(pageable);
    //        Tương tự request.setAttribute()
    model.addAttribute("list",list);
    model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll());
    model.addAttribute("student", new StudentDTO());
    return "result";
    }

    @PostMapping("create")
    public String add(@Valid @ModelAttribute("student")StudentDTO studentDTO,
                      BindingResult bindingResult,
                      RedirectAttributes redirectAttributes,
                      Model model){
        new StudentDTO().validate(studentDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listCodeGymClass", iCodeGymClassService.findAll());
            return "result";
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);
        iStudentService.add(student);
        redirectAttributes.addFlashAttribute("msg","thanh cong");
        return "redirect:/";
    }

    @GetMapping("delete")
        public String showDelete(@RequestParam long id){
        iStudentService.remove(id);
        return "redirect:/";

    }

     @GetMapping("update/{id}")
        public ModelAndView update(@PathVariable Long id, Model model){
        Student student = iStudentService.findById(id);
        if (student != null){
            ModelAndView modelAndView = new ModelAndView("result");
            model.addAttribute("listCodeGymClass",iCodeGymClassService.findAll());
            modelAndView.addObject("student", student);
            return modelAndView;
        }
        else {
            return new ModelAndView("error_404");
        }
    }

    @PostMapping("update/{id}")
    public String processUpdate(@PathVariable Long id,
                                @Valid @ModelAttribute("student") StudentDTO studentDTO,
                                BindingResult bindingResult,
                                RedirectAttributes redirectAttributes) {
        // Validate dữ liệu nhập vào từ form
        new StudentDTO().validate(studentDTO, bindingResult);

        // Kiểm tra xem có lỗi validate hay không
        if (bindingResult.hasErrors()) {
            // Nếu có lỗi, chuyển hướng trở lại trang cập nhật với thông báo lỗi
            return "result";
        }

        // Tìm sinh viên thông qua id
        Student existingStudent = iStudentService.findById(id);

        // Kiểm tra xem sinh viên có tồn tại không
        if (existingStudent != null) {
            // Copy dữ liệu từ StudentDTO sang Student entity
            BeanUtils.copyProperties(studentDTO, existingStudent);

            // Lưu thông tin cập nhật của sinh viên
            iStudentService.add(existingStudent);

            // Thêm thông báo cập nhật thành công vào flash attributes
            redirectAttributes.addFlashAttribute("msg", "Cập nhật thông tin sinh viên thành công");

            // Chuyển hướng về trang chính sau khi cập nhật thành công
            return "redirect:/";
        } else {
            // Nếu không tìm thấy sinh viên, chuyển hướng đến trang 404
            return "redirect:/error_404";
        }
    }
}
