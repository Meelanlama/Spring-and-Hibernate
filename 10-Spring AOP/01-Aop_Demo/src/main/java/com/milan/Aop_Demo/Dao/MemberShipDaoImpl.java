package com.milan.Aop_Demo.Dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDaoImpl implements MemberShipDao {
    @Override
    public boolean addMember() {
        System.out.println(getClass() + ": Adding account...");

        return true;
    }
}
