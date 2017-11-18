package application;

import application.models.Account;
import application.models.User;
import application.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import application.services.account.AccountServiceImpl;
import application.services.user.UserServiceImpl;

import java.math.BigDecimal;
import java.util.Collections;

@SpringBootApplication
@Component
public class ConsoleRunner implements CommandLineRunner {
    private UserServiceImpl userService;
    private AccountServiceImpl accountService;
    private UserRepository userRepository;

    @Autowired
    public ConsoleRunner(UserServiceImpl userService, AccountServiceImpl accountService, UserRepository userRepository) {
        this.userService = userService;
        this.accountService = accountService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
//        User user = new User();
//
//        user.setAge(20);
//        user.setUsername("Panko1");
//
//        Account account = new Account();
//        account.setUser(user);
//        account.setBalance(new BigDecimal(2017));
//
//        user.setAccounts(Collections.singletonList(account));
        User user = userRepository.findOne(2L);

        System.out.println(user.getUsername());

        accountService.transferMoney(new BigDecimal(100), 1L);
    }
}
