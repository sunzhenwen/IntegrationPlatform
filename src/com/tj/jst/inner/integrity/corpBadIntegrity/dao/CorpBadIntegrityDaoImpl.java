package com.tj.jst.inner.integrity.corpBadIntegrity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;
import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.integrity.corpBadIntegrity.model.CorpBadIntegrity;

/**
 * ��ҵ������Ϊ����
 * @author hhc
 *
 */
public class CorpBadIntegrityDaoImpl extends BaseDao implements ICorpBadIntegrityDao {

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
					CorpBadIntegrity cbi = new CorpBadIntegrity();
					cbi.setCorpBadCreditId(rs.getString("corpBadCreditId")); //����
					cbi.setCorpName(rs.getString("corpName"));
					cbi.setCorpCode(rs.getString("corpCode"));
					cbi.setCertTypeNum(rs.getString("certTypeNum"));
					cbi.setPrjNum(rs.getString("prjNum"));
					cbi.setPrjName(rs.getString("prjName"));
					cbi.setAddress(rs.getString("address"));
					cbi.setBuildCorpName(rs.getString("buildCorpName"));
					cbi.setBuildCorpCode(rs.getString("buildCorpCode"));
					cbi.setProvinceNum(rs.getString("provinceNum"));
					cbi.setCityNum(rs.getString("cityNum"));
					cbi.setCountyNum(rs.getString("countyNum"));
					cbi.setCreditClassNum(rs.getString("creditClassNum"));
					cbi.setCreditType(rs.getString("creditType"));
					cbi.setCreditCode(rs.getString("creditCode"));
					cbi.setContent(rs.getString("content"));
					cbi.setPunishDepartName(rs.getString("punishDepartName"));
					cbi.setPunishDepartType(rs.getString("punishDepartType"));
					cbi.setPunishEvidence(rs.getString("punishEvidence"));
					cbi.setPunishContent(rs.getString("punishContent"));
					cbi.setPunishNumber(rs.getString("punishNumber"));
					cbi.setPunishMoney(rs.getString("punishMoney"));
					cbi.setDepartName(rs.getString("departName"));
					cbi.setUserName(rs.getString("userName"));
					cbi.setIsPublic(rs.getString("isPublic"));
					cbi.setAuditUserName(rs.getString("auditUserName"));
					cbi.setHappenDate(rs.getDate("happenDate"));
					cbi.setPunishDate(rs.getDate("punishDate"));
					cbi.setPunishEDate(rs.getDate("punishEDate"));
					cbi.setCreateDate(rs.getDate("createDate"));
					cbi.setPublicBDate(rs.getDate("publicBDate"));
					cbi.setPublicEDate(rs.getDate("publicEDate"));
					cbi.setAuditDate(rs.getDate("auditDate"));
					
