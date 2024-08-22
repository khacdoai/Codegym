package org.c07.movie_booking.repository;
import org.c07.movie_booking.dto.BookingDTO;
import org.c07.movie_booking.dto.response.BookingResDTO;
import org.c07.movie_booking.model.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface IBookingRepository extends JpaRepository<Booking,Long> {
    // Danh sách vé chưa in- role nhân viên hoặc admin
@Query(value = "SELECT new org.c07.movie_booking.dto.response.BookingResDTO(b.id, b.codeBooking, m.nameMovie, s.showDate, s.startTime, b.totalAmount, b.receive, u.name, u.cardId, u.phoneNumber, u.code, ss.seatNumber, r.roomName) " +
        "FROM Booking b " +
        "JOIN b.showTime s " +
        "JOIN s.movie m " +
        "JOIN s.room r " +
        "JOIN b.user u " +
        "JOIN b.seat ss " +
        "WHERE b.receive = false AND (b.codeBooking LIKE %:valueSearch% OR u.code LIKE %:valueSearch% OR u.cardId LIKE %:valueSearch% OR u.phoneNumber LIKE %:valueSearch%)",
        countQuery = "SELECT COUNT(b) " +
                "FROM Booking b " +
                "JOIN b.showTime s " +
                "JOIN s.movie m " +
                "JOIN s.room r " +
                "JOIN b.user u " +
                "JOIN b.seat ss " +
                "WHERE b.receive = false AND (b.codeBooking LIKE %:valueSearch% OR u.code LIKE %:valueSearch% OR u.cardId LIKE %:valueSearch% OR u.phoneNumber LIKE %:valueSearch%)")
    Page<BookingResDTO> SearchBookings(@Param("valueSearch") String valueSearch, Pageable pageable);
    // Danh sách vé của riêng từng khách hàng
    @Query("SELECT new org.c07.movie_booking.dto.BookingDTO(m.nameMovie, b.dateBooking, b.totalAmount, bs.name) " +
            "FROM Booking b " +
            "JOIN b.showTime s " +
            "JOIN s.movie m " +
            "JOIN b.bookingStatus bs")
    List<BookingDTO> findBookingDetails();
    // Tìm vé và xem chi tiết vé theo Id
    @Query(value = "SELECT new org.c07.movie_booking.dto.response.BookingResDTO(b.id, b.codeBooking, m.nameMovie, s.showDate, s.startTime, b.totalAmount, b.receive, u.name, u.cardId, u.phoneNumber, u.code, ss.seatNumber, r.roomName) " +
            "FROM Booking b " +
            "JOIN b.showTime s " +
            "JOIN s.movie m " +
            "JOIN s.room r " +
            "JOIN b.user u " +
            "JOIN b.seat ss " +
            "WHERE b.receive = false AND b.id = ?1",
            countQuery = "SELECT COUNT(b) " +
                    "FROM Booking b " +
                    "JOIN b.showTime s " +
                    "JOIN s.movie m " +
                    "JOIN s.room r " +
                    "JOIN b.user u " +
                    "JOIN b.seat ss " +
                    "WHERE b.receive = false AND b.id = ?1")
    Optional<BookingResDTO> findBookingResDTOById(Long id);
    // Nhận vé
    @Modifying
    @Transactional
    @Query(value = "update booking set receive = 1 where id = ?1", nativeQuery = true)
    void receiveBookingById( Long id);
}
