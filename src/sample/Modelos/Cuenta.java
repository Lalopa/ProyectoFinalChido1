package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.Vistas.Restaurante;

import java.sql.Date;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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
        ArrayList menu = new ArrayList();

        Restaurante r= new Restaurante(menu, arti,n);
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Fecha: "+dateFormat.format(date));

    }
}
