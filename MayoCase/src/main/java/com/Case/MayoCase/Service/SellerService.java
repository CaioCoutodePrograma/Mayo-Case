package com.Case.MayoCase.Service;

import com.Case.MayoCase.Exceptions.BusinessException;
import com.Case.MayoCase.Model.Dto.BaseClientDto;
import com.Case.MayoCase.Model.Dto.BaseSellerDto;
import com.Case.MayoCase.Model.Dto.ListSellerDto;
import com.Case.MayoCase.Model.Dto.Mapping.ClientMapper;
import com.Case.MayoCase.Model.SellerModel;
import com.Case.MayoCase.Model.Dto.Mapping.SellerMapper;
import com.Case.MayoCase.Repository.SellerRepository;
import com.Case.MayoCase.Util.Messages.SellerMessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SellerService {
    @Autowired
    private SellerRepository repository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private SellerMapper vendorMapper;
    @Autowired
    private ClientMapper clientMapper;



    public BaseSellerDto save(BaseSellerDto dto){
        if(repository.findByNameAndEmail(dto.getName(),dto.getEmail()).isPresent()){
            throw new BusinessException(SellerMessageUtils.SELLER_ALREADY_EXISTS);
        }
        return vendorMapper.toDto(repository.save(vendorMapper.toEntity(dto)));
    }

    public BaseSellerDto update(BaseSellerDto dto){
        if(repository.findToUpdate(dto.getName(),dto.getEmail(),dto.getId(),dto.getCpf()).isPresent()){
            throw new BusinessException(SellerMessageUtils.SELLER_ALREADY_EXISTS);
        }
        return vendorMapper.toDto(repository.save(vendorMapper.toEntity(dto)));
    }

    public BaseSellerDto findByid(UUID id){
        Optional<SellerModel> optionalSellerModel = repository.findById(id);
        if (!optionalSellerModel.isPresent()){
            throw new BusinessException(SellerMessageUtils.SELLER_NOT_EXISTS);
        }
        return vendorMapper.toDto(optionalSellerModel.get());
    }

    public List<ListSellerDto> findAll(){
        return vendorMapper.toListDto(repository.findAll());
    }

    public BaseSellerDto deleteById(UUID id){
        BaseSellerDto baseSellerDto = this.findByid(id);
        repository.deleteById(baseSellerDto.getId());
        return baseSellerDto;
    }

    public List<ListSellerDto> addSeller(HashSet<BaseSellerDto> setSellers, UUID clientid) {
        BaseClientDto baseClientDto = clientService.findByid(clientid);
        HashSet<SellerModel> sellerModelHashSet = new HashSet<>();
        setSellers.stream().forEach(vendor -> sellerModelHashSet.add
                (repository.findById(vendor.getId()).orElseThrow
                        (()-> new BusinessException(SellerMessageUtils.SELLER_NOT_AVAILABLE))) );
        baseClientDto.setSellers(sellerModelHashSet);
        clientService.updateSellers(baseClientDto);
        return vendorMapper.toListDto(new ArrayList<>(sellerModelHashSet));
    }
}
