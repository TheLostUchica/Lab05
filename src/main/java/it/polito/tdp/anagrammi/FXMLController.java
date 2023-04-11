package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Calcola;

    @FXML
    private TextArea Corretto;

    @FXML
    private TextArea Errato;

    @FXML
    private TextField Parola;

    @FXML
    private Button Reset;

	private Model model;

    @FXML
    void doCalcola(ActionEvent event) {
    	String parola = this.Parola.getText();
    	if (parola != null) {
    		TreeMap <String, Boolean> Map = model.Convalida(parola);
    		for (String s : Map.keySet()) {
    			if (Map.get(s)) {
    				this.Corretto.appendText(s+"\n");
    			}else {
    				this.Errato.appendText(s+"\n");
    			}
    		}
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.Corretto.clear();
    	this.Errato.clear();
    	this.Parola.clear();
    }

    @FXML
    void initialize() {
        assert Calcola != null : "fx:id=\"Calcola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Corretto != null : "fx:id=\"Corretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Errato != null : "fx:id=\"Errato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Parola != null : "fx:id=\"Parola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert Reset != null : "fx:id=\"Reset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}

}
