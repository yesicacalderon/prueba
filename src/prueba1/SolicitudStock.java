package prueba1;

import java.time.LocalDate;

public class SolicitudStock extends Comprobante {

	Empleado colaborador;
	private boolean aceptado;
	public SolicitudStock(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, Empleado colaborador,
			boolean aceptado) {
		super(fecha, producto, cantidad, vendedor);
		this.colaborador = colaborador;
		this.aceptado = aceptado;
	}
	public Empleado getColaborador() {
		return colaborador;
	}
	public void setColaborador(Empleado colaborador) {
		this.colaborador = colaborador;
	}
	public boolean isAceptado() {
		return aceptado;
	}
	public void setAceptado(boolean aceptado) {
		this.aceptado = aceptado;
	}
	@Override
	public String toString() {
		return "SolicitudStock [" + (colaborador != null ? "colaborador=" + colaborador + ", " : "") + "aceptado="
				+ aceptado + "]";
	}

	
}
