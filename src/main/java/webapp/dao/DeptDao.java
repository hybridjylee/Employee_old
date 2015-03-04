package webapp.dao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import webapp.model.Dept;

public interface DeptDao {
	final static String SELECT_BY_DEPTNO = "Select * from dept where deptno=?";
	final static String SELECT_BY_DEPTNO_WITH_EMPS  = "select * from dept d left join emp e on d.deptno = e.deptno	where d.deptno = ?";
	public void setDataSouce(DataSource ds);
	/*
	 * Single row by primary key
	 */
	public Dept selectByDeptno(Integer deptno); //Dept 정보만 가져올수있음
	public Dept selectByDeptnoWithEmps(Integer deptno);
	
	/*
	 * Multiple row
	 */
	public List<Dept> selectAll(); 
	public List<Dept> selectWithEmps(); //emps 포함한 정보를 가져옴
	
}
