package com.nab.mayco;

import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.nab.mayco.model.User;
import com.nab.mayco.repository.UserRepositoryHbn;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MaycoApplication.class},
    webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)

public class UserRepositoryUnitTest {

  private Logger logger = Logger.getAnonymousLogger();

  @Autowired
  @Qualifier("UserRepositoryHbn")
  private UserRepositoryHbn repository;

  final User USER = new User("nicolas bloj", "nicobloj", "1234");

  final User USER2 = new User("nicolas2", "nicobloj2", "12342");

  @Before
  public void setUp() {
    repository.add(USER);
  }


  @Test
  public void getUserByUserNameTest() {
    org.junit.Assert.assertEquals(repository.list().size(), 1);
    User user = repository.getUserByUserName("nicobloj");
    logger.info(user.getName());
    org.junit.Assert.assertEquals(USER, repository.getUserByUserName("nicobloj"));
  }


}
