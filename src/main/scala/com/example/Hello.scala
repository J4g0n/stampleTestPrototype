package com.example

import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.{PhantomJSDriverService, PhantomJSDriver}
import org.openqa.selenium.remote.{CapabilityType, DesiredCapabilities}

object TestStample {
  def main(args: Array[String]): Unit = {
    val baseCaps = new DesiredCapabilities
    baseCaps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true)
    baseCaps.setCapability("takesScreenshot", true)
    baseCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "/usr/local/bin/phantomjs")

    println("Doing !")
    val webDriver: WebDriver = new PhantomJSDriver(baseCaps)
    webDriver.get("http://www.amazon.com")
    println(webDriver.getTitle)
    println("Done !")
  }
}
