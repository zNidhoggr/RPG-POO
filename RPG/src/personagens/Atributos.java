package personagens;

public class Atributos {
	private float forca, agilidade, inteligencia;
	
	public Atributos(float forca, float agilidade, float inteligencia){
		this.setForca(forca);
		this.setAgilidade(agilidade);
		this.setInteligencia(inteligencia);
	}

	public float getForca() {
		return forca;
	}

	public void setForca(float forca) {
		this.forca = forca;
	}

	public float getAgilidade() {
		return agilidade;
	}

	public void setAgilidade(float agilidade) {
		this.agilidade = agilidade;
	}

	public float getInteligencia() {
		return inteligencia;
	}

	public void setInteligencia(float inteligencia) {
		this.inteligencia = inteligencia;
	}
	
	
}