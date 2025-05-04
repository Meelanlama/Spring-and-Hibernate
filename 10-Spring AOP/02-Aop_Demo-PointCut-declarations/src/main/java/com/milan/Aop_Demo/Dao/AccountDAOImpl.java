package com.milan.Aop_Demo.Dao;

import com.milan.Aop_Demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAOImpl implements AccountDAO {

    private String name;

    private int accountId;

    @Override
    public void addAccount(Account account, boolean verified) {
        System.out.println(getClass() + ": Adding Account..");
    }

    @Override
    public void deleteAccount(Account account) {
        System.out.println("AccountDAOImpl: Deleting Account..");
    }

    public String getName() {
        System.out.println("Getter method executed..");
        return name;
    }

    public void setName(String name) {
        System.out.println("Setter method executed..");
        this.name = name;
    }

    public int getAccountId() {
        System.out.println("Getter method executed..");
        return accountId;
    }

    public void setAccountId(int accountId) {
        System.out.println("Setter method executed..");
        this.accountId = accountId;
    }

    @Override
    public List<Account> findAccounts() {

        //if boolean is false call the method
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean verified) {

        //if boolean is true throw exception
        //for academic purpose: simulate exception
        if (verified) {
            throw new RuntimeException("Not verified yet");
        }

        List<Account> myAccounts = new ArrayList<>();

        //Create sample accounts
        Account myAccount = new Account("Meelan",1000000);
        Account myAccount1 = new Account("Ram",1500000);
        Account myAccount2 = new Account("Hari",1500000);

        //add those accounts to our accounts list
        myAccounts.add(myAccount);
        myAccounts.add(myAccount1);
        myAccounts.add(myAccount2);

        return myAccounts;
    }
}
