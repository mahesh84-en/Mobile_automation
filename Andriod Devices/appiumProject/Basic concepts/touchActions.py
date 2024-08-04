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
element = driver.find_elements(AppiumBy.XPATH, value='//android.widget.app[@text="contacts"]')
actions =TouchAction(driver)
actions.tap(element[1]).perform().release()
actions.long_press(element[1]).perform().release()
wait = WebDriverWait(driver, 20)
wait.until(EC.element_to_be_clickable((AppiumBy.XPATH, "//*[@text=';']")))
driver.find_element(AppiumBy.XPATH, value='//*[@text=";"]').click()
# Find the start and end elements
start_element = driver.find_element(AppiumBy.XPATH, '//android.widget.TextView[@text="StartText"]')
end_element = driver.find_element(AppiumBy.XPATH, '//android.widget.TextView[@text="EndText"]')

# Perform the scroll action
actions.press(start_element).move_to(end_element).release().perform()

#alert concepts

driver.switch_to.alert.accept()
