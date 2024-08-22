package com.example.paging_and_sorting.service;
import com.example.paging_and_sorting.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByCategoryId(Long aLong, Pageable pageable);

    Page<Blog> findByNameContaining(String s, Pageable pageable);

    void save(Blog blog);

    Blog getById(Long id);

    void delete(Long id);
}
