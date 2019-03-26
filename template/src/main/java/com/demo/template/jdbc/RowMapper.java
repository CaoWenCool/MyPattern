package com.demo.template.jdbc;

import java.sql.ResultSet;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:22
 * @version: V1.0
 * @detail:
 **/
public interface RowMapper<T> {
    T mapRow(ResultSet rs, int rowNum)throws Exception;
}
