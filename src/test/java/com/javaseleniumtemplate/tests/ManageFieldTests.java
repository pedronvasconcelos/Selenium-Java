package com.javaseleniumtemplate.tests;


import com.javaseleniumtemplate.bases.TestBase;
import com.javaseleniumtemplate.flows.LoginFlows;
import com.javaseleniumtemplate.pages.MainPage;
import com.javaseleniumtemplate.pages.ManageCustomFieldPage;
import com.javaseleniumtemplate.pages.ManagePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ManageFieldTests extends TestBase {

    //Objects
    LoginFlows loginFlows;
    MainPage mainPage;
    ManagePage managePage;
    ManageCustomFieldPage manageCustomFieldPage;

    @Test
    public void createNewCustomField(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageCustomFieldPage = new ManageCustomFieldPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String fieldName = "Automatizado";
        String sucessMessage = "Operation successful.";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageCustomField();
        manageCustomFieldPage.fillNameField(fieldName);
        manageCustomFieldPage.clickNewCustom();

        //Assert
        Assert.assertEquals(manageCustomFieldPage.returnSuccessText(), sucessMessage);
    }

    @Test
    public void editCustomField(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageCustomFieldPage = new ManageCustomFieldPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String fieldName = "Editar";
        String type = "Numeric";
        String sucessMessage = "Operation successful.";


        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageCustomField();
        manageCustomFieldPage.clickCustomField(fieldName);
        manageCustomFieldPage.selectType(type);
        manageCustomFieldPage.clickUpdate();

        //Assert
        Assert.assertEquals(manageCustomFieldPage.returnSuccessText(), sucessMessage);
    }
    @Test
    public void deleteCustomField(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageCustomFieldPage = new ManageCustomFieldPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String fieldName = "delete this field";
        String sucessMessage = "Operation successful.";


        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageCustomField();
        manageCustomFieldPage.clickCustomField(fieldName);
        manageCustomFieldPage.clickDelete();
        manageCustomFieldPage.clickUpdate();

        //Assert
        Assert.assertEquals(manageCustomFieldPage.returnSuccessText(), sucessMessage);
    }

    @Test
    public void validateRequiredNameCustomField(){
        //Instances
        loginFlows = new LoginFlows();
        mainPage = new MainPage();
        managePage = new ManagePage();
        manageCustomFieldPage = new ManageCustomFieldPage();

        //Parameters
        String user = "administrator";
        String password = "adm";
        String errorMessage = "APPLICATION ERROR #11";

        //Test
        loginFlows.signIn(user, password);
        mainPage.clickManage();
        managePage.clickManageCustomField();
        manageCustomFieldPage.clickNewCustom();

        //Assert
        Assert.assertEquals(manageCustomFieldPage.returnErrorText(), errorMessage);
    }

}