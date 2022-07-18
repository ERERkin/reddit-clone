package kg.erkin.springbackend.mapper.transferDtoToResponse.base;

import kg.erkin.springbackend.model.dto.api.base.BaseResponse;
import kg.erkin.springbackend.model.dto.base.BaseDto;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTransferDtoToResponse <D extends BaseDto, RES extends BaseResponse> {
    public abstract RES transferToResponse(D dto);

    public List<RES> transferToResponseList(List<D> dtoList) {
        return dtoList.stream().map(this::transferToResponse).collect(Collectors.toList());
    }
}
