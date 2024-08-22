package com.example.thi.controller;

import com.example.thi.modell.DoanhNghiep;
import com.example.thi.modell.DuAn;
import com.example.thi.modell.DuAnDTO;
import com.example.thi.service.IDoanhNghiepService;
import com.example.thi.service.IDuAnService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/")
public class duAnController {
    @Autowired
    private IDuAnService iDuAnService;
    @Autowired
    private IDoanhNghiepService iDoanhNghiepService;

    @GetMapping("")
    public String showList(Model model,@RequestParam(required = false) String name ,@RequestParam(required = false, defaultValue = "0")int page,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String startDate,
                           @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") String endDate){
        Pageable pageable = PageRequest.of(page,2);
        Page<DuAn> list;
        if(name != null & startDate != null & endDate != null){
            list = iDuAnService.searchByNameAndDate(pageable,name,startDate,endDate);
        }else {
            list = iDuAnService.showList(pageable);
        }
        model.addAttribute("list",list);
        model.addAttribute("duAn", new DuAn());
        model.addAttribute("search",name);
        model.addAttribute("startDate",startDate);
        model.addAttribute("endDate", endDate);
        return "result";

    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        List<DoanhNghiep> doanhNghiepList = iDoanhNghiepService.showList();
        model.addAttribute("doanhNghiepList",doanhNghiepList);
        model.addAttribute("duAn",new DuAn());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("duAn") DuAnDTO duAnDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new DuAnDTO().validate(duAnDTO, bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("doanhNghiepList",iDoanhNghiepService.showList());
            return "create";
        }
        DuAn duAn = new DuAn();
        BeanUtils.copyProperties(duAnDTO,duAn);
        iDuAnService.create(duAn);
        return "redirect:/";
    }
    @GetMapping("/chiTiet")
    public String showForm(Model model){

        return "chiTiet";
    }

}
