package com.mountain.place.controller.community.dto;

import com.mountain.place.domain.community.model.Community;
import lombok.Data;

@Data
public class CommunityDTO {


    private Long commupostNo;

    private Long cateId;

    private String cateName;

    public CommunityDTO(Community community) {
        this.commupostNo = community.getCommupostNo();
        this.cateId = community.getCateId().getId();
        this.cateName = community.getCateId().getName();
    }
}
