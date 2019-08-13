package modelo.Estrategias;

import interfaces.IEstrategiaMostraListaDeLetrasParaJogador;

public class FabricaMostraListaDeLetrasParaJogador  {

	public static IEstrategiaMostraListaDeLetrasParaJogador singleton;

	public enum TipoEstrategia {
		JogoFacil, JogoDificil
	};

	private TipoEstrategia tipo;

	public FabricaMostraListaDeLetrasParaJogador() {
	}

	public IEstrategiaMostraListaDeLetrasParaJogador criaEstrategia(TipoEstrategia tipo){
			switch(tipo){
			case JogoFacil:
				if (this.singleton == null) {
					singleton = new EstrategiaJogoFacil();
					}
				return this.singleton;
							
			case JogoDificil :
				if(this.singleton == null){
					singleton = new EstrategiaJogoDificil();	
				}
							
			default: return new EstrategiaJogoDificil();
			}
		}

	public static FabricaMostraListaDeLetrasParaJogador getInstance() {
		if (singleton == null)
			singleton = (IEstrategiaMostraListaDeLetrasParaJogador) new FabricaMostraListaDeLetrasParaJogador();
		return (FabricaMostraListaDeLetrasParaJogador) singleton;
	}

	public TipoEstrategia setTipoDeJogoEscolhido(int tipo) {
		TipoEstrategia tipoSelecionado;
		if (tipo == 1) {
			tipoSelecionado = TipoEstrategia.JogoFacil;
		} else {
			tipoSelecionado = TipoEstrategia.JogoDificil;

		}
		return tipoSelecionado;
		
	}
}
