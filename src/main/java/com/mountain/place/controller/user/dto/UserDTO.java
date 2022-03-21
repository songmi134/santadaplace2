package com.mountain.place.controller.user.dto;

import com.mountain.place.domain.user.model.User;
import lombok.Data;

@Data
public class UserDTO {

    private String id;

    private String name;

    private String imgUrl;

    public UserDTO(User user) {
        id = user.getId();
        name = user.getName();
        imgUrl = user.getUserImg();
    }
}
