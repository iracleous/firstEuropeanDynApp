package gr.codehub.firsteuropeandynapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class RentDto {
    private long customerId;
    private long roomId;
    private Date startingDate;
    private Date endingDate;
  }
