package modelo.Estrategias;
	import java.util.ArrayList;
import java.util.Arrays;
	import java.util.Collections;
	import java.util.List;
	import java.util.Random;

import interfaces.IEstrategiaMostraListaDeLetrasParaJogador;
import modelo.Letra;
import modelo.construtorLetrasDoAlfabeto.*;;

	public class EstrategiaJogoDificil  extends ConstrutorDeLetrasDoAlfabeto implements IEstrategiaMostraListaDeLetrasParaJogador{


		@Override
		public List<Letra> mostraListaDeLetrasParaJogador() {
			List<Letra> listaDeLetrasParaOJogador = geraListaDeVogaisParaJogador();
			listaDeLetrasParaOJogador.addAll(geraListaDeConsoantesDificeisParaJogador());
			listaDeLetrasParaOJogador.addAll(geraListaDeConsoantesFaceisParaJogador());
			Collections.shuffle(listaDeLetrasParaOJogador);
			return listaDeLetrasParaOJogador;
		}
		
		private List<Letra> geraListaDeVogaisParaJogador() {
			List<Letra> vogaisParaRandomizar = retornaVogais();
			List<Letra> vogaisParaOJogador = new ArrayList<Letra>();
			 Random r = new Random();
			for(int i= 0; i<8; i++){
				vogaisParaOJogador.add(vogaisParaRandomizar.get(r.nextInt(vogaisParaRandomizar.size()-1)));
				
			}

			return vogaisParaOJogador;
		}
		
		private List<Letra> geraListaDeConsoantesDificeisParaJogador() {
			List<Letra> consoantesParaRandomizar = retornaConsoantesDificeis();
			List<Letra> consoantesParaOJogador = new ArrayList<Letra>();
			 Random r = new Random();
			for(int i= 0; i<9; i++){
				consoantesParaOJogador.add(consoantesParaRandomizar.get(r.nextInt(consoantesParaRandomizar.size()-1)));
				
			}
			return consoantesParaOJogador;
		}
		
		
		private List<Letra> geraListaDeConsoantesFaceisParaJogador() {
			List<Letra> consoantesParaRandomizar = retornaConsoantesFaceis();
			List<Letra> consoantesParaOJogador = new ArrayList<Letra>();
			 Random r = new Random();
			for(int i= 0; i<13; i++){
				consoantesParaOJogador.add(consoantesParaRandomizar.get(r.nextInt(consoantesParaRandomizar.size()-1)));
				
			}
			return consoantesParaOJogador;
		}
}
