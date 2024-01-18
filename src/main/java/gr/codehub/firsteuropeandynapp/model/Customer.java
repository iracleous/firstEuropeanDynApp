package gr.codehub.firsteuropeandynapp.model;

import lombok.*;

import java.sql.Date;

@Data
//avoiding boilerplate code

//model, entity, domain,
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date registrationDate;
}
