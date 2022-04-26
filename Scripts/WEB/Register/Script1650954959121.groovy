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

WebUI.navigateToUrl('https://qa.alta.id/')

WebUI.click(findTestObject('WEB/Register/login_ico'))

WebUI.click(findTestObject('WEB/Register/register_a'))

for (int i = 1; i <= 6; i++) {
    System.out.println('Data Test ke-' + i)

    if (findTestData('WEB/Register').getValue(1, i) != '') {
        WebUI.setText(findTestObject('WEB/Register/fullname_txtbox'), findTestData('WEB/Register').getValue(1, i))
    }
    
    if (findTestData('WEB/Register').getValue(2, i) != '') {
        WebUI.setText(findTestObject('WEB/Register/email_txtbox'), findTestData('WEB/Register').getValue(2, i))
    }
    
    if (findTestData('WEB/Register').getValue(3, i) != '') {
        WebUI.setText(findTestObject('WEB/Register/password_txtbox'), findTestData('WEB/Register').getValue(3, i))
    }
    
    WebUI.click(findTestObject('WEB/Register/register_btn'))

    if (findTestData('WEB/Register').getValue(4, i) == 'negative') {
        WebUI.verifyElementPresent(findTestObject('WEB/Register/register_btn'), 20, FailureHandling.CONTINUE_ON_FAILURE)

        WebUI.navigateToUrl('https://qa.alta.id/auth/register')
    } else {
        WebUI.verifyElementPresent(findTestObject('WEB/Login/login_btn'), 20, FailureHandling.CONTINUE_ON_FAILURE)
    }
}

