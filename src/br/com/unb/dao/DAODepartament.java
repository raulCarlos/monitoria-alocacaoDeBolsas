package br.com.unb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unb.entity.Departament;
import br.com.unb.factory.HSQLConnectionFactory;

public class DAODepartament {

	private Connection conn = HSQLConnectionFactory.getInstance().getConnection();
	
	public List<Departament> getDepartamentList() throws SQLException{
		String sql = "SELECT * FROM DEPARTAMENTO ORDER BY CD_DEPARTAMENTO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs= pstmt.executeQuery();
		
		List<Departament> list = new ArrayList<Departament>();
		Departament dep;
		while(rs.next()){
			dep = new Departament();
			dep.setIdDepartament(rs.getInt("CD_DEPARTAMENTO"));
			dep.setNameDepartament(rs.getString("DS_DEPARTAMENTO"));
			list.add(dep);
		}
		return list;
	}
	
}
