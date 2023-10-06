package com.MovieApp.TicketCounter.service;

import com.MovieApp.TicketCounter.dto.respond.UserRespondDTO;
import com.MovieApp.TicketCounter.model.User;
import com.MovieApp.TicketCounter.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserRespondDTO getUserById(Integer id){
        Optional<User> user=userRepository.findById(id);
        if(user.isEmpty())
            throw new EntityNotFoundException("User By this Id doesn't Exist");
        return UserRespondDTO.builder()
                .userId(user.get().getUserId())
                .email(user.get().getEmail())
                .name(user.get().getName())
                .build();
    }

    public List<UserRespondDTO> getAllUser(){
        List<User> userList=userRepository.findAll();
        List<UserRespondDTO> userRespondDTOList=new ArrayList<>();
        for(User element: userList){
            UserRespondDTO userRespondDTO=new UserRespondDTO();
            userRespondDTO.setUserId(element.getUserId());
            userRespondDTO.setName(element.getName());
            userRespondDTO.setEmail(element.getEmail());
            userRespondDTOList.add(userRespondDTO);
        }
        return userRespondDTOList;
    }

}
