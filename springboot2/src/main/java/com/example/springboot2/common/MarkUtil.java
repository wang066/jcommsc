package com.example.springboot2.common;


/**
 * @author jiangyuesong
 * @date 2021/9/18
 */
public class MarkUtil {

    private MarkUtil() {

    }

    public static String generateUpdateMarkSql(int index, boolean clear, String field, String tableName) {
        final int shifts = index % 64;
        String sql = "update " + tableName + " set " + field + "=" + field;
        if (clear) {
            sql = sql + " & " + (BitUtil.clear(-1L, shifts));
        } else {
            sql = sql + " | " + (1L << shifts);
        }
        return sql + " where id=?";
    }
}
