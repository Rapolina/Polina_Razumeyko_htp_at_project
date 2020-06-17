package runner;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.junit.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({BookingParisTest.class, BookingMoscowTest.class, BookingOsloTest.class, BookingNewAccoutTest.class, BookingCheckHeadTest.class, BookingFavouritesTest.class})
public class BookingRunner {
}
