package sample.Vistas;

import javafx.collections.ObservableList;
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
import sample.Modelos.platillosDAO;
import sample.Modelos.mainsRes;

import java.util.ArrayList;

import static javafx.application.Application.launch;

public class Restaurante extends Stage implements EventHandler {

    private Scene escena;
    private TabPane tabPane;
    private Tab tab[];
    private HBox hBox[];
    private ScrollPane scrollPane;
    private VBox vBox[];
    private VBox vBoxPrincipal;
    private ArrayList menu;

    private ImageView imageView;
    private Label lblName, lblPrice;
    private Button btnAdd, btnNext;
    ArrayList arti;
    platillosDAO ObtenerPlatillos;
    ObservableList<platillosDAO> platillos;
    Integer n;
    // launch the application
    public Restaurante(ArrayList menu, ArrayList articulos, Integer numMesa)
    {
        ObtenerPlatillos = new platillosDAO();
        platillos=ObtenerPlatillos.SELECCIONAR();
        this.n=numMesa;
        this.arti=articulos;
        this.menu=menu;
        crearGUI();
        escena = new Scene(vBoxPrincipal, 1000,700);
        setTitle("Select your mains");
        escena.getStylesheets().add(getClass().getResource("../CSS/interfazRes.css").toExternalForm());
        setScene(escena);
        show();
    }
    public Restaurante(ArrayList menu){
        n=-1;
        this.menu = menu;
        arti= new ArrayList();
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

        tab = new Tab[menu.size()];
        btnNext = new Button("Next");
        btnAdd = new Button("Select yours mains");
    }

    private void anadirComponentes() {
        cartasRestaurante obj1= new cartasRestaurante("Holaa ",500,100,"../Vistas/hola.png",arti,n);
        cartasRestaurante obj2= new cartasRestaurante("Adios",500,100,"../Vistas/hola.png",arti,n);
        cartasRestaurante obj3= new cartasRestaurante("Holaa",500,100,"../Vistas/hola.png",arti,n);

        hBox = new HBox[menu.size()];
        for(int i=0;i<menu.size();i++){
            hBox[i]= new HBox();
            hBox[i].setId(menu.get(i).toString());
            hBox[i].setSpacing(20);
            hBox[i].setPrefSize(400,400);
            hBox[i].setId("hboxCartas");
            hBox[i].setPadding(new Insets(30,10,30,50));


        }
        for(int i=0;i<platillos.size();i++)
        {
            for(int k=0;k<hBox.length;k++){
                if(platillos.get(i).getNom_menu()==hBox[k].getId()){
                    cartasRestaurante obj4= new cartasRestaurante(platillos.get(i).getDescripcion(),platillos.get(i).getPrecio(),
                            100,"../Vistas/hola.png",arti,n);
                    hBox[k].getChildren().add(obj4.principal);
                }
            }
        }

        for (int i=0;i<menu.size();i++){
            tab[i] = new Tab(menu.get(i).toString());
            tab[i].setClosable(false);
            tab[i].setContent(hBox[i]);
            tabPane.getTabs().addAll(tab[i]);
        }

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
