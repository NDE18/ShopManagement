package com.nde.shopmanagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sale")
public class Sale extends AbstractEntity{

    @Column(name = "id")
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "saledate")
    private Instant saleDate;

    @Column(name = "comment")
    private String comment;

    @Column(name = "idbusiness")
    private Integer idBusiness;
}
