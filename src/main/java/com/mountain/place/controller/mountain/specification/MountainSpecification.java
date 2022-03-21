package com.mountain.place.controller.mountain.specification;

import com.mountain.place.domain.mountain.model.Mountain;
import org.springframework.data.jpa.domain.Specification;

public class MountainSpecification {
    public static Specification<Mountain> likeAddressDetail(String addressDetail) {

        return (((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("addressDetail"),"%"+addressDetail+"%")));
    }

    public static Specification<Mountain> likeMountainHeight(String mountainHeight) {

        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("mountainHeight"), "%"+mountainHeight+"%"));
        // Long...으로 변경
    }
}

