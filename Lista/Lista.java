package Lista;

import Elemento.Elemento;

public class Lista {
	private Elemento primeiro;
	private Elemento ultimo;
	private int totalDeElementos = 0;

	public Lista(int v) {
		this.primeiro = new Elemento(v);
		ultimo = primeiro;
		this.totalDeElementos++;
	}

	// ================================================================
	public Lista(Lista novaLista) {
		Elemento aux = novaLista.getPrimeiro();
		this.primeiro = aux;
		this.ultimo = aux;

		while (aux != null) {
			aux = aux.getProximo();
			this.append(aux);
			this.ultimo = aux;
		}
	}

	// ================================================================
	public Lista(int[] v) {
		this.primeiro = new Elemento(v[0]);
		this.ultimo = this.primeiro;

		for (int i = 1; i < v.length; i++) {
			this.append(new Elemento(v[i]));
		}
	}

	// ================================================================
	public Elemento getPrimeiro() {
		return this.primeiro;
	}

	public Elemento getUltimo() {
		return this.ultimo;
	}
	// ================================================================

	public void append(Elemento e) {
		this.ultimo.setProximo(e);
		this.ultimo = e;
		totalDeElementos++;
	}

	// ================================================================
	public void preppend(Elemento e) {
		Elemento aux = e;
		aux.setProximo(primeiro);
		this.primeiro = aux;
		totalDeElementos++;
	}

	// ================================================================

	/*
	 * // public void inserirPosicao(int v, int p) { if (p == 0) { // primeira
	 * posição Elemento aux = new Elemento(v); aux.setProximo(primeiro);
	 * this.primeiro = aux; this.totalDeElementos++;
	 * 
	 * } else if (p == totalDeElementos) { // última posiçao Elemento aux = new
	 * Elemento(v); this.ultimo.setProximo(aux); this.ultimo = aux;
	 * this.totalDeElementos++;
	 * 
	 * } else if (p > 0 && p < totalDeElementos) { // Entre primeira e últimaposição
	 * Elemento aux = this.primeiro; for (int i = 0; i <= totalDeElementos; i++) {
	 * if (i == p - 1) { Elemento aux2 = new Elemento(v);
	 * aux2.setProximo(aux.getProximo()); aux.setProximo(aux2);
	 * this.totalDeElementos++; } else { aux = aux.getProximo(); } } } else {
	 * System.out.println("\nA POSIÇÃO INFORMADA NÃO EXISTE\n"); } } //
	 */

	public void inserirPosicao(int v, int p) {
		Elemento aux = this.primeiro;
		for (int i = 0; i < totalDeElementos; i++) {
			if (i == p) {
				aux.setValor(v);
			}
			aux = aux.getProximo();
		}
	}

	// ========================================================================
	public int valorPosicao(int p) { // 2
		Elemento aux = this.primeiro;
		int valor = 0;
		for (int i = 0; i <= totalDeElementos; i++) {
			if (p == i) {
				valor = aux.getValor();
			} else {
				aux = aux.getProximo();
			}
		}
		return valor;
	}
	// ========================================================================

	public void concatenar(Lista lista2) {
		Elemento aux = lista2.getPrimeiro();
		while (aux != null) {
			this.append(aux);
			aux = aux.getProximo();
		}
	}
	// ========================================================================

	public void inserirAposPosicao(int v, int p) {
		p = p + 1;
		if (p == 0) {
			Elemento aux = new Elemento(v);
			aux.setProximo(primeiro);
			this.primeiro = aux;
			this.totalDeElementos++;

		} else if (p == totalDeElementos) {
			Elemento aux = new Elemento(v);
			this.ultimo.setProximo(aux);
			this.ultimo = aux;
			this.totalDeElementos++;

		} else if (p > totalDeElementos && p < totalDeElementos + 2) {
			Elemento aux = new Elemento(v);
			this.ultimo.setProximo(aux);
			this.ultimo = aux;
			this.totalDeElementos++;

		} else if (p > 0 && p < totalDeElementos) {
			Elemento aux = this.primeiro;

			for (int i = 0; i <= totalDeElementos; i++) {

				if (i == p - 1) {
					Elemento aux2 = new Elemento(v);
					aux2.setProximo(aux.getProximo());
					aux.setProximo(aux2);
					this.totalDeElementos++;

				} else {
					aux = aux.getProximo();
				}
			}

		} else {
			System.out.println("\nA POSIÇÃO INFORMADA NÃO EXISTE\n");
		}
	}
	// ========================================================================

