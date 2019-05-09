package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.Modelos.Cuenta;
import sample.Modelos.articulo;
import java.util.ArrayList;

public class EventosCartas implements EventHandler {
    ArrayList<articulo> arti;
    articulo a1;
    String nombre;
    Double precio;
    Integer n;
    public EventosCartas(ArrayList articulos, String nombre, Double precio, Integer numMesa){
        this.n=numMesa;
        this.arti=articulos;
        this.nombre=nombre;
        this.precio= precio;

    }


    @Override
    public void handle(Event event) {
        System.out.println("Mesa numero: "+ n);
        a1= new articulo(nombre,precio);
        arti.add(a1);
        System.out.println(arti.size());
        for(int i=0;i<arti.size();i++)
        {
            System.out.println(arti.get(i).getNombre());
        }
    }
}
