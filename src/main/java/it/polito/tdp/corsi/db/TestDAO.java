package it.polito.tdp.corsi.db;

import it.polito.tdp.corsi.model.Corso;

public class TestDAO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CorsoDAO dao = new CorsoDAO();
		
		System.out.println(dao.getStudenteByCorso(new Corso("01KSUPG", null, null, null)));

	}

}
