package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.Vistas.Restaurante;

import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Cuenta implements EventHandler{
    String Mesa;
    Integer n;
    ArrayList arti;

  public Cuenta(String nombreMesa, ArrayList articulo,Integer numMesa){
        this.Mesa=nombreMesa;
        this.arti=articulo;
        this.n=numMesa;
}


    @Override
    public void handle(Event event) {
        Date date = new Date();
        mainsRes menu [] = new mainsRes[4];
        menu[0] = new mainsRes("PIZZA");
        menu[1] = new mainsRes("MODERN");
        menu[2] = new mainsRes("MEAT");
        menu[3] = new mainsRes("KIDS");
        Restaurante r= new Restaurante(menu, arti,n);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(date));

    }
}
