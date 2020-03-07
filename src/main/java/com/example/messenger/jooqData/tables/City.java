/*
 * This file is generated by jOOQ.
 */
package com.example.messenger.jooqData.tables;


import com.example.messenger.jooqData.Public;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;


@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class City extends TableImpl<Record> {

    private static final long serialVersionUID = 149345082;

    public static final City CITY = new City();

    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    public final TableField<Record, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('city_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    public final TableField<Record, Integer> COUNTRY_ID = createField("country_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    public City() {
        this(DSL.name("city"), null);
    }

    public City(String alias) {
        this(DSL.name(alias), CITY);
    }

    public City(Name alias) {
        this(alias, CITY);
    }

    private City(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private City(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Internal.createIdentity(com.example.messenger.jooqData.tables.City.CITY, com.example.messenger.jooqData.tables.City.CITY.ID);
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Internal.createUniqueKey(com.example.messenger.jooqData.tables.City.CITY, "city_pkey", com.example.messenger.jooqData.tables.City.CITY.ID);
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(
              Internal.createUniqueKey(com.example.messenger.jooqData.tables.City.CITY, "city_pkey", com.example.messenger.jooqData.tables.City.CITY.ID)
        );
    }

    @Override
    public City as(String alias) {
        return new City(DSL.name(alias), this);
    }

    @Override
    public City as(Name alias) {
        return new City(alias, this);
    }

    @Override
    public City rename(String name) {
        return new City(DSL.name(name), null);
    }

    @Override
    public City rename(Name name) {
        return new City(name, null);
    }
}
