package com.service.InitPak;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * Created by C.A.O on 2017/12/14.
 */
@Data
@AllArgsConstructor
@ToString
public class TableInfo {

    private String tableName;
    private String columnType;
    private String columnName;
    private Integer columnSize;
    private String remark;


}
