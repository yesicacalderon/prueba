package prueba1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sucursal {

	private int idSucursal;
	private  String direccion;
	private List<Empleado> empleados=new ArrayList<Empleado>();
	private List<Lote>lotes=new ArrayList<Lote>();
	
	public Sucursal(int idSucursal, String direccion) {
		super();
		this.idSucursal = idSucursal;
		this.direccion = direccion;
		
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}


	@Override
	public String toString() {
		return "Sucursal [idSucursal=" + idSucursal + ", " + (direccion != null ? "direccion=" + direccion : "") + "]";
	}

	public Empleado traerEmpleado(long dni) {
		Empleado emp=null;
		int i=0;
		
		while (i<empleados.size()) {
		if(empleados.get(i).getDni()==dni) {
			
			emp=empleados.get(i);
			
		}
		i++;
		}
		return emp;
	}
	
	
	public boolean agregarEmpleado(String nombre, String apellido, long dni) {
		
		return  empleados.add(new Empleado(nombre,apellido,dni,this));
		
	}
	
	public boolean agregarLote(Producto producto, LocalDate fechaAlta, int cantidadInicial) {
		
		return lotes.add(new Lote(this,producto,fechaAlta,cantidadInicial,cantidadInicial,true));
		
	}
	
	public List<Lote> traerLotesActivos (Producto producto){
		
		List <Lote> lote=new ArrayList<Lote>();
		int i=0;
		
		while(i<lotes.size()) {
			if(lotes.get(i).getProducto().equals(producto)&&lotes.get(i).isActivo()) {
				
				lote.add(lotes.get(i));
			}
			i++;
		}
		
		return lote;
	}
	
	public int traerCantidad(Producto producto) {
		int cant=0;
		int i=0;
		
		while(i<lotes.size()) {
			if(lotes.get(i).getProducto().equals(producto)) {
				
				cant=cant+lotes.get(i).getCantidadActual();
			}
			
			i++;
		}
		
		return cant;
	}
	
	public boolean validarConsumo(Producto producto, int cantidad) {
		boolean validar=false;
		int i=0;
		
		while(i<lotes.size()) {
			if(lotes.get(i).getProducto().equals(producto)) {
				if(lotes.get(i).getCantidadActual()>=cantidad) {
					
				validar=true;	
				}
			}
			i++;
		}
		return validar;
	}
}
