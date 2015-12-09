package Actividad5;

public class Libro {

	private int isbn;
	private String titulo;
	private String editorial;
	private int paginas;
	private String autor;
	private int copias;
	
	public Libro() {
		super();
	}

	public Libro(int isbn, String titulo, String editorial, int paginas,
			String autor, int copias) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.paginas = paginas;
		this.autor = autor;
		this.copias = copias;
	}
	
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getCopias() {
		return copias;
	}
	public void setCopias(int copias) {
		this.copias = copias;
	}
	
	
}
