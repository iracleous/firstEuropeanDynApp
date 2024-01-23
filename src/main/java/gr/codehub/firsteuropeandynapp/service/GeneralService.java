package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.customexceptions.EntityException;
import gr.codehub.firsteuropeandynapp.model.Customer;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T, K> {
    T create(T model)  throws EntityException;
    List<T> read();
    Optional<T> read(K id);
    Optional<T> update(K id, T newCustomerValues);
    boolean delete(K id);
}
