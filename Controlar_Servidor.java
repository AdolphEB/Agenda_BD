public void Controlar_Servidor {
  String bd = "Agenda";
  String login = "root";
  String password = "";
  String url = "jdbc:mysql://localhost/"+bd;

   Connection link = null;

   /** Constructor de la clase donde inicia todos los componentes
        Tanto Variables como Parametros **/
   public conectate() {
      try{
         //obtenemos el driver para mysql
         Class.forName("com.mysql.jdbc.Driver");
         //obtenemos la conexión
         link = DriverManager.getConnection(url,login,password);
         // comparar que no sea nula la conexion
         if (link != null){
            System.out.println("Conección a base de datos "+bd+". listo");
         }
      }catch(SQLException e){
      // muestra el error generado de sql mientras intenta conectar al servidor
         System.out.println(e);
      }catch(ClassNotFoundException e){
      // Muestra los errores generados por el driver o por el manejo de.
      // Class.forName.
         System.out.println(e);
      }
   }
   /**Permite retornar la conexión*/
   public Connection getConnection(){
      return conn;
   }

   public void desconectar(){
      conn = null;
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }
   }
