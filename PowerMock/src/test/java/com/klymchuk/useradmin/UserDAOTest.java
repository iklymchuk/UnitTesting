package com.klymchuk.useradmin;

import com.klymchuk.useradmin.dao.UserDAO;
import com.klymchuk.useradmin.dto.User;
import com.klymchuk.useradmin.util.IDGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * Created by iklymchuk on 3/3/17.
 */

//Change the default Runner to the custom PowerMockRunner
@RunWith(PowerMockRunner.class)
@PrepareForTest(IDGenerator.class)
public class UserDAOTest {

    @Test
    public void createShouldReturnUserId() {

        UserDAO dao = new UserDAO();

        mockStatic(IDGenerator.class);
        when(IDGenerator.generateID()).thenReturn(1);

        int result = dao.create(new User());
        assertEquals(1, result);
        verifyStatic();
    }
}
