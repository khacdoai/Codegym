package com.example.sping_boot.repository;
import com.example.sping_boot.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
//    @Query(nativeQuery = true, value = "select * from student")
//    List<Student> showList();

    Page<Student> findAll(Pageable pageable);
}
