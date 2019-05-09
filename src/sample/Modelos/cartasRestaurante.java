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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import sample.Eventos.EventosCartas;

import java.io.File;
import java.util.ArrayList;

public class cartasRestaurante extends Stage implements EventHandler {
    public VBox principal;
    ArrayList arti;
    String nombre;
    Double precio;
    Integer n;
    public cartasRestaurante(String descripcion, double precio, double descuento, String url, ArrayList articulos,Integer numMesa){
        this.n=numMesa;
        this.nombre=descripcion;
        this.precio=precio;
        this.arti= articulos;
        principal= new VBox();
        principal.setId("Cartas");

        principal.setAlignment(Pos.CENTER);
        Label label1 = new Label(descripcion);
        Label label2= new Label(Double.toString(precio));
        Label labe3= new Label(Double.toString(descuento));
        label1.setFont(Font.font("Cambria",44));



        String a=url;
        ImageView iv1 = new ImageView(new Image(getClass().getResourceAsStream(a)));
        iv1.setFitHeight(130);
        iv1.setPreserveRatio(true);
        iv1.setSmooth(true);
        iv1.setCache(true);

        Button btn1=new Button("Add");
        btn1.addEventHandler(MouseEvent.MOUSE_CLICKED,new EventosCartas(arti,nombre,precio,n));
        DropShadow ds = new DropShadow();
        ds.setOffsetY(0.0);
        ds.setOffsetX(0.0);
        ds.setColor(Color.LIGHTGRAY);

        principal.setEffect(ds);
        principal.setSpacing(10);
        principal.setPadding(new Insets(15, 15, 15, 15));
        principal.getChildren().addAll(iv1,label1,label2,labe3, btn1);

    }


    @Override
    public void handle(Event event) {

    }
    void hola(){}
}