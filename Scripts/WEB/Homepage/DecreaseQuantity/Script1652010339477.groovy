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

WebUI.callTestCase(findTestCase('WEB/Auth/Login_Success'), [:], FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('WEB/Homepage/AddToCart/button_Beli'))

WebUI.click(findTestObject('WEB/Homepage/AddToCart/button_Cart'))

WebUI.click(findTestObject('WEB/Transactions/IncreaseQuantity/add_quantity'))

int jml = WebUI.getText(findTestObject('WEB/Homepage/AddToCart/jml_product'))

int price = Integer.parseInt(WebUI.getText(findTestObject('WEB/Transactions/IncreaseQuantity/price')))

int total_awal = Integer.parseInt(WebUI.getText(findTestObject('WEB/Transactions/IncreaseQuantity/total_price')))

WebUI.click(findTestObject('WEB/Transactions/IncreaseQuantity/decrease_quantity'))

int jml_2 = WebUI.getText(findTestObject('WEB/Homepage/AddToCart/jml_product'))

int total_akhir = Integer.parseInt(WebUI.getText(findTestObject('WEB/Transactions/IncreaseQuantity/total_price')))

WebUI.verifyEqual(jml - 1, jml_2)

WebUI.verifyEqual(total_awal - price, total_akhir)

WebUI.closeBrowser()

