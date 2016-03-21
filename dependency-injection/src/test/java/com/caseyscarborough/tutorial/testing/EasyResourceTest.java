package com.caseyscarborough.tutorial.testing;

import com.caseyscarborough.tutorial.testing.dao.Dao;
import org.junit.Test;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;

public class EasyResourceTest {

    @Test
    public void testGetContent() throws Exception {
        // Create our "mock" dao instance
        Dao dao = new MockDao();

        // Pass our mock instance into our resource using dependency injection
        EasyResource resource = new EasyResource(dao);

        // Test that our content is retrieved from the DAO.
        Response response = resource.getDatabaseContent();
        String databaseContent = response.getEntity().toString();
        assertEquals("Hello!", databaseContent);
    }
}
