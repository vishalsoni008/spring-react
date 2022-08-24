package com.springreact.model.projection;

import com.springreact.model.User;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = {User.class})
public interface UserProjection {
    Integer getId();
    String getName();
    String getEmail();
}
