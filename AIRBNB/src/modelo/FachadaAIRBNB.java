package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import excecoes.ExcecaoCidadeExistente;
import excecoes.ExcecaoImovelExistente;
import excecoes.ExcecaoPessoaExistente;
import excecoes.ImovelJaReservado;
import excecoes.ImovelNaoEncontrado;
import excecoes.ImovelNaoExiste;
import excecoes.ReservaNaoExistente;
import interfaces.IFachadaAirBNB;
import modelo.Imovel;
import modelo.Comparadores.ComparadorReserva;
import modelo.Comparadores.FiltroPesquisa;
import modelo.Criador.CriadorDeCidades;
import modelo.Criador.CriadorDeImovel;
import modelo.Filtro.Filtro;

public class FachadaAIRBNB implements IFachadaAirBNB, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Reserva> reservas;
	private List<Casa> casas;
	private List<Cidade> cidades;
	private List<Pessoa> pessoas;
	private List<Imovel> todosImoveis;
	private List<Apartamento> apartamentos;
	private static FachadaAIRBNB singleton;

	private FachadaAIRBNB() {

		this.cidades = new ArrayList<Cidade>();
		this.todosImoveis = new ArrayList<Imovel>();
		this.apartamentos = new ArrayList<Apartamento>();
		this.casas = new ArrayList<Casa>();
		this.pessoas = new ArrayList<Pessoa>();
		this.reservas = new ArrayList<Reserva>();
		casas.addAll(new CriadorDeImovel().criaCasas());
		apartamentos.addAll(new CriadorDeImovel().criaApartamentos());
		cidades.addAll(new CriadorDeCidades().criaListCidades());
		todosImoveis.addAll(casas);
		todosImoveis.addAll(apartamentos);

	}

	public static FachadaAIRBNB getInstance() {
		if (singleton == null)
			singleton = new FachadaAIRBNB();
		return singleton;
	}

	public int tamanhoListPessoas() {
		return pessoas.size();
	}

	public int tamanhoListCasas() {
		return casas.size();
	}
	public int tamanhoListTodosImoveis() {
		return todosImoveis.size();
	}


	public int tamanhoListReservas() {
		return reservas.size();
	}

	public int tamanhoListCidades() {
		return cidades.size();
	}

	public int tamanhoListApartamentos() {
		return apartamentos.size();
	}
	public List<Reserva> getReservas() {
		return reservas;
	}

	public List<Imovel> getTodosImoveis() {
		return todosImoveis;
	}

	public List<Apartamento> getApartamentos() {
		return apartamentos;
	}

	public List<Casa> getCasas() {
		return casas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@Override
	public List<Imovel> pesquisarImovel(Filtro filtro) throws ImovelNaoEncontrado {
		FiltroPesquisa filtrador = new FiltroPesquisa(this);
		List<Imovel> imoveisFiltrados = filtrador.filtrar(filtro);
		if (imoveisFiltrados == null) {
			throw new ImovelNaoEncontrado();
		}
		return imoveisFiltrados;

	}

	@Override
	public void reservarImovel(Reserva reserva) throws ImovelNaoExiste, ImovelJaReservado {
		ComparadorReserva comparador = new ComparadorReserva(this);
		if (getReserva(reserva.getIdReserva()) == null && comparador.checaSeReservado(reserva) == false) {

			reservas.add(reserva);

		} else {
			throw new ImovelJaReservado();
		}
	}

	public void cancelarReserva(Integer cpf) throws ReservaNaoExistente  {
		for (int i = 0; i < reservas.size(); i++) {
			Reserva reserva = this.reservas.get(i);
			if (reserva.getPessoa().getCpf() == cpf) {
				reservas.remove(reserva);
			}else{
					throw new ReservaNaoExistente();
				}
			}

		}
	


	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public Pessoa getPessoa(int cpf) {

		for (int cont = 0; cont < this.pessoas.size(); cont++) {
			Pessoa pessoa = this.pessoas.get(cont);
			if (pessoa.getCpf() == cpf) {
				return pessoa;
			}
		}
		return null;
	}

	public Reserva getReserva(Integer cpf) {
		for (int cont = 0; cont < this.reservas.size(); cont++) {
			Reserva reserva = this.reservas.get(cont);
			if (reserva.getPessoa().getCpf() == cpf) {
				return reserva;
			}
		}
		return null;
	}

	public Casa getCasa(String nomeImovel) {
		for (int cont = 0; cont < this.casas.size(); cont++) {
			Casa imovel = this.casas.get(cont);
			if (imovel.getNomeImovel().equals(nomeImovel)) {
				return imovel;
			}
		}
		return null;
	}

	public Apartamento getApartamento(String nomeImovel) {
		for (int cont = 0; cont < this.apartamentos.size(); cont++) {
			Apartamento imovel = this.apartamentos.get(cont);
			if (imovel.getNomeImovel().equals(nomeImovel)) {
				return imovel;
			}
		}
		return null;
	}

	public Cidade getCidade(String nomeCidade) {
		for (int cont = 0; cont < this.cidades.size(); cont++) {
			Cidade cidade = this.cidades.get(cont);
			if (cidade.getNomeCidade().equals(nomeCidade)) {
				return cidade;
			}
		}
		return null;
	}

	public Imovel getImovel(String nomeImovel) {
		for (int cont = 0; cont < this.todosImoveis.size(); cont++) {
			Imovel imovel = this.todosImoveis.get(cont);
			if (imovel.getNomeImovel().equals(nomeImovel)) {
				return imovel;
			}
		}
		return null;
	}

	public void cadastraPessoa(String nome, String sexo, int cpf) throws ExcecaoPessoaExistente {
		Pessoa checarSePessoaNull = getPessoa(cpf);
		if (checarSePessoaNull == null) {
			checarSePessoaNull = new Pessoa(nome, sexo, cpf);
			this.pessoas.add(checarSePessoaNull);
		} else {
			throw new ExcecaoPessoaExistente();
		}

	}

	public void criaCidadeSeNaoExiste(String nomeCidade) {
		Cidade checaSeExiste = getCidade(nomeCidade);
		if (checaSeExiste == null) {
			checaSeExiste = new Cidade(nomeCidade);
			this.cidades.add(checaSeExiste);

		}
	}

	public void cadastraCasa(String cidade, String nomeImovel, Integer numeroDeBanheiros, Integer numeroCamas,
			Integer numeroQuartos, double preco, String jardim) throws ExcecaoImovelExistente, ExcecaoCidadeExistente {
		Casa checarSeImovelNull = getCasa(nomeImovel);
		criaCidadeSeNaoExiste(cidade);
		if (checarSeImovelNull == null) {
			checarSeImovelNull = new Casa(getCidade(cidade), nomeImovel, numeroDeBanheiros, numeroCamas, numeroQuartos,
					preco, 0, jardim,0);
			this.casas.add(checarSeImovelNull);
			this.todosImoveis.add(checarSeImovelNull);
		} else {
			throw new ExcecaoImovelExistente();
		}

	}

	public void cadastraApartamento(String cidade, String nomeImovel, Integer numeroDeBanheiros, Integer numeroCamas,
			Integer numeroQuartos, double preco, String andar) throws ExcecaoImovelExistente, ExcecaoCidadeExistente {
		Apartamento checarSeImovelNull = getApartamento(nomeImovel);
		criaCidadeSeNaoExiste(cidade);
		if (checarSeImovelNull == null) {
			checarSeImovelNull = new Apartamento(getCidade(cidade), nomeImovel, numeroDeBanheiros, numeroCamas,
					numeroQuartos, preco, 0, andar,0);
			this.apartamentos.add(checarSeImovelNull);
			this.todosImoveis.add(checarSeImovelNull);
		} else {
			throw new ExcecaoImovelExistente();
		}

	}

}
