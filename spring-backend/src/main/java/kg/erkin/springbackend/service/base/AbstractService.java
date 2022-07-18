package kg.erkin.springbackend.service.base;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.entity.base.BaseEntity;
import kg.erkin.springbackend.repostitory.base.BaseRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractService<
        E extends BaseEntity,
        D extends BaseDto,
        R extends BaseRepository<E>,
        ED extends AbstractTransferEntityToDto<E, D>,
        DE extends AbstractTransferDtoToEntity<E, D>> implements BaseService<D> {
    protected R repository;
    protected ED transferEntityToDto;
    protected DE transferDtoToEntity;

    public AbstractService(R repository, ED transferEntityToDto, DE transferDtoToEntity) {
        this.repository = repository;
        this.transferEntityToDto = transferEntityToDto;
        this.transferDtoToEntity = transferDtoToEntity;
    }

    @Override
    public D getById(Long id) {
        E entity = repository.findById(id).orElseThrow();
        return transferEntityToDto.transferToDto(entity);
    }

    @Transactional
    @Override
    public D save(D item) {
        E entity = repository.save(transferDtoToEntity.transferToEntity(item));
        return transferEntityToDto.transferToDto(entity);
    }

    @Transactional(readOnly = true)
    @Override
    public List<D> getAll() {
        List<E> eList = repository.findAll().stream().map(e -> (E) e).collect(Collectors.toList());
        return transferEntityToDto.transferToDtoList(eList);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
