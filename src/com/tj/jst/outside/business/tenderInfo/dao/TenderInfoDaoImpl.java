package com.tj.jst.outside.business.tenderInfo.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfoAdd;

/**
 * ��Ͷ��
 * @author hhc
 *
 */
public class TenderInfoDaoImpl extends BaseDao implements ITenderInfoDao {

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
					TenderInfo tenderInfo = new TenderInfo();
					tenderInfo.setTenderNum(rs.getString("tenderNum"));//�б�֪ͨ����
					tenderInfo.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));//�б�����(TBTENDERCLASSDIC)
					tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
					tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));//�б귽ʽ(TBTENDERTYPEDIC)
					tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
					tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));//�б�����
					tenderInfo.setTenderMoney(rs.getString("tenderMoney"));//�б���
					tenderInfo.setPrjSize(rs.getString("prjSize"));//�����ģ
					tenderInfo.setArea(rs.getString("area"));//���(ƽ����)
					tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));//�б����λ����
					tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));//�б����λ��֯��������
					tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));//�б굥λ����
					tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));//�б굥λ��֯��������
					tenderInfo.setConstructorName(rs.getString("constructorName"));//��Ŀ����/�ܼ�����ʦ����
					tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��Ŀ����/�ܼ�����ʦ֤������
					tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
					tenderInfo.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����/�ܼ�����ʦ֤������
					tenderInfo.setCreateDate(rs.getDate("createDate"));
					page.getData().add(tenderInfo);
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

	public List<Construction> queryProjectInfo(String corpCode)
	{
		List<Construction> list = new ArrayList<Construction>();
		try {
			
			String qsql = "select prjNum,prjName from TBPROJECTINFO_S where buildCorpCode=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Construction construction = new Construction();
				construction.setPrjNum(rs.getString("prjNum"));
				construction.setPrjName(rs.getString("prjName"));
				list.add(construction);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	public TenderInfo queryTenderById(String tenderNum)
	{
		TenderInfo tenderInfo = new TenderInfo();
		try {
			
			String qsql = "select * from V_TBTENDERINFO where tenderNum=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, tenderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				tenderInfo.setTenderNum(rs.getString("tenderNum"));//�б�֪ͨ����
				tenderInfo.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));//�б�����(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));//�б귽ʽ(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));//�б�����
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));//�б���
				tenderInfo.setPrjSize(rs.getString("prjSize"));//�����ģ
				tenderInfo.setArea(rs.getString("area"));//���(ƽ����)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));//�б����λ����
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));//�б����λ��֯��������
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));//�б굥λ����
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));//�б굥λ��֯��������
				tenderInfo.setConstructorName(rs.getString("constructorName"));//��Ŀ����/�ܼ�����ʦ����
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setCreateDate(rs.getDate("createDate"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return tenderInfo;
	}
	
	public String add(TenderInfoAdd tenderInfoAdd)
	{
		int i = 0;
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			String sql = "insert into TBTENDERINFO"
					+ "(tenderNum,prjName,prjNum,tenderClassNum,tenderTypeNum,"
					+ "tenderResultDate,tenderMoney,prjSize,area,agencyCorpName,"
					+ "agencyCorpCode,tenderCorpName,tenderCorpCode,constructorName,"
					+ "idCardTypeNum,constructorIdCard,createDate,sectionName,"
					+ "unionCOrpName,unionCorpCode,projectAddress,projectCost,"
					+ "propietorCorpName,propietorCorpCode,ISDELETE,STATE) " 
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,tenderInfoAdd.getTenderNum());//�б�֪ͨ����
			pstmt.setString(2,tenderInfoAdd.getPrjName());//��Ŀ����
			pstmt.setString(3,tenderInfoAdd.getPrjNum());//��Ŀ���
			pstmt.setString(4,tenderInfoAdd.getTenderClassNum());//�б�����(TBTENDERCLASSDIC)
			pstmt.setString(5,tenderInfoAdd.getTenderTypeNum());//�б귽ʽ(TBTENDERTYPEDIC)
			pstmt.setDate(6,tenderInfoAdd.getTenderResultDate());//�б�����
			pstmt.setString(7,tenderInfoAdd.getTenderMoney());//�б���
			pstmt.setString(8,tenderInfoAdd.getPrjSize());//�����ģ(ʩ�����)
			pstmt.setString(9,tenderInfoAdd.getArea());//�������(ƽ����)
			pstmt.setString(10,tenderInfoAdd.getAgencyCorpName());//�б����λ����
			pstmt.setString(11,tenderInfoAdd.getAgencyCorpCode());//�б����λ��֯��������
			pstmt.setString(12,tenderInfoAdd.getTenderCorpName());//�б굥λ����
			pstmt.setString(13,tenderInfoAdd.getTenderCorpCode());//�б굥λ��֯��������
			pstmt.setString(14,tenderInfoAdd.getConstructorName());//��Ŀ��������
			pstmt.setString(15,tenderInfoAdd.getIdCardTypeNum());//��ȫ��������֤������(TBIDCARDTYPEDIC)
			pstmt.setString(16,tenderInfoAdd.getConstructorIdCard());//��Ŀ����֤������
			pstmt.setDate(17,new Date(new java.util.Date().getTime()));//��¼�Ǽ�ʱ��
			pstmt.setString(18,tenderInfoAdd.getSectionName());//�������
			pstmt.setString(19,tenderInfoAdd.getUnionCorpName());//������а���λ����
			pstmt.setString(20,tenderInfoAdd.getUnionCorpCode());//������а���λ��֯����
			pstmt.setString(21,tenderInfoAdd.getProjectAddress());//��Ŀ��ַ
			pstmt.setString(22,tenderInfoAdd.getProjectCost());//�������
			pstmt.setString(23,tenderInfoAdd.getPropietorCorpName());//������λ����
			pstmt.setString(24,tenderInfoAdd.getPropietorCorpCode());//������λס��֯����
			pstmt.setInt(25,0);//ɾ��״̬ 0�������� 1��ɾ��
			pstmt.setInt(26,0);//����״̬ 0δ���� 1�Ѵ��� 2����
			i = pstmt.executeUpdate();
			if(i>0)
			{
				message = "success!";
			}else
			{
				message = "failed!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//�б�����
	public List<DictionaryClass> queryTenderClassNum()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			
			String qsql = "select * from TBTENDERCLASSDIC";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("contracttype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//�б귽ʽ(TBTENDERTYPEDIC)
	public List<DictionaryClass> queryTenderTypeNum()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			
			String qsql = "select * from TBTENDERTYPEDIC";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("tender"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//��ȫ��������֤������(TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNum()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			
			String qsql = "select * from TBIDCARDTYPEDIC";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
}
