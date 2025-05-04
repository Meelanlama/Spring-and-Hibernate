package com.milan.Aop_Demo;

import com.milan.Aop_Demo.Dao.AccountDAO;
import com.milan.Aop_Demo.Dao.MemberShipDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AopDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AccountDAO accountDAO, MemberShipDao memberShipDao) {
		return runner -> {
			demoBeforeAdvice(accountDAO,memberShipDao);
		};
	}

	private void demoBeforeAdvice(AccountDAO accountDAO, MemberShipDao memberShipDao) {
		//call business method
		Account account = new Account();
		accountDAO.addAccount(account,true);
		accountDAO.deleteAccount(account);

		//call membership business method
		memberShipDao.addMember();
	}
}
