package sample.Vistas;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Modelos.cartasRestaurante;
import sample.Modelos.cartasRestaurante;
import sample.Modelos.mainsRes;

import java.util.ArrayList;

import static javafx.application.Application.launch;

public class Restaurante extends Stage implements EventHandler {

    private Scene escena;
    private TabPane tabPane;
    private Tab tab[];
    private HBox hBox;
    private ScrollPane scrollPane;
    private VBox vBox[];
    private VBox vBoxPrincipal;
    mainsRes menu[];
    private ImageView imageView;
    private Label lblName, lblPrice;
    private Button btnAdd, btnNext;
    ArrayList arti;
    Integer n;
    // launch the application
    public Restaurante(mainsRes menu[], ArrayList articulos, Integer numMesa)

    {   this.n=numMesa;
        this.arti=articulos;
        this.menu=menu;
        crearGUI();
        escena = new Scene(vBoxPrincipal, 1000,700);
        setTitle("Select your mains");
        escena.getStylesheets().add(getClass().getResource("../CSS/interfazRes.css").toExternalForm());
        setScene(escena);
        show();
    }

    private void crearGUI() {
        iniciarComponentes();
        anadirComponentes();
    }

    private void iniciarComponentes() {
        vBoxPrincipal = new VBox();
        vBoxPrincipal.setId("vBoxPrincipal");
        System.out.println(mainsRes.getCantidad());
        tabPane = new TabPane();
        tabPane.minHeight(500);
        tabPane.minWidth(500);
        tab = new Tab[mainsRes.getCantidad()];
        btnNext = new Button("Next");
        btnAdd = new Button("Select yours mains");
    }

    private void anadirComponentes() {
        cartasRestaurante obj1= new cartasRestaurante("Holaa ",500,100,"../Vistas/hola.png",arti,n);
        cartasRestaurante obj2= new cartasRestaurante("Adios",500,100,"../Vistas/hola.png",arti,n);
        cartasRestaurante obj3= new cartasRestaurante("Holaa",500,100,"../Vistas/hola.png",arti,n);
        for (int i=0;i<4;i++){
            tab[i] = new Tab(menu[i].getNombre());
            tab[i].setClosable(false);
            tab[i].setContent(obj3.principal);
        }
        hBox = new HBox();
        hBox.setSpacing(20);
        hBox.setPrefSize(400,400);
        hBox.setId("hboxCartas");
        hBox.setPadding(new Insets(30,10,30,50));
        hBox.getChildren().addAll(obj1.principal,obj2.principal);
        tab[0].setContent(hBox);
        tabPane.getTabs().addAll(tab[0]);
        tabPane.setPadding(new Insets(0,0,0,0));
        btnNext.setId("btnNext");
        btnNext.setPadding(new Insets(8,60,8,60));
        btnAdd.setId("btnAdd");
        btnAdd.setPadding(new Insets(10, 900,10,900));
        vBoxPrincipal.getChildren().addAll(btnAdd,tabPane, btnNext);
        vBoxPrincipal.setMargin(btnNext, new Insets(10,10,10,10));
        vBoxPrincipal.setAlignment(Pos.TOP_CENTER);

    }

    @Override
    public void handle(Event event) {
        System.out.println("Hola");
    }
}




