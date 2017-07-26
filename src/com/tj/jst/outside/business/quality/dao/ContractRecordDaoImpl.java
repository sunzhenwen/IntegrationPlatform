package com.tj.jst.outside.business.quality.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.quality.model.ContractCorpQual;
import com.tj.jst.outside.business.quality.model.ContractRecord;
public class ContractRecordDaoImpl  extends BaseDao implements ContractRecordDao{

	@Override
	public Page pageContractRecordQuery(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while (rs.next()) 
				{
					ContractRecord contractRecord = new ContractRecord();
					contractRecord.setRECORDNUM(rs.getString("RECORDNUM"));//��ͬ�������
					contractRecord.setCONTRACTTYPENUM(rs.getString("CONTRACTTYPENUM"));//��ͬ���
					contractRecord.setCONTRACTTYPENAME(rs.getString("CONTRACTTYPENAME"));//��ͬ�������
					contractRecord.setTENDERNUM(rs.getString("TENDERNUM"));//�б�֪ͨ����
					contractRecord.setSECTIONNAME(rs.getString("SECTIONNAME"));//�������
					
					contractRecord.setCONTRACTMONEY(rs.getString("CONTRACTMONEY"));//�������
					contractRecord.setPROJECTADDRESS(rs.getString("PROJECTADDRESS"));//���̵�ַ
					contractRecord.setPROJECTCOST(rs.getString("PROJECTCOST"));//�������
					contractRecord.setAREA(rs.getString("AREA"));//�������
					contractRecord.setPRJNUM(rs.getString("PRJNUM"));//��Ŀ���
					contractRecord.setPRJNAME(rs.getString("PRJNAME"));//��Ŀ����
					contractRecord.setBUILDCORPNAME(rs.getString("BUILDCORPNAME"));//���赥λ����
					contractRecord.setCONTRACTORCORPNAME(rs.getString("CONTRACTORCORPNAME"));//�а���λ����
					contractRecord.setCONTRACTORCORPCODE(rs.getString("CONTRACTORCORPCODE"));//�а���λ��֯��������
					contractRecord.setBDATE(rs.getString("BDATE"));//�ƻ���������
					contractRecord.setEDATE(rs.getString("EDATE"));//�ƻ�������������
					
					contractRecord.setTITLELEVE(rs.getString("TITLELEVE"));//�ȼ�
					contractRecord.setCONSTRUCTORNAME(rs.getString("CONSTRUCTORNAME"));//��Ŀ����
					contractRecord.setPHONE(rs.getString("PHONE"));//�绰
					
					contractRecord.setPROJECTMANAGER(rs.getString("PROJECTMANAGER"));//���赥λ��Ŀ������
					contractRecord.setUNITPHONE(rs.getString("UNITPHONE"));//���赥λ��ϵ�绰

					contractRecord.setQUALITYCERTNUM(rs.getString("QUALITYCERTNUM"));
					contractRecord.setREPRESENTATIVECERTNUM(rs.getString("REPRESENTATIVECERTNUM"));
					
					//quality.setAppDate(rs.getDate("appDate"));//����ʱ��
					//quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					page.getData().add(contractRecord);
				}
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	@Override
	public Page pagedContractCorpQualQuery(Condition condition) {
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try 
		{
			if(rs!=null)
			{
				while (rs.next()) 
				{
					ContractCorpQual contractCorpQual = new ContractCorpQual();
					contractCorpQual.setPRJNUM(rs.getString("PRJNUM"));//��Ŀ���
					contractCorpQual.setPRJNAME(rs.getString("PRJNAME"));//��Ŀ����
					contractCorpQual.setSECTIONNAME(rs.getString("SECTIONNAME"));//�������
					
					contractCorpQual.setRECORDNUM(rs.getString("RECORDNUM"));//��ͬ�������
					contractCorpQual.setCONTRACTTYPENUM(rs.getString("CONTRACTTYPENUM"));//��ͬ���
					contractCorpQual.setCONTRACTTYPENAME(rs.getString("CONTRACTTYPENAME"));//��ͬ�������
					contractCorpQual.setCONTRACTORCORPNAME(rs.getString("CONTRACTORCORPNAME"));//�а���λ����
					contractCorpQual.setCONTRACTORCORPCODE(rs.getString("CONTRACTORCORPCODE"));//�а���λ��֯����
					contractCorpQual.setCONSTRUCTORNAME(rs.getString("CONSTRUCTORNAME"));//��Ŀ��������
					contractCorpQual.setTITLELEVE(rs.getString("TITLELEVE"));//���ʵȼ�
					contractCorpQual.setPHONE(rs.getString("PHONE"));//��ϵ�绰
					contractCorpQual.setQUALIFICATIONSTYPE(rs.getString("QUALIFICATIONSTYPE"));//�����ʸ�����
					contractCorpQual.setQUALIFICATIONSTYPENAME(rs.getString("QUALIFICATIONSTYPENAME"));//�����ʸ���������
					contractCorpQual.setSPECIALTYTYPE(rs.getString("SPECIALTYTYPE"));//רҵ���
					contractCorpQual.setSPECIALTYTYPENAME(rs.getString("SPECIALTYTYPENAME"));//רҵ�������
					contractCorpQual.setRATING(rs.getString("RATING"));//�����ʸ�ȼ�
					contractCorpQual.setRATINGNAME(rs.getString("RATINGNAME"));//�����ʸ�ȼ�����
					//quality.setAppDate(rs.getDate("appDate"));//����ʱ��
					//quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					page.getData().add(contractCorpQual);
				}
			}
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

}
