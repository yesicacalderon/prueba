package prueba1;

public class Producto {

	
	private int asdasd;
	private int idProducto;
	private double precioUnitario;
	public Producto(int idProducto, String descripcion, double precioUnitario) {
		super();
		this.idProducto = idProducto;
		this.precioUnitario = precioUnitario;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
//	public String getDescripcion() {
//		return descripcion;
//	}
	
	//jbkjhbj
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	@Override
	public String toString() {
		return "\n"+ "Producto [idProducto=" + idProducto + ", "
			 + "precioUnitario=" + precioUnitario
				+ "]";
	}
	
}
