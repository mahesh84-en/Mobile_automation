import allure
import pytest
from allure_commons.types import AttachmentType


@pytest.fixture()
def adding_screenshot_fail(request):
    yield
    item = request.node
    if item.rep.call.failed:
        allure.attach(driver.get_screenshot_as_png(), name="failedtest", attachment_type=AttachmentType.PNG)


@pytest.mark.usefixtures("adding_screenshot_fail")
def test_login():
    print("login")