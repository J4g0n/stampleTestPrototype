package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{ObjectMapRepository, Selector}


/**
  * Created by dev on 18/12/15.
  */
trait OnBoardingComponentSelectors extends ObjectMapRepository {
  val ON_BOARDING_WELCOME: Selector = "onBoarding.onBoardingWelcome"
  val ON_BOARDING_STEPS: Selector = "onBoarding.onBoardingSteps"
  val ON_BOARDING_CLOSE_FIRST_STEP_BUTTON: Selector = "onBoarding.closeOnBoardingWelcomeButton"
  val ON_BOARDING_SKIP_BUTTON: Selector = "onBoarding.skipGuideButton"
}
