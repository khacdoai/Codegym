package com.example.paging_and_sorting.controller;

import com.example.paging_and_sorting.model.Blog;
import com.example.paging_and_sorting.service.IBlogService;
import com.example.paging_and_sorting.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.PublicKey;
import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/blog")
    private String getListBlog(Optional<String> key_search, Optional<Long> cateId, Model model,
                               @PageableDefault(size=2) Pageable pageable) {
        model.addAttribute("categoryList",iCategoryService.findAll());

        // th ko nhap vao o tim kiem name
        if(!key_search.isPresent() || key_search.get().equals("")){
            //th ko nhap vao o tim kiem cateId va name
            if(!cateId.isPresent()){
                model.addAttribute("blogList",iBlogService.findAll(pageable));
            }else{
                // th ko nhap vao o name ma nhap vao o cateID
                model.addAttribute("cateId",cateId.get());
                model.addAttribute("blogList",iBlogService.findByCategoryId(cateId.get(),pageable));
            }
        }else {
            // th nhap vao o name
            model.addAttribute("key_search",key_search.get());
            model.addAttribute("blogList",iBlogService.findByNameContaining(key_search.get(),pageable));
        }
        return "index";
    }


    @GetMapping("/createShow")
    public String showCreate(Model model){
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList",iCategoryService.findAll());
        return "create";
    }
    @PostMapping("create")
    public String create(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes){
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "them moi thanh cong");
        return "redirect:/blog";
    }

    @GetMapping("{id}/delete")
    private String delete(@PathVariable Long id, RedirectAttributes redirectAttributes){
        iBlogService.delete(id);
        redirectAttributes.addFlashAttribute("message","delete thanh cong");
        return "redirect:/blog";
    }
}
