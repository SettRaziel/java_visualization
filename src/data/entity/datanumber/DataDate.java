package data.entity.datanumber;

import java.time.LocalDate;
import java.time.Period;

/**
 * Wrapper class for LocalDate
 * @author Benjamin Held (03-16-2016)
 * @version 0.2.3
 * @since 07-19-2016
 */
public class DataDate extends DataNumber<LocalDate> {
    public DataDate(LocalDate attribute) {
        super(attribute);
    }

    public DataDate(String attribute) {
        super(LocalDate.parse(attribute));
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

    public static DataDate getMax() {
        return new DataDate(LocalDate.MAX);
    }

    public static DataDate getMin() {
        return new DataDate(LocalDate.MIN);
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
    public String toString() {
        return attribute.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof DataDate) {
            DataDate date = (DataDate) o;
            return (attribute.getYear() == date.attribute.getYear() &&
                    attribute.getMonthValue() == date.attribute.getMonthValue() &&
                    attribute.getDayOfMonth() == date.attribute.getDayOfMonth());
        }
        return false;
    }
}
