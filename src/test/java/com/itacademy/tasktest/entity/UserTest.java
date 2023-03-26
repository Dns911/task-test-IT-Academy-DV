package com.itacademy.tasktest.entity;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    @DataProvider(name = "testRole")
    public Object[][] testData() {
        return new Object[][]{
                {"Administrator", User.Role.ADMINISTRATOR},
                {"Sdfgdfg1", User.Role.CUSTOMER_USER},
                {"cusTomer_roLE", User.Role.CUSTOMER_USER}};
    }

    @Test(dataProvider = "testRole")
    public void testParseRole(String str, User.Role expected) {
        User.Role actual = User.Role.find(str);
        assertEquals(expected, actual, "Not correct");
    }
}