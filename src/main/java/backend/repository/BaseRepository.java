package backend.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

// This is a base repository interface, as recommended by Spring Data documentation
// Use this interface for general CRUD functionality, and add more interfaces for specific functionality
@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends Repository<T, ID> {

    List<T> findAll();

    T findOne(ID id);

    T save(T entity);

    void delete(ID id);

}
