
public class Teste {	
	
	private static Passeio listaPasseio[] = new Passeio[5];
	private static Carga listaCarga[] = new Carga[5];
	
	private static Leitura leitura = new Leitura();

	public static void main(String[] args) {
		
		boolean continua = true;
		int opcao = 0;
		
		while(continua) {
			
			System.out.println("\n=====================================================\n");
			
			System.out.println("Sistema de Gestão de Veículos - Menu Inicial\n");
			
			System.out.println("1. Cadastrar Veículo de Passeio");
			System.out.println("2. Cadastrar Veículo de Carga");
			System.out.println("3. Imprimir todos os Veículos de Passeio ");
			System.out.println("4. Imprimir todos os Veículos de Carga");
			System.out.println("5. Imprimir Veículo de Passeio pela Placa");
			System.out.println("6. Imprimir Veículo de Carga pela Placa");
			System.out.println("7. Sair do Sistema") ;
			
			System.out.println("\n=====================================================");
			
			try {
				opcao = Integer.parseInt(leitura.entDados("Digite uma das opções acima: ")); 				
			} catch (NumberFormatException e) {
				System.out.println("O valor digitado deve ser um número entre 1 e 7");
				leitura.entDados("");
				continue;
			}
			
			switch(opcao) {			
				case 1:
					cadastraNovoVeiculoPorTipo(TipoVeiculo.PASSEIO, listaPasseio);
					break;
				case 2:
					cadastraNovoVeiculoPorTipo(TipoVeiculo.CARGA, listaCarga);
					break;
				case 3:
					imprimeTodosVeiculosPorTipo(TipoVeiculo.PASSEIO, listaPasseio);
					break;
				case 4:
					imprimeTodosVeiculosPorTipo(TipoVeiculo.CARGA, listaCarga);
					break;
				case 5:
					imprimirVeiculoPelaPlaca(TipoVeiculo.PASSEIO, listaPasseio);
					break;
				case 6:
					imprimirVeiculoPelaPlaca(TipoVeiculo.CARGA, listaCarga);
					break;
				case 7:
					System.out.println("Finalizando sistema...");
					System.out.println("Sistema finalizado.");
					continua = false;
					break;
				default:
					System.out.println("\nAtenção: O valor digitado deve ser um número entre 1 e 7");	
					continue;
			}
		}// fim while

	} // fim main
	
	public static void cadastraNovoVeiculoPorTipo(TipoVeiculo tipoVeiculo, Veiculo[] listaVeiculo) {
		String tipo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? "PASSEIO" : "CARGA"; 
		boolean cadastrarNovoVeiculo = true;
		while(cadastrarNovoVeiculo) {
			int i = encontraVagaVeiculo(listaVeiculo);
			if(i != -1) {		
				System.out.println("\n----------- Cadastro de veículo de " + tipo + " ----------\n");
				String placa = leitura.entDados("Placa: ");
				if(encontraPlaca(placa, listaVeiculo)){					
					System.out.println("\nATENÇÃO: Já existe um veículo de " + tipo + " cadastrado com a placa '" + placa + "'.");
					cadastrarNovoVeiculo = false;
				} else {
					
					Veiculo veiculo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? formularioPasseio(placa) : formularioCarga(placa);					
					listaVeiculo[i] = veiculo;
					if(!desejaNovo(tipo)) {
						cadastrarNovoVeiculo = false;
						break;
					}
				}
											
				continue;
			}
			
			leitura.entDados("\nLista de veículos de " + tipo + " está cheia! (Tecle Enter para voltar ao MENU)");
			break;
								
		}
	}
	
	public static boolean desejaNovo(String tipo) {
		String opcao = leitura.entDados("\nDeseja cadastrar novo veiculo de " + tipo + "? (s:SIM / n:NÃO)");
		if(opcao.equalsIgnoreCase("n")){
			return false;
		} else if(opcao.equalsIgnoreCase("s")) {
			return true;
		}
		return desejaNovo(tipo);
	}
	
	
	public static boolean encontraPlaca(String placa, Veiculo listaVeiculo[]) {
		for(Veiculo veiculo : listaVeiculo) {
			if(veiculo != null) {
				if(placa.trim().equals(veiculo.getPlaca()))
					return true;
			}
		}
		return false;
	}
	
