package com.demo.template.jdbc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:21
 * @version: V1.0
 * @detail:
 **/
public abstract class JdbcTemplate {
    private DataSource dataSource;

    public JdbcTemplate(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values){
        try{
            //1\获取连接
            Connection connection = this.getConnection();
            //2、创建语句集
            PreparedStatement pstm = this.createPrepareStatement(connection,sql);
            //3、执行语句集
            ResultSet rs = this.executeQuery(pstm,values);
            //4、处理语句集
            List<?> result = this.paresResultSet(rs,rowMapper);
            //5、关闭结果集
            this.closeResultSet(rs);
            //6、关闭语句集
            this.closeStatement(pstm);
            //7、关闭连接
            this.closeConnection(connection);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    protected void closeConnection(Connection conn)throws Exception{
        //数据库连接池，
        conn.close();
    }

    protected void closeStatement(PreparedStatement pstm)throws Exception{
        pstm.close();
    }

    protected void closeResultSet(ResultSet rs)throws Exception{
        rs.close();
    }

    protected List<?> paresResultSet(ResultSet rs,RowMapper<?> rowMapper) throws Exception{
        List<Object> result = new ArrayList<Object>();
        int rowNum = 1;
        while(rs.next()){
            result.add(rowMapper.mapRow(rs,rowNum++));
        }
        return result;
    }

    protected ResultSet executeQuery(PreparedStatement pstm,Object[] values)throws Exception{
        for(int i=0;i<values.length;i++){
            pstm.setObject(i,values[i]);
        }
        return pstm.executeQuery();
    }

    protected PreparedStatement createPrepareStatement(Connection conn,String sql)throws Exception{
        return conn.prepareStatement(sql);
    }

    public Connection getConnection()throws Exception{
        return this.dataSource.getConnection();
    }
}
