package sample.Modelos;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class adminCuentas extends Stage  implements EventHandler {
    private Scene escena;
    Button cerrarCuenta;
    private VBox vBoxPrincipal;

       public adminCuentas(){

            iniciarComponentes();
            vBoxPrincipal.getChildren().add(cerrarCuenta);
            vBoxPrincipal.setAlignment(Pos.CENTER);
            vBoxPrincipal.setId("adminCuentas");
            //cerrarCuenta.setPadding(new Insets(20,20,20,20));
            escena = new Scene(vBoxPrincipal, 1000,700);
            setTitle(" Cuentas ");
            escena.getStylesheets().add(getClass().getResource("../CSS/admin.css").toExternalForm());
            setScene(escena);
            show();
        }
    public void iniciarComponentes(){

        vBoxPrincipal= new VBox();
        cerrarCuenta= new Button("Cancelar Cuentas");


    }
    @Override
    public void handle(Event event) {
        System.out.println("Adiosss");
    }
}
