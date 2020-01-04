package test1;


import java.time.LocalDate;

import prueba1.Empleado;
import prueba1.Lote;
import prueba1.Producto;
import prueba1.Remito;
import prueba1.SistemaStock;
import prueba1.Sucursal;
public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SistemaStock sistema=new SistemaStock();
		
		Producto producto1=new Producto(1,"Producto 1",20.5);
        Producto producto2=new Producto(2,"Producto 2",15.5);
        System.out.println(producto1+"\n"+producto2); 
        try {
			sistema.agregarProducto(producto1.getDescripcion(),producto1.getPrecioUnitario());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        System.out.println(sistema.getProductos().toString());
        Sucursal sucursal1=new Sucursal(1,"direccion 1");
        Sucursal sucursal2=new Sucursal(2,"direccion 2");
		try {
			sistema.agregarSucursal(sucursal1.getDireccion());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Empleado empleado1=new Empleado("Juan","Gomez",11111111,sucursal1);
		Empleado empleado2=new Empleado("Julian","Suarez",22222222,sucursal2);
		System.out.println(empleado1+"\n"+empleado2);
		
		Lote lote1=new Lote(sucursal1, producto1,LocalDate.of(2019, 10, 1),100,100,true);
	    Lote lote2=new Lote(sucursal1,producto2,LocalDate.of(2019,10,1),50,50,true);
	    Lote lote3=new Lote(sucursal1,producto1,LocalDate.of(2019,10,3),40,40,true);
	    Lote lote4=new Lote(sucursal2,producto1,LocalDate.of(2019, 10, 2),80,80,true);
	    Lote lote5=new Lote(sucursal2, producto2,LocalDate.of(2019,10, 2),80,80,true);
	    System.out.println(lote1+"\n"+lote2+"\n"+lote3+"\n"+lote4+"\n"+lote5);
	    
	    sucursal1.getLotes().add(lote1);
	    sucursal1.getLotes().add(lote2);
	    sucursal1.getLotes().add(lote3);
	    sucursal2.getLotes().add(lote4);
	    sucursal2.getLotes().add(lote5);
	    
	    
	    System.out.println("Cantidad: "+sucursal1.traerCantidad(producto1));
	    System.out.println("Validar Stock: "+sucursal1.validarConsumo(producto1, 80));
	 
	    
	    
	    
	    sistema.getSucursales().add(sucursal1);
	    sistema.getSucursales().add(sucursal2);
	    
	    Remito remito1=new Remito(LocalDate.of(2019,10,5),producto1,80,empleado1,"Forma de pago 1");
	    Remito remito2=new Remito(LocalDate.of(2019,10,5).plusDays(1),producto1,80,empleado1,"Forma de pago 1");
	    System.out.println(remito1);
	    System.out.println(remito2);
	    
	    try {
			System.out.println("Remito Generado: "+sistema.generarRemitoDeConsumo(LocalDate.of(2019,10,5),producto1,500,empleado1,"Forma de pago 1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
    try {
		System.out.println("Remito Sucursal: "+sistema.generarRemitoDeConsumo(sucursal1,LocalDate.of(2019,10,5),producto1,500,empleado1,"Forma de pago 1"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	}
	
}