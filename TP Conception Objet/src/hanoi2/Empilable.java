package hanoi2;
// Pour l'instant on reste toujours avec la version non generique de Comparable

interface Empilable<T> extends Comparable<T> {
	void init(int a);
}
