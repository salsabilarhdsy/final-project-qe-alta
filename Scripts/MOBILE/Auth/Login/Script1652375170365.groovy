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

    Mobile.delay(7, FailureHandling.CONTINUE_ON_FAILURE)

    Mobile.tap(findTestObject('MOBILE/Auth/Login/android.widget.Button - Login'), 0)

    Mobile.tap(findTestObject('MOBILE/Auth/Login/android.widget.EditText - Email'), 0)

    Mobile.setText(findTestObject('MOBILE/Auth/Login/android.widget.EditText - Email'), findTestData('WEB/Login').getValue(
            1, i), 0)

    Mobile.tap(findTestObject('MOBILE/Auth/Login/android.widget.EditText - Password'), 0)

    Mobile.setText(findTestObject('MOBILE/Auth/Login/android.widget.EditText - Password'), findTestData('WEB/Login').getValue(
            2, i), 0)

    Mobile.pressBack()

    Mobile.tap(findTestObject('MOBILE/Auth/Login/android.widget.Button - Login Button'), 0)

    Mobile.delay(3, FailureHandling.CONTINUE_ON_FAILURE)

    if (findTestData('WEB/Login').getValue(3, i) == 'negative') {
        Mobile.verifyElementVisible(findTestObject('MOBILE/Auth/Login/android.widget.EditText - Email'), 0, FailureHandling.CONTINUE_ON_FAILURE)
    } else {
        Mobile.verifyElementVisible(findTestObject('MOBILE/Auth/Login/android.widget.Button - Logout'), 0, FailureHandling.CONTINUE_ON_FAILURE)
    }
    
    Mobile.pressBack()

    Mobile.closeApplication()
}

