package webapp.util;

import java.sql.Connection;

import javax.sql.DataSource;

public class GlobalVars {
	
	public static ThreadLocal<Connection> con = new ThreadLocal<Connection>();  //jdbc 에서 사용하기 위해서
	public static DataSource ds;				//Spring 에서 사용하기 위해서

}
