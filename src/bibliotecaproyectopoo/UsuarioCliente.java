package bibliotecaproyectopoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class UsuarioCliente {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection usarConexion = null;
    Statement statement = null;
    ConexionABaseDatos conexionBd = new ConexionABaseDatos();   
    
    public void MostrarLibros(){
        LibroConsultas mostrar = new LibroConsultas();
        mostrar.ListaLibros();
    }
    
    public void Registrarse(){
                System.out.println("Ingrese sus datos para completar el registro.");
		Scanner scan = new Scanner(System.in);
		System.out.print("ingrese un login : ");
		String login = scan.nextLine();
		System.out.print("ingrese nueva clave : ");
		String password = scan.nextLine();
		System.out.print("ingrese su nombre : ");
		String nombre = scan.nextLine();
		System.out.print("ingrese su apellido : ");
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
                        System.out.println("Usted se ha registrado exitosamente.");
                        
                    } catch (Exception e) 
                        
                    {
                        System.out.println("No se pudo completar el registro, intente nuevamente.");
                    }                
                
           
        
    }
    
    public Usuario IniciarSesion(){
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
                    System.out.println("::Libros disponibles::");
                    MostrarLibros();
                    
            } else {
 
                  System.out.println("Login o clave incorrecta");
                  
            }
            } catch (Exception error) {

                System.out.println("Ocurrio un error");
                
            }
            return iniciarSesion;
        
    }
    
    
    
}
