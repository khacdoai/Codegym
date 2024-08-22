package com.example.thi2.controller;

import com.example.thi2.model.DanhMuc;
import com.example.thi2.model.TinTuc;
import com.example.thi2.model.TinTucDTO;
import com.example.thi2.service.IDanhMucService;
import com.example.thi2.service.ITinTucService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class tinTucController {
    @Autowired
    IDanhMucService iDanhMucService;
    @Autowired
    ITinTucService iTinTucService;

    @GetMapping("")
    public String showList(Model model, @RequestParam(required = false) String name, @RequestParam(required = false) Integer danhMuc , @RequestParam(required = false, defaultValue = "0")int page) {
        Pageable pageable = PageRequest.of(page,5);
        Page<TinTuc> list;
        if(name != null ){
            list = iTinTucService.search(pageable,name,danhMuc);
        }else {
            list = iTinTucService.hienThi(pageable);
        }
        model.addAttribute("list",list);
        model.addAttribute("listDanhMuc",iDanhMucService.hienThi());
        model.addAttribute("name",name);
        model.addAttribute("danhMuc",danhMuc);
        return "result";
    }
    @GetMapping("/create")
    public String themMoi(Model model){
        List<DanhMuc> listDanhMuc = iDanhMucService.hienThi();
        model.addAttribute("listDanhMuc", listDanhMuc);
        model.addAttribute("tinTuc", new TinTuc());
        return "create";
    }
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("tinTuc") TinTucDTO tinTucDTO, BindingResult bindingResult, Model model) {
        new TinTucDTO().validate(tinTucDTO,bindingResult);
        if (bindingResult.hasErrors()){
            model.addAttribute("listDanhMuc",iDanhMucService.hienThi());
            return "create";
        }
        TinTuc tinTuc = new TinTuc();
        BeanUtils.copyProperties(tinTucDTO,tinTuc);
        iTinTucService.themMoi(tinTuc);
        return "redirect:/";
    }
    @PostMapping("/delete")
    public String delelete(@RequestParam int id){
        iTinTucService.Xoa(Long.valueOf(id));
        return "redirect:/";
    }
    @GetMapping("/chiTiet/{id}")
    public ResponseEntity<TinTuc> hienthi(@PathVariable int id){
        TinTuc tinTuc = iTinTucService.selecter((long) id);
        return new ResponseEntity<>(tinTuc,HttpStatus.OK);
    }
    }

