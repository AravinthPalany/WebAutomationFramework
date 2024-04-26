package org.framework.tests;

import org.framework.basetest.CommonToAllTest;
import org.framework.pages.PageObjectModel.LoginPage_POM;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestVWOLoginPOM extends CommonToAllTest {

    @Test
    public void testLoginNegative(){

        LoginPage_POM loginPagePom = new LoginPage_POM();
        loginPagePom.openVWOLoginURL();
        String error_msg_text  = loginPagePom.loginToVWOInvalidCreds();
        Assert.assertEquals(error_msg_text,"Your email, password, IP address or location did not match");
    }

}
