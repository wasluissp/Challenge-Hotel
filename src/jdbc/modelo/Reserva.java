package jdbc.modelo;

import java.sql.Date;

public class Reserva {
	
	private Integer Id;
	private Date dataE;
	private Date dataS;
	private String valor;
	private String forma_pagamento;
	
	
	public Reserva(Date dataE, Date dataS, String valor, String forma_pagamento) {
		super();		
		this.dataE = dataE;
		this.dataS = dataS;
		this.valor = valor;
		this.forma_pagamento = forma_pagamento;
	}
		
	public Reserva(Integer id, Date dataE, Date dataS, String valor, String forma_pagamento) {
		this.Id = id;
		this.dataE = dataE;
		this.dataS = dataS;
		this.valor = valor;
		this.forma_pagamento = forma_pagamento;
	}

	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		this.Id = id;
	}

	public Date getdataE() {
		return dataE;
	}

	public Date getdataS() {
		return dataS;
	}

	public String getvalor() {
		return valor;
	}

	public String getforma_pagamento() {
		return forma_pagamento;
	}

	
//	@Override
//	public String toString() {
//		return String.format("La reserva generada fue: %d, %s, %s, %s, %s", this.Id, this.dataE, this.dataS, this.valor, this.forma_pagamento);
//	}
	
	
	
}

