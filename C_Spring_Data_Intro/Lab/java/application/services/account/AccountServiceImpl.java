package application.services.account;

import application.models.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import application.repositories.AccountRepository;

import java.math.BigDecimal;

@Service
@Primary
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void withdrawMoney(BigDecimal money, Long id) {
        if (!accountRepository.exists(id)){
            throw new IllegalArgumentException("No such account");
        }

        Account account = accountRepository.findOne(id);
        BigDecimal newBalance = account.getBalance().subtract(money);
        account.setBalance(newBalance);
        accountRepository.save(account);
    }

    @Override
    public void transferMoney(BigDecimal money, Long id) {
        Account acc = accountRepository.findOne(id);
        if (acc == null){
            throw new IllegalArgumentException("No such acount");
        }

        if(acc.getUser() == null){
            throw new IllegalArgumentException("No such user for this account");
        }

        if (acc.getBalance().compareTo(BigDecimal.ZERO) < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }

        BigDecimal newBalance = acc.getBalance().add(money);
        acc.setBalance(newBalance);
        accountRepository.save(acc);
    }
}
