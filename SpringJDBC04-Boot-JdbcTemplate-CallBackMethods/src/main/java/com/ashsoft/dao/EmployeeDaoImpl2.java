package com.ashsoft.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.ashsoft.bo.EmployeeBO;

//@Repository("empDAO")
public class EmployeeDaoImpl2 implements IEmployeeDao {

	@Autowired
	private JdbcTemplate jt;

	private static final String GET_EMP_BY_ENO = "SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO = ?";
	
	private static final String GET_EMPS_BY_DESG = "SELECT EMPNO,ENAME,JOB, SAL FROM EMP WHERE JOB IN(?,?,?)";
	@Override
	public EmployeeBO getEmployeeByNo(int eno) {

		EmployeeBO ebo = jt.queryForObject(GET_EMP_BY_ENO, (rs, rowNum) -> {

			EmployeeBO bo = new EmployeeBO();

			bo.setEmpNo(rs.getInt("EMPNO"));
			bo.setEname(rs.getString("ENAME"));
			bo.setSal(rs.getFloat("SAL"));
			bo.setJob(rs.getString("JOB"));

			return bo;
		},
				
			eno);
		
		return ebo;

	}

	@Override
	public List<EmployeeBO> getEmployeesByDesgs(String desg1, String desg2, String desg3) {
		
		List<EmployeeBO> list = jt.query(GET_EMPS_BY_DESG, (rs)-> {

			
				
				List<EmployeeBO> listBo = new ArrayList<EmployeeBO>();
				
				while(rs.next())
				{
					EmployeeBO bo = new EmployeeBO();
					bo.setEmpNo(rs.getInt("EMPNO"));
					bo.setEname(rs.getString("ENAME"));
					bo.setJob(rs.getString("JOB"));
					bo.setSal(rs.getFloat("SAL"));
					
					listBo.add(bo);
				}
				
				
				return listBo;
			
			
		}, desg1, desg2, desg3);
		
		return list;
	}

}
