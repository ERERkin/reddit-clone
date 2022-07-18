package kg.erkin.springbackend.service.base;

import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.entity.base.BaseEntity;

import java.util.List;

public interface BaseEntityService<E extends BaseEntity> {
    E getById(Long id);

    E save(E entity);

    List<E> getAll();

    void deleteById(Long id);
}
