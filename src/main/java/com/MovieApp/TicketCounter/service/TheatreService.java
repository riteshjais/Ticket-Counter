package com.MovieApp.TicketCounter.service;

import com.MovieApp.TicketCounter.dto.request.TheatreRequestDTO;
import com.MovieApp.TicketCounter.dto.respond.TheatreRespondDTO;
import com.MovieApp.TicketCounter.model.CityEntity;
import com.MovieApp.TicketCounter.model.TheatreEntity;
import com.MovieApp.TicketCounter.model.enums.TheatreType;
import com.MovieApp.TicketCounter.repository.CityRepository;
import com.MovieApp.TicketCounter.repository.TheatreRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityRepository cityRepository;

    public TheatreEntity addTheatre(TheatreRequestDTO requestDTO){
        if(!cityRepository.existsByCityName(requestDTO.getCityName()))
            throw new EntityNotFoundException("City Doesn't Exist");
        CityEntity cityEntity=cityRepository.findByCityName(requestDTO.getCityName()).get();

        TheatreEntity theatreEntity=TheatreEntity.builder()
                .theatreName(requestDTO.getTheatreName())
                .theatreType(TheatreType.valueOf(requestDTO.getTheatreType()))
                .theatreAddress(requestDTO.getTheatreAddress())
                .cityEntity(cityEntity)
                .build();
        return theatreRepository.save(theatreEntity);
    }

    public TheatreRespondDTO getTheatreById(int id){
        Optional<TheatreEntity> optionalTheatreEntity=theatreRepository.findById(id);
        if(optionalTheatreEntity.isEmpty())
            throw new EntityNotFoundException("Theatre By this id doesn't exists");
        TheatreEntity theatreEntity=optionalTheatreEntity.get();
        return TheatreRespondDTO.builder()
                .theatreName(theatreEntity.getTheatreName())
                .theatreId(theatreEntity.getTheatreId())
                .theatreAddress(theatreEntity.getTheatreAddress())
                .theatreType(theatreEntity.getTheatreType().toString())
                .cityName(theatreEntity.getCityEntity().getCityName())
                .build();
    }

    public List<TheatreRespondDTO> getAllTheatre(){
        List<TheatreEntity> theatreEntityList=theatreRepository.findAll();
        List<TheatreRespondDTO> respondDTOList=new ArrayList<>();
        for(TheatreEntity element: theatreEntityList){
            TheatreRespondDTO respondDTO=TheatreRespondDTO.builder()
                    .theatreId(element.getTheatreId())
                    .theatreName(element.getTheatreName())
                    .theatreAddress(element.getTheatreAddress())
                    .theatreType(element.getTheatreType().toString())
                    .cityName(element.getCityEntity().getCityName())
                    .build();
            respondDTOList.add(respondDTO);
        }
        return respondDTOList;
    }
}
