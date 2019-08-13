package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import excecoes.ExcecaoEleicaoAberta;
import excecoes.ExcecaoEleicaoFechada;
import excecoes.ExcecaoEleitorExistente;
import excecoes.ExcecaoEleitorJaVotou;
import excecoes.ExcecaoPartidoExistente;
import excecoes.ExcecaoPrefeitoExistente;
import excecoes.ExcecaoUrnaExistente;
import excecoes.ExcecaoVereadorExistente;
import excecoes.ExcecaoZonaEleitoralExistente;
import excecoes.ExcecaoZonaNaoExistente;
import interfaces.ICartorioEleitoral;
import interfaces.ISecao;
import interfaces.IZonaEleitoral;

public class FachadaCartorioEleitoral implements ICartorioEleitoral, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<ZonaEleitoral> zonas;
	private ArrayList<Eleitor> eleitores;
	private ArrayList<Secao> secoes;
	private ArrayList<Partido> partidos;
	private ArrayList<Urna> urnas;
	private ArrayList<Eleitor> eleitoresQueJaVotaram;
	private ArrayList<Eleitor> eleitoresQueJaVotaramEmVereador;
	private ArrayList<Eleitor> eleitoresQueJaVotaramEmPrefeito;
	private ArrayList<Candidato> candidatosVotadosPrefeitos;
	private ArrayList<Candidato> candidatosVotadosVereador;
	

	public FachadaCartorioEleitoral() {
		this.zonas = new ArrayList<ZonaEleitoral>();
		this.secoes = new ArrayList<Secao>();
		this.eleitores = new ArrayList<Eleitor>();
		this.partidos = new ArrayList<Partido>();
		this.candidatosVotadosPrefeitos = new ArrayList<Candidato>();
		this.candidatosVotadosVereador = new ArrayList<Candidato>();
		this.urnas = new ArrayList<Urna>();
		this.eleitoresQueJaVotaram = new ArrayList<Eleitor>();
		this.eleitoresQueJaVotaramEmPrefeito= new ArrayList<Eleitor>();
		this.eleitoresQueJaVotaramEmVereador = new ArrayList<Eleitor>();
	}

	// Tamanho dos arrays
	public int numeroDeZonasEleitorais() {
		return this.zonas.size();

	}

	public int numeroDePartidos() {
		return this.partidos.size();
	}

	public int numeroDeSecoesEleitorais() {
		return this.secoes.size();

	}
	

	public int numeroDeEleitores() {
		return this.eleitores.size();

	}

	public int numeroDeEleitoresQueVotaram() {
		return this.eleitoresQueJaVotaram.size();
	}


	public int numeroTotalDeCandidatosPrefeitosVotados() {
		return this.candidatosVotadosPrefeitos.size();
	}

	public int numeroTotalDeCandidatosVereadoresVotados() {
		return this.candidatosVotadosVereador.size();
	}
	
	public int numeroEleitoresVotaramEmPrefeitos(){
		return this.eleitoresQueJaVotaramEmPrefeito.size();
	}

	public int numeroEleitoresQueVotaramEmVereador(){
		return this.eleitoresQueJaVotaramEmVereador.size();
	}
	// ---Zonas

	public void cadastraZonaEleitoral(int numeroZonaEleitoral, String localizacao)
			throws ExcecaoZonaEleitoralExistente {
		ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
		if (zona == null) {
			zona = new ZonaEleitoral(numeroZonaEleitoral, localizacao);
			this.zonas.add(zona);

		} else
			throw new ExcecaoZonaEleitoralExistente();
	}
 
	//-- Secao
	public void cadastraSecaoEleitoral(int numeroZonaEleitoral) throws ExcecaoZonaNaoExistente {
		IZonaEleitoral zonaCerta = getZona(numeroZonaEleitoral);
		if (zonaCerta != null) {
			this.secoes.add(zonaCerta.criaNovaSecao());

		} else {
			throw new ExcecaoZonaNaoExistente();
		}
	}
	
	// -- Partidos

	public void cadastraPartido(String siglaDoPartido, String nomeDoPartido) throws ExcecaoPartidoExistente {
		{
			Partido partidoASerCadastrado = getPartido(nomeDoPartido);
			if (partidoASerCadastrado == null){
				 partidoASerCadastrado = new Partido(siglaDoPartido, nomeDoPartido);
				this.partidos.add(partidoASerCadastrado);
			}else {
				throw new ExcecaoPartidoExistente();
			}
		}

	}
	
	public Partido getPartido(String sigla) {
		for (int cont = 0; cont < this.partidos.size(); cont++) {
			Partido partidoExistente = this.partidos.get(cont);
			if (partidoExistente.getNomeDoPartido().equals(sigla)) {
				return partidoExistente;
			}
		}
		return null;

	}
	// -- Votos/ eleicao

	public void abreEleicao() throws ExcecaoEleicaoAberta {
		
		for (int i =0; i< urnas.size(); i++) {
			urnas.get(i).abreUrna();		}
	}
	

	public void fechaEleicao() throws ExcecaoEleicaoFechada {
		for (Urna urna : urnas) {
			urna.fechaUrna();
		}
	}
	
	public void insereVotoPrefeito(Candidato prefeito, Eleitor eleitor, Partido partido, Urna urna, int numeroParaVotar)
			throws ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada {
	if (urna.getEstado().getClass() == EleicaoAberta.class){
		Eleitor eleitorVerifica = getEleitorJaVotouEmPrefeito(eleitor.getTitulo());
		if (eleitorVerifica == null) {
			if (eleitor.getZona() == urna.getZona() && eleitor.getSecao() == urna.getSecao()) {
				if (prefeito == partido.getPrefeito()) {
					prefeito.canditadoGanhouVoto();
					urna.aumentaTotalVotos();
					this.eleitoresQueJaVotaramEmPrefeito.add(eleitor);
					adicionarPrefeitoNoArrayVotados(prefeito, partido);
				}
			}
		} 
		}else {
			throw new ExcecaoEleitorJaVotou();
		}
	}
	
	public void insereVotoVereador(Candidato vereador, Eleitor eleitor, Partido partido, Urna urna, int numeroParaVotar)
			throws ExcecaoEleitorJaVotou, ExcecaoEleicaoFechada {
		Eleitor eleitorVerifica = getEleitorJaVotouEmVereador(eleitor.getTitulo());
		if (eleitorVerifica == null) {
			if (eleitor.getZona() == urna.getZona() && eleitor.getSecao() == urna.getSecao()) {
				if (vereador == partido.getVereador(numeroParaVotar)) {
					vereador.canditadoGanhouVoto();
					urna.aumentaTotalVotos();
					this.eleitoresQueJaVotaramEmVereador.add(eleitor);
					adicionarVereadorNoArrayVotados(vereador, numeroParaVotar, partido);
				}
					}
		} else {
			throw new ExcecaoEleitorJaVotou();
		}
	}
	
	public void adicionarPrefeitoNoArrayVotados(Candidato prefeito, Partido partido) {
		Candidato prefeitoCompara = getCandidatoJaVotadoPrefeito(partido);
		if (prefeitoCompara != prefeito) {
			this.candidatosVotadosPrefeitos.add(prefeito);
		}

	}

	public void adicionarVereadorNoArrayVotados(Candidato vereador, int numeroParaVotar, Partido partido) {
		Candidato vereadorCompara = getVereadorJaVotado(partido, numeroParaVotar);
		if (vereadorCompara != vereador) {
			this.candidatosVotadosVereador.add(vereador);
		}
	}
	


	public Candidato maiorVotoPrefeito() {
		ordenaPorVotosPrefeito();
		Candidato prefeitoEleito = this.candidatosVotadosPrefeitos.get(0);
		return prefeitoEleito;
	}

	public Candidato maiorVotoVereador() {
		ordenaPorVotosVereadores();
		Candidato vereadorEleito = this.candidatosVotadosVereador.get(0);
		return vereadorEleito;
	}
	

	// -- Candidatos
	public void cadastraCandidatoVereador(Eleitor eleitor, Partido partido, int numeroParaVotar)
			throws ExcecaoVereadorExistente {
		Candidato candidatoVereador = partido.getVereador(numeroParaVotar);
		if (candidatoVereador == null){
			candidatoVereador = new Candidato(eleitor, partido, numeroParaVotar);
			partido.insereVereadores(candidatoVereador);
		}else {
			throw new ExcecaoVereadorExistente();
		}
	}

	public void cadastraPrefeito(Eleitor eleitor, Partido partido, int numeroParaVotar)
			throws ExcecaoPrefeitoExistente {
		
		Candidato candidatoPrefeito = partido.getPrefeito();
		if (candidatoPrefeito == null){
			candidatoPrefeito = new Candidato(eleitor, partido, numeroParaVotar);
			partido.setPrefeito(candidatoPrefeito);
		}else {
			throw new ExcecaoPrefeitoExistente();
		}
	}
	
	public Candidato getCandidatoJaVotadoPrefeito(Partido partido) {
		for (int cont = 0; cont < this.candidatosVotadosPrefeitos.size(); cont++) {
			Candidato candidato = this.candidatosVotadosPrefeitos.get(cont);
			if (partido.getPrefeito() == candidato) {
				return candidato;
			}
		}
		return null;
	}

	public Candidato getVereadorJaVotado(Partido partido, int numeroParaVotar) {
		for (int cont = 0; cont < this.candidatosVotadosVereador.size(); cont++) {
			Candidato candidato = this.candidatosVotadosVereador.get(cont);
			if (partido.getVereador(numeroParaVotar) == candidato) {
				return candidato;
			}
		}
		return null;
	}

	public int getNumeroVotosGanhosCandidato(Candidato candidato) {
		return candidato.getNumeroDeVotosGanhos();

	}
	public Candidato getPrefeito(Partido partido) {
		return partido.getPrefeito();
	}
	
	public Candidato getVereador(int numeroVereador, Partido partido){
		return partido.getVereador(numeroVereador);
	}
	

	// -- Eleitores
	public void cadastraEleitor(String nome, int cpf, int titulo, int numeroZonaEleitoral, int numeroSecao,
			String municipio, String endereco) throws ExcecaoEleitorExistente {
		ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
		Secao secao = zona.getSecao(numeroSecao);
		Eleitor eleitor = new Eleitor(cpf, nome, titulo);
		if (!eleitor.equals(secao.getEleitor(titulo))) {
			eleitor.setEndereco(endereco);
			eleitor.setMunicipio(municipio);
			eleitor.setSecao(secao);
			eleitor.setZona(zona);
			secao.insereEleitor(eleitor);
			this.eleitores.add(eleitor);
		} else {
			throw new ExcecaoEleitorExistente();
		}
	}
	
	public Eleitor getEleitorJaVotou(int titulo) {

		for (int cont = 0; cont < this.eleitoresQueJaVotaram.size(); cont++) {
			Eleitor eleitor = this.eleitoresQueJaVotaram.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}
	
	public Eleitor getEleitorJaVotouEmPrefeito(int titulo) {

		for (int cont = 0; cont < this.eleitoresQueJaVotaramEmPrefeito.size(); cont++) {
			Eleitor eleitor = this.eleitoresQueJaVotaramEmPrefeito.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}
	
	public Eleitor getEleitorJaVotouEmVereador(int titulo) {

		for (int cont = 0; cont < this.eleitoresQueJaVotaramEmVereador.size(); cont++) {
			Eleitor eleitor = this.eleitoresQueJaVotaramEmVereador.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}

	public Eleitor getEleitor(int titulo) {

		for (int cont = 0; cont < this.eleitores.size(); cont++) {
			Eleitor eleitor = this.eleitores.get(cont);
			if (eleitor.getTitulo() == titulo) {
				return eleitor;
			}
		}
		return null;
	}
	// -- Urnas
	public void cadastrarUrna(int numeroZonaEleitoral, int numeroSecao) throws ExcecaoUrnaExistente {
		ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
		Secao secao = zona.getSecao(numeroSecao);
		Urna urna = getUrna(numeroZonaEleitoral, numeroSecao);
		if (urna == null) {
			urna = new Urna(zona, secao);
			this.urnas.add(urna);
			secao.setUrna(urna);
		} else {
			throw new ExcecaoUrnaExistente();
		}
	}

	public Urna getUrna(int numeroZonaEleitoral, int numeroSecao) {
		IZonaEleitoral zona = getZona(numeroZonaEleitoral);
		Secao secao = zona.getSecao(numeroSecao);
		for (int cont = 0; cont < this.urnas.size(); cont++) {
			Urna urna = this.urnas.get(cont);
			if (urna.getSecao().equals(secao)) {
				return urna;
			}

		}
		return null;
	}
	
	public int getTotalVotos(Urna urna) {
		return urna.getTotalVotos();
	}
// GETS

	public IZonaEleitoral getZona(int numeroZonaEleitoral) {

		for (int cont = 0; cont < this.zonas.size(); cont++) {
			ZonaEleitoral zona = this.zonas.get(cont);
			if (zona.getNumeroZona() == numeroZonaEleitoral) {
				return zona;
			}
		}
		return null;

	}
	
	public void votarParaSegundoTurno(Candidato prefeito, Eleitor eleitor, Partido partido, Urna urna, int numeroParaVotar) throws ExcecaoEleitorJaVotou{
		if (segundoTurno(urna) == true){
			if (urna.getEstado().getClass() == EleicaoAberta.class){
				Eleitor eleitorVerifica = getEleitorJaVotouEmPrefeito(eleitor.getTitulo());
				if (eleitorVerifica == null) {
					if (eleitor.getZona() == urna.getZona() && eleitor.getSecao() == urna.getSecao()) {
						if (prefeito == partido.getPrefeito()) {
							prefeito.canditadoGanhouVoto();
							urna.aumentaTotalVotos();
							this.eleitoresQueJaVotaramEmPrefeito.add(eleitor);
							adicionarPrefeitoNoArrayVotados(prefeito, partido);
						}
					}
				} 
				}else {
					throw new ExcecaoEleitorJaVotou();
				}
			}
			
		}
	
	public void removeVotosUrnas(){
		for(Urna urna: urnas){
			urna.setTotalVotos(0);
		}
	}
	
	public void removeVotosPrefeitos(){
		for(Partido partido: partidos){
			partido.getPrefeito().setNumeroDeVotosGanhos(0);
		}
	}
	
	
	
	public boolean segundoTurno(Urna urna){
		if (maiorVotoPrefeito().getNumeroDeVotosGanhos() <= (getTotalVotos(urna))/2){
			eleitoresQueJaVotaramEmPrefeito.removeAll(eleitoresQueJaVotaramEmPrefeito);
			candidatosVotadosPrefeitos.removeAll(candidatosVotadosPrefeitos);
			removeVotosUrnas();
			removeVotosPrefeitos();
			eleitoresQueJaVotaram.removeAll(eleitoresQueJaVotaram);
			return true;
		}
		return false;
	}
//ordenaArray
	public void ordenaPorVotosPrefeito() {
		Collections.sort(candidatosVotadosPrefeitos, new CompadadorDeCandidato());
		candidatosVotadosPrefeitos.sort(new CompadadorDeCandidato());
	}
	
	public void ordenaPorVotosVereadores() {
		Collections.sort(candidatosVotadosVereador, new CompadadorDeCandidato());
		candidatosVotadosVereador.sort(new CompadadorDeCandidato());
	
		
	}

		
	// --  Gets
	public ArrayList<ZonaEleitoral> getZonas() {
		return zonas;
	}

	public ArrayList<Eleitor> getEleitores() {
		return eleitores;
	}

	public ArrayList<Secao> getSecoes() {
		return secoes;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public ArrayList<Urna> getUrnas() {
		return urnas;
	}

	public ArrayList<Eleitor> getEleitoresQueJaVotaram() {
		return eleitoresQueJaVotaram;
	}

	public ArrayList<Candidato> getCandidatosVotadosPrefeitos() {
		return candidatosVotadosPrefeitos;
	}

	public ArrayList<Candidato> getCandidatosVotadosVereador() {
		return candidatosVotadosVereador;
	}
	@Override
	public List<? extends ISecao> getSecoesDeUmaZona(int numeroZonaEleitoral) throws Exception {
		ZonaEleitoral zona = (ZonaEleitoral) getZona(numeroZonaEleitoral);
		secoes = zona.getSecoesDeUmaZona();
		return secoes;
	}

	@Override
	public int numeroDeSecoesDeUmaZona(int numeroZonaEleitoral) {
		return getZona(numeroZonaEleitoral).getNumeroSecoes();
	}

	
}
