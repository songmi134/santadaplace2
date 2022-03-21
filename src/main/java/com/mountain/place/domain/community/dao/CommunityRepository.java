package com.mountain.place.domain.community.dao;


import com.mountain.place.domain.comment.model.Comment;
import com.mountain.place.domain.community.model.Community;
import com.mountain.place.domain.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;



@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> , JpaSpecificationExecutor<Community> {
    Page<Community> findByWriterId(User user, Pageable pageable);
}