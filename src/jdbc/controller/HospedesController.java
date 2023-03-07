package jdbc.controller;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import jdb.factory.ConnectionFactory;
import jdbc.dao.HospedesDAO;
import jdbc.modelo.Hospedes;


public class HospedesController {
	 private HospedesDAO hospedesDAO;
	 
	 public HospedesController() {
			Connection connection = new ConnectionFactory().recuperarConexion();
			this.hospedesDAO = new HospedesDAO(connection);
		}
	 
		public void guardar(Hospedes hospedes) {
			this.hospedesDAO.guardar(hospedes);
		}
		public List<Hospedes> listarHospedes() {
			return this.hospedesDAO.listarHospedes();
		}
		
		public List<Hospedes> listarHospedesId(String id) {
			return this.hospedesDAO.buscarId(id);
		}
		
		public void atualizar(String nome, String sobrenome, Date dataN, String nacionalidade, String telefone, Integer idReserva) {
			this.hospedesDAO.Atualizar(nome, sobrenome, dataN, nacionalidade, telefone, idReserva, idReserva);
		}
		
		public void Eliminar(Integer idReserva) {
			this.hospedesDAO.Eliminar(idReserva);
		}
}
