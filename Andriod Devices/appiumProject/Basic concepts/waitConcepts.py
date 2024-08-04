from appium import webdriver
from typing import Any, Dict
from appium.options.common import AppiumOptions
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import ElementNotVisibleException, NoSuchElementException

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

#implicit wait
driver.implicitly_wait(20)

#explicit wait concept

wait = WebDriverWait(driver, 10)
wait.until(EC.element_to_be_clickable((AppiumBy.XPATH, "com.android.permistions.//allowbutoon")))

#fluentWait concept
flu_wait = WebDriverWait(driver, 10, poll_frequency=1, ignored_exceptions=[ElementNotVisibleException, NoSuchElementException])

flu_wait.until(EC.element_to_be_clickable((AppiumBy.XPATH, "com.android.permistions.//allowbutoon")))

driver.quit()
