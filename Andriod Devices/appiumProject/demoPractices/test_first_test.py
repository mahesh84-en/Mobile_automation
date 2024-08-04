import time

from appium import webdriver

des_caps = dict (

    deviceName='Android',
    platformName='Android',
    browserName='Chrome',
    automationName='uiautomator2'


)


driver = webdriver.Remote('http://127.0.0.1:4723', des_caps)
driver.get("http://google.com")
time.sleep(2)
driver.quit()