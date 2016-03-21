package com.caseyscarborough.tutorial.testing;

import com.caseyscarborough.tutorial.testing.dao.Dao;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EasyResourceMockitoTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Dao dao;
    private EasyResource resource;

    @Before
    public void setUp() throws Exception {
        dao = mock(Dao.class);
        resource = new EasyResource(dao);
    }

    @Test
    public void testGetDatabaseContent() throws Exception {
        when(dao.getDatabaseContent()).thenReturn("Hello!");

        Response response = resource.getDatabaseContent();
        String databaseContent = response.getEntity().toString();
        assertEquals("Hello!", databaseContent);
    }

    @Test
    public void testGetDatabaseContentWhenDaoThrowsException() throws Exception {
        when(dao.getDatabaseContent()).thenThrow(new RuntimeException("Database Error"));

        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("Database Error");
        resource.getDatabaseContent();
    }
}
