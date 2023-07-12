package com.habin.wine.domain.region;

import com.habin.wine.domain.base.ProductBaseEntity;
import com.habin.wine.domain.grape.GrapeShare;
import com.habin.wine.domain.wine.Wine;
import com.habin.wine.domain.winery.Winery;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Region extends ProductBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
            name = "parentId",
            referencedColumnName = "id"
    )
    @Comment("상위 지역 식별자")
    private Region parent;

    @OneToMany(
            mappedBy = "region",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<GrapeShare> grapeShares;

    @OneToMany(
            mappedBy = "region",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<Winery> wineries;

    @OneToMany(
            mappedBy = "region",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<Wine> wines;

}
