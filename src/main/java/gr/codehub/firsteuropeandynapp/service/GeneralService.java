package gr.codehub.firsteuropeandynapp.service;

import gr.codehub.firsteuropeandynapp.exceptions.EntityException;

import java.util.List;
import java.util.Optional;

public interface GeneralService<T, K> {
    T create(T model);
    List<T> read();
    T read(K id) throws EntityException;
    T update(K id, T newValues);
    T delete(K id);
}
