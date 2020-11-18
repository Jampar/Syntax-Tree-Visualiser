import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.List;


/**
 * Class to create application GUI.
 */
public class AppWindow extends Application implements EventHandler<ActionEvent> {

  //Size of the window.
  private final int[] windowDimensions = {700, 600};

  //Where the various panes of a window are stored before being added.
  private final List<Pane> paneBuffer = new ArrayList<>();

  private TextField entryField;

  GridPane rootPane;

  /**
   * Display Entry Point
   *
   * @param args Console-Passed Arguments.
   */
  public static void main(String[] args) {
    //Call the Application class Launch Method.
    launch(args);
  }

  /**
   * Creates an application thread for running the application.
   *
   * @param window The current window stage being drawn.
   */
  @Override
  public void start(Stage window) {

    //Set title string.
    window.setTitle("Syntax Tree Visualiser");

    createRootPane();

    //Display window.
    displayWindow(window);
  }

  /**
   * Shows app window.
   *
   * @param stage Stage to be shown.
   */
  private void displayWindow(Stage stage) {

    stage.getIcons().add(new Image("Icons/AppIcon.png"));

    Scene scene = new Scene(rootPane, windowDimensions[0], windowDimensions[1]);
    scene.getStylesheets().add("Stylesheets/stylesheet");
    //Apply new scene to primary stage
    stage.setScene(scene);

    ///Show the stage window.
    stage.show();
  }

  /**
   * Creates the horizontal box at the top of the window for expression entry.
   *
   * @return Entry Pane
   */
  private void createRootPane() {
    rootPane = new GridPane();
    rootPane.setPadding(new Insets(10, 10, 10, 10));
    rootPane.setVgap(5);
    rootPane.setHgap(5);

    Label expressionLabel = new Label("Expression: ");
    GridPane.setConstraints(expressionLabel, 0, 0);
    rootPane.getChildren().add(expressionLabel);

    TextField expressionInput = new TextField();
    GridPane.setConstraints(expressionInput, 1, 0);
    rootPane.getChildren().add(expressionInput);

    Button submit = new Button("Submit");
    GridPane.setConstraints(submit, 2, 0);
    rootPane.getChildren().add(submit);

  }


  /**
   * Invoked when a specific event of the type for which this handler is
   * registered happens.
   *
   * @param event the event which occurred
   */
  @Override
  public void handle(ActionEvent event) {
    String bracketedExpression = ExpressionHandler.applyBrackets(entryField.getText());
  }
}
