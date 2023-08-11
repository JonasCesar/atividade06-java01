
public final class Passeio extends Veiculo implements Calcular {
	
	private int qtdPassageiros;
	
	public Passeio() {
		this.qtdPassageiros = 0;
	}
	
	public Passeio(String placa, String marca, String modelo, String cor, float velocMaxima, int qtdRodas, int qtdPist, int potencia, int qtdPassageiros) {
		super(placa, marca, modelo, cor, velocMaxima, qtdRodas, qtdPist, potencia);
		this.qtdPassageiros = qtdPassageiros;
	}

	public final int getQtdPassageiros() {
		return qtdPassageiros;
	}

	public final void setQtdPassageiros(int qtdPassageiros) {
		this.qtdPassageiros = qtdPassageiros;
	}

	@Override
	public final float calcVel(float velocMax) {
		return velocMax * 1000;
	}
	
	@Override
	public final String toString() {
		
		StringBuilder retorno = new StringBuilder();
		//retorno.append("============= VEÍCULO PASSEIO ==============\n");
		retorno.append("Marca := ").append(getMarca()).append("\n");
		retorno.append("Modelo := ").append(getModelo()).append("\n");
		retorno.append("Placa := ").append(getPlaca()).append("\n");
		retorno.append("Cor := ").append(getCor()).append("\n");
		retorno.append("Velocidade Máxima (km/h) := ").append(getVelocMaxima() + " km/h").append("\n");
		retorno.append("Velocidade Máxima (m/h) := ").append(String.format("%.2f", calcVel(getVelocMaxima())) + " m/h").append("\n");
		retorno.append("Quantidade Rodas := ").append(getQtdRodas()).append("\n");
		retorno.append("Quantidade Pistões do Motor := ").append(getMotor().getQtdPist()).append("\n");
		retorno.append("Potência do Motor := ").append(getMotor().getPotencia()).append("\n");
		retorno.append("Quantidade de Passageiros := ").append(this.qtdPassageiros).append("\n");
		retorno.append("Valor calculado Interface (Soma Qtd caracteres) := ").append(this.calcular()).append("\n");
		retorno.append("=====================================================");
		
		return retorno.toString();
	}

	@Override
	public int calcular() {
		return getMarca().length() + getModelo().length() + getPlaca().length() + getCor().length();
	}

}
