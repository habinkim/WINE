package com.habin.wine.domain.grape;

import com.habin.wine.domain.base.ProductBaseEntity;
import com.habin.wine.domain.wine.WineGrape;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

import java.util.ArrayList;
import java.util.List;

@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Grape extends ProductBaseEntity {

    @Column
    @Comment("산도")
    private Integer acidity;

    @Column
    @Comment("바디감")
    private Integer body;

    @Column
    @Comment("단맛")
    private Integer sweetness;

    @Column
    @Comment("타닌")
    private Integer tannin;

    @Builder.Default
    @OneToMany(
            mappedBy = "grape",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<GrapeShare> grapeShares = new ArrayList<>();

    @Builder.Default
    @OneToMany(
            mappedBy = "grape",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<WineGrape> wineGrapes = new ArrayList<>();


}
