package com.Case.MayoCase.Controller;

import com.Case.MayoCase.Model.Dto.BaseSellerDto;
import com.Case.MayoCase.Model.Dto.ListSellerDto;
import com.Case.MayoCase.Service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/seller")
public class SellerController {

    @Autowired
    private SellerService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseSellerDto> save(@Valid @RequestBody BaseSellerDto dto){
        return ResponseEntity.ok(service.save(dto));
    }
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseSellerDto> update(@Valid @RequestBody BaseSellerDto dto){
        return ResponseEntity.ok(service.update(dto));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListSellerDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseSellerDto> findById (@Valid @PathVariable UUID id){
        return ResponseEntity.ok(service.findByid(id));
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BaseSellerDto> deleteById(@Valid @PathVariable UUID id){
        return ResponseEntity.ok(service.deleteById(id));
    }
    @PostMapping(value = "/addSellerToClient/{clientid}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ListSellerDto>> bindVendor(@Valid @RequestBody HashSet<BaseSellerDto> setSellers, @PathVariable( value="clientid") UUID clientid){
        return new ResponseEntity<>(service.addSeller(setSellers,clientid), HttpStatus.ACCEPTED);
    }

}
