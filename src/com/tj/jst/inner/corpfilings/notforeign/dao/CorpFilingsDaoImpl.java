package com.tj.jst.inner.corpfilings.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

/**
 * ��ҵ����
 * 
 * @author Administrator
 *
 */
public class CorpFilingsDaoImpl extends BaseDao implements ICorpFilingsDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ѯ
	 * 
	 * @param condition
	 * @return
	 */
	public Page pagedQuery(Condition condition) {

		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Corp corp = new Corp();
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
					corp.setEconomicName(rs.getString("corpRegType"));
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
					corp.setAssets(rs.getString("assets"));
					corp.setMachinery(rs.getString("machinery"));
					corp.setSpare1(rs.getString("spare1"));// ��ҵ������
					corp.setAppType(rs.getString("appType"));// ����״̬
					corp.setCreateDate(rs.getDate("CREATDATE"));// ��������
					page.getData().add(corp);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
					page.getRs());
		}
		return page;
	}

	/**
	 * ����ҵ���
	 * 
	 * @return
	 */
	@Override
	public void addCorp(Corp corp) {
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
				+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
				+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������
			pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
			pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
			pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
			pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// ��������
			pstmt.setString(19, corp.getOfficePhone());// �칫�绰
			pstmt.setString(20, corp.getFax()); // �������
			pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
			pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
			pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
			pstmt.setString(24, corp.getEmail()); // ��ϵ����
			pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
			pstmt.setString(26, corp.getDescription()); // ��ע
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // ���ʱ��
			pstmt.setString(28, corpId); // ����
			pstmt.setString(29, "1"); // �������ݣ�0�����ݣ�1������
			pstmt.setString(30, corp.getAssets()); // ���ʲ�
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());// ��ҵ������
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
							+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,"
							+ "appType,spare1,CREATEDATE) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, corpId);
			pstmt.setString(2, corp.getCorpName());
			pstmt.setString(3, corp.getCorpCode());
			pstmt.setString(4, corp.getApplyOpinion());
			pstmt.setString(5, corp.getApplyStaffId());
			pstmt.setString(6, corp.getApplyStaffName());
			pstmt.setString(7, corp.getApplyDept());
			pstmt.setString(8, corp.getApplyDeptName());
			pstmt.setString(9, "1");
			pstmt.setString(10, corp.getSpare1());
			pstmt.setDate(11, new Date(new java.util.Date().getTime())); // ����ʱ��
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
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ����������ҵ
	 */
	@Override
	public void addForeignCorp(Corp corp) {
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
					+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
					+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
					+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
					+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������
			pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
			pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
			pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
			pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// ��������
			pstmt.setString(19, corp.getOfficePhone());// �칫�绰
			pstmt.setString(20, corp.getFax()); // �������
			pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
			pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
			pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
			pstmt.setString(24, corp.getEmail()); // ��ϵ����
			pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
			pstmt.setString(26, corp.getDescription()); // ��ע
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // ���ʱ��
			pstmt.setString(28, corpId); // ����
			pstmt.setString(29, "1"); // �������ݣ�0�����ݣ�1������
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());// ��ҵ������
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into TBCorpForeigninfo(CORPID,CORPNAME,CORPCODE,"
							+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,"
							+ "FOREIGNIVESTOR,CREATEDATE) values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, corpId);
			pstmt.setString(2, corp.getCorpName());
			pstmt.setString(3, corp.getCorpCode());
			pstmt.setString(4, corp.getForeignCorpName());
			pstmt.setString(5, corp.getNationNume());
			pstmt.setString(6, corp.getPrincipalUnitNum());
			pstmt.setString(7, corp.getRegPrin());
			pstmt.setString(8, corp.getPercentTage());
			pstmt.setString(9, corp.getForeignIvestor());
			pstmt.setDate(10, new Date(new java.util.Date().getTime())); // ����ʱ��
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
							+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,"
							+ "appType,spare1,CREATEDATE) "
							+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1, corpId);
			pstmt.setString(2, corp.getCorpName());
			pstmt.setString(3, corp.getCorpCode());
			pstmt.setString(4, corp.getApplyOpinion());
			pstmt.setString(5, corp.getApplyStaffId());
			pstmt.setString(6, corp.getApplyStaffName());
			pstmt.setString(7, corp.getApplyDept());
			pstmt.setString(8, corp.getApplyDeptName());
			pstmt.setString(9, "1");
			pstmt.setString(10, corp.getSpare1());
			pstmt.setDate(11, new Date(new java.util.Date().getTime())); // ����ʱ��
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
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ��ѯ����
	 * 
	 * @return
	 */
	public Corp queryCorpForId(String corpId) {
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
																		// 0:������ҵ��1��������Ȼ��
				corp.setCheckForeign(rs.getString("checkForeign"));// �Ƿ�����Ͷ��
																	// 0:�ǣ�1����
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

	/**
	 * ��ҵ�޸�
	 * 
	 * @return
	 */
	@Override
	public void modifyCorp(Corp corp) {
		String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
				+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
				+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
				+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=?,spare1=?"
				+ " where CORPID=? ";

		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpName()); // ��ҵ����
			pstmt.setString(2, corp.getCorpCode()); // ��֯��������
			pstmt.setString(3, corp.getLicenseNum());// ����Ӫҵִ��ע���
			pstmt.setString(4, corp.getProvinceNum());// ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5, corp.getCityNum()); // ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6, corp.getCountyNum()); // ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7, corp.getAddress()); // ��ҵӪҵ��ַ
			pstmt.setString(8, corp.getPostalCode());// ��ҵӪҵ��ַ��������
			pstmt.setString(9, corp.getLegalMan()); // ��������������
			pstmt.setString(10, corp.getIdCardTypeNum());// ����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11, corp.getLegalManIdCard());// ����������֤������
			pstmt.setString(12, corp.getLegalManDuty());// ����������ְ��
			pstmt.setString(13, corp.getLegaManProtitle());// ����������ְ��
			pstmt.setInt(14, Integer.parseInt(corp.getEconomicNum())); // ��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15, Double.parseDouble(corp.getRegPrin())); // ע���ʱ�(��Ԫ)
			pstmt.setDouble(16, Double.parseDouble(corp.getFactRegPrin())); // ʵ���ʱ�(��Ԫ)
			pstmt.setString(17, corp.getPrincipalUnitNum());// ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18, corp.getCorpBirthDate());// ��������
			pstmt.setString(19, corp.getOfficePhone());// �칫�绰
			pstmt.setString(20, corp.getFax()); // �������
			pstmt.setString(21, corp.getLinkMan()); // ��ϵ������
			pstmt.setString(22, corp.getLinkTel()); // ��ϵ�˰칫�绰
			pstmt.setString(23, corp.getLinkPhone()); // ��ϵ���ֻ�����
			pstmt.setString(24, corp.getEmail()); // ��ϵ����
			pstmt.setString(25, corp.getUrl()); // ��ҵ��ַ
			pstmt.setString(26, corp.getDescription()); // ��ע
			pstmt.setDate(27, new Date(new java.util.Date().getTime())); // �޸�ʱ��
			pstmt.setString(28, corp.getAssets()); // ���ʲ�
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getSpare1());
			pstmt.setString(31, corp.getCorpId()); // ����
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ����ͨ��
	 * 
	 * @return
	 */
	public void applythrough(Corp corp) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update T_TBCORPBUSINESS set APPLYOPINION=?,"
							+ "APPLYSTAFFID=?,APPLYSTAFFNAME=?,APPLYDEPT=?,APPLYDEPTNAME=?,appType=?"
							+ " where corpId=?");

			pstmt.setString(1, corp.getApplyOpinion());
			pstmt.setString(2, corp.getApplyStaffId());
			pstmt.setString(3, corp.getApplyStaffName());
			pstmt.setString(4, corp.getApplyDept());
			pstmt.setString(5, corp.getApplyDeptName());
			pstmt.setString(6, "1");
			pstmt.setString(7, corp.getCorpId());
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
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	/**
	 * ����δͨ��
	 * 
	 * @return
	 */
	public void applyThroughBack(Corp corp) {
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);

			pstmt = conn
					.prepareStatement("update T_TBCORPBUSINESS set APPLYOPINION=?,"
							+ "APPLYSTAFFID=?,APPLYSTAFFNAME=?,APPLYDEPT=?,APPLYDEPTNAME=?,appType=?"
							+ " where corpId=?");

			pstmt.setString(1, corp.getApplyOpinion());
			pstmt.setString(2, corp.getApplyStaffId());
			pstmt.setString(3, corp.getApplyStaffName());
			pstmt.setString(4, corp.getApplyDept());
			pstmt.setString(5, corp.getApplyDeptName());
			pstmt.setString(6, "2");
			pstmt.setString(7, corp.getCorpId());
			pstmt.executeUpdate();

			String sql = "delete from TBCorpBasicinfo where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpId());
			pstmt.executeUpdate();

			pstmt = conn
					.prepareStatement("delete from TBCorpForeigninfo where CORPID=?");
			pstmt.setString(1, corp.getCorpId());
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
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}

	// ��ѯʡ
	@Override
	public List<DictionaryClass> queryProvince() {
		String sql = "select * from TBXZQDMDIC where code like '%0000'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("name"));
				dictionaryClass.setCode(rs.getString("code"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// ��ѯ��
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		String star = provinceId.substring(0, 2);
		String end = provinceId.substring(4, provinceId.length());
		String sql = "select * from TBXZQDMDIC where code like '" + star + "%"
				+ end + "' and code != '" + provinceId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}

		return list;
	}

	// ��ѯ��
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		String star = cityId.substring(0, 4);
		String sql = "select * from TBXZQDMDIC where code like '" + star
				+ "%' and code != '" + cityId + "'";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("name"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	/**
	 * ��֯��������֤�ظ��ж�
	 */
	@Override
	public String queryCorpCode(String corpCode) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "select * from TBCorpBasicinfo where corpCode=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				message = "�ظ�";
			} else {
				message = "ʧ��";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return message;
	}

}
