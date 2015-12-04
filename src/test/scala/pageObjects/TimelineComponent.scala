package pageObjects


/**
  * Created by dev on 30/11/15.
  */
trait TimelineComponent {
  def openNthSpace(n: Int): Unit

  def openNthStample(n: Int): Unit

  def openNthLibrary(n: Int): Unit
}
