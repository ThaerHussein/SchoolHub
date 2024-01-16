package com.hero.SchoolHub.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "mst_shool")
public class SchoolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "school_name",nullable = false)
    private String schoolName;

    @ManyToOne
    @JoinColumn(name="city_id")
    private CityEntity cityEntity;

    @CreationTimestamp
    @Column(name = "creation_date")
    protected LocalDateTime creationDate;

    @UpdateTimestamp
    @Column(name = "updated_date")
    protected LocalDateTime updatedDate;
}
