package com.milan.Aop_Demo;

import com.milan.Aop_Demo.Dao.AccountDAO;
import com.milan.Aop_Demo.Dao.MemberShipDao;
import com.milan.Aop_Demo.Service.TrafficFortuneService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDao memberShipDao,
											   TrafficFortuneService trafficFortuneService) {
		return runner -> {
			//demoBeforeAdvice(accountDAO,memberShipDao);

			//demoAfterReturningAdvice(accountDAO);

			//demoAfterThrowingAdvice(accountDAO);

			//demoAfterAdvice(accountDAO);

			//demoAroundAdvice(trafficFortuneService);

			demoAroundHandleException(trafficFortuneService);
		};
	}

	private void demoAroundHandleException(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoAroundAdvice");

		System.out.println("Calling getFortune()");

		boolean trip = true;
		String data = trafficFortuneService.getFortune(trip);

		System.out.println("\n Fortune: " + data);

		System.out.println("Done..");

	}

	private void demoAroundAdvice(TrafficFortuneService trafficFortuneService) {
		System.out.println("Main Program: demoAroundAdvice");

		System.out.println("Calling getFortune()");

		String data = trafficFortuneService.getFortune();

		System.out.println("\n Fortune: " + data);

		System.out.println("Done..");
	}

	private void demoAfterAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = null;

		try {
			//add a boolean flag to simulate exceptions
			boolean trip = false;
			accounts = accountDAO.findAccounts(trip);
		}catch (Exception e) {
			System.out.println("\n ---- Main program: .... Caught Exception: " + e.getMessage());
		}

		//display accounts
		System.out.println("\n Main Program: After demoAfterAdvice method");
		System.out.println("-----");

		System.out.println("Lists: " + accounts);
	}

	private void demoAfterThrowingAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = null;

		try {
			//add a boolean flag to simulate exceptions
			boolean trip = true;
			accounts = accountDAO.findAccounts(trip);
		}catch (Exception e) {
			System.out.println("\n ---- Main program: .... Caught Exception: " + e.getMessage());
		}

		//display accounts
		System.out.println("\n Main Program: After demoAfterThrowingAdvice method");
		System.out.println("-----");

		System.out.println("Lists: " + accounts);

	}

	private void demoAfterReturningAdvice(AccountDAO accountDAO) {
		//call method to find accounts
		List<Account> accounts = accountDAO.findAccounts();

		//display accounts
		System.out.println("\n\n Program: After demoAfterReturningAdvice method");
		System.out.println("-----");

		System.out.println(accounts);

		System.out.println("\n");
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MemberShipDao memberShipDao) {
		//call business method
		Account account = new Account();
		account.setName("John Doe");
		account.setBalance(10000);
		accountDAO.addAccount(account,true);
		accountDAO.deleteAccount(account);

		//calling account dao getters/setters method
		accountDAO.setName("Milan");
		String accountName = accountDAO.getName();

		accountDAO.setAccountId(1);
		int accountId = accountDAO.getAccountId();

		//call membership business method
		memberShipDao.addMember();
	}
}
