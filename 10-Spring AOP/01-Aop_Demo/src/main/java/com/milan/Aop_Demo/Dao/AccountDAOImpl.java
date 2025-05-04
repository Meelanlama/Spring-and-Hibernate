package com.milan.Aop_Demo.Dao;

import com.milan.Aop_Demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Override
    public void addAccount(Account account, boolean verified) {
        System.out.println(getClass() + ": Adding Account..");
    }

    @Override
    public void deleteAccount(Account account) {
        System.out.println("AccountDAOImpl: Deleting Account..");
    }
}
