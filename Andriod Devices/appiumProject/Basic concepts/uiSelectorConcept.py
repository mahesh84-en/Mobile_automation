from appium import webdriver
from typing import Any, Dict
from appium.options.common import AppiumOptions
from appium.webdriver.common.appiumby import AppiumBy


caps: Dict[str, Any] = {
    'platformName': 'Android',
    'automationName' : "uiautomator2",
    'deviceName' : 'Android',
    'appPackage': 'com.andriod.settings',
    'appActivity': '.Settings',
    'language': 'en',
    'locale': 'US'
}

url = 'http://localhost:4724'

driver = webdriver.Remote(url, options=AppiumOptions().load_capabilities(caps))

firstName = driver.find_element(AppiumBy.ANDROID_UIAUTOMATOR, 'new UiSelector().text("First Name)').send_keys("maheshbabu")

#few other methods in uiselector
# className, discription, descriptionContains, descriptionMaches, text,textStartsWith,textContains,textMAtched, focussed, selected, textStartsWith
driver.quit()