/*  Importat Biblioteca de SQL completa por comodidad */
import java.sql.*;

public class Contacto {
  // usar variable llamada link para manejar la conexion}.
  private conectate link;
  
  // En el constructor definimos la tabla con la caual se quiere trabajar.
  public persona (_tbl){
    link = new conectate(_tbl);
  } 
  
  /* Para Añade un nuevo registro a la TABLA de MYQL */

   public void NuevoContacto(String nomfull, String dir,String email, String movil, String fijo, String giro){
      /* se usa un try ya que pueden salir exepciones y esto es para manejarlos
        y poder terminar lasacciones y tambn podemos determionar en que punto
        Nuestro programa comienza a bugearse. */
       try {            
       /* Para la insercion usamos "?" como comodin ya que desconocemos
          lo que el usuario quiera asignar */
            PreparedStatement pstm = con.getConnection().prepareStatement("INSERT INTO " + 
                    "contactos(NOMBRE, DIRECCION, EMAIL, MOVIL, FIJO, GIRO) " +
                    " values(?,?,?,?,?,?)");
        /* Ya que se coloca la instruccion de mysql solo indicamos
            con el umero de la posicion del comodin el calor que queremos insertar */
            pstm.setString(1, nomfull);
            pstm.setString(2, dir);
            pstm.setString(3, email);                        
            pstm.setString(4, movil);
            pstm.setString(5, fijo);                        
            pstm.setString(6, giro);    
            // ejecutar la sentencia y cerrar la consulta
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
  /* Jamas esta de mas poner una funcion para actualizar los datos de los contactos existentes
     para que con ello no se dupliqeun las entradas
  */
     public void ActualizarContacto(String id, String nomfull, String dir, String email, String movil, String fijo, String giro){
       try {            
            PreparedStatement pstm = con.getConnection().prepareStatement("UPDATE contactos " +
            "set NOMBRE = ? ," +
            "DIRECCION = ? ," +
            "EMAIL = ? ," +                    
            "MOVIL = ? " +                    
            "FIJO = ? " +
            "GIRO = ? " +                    
            "where id = ? ");            
            pstm.setString(1, nomfull);                   
            pstm.setString(2, dir);
            pstm.setString(3, email);
            pstm.setString(4, movil);
            pstm.setString(5, fijo);
            pstm.setString(6, movil);
            pstm.setString(7, String.valueOf(id));
            // Ejecutamos la instruccion y cerramos la conexion.
            pstm.execute();
            pstm.close();            
         }catch(SQLException e){
         System.out.println(e);
      }
   }
   
   /**  Si decemos borrar un registro solo se indica el "id" para que no 
        sea afectado algun registro que comparta el mismo datos **/ 
        
   public void deletePersona(String ide){  
            try {                
            // Prepara la sentencia con el "ide" que se quiere eliminar 
                PreparedStatement pstm = link.getConnection().prepareStatement("DELETE FROM contactos where ID = ?");            
                pstm.setString(1, ide);                   
            // Ejecutamos y cerramos la conxion que se establece con el obj "pstm"
                pstm.execute();
                pstm.close();            
            }catch(SQLException e){
            System.out.println(e);
            }            
   }

 /** obtenemos todos los datos de la tabla y */
 public Object [][] getDatos(){
      int reg = 0;
      //obtenemos la cantidad de registros existentes en la tabla
      try{         
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT count(1) as total FROM contactos ");
         ResultSet res = pstm.executeQuery();
         // Usamos "next" para listar si hay mas de un registro en la tabla
          res.next();
         reg = res.getInt("total");
         res.close();
      }catch(SQLException e){
         System.out.println(e);
      }
      
    Object[][] data = new String[reg][7];  
    //realizamos la consulta sql y llenamos los datos en "Object"
      try{    
         PreparedStatement pstm = con.getConnection().prepareStatement("SELECT " +
              " ID, NOMBRE, DIRECCION, EMAIL, MOVIL, FIJO, GIRO " +
            " FROM contactos" +
            " ORDER BY ID ");
         ResultSet res = pstm.executeQuery();
         int i = 0;
         //usamos un "while" para ordenar los registros
         while(res.next()){
            String stID = res.getString("ID");
            String stNAME = res.getString("NOMBRE");
            String stDIR = res.getString("DIRECCION");
            String stEMAIL = res.getString("EMAIL");
            String stMOVIL = res.getString("MOVIL");
            String stFIJO = res.getString("FIJO");
            String stGIRO = res.getString("GIRO");
            data[i][0] = stID;            
            data[i][1] = stNAME;            
            data[i][2] = stDIR;            
            data[i][3] = stEMAIL;            
            data[i][4] = stMOVIL;
            data[i][5] = stFIJO;
            data[i][6] = stGIRO;
            i++;
         }
         res.close();
          }catch(SQLException e){
         System.out.println(e);
    }
    return data;
 }    
}
