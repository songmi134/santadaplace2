package com.mountain.place.domain.likedmountain.service;


import com.mountain.place.controller.likedMountain.dto.LikedMountainDTO;
import com.mountain.place.domain.likedmountain.dao.LikedMountainRepository;
import com.mountain.place.domain.likedmountain.model.Likedmountain;
import com.mountain.place.domain.mountain.dao.MountainRepository;
import com.mountain.place.domain.mountain.model.Mountain;
import com.mountain.place.domain.user.model.User;
import com.mountain.place.exception.CustomException;
import com.mountain.place.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class LikedMountainService {

    @Autowired
    LikedMountainRepository likedMountainRepository;

    @Autowired
    MountainRepository mountainRepository;

    @Transactional
    public void addMountain( User user, LikedMountainDTO likedMountainDTO) {

        Optional<Mountain> mountain = mountainRepository.findById(likedMountainDTO.getMountainNo());

        if (mountain.isPresent()) {

            if (isNotAlreadyLike(user, mountain)) {

                Likedmountain likedmountain = Likedmountain.builder()
                        .mountainNo(mountain.get())
                        .user(user)
                        .build();

                likedMountainRepository.save(likedmountain);

            } else throw new CustomException(ErrorCode.EXIST_MOUNTAIN);

        } else throw new CustomException(ErrorCode.NOT_FOUND_MOUNTAIN);
    }

    private boolean isNotAlreadyLike(User user, Optional<Mountain> mountain) {
        Likedmountain existData = likedMountainRepository.findByMountainNoAndUser(mountain.get(),user);
        if(existData != null) {
            return false;
        } return true;
    }






    @Transactional
    public void deleteMountain (User user, Long mountainNo){

        Optional<Mountain> mountain = mountainRepository.findById(mountainNo);

        if (mountain.isPresent()) {
            Likedmountain likedmountain = likedMountainRepository.findByMountainNoAndUser(mountain.get(), user);
            likedMountainRepository.delete(likedmountain);

        } else throw new CustomException(ErrorCode.NOT_FOUND_MOUNTAIN);

    }




    @Transactional
    public Page<Likedmountain> getLikedMountainList(User user, Pageable pageable) {

        return likedMountainRepository.findAllByUser(user,pageable);

    }
}



