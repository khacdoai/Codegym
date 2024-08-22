package com.example.register.controller;

import com.example.register.model.Acount;
import com.example.register.service.IAcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class AcountControler {
    @Autowired
    IAcountService iAcountService;

    @GetMapping()
    public String showFormRegister(){
        return "index";
    }
    @PostMapping()
    public String register(@ModelAttribute("Acount")Acount acount, RedirectAttributes redirectAttributes) {
        String userName = acount.getEmail();
        String errorMessage = "";
        if(iAcountService.checkExistingAccountByAcount(userName)) {
            errorMessage = "Tên tài Khoản đã được đăng ký trước đó";
            redirectAttributes.addFlashAttribute("errorMessage",errorMessage );
            return "redirect:/";
        } else {
            iAcountService.saveAcount(acount);
            errorMessage = "Thêm mới tài khoản thành công";
            redirectAttributes.addFlashAttribute("successMessage",errorMessage );
            return "redirect:/";
        }
    }

}
