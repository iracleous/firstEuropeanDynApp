package gr.codehub.firsteuropeandynapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.codehub.firsteuropeandynapp.model.Booking;
import gr.codehub.firsteuropeandynapp.model.Customer;
import gr.codehub.firsteuropeandynapp.model.Room;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDto {
    private long id;
    private long customerId;
    private String customerName;
    private long roomId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;


    public static BookingResponseDto createDto(Booking booking)    {
        try {
            return BookingResponseDto
                    .builder()
                    .id(booking.getId())
                    .customerId(booking.getCustomer().getId())
                    .customerName(booking.getCustomer().getName())
                    .roomId(booking.getRoom().getId())
                    .checkInDate(booking.getCheckInDate())
                    .checkOutDate(booking.getCheckOutDate())
                    .build();
        }
        catch(Exception e){
            return null;
        }
    }

}
