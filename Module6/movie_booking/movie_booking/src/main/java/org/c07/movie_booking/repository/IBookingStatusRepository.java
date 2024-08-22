package org.c07.movie_booking.repository;

import org.c07.movie_booking.model.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookingStatusRepository extends JpaRepository<BookingStatus, Integer> {
}
