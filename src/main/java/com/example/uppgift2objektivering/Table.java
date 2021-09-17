package com.example.uppgift2objektivering;

import javafx.beans.property.SimpleStringProperty;

public class Table {

    // The been that gets and sets the CSV strings.

    private final SimpleStringProperty OrderDate,Region,Rep1,Rep2,Item,Units,UnitCost,Total;

    Table(String orderDate, String Region, String Rep1, String Rep2,
          String Item, String Units, String UnitCost, String Total) {
        this.OrderDate = new SimpleStringProperty(orderDate);
        this.Region = new SimpleStringProperty(Region);
        this.Rep1 = new SimpleStringProperty(Rep1);
        this.Rep2 = new SimpleStringProperty(Rep2);
        this.Item = new SimpleStringProperty(Item);
        this.Units = new SimpleStringProperty(Units);
        this.UnitCost = new SimpleStringProperty(UnitCost);
        this.Total = new SimpleStringProperty(Total);
    }


    public String getOrderDate() {
        return OrderDate.get();
    }

    public SimpleStringProperty orderDateProperty() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        this.OrderDate.set(orderDate);
    }

    public String getRegion() {
        return Region.get();
    }

    public SimpleStringProperty regionProperty() {
        return Region;
    }

    public void setRegion(String region) {
        this.Region.set(region);
    }

    public String getRep1() {
        return Rep1.get();
    }

    public SimpleStringProperty rep1Property() {
        return Rep1;
    }

    public void setRep1(String rep1) {
        this.Rep1.set(rep1);
    }

    public String getRep2() {
        return Rep2.get();
    }

    public SimpleStringProperty rep2Property() {
        return Rep2;
    }

    public void setRep2(String rep2) {
        this.Rep2.set(rep2);
    }

    public String getItem() {
        return Item.get();
    }

    public SimpleStringProperty itemProperty() {
        return Item;
    }

    public void setItem(String item) {
        this.Item.set(item);
    }

    public String getUnits() {
        return Units.get();
    }

    public SimpleStringProperty unitsProperty() {
        return Units;
    }

    public void setUnits(String units) {
        this.Units.set(units);
    }

    public String getUnitCost() {
        return UnitCost.get();
    }

    public SimpleStringProperty unitCostProperty() {
        return UnitCost;
    }

    public void setUnitCost(String unitCost) {
        this.UnitCost.set(unitCost);
    }

    public String getTotal() {
        return Total.get();
    }

    public SimpleStringProperty totalProperty() {
        return Total;
    }

    public void setTotal(String total) {
        this.Total.set(total);
    }

}
