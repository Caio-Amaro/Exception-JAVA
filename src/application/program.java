package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;


public class program {

    
    public static void main(String[] args) throws ParseException {
    
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat dts = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.print("Número do Quarto :");
        int numero = sc.nextInt();
        
        System.out.print(" Data de Entrada - data dd/mm/aaaa : ");
        Date entra = dts.parse(sc.next());
            
        System.out.print(" Data de Saída - data dd/mm/aaaa : ");
        Date saida = dts.parse(sc.next());
        
        if (!saida.after(entra))
        {
            System.out.println("ERRO!!! A data de entrada deve ser anterior a de saída");
        }
        else 
        {
            Reservation reserva = new Reservation(numero, entra, saida);
            System.out.println("Reserva : " + reserva);
            
            System.out.println();
            
            System.out.println("Entre com dados para atulizar a reserva : \n");
                          
            System.out.print(" Data de Entrada - data dd/mm/aaaa : ");
            entra = dts.parse(sc.next());
            
            System.out.print(" Data de Saída - data dd/mm/aaaa : ");
            saida = dts.parse(sc.next());
            
            Date agora = new Date();
            
            if (entra.before(agora) || saida.before(agora))
            {
                System.out.println("ERRO!!! A data não pode ser anterior ao presente");
            
            }
            
            else if (!saida.after(entra)) {
        
            System.out.println("ERRO!!! A data de entrada deve ser anterior a de saída");
        
            }
            else {
            reserva.updateDates(entra, saida);
            System.out.println("Reserva : " + reserva);
            }
        }
    }
    
}
