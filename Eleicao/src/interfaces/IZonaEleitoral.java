package interfaces;

import java.util.ArrayList;

import modelo.Secao;

public interface IZonaEleitoral {

	public int getNumeroZona();
	public String getLocalizacao();
	public Secao getSecao(int numeroSecao);
	public Secao criaNovaSecao();
	public int getNumeroSecoes();
	public ArrayList<Secao> getSecoesDeUmaZona();
	
}