	public static int encontraVagaVeiculo(Veiculo listaVeiculo[]) {
		for(int i = 0; i < listaVeiculo.length; i++) {
			if(listaVeiculo[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
	public static Passeio formularioPasseio(String placa) {
		Passeio passeio = new Passeio();		
		passeio.setMarca(leitura.entDados("Marca: "));
		passeio.setModelo(leitura.entDados("Modelo: "));		
		passeio.setPlaca(placa);
		passeio.setCor(leitura.entDados("Cor: "));
		passeio.setVelocMaxima(Float.parseFloat(leitura.entDados("Velocidade Máxima")));
		passeio.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de Rodas: ")));
		passeio.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistões do Motor: ")));
		passeio.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potência do Motor: ")));
		passeio.setQtdPassageiros(Integer.parseInt(leitura.entDados("Quantidade de Passageiros: ")));
		return passeio;
	}
	
	public static Carga formularioCarga(String placa) {
		Carga carga = new Carga();		
		carga.setMarca(leitura.entDados("Marca: "));
		carga.setModelo(leitura.entDados("Modelo: "));				
		carga.setPlaca(placa);
		carga.setCor(leitura.entDados("Cor: "));
		carga.setVelocMaxima(Float.parseFloat(leitura.entDados("Velocidade Máxima")));
		carga.setQtdRodas(Integer.parseInt(leitura.entDados("Quantidade de Rodas: ")));
		carga.getMotor().setQtdPist(Integer.parseInt(leitura.entDados("Quantidade de Pistões do Motor: ")));
		carga.getMotor().setPotencia(Integer.parseInt(leitura.entDados("Potência do Motor: ")));
		carga.setCargaMax(Integer.parseInt(leitura.entDados("Carga Máxima: ")));
		carga.setTara(Integer.parseInt(leitura.entDados("Tara: ")));
		
		return carga;
	}
	
	public static String imprimePasseio(Passeio passeio) {
		return passeio.toString();
	}
	
	public static String imprimeCarga(Carga carga) {
		return carga.toString();
	}
	
	public static void imprimeTodosVeiculosPorTipo(TipoVeiculo tipoVeiculo, Veiculo[] listaVeiculo) {
		String tipo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? "PASSEIO" : "CARGA";
		boolean todosNull = true;
		System.out.println("\nTodos os veículos de " + tipo + ":");
		for (int i = 0; i < listaVeiculo.length; i++) {
			if (listaVeiculo[i] != null) {
				todosNull = false;
				Veiculo veiculo = listaVeiculo[i];
				System.out.println("\nVEÍCULO DE " + tipo + " - [" + i + "]");
				System.out.println();
				System.out.println(veiculo.toString());				
			}
		}
		if (todosNull) {
			System.out.println("\n-> Não há veículos de "+ tipo +" cadastrados.");
		}
	}
	
	public static void imprimirVeiculoPelaPlaca(TipoVeiculo tipoVeiculo, Veiculo[] listaVeiculo) {
		String tipo = TipoVeiculo.PASSEIO.equals(tipoVeiculo) ? "PASSEIO" : "CARGA"; 
		System.out.println("\nImpressão de veículo de " + tipo + " pela placa.");
		String placa = leitura.entDados("\nDigite a placa: ");
		boolean achouPlaca = false;
		for (int i = 0; i < listaVeiculo.length; i++) {
			Veiculo veiculo = listaVeiculo[i];	
			if(veiculo != null && veiculo.getPlaca().equalsIgnoreCase(placa.trim())) {
				System.out.println("---------------------------------");
				System.out.println("\nVEÍCULO DE " + tipo + " COM A PLACA '" + placa + "':\n");
				System.out.println(veiculo.toString());
				achouPlaca = true;
			}
		}
		if(!achouPlaca) {
			System.out.println("\n-> Não há nenhum veículo de " + tipo + " cadastrado com a placa '" + placa + "'.");
		}
	}

}

