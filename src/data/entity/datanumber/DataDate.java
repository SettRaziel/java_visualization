package data.entity.datanumber;

import java.time.LocalDate;
import java.time.Period;

/**
 * Wrapper class for LocalDate
 * @author Benjamin Held (03-16-2016)
 * @version 0.2.0
 * @since 06-2-2016
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
        int deltaYear = attribute.minus(Period.ofYears(value.getYear())).getYear();
        int deltaDay = attribute.minus(Period.ofDays(value.getDayOfYear())).getDayOfYear();
        return (deltaYear + deltaDay / 365.25);
    }

    public DataDate clone() {
        return new DataDate(attribute);
    }

    @Override
    public boolean isGreater(DataNumber<LocalDate> value) {
        return this.attribute.toEpochDay() > value.attribute.toEpochDay();
    }

    @Override
    public boolean isLesser(DataNumber<LocalDate> value) {
        return this.attribute.toEpochDay() < value.attribute.toEpochDay();
    }

    @Override
    public boolean isEqual(DataNumber<LocalDate> value) {
        return this.attribute.toEpochDay() == value.attribute.toEpochDay();
    }
}
