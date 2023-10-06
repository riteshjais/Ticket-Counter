package com.MovieApp.TicketCounter.service;

import com.MovieApp.TicketCounter.dto.request.CityRequestDTO;
import com.MovieApp.TicketCounter.dto.respond.CityRespondDTO;
import com.MovieApp.TicketCounter.model.CityEntity;
import com.MovieApp.TicketCounter.repository.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public CityEntity addCity(CityRequestDTO requestDTO){
        CityEntity cityEntity=CityEntity.builder()
                .cityName(requestDTO.getCityName())
                .build();
        return cityRepository.save(cityEntity);
    }

    public CityRespondDTO getCityById(int id){
        Optional<CityEntity> optionalCityEntity=cityRepository.findById(id);
        if(optionalCityEntity.isEmpty())
            throw new EntityNotFoundException("City By this Id Doesn't Exists");
        CityEntity cityEntity=optionalCityEntity.get();
        return CityRespondDTO.builder()
                .cityId(cityEntity.getCityId())
                .cityName(cityEntity.getCityName())
                .build();
    }

    public List<CityRespondDTO> getAllCity(){
        List<CityEntity> cityEntityList=cityRepository.findAll();
        List<CityRespondDTO> cityRespondDTOList=new ArrayList<>();
        for(CityEntity element: cityEntityList){
            CityRespondDTO cityRespondDTO=CityRespondDTO.builder()
                    .cityId(element.getCityId())
                    .cityName(element.getCityName())
                    .build();
            cityRespondDTOList.add(cityRespondDTO);
        }
        return cityRespondDTOList;
    }

    public boolean existsByCityName(String cityName){
        return cityRepository.existsByCityName(cityName);
    }
}
