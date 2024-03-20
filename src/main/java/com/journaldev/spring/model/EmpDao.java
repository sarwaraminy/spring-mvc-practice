package com.journaldev.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.journaldev.spring.model.Emp;
    
public class EmpDao { 
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	// insert data into database
	public int save(Emp p) {
		String sql="insert into Emp99(name,salary,designation) values('"+p.getName()+"','"+p.getSalary()+"','"+p.getDesignation()+"')";
		return template.update(sql);
	}
	
	// update records in database based on ID
	public int update(Emp p) {
		String sql="update Emp99 set name='"+p.getName()+"',salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId();
		return template.update(sql);
	}
	
	// delete a record from database
	public int delete(int id) {
		String sql = "delete from Emp99 where id="+id;
		return template.update(sql);
	}
	
	// retrieve data from database based on id
	public Emp getEmpById(int id) {
		String sql="select * from Emp99 where id=?";
		return template.queryForObject(sql, new Object[] {id},new BeanPropertyRowMapper<Emp>(Emp.class));
	}
	
	//
	public List<Emp> getEmployees(){
		return template.query("select * from Emp99", new RowMapper<Emp>(){
			public Emp mapRow(ResultSet rs, int row) throws SQLException{
				Emp e = new Emp();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}
}
