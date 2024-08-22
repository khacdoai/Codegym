package org.c07.movie_booking.service;

import org.c07.movie_booking.dto.BookingDTO;
import org.c07.movie_booking.dto.response.BookingResDTO;
import org.c07.movie_booking.dto.response.UserResDTO;
import org.c07.movie_booking.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBookingService {
    // Danh sách vé của riêng từng khách hàng
    List<BookingDTO> fillAllBooking();
    // Danh sách vé chưa in- role nhân viên hoặc admin
    Page<BookingResDTO> SearchBookings(String valueSearch, Pageable pageable);
    // Tìm vé và xem chi tiết vé theo Id
    BookingResDTO findBookingResDTOById(Long id);
    //Nhận vé
    void receiveBookingById( Long id);
}
