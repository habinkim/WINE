package com.habin.wine.domain.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@SuperBuilder(toBuilder = true)
@MappedSuperclass
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Comment("고유번호")
    private String uuid;

    @JsonIgnore
    @Column
    @Comment("활성화 여부")
    private boolean enabled;

    @CreationTimestamp
    @Column(updatable = false)
    @Comment("생성일")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column
    @Comment("수정일")
    private LocalDateTime updatedAt;

    public final void enable() {
        this.enabled = true;
    }

    public final void disable() {
        this.enabled = false;
    }

}
