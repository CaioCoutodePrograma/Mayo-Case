package com.Case.MayoCase.Controller;

import com.Case.MayoCase.Model.Dto.BaseClientDto;
import com.Case.MayoCase.Model.Dto.ListClientDto;
import com.Case.MayoCase.Service.ClientService;
import com.Case.MayoCase.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/client")
public class ClientController {

    @Autowired
    private ClientService service;
    @Autowired
    private SellerService sellerService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseClientDto> save(@Valid @RequestBody BaseClientDto dto){
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseClientDto> update(@Valid @RequestBody BaseClientDto dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListClientDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseClientDto> findById (@Valid @PathVariable UUID id){
        return ResponseEntity.ok(service.findByid(id));
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseClientDto> deleteById(@Valid @PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }



}
