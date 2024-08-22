package org.c07.movie_booking.model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String codeBooking;
    private boolean receive;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateBooking;
    private double totalAmount;
    @ManyToOne
    @JoinColumn(name = "booking_status_id")
    private BookingStatus bookingStatus;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showTime;
    @ManyToOne
    @JoinColumn(name = "seat_id")
    private Seat seat;

    public Booking() {
    }

    public Booking(long id, String codeBooking, boolean receive, LocalDate dateBooking, double totalAmount, BookingStatus bookingStatus, User user, Showtime showTime, Seat seat) {
        this.id = id;
        this.codeBooking = codeBooking;
        this.receive = receive;
        this.dateBooking = dateBooking;
        this.totalAmount = totalAmount;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.showTime = showTime;
        this.seat = seat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCodeBooking() {
        return codeBooking;
    }

    public void setCodeBooking(String codeBooking) {
        this.codeBooking = codeBooking;
    }

    public boolean isReceive() {
        return receive;
    }

    public void setReceive(boolean receive) {
        this.receive = receive;
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

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Showtime getShowTime() {
        return showTime;
    }

    public void setShowTime(Showtime showTime) {
        this.showTime = showTime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
