package com.springreact.service.impl;

import com.springreact.model.User;
import com.springreact.model.projection.UserProjection;
import com.springreact.repository.UserRepository;
import com.springreact.request.UserRequest;
import com.springreact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectionFactory projectionFactory;
//    @Override
//    public Page<UserProjection> getAllUser() {
//        return new PageImpl(userRepository.findAll()
//                .stream()
//                .map(p -> projectionFactory.createProjection(UserProjection.class, p))
//                .collect(Collectors.toList()));
//    }

    @Override
    public List<UserProjection> getAllUser() {
        return userRepository.findAll()
                .stream()
                .map(p -> projectionFactory.createProjection(UserProjection.class, p))
                .collect(Collectors.toList());
    }

    @Override
    public UserProjection addUser(UserRequest userRequest) {
        if(userRequest.getName() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please provide a name");
        }

        if(userRequest.getEmail() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "please provide email addresss");
        }

        User user = new User();
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());

        user = userRepository.save(user);

        return projectionFactory.createProjection(UserProjection.class, user);
    }
}
