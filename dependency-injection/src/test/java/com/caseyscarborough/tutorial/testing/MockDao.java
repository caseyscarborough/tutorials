package com.caseyscarborough.tutorial.testing;

import com.caseyscarborough.tutorial.testing.dao.Dao;

public class MockDao extends Dao {

    @Override
    public String getDatabaseContent() {
        return "Hello!";
    }
}
