import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

for (int i = 1; i <= 6; i++) {
    WebUI.navigateToUrl('https://qa.alta.id/')

    WebUI.click(findTestObject('WEB/Auth/Login/login_ico'))

    WebUI.setText(findTestObject('WEB/Auth/Login/email_txtbox'), findTestData('WEB/Login').getValue(1, i))

    WebUI.setText(findTestObject('WEB/Auth/Login/password_txtbox'), findTestData('WEB/Login').getValue(2, i))

    WebUI.click(findTestObject('WEB/Auth/Login/login_btn'))

    if (findTestData('WEB/Login').getValue(3, i) == 'negative') {
        WebUI.verifyElementPresent(findTestObject('WEB/Auth/Login/alert_msg'), 5, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        WebUI.verifyElementPresent(findTestObject('WEB/Auth/Logout/user_ico'), 5, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

