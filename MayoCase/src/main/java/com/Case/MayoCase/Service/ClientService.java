package com.Case.MayoCase.Service;


import com.Case.MayoCase.Exceptions.BusinessException;
import com.Case.MayoCase.Model.ClientModel;
import com.Case.MayoCase.Model.Dto.BaseClientDto;
import com.Case.MayoCase.Model.Dto.ListClientDto;
import com.Case.MayoCase.Model.Dto.Mapping.ClientMapper;
import com.Case.MayoCase.Repository.ClientRepository;
import com.Case.MayoCase.Util.Messages.ClientMessageUtils;
import com.Case.MayoCase.Util.Messages.MergeSets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private ClientMapper clientMapper;


    public BaseClientDto save(BaseClientDto dto){
        if(repository.findByNameAndEmail(dto.getName(),dto.getEmail()).isPresent()){
            throw new BusinessException(ClientMessageUtils.CLIENT_ALREADY_EXISTS);
        }
        return clientMapper.toDto(repository.save(clientMapper.toEntity(dto)));
    }

    public BaseClientDto update(BaseClientDto dto){
        if(repository.findToUpdate(dto.getName(),dto.getEmail(),dto.getId(),dto.getCpf()).isPresent()){
            throw  new BusinessException(ClientMessageUtils.CLIENT_ALREADY_EXISTS);
        }
        return clientMapper.toDto(repository.save(clientMapper.toEntity(dto)));
    }
    public BaseClientDto updateSellers(BaseClientDto dto){
        Optional<ClientModel> optionalClientDto = repository.findById(dto.getId());
        if(!optionalClientDto.isPresent()){
            throw  new BusinessException(ClientMessageUtils.CLIENT_NOT_EXISTS);
        }
        dto.setSellers(new MergeSets().mergeSellersSet(optionalClientDto.get().getSellers(), dto.getSellers()));
        return clientMapper.toDto(repository.save(clientMapper.toEntity(dto)));
    }

    public BaseClientDto findByid(UUID id){
        Optional<ClientModel> optionalBaseClientDto = repository.findById(id);
        if (!optionalBaseClientDto.isPresent()){
            throw  new BusinessException(ClientMessageUtils.CLIENT_NOT_EXISTS);
        }
        return clientMapper.toDto(optionalBaseClientDto.get());
    }

    public List<ListClientDto> findAll(){
        return clientMapper.toListDto(repository.findAll());
    }

    public BaseClientDto deleteById(UUID id){
         BaseClientDto baseClientDto = this.findByid(id);
        repository.deleteById(baseClientDto.getId());
        return baseClientDto;
    }


}
