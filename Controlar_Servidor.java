public void Controlar_Servidor {
  private String bd = "Agenda";
  private String login = "root";
  private String password = "";
  private String url = "jdbc:mysql://localhost/";

   private Connection link = null;

   /** El constructor "inicializa" tanto objetos como varialbes a usar en GUI **/
   public conectate(String _bd) {
      try{
        /** Si usamos diversas tablas mandr su nombre como parametro para 
            Trabajar en ellas y asi se asigna **/
         url = url+_bd;
         // LLamamos el Driver a usar "MysqJDBClDrive-5.1.12-bin.jar".
         Class.forName("com.mysql.jdbc.Driver");
         // Asignamos el bool de la conexion a una Valrialbe Bautizada "link".
         link = DriverManager.getConnection(url,login,password);
         // Comprobar por alguin error alñ obtener la conexion.
         if (link != null){
            System.out.println("Base de Datos /"+_bd+"/. lista =)");
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
      return link;
   }

   public void desconectar(){
      link = null;
      System.out.println("La conexion a la  base de datos "+bd+" a terminado");
   }
   }