					page.getData().add(cbi);
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
	public void add(CorpBadIntegrity corpBadIntegrity)
	{
		String sql = "insert into tbcorpbadcreditinfo(CORPBADCREDITID,CORPNAME,CORPCODE,CREDITTYPE"
				+ ",CREDITCODE,HAPPENDATE,PRJNUM,DEPARTNAME,PUNISHEVIDENCE,PUNISHCONTENT"
				+ ",PUNISHNUMBER,PUNISHDATE,PUNISHEDATE,CERTTYPENUM,PRJNAME,ADDRESS,BUILDCORPNAME"
				+ ",BUILDCORPCODE,PROVINCENUM,CITYNUM,COUNTYNUM,CREDITCLASSNUM,CONTENT"
				+ ",PUNISHDEPARTNAME,AUDITDATE,AUDITUSERNAME,PUBLICEDATE,PUBLICBDATE,ISPUBLIC"
				+ ",CREATEDATE,USERNAME,PUNISHMONEY,PUNISHDEPARTTYPE,delType,departId) "
				+"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpBadCreditId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpBadCreditId);	//����
			pstmt.setString(2,corpBadIntegrity.getCorpName()); 	//��ҵ����
			pstmt.setString(3,corpBadIntegrity.getCorpCode());//��֯��������
			pstmt.setString(4,corpBadIntegrity.getCreditType());//������Ϊ���(�ֵ��TBCORPBADDIC)
			pstmt.setString(5,corpBadIntegrity.getCreditCode());//������Ϊ����(�ֵ��TBCORPBADDIC)
			pstmt.setDate(6,corpBadIntegrity.getHappenDate());//������Ϊ��������
			pstmt.setString(7,corpBadIntegrity.getPrjNum());//��Ŀ���
			pstmt.setString(8,corpBadIntegrity.getDepartName());//�Ǽǲ���
			pstmt.setString(9,corpBadIntegrity.getPunishEvidence());//��������
			pstmt.setString(10,corpBadIntegrity.getPunishContent());//������������
			pstmt.setString(11,corpBadIntegrity.getPunishNumber());//���������ĺ�
			pstmt.setDate(12,corpBadIntegrity.getPunishDate());//��������
			pstmt.setDate(13,corpBadIntegrity.getPunishEDate());//������������
			pstmt.setString(14,corpBadIntegrity.getCertTypeNum());//��ҵ����(�ֵ��TBAPTITUDEKINDDIC)
			pstmt.setString(15,corpBadIntegrity.getPrjName()); //��������
			pstmt.setString(16,corpBadIntegrity.getAddress());	//���̵�ַ
			pstmt.setString(17,corpBadIntegrity.getBuildCorpName());//���赥λ
			pstmt.setString(18,corpBadIntegrity.getBuildCorpCode());//���赥λ��֯��������
			pstmt.setString(19,corpBadIntegrity.getProvinceNum());//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setString(20,corpBadIntegrity.getCityNum());//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
			pstmt.setString(21,corpBadIntegrity.getCountyNum());//������Ϊ������������(�ֵ��TBXZQDMDIC)
			pstmt.setString(22,corpBadIntegrity.getCreditClassNum());//������Ϊ����(�ֵ��TBCREDITTYPE)
			pstmt.setString(23,corpBadIntegrity.getContent());//������Ϊ����
			pstmt.setString(24,corpBadIntegrity.getPunishDepartName());//��������
			pstmt.setDate(25,corpBadIntegrity.getAuditDate());//���ʱ�䣨����ʱ����д��
			pstmt.setString(26,corpBadIntegrity.getAuditUserName());//����쵼
			pstmt.setDate(27,corpBadIntegrity.getPublicEDate());//��������ʱ�䣨����ʱ����д��
			pstmt.setDate(28,corpBadIntegrity.getPublicBDate()); //������ʼʱ�䣨����ʱ����д��
			pstmt.setString(29,corpBadIntegrity.getIsPublic());	//�Ƿ񷢲���0��δ������1���ѷ���
			pstmt.setDate(30, corpBadIntegrity.getCreateDate());//�Ǽ�����
			pstmt.setString(31, corpBadIntegrity.getUserName()); //�Ǽ�������
			pstmt.setString(32, corpBadIntegrity.getPunishMoney());//�������
			pstmt.setString(33, corpBadIntegrity.getPunishDepartType());//�������ż���0��������1��ʡ�У�2�����У�3������
			pstmt.setString(34, "0");
			pstmt.setString(35, corpBadIntegrity.getDepartId());//�Ǽǲ���Id
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
	 * @param corpBadCreditId
	 * @return
	 */
	public CorpBadIntegrity queryById(String corpBadCreditId)
	{
		String sql = "select * from tbcorpbadcreditinfo where CORPBADCREDITID=? ";
		CorpBadIntegrity corpBadIntegrity = new CorpBadIntegrity();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpBadCreditId);	//����
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				corpBadIntegrity.setCorpBadCreditId(rs.getString("corpBadCreditId"));//����
				corpBadIntegrity.setCorpName(rs.getString("CORPNAME")); 	//��ҵ����
				corpBadIntegrity.setCorpCode(rs.getString("CORPCODE"));//��֯��������
				corpBadIntegrity.setCreditType(rs.getString("CREDITTYPE"));//������Ϊ���(�ֵ��TBCORPBADDIC)
				corpBadIntegrity.setCreditCode(rs.getString("CREDITCODE"));//������Ϊ����(�ֵ��TBCORPBADDIC)
				corpBadIntegrity.setHappenDate(rs.getDate("HAPPENDATE"));//������Ϊ��������
				corpBadIntegrity.setPrjNum(rs.getString("PRJNUM"));//��Ŀ���
				corpBadIntegrity.setDepartName(rs.getString("DEPARTNAME"));//�Ǽǲ���
				corpBadIntegrity.setPunishEvidence(rs.getString("PUNISHEVIDENCE"));//��������
				corpBadIntegrity.setPunishContent(rs.getString("PUNISHCONTENT"));//������������
				corpBadIntegrity.setPunishNumber(rs.getString("PUNISHNUMBER"));//���������ĺ�
				corpBadIntegrity.setPunishDate(rs.getDate("PUNISHDATE"));//��������
				corpBadIntegrity.setPunishEDate(rs.getDate("PUNISHEDATE"));//������������
				corpBadIntegrity.setCertTypeNum(rs.getString("CERTTYPENUM"));//��ҵ����(�ֵ��TBAPTITUDEKINDDIC)
				corpBadIntegrity.setPrjName(rs.getString("PRJNAME")); //��������
				corpBadIntegrity.setAddress(rs.getString("ADDRESS"));	//���̵�ַ
				corpBadIntegrity.setBuildCorpName(rs.getString("BUILDCORPNAME"));//���赥λ
				corpBadIntegrity.setBuildCorpCode(rs.getString("BUILDCORPCODE"));//���赥λ��֯��������
				corpBadIntegrity.setProvinceNum(rs.getString("PROVINCENUM"));//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
				corpBadIntegrity.setCityNum(rs.getString("CITYNUM"));//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
				corpBadIntegrity.setCountyNum(rs.getString("COUNTYNUM"));//������Ϊ������������(�ֵ��TBXZQDMDIC)
				corpBadIntegrity.setCreditClassNum(rs.getString("CREDITCLASSNUM"));//������Ϊ����(�ֵ��TBCREDITTYPE)
				corpBadIntegrity.setContent(rs.getString("CONTENT"));//������Ϊ����
				corpBadIntegrity.setPunishDepartName(rs.getString("PUNISHDEPARTNAME"));//��������
				corpBadIntegrity.setAuditDate(rs.getDate("AUDITDATE"));//���ʱ�䣨����ʱ����д��
				corpBadIntegrity.setAuditUserName(rs.getString("AUDITUSERNAME"));//����쵼
				corpBadIntegrity.setPublicEDate(rs.getDate("PUBLICEDATE"));//��������ʱ�䣨����ʱ����д��
				corpBadIntegrity.setPublicBDate(rs.getDate("PUBLICBDATE")); //������ʼʱ�䣨����ʱ����д��
				corpBadIntegrity.setIsPublic(rs.getString("ISPUBLIC"));	//�Ƿ񷢲���0��δ������1���ѷ���
				corpBadIntegrity.setCreateDate(rs.getDate("CREATEDATE"));//�Ǽ�����
				corpBadIntegrity.setUserName(rs.getString("USERNAME")); //�Ǽ�������
				corpBadIntegrity.setPunishMoney(rs.getString("PUNISHMONEY"));//�������
				corpBadIntegrity.setPunishDepartType(rs.getString("PUNISHDEPARTTYPE"));//�������ż���0��������1��ʡ�У�2�����У�3������
				corpBadIntegrity.setDepartId(rs.getString("DEPARTID"));//�Ǽǲ���Id
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corpBadIntegrity;
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(CorpBadIntegrity corpBadIntegrity)
	{
		String sql = "update tbcorpbadcreditinfo set CORPNAME=?,CORPCODE=?,CREDITTYPE=?"
				+ ",CREDITCODE=?,HAPPENDATE=?,PRJNUM=?,DEPARTNAME=?,PUNISHEVIDENCE=?"
				+ ",PUNISHCONTENT=?,PUNISHNUMBER=?,PUNISHDATE=?,PUNISHEDATE=?,CERTTYPENUM=?"
				+ ",PRJNAME=?,ADDRESS=?,BUILDCORPNAME=?,BUILDCORPCODE=?,PROVINCENUM=?,CITYNUM=?"
				+ ",COUNTYNUM=?,CREDITCLASSNUM=?,CONTENT=?,PUNISHDEPARTNAME=?,AUDITDATE=?"
				+ ",AUDITUSERNAME=?,PUBLICEDATE=?,PUBLICBDATE=?,ISPUBLIC=?,CREATEDATE=?"
				+ ",USERNAME=?,PUNISHMONEY=?,PUNISHDEPARTTYPE=?,departId=? "
				+ "where CORPBADCREDITID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,corpBadIntegrity.getCorpName()); //��ҵ����
			pstmt.setString(2,corpBadIntegrity.getCorpCode());//��֯��������
			pstmt.setString(3,corpBadIntegrity.getCreditType());//������Ϊ���(�ֵ��TBCORPBADDIC)
			pstmt.setString(4,corpBadIntegrity.getCreditCode());//������Ϊ����(�ֵ��TBCORPBADDIC)
			pstmt.setDate(5,corpBadIntegrity.getHappenDate());//������Ϊ��������
			pstmt.setString(6,corpBadIntegrity.getPrjNum());//��Ŀ���
			pstmt.setString(7,corpBadIntegrity.getDepartName());//�Ǽǲ���
			pstmt.setString(8,corpBadIntegrity.getPunishEvidence());//��������
			pstmt.setString(9,corpBadIntegrity.getPunishContent());//������������
			pstmt.setString(10,corpBadIntegrity.getPunishNumber());//���������ĺ�
			pstmt.setDate(11,corpBadIntegrity.getPunishDate());//��������
			pstmt.setDate(12,corpBadIntegrity.getPunishEDate());//������������
			pstmt.setString(13,corpBadIntegrity.getCertTypeNum());//��ҵ����(�ֵ��TBAPTITUDEKINDDIC)
			pstmt.setString(14,corpBadIntegrity.getPrjName()); //��������
			pstmt.setString(15,corpBadIntegrity.getAddress());	//���̵�ַ
			pstmt.setString(16,corpBadIntegrity.getBuildCorpName());//���赥λ
			pstmt.setString(17,corpBadIntegrity.getBuildCorpCode());//���赥λ��֯��������
			pstmt.setString(18,corpBadIntegrity.getProvinceNum());//������Ϊ��������ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setString(19,corpBadIntegrity.getCityNum());//������Ϊ�������ڵ���(�ֵ��TBXZQDMDIC)
			pstmt.setString(20,corpBadIntegrity.getCountyNum());//������Ϊ������������(�ֵ��TBXZQDMDIC)
			pstmt.setString(21,corpBadIntegrity.getCreditClassNum());//������Ϊ����(�ֵ��TBCREDITTYPE)
			pstmt.setString(22,corpBadIntegrity.getContent());//������Ϊ����
			pstmt.setString(23,corpBadIntegrity.getPunishDepartName());//��������
			pstmt.setDate(24,corpBadIntegrity.getAuditDate());//���ʱ�䣨����ʱ����д��
			pstmt.setString(25,corpBadIntegrity.getAuditUserName());//����쵼
			pstmt.setDate(26,corpBadIntegrity.getPublicEDate());//��������ʱ�䣨����ʱ����д��
			pstmt.setDate(27,corpBadIntegrity.getPublicBDate()); //������ʼʱ�䣨����ʱ����д��
			pstmt.setString(28,corpBadIntegrity.getIsPublic());	//�Ƿ񷢲���0��δ������1���ѷ���
			pstmt.setDate(29,corpBadIntegrity.getCreateDate());//�Ǽ�����
			pstmt.setString(30,corpBadIntegrity.getUserName()); //�Ǽ�������
			pstmt.setString(31,corpBadIntegrity.getPunishMoney());//�������
			pstmt.setString(32,corpBadIntegrity.getPunishDepartType());//�������ż���0��������1��ʡ�У�2�����У�3������
			pstmt.setString(33,corpBadIntegrity.getDepartId());//�Ǽǲ���Id
			pstmt.setString(34,corpBadIntegrity.getCorpBadCreditId());	//����
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
	public void delete(String corpBadCreditId)
	{
		String sql = "update tbcorpbadcreditinfo set delType=? where CORPBADCREDITID=? ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1");//ɾ��״̬
			pstmt.setString(2,corpBadCreditId); //����
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
	
	
	//��ҵ����(TBAPTITUDEKINDDIC)
	public List<DictionaryClass> queryCertTypeNums(){
		String sql = "select code,corpregtype from TBECONTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("corpregtype"));
				dictionaryClass.setCode(rs.getString("code"));
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
}
