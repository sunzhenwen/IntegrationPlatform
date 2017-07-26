package com.tj.jst.inner.integrity.personBadIntegrity.dao;

import java.sql.Connection;
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
import com.tj.jst.inner.integrity.personBadIntegrity.model.PersonBadIntegrity;

/**
 * ע����Ա������Ϊ��Ϣ���ݱ�
 * @author hhc
 *
 */
public class PersonBadIntegrityDaoImpl extends BaseDao implements IPersonBadIntegrityDao {

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
					PersonBadIntegrity pbi = new PersonBadIntegrity();
					
					pbi.setBadPersonId(rs.getString("badPersonId"));//����
					pbi.setPersonName(rs.getString("personName"));//����
					pbi.setIdCardTypeNum(rs.getString("idCardTypeNum"));//֤������(�ֵ��TBIDCARDTYPEDIC)
					pbi.setIdCard18(rs.getString("idCard18"));//֤������
					pbi.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//��Ա����(�ֵ��TBSPECIALTYTYPEDIC)
					
					pbi.setCorpName(rs.getString("corpName"));
					pbi.setCorpCode(rs.getString("corpCode"));
					pbi.setPrjNum(rs.getString("prjNum"));
					pbi.setPrjName(rs.getString("prjName"));
					pbi.setAddress(rs.getString("address"));
					pbi.setBuildCorpName(rs.getString("buildCorpName"));
					pbi.setBuildCorpCode(rs.getString("buildCorpCode"));
					pbi.setProvinceNum(rs.getString("provinceNum"));
					pbi.setCityNum(rs.getString("cityNum"));
					pbi.setCountyNum(rs.getString("countyNum"));
					pbi.setCreditClassNum(rs.getString("creditClassNum"));
					pbi.setCreditType(rs.getString("creditType"));
					pbi.setCreditCode(rs.getString("creditCode"));
					pbi.setContent(rs.getString("content"));
					pbi.setPunishDepartName(rs.getString("punishDepartName"));
					pbi.setPunishDepartType(rs.getString("punishDepartType"));
					pbi.setPunishEvidence(rs.getString("punishEvidence"));
					pbi.setPunishContent(rs.getString("punishContent"));
					pbi.setPunishNumber(rs.getString("punishNumber"));
					pbi.setPunishMoney(rs.getString("punishMoney"));
					pbi.setDepartName(rs.getString("departName"));
					pbi.setUserName(rs.getString("userName"));
					pbi.setIsPublic(rs.getString("isPublic"));
					pbi.setAuditUserName(rs.getString("auditUserName"));
					pbi.setHappenDate(rs.getDate("happenDate"));
					pbi.setPunishDate(rs.getDate("punishDate"));
					pbi.setPunishEDate(rs.getDate("punishEDate"));
					pbi.setCreateDate(rs.getDate("createDate"));
					pbi.setPublicBDate(rs.getDate("publicBDate"));
					pbi.setPublicEDate(rs.getDate("publicEDate"));
					pbi.setAuditDate(rs.getDate("auditDate"));
					
