package ru.aasmc.jbaruch;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class JBaruchApplicationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    JBaruchProperties jBaruchProperties;

    @Test
    public void contextLoad() {
        MatcherAssert.assertThat(jBaruchProperties.getAnswers().size(), Matchers.greaterThan(5));
        MatcherAssert.assertThat(context, notNullValue());
    }
}
