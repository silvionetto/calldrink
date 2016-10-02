package com.calldrink.test;

import com.calldrink.bo.UserBO;
import com.calldrink.entity.User;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by silvionetto on 9/11/16.
 */
public class UserTest extends BaseTest {

    private UserBO userBO;

    @Override
    @Before
    public void setup() {
        super.setup();
        userBO = new UserBO(getSession());
    }

    @Test
    public void testCreate() {
        Transaction transaction = getSession().beginTransaction();

        User user = new User();
        user.setEmail("silvio.netto@gmail.com");
        user.setEntered_date(Calendar.getInstance());
        user.setName("Silvio Netto");
        user.setPassword("senha");
        user.setUpdated_date(Calendar.getInstance());
        user.setVersion(0);
        userBO.create(user);

        User user2 = new User();
        user2.setEmail("deboracouttinho@gmail.com");
        user2.setEntered_date(Calendar.getInstance());
        user2.setName("Debora Coutinho");
        user2.setPassword("senha");
        user2.setUpdated_date(Calendar.getInstance());
        user2.setVersion(0);

        userBO.create(user2);
        transaction.commit();


        List result = userBO.findAll();

        assertEquals(2, result.size());

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
