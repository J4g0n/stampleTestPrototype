package pageObjects

/**
  * Created by dev on 21/01/16.
  */
trait OnBoardingComponent {
  // TODO On boarding is probably going to change in the future,
  // TODO so i'm just using this page object to close it in order to perform other tests
  def closeOnBoarding: Unit

  def isOpen: Boolean
}
