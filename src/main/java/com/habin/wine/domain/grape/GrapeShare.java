package com.habin.wine.domain.grape;

import com.habin.wine.domain.base.BaseEntity;
import com.habin.wine.domain.region.Region;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;

@SuperBuilder(toBuilder = true)
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table
public class GrapeShare extends BaseEntity {

    @Column
    @Comment("포도 품종의 비율")
    private Float share;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grapeId", referencedColumnName = "id")
    @Comment("포도 품종 식별자")
    private Grape grape;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", referencedColumnName = "id")
    @Comment("지역 식별자")
    private Region region;


}
