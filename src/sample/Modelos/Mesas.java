package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import sample.Eventos.EventosCalculadora;
import sample.Eventos.EventosMesas;

import java.util.ArrayList;

public class Mesas extends Stage implements EventHandler {
    public VBox principal;
    HBox[] arHBox;
    public Button[]ButtonMesas;
    Button VerCuenta,CerrarCuenta;
    //crear aqui cuentaaa aray

    int y;
    float a;
    public Mesas(int n){
        a=(float) n/8;
        y=(int)Math.ceil(a);
        ButtonMesas= new Button[n];
        arHBox= new HBox[y];
        principal= new VBox();
        principal.setId("Mesas");
        principal.setAlignment(Pos.CENTER);
        principal.setPadding(new Insets(30,10,10,90));
        int var=0;
    for(int i=0; i<y; i++ ){
        arHBox[i]= new HBox();
        arHBox[i].setSpacing(10);
        arHBox[i].setPadding(new Insets(5));
        for(int k=0;k<8;k++){
            ButtonMesas[var]= new Button("Mesa numero "+ (var+1));
            ButtonMesas[var].addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosMesas(var+1,ButtonMesas[var]));
            ButtonMesas[var].setPrefSize(200,200);
            ButtonMesas[var].setStyle("");
            arHBox[i].getChildren().add(ButtonMesas[var]);
            var++;
            if(var==ButtonMesas.length)
                k=9;
        }

        }
        for(int i=0;i<arHBox.length;i++){
            principal.getChildren().add(arHBox[i]);
        }

    }

    @Override
    public void handle(Event event) {

    }


}
