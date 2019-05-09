package sample.Vistas;

import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Eventos.EventoTeclado;
import sample.Modelos.Admin;
import sample.Modelos.Mesas;

public class RestauranteDashboard extends Stage {
    private Scene escena;
    private VBox vbox,vMesas;
    private ToolBar tlbMenu;
    private TextArea txtTexto, txtEscritura;
    private TabPane tabPane;
    // aqui va el teclado

    public RestauranteDashboard() {

        CrearGUI();
        escena = new Scene(vbox,800,900);
        escena.getStylesheets().add(getClass().getResource("../CSS/Restaurante.css").toExternalForm());
        setTitle("Restaurante");
        setScene(escena);
        show();
    }

    private void CrearGUI() {
        vbox  = new VBox();
        vMesas = new VBox();
        tabPane = new TabPane();
        Mesas m1= new Mesas(13);
        Admin adm= new Admin();
        tabPane.minHeight(500);
        tabPane.minWidth(500);
        tabPane.setPadding(new Insets(0,0,0,0));
        //tabPane.setSide(Side.LEFT);
        Tab tab= new Tab("Mesas");
        Tab tab1= new Tab("Admin");

        // add label to the tab
        tab.setClosable(false);
        tab.setContent(m1.principal);
        tab1.setClosable(false);
        tab1.setContent(adm.principal);

        // add tab
        tabPane.getTabs().addAll(tab,tab1);
        vbox.getChildren().addAll(tabPane);
    }

    private void mesas(int n){


    }

}
