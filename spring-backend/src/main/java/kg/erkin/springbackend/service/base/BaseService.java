package kg.erkin.springbackend.service.base;

import kg.erkin.springbackend.model.dto.base.BaseDto;

import java.util.List;

public interface BaseService<D extends BaseDto> {
    D getById(Long id);

    D save(D item);

    List<D> getAll();

    void deleteById(Long id);
}
