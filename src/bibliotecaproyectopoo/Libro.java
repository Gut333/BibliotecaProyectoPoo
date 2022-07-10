
package bibliotecaproyectopoo;


public class Libro {
    private int idLibro;
    private String titulo;
    private String autor;
    private int paginas;
    private int estado;
    
    public Libro(String titulo,String autor,int paginas,int estado){
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.estado = estado;           
    }
 
    public Libro(){
        titulo = "";
        autor = "";
        
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
     
    public String getInfoLibro(){
        return ("Id Libro : "+idLibro+"\n"+
                "Titulo   : "+titulo+"\n" + 
                "Autor    : "+autor+"\n");
    }
    
    
}
