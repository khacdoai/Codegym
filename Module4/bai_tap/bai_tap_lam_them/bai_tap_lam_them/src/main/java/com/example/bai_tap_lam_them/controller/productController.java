package com.example.bai_tap_lam_them.controller;

import com.example.bai_tap_lam_them.model.Product;
import com.example.bai_tap_lam_them.model.ProductDTO;
import com.example.bai_tap_lam_them.model.ProductDetail;
import com.example.bai_tap_lam_them.service.IProductService;
import com.example.bai_tap_lam_them.service.IProductdetallService;
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
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class productController {
    @Autowired
    private IProductService iProductService;
    @Autowired
    private IProductdetallService iProductdetallService;
    @Autowired
    private Validator validator;

    @GetMapping()
    public String showList(Model model, @RequestParam(required = false, defaultValue = "0")int page){
        Sort sort = Sort.by("ten").descending();
        Pageable pageable = PageRequest.of(page,5,sort);
        Page<Product> list = iProductService.showlist(pageable);
        model.addAttribute("list", list);
        model.addAttribute("product", new Product());
        return "result";
    }
    @GetMapping("/search")
    public String searchByName(Model model, @RequestParam(required = false) String name, @RequestParam(required = false, defaultValue = "0")int page){
        Sort sort = Sort.by("ten").descending();
        Pageable pageable = PageRequest.of(page,5,sort);
        Page<Product> list = iProductService.searchByName(pageable,name);
        model.addAttribute("list", list);
        model.addAttribute("product", new Product());
        return "result";
    }
    @PostMapping("/delete")
    public String delelete(@RequestParam int id){
        iProductService.delete(Long.valueOf(id));
        return "redirect:/";
    }
    @GetMapping("/create")
    public String showFormCreate(Model model){
        List<ProductDetail> listProductDetail = iProductdetallService.showList();
        model.addAttribute("listProductDetail",listProductDetail);
        model.addAttribute("product",new Product());
        return "create";
    }
    @PostMapping("/create")
    public String create (@Valid @ModelAttribute("") ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model){
        new ProductDTO().validate(productDTO,bindingResult);
        validator.validate(productDTO, bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listProductDetail",iProductdetallService.showList());
            return "create";

        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO,product);
        iProductService.add(product);
        redirectAttributes.addFlashAttribute("msg", "Thành Công");
        return "redirect:/";
    }
    @GetMapping("/update/{id}")
    public String showFormUpdate( Model model, @PathVariable long id){
        List<ProductDetail> listProductDetail = iProductdetallService.showList();
        Product product = iProductService.selectById(id);
        model.addAttribute("product", product);
//        model.addAttribute("product",new Product());
        model.addAttribute("listProductDetail",listProductDetail);
        return "update";
    }
    @PostMapping("/update/{id}")
    public String update(@Valid @ModelAttribute("product") ProductDTO productDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes,Model model ){
        new ProductDTO().validate(productDTO,bindingResult);
        if(bindingResult.hasErrors()){
            model.addAttribute("listProductDetail",iProductdetallService.showList());
            return "update";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        iProductService.update(product);
        return "redirect:/";
    }

}
