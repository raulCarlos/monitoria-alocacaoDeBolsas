package br.com.unb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unb.entity.Departament;
import br.com.unb.entity.Offer;
import br.com.unb.factory.HSQLConnectionFactory;

public class DAOOffer {

	private Connection conn = HSQLConnectionFactory.getInstance().getConnection();
	
	public List<Offer> getOfferByDepartment(Departament departament) throws SQLException{
		List<Offer> list = new ArrayList<Offer>();
		
		String sql = "SELECT OFERTA.CD_OFERTA, OFERTA.NR_ANO_SEMESTRE, OFERTA.NR_ALUNOS, OFERTA.NR_BOLSA, "
					+ "DISCIPLINA.IN_OBRIGATORIA, DISCIPLINA.CD_DISCIPLINA FROM OFERTA "
					+ "INNER JOIN DISCIPLINA ON OFERTA.CD_DISCIPLINA = DISCIPLINA.CD_DISCIPLINA "
					+ "WHERE DISCIPLINA.CD_DEPARTAMENTO = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, departament.getIdDepartament());
		ResultSet rs = pstmt.executeQuery();
		
		Offer of;
		while(rs.next()){
			of = new Offer();
			of.setId(rs.getInt("CD_OFERTA"));
			of.setIdSubject(rs.getInt("CD_DISCIPLINA"));
			of.setHalfYear(rs.getString("NR_ANO_SEMESTRE"));
			of.setStudentsAmount(rs.getInt("NR_ALUNOS"));
			of.setScholarShip(rs.getInt("NR_BOLSA"));
			if(rs.getString("IN_OBRIGATORIA").equals("1")){
				of.setIsMandatory(true);
			}else{
				of.setIsMandatory(false);
			}
			list.add(of);
		}
		return list;
	}
	
	public void updateOffer(Offer off) throws SQLException{
		String sql = "UPDATE OFERTA SET NR_BOLSA = ? WHERE CD_OFERTA = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, off.getScholarShip());
		pstmt.setInt(2, off.getId());
		pstmt.execute();
	}
	
	public List<Offer> getOffersList() throws SQLException{
		List<Offer> list = new ArrayList<Offer>();
		String sql = "SELECT OFERTA.CD_OFERTA, OFERTA.NR_ANO_SEMESTRE, OFERTA.NR_ALUNOS, OFERTA.NR_BOLSA, "
					+ "DISCIPLINA.IN_OBRIGATORIA, DISCIPLINA.NM_DISCIPLINA, DEPARTAMENTO.DS_DEPARTAMENTO "
					+ "FROM OFERTA INNER JOIN DISCIPLINA ON OFERTA.CD_DISCIPLINA = DISCIPLINA.CD_DISCIPLINA "
					+ "INNER JOIN DEPARTAMENTO ON DISCIPLINA.CD_DEPARTAMENTO = DEPARTAMENTO.CD_DEPARTAMENTO";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		Offer of;
		Departament dep;
		while(rs.next()){
			of = new Offer();
			of.setId(rs.getInt("CD_OFERTA"));
			of.setSubjectName(rs.getString("NM_DISCIPLINA"));
			of.setHalfYear(rs.getString("NR_ANO_SEMESTRE"));
			of.setStudentsAmount(rs.getInt("NR_ALUNOS"));
			of.setScholarShip(rs.getInt("NR_BOLSA"));
			if(rs.getString("IN_OBRIGATORIA").equals("1")){
				of.setMandatoryLabel("SIM");
			}else{
				of.setMandatoryLabel("NÃO");
			}
			
			dep = new Departament();
			dep.setNameDepartament(rs.getString("DS_DEPARTAMENTO"));
			of.setDepartament(dep);
			
			list.add(of);
		}
		return list;
	}
}
