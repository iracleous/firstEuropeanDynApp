package gr.codehub.firsteuropeandynapp.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
//avoiding boilerplate code

//model, entity, domain,
public class Customer {
    public int id;
    private String name;
    private String email;
    private Date registrationDate;
}
