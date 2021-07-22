package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    
    private Integer roomNamber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
    
public Reservation(){}

public Reservation(Integer roomNamber, Date checkIn, Date checkOut)
{
    this.roomNamber = roomNamber;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
   

}  

    public Integer getRoomNamber() {
        return roomNamber;
    }

    public void setRoomNamber(Integer roomNamber) {
        this.roomNamber = roomNamber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

  
    public long duration ()
    {
        long difer = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(difer, TimeUnit.MILLISECONDS);
    }
    
    
    public void updateDates(Date checkIn, Date checkOut)
    {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString ()
    {
        return " Quarto " + roomNamber + ", entrada : " + dtf.format(checkIn)
                + ", saída : " + dtf.format(checkOut)
                + " , " + duration() + " noites";
    }
    
}
