
public final class Carga extends Veiculo implements Calcular {
	
	private int cargaMax;
	private int tara;
	
	public Carga() {
		this.cargaMax = 0;
		this.tara = 0 ;
	}
	
	public Carga(String placa, String marca, String modelo, String cor, 
			float velocMaxima, int qtdRodas, int qtdPist, int potencia, int cargaMax, int tara) {
		super(placa, marca, modelo, cor, velocMaxima, qtdRodas, qtdPist, potencia);
		this.cargaMax = cargaMax;
		this.tara = tara;
	}

	@Override
	public final float calcVel(float velocMax) {
		return velocMax * 100000;
	}

	public final int getCargaMax() {
		return cargaMax;
	}

	public final int getTara() {
		return tara;
	}

	public final void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public final void setTara(int tara) {
		this.tara = tara;
	}
	
	@Override
	public final String toString() {
		
		StringBuilder retorno = new StringBuilder();
		//retorno.append("============= VEÍCULO CARGA ================\n");
		retorno.append("Marca := ").append(getMarca()).append("\n");
		retorno.append("Modelo := ").append(getModelo()).append("\n");
		retorno.append("Placa := ").append(getPlaca()).append("\n");
		retorno.append("Cor := ").append(getCor()).append("\n");
		retorno.append("Velocidade Máxima (km/h) := ").append(getVelocMaxima() + " km/h").append("\n");
		retorno.append("Velocidade Máxima (cm/h) := ").append(String.format("%.2f", calcVel(getVelocMaxima())) + " cm/h").append("\n");
		retorno.append("Quantidade Rodas := ").append(getQtdRodas()).append("\n");
		retorno.append("Quantidade Pistões do Motor := ").append(getMotor().getQtdPist()).append("\n");
		retorno.append("Potência do Motor := ").append(getMotor().getPotencia()).append("\n");
		retorno.append("Carga Máxima := ").append(this.cargaMax).append("\n");
		retorno.append("Tara := ").append(this.tara).append("\n");
		retorno.append("Valor calculado Interface (Soma valores numéricos) := ").append(this.calcular()).append("\n");
		retorno.append("=====================================================");
		
		return retorno.toString();
	}

	@Override
	public final int calcular() {
		int soma = 0;
		
		soma = (int) (getVelocMaxima() + getQtdRodas() + getMotor().getQtdPist() + getMotor().getPotencia() + getCargaMax() + getTara());
		
		return soma;
	}

}
