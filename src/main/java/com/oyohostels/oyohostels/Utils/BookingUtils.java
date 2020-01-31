package com.oyohostels.oyohostels.Utils;

import com.oyohostels.oyohostels.domain.Booking;

import java.util.Date;
import java.util.List;

public class BookingUtils {
    public static boolean isBookingAvilable(List<Booking> bookingList, Date startDate, Date endDate){
        boolean isAvailable = false;

        for(Booking book:bookingList){
            isAvailable = !areDatesOverlapping(book.getBeginDate(), book.getEndDate(), startDate, endDate);
        }
        return isAvailable;
    }

    private  static boolean areDatesOverlapping(Date beginDate, Date endDate, Date startDate, Date enDate2){
//        if(beginDate==enDate2)return true && endDate.after(startDate);
       return beginDate.before(enDate2) && endDate.after(startDate);
    }
}
