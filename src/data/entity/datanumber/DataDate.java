package data.entity.datanumber;

import java.time.LocalDate;
import java.time.Period;

/**
 * Wrapper class for LocalDate
 * @author Benjamin Held (03-16-2016)
 * @version 0.1.0
 * @since 05-25-2016
 */
public class DataDate extends DataNumber<LocalDate> {
    public DataDate(LocalDate attribute) {
        super(attribute);
    }

    public LocalDate increment() {
        attribute = attribute.plus(Period.ofYears(1));
        return attribute;
    }
    public LocalDate decrement() {
        attribute = attribute.minus(Period.ofYears(1));
        return attribute;
    }

    public double getDelta(LocalDate value) {
        int delta_year = attribute.minus(Period.ofYears(value.getYear())).getYear();
        int delta_day = attribute.minus(Period.ofDays(value.getDayOfYear())).getDayOfYear();
        return (delta_year + delta_day / 365.25);
    }

    public DataDate clone() {
        return new DataDate(attribute);
    }
}
