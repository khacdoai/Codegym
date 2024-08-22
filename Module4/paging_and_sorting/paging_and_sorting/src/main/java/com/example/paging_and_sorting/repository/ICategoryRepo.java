package com.example.paging_and_sorting.repository;
import com.example.paging_and_sorting.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category,Long> {
}
