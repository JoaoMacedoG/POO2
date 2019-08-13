package modelo;

import java.util.ArrayList;
import java.util.List;

public class Mosaico {

//	private List<Triangulo> triangulos;
//	private List<Quadrado> quadrados;
//	private List<Circulo> circulos;
	
	private List<FiguraGeometrica> figuras;
	
	
	public Mosaico(){
//		this.triangulos =  new ArrayList<Triangulo>();
//		this.quadrados =  new ArrayList<Quadrado>();
//		this.circulos =  new ArrayList<Circulo>();
		this.figuras =  new ArrayList<FiguraGeometrica>();
	}
	
//	public void insereTriangulo( Triangulo triangulo){
////		this.triangulos.add(triangulo);
//		this.figuras.add(triangulo);
//	}
//	
//	public void insereQuadrado(Quadrado quadrado){
//		//this.quadrados.add(quadrado);
//		this.figuras.add(quadrado);
//	}
//	
//	public void insereCirculo(Circulo circulo){
//		//this.circulos.add(circulo);
//		this.figuras.add(circulo);
//	}
	public void insereFiguraGoemetrica(FiguraGeometrica figura){
	//this.circulos.add(circulo);
	this.figuras.add(figura);
}
//	
	public String toString(){
		String resultado = "";
		for(FiguraGeometrica figura : this.figuras)
			resultado= resultado + figura.toString() + "\n";
//		for( Object figura : this.figuras)
//			resultado= resultado + figura.toString() + "\n";
////		for(Triangulo triangulo: this.triangulos)
////			resultado =  resultado + triangulo.toString() + "\n";
////		for(Quadrado quadrado: this.quadrados)
////			resultado =  resultado + quadrado.toString() + "\n";
////		for(Circulo circulo : this.circulos)
////			resultado =  resultado + circulo.toString() + "\n";
		return resultado;
	}
	
	public double calculeArea(){
		double area= 0;
		for(FiguraGeometrica figura : this.figuras){
			area= area + figura.calculeArea();
		}
//		for(Object figura : this.figuras){
//			if (figura instanceof Triangulo)
//				area = area + ((Triangulo) figura).calculeArea();
//			if (figura instanceof Quadrado)
//				area = area + ((Quadrado) figura).calculeArea();
//			if (figura instanceof Circulo)
//				area = area + ((Circulo) figura).calculeArea();
//		}
//		for(Triangulo triangulo: this.triangulos)
//			area =  area + triangulo.calcularArea();
//		for(Quadrado quadrado: this.quadrados)
//			area =  area + quadrado.calcularArea();
//		for(Circulo circulo : this.circulos)
//			area =  area + circulo.calculeArea();
		return area;
		
	}
	
	public int quantidadeFiguras(){
		return this.figuras.size();
	}
	
	public FiguraGeometrica retornaFiguraDaPosicao(int pos){
		return this.figuras.get(pos);
	}
}
