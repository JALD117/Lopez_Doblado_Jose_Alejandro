package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Base de Datos 'Alumnos'");

        DBManager accesoBD = new DBManager();

        OperacionesAlumnos opAlumno = new OperacionesAlumnos(accesoBD.getConnection());

        //CRUD
        //Alumno regAlumno = opAlumno.getAlumno(1);
        //System.out.print("Alumno: "+ regAlumno);
        //opAlumno.deleteAlumno(3);
        //opAlumno.insertAlumno(3,"Carl", "Johnson", "",69);
        //opAlumno.updateAlumno(4,"Katalina","Traidora","",0);

        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icono.png")));

        //Creacion de la tabla y columnas
        //TableView<Alumno> tv = new TableView();
        HBox hbBotones = new HBox(); hbBotones.setSpacing(8);
        HBox hbId = new HBox(); hbId.setSpacing(10);
        HBox hbNom = new HBox(); hbNom.setSpacing(10);
        HBox hbApePat = new HBox(); hbApePat.setSpacing(10);
        HBox hbApeMat = new HBox(); hbApeMat.setSpacing(10);
        HBox hbCalif = new HBox(); hbCalif.setSpacing(10);
        HBox hbScene = new HBox();
        hbScene.setLayoutX(0.5);
        VBox vbLeft = new VBox(); vbLeft.setSpacing(10);
        VBox vbRight = new VBox();
        VBox vbLabelAndText = new VBox(); vbLabelAndText.setSpacing(10);

        TextField tfid = new TextField();
        TextField tfnombre = new TextField();
        TextField tfapePaterno = new TextField();
        TextField tfapeMaterno = new TextField();
        TextField tfcalificacion = new TextField();

        //Creando Mensaje de alerta
        Alert  alert = new Alert (Alert.AlertType.INFORMATION);
        alert.setTitle ("Diálogo de información");
        alert.setHeaderText (null);

        Button btnCreate = new Button();
        Button btnRead = new Button();
        Button btnUpdate = new Button();
        Button btnDelete = new Button();
        btnCreate.setText("Añadir");
        btnRead.setText("Buscar");
        btnUpdate.setText("Actualizar");
        btnDelete.setText("Borrar");

        Label lblid = new Label();
        lblid.setText("ID");
        Label lblnombre = new Label();
        lblnombre.setText("Nombre");
        Label lblapepaterno = new Label();
        lblapepaterno.setText("Apellido Paterno");
        Label lblapematerno = new Label();
        lblapematerno.setText("Apellido Materno");
        Label lblcalificacion= new Label();
        lblcalificacion.setText("Calificación");

        //Creando tabla
        TableView<Alumno> tv = new TableView();
        //Creando columnas
        TableColumn<Alumno, Integer> colId = new TableColumn<>("ID");
        TableColumn<Alumno, String> colNombre = new TableColumn<>("Nombre");
        TableColumn<Alumno, String> colApePaterno = new TableColumn<>("Apellido Paterno");
        TableColumn<Alumno, String> colApeMaterno = new TableColumn<>("Apellido Materno");
        TableColumn<Alumno, Float> colCalificacion = new TableColumn<>("Calificación");
        //Añadiendo coljumnas a la tabla
        tv.getColumns().addAll(colId, colNombre, colApePaterno, colApeMaterno, colCalificacion);

        //No recuerdo que hace aqui XD
        colId.setCellValueFactory(new PropertyValueFactory<>("idAlumno"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colApePaterno.setCellValueFactory(new PropertyValueFactory<>("apePaterno"));
        colApeMaterno.setCellValueFactory(new PropertyValueFactory<>("apeMaterno"));
        colCalificacion.setCellValueFactory(new PropertyValueFactory<>("calificacion"));

        //MOSTRANDO DATOS
        ObservableList<Alumno> datos = FXCollections.observableArrayList();
        opAlumno.getLista(datos);
        tv.getItems().addAll(datos);

        //Acomodando los elementos del lado izquierdo
        hbId.getChildren().addAll(lblid, tfid);
        hbNom.getChildren().addAll(lblnombre, tfnombre);
        hbApePat.getChildren().addAll(lblapepaterno, tfapePaterno);
        hbApeMat.getChildren().addAll(lblapematerno, tfapeMaterno);
        hbCalif.getChildren().addAll(lblcalificacion, tfcalificacion);

        vbLabelAndText.getChildren().addAll(hbId, hbNom, hbApePat, hbApeMat, hbCalif);
        vbLabelAndText.setSpacing(8);

        hbBotones.getChildren().addAll(btnRead, btnUpdate, btnCreate, btnDelete);

        vbRight.getChildren().addAll(tv);
        vbLeft.getChildren().addAll(vbLabelAndText, hbBotones);
        hbScene.setSpacing(10);
        hbScene.getChildren().addAll(vbLeft, vbRight);
        Scene scene = new Scene(hbScene, 680, 200);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

        //==================================BOTONES======================================
        btnDelete.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String idS = tfid.getText();
                System.out.println("idS = "+idS);
                if  (idS.equals("")){
                    tfid.clear();
                    alert.setContentText ("El campo ID no puede estar vacio");
                    alert.showAndWait ();
                }else{
                    //Convirtiendo valor del TextField a int
                    int id = Integer.valueOf(tfid.getText());

                    //Limpiar TextField
                    tfid.clear();
                    //Eliminando alumno
                    //opAlumno.deleteAlumno(id);
                    //Actualizando datos
                    Alumno regAlumno = opAlumno.getAlumno(id);
                    datos.remove(regAlumno);
                    /*tv.getItems().clear(); //Limpiar TableView
                    opAlumno.getLista(datos);
                    tv.getItems().addAll(datos);*/
                }
            }
        });

                /*Alert  alert = new Alert (Alert.AlertType.INFORMATION);
                alert.setTitle ("Diálogo de información");
                alert.setHeaderText (null);
                alert.setContentText ("¡Tengo un gran mensaje para ti!");
                alert.showAndWait ();*/

                /*String n = String.valueOf(id);
                if(n.equals("")) {
                    //alert.setAlertType(Alert.AlertType.CONFIRMATION);
                    //alert.show();
                    alert.setContentText("El campo ID no puede estar vacio");
                    alert.showAndWait();
                }else {*/
        btnCreate.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String idS = tfid.getText();
                String nom = tfnombre.getText();
                String appat = tfapePaterno.getText();
                String califS = tfcalificacion.getText();
                if  (idS.equals("")){
                    tfid.clear();
                    alert.setContentText ("El campo ID no puede estar vacio");
                    alert.showAndWait ();
                }else if(nom.equals("")){
                    tfnombre.clear();
                    alert.setContentText ("El campo Nombre no puede estar vacio");
                    alert.showAndWait ();
                }else if (appat.equals("")){
                    tfapePaterno.clear();
                    alert.setContentText ("El campo Apellido Paterno no puede estar vacio");
                    alert.showAndWait ();
                }else if (califS.equals("")){
                    tfcalificacion.clear();
                    alert.setContentText ("El campo Calificación no puede estar vacio");
                    alert.showAndWait ();
                }else {
                    int id = Integer.valueOf(tfid.getText());
                    String apmat = tfapeMaterno.getText();
                    float calif = Float.valueOf(tfcalificacion.getText());
                    opAlumno.insertAlumno(id, nom, appat, apmat, calif);
                    //Limpiar TextField
                    tfid.clear();
                    tfnombre.clear();
                    tfapePaterno.clear();
                    tfapeMaterno.clear();
                    tfcalificacion.clear();
                    //Actualizando datos
                    tv.getItems().clear();
                    opAlumno.getLista(datos);
                    tv.getItems().addAll(datos);
                }
            }
        });

        btnRead.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String idS = tfid.getText();
                if  (idS.equals("")){
                    tfid.clear();
                    alert.setContentText ("El campo ID no puede estar vacio");
                    alert.showAndWait ();
                }else {
                    int id = Integer.valueOf(tfid.getText());
                    opAlumno.getAlumno(id);
                    Alumno regAlumno = opAlumno.getAlumno(id);
                    System.out.print("Alumno: " + regAlumno);
                    //Limpiar TextField
                    tfid.clear();
                    //Actualizando datos
                    tv.getItems().clear();
                    //opAlumno.getLista(datos);
                    tv.getItems().addAll(regAlumno);
                }
            }
        });

        btnUpdate.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                String idS = tfid.getText();
               /* if  (idS.equals("")){
                    tfid.clear();
                    alert.setContentText ("El campo ID no puede estar vacio");
                    alert.showAndWait ();
                }else {*/
                    //Actualizando datos
                    tv.getItems().clear();
                    opAlumno.getLista(datos);
                    tv.getItems().addAll(datos);

                    int id = Integer.valueOf(tfid.getText());
                    String nom = tfnombre.getText();
                    String appat = tfapePaterno.getText();
                    String apmat = tfapeMaterno.getText();
                    String calif = tfcalificacion.getText();

                    Alumno regAlumno = opAlumno.getAlumno(id);
                    String NOMBRE = regAlumno.getNombre();
                    String APEPAT = regAlumno.getApePaterno();
                    String APEMAT = regAlumno.getApeMaterno();
                    float CALIF = regAlumno.getCalificacion();

                    //Remplazando los campos vacios por datos existentes
                    if (nom.equals("")) {
                        nom = NOMBRE;
                    }
                    if (appat.equals("")) {
                        appat = APEPAT;
                    }
                    if (apmat.equals("")) {
                        apmat = APEMAT;
                    }
                    if (calif.equals("")) {
                        opAlumno.updateAlumno(id, nom, appat, apmat, CALIF);

                    } else {
                        float n = Float.valueOf(tfcalificacion.getText());
                        opAlumno.updateAlumno(id, nom, appat, apmat, n);
                    }
                    //Actualizando datos alumno

                    //Limpiar TextField
                    tfid.clear();
                    tfnombre.clear();
                    tfapePaterno.clear();
                    tfapeMaterno.clear();
                    tfcalificacion.clear();
                    //Actualizando datos
                    tv.getItems().clear();
                    opAlumno.getLista(datos);
                    tv.getItems().addAll(datos);
                //}
            }
        });




    }

    public static void main(String[] args) {
        launch(args);
    }
}
