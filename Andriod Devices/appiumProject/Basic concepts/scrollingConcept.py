from appium import webdriver
from typing import Any, Dict
from appium.options.common import AppiumOptions
from appium.webdriver.common.appiumby import AppiumBy
from appium.webdriver.common.touch_action import TouchAction
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
caps: Dict[str, Any] = {
    'platformName': 'Android',
    'automationName' : "uiautomator2",
    'deviceName' : 'Android',
    'appPackage': 'com.hmh.api',
    'appActivity': '.ApiDemos',
    'language': 'en',
    'locale': 'US'
}

url = 'http://localhost:4724'

driver = webdriver.Remote(url, options=AppiumOptions().load_capabilities(caps))
driver.implicitly_wait(10)

continue_button = driver.find_element(AppiumBy.XPATH, '//android.widget.Button[@test="Continue"]')
if continue_button.is_displayed():
    continue_button.click()
    wait = WebDriverWait(driver, 10)
    ele = wait.until(EC.element_to_be_clickable((AppiumBy.XPATH, "com.android.permistions.//allowbutoon")))
    ele.click()

#scrill INto wallpaper option

driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiScrollable(new uiSelector().scrollable(true)).scrollIntoView(new uiSelector().text("wallpaper"))')

#scrolling up and down vertical scrolling
#we can achive this in two ways
#1. mathematical operation

deviceSize = driver.get_window_size()
print(deviceSize)
screen_width =deviceSize['width']
screenHeight = deviceSize['height']
print(screenHeight)
print(screen_width)
statX = screen_width/2
endx = screen_width/2
Staty = screenHeight*8/9
EndY = screenHeight/9

actions = TouchAction(driver)
#scrolling down
actions.long_press(None, statX,Staty).move_to(None, endx,EndY).release().perform()
#scrolling up
actions.long_press(None, endx, EndY).move_to(None, statX, Staty).release().perform()

#2 second approch with uiscrollable object

driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiScrollable(new UiSelector().scrollable(true)).setAsVerticaleList().scrollToEnd(5)')
driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiScrollable(UiSelector().scrollable(true)).setAsVerticalList().ScrollToBegining(10,3)')

#horizontal scrolling

driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiAcrollable(new UiSelector().Scrollable(true)).SetASHorizontalList().ScrollToEnd(5)')
driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiAcrollable(new UiSelector().Scrollable(true)).SetASHorizontalList().ScrollToBegining(5)')
driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiAcrollable(new UiSelector().Scrollable(true)).SetASHorizontalList().ScrollForward(5)')
driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiAcrollable(new UiSelector().Scrollable(true)).SetASHorizontalList().ScrollBackward(5)')



