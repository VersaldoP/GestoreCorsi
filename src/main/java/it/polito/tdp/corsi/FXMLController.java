/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.corsi;

import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.Model;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtPeriodo"
    private TextField txtPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="txtCorso"
    private TextField txtCorso; // Value injected by FXMLLoader

    @FXML // fx:id="btnCorsiPerPeriodo"
    private Button btnCorsiPerPeriodo; // Value injected by FXMLLoader

    @FXML // fx:id="btnNumeroStudenti"
    private Button btnNumeroStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnStudenti"
    private Button btnStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="btnDivisioneStudenti"
    private Button btnDivisioneStudenti; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML
    void corsiPerPeriodo(ActionEvent event) {
    	// CONTROLLO DEGLI INPUT 
    	
    	
    	txtRisultato.clear();
    	
    	String periodoString= txtPeriodo.getText();
    	int periodo;
    	try {
    		periodo= Integer.parseInt(periodoString);
    		
    	}
    	catch(NumberFormatException e ){
    		txtRisultato.setText("Devi inserire un numero(1 0 2) per il periodo didattico");
    		return;    	}
//    	catch(NullPointerException npe) {
//    		txtRisultato.setText("Devi inserire un numero(1 0 2) per il periodo didattico");
//    		return;
//    		}
    	if (periodo<1||periodo>2) {
    		txtRisultato.setText("Devi inserire un numero(1 0 2) per il periodo didattico");
    		return;
    		}		
    	//ELABORAZIONE
    	List<Corso> corsi = this.model.getCorsiByPeriodo(periodo);
//    	for(Corso c:corsi) {
//    		txtRisultato.appendText(c.toString()+"/n");
//    	}
//		Dobbiamo anche modificare il tipo di parametri che la textArea può accettare
//    	txtRisultato.setFromat....
    	
    	StringBuilder sb= new StringBuilder();
    	for(Corso c: corsi) {
    		sb.append(String.format("%-8s ",c.getCodins()));
    		sb.append(String.format("%-4d ",c.getCrediti()));
    		sb.append(String.format("%-50s ",c.getNome()));
    		sb.append(String.format("%-4d\n",c.getPd()));
//    		 "%" è il place holder,
//    		"-"(allineato a sinistra se no sarebbe allineato a dx),
//    		"n" numero di caratteri(8) 
//    		"s"o "d" tipo(s stringa; d intero)
//    		 lo possiamo fare anche in unica riga
    		
    		//dopo il %, il "-" serve per allineare il testo a sinistra, 
    		//il numero per definire la "larghezza" della colonna

    		//N.B. lo stesso formato si può ottenere andando a modificare direttamente
    		//il metodo toString della classe (vedi quanto fatto per la classe Studente)
    		
    	}
    	txtRisultato.appendText(sb.toString());
    }

    @FXML
    void numeroStudenti(ActionEvent event) {
    	
    	txtRisultato.clear();
    	
    	String periodoString= txtPeriodo.getText();
    	int periodo;
    	try {
    		periodo= Integer.parseInt(periodoString);
    		
    	}
    	catch(NumberFormatException e ){
    		txtRisultato.setText("Devi inserire un numero(1 0 2) per il periodo didattico");
    		return;    	}
    	catch(NullPointerException npe) {
    		txtRisultato.setText("Devi inserire un numero(1 0 2) per il periodo didattico");
    		return;
    		}
    	if (periodo<1||periodo>2) {
    		txtRisultato.setText("Devi inserire un numero(1 0 2) per il periodo didattico");
    		return;
    		}		
    	//ELABORAZIONE
    	
    	Map<Corso,Integer> corsiIscrizioni = this.model.getIscrittiByPeriodo(periodo);
    	
    	StringBuilder sb = new StringBuilder();
    	
    	
    	for(Corso c:corsiIscrizioni.keySet()) 
    		    		sb.append(String.format("%-50s %4d\n", c.getNome(),corsiIscrizioni.get(c)));
    	
    	txtRisultato.appendText(sb.toString());
    }

  

    @FXML
    void stampaStudenti(ActionEvent event) {
    	txtRisultato.clear();
    	
    	String codice = txtCorso.getText();
    	
    	if(!model.esisteCorso(codice)) {
    		
    		txtRisultato.appendText("il corso non esiste ");
    		return;
    	}
    	
    	List<Studente> studenti = model.getStudentiByCorso(codice);
    	if (studenti.size()==0) {
    		txtRisultato.appendText("il corso non ha iscritti ");
    		return;
    	}
    	
    	for (Studente s:studenti) {
    		txtRisultato.appendText(s.toString()+"\n");
    	}

    }
    @FXML
    void stampaDivisione(ActionEvent event) {
    	
    	txtRisultato.clear();
    	
    	String codice = txtCorso.getText();
    	
    	if(!model.esisteCorso(codice)) {
    		txtRisultato.appendText("il corso non esiste");
    		return;
    	}
    	
    	Map<String,Integer> divisione=model.getDivisioneCDS(codice);
    	
    	for(String cds : divisione.keySet())
    			txtRisultato.appendText(String.format("%-8s %4d\n",cds,divisione.get(cds)));
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorso != null : "fx:id=\"txtCorso\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCorsiPerPeriodo != null : "fx:id=\"btnCorsiPerPeriodo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNumeroStudenti != null : "fx:id=\"btnNumeroStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnStudenti != null : "fx:id=\"btnStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnDivisioneStudenti != null : "fx:id=\"btnDivisioneStudenti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }
    
    
}