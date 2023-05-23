package geniemoviesandgames;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class tableviewtest extends Application {
   public void start(Stage stage) {
      //Label for education
      Label label = new Label("File Data:");
      Font font = Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 12);
      label.setFont(font);
      //Creating a table view
      TableView<filedata> table = new TableView<filedata>();
      final ObservableList<filedata> data = FXCollections.observableArrayList(
         new filedata("file1", "hello.txt", "25 MB", "12/01/2017"),
         new filedata("file2", "hello1.txt", "30 MB", "01/11/2019"),
         new filedata("file3", "hello2.txt", "50 MB", "12/04/2017"),
         new filedata("file4", "hello3.txt", "75 MB", "25/09/2018")
      );
      
      //Creating columns
      TableColumn fileNameCol = new TableColumn("File Name");
      fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
      TableColumn pathCol = new TableColumn("Path");
      pathCol.setCellValueFactory(new PropertyValueFactory("path"));
      TableColumn sizeCol = new TableColumn("Size");
      sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
      TableColumn dateCol = new TableColumn("Date Modified");
      dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));
      dateCol.setPrefWidth(100);
      //Adding data to the table
      ObservableList<String> list = FXCollections.observableArrayList();
      table.setItems(data);;
      table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
      table.getColumns().addAll(fileNameCol, pathCol, sizeCol, dateCol);
      //Setting the size of the table
      table.setMaxSize(350, 200);
      VBox vbox = new VBox();
      vbox.setSpacing(5);
      vbox.setPadding(new Insets(10, 50, 50, 60));
      vbox.getChildren().addAll(label, table);
      //Setting the scene
      Scene scene = new Scene(vbox, 595, 230);
      stage.setTitle("Table View Exmple");
      stage.setScene(scene);
      stage.show();
   }

    public static void main(String args[]) {
        launch(args);
    }
}