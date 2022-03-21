package com.mountain.place.controller.communitycomment.dto;

import com.mountain.place.controller.community.dto.CommunityDTO;
import com.mountain.place.controller.user.dto.UserDTO;
import com.mountain.place.domain.comment.model.Comment;
import com.mountain.place.domain.community.model.Community;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResponseCommuCommentDTO {

    private Long commentNo;

    private UserDTO user;

    private CommunityDTO community;

    private String commentContent;

    private LocalDateTime createdAt;

    private LocalDateTime updateAt;

    public ResponseCommuCommentDTO(Comment comment, Community community) {
        this.commentNo = comment.getCommentNo();
        this.user = new UserDTO(comment.getUid());
        this.commentContent = comment.getCommentContent();
        this.createdAt = comment.getFstRegDtm();
        this.updateAt = comment.getLstUpdDtm();
        this.community = new CommunityDTO(community);
    }
}





