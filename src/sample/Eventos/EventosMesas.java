package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import sample.Modelos.mainsRes;
import sample.Vistas.Restaurante;
import sample.Modelos.interfazOrdenar;

import java.util.ArrayList;

public class EventosMesas implements EventHandler {
int mesa;
boolean mesaActiva= false;
Button mesaButton;
static interfazOrdenar io1;
    public EventosMesas(int n , Button a){
        this.mesaButton=a;

    this.mesa=n;
    }


    @Override
    public void handle(Event event) {
        bmesaActiva();
        mesaActiva=true;

    }

    void bmesaActiva() {
        mainsRes menu [] = new mainsRes[4];
        menu[0] = new mainsRes("PIZZA");
        menu[1] = new mainsRes("MODERN");
        menu[2] = new mainsRes("MEAT");
        menu[3] = new mainsRes("KIDS");
        mesaButton.setStyle("-fx-background-color: white; -fx-text-fill: #747474");
        io1=new interfazOrdenar(mesaButton.getText(),mesa);

    }
}
