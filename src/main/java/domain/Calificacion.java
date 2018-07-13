package domain;

public interface Calificacion<T> {
	Boolean estaAprobada();
	T getNota();
}
