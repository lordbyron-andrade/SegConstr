package com.kgm.segconstr.ManejoBD;

public class BDDefinicion {
    public static final String[] CAMPOS = new String[] {"id_organizaciones_00", "id_uuid", "id_int",
                                                         "id_long", "texto"};
    public static final String TABLE_ORGS = "organizaciones_00";
    public static final String COLUMN_ID_UUID = "id_uuid";
    public static final String COLUMN_ID_INT = "id_int";
    public static final String COLUMN_ID_LONG = "id_long";
    public static final String COLUMN_TEXTO = "texto";
    public static final String COLUMN_ID_ID = "id_organizaciones_00";
    public static final String SQL_CREATE =
            "CREATE TABLE " + TABLE_ORGS + "(" +
                    COLUMN_ID_UUID + " VARCHAR(60)," +
                    COLUMN_ID_INT + " INT," +
                    COLUMN_ID_LONG + " BIGINT," +
                    COLUMN_TEXTO + " VARCHAR(170)," +
                    COLUMN_ID_ID + " VARCHAR(60)" + ");";
    public static final String SQL_DELETE =
            "DROP TABLE " + TABLE_ORGS;


}
