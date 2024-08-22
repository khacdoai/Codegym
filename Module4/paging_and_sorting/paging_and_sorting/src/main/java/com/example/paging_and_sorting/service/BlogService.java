package com.example.paging_and_sorting.service;

import com.example.paging_and_sorting.model.Blog;
import com.example.paging_and_sorting.repository.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo iBlogRepo;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }

    @Override
    public Page<Blog> findByCategoryId(Long aLong, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Blog> findByNameContaining(String s, Pageable pageable) {
        return null;
    }

    @Override
    public void save(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public Blog getById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {
        iBlogRepo.deleteById(id);
    }
}
