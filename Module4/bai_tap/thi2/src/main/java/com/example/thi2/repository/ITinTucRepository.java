package com.example.thi2.repository;

import com.example.thi2.model.TinTuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITinTucRepository extends JpaRepository<TinTuc,Long> {
    Page<TinTuc> findAll(Pageable pageable);
    @Query("select p from TinTuc p where p.tieuDe like %?1%")
    Page<TinTuc>searchName(Pageable pageable, String name);
    @Query("select p from TinTuc p where p.tieuDe like %?1% and p.danhMuc.id = ?2")
    Page<TinTuc>searchTenAndDanhMuc(Pageable pageable, String name,Integer danhmuc);
    @Query("select p from TinTuc p where  p.danhMuc.id = ?1")
    Page<TinTuc>searchDanhMuc(Pageable pageable,Integer danhmuc);

}
