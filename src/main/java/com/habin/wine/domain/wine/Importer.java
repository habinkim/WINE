package com.habin.wine.domain.wine;

import com.habin.wine.domain.base.BaseEntity;
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
public class Importer extends BaseEntity {

    @Column
    @Comment("수입사명")
    private String name;

    @Builder.Default
    @OneToMany(mappedBy = "importer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Wine> wine = new ArrayList<>();

}
