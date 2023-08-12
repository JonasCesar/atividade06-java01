
public abstract class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private String cor;
	private float velocMaxima;
	private int qtdRodas;
	private Motor motor;
	
	public Veiculo() {
		this.placa = " ";
		this.marca = " ";
		this.modelo = " "; 
		this.cor = " ";
		this.velocMaxima = 0;
		this.qtdRodas = 0;
		this.motor = new Motor();
	}

	
	
	public Veiculo(String placa, String marca, String modelo, String cor, float velocMaxima, int qtdRodas) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.velocMaxima = velocMaxima;
		this.qtdRodas = qtdRodas;
		this.motor = new Motor();
	}
	
	public Veiculo(String placa, String marca, String modelo, String cor, float velocMaxima, int qtdRodas, int qtdPist, int potencia) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.velocMaxima = velocMaxima;
		this.qtdRodas = qtdRodas;
		this.motor = new Motor(qtdPist, potencia);
	}
	
	public String getPlaca() {
		return placa;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getCor() {
		return cor;
	}

	public float getVelocMaxima() {
		return velocMaxima;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public Motor getMotor() {
		return motor;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public final void setVelocMaxima(float velocMaxima) throws VelocException {
		if(velocMaxima < 80 || velocMaxima > 110) {
			throw new VelocException();
		}
		this.velocMaxima = velocMaxima;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}
	
	public abstract float calcVel(float velocMax);

}
