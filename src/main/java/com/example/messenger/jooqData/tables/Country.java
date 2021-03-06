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
public class Country extends TableImpl<Record> {

    private static final long serialVersionUID = 1513236368;

    public static final Country COUNTRY = new Country();

    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    public final TableField<Record, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('country_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    public Country() {
        this(DSL.name("country"), null);
    }

    public Country(String alias) {
        this(DSL.name(alias), COUNTRY);
    }

    public Country(Name alias) {
        this(alias, COUNTRY);
    }

    private Country(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Country(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Internal.createIdentity(com.example.messenger.jooqData.tables.Country.COUNTRY, com.example.messenger.jooqData.tables.Country.COUNTRY.ID);
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Internal.createUniqueKey(com.example.messenger.jooqData.tables.Country.COUNTRY, "country_pkey", com.example.messenger.jooqData.tables.Country.COUNTRY.ID);
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(
              Internal.createUniqueKey(com.example.messenger.jooqData.tables.Country.COUNTRY, "country_pkey", com.example.messenger.jooqData.tables.Country.COUNTRY.ID)
        );
    }

    @Override
    public Country as(String alias) {
        return new Country(DSL.name(alias), this);
    }

    @Override
    public Country as(Name alias) {
        return new Country(alias, this);
    }

    @Override
    public Country rename(String name) {
        return new Country(DSL.name(name), null);
    }

    @Override
    public Country rename(Name name) {
        return new Country(name, null);
    }
}
