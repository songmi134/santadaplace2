package com.mountain.place.controller.likedMountain.dto;


import com.mountain.place.domain.likedmountain.model.Likedmountain;
import com.mountain.place.domain.mountain.model.Mountain;
import lombok.Data;


@Data
public class ResponseLikedMountainDTO {

    private Long id;

    private Mountain mountain;



    public ResponseLikedMountainDTO(Likedmountain likedmountain) {
        this.id = likedmountain.getId();
        this.mountain = likedmountain.getMountainNo();
    }
}
