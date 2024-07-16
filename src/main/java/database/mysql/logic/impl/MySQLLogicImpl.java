package database.mysql.logic.impl;

import database.mysql.logic.MySQLLogic;

public class MySQLLogicImpl implements MySQLLogic {
    @Override
    public String escapeString(String str) {
        str = str.replace("\\", "\\\\")
                .replace("\b", "\\b")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t")
                .replace("\\x1A", "\\Z")
                .replace("\\x00", "\\0")
                .replace("'", "\\'")
                .replace("\"", "\\\"");
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.insert(0, "'");
        stringBuilder.append("'");
        return stringBuilder.toString();
    }

}
