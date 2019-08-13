package modelo;

public class Circulo extends FiguraGeometrica {
	
	private double raio;
	
	public Circulo (double raio){
		this.raio= raio;
	}
	
	public String toString(){
		return "Circulo - Raio: " + this.raio;
	}

	public double calculeArea(){
		return Math.PI * this.raio *this.raio;
	}
}
