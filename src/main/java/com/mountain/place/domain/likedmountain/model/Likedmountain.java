package com.mountain.place.domain.likedmountain.model;


import com.mountain.place.domain.mountain.model.Mountain;
import com.mountain.place.domain.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name ="likedmountain")
public class Likedmountain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "uid")
    private User user;

    @OneToOne
    @JoinColumn(name = "mountain_no")
    private Mountain mountainNo;


    @Builder
    public Likedmountain(Long id, User user, Mountain mountainNo) {
        this.id = id;
        this.user = user;
        this.mountainNo = mountainNo;
    }
}
