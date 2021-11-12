package com.example.gurospruebatecnica.controller;

import com.example.gurospruebatecnica.DTO.ResponseDTO;
import com.example.gurospruebatecnica.DTO.AdnDTO;
import com.example.gurospruebatecnica.service.ADNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mutation")
public class ADNController {

  @Autowired
  ADNService adnService;

  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<ResponseDTO<Boolean>> isMutant(@RequestBody AdnDTO dna){
    ResponseDTO<Boolean> response = new ResponseDTO<>( adnService.hasMutation(dna));
    if(response.getContent() == true){
      return new ResponseEntity<>(response, HttpStatus.OK);
    }else{
      return new ResponseEntity<>( response, HttpStatus.FORBIDDEN);
    }
  }
}
