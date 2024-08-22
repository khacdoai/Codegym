package org.c07.movie_booking.controller;

import org.c07.movie_booking.dto.response.UserResDTO;
import org.c07.movie_booking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({"/api/v1/user"})
public class UserController {
    @Autowired
    IUserService iUserService;
    //Show List and Search Employee
    @GetMapping("private/list-employee")
    public ResponseEntity<Page<UserResDTO>> searchEmployees(
            @RequestParam(value = "valueSearch", defaultValue = "") String valueSearch,
            @RequestParam("page") Optional<Integer> page) {

        System.out.println("Search criteria:");
        System.out.println("Name: " + valueSearch);

        int currentPage = page.map(p -> Math.max(p, 0)).orElse(0);
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<UserResDTO> employees = iUserService.searchEmployees(
                valueSearch, pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    // Remove Employee
    @PutMapping("private/delete-employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        UserResDTO userResDTO = iUserService.findEmployeeById(id);
        if (userResDTO == null) {
            return new ResponseEntity<>("Employee not found to delete !", HttpStatus.BAD_REQUEST);
        }
        iUserService.deleteEmployeeById(id);
        return new ResponseEntity<>("Delete employee successfully.", HttpStatus.OK);
    }
}
