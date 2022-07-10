package bibliotecaproyectopoo;

public class Usuario {

    private int idUsuario;
    private String login;
    private String pass;
    private String nombre;
    private String apellido;
    
    public Usuario(String login,String pass,String nombre,String apellido){
        this.login=login;
        this.pass=pass;
        this.nombre=nombre;
        this.apellido=apellido;
             
    }
    
    public Usuario(){
        
    }
    
    public String getLogin() {
        return login;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
        
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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
              
    public String getInfoUsuario(){
        return ("Id Usuario : "+idUsuario+"\n"+
                "Login      : "+login+"\n" + 
                "Pass       : "+"****"+"\n"+
                "Nombre     : "+nombre+"\n"+
                "Apellido   : "+apellido+"\n");
    }
         
    
}
