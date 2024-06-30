package com.apiautomation.day_27June2024.gson.serialization;

public class BookingResponse {
    private Integer bookingid;
    private BookingData bookingData;

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingData getBookingData() {
        return bookingData;
    }

    public void setBookingData(BookingData bookingData) {
        this.bookingData = bookingData;
    }

}
