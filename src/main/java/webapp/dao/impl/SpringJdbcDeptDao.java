package webapp.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import webapp.dao.DeptDao;
import webapp.model.Dept;
import webapp.model.Emp;

public class SpringJdbcDeptDao implements DeptDao {
	DataSource dataSoure;
	static Logger log = Logger.getLogger(SpringJdbcDeptDao.class);
	@Override
	public void setDataSouce(DataSource ds) {
		dataSoure=ds;
	}
	
	@Override
	public Dept selectByDeptno(Integer deptno) {
		log.info("###########################");
		log.info("selectByDeptno("+ deptno +")");
		log.info("###########################");
		
		JdbcTemplate template = new JdbcTemplate(dataSoure);
		Dept dept = template.queryForObject(SELECT_BY_DEPTNO,new BeanPropertyRowMapper<Dept>(Dept.class), deptno); // NULL로들어감 try catch에서처리
		return dept;
	}
	
	class DeptResultSetExtractor implements ResultSetExtractor<Dept>{
		/*
		 *  매핑처리
		 */ 
		 
		@Override
		public Dept extractData(ResultSet rs) throws SQLException,
				DataAccessException {
			Dept dept = null;
			List<Emp> emps= null;
			while(rs.next()){
				if(dept==null){
					dept = new Dept();
					dept.setDeptno(rs.getInt("deptno"));
					dept.setDname(rs.getString("dname"));
					dept.setLoc(rs.getString("loc"));
					emps = new ArrayList<Emp>();
				}
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getFloat("sal"));
				emp.setComm(rs.getFloat("comm"));
				
				emps.add(emp);
			}
			if(dept!=null)
				dept.setEmps(emps);
			
			
			return dept;
		}
		
	}
	
	@Override
	public Dept selectByDeptnoWithEmps(Integer deptno){
		log.info("###########################");
		log.info("selectByDeptnoWithEmps("+ deptno +")");
		log.info("###########################");
		
		JdbcTemplate template = new JdbcTemplate(dataSoure);
		
		DeptResultSetExtractor rse = new DeptResultSetExtractor();
		Dept dept = template.query(SELECT_BY_DEPTNO_WITH_EMPS, new Object[] {deptno}, rse);
		
		return dept;
	}

	@Override
	public List<Dept> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> selectWithEmps() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
