/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publistore.datos;

/**
 *
 * @author RYZEN
 */
import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

public class Conexion
{
	/* Variables */
	
	long tiempo_inicio = -1;
  	long tiempo_total = 0;
  	
  	private final static String url ="jdbc:mysql://mysql.madarme.co:3306/estudiante_17?serverTimeZone=UTC&autoReconnect=true&useSSL=false";//alojada
	private String usuario="estudiante_17";	
	private String password="Ii0pGTyP3M";
	private final static String driver = "com.mysql.cj.jdbc.Driver";			
	private String error;
		
	// portatil
	
	
	//public String ruta_logs="/var/www/vhosts/sotraexsa.com/httpdocs/ecolsi/clubbioarmonias/logs/logs.html";	
	
	private Connection con;
	private CallableStatement cs;
	private PreparedStatement ps;	
	private ResultSet rst;
	
	/**
	 * Constructor de la clase.
	 */
	public Conexion()
	{		
		super();
	}
	
	public void setusuario(String usuario)
	{
		this.usuario=usuario;		
	}

	public void setclave(String clave)
	{
		this.password=clave;		
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	/**
	 * M�todo que permite realizar una conexi�n con la base de datos.
	 * @param conectaDesde: Clase y m�todo de donde se realiza la conexi�n. 
	 * @return Connection: Objeto con la conexi�n establecida con la base de datos.
	 * @throws java.sql.SQLException
	 */
	public Connection conectar(String conectaDesde) throws java.sql.SQLException
	{						
		try
		{
			Class.forName(driver);
			this.con = DriverManager.getConnection(url,usuario,password);
			//this.escribirLogsCon(conectaDesde);
                        System.out.println("Conexión exitosa desde " + conectaDesde);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("No se pudo conectar");
		}
		return this.con;
	}
	
	/**
	 * M�todo que asigna una conexion.
	 * @param conex: Conecction a asignar
	 */
	public void setConnection (Connection conex)
	{
		this.con= conex;	
	}
	
	/**
	 * M�todo que permite cerrar una conexi�n.
	 */
	public void cerrarConexion()
	{
		
		try
		{		
			if (this.rst!=null) this.rst.close();
			if (this.ps!=null) this.ps.close();
			if (this.cs!=null) this.cs.close();
						
			this.rst= null;
			this.ps= null;
			this.cs=null;
			
			this.con.close();
			this.con=null;
		}
		catch(Exception e)
		{
			
		}
		
	}  		
	
	/**
	 * M�todo que se encarga de escribir lo logs de conexi�n del usuario.
	 
	/* M�todo que permite iniciar el cronometro */
	public void iniciarCronometro()
	{
		tiempo_inicio = System.currentTimeMillis();
		tiempo_total=0;
	}

	/* M�todo que permite detener el cronometro */
	public void detenerCronometro()
	{
		tiempo_total = System.currentTimeMillis() - tiempo_inicio;
	}

	/* M�todo que permite calcular el tiempo total de ejecuci�n para un proceso */
	public long getTiempoTotal()
	{
		return tiempo_total;
	}
	
	public Connection getConnection()
	{
		return this.con;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Conexion))
			return false;
		final Conexion other = (Conexion) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
}