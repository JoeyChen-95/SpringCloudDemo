package net.biancheng.c.exception;

public class ErrorCode {
    //Reservation's Start time is latter than the end time
    public static final int INVALID_RESERVATION_TIMESLOT = 140000;
    //Reservation's timeslot conflicts with an existing reservation
    public static final int CONFLICT_RESERVATION_TIMESLOT = 140001;

    //Reservation's timeslot is too long
    public static final int RESERVATION_TIME_TOO_LONG = 140002;
}
