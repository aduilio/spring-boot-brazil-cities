package com.aduilio.brazilcities.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

/**
 * Represents a state.
 */
@Data
@Builder
@Entity
@Table (name = "estado")
@NoArgsConstructor
@AllArgsConstructor
@TypeDef (name = "jsonb", typeClass = JsonBinaryType.class)
public class State
{
    @Id
    private Long id;

    @Column (name = "nome")
    private String name;

    @Column
    private String uf;

    @Column (name = "ibge")
    private int code;

    @ManyToOne
    @JoinColumn (name = "pais", referencedColumnName = "id")
    private Country country;

    @Type (type = "jsonb")
    @Basic (fetch = FetchType.LAZY)
    @Column (name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;
}
