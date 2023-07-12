package com.habin.wine.domain.wine;

import com.habin.wine.common.enums.WineTagType;
import com.habin.wine.domain.base.BaseEntity;
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
public class WineTag extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column
    @Comment("태그 유형")
    private WineTagType type;

    @Column
    @Comment("태그 값")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wineId", referencedColumnName = "id")
    @Comment("와인 식별자")
    private Wine wine;

}
