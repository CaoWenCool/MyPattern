package com.demo.template.jdbc.dao;

import com.demo.template.jdbc.JdbcTemplate;
import com.demo.template.jdbc.Member;
import com.demo.template.jdbc.RowMapper;

import javax.activation.DataSource;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:23
 * @version: V1.0
 * @detail:
 **/
public class MemberDao extends JdbcTemplate {
    public MemberDao(DataSource dataSource){
        super(dataSource);
    }

    public List<?> selectAll(){
        String sql = "select * from t_member";
        return super.executeQuery(sql, new RowMapper<Member>() {
            public  Member mapRow(ResultSet rs, int rowNum)throws Exception{
                Member member = new Member();
                //字段过多，用原型模式
                member.setUsername(rs.getString("username"));
                member.setNickname(rs.getString("nickname"));
                member.setPassword(rs.getString("password"));
                member.setAddr(rs.getString("addr"));
                member.setAge(rs.getInt("age"));
                return member;
            }
        },null);
    }
}
