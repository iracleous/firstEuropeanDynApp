package gr.codehub.firsteuropeandynapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelApiResult<T> {
    private T data;
    private int statusCode;
    private String message;
}

