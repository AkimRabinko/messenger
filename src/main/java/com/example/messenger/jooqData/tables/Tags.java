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
public class Tags extends TableImpl<Record> {

    private static final long serialVersionUID = -1196251867;

    public static final Tags TAGS = new Tags();

    @Override
    public Class<Record> getRecordType() {
        return Record.class;
    }

    public final TableField<Record, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('tags_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    public final TableField<Record, String> NAME = createField("name", org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    public Tags() {
        this(DSL.name("tags"), null);
    }

    public Tags(String alias) {
        this(DSL.name(alias), TAGS);
    }

    public Tags(Name alias) {
        this(alias, TAGS);
    }

    private Tags(Name alias, Table<Record> aliased) {
        this(alias, aliased, null);
    }

    private Tags(Name alias, Table<Record> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    @Override
    public Identity<Record, Integer> getIdentity() {
        return Internal.createIdentity(com.example.messenger.jooqData.tables.Tags.TAGS, com.example.messenger.jooqData.tables.Tags.TAGS.ID);
    }

    @Override
    public UniqueKey<Record> getPrimaryKey() {
        return Internal.createUniqueKey(com.example.messenger.jooqData.tables.Tags.TAGS, "tags_pkey", com.example.messenger.jooqData.tables.Tags.TAGS.ID);
    }

    @Override
    public List<UniqueKey<Record>> getKeys() {
        return Arrays.<UniqueKey<Record>>asList(
              Internal.createUniqueKey(com.example.messenger.jooqData.tables.Tags.TAGS, "tags_pkey", com.example.messenger.jooqData.tables.Tags.TAGS.ID)
        );
    }

    @Override
    public Tags as(String alias) {
        return new Tags(DSL.name(alias), this);
    }

    @Override
    public Tags as(Name alias) {
        return new Tags(alias, this);
    }

    @Override
    public Tags rename(String name) {
        return new Tags(DSL.name(name), null);
    }

    @Override
    public Tags rename(Name name) {
        return new Tags(name, null);
    }
}
