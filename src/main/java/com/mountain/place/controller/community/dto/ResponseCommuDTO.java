package com.mountain.place.controller.community.dto;


import com.mountain.place.domain.community.model.Community;
import com.mountain.place.domain.user.model.User;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseCommuDTO {


    private Long commupostNo;

    private User writerId;

    private String cateId;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Long viewCount;

    private String title;

    private String content;

    public ResponseCommuDTO(Community community) {
        this.commupostNo = community.getCommupostNo();
        this.writerId = community.getWriterId();
        this.cateId = community.getCateId().getName();
        this.createdAt = community.getFstRegDtm();
        this.updatedAt = community.getLstUpdDtm();
        this.viewCount = community.getViewCount();
        this.title = community.getTitle();
        this.content = community.getContent();
    }
}
