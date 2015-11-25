package pageObjects

import pageObjects.pageObjectUtils.BasePageObject
import testConfig.TestConfig


class StampleApp extends BasePageObject(TestConfig.baseUrl) {
  //implicit val webDriver: WebDriver = TestConfig.webDriver

  val STAMPLE_APP_ROOT_NODE = id("reactAppContainer")

  def stampleRootDisplayed = STAMPLE_APP_ROOT_NODE.element.isDisplayed
}

