package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Eventos.EventoAdmin;
import sample.Eventos.EventosCartas;


public class Admin extends Stage implements EventHandler {

    public VBox principal;
    public HBox menu;
    Button btnPedidos,btnEstadisticas,btnMenu;

    public Admin(){
    iniciarComponentes();
    menu.getChildren().addAll(btnPedidos,btnEstadisticas,btnMenu);
    menu.setAlignment(Pos.CENTER);
    menu.setSpacing(20);
    menu.setPadding(new Insets(200,10,10,10));
    principal.getChildren().addAll(menu);
    btnPedidos.setPrefSize(300,200);
    btnMenu.setPrefSize(300,200);
    btnEstadisticas.setPrefSize(400,200);
    }

    void iniciarComponentes(){
        principal= new VBox();
        menu= new HBox();
        btnEstadisticas= new Button("Estadistica");
        btnMenu= new Button("Editar Menu");
        btnPedidos= new Button("Pedidos");
        btnPedidos.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventoAdmin(1));
    }


    @Override
    public void handle(Event event) {
    }
}
