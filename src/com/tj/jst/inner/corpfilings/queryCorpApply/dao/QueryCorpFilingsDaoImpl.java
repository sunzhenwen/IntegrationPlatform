package com.tj.jst.inner.corpfilings.queryCorpApply.dao;

import java.sql.Connection;
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
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����������ѯ
 * @author Administrator
 *
 */
public class QueryCorpFilingsDaoImpl extends BaseDao implements IQueryCorpFilingsDao {

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
						Corp corp = new Corp();
						
						corp.setCorpId(rs.getString("corpId"));		//����	
						corp.setCorpName(rs.getString("corpName"));	//��ҵ����
						corp.setCorpCode(rs.getString("corpCode")); 	//��֯��������
						corp.setLicenseNum(rs.getString("licenseNum"));//����Ӫҵִ��ע���
						corp.setProvinceNum(rs.getString("provinceNum"));//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
						corp.setCityNum(rs.getString("cityNum"));		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
						corp.setCountyNum(rs.getString("countyNum"));	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
						corp.setAddress(rs.getString("address"));		//��ҵӪҵ��ַ
						corp.setPostalCode(rs.getString("postalCode"));//��ҵӪҵ��ַ��������
						corp.setLegalMan(rs.getString("legalMan"));	//��������������
						corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//����������֤������(�ֵ��TBIDCARDTYPEDIC)
						corp.setLegalManIdCard(rs.getString("legalManIdCard"));//����������֤������
						corp.setLegalManDuty(rs.getString("legalManDuty"));//����������ְ��
						corp.setLegaManProtitle(rs.getString("legaManProtitle"));//����������ְ��
						corp.setEconomicNum(rs.getString("economicNum"));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
						corp.setRegPrin(rs.getString("regPrin")); 		//ע���ʱ�(��Ԫ)
						corp.setFactRegPrin(rs.getString("factRegPrin"));	//ʵ���ʱ�(��Ԫ)
						corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
						corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//��������
						corp.setOfficePhone(rs.getString("officePhone"));//�칫�绰
						corp.setFax(rs.getString("fax"));				//�������
						corp.setLinkMan(rs.getString("linkMan")); 		//��ϵ������
						corp.setLinkTel(rs.getString("linkTel"));		//��ϵ�˰칫�绰
						corp.setLinkPhone(rs.getString("linkPhone"));	//��ϵ���ֻ�����
						corp.setEmail(rs.getString("email"));			//��ϵ����
						corp.setUrl(rs.getString("url"));				//��ҵ��ַ
						corp.setDescription(rs.getString("description"));	//��ע
						corp.setAssets(rs.getString("assets"));	
						corp.setMachinery(rs.getString("machinery"));
						corp.setSpare1(rs.getString("spare1"));//��ҵ������
						//corp.setForeignCorpName(rs.getString("foreignCorpName"));//����Ͷ��������
						//corp.setNationNume(rs.getString("nationnum"));//���������(�ֵ��TBNATIONALDIC)
						//corp.setPercentTage(rs.getString("percentTage"));//����Ͷ����ռ����(%)
						//corp.setForeignIvestor(rs.getString("foreignIvestor"));	//����Ͷ��������         0:������ҵ��1��������Ȼ��
						//corp.setCheckForeign(rs.getString("checkForeign"));//�Ƿ�����Ͷ��	   0:�ǣ�1����
						corp.setEnterpriseType(rs.getString("enterpriseType"));
						
						corp.setApplyStaffId(rs.getString("applyStaffId"));//������Id
						corp.setApplyStaffName(rs.getString("applyStaffName"));//����������
						corp.setApplyDept(rs.getString("applyDept"));//��������Id
						corp.setApplyDeptName(rs.getString("applyDeptName"));//������������
						corp.setApplyOpinion(rs.getString("applyOpinion"));//��������
						corp.setAppType(rs.getString("appType"));//����״̬
						//corp.setCreateDate(rs.getDate("CREATEDATE"));//��������
						page.getData().add(corp);
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
	
	//��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%"+end+"' and code != '"+provinceId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}

	//��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+cityId+"'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Corp queryCorpInfo(String corpId) {
		Corp corp = new Corp();
		String sql = "select * from V_TBCORPFOREIGNINFO where corpId=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				corp.setCorpId(rs.getString("corpId")); // ����
				corp.setCorpName(rs.getString("corpName")); // ��ҵ����
				corp.setCorpCode(rs.getString("corpCode")); // ��֯��������
				corp.setLicenseNum(rs.getString("licenseNum"));// ����Ӫҵִ��ע���
				corp.setProvinceNum(rs.getString("provinceNum"));// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum")); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countyNum")); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
				corp.setAddress(rs.getString("address")); // ��ҵӪҵ��ַ
				corp.setPostalCode(rs.getString("postalCode"));// ��ҵӪҵ��ַ��������
				corp.setLegalMan(rs.getString("legalMan")); // ��������������
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));// ����������֤������
				corp.setLegalManDuty(rs.getString("legalManDuty"));// ����������ְ��
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));// ����������ְ��
				corp.setEconomicNum(rs.getString("economicNum")); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
				corp.setRegPrin(rs.getString("regPrin")); // ע���ʱ�(��Ԫ)
				corp.setFactRegPrin(rs.getString("factRegPrin")); // ʵ���ʱ�(��Ԫ)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));// ��������
				corp.setOfficePhone(rs.getString("officePhone"));// �칫�绰
				corp.setFax(rs.getString("fax")); // �������
				corp.setLinkMan(rs.getString("linkMan")); // ��ϵ������
				corp.setLinkTel(rs.getString("linkTel")); // ��ϵ�˰칫�绰
				corp.setLinkPhone(rs.getString("linkPhone")); // ��ϵ���ֻ�����
				corp.setEmail(rs.getString("email")); // ��ϵ����
				corp.setUrl(rs.getString("url")); // ��ҵ��ַ
				corp.setDescription(rs.getString("description")); // ��ע
				corp.setAssets(rs.getString("assets")); // ���ʲ�
				corp.setMachinery(rs.getString("machinery"));
				corp.setSpare1(rs.getString("spare1"));// ��ҵ������
				corp.setForeignCorpName(rs.getString("foreignCorpName"));// ����Ͷ��������
				corp.setNationNume(rs.getString("nationnum"));// ���������(�ֵ��TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));// ����Ͷ����ռ����(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor")); // ����Ͷ��������
				corp.setCheckForeign(rs.getString("checkForeign"));// �Ƿ�����Ͷ��
				corp.setAppType(rs.getString("appType"));
				corp.setApplyOpinion(rs.getString("applyOpinion"));
				corp.setApplyDeptName(rs.getString("applyDeptName"));
				corp.setApplyDept(rs.getString("applyDept"));
				corp.setApplyStaffId(rs.getString("applyStaffId"));
				corp.setApplyStaffName(rs.getString("applyStaffName"));
				corp.setSpare1(rs.getString("spare1"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
}
