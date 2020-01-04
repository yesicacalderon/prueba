package prueba1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaStock {

	private List<Producto>productos=new ArrayList<Producto>();
	private List<Comprobante>comprobantes= new ArrayList<Comprobante>();
	private List<Sucursal>sucursales=new ArrayList<Sucursal>();
	public SistemaStock() {
		super();
		
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public List<Comprobante> getComprobantes() {
		return comprobantes;
	}
	public void setComprobantes(List<Comprobante> comprobantes) {
		this.comprobantes = comprobantes;
	}
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
	
	public Producto traerProducto(String descripcion) {
		Producto traer=null;
		int i=0;
		while (i<productos.size()) {
			if(productos.get(i).getDescripcion().contentEquals(descripcion)) {
				
				traer=productos.get(i);
			}
			i++;
		}
		return traer;
	}
	
	@Override
	public String toString() {
		return "\n"+"SistemaStock [" + (productos != null ? "productos=" + productos + ", " : "")
				+ (comprobantes != null ? "comprobantes=" + comprobantes + ", " : "")
				+ (sucursales != null ? "sucursales=" + sucursales : "") + "]";
	}
	public boolean agregarProducto(String descripcion, double precioUnitario)throws Exception {
		int largo=0;
		if(traerProducto(descripcion)==null) {
			if(!this.getProductos().isEmpty()) {
				largo=productos.get(productos.size()-1).getIdProducto()+1;
				
				}else {
				
				largo++;
				
			}
			
		}else {
			
			throw new Exception ("Ya existe");
		}
		
		return productos.add(new Producto(largo,descripcion,precioUnitario));
		
		
	}
	
	public Sucursal traerSucursal(String direccion) {
		Sucursal traerS=null;
		int i=0;
		
		while (i<sucursales.size()) {
			if(sucursales.get(i).getDireccion().equalsIgnoreCase(direccion)) {
				traerS=sucursales.get(i);	
			}
			i++;
		}
		return traerS;
	}
	public boolean agregarSucursal(String direccion) throws Exception{
		int i=0;
		if(traerSucursal(direccion)==null) {		
		if(sucursales.size()>0) {	
		i=sucursales.get(sucursales.size()-1).getIdSucursal()+1;
		}else {
			
			i++;
		}	
		}else{
			throw new Exception("Ya existe sucursal");}
		
		return sucursales.add(new Sucursal(i,direccion));
	}
	public Sucursal traerSucursal(int idSucursal) {
		Sucursal traerS=null;
		int i=0;
		
		while (i<sucursales.size()) {
			if(sucursales.get(i).getIdSucursal()==idSucursal) {
				traerS=sucursales.get(i);	
			}
			i++;
		}
		return traerS;
}
	
	public Producto traerProducto(int idProducto) {
		Producto traer=null;
		int i=0;
		
		while(i<productos.size()) {
			if(productos.get(i).getIdProducto()==idProducto) {
				traer=productos.get(i);
			}
			i++;	
		}
		return traer;
	}
	
	public List<Sucursal> validarConsumo(Producto producto, int cantidad){
		List<Sucursal> lista=new ArrayList<Sucursal>();
		int i=0;
		while(i<sucursales.size())
			for(int y=0;y<sucursales.get(i).getLotes().size();y++) {
				if(sucursales.get(i).getLotes().get(y).getProducto().equals(producto)) {
					
					
				}
			}
			
		return lista;
		}
		
	public Remito generarRemitoDeConsumo(LocalDate fecha,Producto producto,int cantidad,Empleado vendedor,String formaDePago)throws Exception {
		int i=0;
		int y=0;
		Remito remito=null;
		Lote lote=null;
		while(i<sucursales.size()&& remito==null) {
		while (y<sucursales.get(i).getLotes().size()&& remito==null) {
		lote=sucursales.get(i).getLotes().get(y);
			if(lote.getProducto().getIdProducto()==producto.getIdProducto()) {
				if(lote.getCantidadActual()>cantidad) {
				remito=new Remito(fecha,producto,cantidad,vendedor,formaDePago);
				
				}	
			}
			y++;
		}
		i++;
		}
		if(remito==null)throw new Exception("No hay cantidad disponible");
			
	return remito;	
	}
	
	public Remito generarRemitoDeConsumo(Sucursal sucursal,LocalDate fecha,Producto producto,int cantidad,Empleado vendedor,String formaDePago)throws Exception {
		int i=0;
		Remito remito=null;
		Sucursal sucursal1=null;
		while(i<sucursales.size()&& remito==null) {
		sucursal1=sucursales.get(i);
			if(sucursal1.getIdSucursal()==sucursal.getIdSucursal()){
		{
				remito=new Remito(fecha,producto,cantidad,vendedor,formaDePago);
				
				}
		}
		i++;
		}
		if(remito==null)throw new Exception("No existe sucursal");
			
	return remito;	
		
	}	
	
	
}
