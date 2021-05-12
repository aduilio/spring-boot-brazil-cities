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
package com.aduilio.brazilcities.type;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;
import org.springframework.data.geo.Point;

/**
 * Defines how Hibernate deserializes {@link Point} values.
 */
public class PointType implements UserType
{
    @Override
    public int[] sqlTypes()
    {
        return new int[] { java.sql.Types.OTHER };
    }

    @Override
    public Class<Point> returnedClass()
    {
        return Point.class;
    }

    @Override
    public boolean equals(final Object x, final Object y) throws HibernateException
    {
        return false;
    }

    @Override
    public int hashCode(final Object x) throws HibernateException
    {
        return 0;
    }

    @Override
    public Object nullSafeGet(final ResultSet rs,
                              final String[] names,
                              final SharedSessionContractImplementor session,
                              final Object owner) throws HibernateException,
                                                  SQLException
    {
        final Object object = rs.getObject(names[0]);
        final String[] points = object.toString().replace("(", "").replace(")", "").split(",");
        return new Point(Double.valueOf(points[0]), Double.valueOf(points[1]));
    }

    @Override
    public void nullSafeSet(final PreparedStatement st,
                            final Object value,
                            final int index,
                            final SharedSessionContractImplementor session) throws HibernateException,
                                                                            SQLException
    {
    }

    @Override
    public Object deepCopy(final Object value) throws HibernateException
    {
        return null;
    }

    @Override
    public boolean isMutable()
    {
        return false;
    }

    @Override
    public Serializable disassemble(final Object value) throws HibernateException
    {
        return null;
    }

    @Override
    public Object assemble(final Serializable cached, final Object owner) throws HibernateException
    {
        return null;
    }

    @Override
    public Object replace(final Object original, final Object target, final Object owner) throws HibernateException
    {
        return null;
    }
}
