package com.example.uppgift2objektivering;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelloApplication extends Application {

    private final TableView<Table> tableView = new TableView<>();
    private final ObservableList<Table> dataList = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {



        Group root = new Group();
        stage.setTitle("Uppgift 2 : Objektivering");
        stage.setWidth(860);
        stage.setHeight(750);

        // adds some text at the top of the table
        final Label label = new Label("Orderlista: ");
        label.setFont(new Font("Arial", 20));

        tableView.setEditable(true);
        tableView.setMinHeight(500);
        tableView.setMinWidth(820);

        TableColumn<Table, String> orderDate = new TableColumn<>("Orderdate");
        orderDate.setMinWidth(100);
        orderDate.setCellValueFactory(new PropertyValueFactory<>("OrderDate"));

        TableColumn<Table, String> region = new TableColumn<>("Region");
        region.setMinWidth(100);
        region.setCellValueFactory(new PropertyValueFactory<>("Region"));

        TableColumn<Table, String> rep1 = new TableColumn<>("Rep1");
        rep1.setMinWidth(100);
        rep1.setCellValueFactory(new PropertyValueFactory<>("Rep1"));

        TableColumn<Table, String> rep2 = new TableColumn<>("Rep2");
        rep2.setMinWidth(100);
        rep2.setCellValueFactory(new PropertyValueFactory<>("Rep2"));

        TableColumn<Table, String> item = new TableColumn<>("Item");
        item.setMinWidth(100);
        item.setCellValueFactory(new PropertyValueFactory<>("Item"));

        TableColumn<Table, String> units = new TableColumn<>("Units");
        units.setMinWidth(100);
        units.setCellValueFactory(new PropertyValueFactory<>("Units"));

        TableColumn<Table, String> unitCost = new TableColumn<>("UnitCost");
        unitCost.setMinWidth(100);
        unitCost.setCellValueFactory(new PropertyValueFactory<>("UnitCost"));

        TableColumn<Table, String> total = new TableColumn<>("Total");
        total.setMinWidth(100);
        total.setCellValueFactory(new PropertyValueFactory<>("Total"));

        tableView.setItems(dataList);

        tableView.getColumns().addAll(orderDate, region, rep1, rep2, item, units, unitCost, total);


        // creates the box and edits it
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(label, tableView);

        root.getChildren().add(vBox);

        //  shows the scene
        stage.setScene(new Scene(root));
        stage.show();

        ReadCSV();
    }

    private void ReadCSV() {

        String CsvFile = "src/main/resources/sample.csv";
        String FieldDelimiter = ",";

        BufferedReader br;

        try {
            br = new BufferedReader(new FileReader(CsvFile));

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(FieldDelimiter, -1);

                Table table = new Table(fields[0], fields[1], fields[2],
                        fields[3], fields[4], fields[5], fields[6], fields[7]);

                dataList.add(table);
            }

            dataList.remove(0);

        } catch (FileNotFoundException ex) {

        } catch (IOException ex) {

        }

    }

    public static void main(String[] args){
        launch();
    }
}