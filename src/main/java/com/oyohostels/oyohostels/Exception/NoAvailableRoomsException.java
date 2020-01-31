package com.oyohostels.oyohostels.Exception;

public class NoAvailableRoomsException extends Exception {
    public NoAvailableRoomsException() {
        super("No available rooms!");
    }
}