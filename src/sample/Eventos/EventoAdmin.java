package sample.Eventos;

import javafx.event.Event;
import javafx.event.EventHandler;
import sample.Modelos.adminCuentas;
public class EventoAdmin implements EventHandler{
    int tipo;
    public EventoAdmin(int tipo){
    this.tipo=tipo;

    }

    void seleccionar(){
        switch (tipo){
            case 1:
                new adminCuentas();
                break;
        }
    }

    @Override
    public void handle(Event event) {
        seleccionar();
    }
}
