package com.codenfast.developersuniverse.utils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final SimpleDateFormat iso8601Format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    public static final SimpleDateFormat iso8601FormatFromUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    private DateUtil() {
        // No one needs any reference
    }

    /**
     * Converts LocalDate to Date
     *
     * @param localDate will convert
     * @return Converted object
     */
    public static Date convert(final LocalDate localDate) {
        return convert(localDate, ZoneId.systemDefault());
    }

    /**
     * Converts LocalDate to Date with Zone Id
     *
     * @param localDate Time will convert
     * @return Converted object
     */
    public static Date convert(final LocalDate localDate, final ZoneId zoneId) {
        return Date.from(localDate.atStartOfDay(zoneId).toInstant());
    }

    /**
     * Converts Date to LocalDate
     *
     * @param date Time will convert
     * @return Converted object
     */
    public static LocalDateTime convert(final Date date) {
        return convert(date, ZoneId.systemDefault());
    }

    /**
     * Converts Fasttime to LocalDate
     *
     * @param milliseconds Time will convert
     * @return Converted object
     */
    public static LocalDateTime convert(final long milliseconds) {
        return Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * Converts Date to LocalDate with Zone Id
     *
     * @param date Time will convert
     * @return Converted object
     */
    public static LocalDateTime convert(final Date date, final ZoneId zoneId) {
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

    /**
     * Converts Date to LocalDate (only date not more)
     *
     * @param date Time will convert
     * @return Converted object
     */
    public static LocalDate convertOnlyDate(final Date date) {
        return convertOnlyDate(date, ZoneId.systemDefault());
    }

    /**
     * Converts Date to LocalDate with Zone Id (only date not more)
     *
     * @param date Time will convert
     * @return Converted object
     */
    public static LocalDate convertOnlyDate(final Date date, final ZoneId zoneId) {
        return LocalDate.ofInstant(date.toInstant(), zoneId);
    }

    /**
     * Converts Date to LocalTime with time info
     *
     * @param date Time will convert
     * @return Converted object
     */
    public static LocalTime convertOnlyTime(final Date date) {
        return convertOnlyTime(date, ZoneId.systemDefault());
    }

    /**
     * Converts Date to LocalTime only time info
     *
     * @param date Time will convert
     * @return Converted object
     */
    public static LocalTime convertOnlyTime(final Date date, final ZoneId zoneId) {
        return LocalDateTime.ofInstant(date.toInstant(), zoneId).toLocalTime();
    }

    /**
     * Converts only time into to Date
     *
     * @param localTime Time will convert
     * @return Converted object
     */
    public static Date convertOnlyTime(final LocalTime localTime) {
        return convertOnlyTime(localTime, ZoneId.systemDefault());
    }

    /**
     * Converts only time into to Date with Zone Id
     *
     * @param localTime Time will convert
     * @return Converted object
     */
    public static Date convertOnlyTime(final LocalTime localTime, final ZoneId zoneId) {
        Instant instant = localTime.atDate(LocalDate.of(1970, 0, 0)).atZone(zoneId).toInstant();
        return Date.from(instant);
    }

    /**
     * Returns the starting time of the given day
     *
     * @param date Start of day time
     * @return Start time of given date
     */
    public static Date startOfDay(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    /**
     * Returns the end time of the given day
     *
     * @param date End of day time
     * @return End time of given date
     */
    public static Date endOfDay(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

    /**
     * Returns first day of month of given time
     *
     * @param date Time to be received on the first day of the relevant month
     * @return First day of given time
     */
    public static Date firstDayOfMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * Returns last day of month of given time
     *
     * @param date Time to be received on the first day of the relevant month
     * @return First day of given time
     */
    public static Date lastDayOfMonth(final Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    /**
     * Returns first day and first instant of month of given time
     *
     * @param date Time to be received on the first day of the relevant month
     * @return First day of given time
     */
    public static Date firstTimeOfMonth(final Date date) {
        Date result = firstDayOfMonth(date);
        return startOfDay(result);
    }

    /**
     * Returns last day and last instant of month of given time
     *
     * @param date Time to be received on the first day of the relevant month
     * @return First day of given time
     */
    public static Date lastTimeOfMonth(final Date date) {
        Date result = lastDayOfMonth(date);
        return endOfDay(result);
    }

    /**
     * Checks given date is between other two dates
     *
     * @param date      The checking date
     * @param startDate First date
     * @param endDate   End date
     * @return if date is between start and end date then true, else false
     */
    public static boolean isTimeBetweenDates(final Date date, final Date startDate, final Date endDate) {
        return (date.compareTo(startDate) == 0 || date.after(startDate)) && (date.compareTo(endDate) == 0 || date.before(endDate));
    }

    /**
     * Checks given date is between other two dates
     *
     * @param date          The checking date
     * @param startDateTime First date
     * @param endDateTime   End date
     * @return if date is between start and end date then true, else false
     */
    public static boolean isTimeBetweenDates(final LocalDateTime date, final LocalDateTime startDateTime, final LocalDateTime endDateTime) {
        return (date.isEqual(startDateTime) || date.isAfter(startDateTime) && (date.isEqual(endDateTime) || date.isBefore(endDateTime)));
    }

    /**
     * Checks given time is between other two times
     *
     * @param localDateTime The checking date
     * @param startTime     First time
     * @param endTime       End time
     * @return if date is between start and end time then true, else false
     */
    public static boolean isTimeBetweenTimes(final LocalDateTime localDateTime, final LocalTime startTime, final LocalTime endTime) {
        LocalTime localTime = localDateTime.toLocalTime();
        return isTimeBetweenTimes(localTime, startTime, endTime);
    }

    /**
     * Checks given time is between other two times
     *
     * @param localDateTime The checking date
     * @param startTime     First time
     * @param endTime       End time
     * @return if date is between start and end time then true, else false
     */
    public static boolean isTimeBetweenTimes(final LocalTime localDateTime, final LocalTime startTime, final LocalTime endTime) {
        return (localDateTime.compareTo(startTime) == 0 || localDateTime.isBefore(startTime)) && (localDateTime.compareTo(endTime) == 0 || localDateTime.isAfter(endTime));
    }

    /**
     * Given time checks its intersection with scope in two time slots
     *
     * @param firstTimeStart  First time ranges first date
     * @param firstTimeEnd    First time ranges end date
     * @param secondTimeStart Second time ranges first date
     * @param secondTimeEnd   Second time ranges end date
     * @return If given time checks its intersection with scope in two time slots
     */
    public static boolean isTimeRangeCollapsedToAnother(final Date firstTimeStart, final Date firstTimeEnd, final Date secondTimeStart, final Date secondTimeEnd) {
        boolean inMatchTimeRange = isTimeBetweenDates(firstTimeStart, secondTimeStart, secondTimeEnd) && isTimeBetweenDates(firstTimeEnd, secondTimeStart, secondTimeEnd);
        boolean inPartialTimeRange = firstTimeStart.before(secondTimeEnd) && firstTimeEnd.after(secondTimeStart);
        return inMatchTimeRange || inPartialTimeRange;
    }
}
