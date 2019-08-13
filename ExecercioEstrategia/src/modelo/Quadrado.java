package modelo;

public class Quadrado extends FiguraGeometrica {

	private double lado;
	
	
	public Quadrado ( double lado){
		this.lado= lado;
		
	
	}

	
	public String toString(){
		return "Quadrado - Lado: " + this.lado;
	}
	
	public double calculeArea(){
		return this.lado * this.lado;
	}
}

