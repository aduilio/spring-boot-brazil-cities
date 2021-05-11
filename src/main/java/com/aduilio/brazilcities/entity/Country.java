package com.aduilio.brazilcities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a country.
 */
@Data
@Builder
@Entity
@Table (name = "pais")
@NoArgsConstructor
@AllArgsConstructor
public class Country
{
    @Id
    private Long id;

    @Column (name = "nome")
    private String name;

    @Column (name = "nome_pt")
    private String ptName;

    @Column (name = "sigla")
    private String code;

    @Column
    private int bacen;
}
