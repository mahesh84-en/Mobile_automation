from appium import webdriver
from typing import Any, Dict
from appium.options.common import AppiumOptions
from appium.webdriver.common.appiumby import AppiumBy
from selenium.webdriver.common.keys import Keys

caps: Dict[str, Any] = {
    'platformName': 'Android',
    'automationName' : "uiautomator2",
    'deviceName' : 'Android',

}

url = 'http://localhost:4724'

driver = webdriver.Remote(url, options=AppiumOptions().load_capabilities(caps))

chrome = driver.find_element(by=AppiumBy.ACCESSIBILITY_ID, value='Chrome')
chrome.click()

search_box = driver.find_element(by=AppiumBy.XPATH, value='//*[@text="search or type web address]')
search_box.send_keys("maheshbabu")
search_box.send_keys(Keys.ENTER)



driver.quit()