package prueba1;

public class Empleado {

	private String nombre;
	private String apellido;
	private long dni;
	Sucursal sucursal;
	public Empleado(String nombre, String apellido, long dni, Sucursal sucursal) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.sucursal = sucursal;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	@Override
	public String toString() {
		return "Empleado [" + (nombre != null ? "nombre=" + nombre + ", " : "")
				+ (apellido != null ? "apellido=" + apellido + ", " : "") + "dni=" + dni + ", "
				+ (sucursal != null ? "sucursal=" + sucursal : "") + "]";
	}
	
}
