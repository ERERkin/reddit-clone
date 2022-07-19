package kg.erkin.springbackend.mapper.transferEntityToDto.base;

import kg.erkin.springbackend.model.dto.base.BaseDto;
import kg.erkin.springbackend.model.entity.base.BaseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTransferEntityToDto<E extends BaseEntity, D extends BaseDto>{
    public abstract D transferToDto(E entity);

    public List<D> transferToDtoList(List<E> entityList) {
        return entityList == null ? new ArrayList<>() :
                entityList.stream()
                        .map(this::transferToDto)
                        .collect(Collectors.toList());
    }
}
