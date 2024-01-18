package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.model.Customer;

import java.util.List;

public interface GeneralService<T, K> {
    T create(T model);
    List<T> read();
    T read(K id);
    T update(K id, T newCustomerValues);
    boolean delete(K id);
}
