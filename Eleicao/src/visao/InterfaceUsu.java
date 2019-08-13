package visao;

import javax.swing.JOptionPane;

import java.util.Scanner;

import modelo.Eleitor;
import modelo.FachadaCartorioEleitoral;
import modelo.Partido;
import modelo.Urna;
import modelo.Candidato;
import modelo.Serializar;

public class InterfaceUsu {
	static Serializar serialize = new Serializar();
	 static FachadaCartorioEleitoral cartorio;
	InterfaceUsu inte= new InterfaceUsu();
	
	public static void main(String[] args) throws Exception {
		
	 if(cartorio == null){
			 cartorio = new FachadaCartorioEleitoral();
		 }
		Scanner lerDigitado = new Scanner(System.in);
		int opt= 0;
		while (opt != 13) {
		opt=  Integer.parseInt(JOptionPane.showInputDialog("Escolha a opção: "
				+ "\n" + "1 - Cadastrar zona eleitoral \n"
				+ "2 - Cadastrar seção \n" + 
				"3 - Cadastra eleitor \n" + 
				"4 - Cadastrar partido \n"
				+ "5 - Cadastrar vereador \n" + 
				"6 - Cadastrar prefeito \n" + 
				"7 - Cadastrar urna \n" + 
				"8 - Votar \n"
				+ "9 -  Abrir Eleicao \n" + 
				"10 - Fechar Eleicao \n" + 
				"11 -  Informações \n " + 
				"12 -  Carregar fachada \n " + 
				"13 - Sair e salvar"));
		
			switch (opt) {

			case 13:
				Serializar serializa = new Serializar();
				serializa.salvaFachada(cartorio, "arquivo");
				System.out.println("Salvo!");
				break;

			case 1:
				System.out.println("Informe o número da zona eleitoral: ");
				int numeroZonaEleitoral = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe a localização: ");
				String localizacao = lerDigitado.nextLine();
				cartorio.cadastraZonaEleitoral(numeroZonaEleitoral, localizacao);
				System.out.println("Zona Cadastrada!");
				
				break;

			case 2:
				System.out.println("Informe o número da zona eleitoral: ");
				int numeroZonaEleitoralSecao = Integer.parseInt(lerDigitado.nextLine());
				cartorio.cadastraSecaoEleitoral(numeroZonaEleitoralSecao);
				System.out.println("Seção cadastrada!");
				break;

			case 3:
				System.out.println("Informe o nome: ");
				String nome = lerDigitado.nextLine();
				System.out.println("Informe o cpf: ");
				int cpf = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o titulo: ");
				int titulo = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o número da zona eleitoral: ");
				numeroZonaEleitoral = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o número da seção: ");
				int numeroSecao = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o municipio: ");
				String municipio = lerDigitado.nextLine();
				System.out.println("Informe o endereço: ");
				String endereco = lerDigitado.nextLine();
				cartorio.cadastraEleitor(nome, cpf, titulo, numeroZonaEleitoral, numeroSecao, municipio, endereco);
				System.out.println("Eleitor cadastrado!");
				break;

			case 4:

				System.out.println("Informe a sigla do partido: ");
				String siglaPartido = lerDigitado.nextLine();
				System.out.println("Informe o nome do partido:");
				String nomePartido = lerDigitado.nextLine();
				cartorio.cadastraPartido(nomePartido, siglaPartido);
				System.out.println("Partido cadastrado!");
				break;

			case 5:
				System.out.println("Informe o numero do vereador: ");
				int numVereador = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o  nome partido :");
				String nomePartidoVereador = lerDigitado.nextLine();
				Partido partidoVereador = cartorio.getPartido(nomePartidoVereador);
				System.out.println("Informe o titulo de eleitor:");
				int numeroTituloVereador = Integer.parseInt(lerDigitado.nextLine());
				Eleitor eleitorVereador = cartorio.getEleitor(numeroTituloVereador);
				cartorio.cadastraCandidatoVereador(eleitorVereador, partidoVereador, numVereador);
				System.out.println("Vereador cadastrado!");
				break;

			case 6:
				System.out.println("Informe o numero do prefeito: ");
				int numPrefeito = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o  nome partido :");
				String nomePartidoPrefeito = lerDigitado.nextLine();
				Partido partidoPrefeito = cartorio.getPartido(nomePartidoPrefeito);
				System.out.println("Informe o titulo do prefeito:");
				int numeroTituloPrefeito = Integer.parseInt(lerDigitado.nextLine());
				Eleitor eleitorPrefeito = cartorio.getEleitor(numeroTituloPrefeito);
				cartorio.cadastraPrefeito(eleitorPrefeito, partidoPrefeito, numPrefeito);
				System.out.println("Prefeito cadastrado!");
				break;

			case 7:
				System.out.println("Informe o número da zona eleitoral: ");
				int numeroZonaEleitoralUrna = Integer.parseInt(lerDigitado.nextLine());
				System.out.println("Informe o número da seção: ");
				int numeroSecaoUrna = Integer.parseInt(lerDigitado.nextLine());
				cartorio.cadastrarUrna(numeroZonaEleitoralUrna, numeroSecaoUrna);
				System.out.println("Urna cadastrada!");
				break;

			case 8:
				System.out.println("Informe o seu titulo ");
				int tituloVoto = Integer.parseInt(lerDigitado.nextLine());
				Eleitor eleitorVoto = cartorio.getEleitor(tituloVoto);

				System.out.println("Informe o nome partido do prefeito :");
				String nomePartidoPrefeitoVoto = lerDigitado.nextLine();
				Partido partidoPrefeitoVoto = cartorio.getPartido(nomePartidoPrefeitoVoto);
				System.out.println("Informe o numero do prefeito: ");
				int numeroPrefeitoVoto = Integer.parseInt(lerDigitado.nextLine());
				Candidato prefeito = cartorio.getPrefeito(partidoPrefeitoVoto);
				Urna urna = eleitorVoto.getSecao().getUrna();
				cartorio.insereVotoPrefeito(prefeito, eleitorVoto, partidoPrefeitoVoto, urna, numeroPrefeitoVoto);
				System.out.println("Voto para prefeito concluído");

				System.out.println("Informe o nome partido do vereador :");
				String nomePartidoVereadorVoto = lerDigitado.nextLine();
				Partido partidoVereadorVoto = cartorio.getPartido(nomePartidoVereadorVoto);
				System.out.println("Informe o numero do vereador: ");
				int numVereadorVoto = Integer.parseInt(lerDigitado.nextLine());
				Candidato vereador = cartorio.getVereador(numVereadorVoto, partidoVereadorVoto);
				cartorio.insereVotoVereador(vereador, eleitorVoto, partidoVereadorVoto, urna, numVereadorVoto);
				System.out.println("Voto para vereador concluído");

				break;

			case 9:
				cartorio.abreEleicao();

				break;

			case 10:
				cartorio.fechaEleicao();
			
				if(cartorio.segundoTurno(cartorio.getUrnas().get(0))==true){
					while(cartorio.getEleitores().size()<0){
					System.out.println("Informe o seu titulo ");
					int tituloVoto2 = Integer.parseInt(lerDigitado.nextLine());
					Eleitor eleitorVoto2 = cartorio.getEleitor(tituloVoto2);

					System.out.println("Informe o nome partido do prefeito :");
					String nomePartidoPrefeitoVoto2 = lerDigitado.nextLine();
					Partido partidoPrefeitoVoto2 = cartorio.getPartido(nomePartidoPrefeitoVoto2);
					System.out.println("Informe o numero do prefeito: ");
					int numeroPrefeitoVoto2 = Integer.parseInt(lerDigitado.nextLine());
					Candidato prefeito2 = cartorio.getPrefeito(partidoPrefeitoVoto2);
					Urna urna2 = eleitorVoto2.getSecao().getUrna();
					cartorio.votarParaSegundoTurno(prefeito2, eleitorVoto2, partidoPrefeitoVoto2, urna2, numeroPrefeitoVoto2);
					System.out.println("Voto para prefeito concluído");
				}
				}

				break;

			case 11:
				Candidato prefeitoEleito = cartorio.maiorVotoPrefeito();
				Candidato vereadorEleito = cartorio.maiorVotoVereador();
				int numeroVereadoresVotados = cartorio.numeroTotalDeCandidatosVereadoresVotados();
				int numeroPrefeitoVotados = cartorio.numeroTotalDeCandidatosPrefeitosVotados();
				int numeroDeEleitoresQueVotaramEmPrefeito = cartorio.numeroEleitoresVotaramEmPrefeitos();
				int numeroDeEleitoresQueVotaramEmVereador = cartorio.numeroEleitoresQueVotaramEmVereador();				
			System.out.println(
				"Prefeito eleito :" + prefeitoEleito
						+ "\n Vereador Eleito :" + vereadorEleito
						+ "\n Numero de vereadores votados:" + numeroVereadoresVotados
						+ "\n Numero de prefeitos votados :" + numeroPrefeitoVotados
						+ "\n Numero de eleitores que votaram em prefeitos : " + numeroDeEleitoresQueVotaramEmPrefeito
						+ "\n Numero de eleitores que votaram em vereadores:" + numeroDeEleitoresQueVotaramEmVereador
						+ "\n Numero de zonas cadastradas: "+ cartorio.getZonas().size()
						+ "\n Numero de secoes cadastradas: " + cartorio.getSecoes().size()
						+ "\n Numero de eleitores cadastrados: " + cartorio.getEleitores().size()
						+ "\n Numero de urnas cadastradas: " + cartorio.getUrnas().size());

				break;
				
			case 12:

				cartorio = serialize.carregaFachada("arquivo");
				
				break;
				

			
			}

		}

	}
	
	

}
