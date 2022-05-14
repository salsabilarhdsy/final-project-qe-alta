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

for (int i = 1; i <= 7; i++) {
    Mobile.startExistingApplication('com.example.frontend_mobile')

    Mobile.tap(findTestObject('MOBILE/Auth/Register/android.widget.Button - Login 2'), 5)

    Mobile.tap(findTestObject('MOBILE/Auth/Register/android.widget.Button - Register a'), 0)

    Mobile.tap(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Fullname'), 0)

    if (findTestData('WEB/Register').getValue(1, i) != '') {
        Mobile.setText(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Fullname'), findTestData('WEB/Register').getValue(
                1, i), 0)
    } else {
        Mobile.clearText(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Fullname'), 0)
    }
    
    Mobile.tap(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Email'), 0)

    if (findTestData('WEB/Register').getValue(2, i) != '') {
        Mobile.setText(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Email'), findTestData('WEB/Register').getValue(
                2, i), 0)
    } else {
        Mobile.clearText(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Email'), 0)
    }
    
    Mobile.tap(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Password'), 0)

    if (findTestData('WEB/Register').getValue(3, i) != '') {
        Mobile.setText(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Password'), findTestData('WEB/Register').getValue(
                3, i), 0)
    } else {
        Mobile.clearText(findTestObject('MOBILE/Auth/Register/android.widget.EditText - Password'), 0)
    }
    
    Mobile.pressBack()

    Mobile.tap(findTestObject('MOBILE/Auth/Register/android.widget.Button - Register button'), 1)

    if (findTestData('WEB/Register').getValue(4, i) == 'negative') {
        Mobile.verifyElementVisible(findTestObject('MOBILE/Auth/Register/android.widget.Button - Fullname'), 2, FailureHandling.CONTINUE_ON_FAILURE)

        Mobile.pressBack()
    } else {
        Mobile.verifyElementVisible(findTestObject('MOBILE/Auth/Register/android.widget.Button - Login 2'), 2)
    }
    
    Mobile.closeApplication()
}

Mobile.waitForElementPresent(findTestObject(null), 0)

