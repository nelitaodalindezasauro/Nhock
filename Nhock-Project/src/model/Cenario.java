package model;

import util.Util;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Responsabilidade da Classe: Controla opera��es exclusivas do cen�rio.
 */
public class Cenario {

	/*
	 * Constantes, cada constante representa um elemento do cen�rio
	*/
	static int VAZIO = 0;
	static int MURO = 1;

	//A Matriz � um vetor bidimensional que armazena todos os blocos da tela do jogador.
	private int[][] matriz;

	//A semente � a comida do Nhock. Ela � representada por um ponto.
	private Ponto semente;

	public Cenario(){
		//Cria cen�rio b�sico.
		//Cada n�mero representa alguma coisa na Matriz
		//O n�mero 1 � uma parede
		//O n�mero zero � casa vazia.
		this.matriz = new int[][]{
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};

		this.sorteiaSemente();
	}

	/**
	 * Verifica se um detrminado ponto no cen�rio � um muro.
	 */
	public boolean ehMuro(Ponto p){
		int valueOfMatrix = this.matriz[p.getY()][p.getX()];
		return valueOfMatrix == Cenario.MURO;
	}

	/**
	 * Verifica se um determinado ponto do cen�rio � uma semente
	 */
	public boolean ehSemente(Ponto p){
		return this.semente.equals(p);
	}

	/**
	 * Desenha o cen�rio de acordo com a matriz.
	 * Cada n�mero da matriz � representado por um quadrado.
	 */
	public void desenha(Graphics g) {
		g.setColor(new Color(60, 60, 200)); //pincel � preto
		for(int i = 0; i < this.matriz.length; i++ ){
			for(int j = 0; j < this.matriz[i].length; j++){
				if(this.matriz[i][j] == Cenario.MURO){
					g.fillRect(j*Config.TAMANHO, i*Config.TAMANHO, Config.TAMANHO, Config.TAMANHO); //Pinta todos os muros
				}
			}
		}
		//Desenha semente
		g.setColor(Color.green); //pincel � vermelho
		g.fillRect(this.semente.getX()*Config.TAMANHO, this.semente.getY()*Config.TAMANHO, Config.TAMANHO, Config.TAMANHO);
	}

	public void sorteiaSemente() {
		do {
			this.semente = new Ponto(Util.random(this.matriz[0].length-1),Util.random(this.matriz.length-1));
		}while(this.ehMuro(this.semente)); //Enquanto o ponto sorteado for muro, continua sorteando.
	}
}
