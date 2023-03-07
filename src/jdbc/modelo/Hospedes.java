package jdbc.modelo;

import java.sql.Date;

public class Hospedes {
	private Integer Id;
	private String Nome;
	private String Sobrenome;
	private Date DataNascimento;
	private String Nacionalidade;
	private String Telefone;
	private Integer IdReserva;
	
	public Hospedes(String nome, String sobrenome,  Date dataNascimento, String nacionalidade, String telefone, Integer idReserva) {
		super();
		this.Nome = nome;
		this.Sobrenome = sobrenome;
		this.DataNascimento = dataNascimento;
		this.Nacionalidade = nacionalidade;
		this.Telefone = telefone;
		this.IdReserva = idReserva;
	}
	
	public Hospedes(Integer id, String nome, String sobrenome, Date dataNascimento, String nacionalidade, String telefone, Integer idReserva) {
		super();
		this.Id = id;
		this.Nome = nome;
		this.Sobrenome = sobrenome;
		this.DataNascimento = dataNascimento;
		this.Nacionalidade = nacionalidade;
		this.Telefone = telefone;
		this.IdReserva = idReserva;
	}


	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}


	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getSobrenome() {
		return Sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		Sobrenome = sobrenome;
	}

	public String getNacionalidade() {
		return Nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		Nacionalidade = nacionalidade;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}

	public Integer getIdReserva() {
		return IdReserva;
	}

	public void setIdReserva(Integer idReserva) {
		IdReserva = idReserva;
	}
	
}
