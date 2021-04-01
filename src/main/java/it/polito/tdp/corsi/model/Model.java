package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private CorsoDAO corsoDao;
	
	public Model() {
		corsoDao =new CorsoDAO();
	}

	public List<Corso> getCorsiByPeriodo(Integer periodo) {
		
		return corsoDao.getCorsiByPeriodo(periodo);
	}
	
	public Map<Corso,Integer> getIscrittiByPeriodo(Integer periodo) {
		
		return corsoDao.getIscrittiByPeriodo(periodo);
	}
	
	public List<Studente> getStudentiByCorso(String codice){
		return corsoDao.getStudenteByCorso(new Corso(codice,null,null,null));
		
	
	}
	
	public Map<String,Integer> getDivisioneCDS(String codice){
				//cosa ci aspettiamo
				//dato il corso con codice ABC
				// GEST -> 50
				// INF -> 40
				// MEC -> 30
		
		//SOLUZIONE1
		
		Map<String,Integer> divisione = new HashMap<String,Integer>();
		List<Studente> studenti = this.getStudentiByCorso(codice);
		for(Studente s : studenti) {
			if(s.getCDS()!=null&&!s.getCDS().equals("")) {
				if(divisione.get(s.getCDS())==null)
				{
					divisione.put(s.getCDS(),1);
					}
				else {
					divisione.put(s.getCDS(),divisione.get(s.getCDS())+1);
				}
			}
		}
		
		return divisione;
		
	}
	

	public boolean esisteCorso(String codice) {
		// TODO Auto-generated method stub
		
		
		return corsoDao.esisteCorso(new Corso(codice,null,null,null));
	}
	
}
