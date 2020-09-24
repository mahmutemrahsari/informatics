/*
Skriv programmet slik at du bruker klassen ​​javafx.stage.
FileChooser​​ for å la brukeren finne/velge filen med labyrinten.
Når brukeren har valgt labyrintfilen som skal åpnes, skal labyrinten vises grafisk.
For den grafiske representasjonen av labyrinten skal programmet
bruke klassen javafx.scene.layout.GridPane.
Når brukeren klikker på en hvit rute, skal du bruke programmet
fra oblig 5 for å finne alle løsningene fra denne ruten.
Du skal ta én løsning fra beholderen med løsninger, og vise denne i labyrinten.
Er det flere enn én løsning, kan du vise den første,
med informasjon om hvor mange løsninger som totalt ble funnet.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;


public class GuiLabyrint extends Application {
    Labyrint labyrint;
    public  static  LabyrintCell[][] labyrintCellGUI;
    public  static  Text infoText = new Text("Velg en labyrint fil etter på klikk på en rute!");
    GridPane gridPane = new GridPane();

    @Override
    public void start(Stage primaryStage) {

        GridPane labyrintGridPane =  new GridPane();


        Button labyrintVelgerKnapp = new Button("Velg fil");


        labyrintVelgerKnapp.setTranslateX(0);
        labyrintVelgerKnapp.setTranslateY(30);
        labyrintVelgerKnapp.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Labyrint Filer", "*.in"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if(selectedFile != null) {
                labyrint = null;
                try {
                    labyrint = Labyrint.lesFraFil(selectedFile);
                    labyrintCellGUI = new LabyrintCell[labyrint.giRad()][labyrint.giKol()];
                    for(int i = 0; i<labyrint.giRad(); i++){
                        for(int j = 0; j<labyrint.giKol(); j++){
                            LabyrintCell labyrintCell = new LabyrintCell(labyrint,j,i);
                            labyrintGridPane.add(labyrintCell,j,i);
                            labyrintCellGUI[i][j] = labyrintCell;
                        }
                    }

                } catch (FileNotFoundException e) {
                    System.exit(1);
                }
            }
        });





        gridPane.setMinSize(900,900);
        gridPane.add(labyrintVelgerKnapp,1,2);
        //gridPane.getChildren().add(labyrintVelgerKnapp);
        //gridPane.getChildren().add(labyrintGridPane);
        gridPane.add(labyrintGridPane,1,0);
        gridPane.add(infoText,1,1);

        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Labyrint sølver");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

