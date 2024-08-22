package org.c07.movie_booking.service;

import org.c07.movie_booking.dto.response.UserResDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {
    //Show List and Search Employee
    Page<UserResDTO> searchEmployees(String valueSearch, Pageable pageable);
    // Remove Employee
    void deleteEmployeeById(Long id);
    // Tìm employee theo id
    UserResDTO findEmployeeById(Long id);
}