					page.getData().add(pbi);
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
	 * @return
	 */
	public void add(PersonBadIntegrity personBadIntegrity)
	{
		
		String sql = "insert into TBREGPERSONBADCREDITINFO(badPersonId,CORPNAME,CORPCODE,CREDITTYPE"
				+ ",CREDITCODE,HAPPENDATE,PRJNUM,DEPARTNAME,PUNISHEVIDENCE,PUNISHCONTENT"
				+ ",PUNISHNUMBER,PUNISHDATE,PUNISHEDATE,specialtyTypNum,PRJNAME,ADDRESS,BUILDCORPNAME"
				+ ",BUILDCORPCODE,PROVINCENUM,CITYNUM,COUNTYNUM,CREDITCLASSNUM,CONTENT"
				+ ",PUNISHDEPARTNAME,AUDITDATE,AUDITUSERNAME,PUBLICEDATE,PUBLICBDATE,ISPUBLIC"
				+ ",CREATEDATE,USERNAME,PUNISHMONEY,PUNISHDEPARTTYPE,departId,personName"
				+ ",idCardTypeNum,idCard18,delType) "
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String badPersonId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,badPersonId);	//����
			pstmt.setString(2,personBadIntegrity.getCorpName()); 	//��ҵ����
			pstmt.setString(3,personBadIntegrity.getCorpCode());//��֯��������
			pstmt.setString(4,personBadIntegrity.getCreditType());//������Ϊ���(�ֵ��TBCORPBADDIC)
			pstmt.setString(5,personBadIntegrity.getCreditCode());//������Ϊ����(�ֵ��TBCORPBADDIC)
			pstmt.setDate(6,personBadIntegrity.getHappenDate());//������Ϊ��������
			pstmt.setString(7,personBadIntegrity.getPrjNum());//��Ŀ���
			pstmt.setString(8,personBadIntegrity.getDepartName());//�Ǽǲ���
			pstmt.setString(9,personBadIntegrity.getPunishEvidence());//��������
			pstmt.setString(10,personBadIntegrity.getPunishContent());//������������
			pstmt.setString(11,personBadIntegrity.getPunishNumber());//���������ĺ�
			pstmt.setDate(12,personBadIntegrity.getPunishDate());//��������
			pstmt.setDate(13,personBadIntegrity.getPunishEDate());//������������
			pstmt.setString(14,personBadIntegrity.getSpecialtyTypNum());//��Ա����(�ֵ��TBSPECIALTYTYPEDIC)
			pstmt.setString(15,personBadIntegrity.getPrjName()); //��������
			pstmt.setString(16,personBadIntegrity.getAddress());	//���̵�ַ
			pstmt.setString(17,personBadIntegrity.getBuildCorpName());//���赥λ
			pstmt.setString(18,personBadIntegrity.getBuildCorpCode());//���赥λ��֯��������
			pstmt.setString(19,personBadIntegrity.getProvinceNum());//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setString(20,personBadIntegrity.getCityNum());//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
			pstmt.setString(21,personBadIntegrity.getCountyNum());//������Ϊ������������(�ֵ��TBXZQDMDIC)
			pstmt.setString(22,personBadIntegrity.getCreditClassNum());//������Ϊ����(�ֵ��TBCREDITTYPE)
			pstmt.setString(23,personBadIntegrity.getContent());//������Ϊ����
			pstmt.setString(24,personBadIntegrity.getPunishDepartName());//��������
			pstmt.setDate(25,personBadIntegrity.getAuditDate());//���ʱ�䣨����ʱ����д��
			pstmt.setString(26,personBadIntegrity.getAuditUserName());//����쵼
			pstmt.setDate(27,personBadIntegrity.getPublicEDate());//��������ʱ�䣨����ʱ����д��
			pstmt.setDate(28,personBadIntegrity.getPublicBDate()); //������ʼʱ�䣨����ʱ����д��
			pstmt.setString(29,personBadIntegrity.getIsPublic());	//�Ƿ񷢲���0��δ������1���ѷ���
			pstmt.setDate(30, personBadIntegrity.getCreateDate());//�Ǽ�����
			pstmt.setString(31, personBadIntegrity.getUserName()); //�Ǽ�������
			pstmt.setString(32, personBadIntegrity.getPunishMoney());//�������
			pstmt.setString(33, personBadIntegrity.getPunishDepartType());//�������ż���0��������1��ʡ�У�2�����У�3������
			pstmt.setString(34, personBadIntegrity.getDepartId());//�Ǽǲ���Id
			pstmt.setString(35, personBadIntegrity.getPersonName());//����
			pstmt.setString(36, personBadIntegrity.getIdCardTypeNum());//֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(37, personBadIntegrity.getIdCard18());//֤������
			pstmt.setString(38, "0");
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ��ѯ������¼
	 * @param badPersonId
	 * @return
	 */
	public PersonBadIntegrity queryById(String badPersonId)
	{
		String sql = "select * from TBREGPERSONBADCREDITINFO where badPersonId=? ";
		PersonBadIntegrity personBadIntegrity = new PersonBadIntegrity();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,badPersonId);	//����
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				personBadIntegrity.setBadPersonId(rs.getString("badPersonId"));//����
				personBadIntegrity.setCorpName(rs.getString("CORPNAME")); 	//��ҵ����
				personBadIntegrity.setCorpCode(rs.getString("CORPCODE"));//��֯��������
				personBadIntegrity.setCreditType(rs.getString("CREDITTYPE"));//������Ϊ���(�ֵ��TBCORPBADDIC)
				personBadIntegrity.setCreditCode(rs.getString("CREDITCODE"));//������Ϊ����(�ֵ��TBCORPBADDIC)
				personBadIntegrity.setHappenDate(rs.getDate("HAPPENDATE"));//������Ϊ��������
				personBadIntegrity.setPrjNum(rs.getString("PRJNUM"));//��Ŀ���
				personBadIntegrity.setDepartName(rs.getString("DEPARTNAME"));//�Ǽǲ���
				personBadIntegrity.setPunishEvidence(rs.getString("PUNISHEVIDENCE"));//��������
				personBadIntegrity.setPunishContent(rs.getString("PUNISHCONTENT"));//������������
				personBadIntegrity.setPunishNumber(rs.getString("PUNISHNUMBER"));//���������ĺ�
				personBadIntegrity.setPunishDate(rs.getDate("PUNISHDATE"));//��������
				personBadIntegrity.setPunishEDate(rs.getDate("PUNISHEDATE"));//������������
				personBadIntegrity.setSpecialtyTypNum(rs.getString("specialtyTypNum"));//��Ա����(�ֵ��TBSPECIALTYTYPEDIC)
				personBadIntegrity.setPrjName(rs.getString("PRJNAME")); //��������
				personBadIntegrity.setAddress(rs.getString("ADDRESS"));	//���̵�ַ
				personBadIntegrity.setBuildCorpName(rs.getString("BUILDCORPNAME"));//���赥λ
				personBadIntegrity.setBuildCorpCode(rs.getString("BUILDCORPCODE"));//���赥λ��֯��������
				personBadIntegrity.setProvinceNum(rs.getString("PROVINCENUM"));//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
				personBadIntegrity.setCityNum(rs.getString("CITYNUM"));//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
				personBadIntegrity.setCountyNum(rs.getString("COUNTYNUM"));//������Ϊ������������(�ֵ��TBXZQDMDIC)
				personBadIntegrity.setCreditClassNum(rs.getString("CREDITCLASSNUM"));//������Ϊ����(�ֵ��TBCREDITTYPE)
				personBadIntegrity.setContent(rs.getString("CONTENT"));//������Ϊ����
				personBadIntegrity.setPunishDepartName(rs.getString("PUNISHDEPARTNAME"));//��������
				personBadIntegrity.setAuditDate(rs.getDate("AUDITDATE"));//���ʱ�䣨����ʱ����д��
				personBadIntegrity.setAuditUserName(rs.getString("AUDITUSERNAME"));//����쵼
				personBadIntegrity.setPublicEDate(rs.getDate("PUBLICEDATE"));//��������ʱ�䣨����ʱ����д��
				personBadIntegrity.setPublicBDate(rs.getDate("PUBLICBDATE")); //������ʼʱ�䣨����ʱ����д��
				personBadIntegrity.setIsPublic(rs.getString("ISPUBLIC"));	//�Ƿ񷢲���0��δ������1���ѷ���
				personBadIntegrity.setCreateDate(rs.getDate("CREATEDATE"));//�Ǽ�����
				personBadIntegrity.setUserName(rs.getString("USERNAME")); //�Ǽ�������
				personBadIntegrity.setPunishMoney(rs.getString("PUNISHMONEY"));//�������
				personBadIntegrity.setPunishDepartType(rs.getString("PUNISHDEPARTTYPE"));//�������ż���0��������1��ʡ�У�2�����У�3������
				personBadIntegrity.setDepartId(rs.getString("DEPARTID"));//�Ǽǲ���Id
				personBadIntegrity.setPersonName(rs.getString("personName"));//����
				personBadIntegrity.setIdCardTypeNum(rs.getString("idCardTypeNum"));//֤������(�ֵ��TBIDCARDTYPEDIC)
				personBadIntegrity.setIdCard18(rs.getString("idCard18"));//֤������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return personBadIntegrity;
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(PersonBadIntegrity personBadIntegrity)
	{
		
		String sql = "update TBREGPERSONBADCREDITINFO set CORPNAME=?,CORPCODE=?,CREDITTYPE=?"
				+ ",CREDITCODE=?,HAPPENDATE=?,PRJNUM=?,DEPARTNAME=?,PUNISHEVIDENCE=?"
				+ ",PUNISHCONTENT=?,PUNISHNUMBER=?,PUNISHDATE=?,PUNISHEDATE=?,specialtyTypNum=?"
				+ ",PRJNAME=?,ADDRESS=?,BUILDCORPNAME=?,BUILDCORPCODE=?,PROVINCENUM=?,CITYNUM=?"
				+ ",COUNTYNUM=?,CREDITCLASSNUM=?,CONTENT=?,PUNISHDEPARTNAME=?,AUDITDATE=?"
				+ ",AUDITUSERNAME=?,PUBLICEDATE=?,PUBLICBDATE=?,ISPUBLIC=?,CREATEDATE=?"
				+ ",USERNAME=?,PUNISHMONEY=?,PUNISHDEPARTTYPE=?,departId=?,personName=?"
				+ ",idCardTypeNum=?,idCard18=? "
				+ "where badPersonId=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,personBadIntegrity.getCorpName()); //��ҵ����
			pstmt.setString(2,personBadIntegrity.getCorpCode());//��֯��������
			pstmt.setString(3,personBadIntegrity.getCreditType());//������Ϊ���(�ֵ��TBCORPBADDIC)
			pstmt.setString(4,personBadIntegrity.getCreditCode());//������Ϊ����(�ֵ��TBCORPBADDIC)
			pstmt.setDate(5,personBadIntegrity.getHappenDate());//������Ϊ��������
			pstmt.setString(6,personBadIntegrity.getPrjNum());//��Ŀ���
			pstmt.setString(7,personBadIntegrity.getDepartName());//�Ǽǲ���
			pstmt.setString(8,personBadIntegrity.getPunishEvidence());//��������
			pstmt.setString(9,personBadIntegrity.getPunishContent());//������������
			pstmt.setString(10,personBadIntegrity.getPunishNumber());//���������ĺ�
			pstmt.setDate(11,personBadIntegrity.getPunishDate());//��������
			pstmt.setDate(12,personBadIntegrity.getPunishEDate());//������������
			pstmt.setString(13,personBadIntegrity.getSpecialtyTypNum());//��Ա����(�ֵ��TBSPECIALTYTYPEDIC)
			pstmt.setString(14,personBadIntegrity.getPrjName()); //��������
			pstmt.setString(15,personBadIntegrity.getAddress());	//���̵�ַ
			pstmt.setString(16,personBadIntegrity.getBuildCorpName());//���赥λ
			pstmt.setString(17,personBadIntegrity.getBuildCorpCode());//���赥λ��֯��������
			pstmt.setString(18,personBadIntegrity.getProvinceNum());//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setString(19,personBadIntegrity.getCityNum());//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
			pstmt.setString(20,personBadIntegrity.getCountyNum());//������Ϊ������������(�ֵ��TBXZQDMDIC)
			pstmt.setString(21,personBadIntegrity.getCreditClassNum());//������Ϊ����(�ֵ��TBCREDITTYPE)
			pstmt.setString(22,personBadIntegrity.getContent());//������Ϊ����
			pstmt.setString(23,personBadIntegrity.getPunishDepartName());//��������
			pstmt.setDate(24,personBadIntegrity.getAuditDate());//���ʱ�䣨����ʱ����д��
			pstmt.setString(25,personBadIntegrity.getAuditUserName());//����쵼
			pstmt.setDate(26,personBadIntegrity.getPublicEDate());//��������ʱ�䣨����ʱ����д��
			pstmt.setDate(27,personBadIntegrity.getPublicBDate()); //������ʼʱ�䣨����ʱ����д��
			pstmt.setString(28,personBadIntegrity.getIsPublic());	//�Ƿ񷢲���0��δ������1���ѷ���
			pstmt.setDate(29,personBadIntegrity.getCreateDate());//�Ǽ�����
			pstmt.setString(30,personBadIntegrity.getUserName()); //�Ǽ�������
			pstmt.setString(31,personBadIntegrity.getPunishMoney());//�������
			pstmt.setString(32,personBadIntegrity.getPunishDepartType());//�������ż���0��������1��ʡ�У�2�����У�3������
			pstmt.setString(33,personBadIntegrity.getDepartId());//�Ǽǲ���Id
			pstmt.setString(34, personBadIntegrity.getPersonName());//����
			pstmt.setString(35, personBadIntegrity.getIdCardTypeNum());//֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(36, personBadIntegrity.getIdCard18());//֤������
			pstmt.setString(37,personBadIntegrity.getBadPersonId());	//����
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String badPersonId)
	{
		String sql = "update TBREGPERSONBADCREDITINFO set delType=? where badPersonId=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,"1"); //����
			pstmt.setString(2,badPersonId); //����
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
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
	
	
	//��Ա����(TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySpecialtyTypNums(){
		String sql = "select code,TYPELEVEL from TBSPECIALTYTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("TYPELEVEL"));
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
	//������Ϊ����(TBCREDITTYPE)
	public List<DictionaryClass> queryCreditClassNums(){
		String sql = "select code,BADBEHAVIOUR from TBCREDITTYPE";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("BADBEHAVIOUR"));
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
	
	//֤������(�ֵ��TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNums()
	{
		String sql = "select code,PAPERTYPE from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("PAPERTYPE"));
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
	
	//������Ϊ���(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditType(){
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		return list;
	}
	//������Ϊ����(TBCORPBADDIC)
	public List<DictionaryClass> queryCreditCodes(){
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		return list;
	}
	//��������(TBCORPBADDIC)
	public List<DictionaryClass> queryPuishEvidences(){
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		
		return list;
	}
}
