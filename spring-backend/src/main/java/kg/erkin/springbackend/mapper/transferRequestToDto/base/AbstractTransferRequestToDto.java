package kg.erkin.springbackend.mapper.transferRequestToDto.base;

import kg.erkin.springbackend.model.dto.api.base.BaseRequest;
import kg.erkin.springbackend.model.dto.base.BaseDto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTransferRequestToDto<D extends BaseDto, REQ extends BaseRequest> {
    public abstract D transferToDto(REQ request);

    public List<D> transferToDtoList(List<REQ> requestList){
        return requestList.stream().map(this::transferToDto).collect(Collectors.toList());
    }
}
