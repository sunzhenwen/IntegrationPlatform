package com.tj.jst.inner.integrity.corpGoodIntegrity.dao;

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
import com.tj.jst.inner.integrity.corpGoodIntegrity.model.CorpGoodIntegrity;

/**
 * ��ҵ������Ϊ����
 * 
 * @author DarkFlameMaster
 *
 */
public class CorpGoodIntegrityDaoImpl extends BaseDao implements ICorpGoodIntegrityDao {

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
			if(rs!=null)
			{
				while (rs.next()) {
					CorpGoodIntegrity good = new CorpGoodIntegrity();
					good.setCorpGoodCreditId(rs.getString("goodCreditId"));
					good.setCorpCode(rs.getString("corpCode"));
					good.setCorpName(rs.getString("corpName"));
					good.setCertTypeNum(rs.getString("certTypeNum"));
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
		} finally
		{
			ConnectionFactory.closeConn(page.getConn(), page.getPstmt(), page.getRs());
		}
		return page;
	}

	/**
	 * ��ѯ����ʡ
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
	 * ��ѯ������
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
	 * ��ѯ������
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
	 * ��ѯ��ҵ����
	 */
	@Override
	public List<DictionaryClass> queryCertTypeNums() {
		String sql = "select code,corpregtype from TBECONTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
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
	 * ������ҵ������Ϊ��Ϣ
	 */
	@Override
	public String addGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		String sql = "insert into TBCorpGoodCreditInfo (GOODCREDITID,CORPNAME,CORPCODE,"
				+ "CERTTYPENUM,PRJNUM,PRJNAME,ADDRESS,BUILDCORPNAME,BUILDCORPCODE,"
				+ "PROVINCENUM,CITYNUM,COUNTYNUM,AWARDDEPARTNAME,AWARDDEPARTTYPE,"
				+ "AWARDCONTENT,AWARDNUMBER,AWARDDATE,DEPARTNAME,USERNAME,CREATEDATE,"
				+ "ISPUBLIC,PUBLICBDATE,PUBLICEDATE,AUDITUSERNAME,AUDITDATE,DEPARTID) values "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String message = "";
		String goodCreditId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, goodCreditId);								//����
			pstmt.setString(2, corpGoodIntegrity.getCorpName());			//��ҵ����
			pstmt.setString(3, corpGoodIntegrity.getCorpCode());			//��ҵ��֯��������֤
			pstmt.setString(4, corpGoodIntegrity.getCertTypeNum());			//��ҵ����
			pstmt.setString(5, corpGoodIntegrity.getPrjNum());				//��Ŀ���
			pstmt.setString(6, corpGoodIntegrity.getPrjName());				//��������
			pstmt.setString(7, corpGoodIntegrity.getAddress());				//���̵�ַ
			pstmt.setString(8, corpGoodIntegrity.getBuildCorpName());		//���赥λ
			pstmt.setString(9, corpGoodIntegrity.getBuildCorpCode());		//���赥λסַ��������
			pstmt.setString(10, corpGoodIntegrity.getProvinceNum());		//������Ϊ��������ʡ
			pstmt.setString(11, corpGoodIntegrity.getCityNum());			//������
			pstmt.setString(12, corpGoodIntegrity.getCountyNum());			//������
			pstmt.setString(13, corpGoodIntegrity.getAwardDepartName());	//��������
			pstmt.setString(14, corpGoodIntegrity.getAwardDepartType());	//�������ż���
			pstmt.setString(15, corpGoodIntegrity.getAwardContent());		//�����������
			pstmt.setString(16, corpGoodIntegrity.getAwardNumber());		//��������ĺ�
			pstmt.setDate(17, corpGoodIntegrity.getAwardDate());			//��������
			pstmt.setString(18, corpGoodIntegrity.getDepartName());			//�Ǽǲ���
			pstmt.setString(19, corpGoodIntegrity.getUserName());			//�Ǽ���
			pstmt.setDate(20, new Date(new java.util.Date().getTime()));	//�Ǽ�����
			pstmt.setString(21, corpGoodIntegrity.getIsPublic());			//�Ƿ񷢲�
			pstmt.setDate(22, corpGoodIntegrity.getPublicBDate());			//������ʼʱ��
			pstmt.setDate(23, corpGoodIntegrity.getPublicEDate());			//��������ʱ��
			pstmt.setString(24, corpGoodIntegrity.getAuditUserName());		//����쵼
			pstmt.setDate(25, corpGoodIntegrity.getAuditDate());			//�������
			pstmt.setString(26, corpGoodIntegrity.getDepartId()); 			//�Ǽǲ���Id
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "��ӳɹ���";
			}else
			{
				message = "���ʧ�ܣ�";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ��ѯ��Ҫ�޸ĵ���Ϣ
	 */
	@Override
	public CorpGoodIntegrity queryCorpGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		CorpGoodIntegrity corp = new CorpGoodIntegrity();
		String sql = "select * from TBCORPGOODCREDITINFO where goodCreditId = ?";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpGoodCreditId);
			rs = pstmt.executeQuery();
			if(rs.next()){
				corp.setCorpGoodCreditId(rs.getString("goodCreditId"));
				corp.setCorpName(rs.getString("corpName"));
				corp.setCorpCode(rs.getString("corpCode"));
				corp.setCertTypeNum(rs.getString("certTypeNum").trim());
				corp.setDepartId(rs.getString("departId"));
				corp.setPrjNum(rs.getString("prjNum"));
				corp.setPrjName(rs.getString("prjName"));
				corp.setAddress(rs.getString("address"));
				corp.setBuildCorpName(rs.getString("buildCorpName"));
				corp.setBuildCorpCode(rs.getString("buildCorpCode"));
				corp.setProvinceNum(rs.getString("provinceNum"));
				corp.setCityNum(rs.getString("cityNum"));
				corp.setCountyNum(rs.getString("countyNum"));
				corp.setAwardDepartName(rs.getString("awardDepartName"));
				corp.setAwardDepartType(rs.getString("awardDepartType"));
				corp.setAwardContent(rs.getString("awardContent"));
				corp.setAwardNumber(rs.getString("awardNumber"));
				corp.setAwardDate(rs.getDate("awardDate"));
				corp.setDepartName(rs.getString("departName"));
				corp.setUserName(rs.getString("userName"));
				corp.setCreateDate(rs.getDate("createDate"));
				corp.setIsPublic(rs.getString("isPublic"));
				corp.setPublicBDate(rs.getDate("publicBDate"));
				corp.setPublicEDate(rs.getDate("publicEDate"));
				corp.setAuditUserName(rs.getString("auditUserName"));
				corp.setAuditDate(rs.getDate("auditDate"));
			}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return corp;
	}

	/**
	 * �޸�������Ϣ
	 */
	@Override
	public String modifyGoodInfo(CorpGoodIntegrity corpGoodIntegrity) {
		// TODO Auto-generated method stub
		String sql = "update TBCorpGoodCreditinfo set CORPNAME=? , CORPCODE=? ,"
				+ " CERTTYPENUM=? , PRJNUM=? , PRJNAME=? , ADDRESS=? , BUILDCORPNAME=? , "
				+ "BUILDCORPCODE=? , PROVINCENUM=? , CITYNUM=? , COUNTYNUM=? , "
				+ "AWARDDEPARTNAME=? , AWARDDEPARTTYPE=? , AWARDCONTENT=? , AWARDNUMBER=? , "
				+ "AWARDDATE=?  , ISPUBLIC=? , PUBLICBDATE=? , PUBLICEDATE=? , "
				+ "AUDITUSERNAME=? , AUDITDATE=? where GOODCREDITID=? ";
		String message = "";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpGoodIntegrity.getCorpName());			//��ҵ����
			pstmt.setString(2, corpGoodIntegrity.getCorpCode());			//��ҵ��֯��������֤
			pstmt.setString(3, corpGoodIntegrity.getCertTypeNum());			//��ҵ����
			pstmt.setString(4, corpGoodIntegrity.getPrjNum());				//��Ŀ���
			pstmt.setString(5, corpGoodIntegrity.getPrjName());				//��������
			pstmt.setString(6, corpGoodIntegrity.getAddress());				//���̵�ַ
			pstmt.setString(7, corpGoodIntegrity.getBuildCorpName());		//���赥λ
			pstmt.setString(8, corpGoodIntegrity.getBuildCorpCode());		//���赥λסַ��������
			pstmt.setString(9, corpGoodIntegrity.getProvinceNum());			//������Ϊ��������ʡ
			pstmt.setString(10, corpGoodIntegrity.getCityNum());			//������
			pstmt.setString(11, corpGoodIntegrity.getCountyNum());			//������
			pstmt.setString(12, corpGoodIntegrity.getAwardDepartName());	//��������
			pstmt.setString(13, corpGoodIntegrity.getAwardDepartType());	//�������ż���
			pstmt.setString(14, corpGoodIntegrity.getAwardContent());		//������������
			pstmt.setString(15, corpGoodIntegrity.getAwardNumber());		//���������ĺ�
			pstmt.setDate(16, corpGoodIntegrity.getAwardDate());			//������������
			pstmt.setString(17, corpGoodIntegrity.getIsPublic());			//�Ƿ񷢲�
			pstmt.setDate(18, corpGoodIntegrity.getPublicBDate());			//������ʼʱ��
			pstmt.setDate(19, corpGoodIntegrity.getPublicEDate());			//��������ʱ��
			pstmt.setString(20, corpGoodIntegrity.getAuditUserName());		//����쵼
			pstmt.setDate(21, corpGoodIntegrity.getAuditDate());			//�������
			pstmt.setString(22, corpGoodIntegrity.getCorpGoodCreditId()); 	//�Ǽǲ���Id
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
	 *  ɾ����ҵ������Ϣ
	 */
	@Override
	public String deleteGoodInfo(String corpGoodCreditId) {
		// TODO Auto-generated method stub
		String sql = "update TBCorpGoodCreditinfo set STATUS = ? where GOODCREDITID=?";
		String message = "";
		try{
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1");
			pstmt.setString(2,corpGoodCreditId);	
			int check = pstmt.executeUpdate();
			if(check == 1)
			{
				message = "�޸ĳɹ���";
			}else
			{
				message = "�޸�ʧ�ܣ�";
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

}
