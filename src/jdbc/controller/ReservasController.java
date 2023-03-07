package jdbc.controller;

import java.sql.Connection;
import java.sql.Date;
//import java.sql.SQLException;
import java.util.List;
import jdb.factory.ConnectionFactory;
import jdbc.dao.ReservaDAO;
import jdbc.modelo.Reserva;

public class ReservasController {
 private ReservaDAO reservaDAO;
 
 public ReservasController() {
		Connection connection = new ConnectionFactory().recuperarConexion();
		this.reservaDAO = new ReservaDAO(connection);
	}
 
	public void guardar(Reserva reserva) {
		this.reservaDAO.guardar(reserva);
	}
		
	public List<Reserva> buscar() {
		return this.reservaDAO.buscar();
	}
	
	public List<Reserva> buscarId(String id) {
		return this.reservaDAO.buscarId(id);
	}
	
	public void actualizar(Date dataE, Date dataS, String valor, String forma_pagamento, Integer Id){
		this.reservaDAO.Atualizar(dataE, dataS, valor, forma_pagamento, Id);
	}
	
	public void Eliminar(Integer Id) {
		this.reservaDAO.Eliminar(Id);
	}
}