	/*
	 * public void inverter() { Elemento proximo = null; Elemento prev = null;
	 * Elemento aux = this.primeiro; while (aux != null) { proximo =
	 * aux.getProximo(); aux.setProximo(prev); prev = aux; aux = proximo; }
	 * this.primeiro = prev; System.out.println("prev: " + prev); }
	 */

	// ========================================================================

	public void remover(int p) {
		if (totalDeElementos == 2 && p == 1) { //
			this.primeiro.setProximo(null);
			this.ultimo = this.primeiro;
			totalDeElementos--;
		}
		if (p == 0) { // primeira posição
			Elemento aux = this.primeiro;
			this.primeiro = this.primeiro.getProximo();
			aux.setProximo(null);
			this.totalDeElementos--;
		}
		if (p == totalDeElementos - 1) { // última posiçao
			Elemento aux = this.primeiro;
			Elemento aux2 = aux.getProximo();

			while (aux.getProximo() != null) {
				aux2 = aux2.getProximo();
				aux = aux.getProximo();

				if (aux2.getProximo() == null) {
					this.ultimo = aux;
					this.ultimo.setProximo(null);
					aux.setProximo(null);
				}
			}
			totalDeElementos--;
		}
		if (p > 0 && p < totalDeElementos) {
			Elemento aux = this.primeiro;
			Elemento aux2 = aux.getProximo();
			Elemento aux3 = aux2.getProximo();
			if (p == 1) {
				aux.setProximo(aux3);
				aux2.setProximo(null);
				totalDeElementos--;
			}
			for (int i = 0;; i++) {
				if (i == p - 1) {
					aux.setProximo(aux3);
					aux2.setProximo(null);
					totalDeElementos--;
					break;
				}
				aux = aux.getProximo();
				aux2 = aux2.getProximo();
				aux3 = aux3.getProximo();
			}
		}
	}

	// ================================================================

	public void esvaziar() {
		this.primeiro = null;
		totalDeElementos = 0;
	}
	// ================================================================

	public int getTamanho() {
		return totalDeElementos;
	}
	// ================================================================

	public boolean pertence(int v) {
		Elemento aux = this.primeiro;
		for (int i = 0; i < totalDeElementos; i++) {
			if (aux.getValor() == v) {
				return true;
			}
		}
		return false;
	}

	// ================================================================

	public void appendArray(int[] v) {
		Elemento aux = this.ultimo;
		for (int i = 0; i < v.length; i++) {
			this.append(new Elemento(v[i]));
			aux = aux.getProximo();
			this.ultimo = aux;
		}
	}
	// ================================================================

	/*
	 * public void prependArray(int[] v) { Elemento aux = this.primeiro; for(int i =
	 * v.length; i == 0; i--) { this.preppend(new Elemento(v[i])); aux =
	 * aux.getProximo(); this.primeiro= aux; } }
	 */

	/*
	 * public void prependArray(int[] v) { //Elemento aux = this.primeiro; for(int i
	 * = v.length; i == 0; i--) { Elemento aux = new Elemento(v[i]);
	 * this.preppend(aux);
	 * 
	 * 
	 * this.primeiro.setProximo(aux); this.primeiro = aux;
	 * 
	 * } }
	 */
	// ================================================================
	public void imprime() {
		Elemento aux = this.primeiro;
		while (aux != null) {
			aux.imprime();
			aux = aux.getProximo();
		}
		System.out.println("-Total de Elementos: " + getTamanho());
		System.out.println("==========================================\n");
	}
}
