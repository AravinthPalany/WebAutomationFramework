package org.framework.tests;

import org.assertj.core.api.Assertions;
import org.framework.basetest.CommonToAllTest;
import org.framework.pages.PageObjectModel.DashboardPage_POM;
import org.framework.pages.PageObjectModel.LoginPage_POM;
import org.framework.utils.PropertyReader;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestVWOLoginPOMBaseTest extends CommonToAllTest {

    @Test(groups = {"reg"}, priority = 2)
    public void testLoginNegative() {

        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openVWOLoginURL();
        String error_msg_text = loginPagePom.loginToVWOInvalidCreds();

        // TestNG
        Assert.assertEquals(error_msg_text, "Your email, password, IP address or location did not match");

        // AssertJ
        Assertions.assertThat(error_msg_text )
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readyKey("error_message"));
    }

    @Test(groups = {"smoke"} , priority = 1)
    public void testLoginPositive() {
        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openVWOLoginURL();
        loginPagePom.loginToVWOValidCreds();
        DashboardPage_POM dashboardPagePom = loginPagePom.afterLoginVWOValidCreds();
        String expected_username = dashboardPagePom.loggedInUserName();

        // TestNG
        Assert.assertEquals(expected_username, PropertyReader.readyKey("expected_username"));

        // AssertJ
        Assertions.assertThat(expected_username)
                .isNotNull()
                .isNotBlank()
                .contains(PropertyReader.readyKey("expected_username"));

    }

}
