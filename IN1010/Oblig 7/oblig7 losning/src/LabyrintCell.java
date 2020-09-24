import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class LabyrintCell extends Pane {
    public static Labyrint labyrint;
    private boolean isHvite;
    private  boolean marked = false;
    private int col, row;
    List<String> exits;

    public LabyrintCell(Labyrint labyrint, int col, int row){
        this.labyrint = labyrint;
        this.row = row;
        this.col = col;

        if(labyrint.getRute(col,row) instanceof HvitRute){
            setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
            isHvite = true;
        }else{
            setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
            isHvite = false;
        }

        setBorder(new Border(new BorderStroke(Color.GREY, BorderStrokeStyle.SOLID,
                null, new BorderWidths(0.5))));

        //Setter storrelsene til rutene
        if (labyrint.giRad() < 20){
            setMinWidth(50);
            setMinHeight(50);
        } else if (labyrint.giRad() < 30){
            setMinWidth(30);
            setMinHeight(30);
        } else{
            setMinWidth(10);
            setMinHeight(10);
        }


        //Handterer musetrykk og kaller pa losning
        addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                clearCell();
                if (isHvite){

                        //Skifter Backgroundsfarge til redd
                        setBackground(new Background(
                                new BackgroundFill(Color.RED, null, null)));

                        marked = true;

                        //Kaller pa metoden finnLosning.
                      exits = labyrint.finnUtveiFra(col,row);
                      GuiLabyrint.infoText.setText("Antall losninger " + exits.size());

                      if(exits.size()>0){

                          boolean[][] temp = losningStringTilTabell(exits.get(0),labyrint.giRad(),labyrint.giKol());
                          for (int i=0; i<labyrint.giKol(); i++){
                              for (int j = 0; j<labyrint.giRad(); j++){
                                  if(temp[i][j]==true){
                                      GuiLabyrint.labyrintCellGUI[j][i].marked=true;
                                      GuiLabyrint.labyrintCellGUI[j][i].setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));
                                  }
                              }
                          }
                      }
                }
            }
        });
    }

    public void clearCell(){
        for (int i=0; i<labyrint.giRad(); i++){
            for (int j = 0; j<labyrint.giKol(); j++){
                if(GuiLabyrint.labyrintCellGUI[i][j].marked == true){
                    GuiLabyrint.labyrintCellGUI[i][j].setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                    GuiLabyrint.labyrintCellGUI[i][j].marked = false;
                }
            }
        }
    }


    //Gitt kode
    static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
        boolean[][] losning = new boolean[hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while(m.find()) {
            int x = Integer.parseInt(m.group(1))-1;
            int y = Integer.parseInt(m.group(2))-1;
            losning[y][x] = true;
        }
        return losning;
    }


}
