package com.tj.jst.outside.business.corpReport.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.outside.business.corpReport.model.CorpReport;

/**
 * ������ҵͳ�Ʊ���
 * @author hhc
 *
 */
public class CorpReportDaoImpl extends BaseDao implements ICorpReportDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	/**
	 * ��ѯ
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) {
					CorpReport corpReport = new CorpReport();
					
					corpReport.setId(rs.getString("id"));//����
					corpReport.setCorpCode(rs.getString("CorpCode"));//��ҵ��֯��������
					corpReport.setCorpName(rs.getString("CorpName"));//��ҵ����
					corpReport.setProvinceNum(rs.getString("ProvinceNum")); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
					corpReport.setCityNum(rs.getString("CityNum")); 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
					corpReport.setCountyNum(rs.getString("CountyNum")); 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
					corpReport.setReportYear(rs.getString("ReportYear"));//��
					corpReport.setQuarter(rs.getString("Quarter"));//����
					corpReport.setSignContract(rs.getString("SignContract"));//ǩ����ͬ��
					corpReport.setLastYearContract(rs.getString("LastYearContract"));//�����ת��ͬ��
					corpReport.setThisYearContract(rs.getString("ThisYearContract"));//������ǩ��ͬ��
					corpReport.setTotalOutput(rs.getString("TotalOutput"));//����ҵ�ܲ�ֵ
					corpReport.setProvinceOutside(rs.getString("ProvinceOutside"));//ʡ��
					corpReport.setAbroad(rs.getString("Abroad"));//����
					corpReport.setConstruction(rs.getString("Construction"));//��������
					corpReport.setErection(rs.getString("Erection"));//��װ����
					corpReport.setDecorate(rs.getString("Decorate"));//װ��װ�޹���
					corpReport.setSettlementIncome(rs.getString("SettlementIncome"));//���̽�������
					corpReport.setSettlementCost(rs.getString("SettlementCost"));//���̽���ɱ�
					corpReport.setAddedValue(rs.getString("AddedValue"));//����ֵ
					corpReport.setReward(rs.getString("Reward"));//��ҵ��Ա�Ͷ�����
					corpReport.setTotalProfit(rs.getString("TotalProfit"));//��˰�ܶ�
					corpReport.setProfit(rs.getString("Profit"));//�����ܶ�
					corpReport.setEmployee(rs.getString("Employee"));//��ҵ��Ա
					corpReport.setRegistered(rs.getString("Registered"));//ע�Ὠ��ʦ
					corpReport.setUltimate(rs.getString("Ultimate"));//�м�����ְ����Ա
					corpReport.setPost(rs.getString("Post"));//��֤��λ��Ա
					corpReport.setTechnology(rs.getString("Technology"));//�м����ϼ�������
					corpReport.setTechnicalEquipment(rs.getString("TechnicalEquipment"));//����װ����
					corpReport.setLaborProduction(rs.getString("LaborProduction"));//�Ͷ�����
					corpReport.setLegalMan(rs.getString("LegalMan")); 		//��λ������
					corpReport.setFillOut(rs.getString("FillOut"));//�����
					corpReport.setLinkPhone(rs.getString("LinkPhone"));//��ϵ�绰
					corpReport.setCreateDate(rs.getDate("CreateDate")); 		//�������
					page.getData().add(corpReport);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ���
	 * @param corpReport
	 * @return
	 */
	public void add(CorpReport corpReport)
	{
		String id = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into CORP_REPORT(id,corpCode,corpName,provinceNum,"
					+ "cityNum,"
					+ "countyNum,reportYear,quarter,signContract,lastYearContract,"
					+ "thisYearContract,"
					+ "totalOutput,provinceOutside,abroad,construction,erection,"
					+ "decorate,"
					+ "settlementIncome,settlementCost,addedValue,reward,totalProfit,"
					+ "profit,employee,registered,"
					+ "ultimate,post,technology,technicalEquipment,laborProduction,"
					+ "legalMan,fillOut,linkPhone,createDate) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);	//����
			pstmt.setString(2,corpReport.getCorpCode());//��ҵ��֯��������
			pstmt.setString(3,corpReport.getCorpName());//��ҵ����
			pstmt.setString(4,corpReport.getProvinceNum()); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corpReport.getCityNum()); 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corpReport.getCountyNum()); 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7,corpReport.getReportYear());//��
			pstmt.setString(8,corpReport.getQuarter());//����
			pstmt.setString(9,corpReport.getSignContract());//ǩ����ͬ��
			pstmt.setString(10,corpReport.getLastYearContract());//�����ת��ͬ��
			pstmt.setString(11,corpReport.getThisYearContract());//������ǩ��ͬ��
			pstmt.setString(12,corpReport.getTotalOutput());//����ҵ�ܲ�ֵ
			pstmt.setString(13,corpReport.getProvinceOutside());//ʡ��
			pstmt.setString(14,corpReport.getAbroad());//����
			pstmt.setString(15,corpReport.getConstruction());//��������
			pstmt.setString(16,corpReport.getErection());//��װ����
			pstmt.setString(17,corpReport.getDecorate());//װ��װ�޹���
			pstmt.setString(18,corpReport.getSettlementIncome());//���̽�������
			pstmt.setString(19,corpReport.getSettlementCost());//���̽���ɱ�
			pstmt.setString(20,corpReport.getAddedValue());//����ֵ
			pstmt.setString(21,corpReport.getReward());//��ҵ��Ա�Ͷ�����
			pstmt.setString(22,corpReport.getTotalProfit());//��˰�ܶ�
			pstmt.setString(23,corpReport.getProfit());//�����ܶ�
			pstmt.setString(24,corpReport.getEmployee());//��ҵ��Ա
			pstmt.setString(25,corpReport.getRegistered());//ע�Ὠ��ʦ
			pstmt.setString(26,corpReport.getUltimate());//�м�����ְ����Ա
			pstmt.setString(27,corpReport.getPost());//��֤��λ��Ա
			pstmt.setString(28,corpReport.getTechnology());//�м����ϼ�������
			pstmt.setString(29,corpReport.getTechnicalEquipment());//����װ����
			pstmt.setString(30,corpReport.getLaborProduction());//�Ͷ�����
			pstmt.setString(31,corpReport.getLegalMan()); 		//��λ������
			pstmt.setString(32,corpReport.getFillOut());//�����
			pstmt.setString(33,corpReport.getLinkPhone());//��ϵ�绰
			pstmt.setDate(34, new Date(new java.util.Date().getTime()));//��¼�Ǽ�ʱ��
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ��ѯ��������
	 * @param corpReport
	 * @return
	 */
	public CorpReport queryById(String id)
	{

		CorpReport corpReport = new CorpReport();
		try {
			
			String qsql = "select * from CORP_REPORT where id=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				corpReport.setId(rs.getString("id"));//����
				corpReport.setCorpCode(rs.getString("CorpCode"));//��ҵ��֯��������
				corpReport.setCorpName(rs.getString("CorpName"));//��ҵ����
				corpReport.setProvinceNum(rs.getString("ProvinceNum")); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				corpReport.setCityNum(rs.getString("CityNum")); 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				corpReport.setCountyNum(rs.getString("CountyNum")); 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				corpReport.setReportYear(rs.getString("ReportYear"));//��
				corpReport.setQuarter(rs.getString("Quarter"));//����
				corpReport.setSignContract(rs.getString("SignContract"));//ǩ����ͬ��
				corpReport.setLastYearContract(rs.getString("LastYearContract"));//�����ת��ͬ��
				corpReport.setThisYearContract(rs.getString("ThisYearContract"));//������ǩ��ͬ��
				corpReport.setTotalOutput(rs.getString("TotalOutput"));//����ҵ�ܲ�ֵ
				corpReport.setProvinceOutside(rs.getString("ProvinceOutside"));//ʡ��
				corpReport.setAbroad(rs.getString("Abroad"));//����
				corpReport.setConstruction(rs.getString("Construction"));//��������
				corpReport.setErection(rs.getString("Erection"));//��װ����
				corpReport.setDecorate(rs.getString("Decorate"));//װ��װ�޹���
				corpReport.setSettlementIncome(rs.getString("SettlementIncome"));//���̽�������
				corpReport.setSettlementCost(rs.getString("SettlementCost"));//���̽���ɱ�
				corpReport.setAddedValue(rs.getString("AddedValue"));//����ֵ
				corpReport.setReward(rs.getString("Reward"));//��ҵ��Ա�Ͷ�����
				corpReport.setTotalProfit(rs.getString("TotalProfit"));//��˰�ܶ�
				corpReport.setProfit(rs.getString("Profit"));//�����ܶ�
				corpReport.setEmployee(rs.getString("Employee"));//��ҵ��Ա
				corpReport.setRegistered(rs.getString("Registered"));//ע�Ὠ��ʦ
				corpReport.setUltimate(rs.getString("Ultimate"));//�м�����ְ����Ա
				corpReport.setPost(rs.getString("Post"));//��֤��λ��Ա
				corpReport.setTechnology(rs.getString("Technology"));//�м����ϼ�������
				corpReport.setTechnicalEquipment(rs.getString("TechnicalEquipment"));//����װ����
				corpReport.setLaborProduction(rs.getString("LaborProduction"));//�Ͷ�����
				corpReport.setLegalMan(rs.getString("LegalMan")); 		//��λ������
				corpReport.setFillOut(rs.getString("FillOut"));//�����
				corpReport.setLinkPhone(rs.getString("LinkPhone"));//��ϵ�绰
				corpReport.setCreateDate(rs.getDate("CreateDate")); 		//�������
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corpReport;
	}
	
	/**
	 * �޸�
	 * @param corpReport
	 * @return
	 */
	public void modify(CorpReport corpReport)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update CORP_REPORT set corpCode=?,corpName=?,provinceNum=?,"
					+ "cityNum=?,"
					+ "countyNum=?,reportYear=?,quarter=?,signContract=?,lastYearContract=?,"
					+ "thisYearContract=?,"
					+ "totalOutput=?,provinceOutside=?,abroad=?,construction=?,erection=?,"
					+ "decorate=?,"
					+ "settlementIncome=?,settlementCost=?,addedValue=?,reward=?,totalProfit=?,"
					+ "profit=?,employee=?,registered=?,"
					+ "ultimate=?,post=?,technology=?,technicalEquipment=?,laborProduction=?,"
					+ "legalMan=?,fillOut=?,linkPhone=? where id=?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,corpReport.getCorpCode());//��ҵ��֯��������
			pstmt.setString(2,corpReport.getCorpName());//��ҵ����
			pstmt.setString(3,corpReport.getProvinceNum()); //ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(4,corpReport.getCityNum()); 		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corpReport.getCountyNum()); 		//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corpReport.getReportYear());//��
			pstmt.setString(7,corpReport.getQuarter());//����
			pstmt.setString(8,corpReport.getSignContract());//ǩ����ͬ��
			pstmt.setString(9,corpReport.getLastYearContract());//�����ת��ͬ��
			pstmt.setString(10,corpReport.getThisYearContract());//������ǩ��ͬ��
			pstmt.setString(11,corpReport.getTotalOutput());//����ҵ�ܲ�ֵ
			pstmt.setString(12,corpReport.getProvinceOutside());//ʡ��
			pstmt.setString(13,corpReport.getAbroad());//����
			pstmt.setString(14,corpReport.getConstruction());//��������
			pstmt.setString(15,corpReport.getErection());//��װ����
			pstmt.setString(16,corpReport.getDecorate());//װ��װ�޹���
			pstmt.setString(17,corpReport.getSettlementIncome());//���̽�������
			pstmt.setString(18,corpReport.getSettlementCost());//���̽���ɱ�
			pstmt.setString(19,corpReport.getAddedValue());//����ֵ
			pstmt.setString(20,corpReport.getReward());//��ҵ��Ա�Ͷ�����
			pstmt.setString(21,corpReport.getTotalProfit());//��˰�ܶ�
			pstmt.setString(22,corpReport.getProfit());//�����ܶ�
			pstmt.setString(23,corpReport.getEmployee());//��ҵ��Ա
			pstmt.setString(24,corpReport.getRegistered());//ע�Ὠ��ʦ
			pstmt.setString(25,corpReport.getUltimate());//�м�����ְ����Ա
			pstmt.setString(26,corpReport.getPost());//��֤��λ��Ա
			pstmt.setString(27,corpReport.getTechnology());//�м����ϼ�������
			pstmt.setString(28,corpReport.getTechnicalEquipment());//����װ����
			pstmt.setString(29,corpReport.getLaborProduction());//�Ͷ�����
			pstmt.setString(30,corpReport.getLegalMan()); 		//��λ������
			pstmt.setString(31,corpReport.getFillOut());//�����
			pstmt.setString(32,corpReport.getLinkPhone());//��ϵ�绰
			pstmt.setString(33,corpReport.getId());	//����
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from CORP_REPORT where id=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//����
			pstmt.executeUpdate();
			
			conn.commit();
			
		} catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}
	
}
