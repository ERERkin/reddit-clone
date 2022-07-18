package kg.erkin.springbackend.service.base;

import kg.erkin.springbackend.mapper.transferDtoToEntity.base.AbstractTransferDtoToEntity;
import kg.erkin.springbackend.mapper.transferEntityToDto.base.AbstractTransferEntityToDto;
import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.entity.base.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractService <
        S extends BaseEntityService <E>,
        E extends BaseEntity,
        D extends BaseDto,
        ED extends AbstractTransferEntityToDto<E, D>,
        DE extends AbstractTransferDtoToEntity<E, D>> implements BaseService<D> {
    protected S entityService;
    protected ED transferEntityToDto;
    protected DE transferDtoToEntity;

    public AbstractService(S entityService, ED transferEntityToDto, DE transferDtoToEntity) {
        this.entityService = entityService;
        this.transferEntityToDto = transferEntityToDto;
        this.transferDtoToEntity = transferDtoToEntity;
    }

    @Override
    public D getById(Long id) {
        E entity = entityService.getById(id);
        return transferEntityToDto.transferToDto(entity);
    }

    @Override
    public D save(D item) {
        E entity = transferDtoToEntity.transferToEntity(item);
        entity = entityService.save(entity);
        return transferEntityToDto.transferToDto(entity);

    }

    @Override
    public List<D> getAll() {
        List<E> entityList = entityService.getAll();
        return entityList.stream().map(entity -> transferEntityToDto.transferToDto(entity)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        entityService.deleteById(id);
    }
}
