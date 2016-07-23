package com.dayswideawake.webrobot.core.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dayswideawake.webrobot.core.Application;
import com.dayswideawake.webrobot.core.entity.Account;
import com.dayswideawake.webrobot.core.model.EmailAddress;
import com.dayswideawake.webrobot.core.model.HashedPassword;

@SpringApplicationConfiguration(Application.class)
@TestExecutionListeners({TransactionalTestExecutionListener.class})
public class AccountRepositoryTest extends AbstractTestNGSpringContextTests {
  
    @Autowired
    private AccountRepository accountRepository;
    @PersistenceContext
    private EntityManager entityManager;
    
    @Test
    @Transactional
    public void accountShouldBeSavedAndFoundWithCorrectPassword(){
        String passwordString = "Pa$$w0rd";
        String emailAddressString = "example@example.com";
        Account account = new Account(new EmailAddress(emailAddressString), new HashedPassword(passwordString));
        account = accountRepository.save(account);
        entityManager.clear();
        Account loadedAccount = accountRepository.findOne(account.getId());
        Assert.assertEquals(loadedAccount.getPassword(), new HashedPassword(passwordString));
        Assert.assertEquals(loadedAccount.getEmailAddress(), new EmailAddress(emailAddressString));
    }
    
    
}
