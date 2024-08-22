package org.c07.movie_booking.service.implement;

import org.c07.movie_booking.dto.BookingDTO;
import org.c07.movie_booking.dto.response.BookingResDTO;
import org.c07.movie_booking.model.Booking;
import org.c07.movie_booking.model.User;
import org.c07.movie_booking.repository.IBookingRepository;
import org.c07.movie_booking.service.IBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService implements IBookingService {
    @Autowired
    private IBookingRepository iBookingRepository;
    // Danh sách vé của riêng từng khách hàng
    @Override
    public List<BookingDTO> fillAllBooking() {
        return iBookingRepository.findBookingDetails();
    }
    // Danh sách vé chưa in- role nhân viên hoặc admin
    @Override
    public Page<BookingResDTO> SearchBookings(String valueSearch, Pageable pageable) {
        return iBookingRepository.SearchBookings(valueSearch, pageable) ;
    }
    // Tìm vé và xem chi tiết vé theo Id
    @Override
    public BookingResDTO findBookingResDTOById(Long id) {
        BookingResDTO bookingResDTO = iBookingRepository.findBookingResDTOById(id).orElse(null);
        if (bookingResDTO == null || bookingResDTO.getReceive()) {
            return null;
        } else {
            return bookingResDTO;
        }
    }
    // Nhận vé
    @Override
    public void receiveBookingById(Long id) {
        iBookingRepository.receiveBookingById(id);
    }

}
