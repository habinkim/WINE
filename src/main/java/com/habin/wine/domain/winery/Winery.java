package com.habin.wine.domain.winery;

import com.habin.wine.domain.base.ProductBaseEntity;
import com.habin.wine.domain.region.Region;
import com.habin.wine.domain.wine.Wine;
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
public class Winery extends ProductBaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "regionId", referencedColumnName = "id")
    @Comment("지역 식별자")
    private Region region;

    @Builder.Default
    @OneToMany(mappedBy = "winery", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Wine> wines = new ArrayList<>();

}
