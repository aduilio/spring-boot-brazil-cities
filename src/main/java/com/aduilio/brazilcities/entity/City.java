//**********************************************************************
// Copyright (c) 2021 Telefonaktiebolaget LM Ericsson, Sweden.
// All rights reserved.
// The Copyright to the computer program(s) herein is the property of
// Telefonaktiebolaget LM Ericsson, Sweden.
// The program(s) may be used and/or copied with the written permission
// from Telefonaktiebolaget LM Ericsson or in accordance with the terms
// and conditions stipulated in the agreement/contract under which the
// program(s) have been supplied.
// **********************************************************************
package com.aduilio.brazilcities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.springframework.data.geo.Point;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.aduilio.brazilcities.type.PointType;

@Data
@Builder
@Entity
@Table (name = "cidade")
@NoArgsConstructor
@AllArgsConstructor
@TypeDef (name = "point", typeClass = PointType.class)
public class City
{
    @Id
    private Long id;

    @Column (name = "nome")
    private String name;

    @ManyToOne
    @JoinColumn (name = "uf", referencedColumnName = "id")
    private State state;

    @Column (name = "ibge")
    private int code;

    @Type (type = "point")
    @Column (name = "lat_lon", updatable = false, insertable = false)
    private Point location;
}
