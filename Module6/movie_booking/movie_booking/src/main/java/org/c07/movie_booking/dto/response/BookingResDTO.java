package org.c07.movie_booking.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class BookingResDTO {
    private long id;
    private String codeBooking;
    private String nameMovie;
    private LocalDate showDate;
    private LocalTime startTime;
    private double totalAmount;
    private Boolean receive;
    private String nameUser;
    private String cardIdUser;
    private String phoneNumberUser;
    private String codeUser;
    private String seatNumber;
    private String roomName;

    public BookingResDTO() {
    }

    public BookingResDTO(long id, String codeBooking, String nameMovie, LocalDate showDate, LocalTime startTime, double totalAmount, Boolean receive, String nameUser, String cardIdUser, String phoneNumberUser, String codeUser, String seatNumber, String roomName) {
        this.id = id;
        this.codeBooking = codeBooking;
        this.nameMovie = nameMovie;
        this.showDate = showDate;
        this.startTime = startTime;
        this.totalAmount = totalAmount;
        this.receive = receive;
        this.nameUser = nameUser;
        this.cardIdUser = cardIdUser;
        this.phoneNumberUser = phoneNumberUser;
        this.codeUser = codeUser;
        this.seatNumber = seatNumber;
        this.roomName = roomName;
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

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public LocalDate getShowDate() {
        return showDate;
    }

    public void setShowDate(LocalDate showDate) {
        this.showDate = showDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getReceive() {
        return receive;
    }

    public void setReceive(Boolean receive) {
        this.receive = receive;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getCardIdUser() {
        return cardIdUser;
    }

    public void setCardIdUser(String cardIdUser) {
        this.cardIdUser = cardIdUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getCodeUser() {
        return codeUser;
    }

    public void setCodeUser(String codeUser) {
        this.codeUser = codeUser;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
