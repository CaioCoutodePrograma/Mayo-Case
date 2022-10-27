package com.Case.MayoCase.Model.Dto.Mapping;

import com.Case.MayoCase.Model.Dto.ListSellerDto;
import com.Case.MayoCase.Model.SellerModel;
import com.Case.MayoCase.Model.Dto.BaseSellerDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SellerMapper {


    public SellerModel toEntity(BaseSellerDto dto){
        SellerModel SellerModel = new SellerModel();
        SellerModel.setId(dto.getId());
        SellerModel.setName(dto.getName());
        SellerModel.setCpf(dto.getCpf());
        SellerModel.setEmail(dto.getEmail());
        SellerModel.setClients(dto.getClients());
        return SellerModel;
    }
    public SellerModel toEntity(ListSellerDto dto){
        SellerModel SellerModel = new SellerModel();
        SellerModel.setId(dto.getId());
        SellerModel.setName(dto.getName());
        SellerModel.setCpf(dto.getCpf());
        SellerModel.setEmail(dto.getEmail());
        return SellerModel;
    }
    public BaseSellerDto toDto(SellerModel sellerModel){
        BaseSellerDto baseSellerDto = new BaseSellerDto();
        baseSellerDto.setId(sellerModel.getId());
        baseSellerDto.setName(sellerModel.getName());
        baseSellerDto.setCpf(sellerModel.getCpf());
        baseSellerDto.setEmail(sellerModel.getEmail());
        baseSellerDto.setClients(sellerModel.getClients());
        return baseSellerDto;
    }
    public ListSellerDto toListDto(BaseSellerDto sellerDto) {
        ListSellerDto baseSellerDto = new ListSellerDto();
        baseSellerDto.setId(sellerDto.getId());
        baseSellerDto.setName(sellerDto.getName());
        baseSellerDto.setCpf(sellerDto.getCpf());
        baseSellerDto.setEmail(sellerDto.getEmail());
        return baseSellerDto;
    }
    public ListSellerDto toListDto(SellerModel sellerModel) {
        ListSellerDto baseSellerDto = new ListSellerDto();
        baseSellerDto.setId(sellerModel.getId());
        baseSellerDto.setName(sellerModel.getName());
        baseSellerDto.setCpf(sellerModel.getCpf());
        baseSellerDto.setEmail(sellerModel.getEmail());
        return baseSellerDto;
    }

    public List<BaseSellerDto> toDto(List<SellerModel> sellerModelList) {
        List<BaseSellerDto> SellerDtoList = new ArrayList<>();
        sellerModelList.stream().forEach(sellerModel -> SellerDtoList.add(toDto(sellerModel)));
        return SellerDtoList;
    }
    public List<ListSellerDto> baseToListDto(List<BaseSellerDto> baseSellerDtoList) {
        List<ListSellerDto> SellerDtoList = new ArrayList<>();
        baseSellerDtoList.stream().forEach(sellerDto -> SellerDtoList.add(toListDto(sellerDto)));
        return SellerDtoList;
    }
    public List<ListSellerDto> toListDto(List<SellerModel> sellerModelList) {
        List<ListSellerDto> SellerDtoList = new ArrayList<>();
        sellerModelList.stream().forEach(sellerModel -> SellerDtoList.add(toListDto(sellerModel)));
        return SellerDtoList;
    }

}
