package com.mountain.place.controller.mountain;


import com.mountain.place.controller.mountain.dto.PBMTListDTO;
import com.mountain.place.controller.mountain.dto.ResponseMountainDTO;
import com.mountain.place.controller.mountain.specification.MountainSpecification;
import com.mountain.place.domain.mountain.model.Mountain;
import com.mountain.place.domain.mountain.service.MountainService;
import com.mountain.place.domain.mountain.service.PublicMTAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/mountains")
public class MountainController {


    @Autowired
    MountainService mountainService;

    @Autowired
    PublicMTAPIService publicMTAPIService;

    @GetMapping("/public")
    public ResponseEntity<PBMTListDTO> mountainList() throws UnsupportedEncodingException {
        return publicMTAPIService.callAPI();
    }

    @GetMapping("")
    public Page<ResponseMountainDTO> findMountain(
            @RequestParam(required = false) String addressDetail,
            @RequestParam(required = false) String mountainHeight,
            Pageable pageable) {

        Specification<Mountain> spec = (((root, query, criteriaBuilder) -> null));

        if(addressDetail != null) spec = spec.and(MountainSpecification.likeAddressDetail(addressDetail));
        if(mountainHeight != null) spec = spec.and(MountainSpecification.likeMountainHeight(mountainHeight));

        return mountainService.findAll(spec, pageable).map(Mountain -> new ResponseMountainDTO(Mountain));

    }

    @GetMapping("/{mountainNo}")
    public ResponseMountainDTO findMountainDetail(@PathVariable(value = "mountainNo") Long mountainNo) {
        return new ResponseMountainDTO(mountainService.findMountainDetail(mountainNo));
    }
}