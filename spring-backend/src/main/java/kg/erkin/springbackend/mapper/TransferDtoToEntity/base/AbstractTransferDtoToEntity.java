package kg.erkin.springbackend.mapper.TransferDtoToEntity.base;

import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.entity.base.BaseEntity;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTransferDtoToEntity<E extends BaseEntity, D extends BaseDto> {
    public abstract E transferToEntity(D dto);

    public List<E> transferToEntityList(List<D> dtoList) {
        return dtoList.stream().map(this::transferToEntity).collect(Collectors.toList());
    }
}