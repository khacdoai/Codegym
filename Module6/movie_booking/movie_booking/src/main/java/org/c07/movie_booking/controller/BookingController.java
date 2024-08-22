package org.c07.movie_booking.controller;

import org.c07.movie_booking.dto.BookingDTO;
import org.c07.movie_booking.dto.response.BookingResDTO;
import org.c07.movie_booking.dto.response.UserResDTO;
import org.c07.movie_booking.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/booking")
@CrossOrigin
public class BookingController {

    @Autowired
    private IBookingService iBookingService;

    // Danh sách vé của riêng từng khách hàng
    @GetMapping("private/booking-customer")
    public ResponseEntity<List<BookingDTO>> showList() {
        List<BookingDTO> bookings = iBookingService.fillAllBooking();
        return ResponseEntity.ok(bookings);
    }
    // Show danh sách vé chưa nhận
    @GetMapping("private/list-booking")
    public ResponseEntity<Page<BookingResDTO>> SearchBookings(
            @RequestParam(value = "valueSearch", defaultValue = "") String valueSearch,
            @RequestParam("page") Optional<Integer> page) {
        System.out.println("ValueSearch: " + valueSearch);
        int currentPage = page.map(p -> Math.max(p, 0)).orElse(0);
        Pageable pageable = PageRequest.of(currentPage, 5);
        Page<BookingResDTO> bookings = iBookingService.SearchBookings(
                valueSearch, pageable);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }
    // Tìm vé theo Id
    @GetMapping("private/booking-details/{id}")
    public ResponseEntity<BookingResDTO> findEmployeeById(@PathVariable Long id) {
        BookingResDTO bookingResDTO = iBookingService.findBookingResDTOById(id);
        return ResponseEntity.ok(bookingResDTO);
    }
    // Nhận vé
    @PutMapping("private/receive-booking/{id}")
    public ResponseEntity<String> receiveBookingById(@PathVariable Long id) {
        BookingResDTO bookingResDTO = iBookingService.findBookingResDTOById(id);
        if (bookingResDTO == null) {
            return new ResponseEntity<>("Booking not found to receive !", HttpStatus.BAD_REQUEST);
        }
        iBookingService.receiveBookingById(id);
        return new ResponseEntity<>("Received Booking successfully.", HttpStatus.OK);
    }
}