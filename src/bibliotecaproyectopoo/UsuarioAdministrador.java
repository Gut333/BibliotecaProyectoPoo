package bibliotecaproyectopoo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UsuarioAdministrador  {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection usarConexion = null;
    Statement statement = null;
    ConexionABaseDatos conexionBd = new ConexionABaseDatos();
       
    public void MostrarClientes(){
        
        try{
            usarConexion = conexionBd.ConectarseABaseDeDatos();
            String clientes = "select * from clientes";
            statement = usarConexion.createStatement();
            resultSet = statement.executeQuery(clientes);
            while (resultSet.next())
            {
                Usuario user = new Usuario();
                user.setIdUsuario(resultSet.getInt(1));
                user.setLogin(resultSet.getString(2));
                user.setPass(resultSet.getString(3));
                user.setNombre(resultSet.getString(4));
                user.setApellido(resultSet.getString(5));              
                System.out.println(user.getInfoUsuario());
            }
                                
        }catch (Exception e) {            
            System.out.println("Error al mostrar Usuarios "+e);           
        }
         
    }
        
    public void AgregarNuevoCliente(){
		Scanner scan = new Scanner(System.in);
		System.out.print("ingrese nuevo login : ");
		String login = scan.nextLine();
		System.out.print("ingrese nueva clave : ");
		String password = scan.nextLine();
		System.out.print("ingrese nombre del nuevo usuario : ");
		String nombre = scan.nextLine();
		System.out.print("ingrese apellido del nuevo usuario : ");
		String apellido = scan.next();               
                Usuario user = new Usuario(login, password, nombre, apellido); 
                try {
			String consulta = "insert into clientes (login, pass, nombre, apellido)values(?,?,?,?)";
			usarConexion = conexionBd.ConectarseABaseDeDatos();
			preparedStatement = usarConexion.prepareStatement(consulta);
			preparedStatement.setObject(1, user.getLogin());
			preparedStatement.setObject(2, user.getPass());
			preparedStatement.setObject(3, user.getNombre());
			preparedStatement.setObject(4, user.getApellido());
			preparedStatement.executeUpdate();                       
                        System.out.println("usuario agregado exitosamente");
                        
                    } catch (Exception e) 
                        
                    {
                        System.out.println("no se puede agregar el usuario");
                    }                
                        
        
    }
           
    public void AgregarNuevoLibro(){
        LibroConsultas agregarLibro = new LibroConsultas();
        agregarLibro.NuevoLibro();
            
    }
    
    public Usuario IniciarSesionAdmin(){
        Usuario iniciarSesion = null;

		Scanner scan = new Scanner(System.in);
		System.out.print("ingrese su login : ");
		String login = scan.nextLine();
		System.out.print("ingrese su clave : ");
		String pass = scan.nextLine();
                
        String consultaBaseDatos = "select * from clientes where login='" + login + "' and pass='" + pass + "'";
        try{
            usarConexion = conexionBd.ConectarseABaseDeDatos();
            statement = usarConexion.createStatement();
            resultSet = statement.executeQuery(consultaBaseDatos);
            
            if(resultSet.next()){
                    Usuario userlogin = new Usuario();
                    userlogin.setIdUsuario(resultSet.getInt(1));
                    userlogin.setLogin(resultSet.getString(2));
                    userlogin.setPass(resultSet.getString(3));
                    userlogin.setNombre(resultSet.getString(4));
                    userlogin.setApellido(resultSet.getString(5));
                    iniciarSesion = userlogin;
                    System.out.println("Inicializando...\n");
                    System.out.println("Seleccione una opcion :\n1)Agregar nuevo cliente \n"
                            +"2)Mostrar clientes \n3)Agregar nuevo libro \n4)salir");
                    int opcion = scan.nextInt();
                    switch (opcion){
                        case 1 : 
                                AgregarNuevoCliente();
                                break;        
                        case 2 :
                                MostrarClientes();
                                break;                                
                        case 3 :
                                AgregarNuevoLibro();
                                break;
                        case 4 :
                                break;
                        
                    }
                    
                                        
            } else {
 
                  System.out.println("Login o clave incorrecta");
                  
            }
            } catch (Exception error) {

                System.out.println("Ocurrio un error");
                
            }
            return iniciarSesion;
        
    }    
    
  
    
}