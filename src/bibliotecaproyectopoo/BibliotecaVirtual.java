package bibliotecaproyectopoo;
import java.util.Scanner;
public class BibliotecaVirtual {      
    public BibliotecaVirtual(){
       
    }
    
       
    public void IniciarSistema(){           
        System.out.println("::BIENVENIDOS::");
        System.out.println("Seleccione una opcion : \n");
        System.out.println("1)Para ingresar con una cuenta \n2)Para registrarse \n"
                + "3)Para ingresar como administrador");
        UsuarioCliente userClient = new UsuarioCliente();
        UsuarioAdministrador userAdmin = new UsuarioAdministrador();
        Scanner scan = new Scanner(System.in);
        int opcion = scan.nextInt();    
        switch (opcion){
            case 1:                        
                    userClient.IniciarSesion();
                    break;
            case 2: 
                    userClient.Registrarse();
                    break;
            
            case 3:
                    userAdmin.IniciarSesionAdmin();
                    break;
                                               
            default:
                    break;
        }
                       
    }
    
   
}


