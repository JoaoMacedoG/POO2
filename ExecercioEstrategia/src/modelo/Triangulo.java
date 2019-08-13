package modelo;

public class Triangulo extends FiguraGeometrica {
	
	private double base;
	private double altura;
	
	public Triangulo ( double base, double altura){
		this.base= base;
		this.altura = altura;
		
	}

	
	public String toString(){
		return "Triangulo - Base: " + this.base + " \n Altura:"+ this.altura;
	}
	
	public double calculeArea(){
		return this.base * this.altura /2;
	}
}
