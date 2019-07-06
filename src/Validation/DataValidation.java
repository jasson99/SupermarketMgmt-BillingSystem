/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import Connectivity.DbConnection;
import com.jfoenix.controls.JFXDatePicker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Background;

/**
 *
 * @author New
 */
public class DataValidation {

    public static boolean phoneNo(TextField inputTextField, Label error) {
        boolean send;
        if (!inputTextField.getText().matches("[0-9]{10}")) {

            inputTextField.setStyle("-fx-border-color:red;");
            inputTextField.setStyle("-fx-background-color:#F8E0E0");
            error.setVisible(true);
            send= false;
        } else {
            inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
            error.setVisible(false);
            send = true;
        }
        return send;
    }

    public static boolean nameFieldValidation(TextField inputTextField, Label error) {
        boolean send;
        if (!inputTextField.getText().matches("[a-z A-Z]{5,}")) {
            inputTextField.setStyle("-fx-background-color:#F8E0E0");
            error.setVisible(true);
            send= false;
        } else {
            inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
            error.setVisible(false);
            send= true;
        }
        return send;
    }

    public static void usernameValidation(TextField inputTextField, String table, Label error) throws ClassNotFoundException, SQLException {
        if (inputTextField.getText().isEmpty()) {
            inputTextField.setStyle("-fx-background-color:#f8e0e0");
        } else {
            inputTextField.backgroundProperty().set(Background.EMPTY);
            inputTextField.setStyle("-fx-background-color:transparent");
        }
        DbConnection db = new DbConnection();
        Connection Con = db.DbConnect();
        PreparedStatement Pre = Con.prepareStatement("select * from " + table);
        ResultSet rs = Pre.executeQuery();
        while (rs.next()) {
            if (inputTextField.getText().equals(rs.getString("username"))) {
                inputTextField.setStyle("-fx-background-color:#f8e0e0");
                error.setVisible(true);
            } else {
                inputTextField.backgroundProperty().set(Background.EMPTY);
                inputTextField.setStyle("-fx-background-color:transparent");
                error.setVisible(false);
            }
        }
    }

    public static boolean passwordValidation(PasswordField inputTextField, Label error) {
        boolean send;
        if (!inputTextField.getText().matches("[a-zA-Z0-9]{8,20}")) {
            inputTextField.setStyle("-fx-background-color:#f8e0e0");
            error.setVisible(true);
            send = false;
        } else {
            inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
            error.setVisible(false);
            send = true;
        }
        return send;
    }

    public static void dobValidate(JFXDatePicker date) {
        
        if (date.getValue() == null) {
            date.setStyle("-fx-background-color:#f8e0e0");
        } else {
            date.setStyle("-fx-background-color:transparent");
            date.backgroundProperty().set(Background.EMPTY);
        }
    }

    public static boolean AddressValidation(TextField inputTextField, Label error) {
        boolean send;
        if (!inputTextField.getText().matches("[a-zA-Z0-9\\s]{5,}")) {
            inputTextField.setStyle("-fx-background-color:#f8e0e0");
            error.setVisible(true);
            send = false;
        } else {
            inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
            error.setVisible(false);
            send =  true;
        }
        return send;
    }

   
    
    public static void ProductNameValidation(TextField inputTextField, String table) throws ClassNotFoundException, SQLException
    {
        if(inputTextField.getText().trim()=="")
        {
            inputTextField.setStyle("-fx-background-color:#f8e0e0e0");
        }
        else
        {
              inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
        }
        DbConnection db = new DbConnection();
        Connection Con = db.DbConnect();
        PreparedStatement Pre = Con.prepareStatement("select * from " + table);
        ResultSet rs = Pre.executeQuery();
        while (rs.next()) {
            if (inputTextField.getText().equals(rs.getString("name"))) {
                inputTextField.setStyle("-fx-background-color:#f8e0e0");
               Alert dialog = new Alert(Alert.AlertType.WARNING);
               dialog.setTitle("Already Registered");
               dialog.setContentText("This item is already registered");
               dialog.showAndWait();
            } else {
                inputTextField.backgroundProperty().set(Background.EMPTY);
                inputTextField.setStyle("-fx-background-color:transparent");
               
            }
        }
    }
    
    public static void BarCodeValidation(TextField inputTextField)
    {
         if(!inputTextField.getText().matches("[0-9]"))
        {
            inputTextField.setStyle("-fx-background-color:#f8e0e0e0");
        }
        else
        {
              inputTextField.setStyle("-fx-background-color:#6ccccc");
            inputTextField.backgroundProperty().set(Background.EMPTY);
        }
    }
    
    public static void BlockValidation(TextField inputTextField){
        if(!inputTextField.getText().matches("[A-Z]"))
        {
            inputTextField.setStyle("-fx-background-color:#f8e0e0e0");
        }
        else
        {
              inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
        }
    }
    
    public static void PriceValidation(TextField inputTextField)
    {
        if(!inputTextField.getText().matches("[0-9]+\\.\\d\\d"))
        {
            inputTextField.setStyle("-fx-background-color:#f8e0e0e0");
        }
        else
        {
              inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
        }
    }
    
    public static void QtyValidation(TextField inputTextField)
    {
        
        if(!inputTextField.getText().matches("[0-9]+"))
        {
            inputTextField.setStyle("-fx-background-color:#f8e0e0e0");
        }
        else
        {
              inputTextField.setStyle("-fx-background-color:transparent");
            inputTextField.backgroundProperty().set(Background.EMPTY);
        }
    }
    
    
   
   
}
