package pageObjects.pageObjectsImpl

import objectLocatorRepository.OnBoardingComponentSelectors
import pageObjects.OnBoardingComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 21/01/16.
  */
trait OnBoardingComponentImpl {
  val onBoardingComponent: OnBoardingComponent = new DefaultOnBoardingComponentImpl

  class DefaultOnBoardingComponentImpl extends BaseComponent with OnBoardingComponent with OnBoardingComponentSelectors {
    def closeOnBoarding: Unit = {
      click on ON_BOARDING_CLOSE_FIRST_STEP_BUTTON
      click on ON_BOARDING_SKIP_BUTTON
    }

    def isOpen: Boolean = {
      exists(ON_BOARDING_WELCOME) || exists (ON_BOARDING_STEPS)
    }
  }
}
