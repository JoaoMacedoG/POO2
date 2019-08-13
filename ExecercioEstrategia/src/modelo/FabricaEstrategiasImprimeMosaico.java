package modelo;

import java.util.HashMap;
import java.util.Map;

import interfaces.EstrategiaImprimeMosaico;

public class FabricaEstrategiasImprimeMosaico {

	private static FabricaEstrategiasImprimeMosaico singleton;
	public enum TipoEstrategia{ FrenteParaTras,TrasParaFrente };
	
	public Map<TipoEstrategia, EstrategiaImprimeMosaico> estrategias;
	
	private FabricaEstrategiasImprimeMosaico(){
		estrategias =  new HashMap <TipoEstrategia, EstrategiaImprimeMosaico>();
		estrategias.put(TipoEstrategia.FrenteParaTras, new EstrategiaImprimeFrenteParaTras());
		estrategias.put(TipoEstrategia.TrasParaFrente, new EstrategiaImprimeTrasParaFrente());
	}
	
	public EstrategiaImprimeMosaico criaEstrategia(TipoEstrategia tipo){
		return estrategias.get(tipo);
		
	}
	
	public static FabricaEstrategiasImprimeMosaico getInstance(){
		if(singleton == null)
			singleton = new FabricaEstrategiasImprimeMosaico();
		return singleton;
	}
}
