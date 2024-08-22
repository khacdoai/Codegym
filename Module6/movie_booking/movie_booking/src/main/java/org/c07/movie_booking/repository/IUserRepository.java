package org.c07.movie_booking.repository;

import org.c07.movie_booking.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    //BuiTheThien
    // Show List and Search Employee
    @Query(value = "SELECT u.* " +
            "FROM user u " +
            "JOIN role r ON u.role_id = r.id " +
            "WHERE r.name = 'employee' AND u.status = false " +
            "AND (u.name LIKE %:valueSearch% OR u.code LIKE %:valueSearch%)",
            countQuery = "SELECT COUNT(*) " +
                    "FROM user u " +
                    "JOIN role r ON u.role_id = r.id " +
                    "WHERE r.name = 'employee' AND u.status = false " +
                    "AND (u.name LIKE %:valueSearch% OR u.code LIKE %:valueSearch%)", nativeQuery = true)
      Page<User> SearchEmployees(@Param("valueSearch") String valueSearch, Pageable pageable);
    // Remove Employee
    @Modifying
    @Transactional
    @Query(value = "update user set status = 1 where id = ?1", nativeQuery = true)
    void deleteEmployeeByQuery( Long id);
    // Tìm employee theo id
//    @Query(value= "select * from user where id = ?1 and status = false", nativeQuery = true)
    @Query(value = "SELECT u.* " +
            "FROM user u " +
            "JOIN role r ON u.role_id = r.id " +
            "WHERE r.name = 'employee' AND u.status = false AND u.id = ?1"
            , nativeQuery = true)
    Optional<User> findEmployeeById(Long id);
}
