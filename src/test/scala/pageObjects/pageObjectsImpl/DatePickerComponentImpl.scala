package pageObjects.pageObjectsImpl

import objectLocatorRepository.DatePickerComponentSelectors
import pageObjects.DatePickerComponent
import pageObjects.pageObjectsImpl.pageObjectUtils.BaseComponent

/**
  * Created by dev on 30/11/15.
  */
trait DatePickerComponentImpl {
  val datepickerComponent: DatePickerComponent = new DefaultDatePickerComponentImpl

  class DefaultDatePickerComponentImpl extends BaseComponent with DatePickerComponent with DatePickerComponentSelectors {
    def pickToday = click on DATEPICKER_TODAY_BUTTON
    def pickTomorrow = click on DATEPICKER_TOMORROW_BUTTON
    def pickInAWeek = click on DATEPICKER_IN_A_WEEK_BUTTON
    def pickInAMonth = click on DATEPICKER_IN_A_MONTH_BUTTON
    def pickInThreeMonths = click on DATEPICKER_IN_3_MONTHS_BUTTON
    def pickInAYear = click on DATEPICKER_IN_A_YEAR_BUTTON
  }
}
