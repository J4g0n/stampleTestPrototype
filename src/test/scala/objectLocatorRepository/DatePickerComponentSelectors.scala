package objectLocatorRepository

import objectLocatorRepository.objectMapUtils.{Selector, ObjectMapRepository}

/**
  * Created by dev on 26/11/15.
  */
trait DatePickerComponentSelectors extends ObjectMapRepository {
  val DATEPICKER_CLOSE_BUTTON: Selector = "datePicker.closeButton"
  val DATEPICKER_IN_A_YEAR_BUTTON: Selector = "datePicker.inAYear"
  val DATEPICKER_IN_3_MONTHS_BUTTON: Selector = "datePicker.in3Months"
  val DATEPICKER_IN_A_MONTH_BUTTON: Selector = "datePicker.inAMonth"
  val DATEPICKER_IN_A_WEEK_BUTTON: Selector = "datePicker.inAWeek"
  val DATEPICKER_TOMORROW_BUTTON: Selector = "datePicker.tomorrow"
  val DATEPICKER_TODAY_BUTTON: Selector = "datePicker.today"
}
