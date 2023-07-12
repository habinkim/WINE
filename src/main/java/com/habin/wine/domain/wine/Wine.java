package com.habin.wine.domain.wine;

import com.habin.wine.domain.base.ProductBaseEntity;
import com.habin.wine.domain.region.Region;
import com.habin.wine.domain.winery.Winery;
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
public class Wine extends ProductBaseEntity {

    @Column
    @Comment("와인의 종류")
    private String type;

    @Column
    @Comment("알코올 도수")
    private Float alcohol;

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

    @Column
    @Comment("권장 섭취온도")
    private Float servingTemperature;

    @Column
    @Comment("와인의 점수")
    private Float score;

    @Column
    @Comment("와인의 가격")
    private Integer price;

    @Column
    @Comment("와인의 스타일")
    private String style;

    @Column
    @Comment("와인의 등급")
    private String grade;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "importerId", referencedColumnName = "id")
    @Comment("수입사 식별자")
    private Importer importer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wineryId", referencedColumnName = "id")
    @Comment("와이너리 식별자")
    private Winery winery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", referencedColumnName = "id")
    @Comment("지역 식별자")
    private Region region;

    @Builder.Default
    @OneToMany(mappedBy = "wine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<WineGrape> wineGrapes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "wine", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<WineTag> wineTags = new ArrayList<>();

}
