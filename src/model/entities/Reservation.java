package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import model.execptions.DomainException;

public class Reservation {
    
    private Integer roomNamber;
    private Date checkIn;
    private Date checkOut;
    
    private static SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy");
    
public Reservation(){}

public Reservation(Integer roomNamber, Date checkIn, Date checkOut) throws DomainException
{
    if (!checkIn.after(checkOut)) {
        
               throw new DomainException ("ERRO!!! A data de entrada deve ser anterior a de saída");
        
        }
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
    
    
    public void updateDates(Date entra, Date saida) throws DomainException
    {
        Date agora = new Date();
            
        if (entra.before(agora) || saida.before(agora))
            {
                throw new DomainException ("ERRO!!! A data não pode ser anterior ao presente");
            
            }
        if (!saida.after(entra)) {
        
               throw new DomainException ("ERRO!!! A data de entrada deve ser anterior a de saída");
        
        }
        
        this.checkIn = entra;
        this.checkOut = saida;
        
        //return null;
    }

    
    
    @Override
    public String toString ()
    {
        return " Quarto " + roomNamber + ", entrada : " + dtf.format(checkIn)
                + ", saída : " + dtf.format(checkOut)
                + " , " + duration() + " noites";
    }
    
}
