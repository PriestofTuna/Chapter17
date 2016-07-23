import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by lytte on 7/22/2016.
 *
 * The programming exercise specifically states *Every time the program is run* that's why it requires a restart
 */
public class CountFX extends Application {
    public static void main(String [] args) {
        launch(args);
    }
    Button button, reset;
    @Override
    public void start(Stage PrimaryStage) throws Exception {
        Text outputText = new Text();
        button = new Button("getCount");
        reset = new Button("reset Count");
        button.setOnAction(e -> {

            try {
                outputText.setText("This is the " + countMain.counter() + "th iteration");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            countMain.clicked(); //tells the program its been clicked
        });
        //the below is the same as the above, just wanted to use the old method.
        reset.setOnAction(new EventHandler<javafx.event.ActionEvent>()  {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                try {
                    countMain.countReset();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        GridPane gridshow = new GridPane();
        gridshow.setAlignment(Pos.CENTER);
        gridshow.add(outputText, 0 , 0);
        gridshow.add(button, 0, 1);
        gridshow.add(reset, 0, 2);
        gridshow.setStyle("-fx-background-color: crimson");
        PrimaryStage.setScene(new Scene(gridshow, 300, 300));
        PrimaryStage.show();
    }
}
