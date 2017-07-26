package com.tj.jst.outside.business.queryBusiness.dao;

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
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.permit.model.Permit;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ʩ�����
 * @author hhc
 *
 */
public class QueryPermitDaoImpl extends BaseDao implements IQueryPermitDao {

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
					Permit permit = new Permit();
					permit.setPermitId(rs.getString("permitId"));//����
					permit.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					permit.setPrjName(rs.getString("prjName"));//��Ŀ����
					permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
					permit.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�����
					permit.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
					permit.setArea(rs.getString("area"));//���(ƽ����)
					permit.setPrjSize(rs.getString("prjSize"));//�����ģ
					permit.setIssueCertDate(rs.getDate("issueCertDate"));//��֤����
					permit.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
					permit.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
					permit.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
					permit.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
					permit.setConsCorpname(rs.getString("consCorpname"));//ʩ����λ����
					permit.setConsCorpCode(rs.getString("consCorpCode"));//ʩ����λ��֯��������
					permit.setSafetyCerId(rs.getString("safetyCerId"));//ʩ����λ��ȫ�������֤���
					permit.setSuperCorpName(rs.getString("superCorpName"));//����λ����     
					permit.setSuperCorpCode(rs.getString("superCorpCode"));//����λ��֯��������
					permit.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));//��Ŀ����֤������(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����֤������
					permit.setSupervisionName(rs.getString("supervisionName"));//�ܼ�����ʦ����
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));//�ܼ�����ʦ����
					permit.setUserName(rs.getString("userName"));//��ȫ����������Ա����
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��ȫ��������֤������(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));//��ȫ����������Ա֤����
					permit.setCertId(rs.getString("certId"));//��ȫ�������˺ϸ�֤����
					permit.setUserType(rs.getString("userType"));//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
					permit.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					permit.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					permit.setAppSteffId(rs.getString("appSteffId"));//������id
					permit.setAppSteffName(rs.getString("appSteffName"));//����������
					permit.setAppDate(rs.getDate("appDate"));//����ʱ��
					permit.setAppOpinion(rs.getString("appOpinion"));//�������
					permit.setProjectName(rs.getString("projectName"));
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					permit.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					permit.setProcessSteps(rs.getString("processSteps").trim());
					permit.setAppDept(rs.getString("appDept").trim());//������λid
					permit.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					permit.setAuCorpName(rs.getString("auCorpName"));
					page.getData().add(permit);
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Permit queryById(String permitId)
	{

		Permit permit = new Permit();
		try {
			
			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				
				permit.setPermitId(rs.getString("permitId"));//����
				permit.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				permit.setPrjId(rs.getString("prjId"));
				permit.setPrjName(rs.getString("prjName"));//��Ŀ����
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
				permit.setCensorNum(rs.getString("censorNum"));//ʩ��ͼ���ϸ�����
				permit.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
				permit.setArea(rs.getString("area"));//���(ƽ����)
				permit.setPrjSize(rs.getString("prjSize"));//�����ģ
				permit.setIssueCertDate(rs.getDate("issueCertDate"));//��֤����
				permit.setEconCorpName(rs.getString("econCorpName"));//���쵥λ����
				permit.setEconCorpCode(rs.getString("econCorpCode"));//���쵥λ��֯��������
				permit.setDesignCorpName(rs.getString("designCorpName"));//��Ƶ�λ����
				permit.setDesignCorpCode(rs.getString("designCorpCode"));//��Ƶ�λ��֯��������
				permit.setConsCorpname(rs.getString("consCorpname"));//ʩ����λ����
				permit.setConsCorpCode(rs.getString("consCorpCode"));//ʩ����λ��֯��������
				permit.setSafetyCerId(rs.getString("safetyCerId"));//ʩ����λ��ȫ�������֤���
				permit.setSuperCorpName(rs.getString("superCorpName"));//����λ����     
				permit.setSuperCorpCode(rs.getString("superCorpCode"));//����λ��֯��������
				permit.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));//��Ŀ����֤������(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����֤������
				permit.setSupervisionName(rs.getString("supervisionName"));//�ܼ�����ʦ����
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));//�ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));//�ܼ�����ʦ����
				permit.setUserName(rs.getString("userName"));//��ȫ����������Ա����
				permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��ȫ��������֤������(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));//��ȫ����������Ա֤����
				permit.setCertId(rs.getString("certId"));//��ȫ�������˺ϸ�֤����
				permit.setUserType(rs.getString("userType"));//��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
				permit.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				permit.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				permit.setAppSteffId(rs.getString("appSteffId"));//������id
				permit.setAppSteffName(rs.getString("appSteffName"));//����������
				permit.setAppDate(rs.getDate("appDate"));//����ʱ��
				permit.setAppOpinion(rs.getString("appOpinion"));//�������
				permit.setProjectName(rs.getString("projectName"));
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				permit.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				permit.setProcessSteps(rs.getString("processSteps").trim());
				permit.setAppDept(rs.getString("appDept").trim());//������λid
				permit.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
			}
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,permitId);
			rs = pstmt.executeQuery();
			List<Upload> list = new ArrayList<Upload>();
			while(rs.next())
			{
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setRoot(rs.getString("root"));
				upload.setNewName(rs.getString("newName"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setId(rs.getString("id"));
				upload.setFileFileName(rs.getString("fileFileName"));
				list.add(upload);
			}
			permit.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}
	
	/**
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//��ѯ������
		String sql = "select * from TBXZQDMDIC where name like '%������%'";
		List<Regional> list = new ArrayList<Regional>();
		//ʡId
		String prId = "";
		//��Id
		List<String> citys = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("code"));
				regional.setpId("-1");
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				prId = regional.getId();
				list.add(regional);
			}
			//��ѯ��
			pstmt = conn.prepareStatement("select * from TBXZQDMDIC where code like '23%00' and code !='230000'");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("code"));
				regional.setpId(prId);
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				citys.add(regional.getId());
				list.add(regional);
			}
			//��ѯ����
			for(int i=0;i<citys.size();i++)
			{
				String star = citys.get(i).substring(0, 4);
				pstmt = conn.prepareStatement("select * from TBXZQDMDIC where code like '"+star+"%' and code != '"+citys.get(i)+"'");
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Regional regional = new Regional();
					regional.setId(rs.getString("code"));
					regional.setpId(citys.get(i));
					regional.setName(rs.getString("name"));
					list.add(regional);
				}
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
	 * ������������id��ѯ�������
	 * @param appDept
	 * @return
	 */
	public String queryAppDeptId(String appDept)
	{
		String sql = "select code from TBXZQDMDIC_APP where sortnum=?";
		String code = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, appDept);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				code = rs.getString("code");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return code;
	}

	//֤������
	public List<DictionaryClass> queryCardTypeNums()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		String sql = "select * from TBIDCARDTYPEDIC ";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("PAPERTYPE"));
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
