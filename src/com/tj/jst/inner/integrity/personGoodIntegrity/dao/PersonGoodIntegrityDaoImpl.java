package com.tj.jst.inner.integrity.personGoodIntegrity.dao;

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
import com.tj.jst.inner.integrity.personGoodIntegrity.model.PersonGoodIntegrity;

/**
 * ��Ա������ϢDao
 * 
 * @author DarkFlameMaster
 *
 */
public class PersonGoodIntegrityDaoImpl extends BaseDao implements
		IPersonGoodIntegrityDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page pagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					PersonGoodIntegrity good = new PersonGoodIntegrity();
					good.setGoodCreditId(rs.getString("GOODPERSONID"));
					good.setPersonName(rs.getString("personName"));
					good.setIdCardTypeNum(rs.getString("idCardTypeNum"));
					good.setIdCard18(rs.getString("idCard18"));
					good.setCorpCode(rs.getString("corpCode"));
					good.setCorpName(rs.getString("corpName"));
					good.setSpecialtyTypeNum(rs.getString("SPECIALTYTYPNUM"));
					good.setPrjNum(rs.getString("prjNum"));
					good.setPrjName(rs.getString("prjName"));
					good.setAddress(rs.getString("address"));
					good.setBuildCorpName(rs.getString("buildCorpName"));
					good.setBuildCorpCode(rs.getString("buildCorpCode"));
					good.setProvinceNum(rs.getString("provinceNum"));
					good.setCityNum(rs.getString("cityNum"));
					good.setCountyNum(rs.getString("countyNum"));
					good.setAwardDepartName(rs.getString("awardDepartName"));
					good.setAwardDepartType(rs.getString("awardDepartType"));
					good.setAwardContent(rs.getString("awardContent"));
					good.setAwardDate(rs.getDate("awardDate"));
					good.setDepartName(rs.getString("departName"));
					good.setUserName(rs.getString("userName"));
					good.setCreateDate(rs.getDate("createDate"));
					good.setIsPublic(rs.getString("isPublic"));
					good.setPublicBDate(rs.getDate("publicBDate"));
					good.setPublicEDate(rs.getDate("publicEDate"));
					good.setAuditUserName(rs.getString("auditUserName"));
					good.setAuditDate(rs.getDate("auditDate"));
					page.getData().add(good);
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
	 * ��ѯʡ
	 */
	@Override
	public List<DictionaryClass> queryProvince() {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryCity(String provinceId) {
		// TODO Auto-generated method stub
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

	/**
	 * ��ѯ��
	 */
	@Override
	public List<DictionaryClass> queryArea(String cityId) {
		// TODO Auto-generated method stub
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
	 * ��ѯ֤������
	 */
	@Override
	public List<DictionaryClass> queryCardType() {
		// TODO Auto-generated method stub
		String sql = "select * from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("papertype"));
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

	/**
	 * ��ѯ��Ա����
	 */
	@Override
	public List<DictionaryClass> queryPersonType() {
		// TODO Auto-generated method stub
		String sql = "select * from TBSPECIALTYTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("typelevel"));
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

	/**
	 * ������Ա������Ϣ
	 */
	@Override
	public String addPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "insert into tbregpersongoodcreditinfo (GOODPERSONID,PERSONNAME,"
				+ "IDCARDTYPENUM,IDCARD18,CORPNAME,CORPCODE,SPECIALTYTYPNUM,PRJNUM,"
				+ "PRJNAME,ADDRESS,BUILDCORPNAME,BUILDCORPCODE,"
				+ "PROVINCENUM,CITYNUM,COUNTYNUM,AWARDDEPARTNAME,AWARDDEPARTTYPE,"
				+ "AWARDCONTENT,AWARDNUMBER,AWARDDATE,DEPARTNAME,USERNAME,CREATEDATE,"
				+ "ISPUBLIC,PUBLICBDATE,PUBLICEDATE,AUDITUSERNAME,AUDITDATE,DEPARTID) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String goodCreditId = UUID.randomUUID().toString();
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodCreditId);								//����
			pstmt.setString(2, personGoodIntegrity.getPersonName());		//��ҵ����
			pstmt.setString(3, personGoodIntegrity.getIdCardTypeNum());		//��ҵ����
			pstmt.setString(4, personGoodIntegrity.getIdCard18());			//��ҵ����
			pstmt.setString(5, personGoodIntegrity.getCorpName());			//��ҵ����
			pstmt.setString(6, personGoodIntegrity.getCorpCode());			//��ҵ��֯��������֤
			pstmt.setString(7, personGoodIntegrity.getSpecialtyTypeNum());	//��ҵ����
			pstmt.setString(8, personGoodIntegrity.getPrjNum());			//��Ŀ���
			pstmt.setString(9, personGoodIntegrity.getPrjName());			//��������
			pstmt.setString(10, personGoodIntegrity.getAddress());			//���̵�ַ
			pstmt.setString(11, personGoodIntegrity.getBuildCorpName());	//���赥λ
			pstmt.setString(12, personGoodIntegrity.getBuildCorpCode());	//���赥λסַ��������
			pstmt.setString(13, personGoodIntegrity.getProvinceNum());		//������Ϊ��������ʡ
			pstmt.setString(14, personGoodIntegrity.getCityNum());			//������
			pstmt.setString(15, personGoodIntegrity.getCountyNum());		//������
			pstmt.setString(16, personGoodIntegrity.getAwardDepartName());	//��������
			pstmt.setString(17, personGoodIntegrity.getAwardDepartType());	//�������ż���
			pstmt.setString(18, personGoodIntegrity.getAwardContent());		//�����������
			pstmt.setString(19, personGoodIntegrity.getAwardNumber());		//��������ĺ�
			pstmt.setDate(20, personGoodIntegrity.getAwardDate());			//��������
			pstmt.setString(21, personGoodIntegrity.getDepartName());		//�Ǽǲ���
			pstmt.setString(22, personGoodIntegrity.getUserName());			//�Ǽ���
			pstmt.setDate(23, new Date(new java.util.Date().getTime()));	//�Ǽ�����
			pstmt.setString(24, personGoodIntegrity.getIsPublic());			//�Ƿ񷢲�
			pstmt.setDate(25, personGoodIntegrity.getPublicBDate());		//������ʼʱ��
			pstmt.setDate(26, personGoodIntegrity.getPublicEDate());		//��������ʱ��
			pstmt.setString(27, personGoodIntegrity.getAuditUserName());	//����쵼
			pstmt.setDate(28, personGoodIntegrity.getAuditDate());			//�������
			pstmt.setString(29, personGoodIntegrity.getDepartId()); 		//�Ǽǲ���Id
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "��ӳɹ���";
			}else
			{
				message = "���ʧ�ܣ�";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * �޸���Ա������Ϣ
	 */
	@Override
	public String modifyPersonGoodInfo(PersonGoodIntegrity personGoodIntegrity) {
		// TODO Auto-generated method stub
		String message = "";
		String sql = "update TBRegPersonGoodCreditinfo set PERSONNAME=? , IDCARDTYPENUM=? , IDCARD18=? ,"
				+ " CORPNAME=? , CORPCODE=? ,"
				+ " SPECIALTYTYPNUM=? , PRJNUM=? , PRJNAME=? , ADDRESS=? , BUILDCORPNAME=? , "
				+ "BUILDCORPCODE=? , PROVINCENUM=? , CITYNUM=? , COUNTYNUM=? , "
				+ "AWARDDEPARTNAME=? , AWARDDEPARTTYPE=? , AWARDCONTENT=? , AWARDNUMBER=? , "
				+ "AWARDDATE=?  , ISPUBLIC=? , PUBLICBDATE=? , PUBLICEDATE=? , "
				+ "AUDITUSERNAME=? , AUDITDATE=? where GOODPERSONID=? ";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personGoodIntegrity.getPersonName());		//��Ա����
			pstmt.setString(2, personGoodIntegrity.getIdCardTypeNum());		//֤������
			pstmt.setString(3, personGoodIntegrity.getIdCard18());			//֤������
			pstmt.setString(4, personGoodIntegrity.getCorpName());			//��ҵ����
			pstmt.setString(5, personGoodIntegrity.getCorpCode());			//��ҵ��֯��������֤
			pstmt.setString(6, personGoodIntegrity.getSpecialtyTypeNum());	//��Ա����
			pstmt.setString(7, personGoodIntegrity.getPrjNum());			//��Ŀ���
			pstmt.setString(8, personGoodIntegrity.getPrjName());			//��������
			pstmt.setString(9, personGoodIntegrity.getAddress());			//���̵�ַ
			pstmt.setString(10, personGoodIntegrity.getBuildCorpName());	//���赥λ
			pstmt.setString(11, personGoodIntegrity.getBuildCorpCode());	//���赥λסַ��������
			pstmt.setString(12, personGoodIntegrity.getProvinceNum());		//������Ϊ��������ʡ
			pstmt.setString(13, personGoodIntegrity.getCityNum());			//������
			pstmt.setString(14, personGoodIntegrity.getCountyNum());		//������
			pstmt.setString(15, personGoodIntegrity.getAwardDepartName());	//��������
			pstmt.setString(16, personGoodIntegrity.getAwardDepartType());	//�������ż���
			pstmt.setString(17, personGoodIntegrity.getAwardContent());		//������������
			pstmt.setString(18, personGoodIntegrity.getAwardNumber());		//���������ĺ�
			pstmt.setDate(19, personGoodIntegrity.getAwardDate());			//������������
			pstmt.setString(20, personGoodIntegrity.getIsPublic());			//�Ƿ񷢲�
			pstmt.setDate(21, personGoodIntegrity.getPublicBDate());		//������ʼʱ��
			pstmt.setDate(22, personGoodIntegrity.getPublicEDate());		//��������ʱ��
			pstmt.setString(23, personGoodIntegrity.getAuditUserName());	//����쵼
			pstmt.setDate(24, personGoodIntegrity.getAuditDate());			//�������
			pstmt.setString(25, personGoodIntegrity.getGoodCreditId()); 	//�Ǽǲ���Id
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ɾ����Ա������Ϣ
	 */
	@Override
	public String deletePersonGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		String sql = "update TBRegPersonGoodCreditinfo set STATUS = ? where GOODPERSONID=?";
		String message = "";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1");	
			pstmt.setString(2,goodCreditId);	
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "ɾ���ɹ���";
			}else
			{
				message = "ɾ��ʧ�ܣ�";
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

	/**
	 * ������Ҫ�޸ĵ���Ա��Ϣ
	 */
	@Override
	public PersonGoodIntegrity queryGoodInfo(String goodCreditId) {
		// TODO Auto-generated method stub
		PersonGoodIntegrity person = new PersonGoodIntegrity();
		String sql = "select * from TBREGPERSONGOODCREDITINFO where GOODPERSONID = ?";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodCreditId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				person.setGoodCreditId(rs.getString("GOODPERSONID"));
				person.setPersonName(rs.getString("personName"));
				person.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				person.setIdCard18(rs.getString("idCard18"));
				person.setCorpName(rs.getString("corpName"));
				person.setCorpCode(rs.getString("corpCode"));
				person.setSpecialtyTypeNum(rs.getString("specialtyTypNum").trim());
				person.setDepartId(rs.getString("departId"));
				person.setPrjNum(rs.getString("prjNum"));
				person.setPrjName(rs.getString("prjName"));
				person.setAddress(rs.getString("address"));
				person.setBuildCorpName(rs.getString("buildCorpName"));
				person.setBuildCorpCode(rs.getString("buildCorpCode"));
				person.setProvinceNum(rs.getString("provinceNum"));
				person.setCityNum(rs.getString("cityNum"));
				person.setCountyNum(rs.getString("countyNum"));
				person.setAwardDepartName(rs.getString("awardDepartName"));
				person.setAwardDepartType(rs.getString("awardDepartType"));
				person.setAwardContent(rs.getString("awardContent"));
				person.setAwardNumber(rs.getString("awardNumber"));
				person.setAwardDate(rs.getDate("awardDate"));
				person.setDepartName(rs.getString("departName"));
				person.setUserName(rs.getString("userName"));
				person.setCreateDate(rs.getDate("createDate"));
				person.setIsPublic(rs.getString("isPublic"));
				person.setPublicBDate(rs.getDate("publicBDate"));
				person.setPublicEDate(rs.getDate("publicEDate"));
				person.setAuditUserName(rs.getString("auditUserName"));
				person.setAuditDate(rs.getDate("auditDate"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return person;
	}

}
