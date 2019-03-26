package com.demo.template.jdbc;

import com.demo.template.jdbc.dao.MemberDao;

import java.util.List;

/**
 * @author: admin
 * @create: 2019/3/26
 * @update: 10:22
 * @version: V1.0
 * @detail:
 **/
public class MemberDaoTest {
    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
