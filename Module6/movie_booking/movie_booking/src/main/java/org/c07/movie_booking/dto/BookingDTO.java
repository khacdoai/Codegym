package org.c07.movie_booking.dto;

import java.time.LocalDate;

public class BookingDTO {
    private String nameMovie;
    private LocalDate dateBooking;
    private double totalAmount;
    private String bookingStatus;

    public BookingDTO() {
    }

    public BookingDTO(String nameMovie, LocalDate dateBooking, double totalAmount, String bookingStatus) {
        this.nameMovie = nameMovie;
        this.dateBooking = dateBooking;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public LocalDate getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(LocalDate dateBooking) {
        this.dateBooking = dateBooking;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
