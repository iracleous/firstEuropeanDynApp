package gr.codehub.firsteuropeandynapp.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDto {
    private long customerId;
    private long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
  }
