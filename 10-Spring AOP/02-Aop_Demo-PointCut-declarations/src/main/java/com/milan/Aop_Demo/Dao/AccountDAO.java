package com.milan.Aop_Demo.Dao;

import com.milan.Aop_Demo.Account;

import java.util.List;

public interface AccountDAO {

    void addAccount(Account account, boolean verified);

    void deleteAccount(Account account);

    public String getName();

    public void setName(String name);

    public int getAccountId();

    public void setAccountId(int accountId);

    //return list of accounts
    public List<Account> findAccounts();

    public List<Account> findAccounts(boolean verified);
}
