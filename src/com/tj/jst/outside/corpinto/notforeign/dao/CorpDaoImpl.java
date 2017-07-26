package com.tj.jst.outside.corpinto.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class CorpDaoImpl implements ICorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//	//��ҵ��֯���������ѯ
//	@Override
//	public Corp queryCorpCode(String corpCode) {
//		
//		Corp corp = new Corp();
//		try {
//			
//			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
//			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
//			conn = ConnectionFactory.getBasicConnection();
//			pstmt = conn.prepareStatement(qsql);
//			pstmt.setString(1, corpCode);
//			rs = pstmt.executeQuery();
//			
//			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
//			if(rs.next())
//			{
//				String appType = rs.getString("appType");
//				if(appType!=null)
//				{
//					if(appType.equals("0"))
//					{
//						//������ݿ������δ���������������޸�ҳ��
//						corp.setCorpId(rs.getString("corpId"));		//����	
//						corp.setCorpName(rs.getString("corpName"));	//��ҵ����
//						corp.setCorpCode(rs.getString("corpCode")); 	//��֯��������
//						corp.setLicenseNum(rs.getString("licenseNum"));//����Ӫҵִ��ע���
//						corp.setProvinceNum(rs.getString("provinceNum"));//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
//						corp.setCityNum(rs.getString("cityNum"));		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
//						corp.setCountyNum(rs.getString("countyNum"));	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
//						corp.setAddress(rs.getString("address"));		//��ҵӪҵ��ַ
//						corp.setPostalCode(rs.getString("postalCode"));//��ҵӪҵ��ַ��������
//						corp.setLegalMan(rs.getString("legalMan"));	//��������������
//						corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//����������֤������(�ֵ��TBIDCARDTYPEDIC)
//						corp.setLegalManIdCard(rs.getString("legalManIdCard"));//����������֤������
//						corp.setLegalManDuty(rs.getString("legalManDuty"));//����������ְ��
//						corp.setLegaManProtitle(rs.getString("legaManProtitle"));//����������ְ��
//						corp.setEconomicNum(rs.getString("economicNum"));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
//						corp.setRegPrin(rs.getString("regPrin")); 		//ע���ʱ�(��Ԫ)
//						corp.setFactRegPrin(rs.getString("factRegPrin"));	//ʵ���ʱ�(��Ԫ)
//						corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
//						corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//��������
//						corp.setOfficePhone(rs.getString("officePhone"));//�칫�绰
//						corp.setFax(rs.getString("fax"));				//�������
//						corp.setLinkMan(rs.getString("linkMan")); 		//��ϵ������
//						corp.setLinkTel(rs.getString("linkTel"));		//��ϵ�˰칫�绰
//						corp.setLinkPhone(rs.getString("linkPhone"));	//��ϵ���ֻ�����
//						corp.setEmail(rs.getString("email"));			//��ϵ����
//						corp.setUrl(rs.getString("url"));				//��ҵ��ַ
//						corp.setDescription(rs.getString("description"));	//��ע
//						corp.setAssets(rs.getString("assets"));	
//						corp.setMachinery(rs.getString("machinery"));
//						corp.setSpare1(rs.getString("spare1"));//��ҵ������
//						corp.setForeignCorpName(rs.getString("foreignCorpName"));//����Ͷ��������
//						corp.setNationNume(rs.getString("nationnum"));//���������(�ֵ��TBNATIONALDIC)
//						corp.setPercentTage(rs.getString("percentTage"));//����Ͷ����ռ����(%)
//						corp.setForeignIvestor(rs.getString("foreignIvestor"));	//����Ͷ��������         0:������ҵ��1��������Ȼ��
//						corp.setCheckForeign(rs.getString("checkForeign"));//�Ƿ�����Ͷ��	   0:�ǣ�1����
//						corp.setEnterpriseType(rs.getString("enterpriseType"));
//						//���ݿ��д��ڣ�δ��������ת�޸�ҳ��
//						corp.setCheckType(1);
//					}else
//					{
//						//���ݿ����Ѿ�������ת��½ҳ��
//						corp.setCheckType(0);
//						corp.setMessage("������ѯ����ҵ�Ѿ�ע�Ტ������ˣ���ʹ��UKey��½��");
//					}
//				}else
//				{
//					//appTypeΪnullΪ������,Ĭ�Ͼ������
//					corp.setCheckType(0);
//					corp.setMessage("������ѯ����ҵ�Ѿ�ע�Ტ������ˣ���ʹ��UKey��½��");
//				}
//			}else
//			{
//				//���ݿ��в�������ת���ҳ��
//				corp.setCheckType(2);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally
//		{
//			ConnectionFactory.closeConn(conn, pstmt, rs);
//		}
//		return corp;
//	}

	//��ҵ��֯���������ѯ
	@Override
	public Corp queryCorpCode(String corpCode) {
		
		Corp corp = new Corp();
		
		try {
			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				//������ݿ������δ���������������޸�ҳ��
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
				corp.setForeignCorpName(rs.getString("foreignCorpName"));//����Ͷ��������
				corp.setNationNume(rs.getString("nationnum"));//���������(�ֵ��TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));//����Ͷ����ռ����(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor"));	//����Ͷ��������         0:������ҵ��1��������Ȼ��
				corp.setCheckForeign(rs.getString("checkForeign"));//�Ƿ�����Ͷ��	   0:�ǣ�1����
				corp.setEnterpriseType(rs.getString("enterpriseType"));
				corp.setAppType(rs.getString("appType"));//������ʶ
				corp.setLockNumber1(rs.getString("lockNumber1"));//UKey��
				corp.setLockNumber1_Date(rs.getString("lockNumber1_Date"));//��UKey����
				
				if( corp.getLockNumber1() != null ) {
					corp.setCheckType(0);
					corp.setMessage("��ҵ�Ѿ�ӵ��UKey����ʹ��UKey��½��");
				} else {
					if(corp.getAppType()==null)
					{
						//���������ʶΪnull,˵����������,����Ҫ��������,��ת�޸�ҳ��
						corp.setCheckType(1);
					}else if(corp.getAppType().equals("0"))
					{
						//���������ʶΪ0,˵�������û�ע��,δ��������,��ת�޸�ҳ��
						corp.setCheckType(1);
					}else if(corp.getAppType().equals("1"))
					{
						//���������ʶΪ1,˵�����û���������,��ת��½ҳ��
						//corp.setCheckType(0);
						//corp.setMessage("������ѯ����ҵ�Ѿ�ע�Ტ������ˣ���ʹ��UKey��½��");
						//������ʶΪ1��Ҳ���޸�
						corp.setCheckType(1);
					}else
					{
						//���������ʶΪ2,˵�����û�����δͨ��,�����ύ��Ϣ,��ת���ҳ��
						corp.setCheckType(2);
					}
				}
				
			}else
			{
				//���ݿ��в�������ת���ҳ��
				corp.setCheckType(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
	
	//��ҵ��֯���������ѯ
	public Corp queryCorpTypeCode(String corpCode)
	{
		Corp corp = new Corp();
		try {
			
			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				//������ݿ������δ���������������޸�ҳ��
				corp.setCorpName(rs.getString("corpName"));//��ҵ����
				corp.setCorpCode(rs.getString("corpCode"));//��ҵ��֯��������
				corp.setCorpId(rs.getString("corpId"));		//����
				corp.setEnterpriseType(rs.getString("enterpriseType"));
			}else
			{
				//���ݿ��в�������ת���ҳ��
				corp.setCheckType(2);
				corp.setMessage("������ѯ����ҵ��Ϣ������,���������ҵ¼�����!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
	
	//�����ҵ
	@Override
	public String addCorp(Corp corp) {
		String message = "";
		int checkNum1 = 0;
		int checkNum2 = 0;
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
				+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
				+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN,enterpriseType) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//��ҵ����
			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
			pstmt.setString(3,corp.getLicenseNum());//����Ӫҵִ��ע���
			pstmt.setString(4,corp.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//��ҵӪҵ��ַ
			pstmt.setString(8,corp.getPostalCode());//��ҵӪҵ��ַ��������
			pstmt.setString(9,corp.getLegalMan());	//��������������
			pstmt.setString(10,corp.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//����������֤������
			pstmt.setString(12,corp.getLegalManDuty());//����������ְ��
			pstmt.setString(13,corp.getLegaManProtitle());//����������ְ��
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//ע���ʱ�(��Ԫ)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//ʵ���ʱ�(��Ԫ)
			pstmt.setString(17,corp.getPrincipalUnitNum());//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//��������
			pstmt.setString(19,corp.getOfficePhone());//�칫�绰
			pstmt.setString(20,corp.getFax());				//�������
			pstmt.setString(21,corp.getLinkMan()); 		//��ϵ������
			pstmt.setString(22,corp.getLinkTel());		//��ϵ�˰칫�绰
			pstmt.setString(23,corp.getLinkPhone());	//��ϵ���ֻ�����
			pstmt.setString(24,corp.getEmail());			//��ϵ����
			pstmt.setString(25,corp.getUrl());				//��ҵ��ַ
			pstmt.setString(26,corp.getDescription());	//��ע
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//���ʱ��
			pstmt.setString(28, corpId);				//����
			pstmt.setString(29, "1");				//�������ݣ�0�����ݣ�1������
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());//��ҵ������
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.setString(34, corp.getEnterpriseType().replace(" ", ""));
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
					+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,appType,"
					+ "spare1,CREATEDATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,corpId);	
			pstmt.setString(2,corp.getCorpName()); 
			pstmt.setString(3,corp.getCorpCode()); 
			pstmt.setString(4,corp.getApplyOpinion()); 
			pstmt.setString(5,corp.getApplyStaffId()); 
			pstmt.setString(6,corp.getApplyStaffName());
			pstmt.setString(7,corp.getApplyDept());
			pstmt.setString(8,corp.getApplyDeptName());
			pstmt.setString(9,"1");
			pstmt.setString(10,corp.getSpare1());
			pstmt.setDate(11,new Date(new java.util.Date().getTime())); //����ʱ��
			checkNum2 = pstmt.executeUpdate();
			conn.commit();
			if(checkNum1 > 0 && checkNum2 > 0)
			{
				message = "��ҵ��ӳɹ�!";
			}else
			{
				message = "��ҵ���ʧ��!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		return message;
	}
	
	//����������ҵ
	@Override
	public String addForeignCorp(Corp corp) {
		String corpId = UUID.randomUUID().toString();
		String message = "";
		int checkNum1 = 0;
		int checkNum2 = 0;
		int checkNum3 = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
					+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
					+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
					+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
					+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN,enterpriseType) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//��ҵ����
			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
			pstmt.setString(3,corp.getLicenseNum());//����Ӫҵִ��ע���
			pstmt.setString(4,corp.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//��ҵӪҵ��ַ
			pstmt.setString(8,corp.getPostalCode());//��ҵӪҵ��ַ��������
			pstmt.setString(9,corp.getLegalMan());	//��������������
			pstmt.setString(10,corp.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//����������֤������
			pstmt.setString(12,corp.getLegalManDuty());//����������ְ��
			pstmt.setString(13,corp.getLegaManProtitle());//����������ְ��
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//ע���ʱ�(��Ԫ)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//ʵ���ʱ�(��Ԫ)
			pstmt.setString(17,corp.getPrincipalUnitNum());//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//��������
			pstmt.setString(19,corp.getOfficePhone());//�칫�绰
			pstmt.setString(20,corp.getFax());				//�������
			pstmt.setString(21,corp.getLinkMan()); 		//��ϵ������
			pstmt.setString(22,corp.getLinkTel());		//��ϵ�˰칫�绰
			pstmt.setString(23,corp.getLinkPhone());	//��ϵ���ֻ�����
			pstmt.setString(24,corp.getEmail());			//��ϵ����
			pstmt.setString(25,corp.getUrl());				//��ҵ��ַ
			pstmt.setString(26,corp.getDescription());	//��ע
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//���ʱ��
			pstmt.setString(28, corpId);				//����
			pstmt.setString(29, "1");				//�������ݣ�0�����ݣ�1������
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());//��ҵ������
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.setString(34, corp.getEnterpriseType().replace(" ", ""));//��ҵ����
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
					+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,appType,"
					+ "spare1,CREATEDATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,corpId);	
			pstmt.setString(2,corp.getCorpName()); 
			pstmt.setString(3,corp.getCorpCode()); 
			pstmt.setString(4,corp.getApplyOpinion()); 
			pstmt.setString(5,corp.getApplyStaffId()); 
			pstmt.setString(6,corp.getApplyStaffName());
			pstmt.setString(7,corp.getApplyDept());
			pstmt.setString(8,corp.getApplyDeptName());
			pstmt.setString(9,"1");
			pstmt.setString(10, corp.getSpare1());
			pstmt.setDate(11,new Date(new java.util.Date().getTime())); //����ʱ��
			checkNum2 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into TBCorpForeigninfo(CORPID,CORPNAME,CORPCODE,"
					+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,FOREIGNIVESTOR,"
					+ "CREATEDATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,corpId);	
			pstmt.setString(2,corp.getCorpName()); 
			pstmt.setString(3,corp.getCorpCode()); 
			pstmt.setString(4,corp.getForeignCorpName()); 
			pstmt.setString(5,corp.getNationNume()); 
			pstmt.setString(6,corp.getPrincipalUnitNum());
			pstmt.setString(7,corp.getRegPrin());
			pstmt.setString(8,corp.getPercentTage());
			pstmt.setString(9,corp.getForeignIvestor());
			pstmt.setDate(10,new Date(new java.util.Date().getTime())); //����ʱ��
			checkNum3 = pstmt.executeUpdate();
			
			conn.commit();
			if(checkNum1 > 0 && checkNum2 > 0 && checkNum3 > 0)
			{
				message = "��ҵ��ӳɹ�!";
			}else
			{
				message = "��ҵ���ʧ��!";
			}
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
		return message;
	}
	


	//�޸���ҵ
	@Override
	public String modifyCorp(Corp corp) 
	{
		//��ҵ������Ϣ�޸ı���
		this.modifyCorpInfoLog(corp);
		
		String message = "";
		int checkNum1 = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
					+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
					+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
					+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=?,spare1=?,"
					+ "checkForeign=?,enterpriseType=? where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//��ҵ����
			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
			pstmt.setString(3,corp.getLicenseNum());//����Ӫҵִ��ע���
			pstmt.setString(4,corp.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//��ҵӪҵ��ַ
			pstmt.setString(8,corp.getPostalCode());//��ҵӪҵ��ַ��������
			pstmt.setString(9,corp.getLegalMan());	//��������������
			pstmt.setString(10,corp.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//����������֤������
			pstmt.setString(12,corp.getLegalManDuty());//����������ְ��
			pstmt.setString(13,corp.getLegaManProtitle());//����������ְ��
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//ע���ʱ�(��Ԫ)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//ʵ���ʱ�(��Ԫ)
			pstmt.setString(17,corp.getPrincipalUnitNum());//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//��������
			pstmt.setString(19,corp.getOfficePhone());//�칫�绰
			pstmt.setString(20,corp.getFax());				//�������
			pstmt.setString(21,corp.getLinkMan()); 		//��ϵ������
			pstmt.setString(22,corp.getLinkTel());		//��ϵ�˰칫�绰
			pstmt.setString(23,corp.getLinkPhone());	//��ϵ���ֻ�����
			pstmt.setString(24,corp.getEmail());			//��ϵ����
			pstmt.setString(25,corp.getUrl());				//��ҵ��ַ
			pstmt.setString(26,corp.getDescription());	//��ע
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//�޸�ʱ��
			pstmt.setString(28, corp.getAssets());
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getSpare1());
			pstmt.setString(31, corp.getCheckForeign());
			pstmt.setString(32, corp.getEnterpriseType().replace(" ", ""));
			pstmt.setString(33, corp.getCorpId());	//����
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from TBCorpForeigninfo where corpId=?");
			pstmt.setString(1,corp.getCorpId());	
			pstmt.executeUpdate();
			
			
//			pstmt = conn.prepareStatement("update T_TBCORPBUSINESS set CORPNAME=?,CORPCODE=?,"
//					+ "spare1=? where CORPID=?");
//			pstmt.setString(1,corp.getCorpName());	//��ҵ����
//			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
//			pstmt.setString(3, corp.getSpare1());
//			pstmt.setString(4,corp.getCorpId());	//����
//			checkNum3 = pstmt.executeUpdate();
			
			
			conn.commit();
			if(checkNum1 > 0)
			{
				message = "��ҵ�޸ĳɹ�!";
			}else
			{
				message = "��ҵ�޸�ʧ��!";
			}
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
		return message;
	}
	
	/**
	 * ��ҵ������Ϣ�޸ı���
	 * @param corp
	 */
	private void modifyCorpInfoLog(Corp corp) {
		// TODO Auto-generated method stub
		String sql = "select * from TBCORPBASICINFO where corpId = ?" ;
		Corp corpOldInfo = new Corp() ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				corpOldInfo.setCorpName(rs.getString("corpName"));
				corpOldInfo.setLicenseNum(rs.getString("licenseNum"));
				corpOldInfo.setProvinceNum(rs.getString("provinceNum"));
				corpOldInfo.setCityNum(rs.getString("cityNum"));
				corpOldInfo.setCountyNum(rs.getString("countyNum"));
				corpOldInfo.setAddress(rs.getString("address"));
				corpOldInfo.setLegalMan(rs.getString("legalMan"));
				corpOldInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				corpOldInfo.setLegalManIdCard(rs.getString("legalManIdCard"));
				corpOldInfo.setLegalManDuty(rs.getString("legalManDuty"));
				corpOldInfo.setLegaManProtitle(rs.getString("legaManProtitle"));
				corpOldInfo.setEconomicNum(String.valueOf(rs.getInt("economicNum")));
				corpOldInfo.setRegPrin(String.valueOf(rs.getDouble("regPrin")));
				corpOldInfo.setFactRegPrin(String.valueOf(rs.getDouble("factRegPrin")));
				corpOldInfo.setCorpBirthDate(rs.getDate("corpBirthDate"));
				corpOldInfo.setSpare1(rs.getString("spare1"));
				corpOldInfo.setAssets(rs.getString("assets"));
				corpOldInfo.setCreateDate(rs.getDate("creatDate"));
				corpOldInfo.setLockNumber1(rs.getString("lockNumber1"));
				corpOldInfo.setLockNumber1_Date(rs.getString("lockNumber1_Date"));
			}
			
			sql = "insert into MODIFYCORPINFO_LOG (CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
					+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
					+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
					+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
					+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN,enterpriseType,LOGID,MODIFYDATE," +
					"CORPNAME1,LICENSENUM1,PROVINCENUM1,CITYNUM1,COUNTYNUM1,ADDRESS1,LEGALMAN1,IDCARDTYPENUM1," +
					"LEGALMANIDCARD1,LEGALMANDUTY1,LEGAMANPROTITLE1,ECONOMICNUM1,REGPRIN1,FACTREGPRIN1," +
					"CORPBIRTHDATE1,SPARE11,ASSETS1,LOCKNUMBER1,LOCKNUMBER1_DATE,MODIFYINGLOCATION) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//��ҵ����
			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
			pstmt.setString(3,corp.getLicenseNum());//����Ӫҵִ��ע���
			pstmt.setString(4,corp.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//��ҵӪҵ��ַ
			pstmt.setString(8,corp.getPostalCode());//��ҵӪҵ��ַ��������
			pstmt.setString(9,corp.getLegalMan());	//��������������
			pstmt.setString(10,corp.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//����������֤������
			pstmt.setString(12,corp.getLegalManDuty());//����������ְ��
			pstmt.setString(13,corp.getLegaManProtitle());//����������ְ��
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//ע���ʱ�(��Ԫ)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//ʵ���ʱ�(��Ԫ)
			pstmt.setString(17,corp.getPrincipalUnitNum());//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//��������
			pstmt.setString(19,corp.getOfficePhone());//�칫�绰
			pstmt.setString(20,corp.getFax());				//�������
			pstmt.setString(21,corp.getLinkMan()); 		//��ϵ������
			pstmt.setString(22,corp.getLinkTel());		//��ϵ�˰칫�绰
			pstmt.setString(23,corp.getLinkPhone());	//��ϵ���ֻ�����
			pstmt.setString(24,corp.getEmail());			//��ϵ����
			pstmt.setString(25,corp.getUrl());				//��ҵ��ַ
			pstmt.setString(26,corp.getDescription());	//��ע
			pstmt.setDate(27,corpOldInfo.getCreateDate());	//���ʱ��
			pstmt.setString(28, corp.getCorpId());				//����
			pstmt.setString(29, "1");				//�������ݣ�0�����ݣ�1������
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());//��ҵ������
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.setString(34, corp.getEnterpriseType());
			pstmt.setString(35, UUID.randomUUID().toString());//��־����
			pstmt.setDate(36, new Date(new java.util.Date().getTime()));//�޸�ʱ��
			pstmt.setString(37, corpOldInfo.getCorpName());
			pstmt.setString(38, corpOldInfo.getLicenseNum());
			pstmt.setString(39, corpOldInfo.getProvinceNum());
			pstmt.setString(40, corpOldInfo.getCityNum());
			pstmt.setString(41, corpOldInfo.getCountyNum());
			pstmt.setString(42, corpOldInfo.getAddress());
			pstmt.setString(43, corpOldInfo.getLegalMan());
			pstmt.setString(44, corpOldInfo.getIdCardTypeNum());
			pstmt.setString(45, corpOldInfo.getLegalManIdCard());
			pstmt.setString(46, corpOldInfo.getLegalManDuty());
			pstmt.setString(47, corpOldInfo.getLegaManProtitle());
			pstmt.setInt(48, Integer.parseInt(corpOldInfo.getEconomicNum()));
			pstmt.setDouble(49, Double.parseDouble(corpOldInfo.getRegPrin()));
			pstmt.setDouble(50, Double.parseDouble(corpOldInfo.getFactRegPrin()));
			pstmt.setDate(51, corpOldInfo.getCorpBirthDate());
			pstmt.setString(52, corpOldInfo.getSpare1());
			pstmt.setString(53, corpOldInfo.getAssets());
			pstmt.setString(54,corpOldInfo.getLockNumber1());
			pstmt.setString(55, corpOldInfo.getLockNumber1_Date());
			pstmt.setString(56, "������ʡ����һ�廯ƽ̨");

			pstmt.executeUpdate();
			conn.commit();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}

	//�޸�������ҵ
	@Override
	public String modifyForeignCorp(Corp corp) 
	{
		String message = "";
		int checkNum1 = 0;
		int checkNum2 = 0;
		int checkNum3 = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
					+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
					+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
					+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=?,spare1=?,"
					+ "checkForeign=?,enterpriseType=? where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//��ҵ����
			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
			pstmt.setString(3,corp.getLicenseNum());//����Ӫҵִ��ע���
			pstmt.setString(4,corp.getProvinceNum());//ע������ʡ(��������ֱϽ��)(�ֵ��TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//ע�����ڵ�(�С��ݡ���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//ע��������(�����С���)(�ֵ��TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//��ҵӪҵ��ַ
			pstmt.setString(8,corp.getPostalCode());//��ҵӪҵ��ַ��������
			pstmt.setString(9,corp.getLegalMan());	//��������������
			pstmt.setString(10,corp.getIdCardTypeNum());//����������֤������(�ֵ��TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//����������֤������
			pstmt.setString(12,corp.getLegalManDuty());//����������ְ��
			pstmt.setString(13,corp.getLegaManProtitle());//����������ְ��
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//��ҵ�Ǽ�ע������(�ֵ��TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//ע���ʱ�(��Ԫ)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//ʵ���ʱ�(��Ԫ)
			pstmt.setString(17,corp.getPrincipalUnitNum());//ע���ʱ�����(�ֵ��TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//��������
			pstmt.setString(19,corp.getOfficePhone());//�칫�绰
			pstmt.setString(20,corp.getFax());				//�������
			pstmt.setString(21,corp.getLinkMan()); 		//��ϵ������
			pstmt.setString(22,corp.getLinkTel());		//��ϵ�˰칫�绰
			pstmt.setString(23,corp.getLinkPhone());	//��ϵ���ֻ�����
			pstmt.setString(24,corp.getEmail());			//��ϵ����
			pstmt.setString(25,corp.getUrl());				//��ҵ��ַ
			pstmt.setString(26,corp.getDescription());	//��ע
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//�޸�ʱ��
			pstmt.setString(28, corp.getAssets());
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getSpare1());
			pstmt.setString(31, corp.getCheckForeign());
			pstmt.setString(32, corp.getEnterpriseType().replace(" ", ""));
			pstmt.setString(33,corp.getCorpId());	//����
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from TBCorpForeigninfo where corpId=?");
			pstmt.setString(1,corp.getCorpId());	
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				String foreignSql = "update TBCorpForeigninfo set CORPNAME=?,CORPCODE=?,"
						+ "foreignCorpName=?,nationNum=?,principalUnitNum=?,regPrin=?,percentTage=?,"
						+ "FOREIGNIVESTOR=?,MODIFYDATE=? where CORPID=? ";
				pstmt = conn.prepareStatement(foreignSql);
				pstmt.setString(1,corp.getCorpName());	//��ҵ����
				pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
				pstmt.setString(3,corp.getForeignCorpName());
				pstmt.setString(4,corp.getNationNume());
				pstmt.setString(5,corp.getPrincipalUnitNum());
				pstmt.setString(6,corp.getRegPrin());
				pstmt.setString(7,corp.getPercentTage());
				pstmt.setString(8,corp.getForeignIvestor());
				pstmt.setDate(9,new Date(new java.util.Date().getTime()));	//�޸�ʱ��
				pstmt.setString(10,corp.getCorpId());
				checkNum2 = pstmt.executeUpdate();
			}else
			{
				pstmt = conn.prepareStatement("insert into TBCorpForeigninfo(CORPID,CORPNAME,CORPCODE,"
						+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,FOREIGNIVESTOR,"
						+ "CREATEDATE) "
						+ "values(?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1,corp.getCorpId());	
				pstmt.setString(2,corp.getCorpName()); 
				pstmt.setString(3,corp.getCorpCode()); 
				pstmt.setString(4,corp.getForeignCorpName()); 
				pstmt.setString(5,corp.getNationNume()); 
				pstmt.setString(6,corp.getPrincipalUnitNum());
				pstmt.setString(7,corp.getRegPrin());
				pstmt.setString(8,corp.getPercentTage());
				pstmt.setString(9,corp.getForeignIvestor());
				pstmt.setDate(10,new Date(new java.util.Date().getTime())); //����ʱ��
				checkNum2 = pstmt.executeUpdate();
			}
			
			pstmt = conn.prepareStatement("update T_TBCORPBUSINESS set CORPNAME=?,CORPCODE=?,"
					+ "spare1=? where CORPID=?");
			pstmt.setString(1,corp.getCorpName());	//��ҵ����
			pstmt.setString(2,corp.getCorpCode()); 	//��֯��������
			pstmt.setString(3, corp.getSpare1());
			pstmt.setString(4,corp.getCorpId());	//����
			checkNum3 = pstmt.executeUpdate();
			
			conn.commit();
			if(checkNum1 > 0 && checkNum2 > 0 && checkNum3 > 0)
			{
				message = "��ҵ�޸ĳɹ�!";
			}else
			{
				message = "��ҵ�޸�ʧ��!";
			}
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
		return message;
	}

	//�޸���ҵ����
	public String modifyCorpType(Corp corp)
	{
		String message = "";
		int checkNum = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBCorpBasicinfo set enterpriseType=? where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getEnterpriseType());
			pstmt.setString(2,corp.getCorpId());	//����
			checkNum = pstmt.executeUpdate();
			conn.commit();
			if(checkNum > 0)
			{
				message = "�޸ĳɹ�!";
			}else
			{
				message = "�޸�ʧ��!";
			}
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
		return message;
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

	//���赥λ��ת�޸�ҳ�棬��ѯһ����ҵ������Ϣ
	@Override
	public Corp queryCorpCode1(String corpCode) {
		// TODO Auto-generated method stub
		Corp corp = new Corp();
		
		try {
			//�ж���ҵ�Ƿ������ʴ���
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement("select * from TBQUALIFICATIONAPPLY where corpCode=? " +
					" and (qualiftype='a' or qualiftype='1' or qualiftype='3' or qualiftype='5' or qualiftype='7' or qualiftype='9')");
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return null;
			}
			
			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				//������ݿ������δ���������������޸�ҳ��
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
				corp.setForeignCorpName(rs.getString("foreignCorpName"));//����Ͷ��������
				corp.setNationNume(rs.getString("nationnum"));//���������(�ֵ��TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));//����Ͷ����ռ����(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor"));	//����Ͷ��������         0:������ҵ��1��������Ȼ��
				corp.setCheckForeign(rs.getString("checkForeign"));//�Ƿ�����Ͷ��	   0:�ǣ�1����
				corp.setEnterpriseType(rs.getString("enterpriseType"));
				corp.setAppType(rs.getString("appType"));//������ʶ
				
//				if(corp.getAppType()==null)
//				{
//					//���������ʶΪnull,˵����������,����Ҫ��������,��ת�޸�ҳ��
//					corp.setCheckType(1);
//				}else if(corp.getAppType().equals("0"))
//				{
//					//���������ʶΪ0,˵�������û�ע��,δ��������,��ת�޸�ҳ��
//					corp.setCheckType(1);
//				}else if(corp.getAppType().equals("1"))
//				{
//					//���������ʶΪ1,˵�����û���������,��ת��½ҳ��
//					corp.setCheckType(0);
//					corp.setMessage("������ѯ����ҵ�Ѿ�ע�Ტ������ˣ���ʹ��UKey��½��");
//				}else
//				{
//					//���������ʶΪ2,˵�����û�����δͨ��,�����ύ��Ϣ,��ת���ҳ��
//					corp.setCheckType(2);
//				}
//			}else
//			{
//				//���ݿ��в�������ת���ҳ��
//				corp.setCheckType(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	
	}
	
}
