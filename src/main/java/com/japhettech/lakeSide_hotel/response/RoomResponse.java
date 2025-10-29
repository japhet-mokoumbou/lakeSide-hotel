package com.japhettech.lakeSide_hotel.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import org.apache.commons.codec.binary.Base64;
import java.util.List;

@Data
@NoArgsConstructor
public class RoomResponse {

    private Long id;

    private String roomType;

    private BigDecimal roomPrice;

    private boolean isBooked;

    private List<BookingResponse> bookings;

    private String photo;

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, List<BookingResponse> bookings, byte[] photoBytes) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.bookings = bookings;
        this.photo = photoBytes != null ? Base64.encodeBase64String(photoBytes) : null;
    }
}
