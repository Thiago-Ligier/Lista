package AppMain;

import java.util.Random;

import Elemento.Elemento;
import Lista.Lista;

public class Appmain {

	public static int gerarNumero() {
		Random rand = new Random();
		int limite = 100;
		int int_random = rand.nextInt(limite);
		return int_random;
	}

	public static void main(String[] args) {
		//=============================================================================================
		
		Lista lista = new Lista(1);

		for (int i = 0; i <= 3; i++) {
			lista.append(new Elemento(gerarNumero()));
		}

		System.out.println("2.1 Lista(int v) \n");
		lista.imprime();
		//=============================================================================================

		System.out.println("2.2 Lista(Lista lista) \n");
		Lista novaLista = new Lista(lista);
		novaLista.imprime();
		//=============================================================================================

		System.out.println("2.3 Lista(int [] v)  \n");
		int vetor[] = new int[10];
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = gerarNumero();
		}
		Lista vetorLista = new Lista(vetor);
		vetorLista.imprime();
		//=============================================================================================

		System.out.println("3.1 append() \n");
		lista.append(new Elemento(gerarNumero()));
		lista.imprime();
		//=============================================================================================

		System.out.println("3.2 prepend() \n");
		lista.preppend(new Elemento(gerarNumero()));
		lista.imprime();
		//=============================================================================================

		System.out.println("3.3 inserirPosicao(int v, int p) \n");
		lista.inserirPosicao(10, 0);
		lista.imprime();
		// =============================================================================================
		
		System.out.println("3.4 valorPosicao(int p) \n");
		int valorPosicao = lista.valorPosicao(2);
		System.out.println("Posição Consultada: 2 \nValor da Posição consultada: " + valorPosicao);
		System.out.println("==========================================\n");
		// =============================================================================================
		
		System.out.println("3.5 concatenar(Lista lista) \n");
		Lista lista2 = new Lista(33);
		lista2.append(new Elemento(44));
		lista2.append(new Elemento(55));
		lista2.append(new Elemento(66));

		lista.concatenar(lista2);
		lista.imprime();
		
		// =============================================================================================
		System.out.println("3.6 inserirAposposicao(int v, int p) \n");
		lista.inserirAposPosicao(10, 0);
		lista.imprime();
		// =============================================================================================
		
		/*
		 * System.out.println("3.7 inverter() \n"); lista.inverter(); lista.imprime();
		 */
		// =============================================================================================
		
		System.out.println("3.9 remover(int p) \n");
		lista.remover(11);
		lista.imprime();
		// =============================================================================================
		
		System.out.println("3.13 getTamanho() \n");
		int t = lista.getTamanho();
		System.out.println("Total de Elementos: " + t);
		System.out.println("==========================================\n");
		// =============================================================================================
		
		System.out.println("3.15 pertence(int p) \n");
		boolean p = lista.pertence(0);
		System.out.println("Pertence ou não pertence? " + p);
		System.out.println("==========================================\n");
		// =============================================================================================
		
		System.out.println("3.16 appendArray(int[] v) \n");
		int vetorAppend[] = new int[10];
		for (int i = 0; i < vetorAppend.length; i++) {
			vetorAppend[i] = gerarNumero();
			System.out.println("v: " + vetorAppend[i]);
		}
		System.out.println("\n");
		lista.appendArray(vetorAppend);
		lista.imprime();
		// =============================================================================================
		
		/*
		 * System.out.println("3.17 prependArray(int[] v) \n"); int vetorPrepend[] = new
		 * int[10]; for (int i = 0; i < vetorAppend.length; i++) { vetorAppend[i] =
		 * gerarNumero(); System.out.println("v: " + vetorPrepend[i]); }
		 * System.out.println("\n"); lista.appendArray(vetorPrepend); lista.imprime();
		 */
		// =============================================================================================
		
		System.out.println("3.10 esvaziar() \n");
		lista.esvaziar();
		lista.imprime();
		// =============================================================================================
		
	}
}
