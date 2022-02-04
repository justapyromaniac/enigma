package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.example.models.Enigma;
import com.example.models.LoopedReflector;
import com.example.models.Rotor;

/**
 * JavaFX App
 */
public class App /*extends Application */ {

    // private static Scene scene;

    // @Override
    // public void start(Stage stage) throws IOException {
    //     scene = new Scene(loadFXML("primary"), 640, 480);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    // public static void setRoot(String fxml) throws IOException {
    //     scene.setRoot(loadFXML(fxml));
    // }

    // private static Parent loadFXML(String fxml) throws IOException {
    //     FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    //     return fxmlLoader.load();
    // }

    public static void main(String[] args) {
        char output = 'a';
        Enigma machine = new Enigma(5, 3, 5);
        //System.out.println("output: " + machine.encryptCharacter(output));
        System.out.println(new LoopedReflector());
        //launch();
    }

}