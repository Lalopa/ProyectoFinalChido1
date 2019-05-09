package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Eventos.EventosMesas;

import java.util.ArrayList;

public class interfazOrdenar extends Stage implements EventHandler {
    private Scene escena;
    private TabPane tabPane;
    private Tab tab[];
    private HBox hBox;
    private ScrollPane scrollPane;
    private VBox vBox[];
    private VBox vBoxPrincipal;
    private ImageView imageView;
    private Label lblName, lblPrice;
    private Button crearCuenta, verCuenta,cerrarCuenta;
    private Cuenta cuenta1;
    String Mesa;
    ArrayList arti;
    Integer n;
    public  interfazOrdenar(String nombreMesa,Integer numeroMesa){
        arti= new ArrayList();
        this.Mesa= nombreMesa;
        this.n=numeroMesa;
        iniciarComponentes();
        anadirComponentes();
        escena = new Scene(vBoxPrincipal, 1000,700);
        setTitle("Select your mains");
        escena.getStylesheets().add(getClass().getResource("../CSS/interfazCuenta.css").toExternalForm());
        setScene(escena);
        show();
    }

    void iniciarComponentes(){
        cuenta1 = new Cuenta(Mesa,arti,n);
     vBoxPrincipal= new VBox();
     crearCuenta= new Button("Crear Cuenta");
     verCuenta= new Button("Ver Cuenta");
     cerrarCuenta = new Button("Cerar Cuenta");
     vBoxPrincipal.setSpacing(20);
     vBoxPrincipal.setAlignment(Pos.CENTER);
     crearCuenta.addEventHandler(MouseEvent.MOUSE_CLICKED,cuenta1);

    }

    void anadirComponentes(){
        vBoxPrincipal.getChildren().addAll(crearCuenta, verCuenta,cerrarCuenta);
    }


    @Override
    public void handle(Event event) {

    }
}
