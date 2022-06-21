package net.biancheng.c.exception;

public class ItemReservationException extends BaseException{
    public ItemReservationException(int errorCode, String message) {
        super(errorCode, message);
    }
}
