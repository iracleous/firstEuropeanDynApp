package gr.codehub.firsteuropeandynapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerDto {
    private long id;
    private String name;
    private String email;
    private LocalDate registrationDate;
    private List<BookingRequestDto> bookings;
}
