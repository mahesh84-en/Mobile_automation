
#how to identify natives app package and app activity
#1. we have open cmd as run as administrator
#2. run the command adb devices
#3. open the emulator/real device click on any app
#4 after come to the cmd and enter the command---- adb shell
#5. dumpsys window windows | grep -E 'mTopActivityComponent'

# we will get appPackage and app activity

# 'appPackage': 'com.andriod.settings',
# 'appActivity': '.Settings',

#example of native app of phone call
from appium import webdriver
from typing import Any, Dict
from appium.options.common import AppiumOptions
from appium.webdriver.common.appiumby import AppiumBy


caps: Dict[str, Any] = {
    'platformName': 'Android',
    'automationName' : "uiautomator2",
    'deviceName' : 'Android',
    'appPackage': 'com.google.andriod.dialer',
    'appActivity': '.com.andriod.dialer.main.impl.MainActivity',
    'language': 'en',
    'locale': 'US'
}

url = 'http://localhost:4724'

driver = webdriver.Remote(url, options=AppiumOptions().load_capabilities(caps))

driver.find_element(by=AppiumBy.XPATH, value='//android.widget.TextView[@text="Recents"]').click()

driver.find_element(by=AppiumBy.ACCESSIBILITY_ID, value="Key pad").click()

for i in range(0, 10):
    driver.find_element(by=AppiumBy.XPATH, value=f'//andriod.widget.TextView[@text="{i}"]').click()

driver.find_element(by=AppiumBy.ACCESSIBILITY_ID, value="Dail").click()
