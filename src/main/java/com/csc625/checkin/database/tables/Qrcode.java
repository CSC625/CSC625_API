/*
 * This file is generated by jOOQ.
*/
package com.csc625.checkin.database.tables;


import com.csc625.checkin.database.Checkin;
import com.csc625.checkin.database.Indexes;
import com.csc625.checkin.database.Keys;
import com.csc625.checkin.database.tables.records.QrcodeRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Identity;
import org.jooq.Index;
import org.jooq.Name;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.1"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Qrcode extends TableImpl<QrcodeRecord> {

    private static final long serialVersionUID = 793385606;

    /**
     * The reference instance of <code>checkin.qrcode</code>
     */
    public static final Qrcode QRCODE = new Qrcode();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<QrcodeRecord> getRecordType() {
        return QrcodeRecord.class;
    }

    /**
     * The column <code>checkin.qrcode.ID</code>.
     */
    public final TableField<QrcodeRecord, Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>checkin.qrcode.Student_ID</code>.
     */
    public final TableField<QrcodeRecord, Integer> STUDENT_ID = createField("Student_ID", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>checkin.qrcode.Active</code>.
     */
    public final TableField<QrcodeRecord, String> ACTIVE = createField("Active", org.jooq.impl.SQLDataType.VARCHAR(45).nullable(false), this, "");

    /**
     * The column <code>checkin.qrcode.Code</code>.
     */
    public final TableField<QrcodeRecord, byte[]> CODE = createField("Code", org.jooq.impl.SQLDataType.BLOB.nullable(false), this, "");

    /**
     * Create a <code>checkin.qrcode</code> table reference
     */
    public Qrcode() {
        this(DSL.name("qrcode"), null);
    }

    /**
     * Create an aliased <code>checkin.qrcode</code> table reference
     */
    public Qrcode(String alias) {
        this(DSL.name(alias), QRCODE);
    }

    /**
     * Create an aliased <code>checkin.qrcode</code> table reference
     */
    public Qrcode(Name alias) {
        this(alias, QRCODE);
    }

    private Qrcode(Name alias, Table<QrcodeRecord> aliased) {
        this(alias, aliased, null);
    }

    private Qrcode(Name alias, Table<QrcodeRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Checkin.CHECKIN;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.QRCODE_PRIMARY, Indexes.QRCODE_STUDENT_ID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<QrcodeRecord, Integer> getIdentity() {
        return Keys.IDENTITY_QRCODE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<QrcodeRecord> getPrimaryKey() {
        return Keys.KEY_QRCODE_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<QrcodeRecord>> getKeys() {
        return Arrays.<UniqueKey<QrcodeRecord>>asList(Keys.KEY_QRCODE_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<QrcodeRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<QrcodeRecord, ?>>asList(Keys.QRCODE_IDFK_1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qrcode as(String alias) {
        return new Qrcode(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Qrcode as(Name alias) {
        return new Qrcode(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Qrcode rename(String name) {
        return new Qrcode(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Qrcode rename(Name name) {
        return new Qrcode(name, null);
    }
}
