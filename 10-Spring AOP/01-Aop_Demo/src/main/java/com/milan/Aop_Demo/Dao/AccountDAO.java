package com.milan.Aop_Demo.Dao;

import com.milan.Aop_Demo.Account;

public interface AccountDAO {

    void addAccount(Account account, boolean verified);

    void deleteAccount(Account account);
}
