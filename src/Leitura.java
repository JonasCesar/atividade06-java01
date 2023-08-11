import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leitura {
	
	public String entDados(String rotulo) {
		
		System.out.println(rotulo);
		InputStreamReader tec = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(tec);
		
		String retorno = "";
		
		try {
			retorno = buff.readLine();
		} catch (IOException exception) {
			System.out.println("\n Erro de sistema: " + exception.getMessage());
		}
		
		return retorno;
		
	}

}
