package com.habin.wine.domain.wine;

import com.habin.wine.domain.base.BaseEntity;
import com.habin.wine.domain.grape.Grape;
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
public class WineGrape extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wineId", referencedColumnName = "id")
    @Comment("와인 식별자")
    private Wine wine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "grapeId", referencedColumnName = "id")
    @Comment("포도 품종 식별자")
    private Grape grape;

}
