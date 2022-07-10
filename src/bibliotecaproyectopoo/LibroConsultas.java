
package bibliotecaproyectopoo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class LibroConsultas {
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    Connection usarConexion = null;
    Statement statement = null;
    ConexionABaseDatos conexionBd = new ConexionABaseDatos();
    
    public void NuevoLibro (){
                Scanner scan = new Scanner(System.in);
                System.out.println("Ingrese Titulo del libro :");
                String tituloLibro = scan.nextLine();
                System.out.println("Ingrese Autor del libro :");
                String autorLibro = scan.nextLine();
                System.out.println("Ingresa cantidad de paginas :");
                int cantidadPaginas = scan.nextInt();
                System.out.println("Ingrese estado del libro: 1)disponible 2)no diponible");
                int estadoLibro = scan.nextInt();
                Libro lib = new Libro(tituloLibro,autorLibro,cantidadPaginas,estadoLibro);
        
                try{
                    String tablaLibros = "insert into libros(titulo,autor,paginas,estado)values(?,?,?,?)";
                    usarConexion = conexionBd.ConectarseABaseDeDatos();
                    preparedStatement = usarConexion.prepareStatement(tablaLibros);
                    preparedStatement.setObject(1, lib.getTitulo());
                    preparedStatement.setObject(2, lib.getAutor());
                    preparedStatement.setObject(3, lib.getPaginas());
                    preparedStatement.setObject(4, lib.getEstado());
                    preparedStatement.executeUpdate();
                    System.out.println("Libro agregado correctamente");
                } catch (Exception e){
                    System.out.println("No se pudo agregar libro");
                }
               
        
    }
    
    public void ListaLibros(){
        try{
            usarConexion = conexionBd.ConectarseABaseDeDatos();
            String libros = "select * from libros";
            statement = usarConexion.createStatement();
            resultSet = statement.executeQuery(libros);
            while (resultSet.next())
            {
                Libro libro = new Libro();
                libro.setIdLibro(resultSet.getInt(1));
                libro.setTitulo(resultSet.getString(2));
                libro.setAutor(resultSet.getString(3));
                libro.setEstado(resultSet.getInt(4));
                System.out.println(libro.getInfoLibro());
                
            }            
            
        }catch (Exception e){
            System.out.println("Error al mostrar Libros" + e);
        }
        
    }
    
}
