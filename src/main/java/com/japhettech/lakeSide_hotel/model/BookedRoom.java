package com.japhettech.lakeSide_hotel.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long bookingId;

      @Column(name = "check_in")
      private LocalDate checkInDate;

      @Column(name = "check_out")
      private LocalDate checkOutDate;

        @Column(name = "guest_fullName")
        private String guestFullName;

        @Column(name = "guest_email")
        private String guestEmail;

        @Column(name = "children")
        private int numOfChildren;

        @Column(name = "adults")
        private int numOfAdults;

        @Column(name = "total_guest")
        private int totalNumOfGuest;

        @Column(name = "confirmation_code")
        private String bookingConfirmationCode;

        // Pour le chargement à la demande uniquement
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "room_id")
        private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumOfGuest = this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public BookedRoom(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

