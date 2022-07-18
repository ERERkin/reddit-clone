package kg.erkin.springbackend.service.base;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.entity.base.BaseEntity;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractEntityService<
        E extends BaseEntity,
        R extends BaseRepository<E>
        > implements BaseEntityService<E> {
    protected R repository;

    public AbstractEntityService(R repository) {
        this.repository = repository;
    }

    @Override
    public E getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Transactional
    @Override
    public E save(E entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<E> getAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
