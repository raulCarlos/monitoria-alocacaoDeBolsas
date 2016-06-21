package br.com.unb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unb.entity.Departament;
import br.com.unb.entity.ScholarShip;
import br.com.unb.factory.HSQLConnectionFactory;

public class DAOScholarShip {

	private Connection conn = HSQLConnectionFactory.getInstance().getConnection();
	
	public ScholarShip getScholarShipByDepartment(Departament departament) throws SQLException{
		String sql = "SELECT * FROM DEFINICAO_BOLSAS WHERE CD_DEPARTAMENTO= ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, departament.getIdDepartament());
		ResultSet rs = pstmt.executeQuery();
		
		ScholarShip ship = null;
		while(rs.next()){
			ship = new ScholarShip();
			ship.setIdScholarShip(rs.getInt("CD_DEFINICAO_BOLSAS"));
			ship.setAmount(rs.getInt("NR_BOLSA"));
			ship.setHalfYear(rs.getString("NR_ANO_SEMESTRE"));
		}
		return ship;
	}
	
	public void updateScholarShipByDepartament(ScholarShip ship, Departament departament) throws SQLException{
		String sql = "UPDATE DEFINICAO_BOLSAS SET NR_BOLSA = ? WHERE CD_DEFINICAO_BOLSAS= ? AND CD_DEPARTAMENTO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, ship.getAmount());
		pstmt.setInt(2, ship.getIdScholarShip());
		pstmt.setInt(3, departament.getIdDepartament());
		pstmt.execute();
	}
	
	public ScholarShip getSSNumber(int value){
		ScholarShip ssn = new ScholarShip();
		ssn.setAmount(value);
		return ssn;
	}
	
	public List<ScholarShip> getAllScholarShip() throws SQLException{
		String sql = "SELECT DEFINICAO_BOLSAS.NR_BOLSA, DEFINICAO_BOLSAS.NR_ANO_SEMESTRE, DEPARTAMENTO.DS_DEPARTAMENTO "
				+ "FROM DEFINICAO_BOLSAS "
				+ "INNER JOIN DEPARTAMENTO ON DEFINICAO_BOLSAS.CD_DEPARTAMENTO = DEPARTAMENTO.CD_DEPARTAMENTO "
				+ "ORDER BY NR_ANO_SEMESTRE DESC";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<ScholarShip> list = new ArrayList<ScholarShip>();
		ScholarShip ship;
		Departament dep;
		while(rs.next()){
			ship= new ScholarShip();
			ship.setAmount(rs.getInt("NR_BOLSA"));
			ship.setHalfYear(rs.getString("NR_ANO_SEMESTRE"));
			
			dep = new Departament();
			dep.setNameDepartament(rs.getString("DS_DEPARTAMENTO"));
			ship.setDepartament(dep);
			list.add(ship);
		}
		return list;
	}
	
}
