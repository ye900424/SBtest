package com.service.InitPak;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by C.A.O on 2017/12/14.
 */
@Service
public class InitTables {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @PostConstruct
    public void initTable() {
        System.out.println("============666========");
        Connection conn = sqlSessionFactory.openSession().getConnection();
        DatabaseMetaData data = null;
        try {
            data = conn.getMetaData();
            ResultSet rs = data.getColumns(null, null, null, null);
            while (rs.next()) {
                //打印字段table信息
                String tableName = rs.getString("TABLE_NAME");
                //打印字段name信息
                String columnName = rs.getString("COLUMN_NAME");
                //获取字段类型
                String type = rs.getString("TYPE_NAME");
                //获取字段长度
                int size = rs.getInt("COLUMN_SIZE");
                //获取字段备注
                String remark = rs.getString("REMARKS");

                TableInfo tableInfo = new TableInfo(tableName,columnName,type,size,remark);

                System.out.println(tableInfo.toString());


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
