package com.Case.MayoCase.Model.Dto.Mapping;


import com.Case.MayoCase.Model.Dto.BaseClientDto;
import com.Case.MayoCase.Model.Dto.ListClientDto;
import com.Case.MayoCase.Model.ClientModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientMapper {


    public ClientModel toEntity(BaseClientDto dto){
        ClientModel ClientModel = new ClientModel();
        ClientModel.setId(dto.getId());
        ClientModel.setName(dto.getName());
        ClientModel.setCpf(dto.getCpf());
        ClientModel.setEmail(dto.getEmail());
        ClientModel.setSellers(dto.getSellers());
        return ClientModel;
    }
    public ClientModel toEntity(ListClientDto dto){
        ClientModel ClientModel = new ClientModel();
        ClientModel.setId(dto.getId());
        ClientModel.setName(dto.getName());
        ClientModel.setCpf(dto.getCpf());
        ClientModel.setEmail(dto.getEmail());
        return ClientModel;
    }
    public BaseClientDto toDto(ClientModel clientModel){
        BaseClientDto baseClientDto = new BaseClientDto();
        baseClientDto.setId(clientModel.getId());
        baseClientDto.setName(clientModel.getName());
        baseClientDto.setCpf(clientModel.getCpf());
        baseClientDto.setEmail(clientModel.getEmail());
        baseClientDto.setSellers(clientModel.getSellers());
        return baseClientDto;
    }
    public ListClientDto toListDto(BaseClientDto clientDto) {
        ListClientDto baseClientDto = new ListClientDto();
        baseClientDto.setId(clientDto.getId());
        baseClientDto.setName(clientDto.getName());
        baseClientDto.setCpf(clientDto.getCpf());
        baseClientDto.setEmail(clientDto.getEmail());
        return baseClientDto;
    }
    public ListClientDto toListDto(ClientModel clientModel) {
        ListClientDto baseClientDto = new ListClientDto();
        baseClientDto.setId(clientModel.getId());
        baseClientDto.setName(clientModel.getName());
        baseClientDto.setCpf(clientModel.getCpf());
        baseClientDto.setEmail(clientModel.getEmail());
        return baseClientDto;
    }

    public List<BaseClientDto> toDto(List<ClientModel> clientModelList) {
        List<BaseClientDto> ClientDtoList = new ArrayList<>();
        clientModelList.stream().forEach(clientModel -> ClientDtoList.add(toDto(clientModel)));
        return ClientDtoList;
    }
    public List<ListClientDto> baseToListDto(List<BaseClientDto> baseClientDtoList) {
        List<ListClientDto> ClientDtoList = new ArrayList<>();
        baseClientDtoList.stream().forEach(clientDto -> ClientDtoList.add(toListDto(clientDto)));
        return ClientDtoList;
    }
    public List<ListClientDto> toListDto(List<ClientModel> clientModelList) {
        List<ListClientDto> ClientDtoList = new ArrayList<>();
        clientModelList.stream().forEach(clientModel -> ClientDtoList.add(toListDto(clientModel)));
        return ClientDtoList;
    }

}
