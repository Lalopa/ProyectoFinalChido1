package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class adminCuentas extends Stage  implements EventHandler {
    private Scene escena;
    private VBox vBoxPrincipal;

       public adminCuentas(){

            iniciarComponentes();
            escena = new Scene(vBoxPrincipal, 1000,700);
            setTitle("Cuentas");
            escena.getStylesheets().add(getClass().getResource("../CSS/interfazCuenta.css").toExternalForm());
            setScene(escena);
            show();
        }
    public void iniciarComponentes(){

        vBoxPrincipal= new VBox();
    }
    @Override
    public void handle(Event event) {
        System.out.println("Adiosss");
    }
}
