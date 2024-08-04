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
    'appPackage': 'com.socialnmobile.dictapps.notepad.color.note',
    'appActivity': '.ApiDemos',
    'language': 'en',
    'locale': 'US'
}

url = 'http://localhost:4724'

driver = webdriver.Remote(url, options=AppiumOptions().load_capabilities(caps))

face_book_link = driver.find_element(AppiumBy.XPATH, value='//sndroid.widget.textview[@text="facebook"]')
face_book_link.click()

print(driver.context)
print(driver.contexts)
#we can do without switching to the context new versions
wait = WebDriverWait(driver, 20)
login = wait.until(EC.presence_of_element_located(AppiumBy.XPATH, value='//androif.widget[@text="login]'))
print(login.text)