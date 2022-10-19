package com.devsuperior.workshopmongo.services;

import com.devsuperior.workshopmongo.domain.User;
import com.devsuperior.workshopmongo.dto.UserDTO;
import com.devsuperior.workshopmongo.repository.UserRepository;
import com.devsuperior.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll(){
        List<User> userList = userRepository.findAll();
        return userList.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }
    public UserDTO findById(String id){
       User user = userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
        return new UserDTO(user);
    }
}
