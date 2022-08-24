package com.springreact.service;

import com.springreact.model.projection.UserProjection;
import com.springreact.request.UserRequest;

import java.util.List;

public interface UserService {
//    Page<UserProjection> getAllUser();
    List<UserProjection> getAllUser();

    UserProjection addUser(UserRequest userRequest);
}
