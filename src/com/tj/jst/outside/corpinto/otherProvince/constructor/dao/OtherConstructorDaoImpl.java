package com.tj.jst.outside.corpinto.otherProvince.constructor.dao;

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
import com.tj.jst.outside.business.contractFiling.model.CertdetailInfo;
import com.tj.jst.outside.business.contractFiling.model.Certinfo;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * ��ʡע�Ὠ��ʦ
 * @author Administrator
 *
 */
public class OtherConstructorDaoImpl extends BaseDao implements IOtherConstructorDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Constructor constructor = new Constructor();
				    constructor.setPersonId(rs.getString("PERSONID"));			//����
				    constructor.setPersonName(rs.getString("personName"));		//����
					constructor.setSexName(rs.getString("sexName")); 			//�Ա�(�ֵ��TBSEXDIC)
					constructor.setIdCardTypeName(rs.getString("idCardTypeName")); //֤������(�ֵ��TBIDCARDTYPEDIC)
					constructor.setIdCard(rs.getString("idCard")); 				//���֤��(����Ϊ18λ)
					constructor.setBirthday(rs.getDate("birthday")); 			//����
					constructor.setNationAlityName(rs.getString("paperTypeName"));//����(�ֵ��TBNATIONDIC)
					constructor.setEduLevelName(rs.getString("eduLevelName")); 	//ѧ��(�ֵ��TBEDULEVELDIC)
					constructor.setDegreeName(rs.getString("degreeName")); 		//ѧλ(�ֵ��TBDEGREEDIC)
					constructor.setMobile(rs.getString("mobile")); 				//�ֻ�����
					constructor.setSepecialtyTypName(rs.getString("specialtytypname"));//ע�����ͼ��ȼ�����
					constructor.setCertNum(rs.getString("certNum"));//ע��֤����
					constructor.setAwardDate(rs.getDate("awardDate"));//��֤����
					constructor.setAwardDepart(rs.getString("awardDepart"));//��֤��λ
					constructor.setStampNum(rs.getString("stampNum"));//ִҵӡ�º�
					constructor.setEffectDate(rs.getDate("effectDate"));//ע����Ч��
					constructor.setCallingTypeName(rs.getString("callingTypeName"));//������ҵ��ҵ����
					constructor.setCertId(rs.getString("certId"));//������ҵ֤����
					constructor.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));//ע�Ὺʼ����(1-8)
					constructor.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));//ע���ֹ����(1-8)
					constructor.setRegTradeTypeName(rs.getString("regTradeTypeName")); //��Աע��רҵ 
					constructor.setCorpCode(rs.getString("corpcode"));//��֯��������
					constructor.setDataSource(rs.getString("dataSource"));
				    page.getData().add(constructor);
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

	//ѧ��
	@Override
	public List<DictionaryClass> eduLevelNums() {
		String sql = "select * from TBEDULEVELDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("diploma"));
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

	//ѧλ
	@Override
	public List<DictionaryClass> degreeNums() {
		String sql = "select * from TBDEGREEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("degree"));
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

	//��ѯ��ϸ
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		String sql = "select t.*,"
				+ "(select a.papertype from TBIDCARDTYPEDIC a where a.code=t.idcardtypenum) as idCardTypeName,"
				+ "(select b.typelevel from TBSPECIALTYTYPEDIC b where b.code=t.specialtytypnum) as sepecialtyTypName,"
				+ "(select c.type from TBCALLINGTYPEDIC c where c.code=t.callingtypenum) as callingTypeName,"
				+ "(select d.discipline from TBREGTRADETYPEDIC d where d.code=t.regtradetypenum) as regTradeTypeName,"
				+ "(select e.status from TBQSTATEDIC e where e.code=t.qstate) as qStateName "
				+ "from TBREGPERSONREGINFO t where t.idCard18=? and t.corpCode=? ";

		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			pstmt.setString(2, corpCode);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard18"));
				constructor.setSepecialtyTypName(rs.getString("sepecialtyTypName"));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeName(rs.getString("callingTypeName"));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeName(rs.getString("regTradeTypeName"));
				constructor.setRegTradeTypeNum(rs.getString("REGTRADETYPENUM"));
				constructor.setTradeTypeAwardDate(rs.getDate("TRADETYPEAWARDDATE"));
				constructor.setTradeTypeEffectDate(rs.getDate("TRADETYPEEFFECTDATE"));
				constructor.setStateName(rs.getString("qStateName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return constructor;
	}
	
	//��ѯ�н����е�����(����ʦ)
	public List<Constructor> queryImportConstructor(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//����ʦ
		String sql = "select "
				+ "a.personname,"
				+ "a.idcardtypenum,"
				+ "a.idcard18,"
				+ "a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "'2' callingtypenum,a.corpname, a.corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "case when  b.TradeTypeNum is null then 1  else b.TradeTypeNum end  as  regtradetypenum,"
				+ "case when to_char(b.Yxqq,'yyyy-MM-dd')='' or b.Yxqq is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(b.Yxqq,'yyyy-MM-dd') end  as tradetypeawarddate,"
				+ "case when to_char(b.Yxqz,'yyyy-MM-dd')='' or b.Yxqz is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(b.Yxqz,'yyyy-MM-dd') end  as tradetypeeffectdate,"
				+ "a.qstate,"
				+ "updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a left join  zjb_TBregPersonZczy b "
				+ "on a.idcard18=b.idcard18 "
				+ "where��a.specialtytypnum��in��('81','82','83','84') and a.corpcode=?";

		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("specialtytypnum"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("UPDATETIME"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	//��ѯ�н����е�����(������ʦ ��һרҵ)
	public List<Constructor> queryImportSupervisorOne(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//������ʦ ��һרҵ
		String sql = "select a.personname,a.idcardtypenum,a.idcard18,a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "callingtypenum,"
				+ "case when a.corpname='' or a.corpname is null then '-1'  else a.corpname end  as corpname,"
				+ "case when a.corpcode='' or a.corpcode is null then '-1'  else a.corpcode end  as  corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "case when  a.Regspec1 is null then 1  else a.Regspec1 end  as  regtradetypenum,"
				+ "a.qstate,updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a where��a.specialtytypnum='71' "
				+ "and a.corpcode=?";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("SPECIALTYTYPNUM"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	//��ѯ�н����е�����(������ʦ �ڶ�רҵ)
	public List<Constructor> queryImportSupervisorTwo(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		
		//������ʦ �ڶ�רҵ
		String sql = "select a.personname,a.idcardtypenum,a.idcard18,a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "callingtypenum,"
				+ "case when a.corpname='' or a.corpname is null then '-1'  else a.corpname end  as corpname,"
				+ "case when a.corpcode='' or a.corpcode is null then '-1'  else a.corpcode end  as  corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "case when  a.Regspec2 is null then 1  else a.Regspec2 end  as  regtradetypenum,"
				+ "a.qstate,"
				+ "updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a "
				+ "where��a.specialtytypnum='71' and a.Regspec2!=0 "
				+ "and   a.corpcode=?";
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("SPECIALTYTYPNUM"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("tradeTypeAwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("tradeTypeEffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//��ѯ�н����е�����(���˽���ʦ�ͼ�����ʦ�����)
	public List<Constructor> queryImportOther(String corpName,String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//���˽���ʦ�ͼ�����ʦ�����
		String sql = "select a.personname,a.idcardtypenum,a.idcard18,a.specialtytypnum,"
				+ "case when a.certnum='' or a.certnum is null then '-1'  else a.certnum end  as certnum,"
				+ "case when to_char(a.awarddate,'yyyy-MM-dd')='' or to_char(a.awarddate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.awarddate,'yyyy-MM-dd') end as awarddate,"
				+ "case when  a.awarddepart='' or  a.awarddepart is null then '-1'  else  a.awarddepart end  as awarddepart,"
				+ "case when a.stampnum='' or a.stampnum is null then '-1'  else a.stampnum end  as stampnum,"
				+ "case when to_char(a.effectdate,'yyyy-MM-dd')='' or to_char(a.effectdate,'yyyy-MM-dd') is null then to_char(sysdate,'yyyy-MM-dd')  else to_char(a.effectdate,'yyyy-MM-dd') end as effectdate,"
				+ "callingtypenum,"
				+ "case when a.corpname='' or a.corpname is null then '-1'  else a.corpname end  as corpname,"
				+ "case when a.corpcode='' or a.corpcode is null then '-1'  else a.corpcode end  as  corpcode,"
				+ "case when a.certid='' or a.certid is null then '-1'  else a.certid end  as certid,"
				+ "'-1'  regtradetypenum,a.qstate,"
				+ "updatetime,"
				+ "'1' oldornew,'07' datasource,'' ftype "
				+ "from  zjb_TBRegPersonReginfo a "
				+ "where��a.specialtytypnum not in ('71','81','82','83','84') and "
				+ "a.corpcode=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("IDCARD18"));
				cs.setSepecialtyTypNum(rs.getString("SPECIALTYTYPNUM"));
				cs.setCertNum(rs.getString("certNum"));
				cs.setAwardDate(rs.getDate("awardDate"));
				cs.setAwardDepart(rs.getString("awardDepart"));
				cs.setStampNum(rs.getString("stampNum"));
				cs.setEffectDate(rs.getDate("effectDate"));
				cs.setCallingTypeNum(rs.getString("callingTypeNum"));
				cs.setCorpName(rs.getString("corpName"));
				cs.setCorpCode(rs.getString("corpCode"));
				cs.setCertId(rs.getString("certId"));
				cs.setRegTradeTypeNum(rs.getString("regTradeTypeNum"));
				cs.setTradeTypeAwardDate(rs.getDate("AwardDate"));
				cs.setTradeTypeEffectDate(rs.getDate("EffectDate"));
				cs.setqState(rs.getString("qState"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return list;
	}
	
	//���м�����µ���������
	public boolean importData(List<Constructor> list,String corpCode)
	{
		boolean check = true;
		//��ɾ��������
		this.deletePersonInfo(corpCode);
		try{
				conn = ConnectionFactory.getBasicConnection();
				// ȡ���Զ��ύ
	            conn.setAutoCommit(false);
				//�ٲ�����м�����������
				pstmt = conn.prepareStatement("insert into TBREGPERSONREGINFO"
						+ "(personId,personName,idCardTypeNum,IDCARD18,"
						+ "SPECIALTYTYPNUM,certNum,awardDate,awardDepart,stampNum,effectDate,"
						+ "callingTypeNum,corpName,corpCode,certId,regTradeTypeNum,tradeTypeAwardDate,"
						+ "tradeTypeEffectDate,qState,updateTime,oldOrNew,dataSource) values "
						+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for(int i=0;i<list.size();i++)
	            {
	            	pstmt.setString(1,list.get(i).getPersonId());
					pstmt.setString(2,list.get(i).getPersonName());
					pstmt.setString(3,list.get(i).getIdCardTypeNum().trim());
					pstmt.setString(4,list.get(i).getIdCard());
					pstmt.setString(5,list.get(i).getSepecialtyTypNum());
					pstmt.setString(6,list.get(i).getCertNum());
					pstmt.setDate(7,list.get(i).getAwardDate());
					pstmt.setString(8,list.get(i).getAwardDepart());
					pstmt.setString(9,list.get(i).getStampNum());
					pstmt.setDate(10,list.get(i).getEffectDate());
					pstmt.setString(11,list.get(i).getCallingTypeNum());
					pstmt.setString(12,list.get(i).getCorpName());
					pstmt.setString(13,list.get(i).getCorpCode());
					pstmt.setString(14,list.get(i).getCertId());
					pstmt.setString(15,list.get(i).getRegTradeTypeNum());
					pstmt.setDate(16,list.get(i).getTradeTypeAwardDate());
					pstmt.setDate(17,list.get(i).getTradeTypeEffectDate());
					pstmt.setString(18,list.get(i).getqState());
					pstmt.setDate(19,list.get(i).getUpdateTime());
					pstmt.setString(20,list.get(i).getOldOrNew());
					pstmt.setString(21,"07");
					pstmt.addBatch();
				}
				
				pstmt.executeBatch();
	            // ���û�д������ʾ��������ִ�� �ֹ��ύ
	            conn.commit();
	            //ɾ���м������
	            this.deleteZjbPersonInfo(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//��ѯ�м����Ա��������
	public List<Constructor> queryBasePerson(String corpCode)
	{
		String personId = UUID.randomUUID().toString();
		List<Constructor> list = new ArrayList<Constructor>();
		//��ѯ��Ա�����м��
		String sql = "select a.PersonName personname,"
				+ "a.SexNum sexnum,"
				+ "a.IDCardTypeNum idcardtypenum,"
				+ "a.IDCard18 idcard,"
				+ "is_date(a.Birthday) ISDATE,"
				+ "a.Birthday,"
				+ "case when  a.NationalityNum  is null then 1  else a.NationalityNum  end  as  nationalitynum,"
				+ "a.EduLevelNum edulevelnum,"
				+ "a.DegreeNum  degreenum,"
				+ "a.Mobile mobile,"
				+ "'' corpid,"
				+ "'' personid,"
				+ "sysdate updatetime,"
				+ "'1' oldornew ,"
				+ "'07' datasource,"
				+ "corpcode "
				+ "from zjb_tbregpersonbasicinfo a where corpCode=?	";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Constructor cs = new Constructor();
				cs.setPersonId(personId);
				cs.setPersonName(rs.getString("personName"));
				cs.setSexNum(rs.getString("sexNum"));
				cs.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				cs.setIdCard(rs.getString("idCard"));
				cs.setIsDate(rs.getString("isDate"));
				cs.setBirthday(rs.getDate("birthday"));
				cs.setNationAlityNum(rs.getString("nationAlityNum"));
				cs.setEduLevelNum(rs.getString("eduLevelNum"));
				cs.setDegreeNum(rs.getString("degreeNum"));
				cs.setMobile(rs.getString("mobile"));
				cs.setCorpId(rs.getString("corpId"));
				cs.setPersonId(rs.getString("personId"));
				cs.setUpdateTime(rs.getDate("updateTime"));
				cs.setOldOrNew(rs.getString("oldOrNew"));
				cs.setDataSource(rs.getString("dataSource"));
				cs.setCorpCode(rs.getString("corpCode"));
				list.add(cs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//���м������Ա��������
	public boolean importBasePerson(List<Constructor> list,String corpCode)
	{
		boolean check = true;
		//��ɾ��������
		this.deletePersonBase(corpCode);
		try{
				conn = ConnectionFactory.getBasicConnection();
				// ȡ���Զ��ύ
	            conn.setAutoCommit(false);
				//�ٲ�����м�����������
				pstmt = conn.prepareStatement("insert into tbregpersonbasicinfo"
						+ "(personId,personName,sexNum,idCardTypeNum,"
						+ "idCard,birthday,nationAlityNum,eduLevelNum,degreeNum,"
						+ "mobile,corpId,updateTime,oldOrNew,dataSource,corpCode) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				for(int i=0;i<list.size();i++)
	            {
	            	pstmt.setString(1,list.get(i).getPersonId());
	            	pstmt.setString(2,list.get(i).getPersonName());
					pstmt.setString(3,list.get(i).getSexNum());
					pstmt.setString(4,list.get(i).getIdCardTypeNum());
					pstmt.setString(5,list.get(i).getIdCard());
					pstmt.setDate(6,list.get(i).getBirthday());
					pstmt.setString(7,list.get(i).getNationAlityNum());
					pstmt.setString(8,list.get(i).getEduLevelNum());
					pstmt.setString(9,list.get(i).getDegreeNum());
					pstmt.setString(10,list.get(i).getMobile());
					pstmt.setString(11,list.get(i).getCorpId());
					pstmt.setDate(12,list.get(i).getUpdateTime());
					pstmt.setString(13,list.get(i).getOldOrNew());
					pstmt.setString(14,"07");
					pstmt.setString(15,list.get(i).getCorpCode());
					pstmt.addBatch();
				}
				
				pstmt.executeBatch();
	            // ���û�д������ʾ��������ִ�� �ֹ��ύ
	            conn.commit();
	            //ɾ���м����Ա��������
	            this.deleteZjbPersonBase(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//ɾ����Ա������Ϣ
	public void deletePersonBase(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from tbregpersonbasicinfo where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//ɾ���м����Ա������Ϣ
	public void deleteZjbPersonBase(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_tbregpersonbasicinfo where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//ɾ����Ա��Ϣ��
	public void deletePersonInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from TBREGPERSONREGINFO where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//ɾ���м����Ա��Ϣ��
	public void deleteZjbPersonInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_TBREGPERSONREGINFO where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//��ѯ��ҵ�����м��(֤���)
	public List<Certinfo> queryCertinfo(String corpCode)
	{
		List<Certinfo> list = new ArrayList<Certinfo>();
		//��ѯ��Ա�����м��
		String sql = "select CertID,CertTypeNum,TitleLevelNum,CorpName,CorpCode,LicenseNum,"
				+ "ProvinceNum,CityNum,CountyNum,Address,RegPrin,EconomicNum,LegalMan,"
				+ "LegalManDuty,LegaManProTitle,TechMan,TechManDuty,TechManProTitle,"
				+ "UnitMan,UnitManDuty,UnitManProTitle,OrganName,OrganDate,EndDate,IsValid,"
				+ "'1' oldornew,'07' datasource "
				+ "from ZJB_TBCorpCertinfo where corpCode=?	";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Certinfo ct = new Certinfo();
				ct.setCertID(rs.getString("certID"));
				ct.setCertTypeNum(rs.getString("certTypeNum"));
				ct.setTitleLevelNum(rs.getString("titleLevelNum"));
				ct.setCorpName(rs.getString("corpName"));
				ct.setCorpCode(rs.getString("corpCode"));
				ct.setLicenseNum(rs.getString("licenseNum"));
				ct.setProvinceNum(rs.getString("provinceNum"));
				ct.setCityNum(rs.getString("cityNum"));
				ct.setCountyNum(rs.getString("countyNum"));
				ct.setAddress(rs.getString("address"));
				ct.setRegPrin(rs.getString("regPrin"));
				ct.setEconomicNum(rs.getString("economicNum"));
				ct.setLegalMan(rs.getString("legalMan"));
				ct.setLegalManDuty(rs.getString("legalManDuty"));
				ct.setLegaManProTitle(rs.getString("legaManProTitle"));
				ct.setTechMan(rs.getString("techMan"));
				ct.setTechManDuty(rs.getString("techManDuty"));
				ct.setTechManProTitle(rs.getString("techManProTitle"));
				ct.setUnitMan(rs.getString("unitMan"));
				ct.setUnitManDuty(rs.getString("unitManDuty"));
				ct.setUnitManProTitle(rs.getString("unitManProTitle"));
				ct.setOrganName(rs.getString("organName"));
				ct.setOrganDate(rs.getDate("organDate"));
				ct.setEndDate(rs.getDate("endDate"));
				ct.setIsValid(rs.getString("isValid"));
				ct.setOldornew(rs.getString("oldornew"));
				ct.setDatasource(rs.getString("datasource"));
				list.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//��ѯ��ҵ�����м��(���ʱ�)
	public List<CertdetailInfo> queryCertdetailinfo(String corpCode)
	{
		List<CertdetailInfo> list = new ArrayList<CertdetailInfo>();
		String sql = "select CertID,CorpCode,'-1' corpname,CertTypeNum,TradeTypeNum,"
				+ "TradeBoundNum,TitleLevelNum,Mark,IsMaster,NoteNumber,"
				+ "NoteDate,'001' addtypenum,"
				+ "'1' oldornew,'07' datasource "
				+ "from zjb_TBCorpCertdetailinfo where corpCode=?	";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				CertdetailInfo ct = new CertdetailInfo();
				ct.setCertID(rs.getString("certID"));
				ct.setCorpCode(rs.getString("corpCode"));
				ct.setCorpname(rs.getString("corpname"));
				ct.setCertTypeNum(rs.getString("certTypeNum"));
				ct.setTradeTypeNum(rs.getString("tradeTypeNum"));
				ct.setTradeBoundNum(rs.getString("tradeBoundNum"));
				ct.setTitleLevelNum(rs.getString("titleLevelNum"));
				ct.setMark(rs.getString("mark"));
				ct.setIsMaster(rs.getString("isMaster"));
				ct.setNoteNumber(rs.getString("noteNumber"));
				ct.setNoteDate(rs.getDate("noteDate"));
				ct.setAddTypeNum(rs.getString("addTypeNum"));
				ct.setOldOrNew(rs.getString("oldOrNew"));
				ct.setDataSource(rs.getString("dataSource"));
				list.add(ct);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//����֤���
	public boolean importCertinfo(List<Certinfo> listCertinfo,String corpCode)
	{
		boolean check = true;
		//��ɾ��������
		this.deleteCertinfo(corpCode);
		try{
				conn = ConnectionFactory.getBasicConnection();
				// ȡ���Զ��ύ
	            conn.setAutoCommit(false);
				//�ٲ�����м�����������
				pstmt = conn.prepareStatement("insert into TBCorpCertinfo"
						+ "(CertID,CertTypeNum,TitleLevelNum,CorpName,"
						+ "CorpCode,LicenseNum,ProvinceNum,CityNum,CountyNum,"
						+ "Address,RegPrin,EconomicNum,LegalMan,LegalManDuty,LegaManProTitle,"
						+ "TechMan,TechManDuty,TechManProTitle,UnitMan,UnitManDuty,UnitManProTitle,"
						+ "OrganName,OrganDate,EndDate,IsValid,oldornew,datasource,corpCertid) "
						+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERT_SEQ.nextval)");
				
				for(int i=0;i<listCertinfo.size();i++)
	            {
					pstmt.setString(1,listCertinfo.get(i).getCertID());
					pstmt.setString(2,listCertinfo.get(i).getCertTypeNum());
					pstmt.setString(3,listCertinfo.get(i).getTitleLevelNum());
					pstmt.setString(4,listCertinfo.get(i).getCorpName());
					pstmt.setString(5,listCertinfo.get(i).getCorpCode());
					pstmt.setString(6,listCertinfo.get(i).getLicenseNum());
					pstmt.setString(7,listCertinfo.get(i).getProvinceNum());
					pstmt.setString(8,listCertinfo.get(i).getCityNum());
					pstmt.setString(9,listCertinfo.get(i).getCountyNum());
					pstmt.setString(10,listCertinfo.get(i).getAddress());
					pstmt.setString(11,listCertinfo.get(i).getRegPrin());
					pstmt.setString(12,listCertinfo.get(i).getEconomicNum());
					pstmt.setString(13,listCertinfo.get(i).getLegalMan());
					pstmt.setString(14,listCertinfo.get(i).getLegalManDuty());
					pstmt.setString(15,listCertinfo.get(i).getLegaManProTitle());
					pstmt.setString(16,listCertinfo.get(i).getTechMan());
					pstmt.setString(17,listCertinfo.get(i).getTechManDuty());
					pstmt.setString(18,listCertinfo.get(i).getTechManProTitle());
					pstmt.setString(19,listCertinfo.get(i).getUnitMan());
					pstmt.setString(20,listCertinfo.get(i).getUnitManDuty());
					pstmt.setString(21,listCertinfo.get(i).getUnitManProTitle());
					pstmt.setString(22,listCertinfo.get(i).getOrganName());
					pstmt.setDate(23,listCertinfo.get(i).getOrganDate());
					pstmt.setDate(24,listCertinfo.get(i).getEndDate());
					pstmt.setString(25,listCertinfo.get(i).getIsValid());
					pstmt.setString(26,listCertinfo.get(i).getOldornew());
					pstmt.setString(27,"07");
					pstmt.addBatch();
				}
				
				pstmt.executeBatch();
	            // ���û�д������ʾ��������ִ�� �ֹ��ύ
	            conn.commit();
	            //ɾ���м��֤������
	            this.deleteZjbCertinfo(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//ɾ��֤���
	public void deleteCertinfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from TBCorpCertinfo where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//ɾ���м��֤���
	public void deleteZjbCertinfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_TBCorpCertinfo where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//����������Ϣ��
	public boolean importCertdetailinfo(List<CertdetailInfo> listCertdetailinfo,String corpCode)
	{
		boolean check = true;
		//��ɾ��������
		this.deleteCertdetailInfo(corpCode);
		try{
			conn = ConnectionFactory.getBasicConnection();
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
			//�ٲ�����м�����������
			pstmt = conn.prepareStatement("insert into TBCorpCertdetailinfo"
					+ "(CertID,CorpCode,corpname,CertTypeNum,TradeTypeNum,TradeBoundNum,"
					+ "TitleLevelNum,Mark,IsMaster,NoteNumber,NoteDate,"
					+ "addtypenum,oldornew,datasource,certdetailid) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,CERT_SEQ.nextval)");
			
			for(int i=0;i<listCertdetailinfo.size();i++)
            {
				pstmt.setString(1,listCertdetailinfo.get(i).getCertID());
				pstmt.setString(2,listCertdetailinfo.get(i).getCorpCode());
				pstmt.setString(3,listCertdetailinfo.get(i).getCorpname());
				pstmt.setString(4,listCertdetailinfo.get(i).getCertTypeNum());
				pstmt.setString(5,listCertdetailinfo.get(i).getTradeTypeNum());
				pstmt.setString(6,listCertdetailinfo.get(i).getTradeBoundNum());
				pstmt.setString(7,listCertdetailinfo.get(i).getTitleLevelNum());
				pstmt.setString(8,listCertdetailinfo.get(i).getMark());
				pstmt.setString(9,listCertdetailinfo.get(i).getIsMaster());
				pstmt.setString(10,listCertdetailinfo.get(i).getNoteNumber());
				pstmt.setDate(11,listCertdetailinfo.get(i).getNoteDate());
				pstmt.setString(12,listCertdetailinfo.get(i).getAddTypeNum());
				pstmt.setString(13,listCertdetailinfo.get(i).getOldOrNew());
				pstmt.setString(14,"07");
				pstmt.addBatch();
			}
			
			pstmt.executeBatch();
            // ���û�д������ʾ��������ִ�� �ֹ��ύ
            conn.commit();
            //ɾ���м������
            this.deleteZjbCertdetailInfo(corpCode);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			check = false;
			e.printStackTrace();
			try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return check;
	}
	
	//ɾ��������Ϣ��
	public void deleteCertdetailInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from TBCorpCertdetailinfo where CORPCODE=? and dataSource=07";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//ɾ���м��������Ϣ��
	public void deleteZjbCertdetailInfo(String corpCode) {
		// TODO Auto-generated method stub
		String sql = "delete from ZJB_TBCorpCertdetailinfo where CORPCODE=?";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corpCode);	
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
	 * ���
	 * @return
	 */
	public void add(Constructor constructor)
	{
		try{
			String personId = UUID.randomUUID().toString();
			conn = ConnectionFactory.getBasicConnection();
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            
            String sql = "insert into TBREGPERSONBASICINFO "
            		+ "(PERSONNAME,SEXNUM,IDCARDTYPENUM,IDCARD,"
					+ "BIRTHDAY,NATIONALITYNUM,EDULEVELNUM,DEGREENUM,MOBILE,"
					+ "CORPID,PERSONID,UPDATETIME,OLDORNEW,DATASOURCE,"
					+ "CORPCODE) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            String sql1 = "insert into TBREGPERSONREGINFO "
					+ "(PERSONNAME,IDCARDTYPENUM,IDCARD18,SPECIALTYTYPNUM,"
					+ "CERTNUM,AWARDDATE,AWARDDEPART,STAMPNUM,EFFECTDATE,"
					+ "CALLINGTYPENUM,CORPNAME,CORPCODE,CERTID,REGTRADETYPENUM,"
					+ "TRADETYPEAWARDDATE,TRADETYPEEFFECTDATE,QSTATE,CORPID,PERSONID,"
					+ "UPDATETIME,OLDORNEW,DATASOURCE,FTYPE,REGTRADETYPENUM1,"
					+ "REGTRADETYPENUM2,REGTRADETYPENUM3) "
					+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);
            //����
            pstmt.setString(1,constructor.getPersonName());
            pstmt.setString(2,constructor.getSexNum()); //�Ա�(�ֵ��TBSEXDIC)
            pstmt.setString(3,constructor.getIdCardTypeNum());//֤������(�ֵ��TBIDCARDTYPEDIC)
            pstmt.setString(4,constructor.getIdCard());//���֤��(����Ϊ18λ)
            pstmt.setDate(5,constructor.getBirthday());//����
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	//����(�ֵ��TBNATIONDIC)
            	pstmt.setInt(6,Integer.parseInt(constructor.getNationAlityNum()));//����(�ֵ��TBNATIONDIC)
            }else
            {
            	pstmt.setInt(6,0);//����(�ֵ��TBNATIONDIC)
            }
            
            if(!"".equals(constructor.getEduLevelNum()))
            {
            	//ѧ��(�ֵ��TBEDULEVELDIC)
            	pstmt.setInt(7,Integer.parseInt(constructor.getEduLevelNum()));//����(�ֵ��TBNATIONDIC)
            }else
            {
            	pstmt.setInt(7,0);//ѧ��(�ֵ��TBEDULEVELDIC)
            }
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	//ѧλ(�ֵ��TBDEGREEDIC)
            	pstmt.setInt(8,Integer.parseInt(constructor.getDegreeNum()));//����(�ֵ��TBNATIONDIC)
            }else
            {
            	//ѧλ(�ֵ��TBDEGREEDIC)
            	pstmt.setInt(8,0);//����(�ֵ��TBNATIONDIC)
            }
            pstmt.setString(9, constructor.getMobile());//�ֻ�����
            pstmt.setString(10, constructor.getCorpId());//��ҵID
            pstmt.setString(11, personId); //��ԱID
            pstmt.setDate(12, new Date(new java.util.Date().getTime())); //��������
            pstmt.setString(13,"1"); //0�������� 1��������
            pstmt.setString(14,"09"); //������Դϵͳ
            pstmt.setString(15,constructor.getCorpCode()); //������ҵ��֯��������֤
            pstmt.executeUpdate();
            
			pstmt = conn.prepareStatement(sql1);
			//����
			pstmt.setString(1,constructor.getPersonName());
			//֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(2,constructor.getIdCardTypeNum());
			//���֤��
			pstmt.setString(3,constructor.getIdCard());
			//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
			pstmt.setString(4,constructor.getSepecialtyTypNum());
			//ע��֤����
			pstmt.setString(5,constructor.getCertNum());
			//��֤����
			pstmt.setDate(6,constructor.getAwardDate());
			//��֤��λ
			pstmt.setString(7,constructor.getAwardDepart());
			//ִҵӡ�º�
			pstmt.setString(8,constructor.getStampNum());
			//ע����Ч��
			pstmt.setDate(9,constructor.getEffectDate());
			//������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
			pstmt.setString(10,constructor.getCallingTypeNum());
			//������ҵ����
			pstmt.setString(11,constructor.getCorpName());
			//������ҵ��֯��������
			pstmt.setString(12,constructor.getCorpCode());
			//������ҵ֤����
			pstmt.setString(13,constructor.getCertId());
			//ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
			pstmt.setInt(14,Integer.parseInt(constructor.getRegTradeTypeNum()));
			//ע�Ὺʼ����(1-8)
			pstmt.setDate(15,constructor.getTradeTypeAwardDate());
			//ע���ֹ����(1-8)
			pstmt.setDate(16,constructor.getTradeTypeEffectDate());
			//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
			pstmt.setString(17,constructor.getState());
			//��ҵID
			pstmt.setString(18,constructor.getCorpId());
			//��ԱID(����)
			pstmt.setString(19,personId);
			//��������(�������)
			pstmt.setDate(20,new Date(new java.util.Date().getTime())); 
			//0�������� 1��������
			pstmt.setString(21,"1");
			//������Դϵͳ   09:��ʡ��ҵ�ֶ����
			pstmt.setString(22,"09");
			//ҵ������
			pstmt.setString(23,"��ʼע��"); 
			
			if(!"".equals(constructor.getRegTradeTypeNum1()))
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(24,Integer.parseInt(constructor.getRegTradeTypeNum1()));
			}else
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(24,0);
			}
			if(!"".equals(constructor.getRegTradeTypeNum2()))
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(25,Integer.parseInt(constructor.getRegTradeTypeNum2()));
			}else
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(25,0);
			}
			if(!"".equals(constructor.getRegTradeTypeNum3()))
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(26,Integer.parseInt(constructor.getRegTradeTypeNum3()));
			}else
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(26,0);
			}
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
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
	 * ��ת�޸�ҳ��
	 * @return
	 */
	public Constructor queryById(String personId)
	{
		String sql = "select * from V_CONSTRUCTOR where personId=? ";

		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setSexNum(rs.getString("sexNum"));
				constructor.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard"));
				constructor.setBirthday(rs.getDate("birthday"));
				constructor.setNationAlityNum(Integer.toString(rs.getInt("nationAlityNum")));
				constructor.setEduLevelNum(Integer.toString(rs.getInt("eduLevelNum")));
				constructor.setDegreeNum(Integer.toString(rs.getInt("degreeNum")));
				constructor.setMobile(rs.getString("mobile"));
				
				constructor.setSepecialtyTypNum(Integer.toString(rs.getInt("SPECIALTYTYPNUM")));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeNum(Integer.toString(rs.getInt("callingTypeNum")));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeNum(Integer.toString(rs.getInt("regTradeTypeNum")));
				constructor.setRegTradeTypeNum(rs.getString("REGTRADETYPENUM"));
				constructor.setTradeTypeAwardDate(rs.getDate("TRADETYPEAWARDDATE"));
				constructor.setTradeTypeEffectDate(rs.getDate("TRADETYPEEFFECTDATE"));
				constructor.setStateName(rs.getString("qStateName"));
				constructor.setState(rs.getString("qState"));
				constructor.setRegTradeTypeNum1(Integer.toString(rs.getInt("regTradeTypeNum1")));
				constructor.setRegTradeTypeNum2(Integer.toString(rs.getInt("regTradeTypeNum2")));
				constructor.setRegTradeTypeNum3(Integer.toString(rs.getInt("regTradeTypeNum3")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return constructor;
	}
	
	/**
	 * �޸�
	 * @return
	 */
	public void modify(Constructor constructor)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            
            String sql = "update TBREGPERSONBASICINFO set"
            		+ " PERSONNAME=?,SEXNUM=?,IDCARDTYPENUM=?,IDCARD=?,"
					+ "BIRTHDAY=?,NATIONALITYNUM=?,EDULEVELNUM=?,DEGREENUM=?,MOBILE=? "
					+ "where personId=? ";
            
            String sql1 = "update TBREGPERSONREGINFO set "
					+ "PERSONNAME=?,IDCARDTYPENUM=?,IDCARD18=?,SPECIALTYTYPNUM=?,"
					+ "CERTNUM=?,AWARDDATE=?,AWARDDEPART=?,STAMPNUM=?,EFFECTDATE=?,"
					+ "CALLINGTYPENUM=?,CERTID=?,REGTRADETYPENUM=?,"
					+ "TRADETYPEAWARDDATE=?,TRADETYPEEFFECTDATE=?,QSTATE=?,"
					+ "REGTRADETYPENUM1=?,REGTRADETYPENUM2=?,REGTRADETYPENUM3=? "
					+ "where personId=?";
            
            pstmt = conn.prepareStatement(sql);
            //����
            pstmt.setString(1,constructor.getPersonName());
            pstmt.setString(2,constructor.getSexNum()); //�Ա�(�ֵ��TBSEXDIC)
            pstmt.setString(3,constructor.getIdCardTypeNum());//֤������(�ֵ��TBIDCARDTYPEDIC)
            pstmt.setString(4,constructor.getIdCard());//���֤��(����Ϊ18λ)
            pstmt.setDate(5,constructor.getBirthday());//����
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	
            	pstmt.setInt(6,Integer.parseInt(constructor.getNationAlityNum()));
            }else
            {
            	pstmt.setInt(6,0);
            }
            
            if(!"".equals(constructor.getEduLevelNum()))
            {
            	
            	pstmt.setInt(7,Integer.parseInt(constructor.getEduLevelNum()));
            }else
            {
            	pstmt.setInt(7,0);
            }
            
            if(!"".equals(constructor.getNationAlityNum()))
            {
            	
            	pstmt.setInt(8,Integer.parseInt(constructor.getDegreeNum()));
            }else
            {
            	
            	pstmt.setInt(8,0);
            }
            pstmt.setString(9, constructor.getMobile());//�ֻ�����
            pstmt.setString(10, constructor.getPersonId()); //��ԱID
            pstmt.executeUpdate();
            
			pstmt = conn.prepareStatement(sql1);
			//����
			pstmt.setString(1,constructor.getPersonName());
			//֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(2,constructor.getIdCardTypeNum());
			//���֤��
			pstmt.setString(3,constructor.getIdCard());
			//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
			pstmt.setString(4,constructor.getSepecialtyTypNum());
			//ע��֤����
			pstmt.setString(5,constructor.getCertNum());
			//��֤����
			pstmt.setDate(6,constructor.getAwardDate());
			//��֤��λ
			pstmt.setString(7,constructor.getAwardDepart());
			//ִҵӡ�º�
			pstmt.setString(8,constructor.getStampNum());
			//ע����Ч��
			pstmt.setDate(9,constructor.getEffectDate());
			//������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
			pstmt.setString(10,constructor.getCallingTypeNum());
			//������ҵ֤����
			pstmt.setString(11,constructor.getCertId());
			//ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
			pstmt.setInt(12,Integer.parseInt(constructor.getRegTradeTypeNum()));
			//ע�Ὺʼ����(1-8)
			pstmt.setDate(13,constructor.getTradeTypeAwardDate());
			//ע���ֹ����(1-8)
			pstmt.setDate(14,constructor.getTradeTypeEffectDate());
			//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
			pstmt.setString(15,constructor.getState());
			
			if(!"".equals(constructor.getRegTradeTypeNum1()))
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(16,Integer.parseInt(constructor.getRegTradeTypeNum1()));
			}else
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(16,0);
			}
			
			if(!"".equals(constructor.getRegTradeTypeNum2()))
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(17,Integer.parseInt(constructor.getRegTradeTypeNum2()));
			}else
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(17,0);
			}
			
			if(!"".equals(constructor.getRegTradeTypeNum3()))
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(18,Integer.parseInt(constructor.getRegTradeTypeNum3()));
			}else
			{
				//����ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
				pstmt.setInt(18,0);
			}
			pstmt.setString(19, constructor.getPersonId());
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
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
	public void deletePerson(String personId)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			// ȡ���Զ��ύ
            conn.setAutoCommit(false);
            
            String sql = "delete from TBREGPERSONBASICINFO where personId=? ";
            
            String sql1 = "delete from TBREGPERSONREGINFO where personId=?";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,personId);
            pstmt.executeUpdate();
            
            
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,personId);
			pstmt.executeUpdate();
			
			conn.commit();
		}catch (SQLException e) {
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
	
	//ְҵ�ʸ�״̬(1-8)(�ֵ��TBQSTATEDIC)
	public List<DictionaryClass> queryStates()
	{
		String sql = "select * from TBQSTATEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("status"));
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
	
	//ע��רҵ���(1-8)(�ֵ��TBREGTRADETYPEDIC)
	public List<DictionaryClass> queryRegTradeTypeNums()
	{
		String sql = "select * from TBREGTRADETYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("discipline"));
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
	//������ҵ��ҵ����(�ֵ��TBCALLINGTYPEDIC)
	public List<DictionaryClass> queryCallingTypeNums()
	{
		String sql = "select * from TBCALLINGTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("type"));
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
	//ע�����ͼ��ȼ�(�ֵ��TBSPECIALTYTYPEDIC)
	public List<DictionaryClass> querySepecialtyTypNums()
	{
		String sql = "select * from TBSPECIALTYTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("typelevel"));
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
		String sql = "select * from TBIDCARDTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
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
	
	//����
	public List<DictionaryClass> nationAlityNums()
	{
		String sql = "select * from TBNATIONDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(Integer.toString(rs.getInt("code")));
				dictionaryClass.setName(rs.getString("NATION"));
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
