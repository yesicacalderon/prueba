package prueba1;

import java.time.LocalDate;

public class Remito extends Comprobante {

	private String formaDePago;

	public Remito(LocalDate fecha, Producto producto, int cantidad, Empleado vendedor, String formaDePago) {
		super(fecha, producto, cantidad, vendedor);
		this.formaDePago = formaDePago;
	}



	public String getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(String formaDePago) {
		this.formaDePago = formaDePago;
	}

	@Override
	public String toString() {
		return "\n"+"Remito [" + (formaDePago != null ? "formaDePago=" + formaDePago + " " : "")+"\n"
				+ (fecha != null ? "fecha=" + fecha + " " : "")
				+ (producto != null ?  producto + ", " : "")+"\n" + "cantidad=" + cantidad + ", "
				+ (vendedor != null ? "vendedor=" + vendedor : "") + "]";
	}

	
	
}
