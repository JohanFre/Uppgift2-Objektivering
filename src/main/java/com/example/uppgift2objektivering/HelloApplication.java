package com.example.uppgift2objektivering;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HelloApplication extends Application {

    private final TableView<Table> tableView = new TableView<>();
    private final ObservableList<Table> dataList = FXCollections.observableArrayList(
            new Table("","","","","","","","")
    );
    final HBox hb = new HBox();

    @Override
    public void start(Stage stage) {



        // Modifies stage size and set title of the stage.
        Group root = new Group();
        stage.setTitle("Uppgift 2 : Objektivering");
        stage.setWidth(860);
        stage.setHeight(750);

        // Adding text "Orderlista" on top of the table.
        final Label label = new Label("Orderlista: ");
        label.setFont(new Font("Arial", 20));

        // Creates the table and modify size.

        tableView.setEditable(true);
        tableView.setMinHeight(500);
        tableView.setMinWidth(820);

        // Creates columns in the table.

        TableColumn orderDate = new TableColumn("Orderdate");
        orderDate.setMinWidth(100);
        orderDate.setCellValueFactory(new PropertyValueFactory<Table, String>("OrderDate"));

        TableColumn region = new TableColumn("Region");
        region.setMinWidth(100);
        region.setCellValueFactory(new PropertyValueFactory<Table, String>("Region"));

        TableColumn rep1 = new TableColumn("Rep1");
        rep1.setMinWidth(100);
        rep1.setCellValueFactory(new PropertyValueFactory<Table, String>("Rep1"));

        TableColumn rep2 = new TableColumn("Rep2");
        rep2.setMinWidth(100);
        rep2.setCellValueFactory(new PropertyValueFactory<Table, String>("Rep2"));

        TableColumn item = new TableColumn("Item");
        item.setMinWidth(100);
        item.setCellValueFactory(new PropertyValueFactory<Table, String>("Item"));

        TableColumn units = new TableColumn("Units");
        units.setMinWidth(100);
        units.setCellValueFactory(new PropertyValueFactory<Table, String>("Units"));

        TableColumn unitCost = new TableColumn("UnitCost");
        unitCost.setMinWidth(100);
        unitCost.setCellValueFactory(new PropertyValueFactory<Table, String>("UnitCost"));

        TableColumn total = new TableColumn("Total");
        total.setMinWidth(100);
        total.setCellValueFactory(new PropertyValueFactory<Table, String>("Total"));

        // Sets items for the table.
        tableView.setItems(dataList);

        // Adds all the columns.
        tableView.getColumns().addAll(orderDate, region, rep1, rep2, item, units, unitCost, total);

        // Creates text fields for entering new items to the table.

        final TextField addOrderDate = new TextField();
        addOrderDate.setPromptText("Order date");
        addOrderDate.setMaxWidth(orderDate.getPrefWidth());
        final TextField addRegion = new TextField();
        addRegion.setMaxWidth(region.getPrefWidth());
        addRegion.setPromptText("Region");
        final TextField addRep1 = new TextField();
        addRep1.setMaxWidth(rep1.getPrefWidth());
        addRep1.setPromptText("Rep1");
        final TextField addRep2 = new TextField();
        addRep2.setMaxWidth(rep2.getPrefWidth());
        addRep2.setPromptText("Rep2");
        final TextField addItem = new TextField();
        addItem.setMaxWidth(item.getPrefWidth());
        addItem.setPromptText("Item");
        final TextField addUnits = new TextField();
        addUnits.setMaxWidth(units.getPrefWidth());
        addUnits.setPromptText("Units");
        final TextField addUnitCost = new TextField();
        addUnitCost.setMaxWidth(unitCost.getPrefWidth());
        addUnitCost.setPromptText("Unit Cost");
        final TextField addTotal = new TextField();
        addTotal.setMaxWidth(total.getPrefWidth());
        addTotal.setPromptText("Total");

        // Creates a button which adds the information that has been added to the fields.

        final Button addButton = new Button("Add to Table");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override

            // "On click" adds the information and creates new row in table and then clear the fields.
            public void handle(ActionEvent e) {
                dataList.add(new Table(
                        addOrderDate.getText(),
                        addRegion.getText(),
                        addRep1.getText(),
                        addRep2.getText(),
                        addItem.getText(),
                        addUnits.getText(),
                        addUnitCost.getText(),
                        addTotal.getText()));
                addOrderDate.clear();
                addRegion.clear();
                addRep1.clear();
                addRep2.clear();
                addItem.clear();
                addUnits.clear();
                addUnitCost.clear();
                addTotal.clear();
            }
        });


        // Adds the new information into the table.
        hb.getChildren().addAll(addOrderDate, addRegion, addRep1, addRep2, addItem, addUnits, addUnitCost, addTotal, addButton);
        hb.setSpacing(3);

        // Creates the box and edits it.
        VBox vBox = new VBox();
        vBox.setSpacing(20);
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.getChildren().addAll(label, tableView, hb);

        root.getChildren().add(vBox);

        //  Shows the stage.
        stage.setScene(new Scene(root));
        stage.show();

        ReadCSV();
    }

    private void ReadCSV() {

        // Creates variable for CSV-File and FieldDelimiter.

        String CsvFile = "src/main/resources/sample.csv";
        String FieldDelimiter = ",";

        BufferedReader br;

        // Reads all the lines in the CSV-File, adding it to the table.
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