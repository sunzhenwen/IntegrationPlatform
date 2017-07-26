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
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��ȫ�ල
 * @author hhc
 *
 */
public class QuerySafetyDaoImpl extends BaseDao implements IQuerySafetyDao {

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
					Safety quality = new Safety();
					quality.setSafetyId(rs.getString("SAFETYID"));//����
					quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					quality.setPrjName(rs.getString("prjName"));//��Ŀ����
					quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
					quality.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
					quality.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
					quality.setAppSteffId(rs.getString("appSteffId"));//������id
					quality.setAppSteffName(rs.getString("appSteffName"));//����������
					quality.setAppDate(rs.getDate("appDate"));//����ʱ��
					quality.setAppOpinion(rs.getString("appOpinion"));//�������
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					quality.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					quality.setProcessSteps(rs.getString("processSteps").trim());
					quality.setAppDept(rs.getString("appDept").trim());//������λid
					quality.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
					quality.setAuCorpName(rs.getString("auCorpName"));
					page.getData().add(quality);
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
	public Safety queryById(String safetyId)
	{

		Safety quality = new Safety();
		try {
			
			String qsql = "select * from TB_SAFETYSUPERVISION where SAFETYID=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, safetyId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setSafetyId(rs.getString("SAFETYID"));//����
				quality.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				quality.setPrjName(rs.getString("prjName"));//��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));//������id
				quality.setAppSteffName(rs.getString("appSteffName"));//����������
				quality.setAppDate(rs.getDate("appDate"));//����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());//������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));//��������
				quality.setProjectAddress(rs.getString("projectAddress"));//���̵ص�
				quality.setProStartDate(rs.getDate("proStartDate"));//��ͬ��������
				quality.setProEndDate(rs.getDate("proEndDate"));//��ͬ��������
				quality.setProjectType(rs.getString("projectType"));//��������
				quality.setSafetyTarget(rs.getString("safetyTarget"));//��ȫ������׼������Ŀ��
				if(rs.getString("newlyBuild") != null)
				{
					quality.setNewlyBuild(rs.getString("newlyBuild").trim());//�½�
				}else
				{
					quality.setNewlyBuild(rs.getString("newlyBuild"));//�½�
				}
				if(rs.getString("extend") != null)
				{
					quality.setExtend(rs.getString("extend").trim());//������
				}else
				{
					quality.setExtend(rs.getString("extend"));//������
				}
				if(rs.getString("other") != null)
				{
					quality.setOther(rs.getString("other").trim());//����
				}else
				{
					quality.setOther(rs.getString("other"));//����
				}
				quality.setPolicingName(rs.getString("policingName"));//���쵥λȫ��
				quality.setPolicingStaff(rs.getString("policingStaff"));//���쵥λ��Ŀ������
				quality.setDesignName(rs.getString("designName"));//��Ƶ�λȫ��
				quality.setDesignStaff(rs.getString("designStaff"));//��Ƶ�λ��Ŀ������
				quality.setBuildingName(rs.getString("buildingName"));//���赥λȫ��
				quality.setBuildingStaff(rs.getString("buildingStaff"));//���赥λ��Ŀ������
				quality.setBuildingPhone(rs.getString("buildingPhone"));//���赥λ��ϵ�绰
				quality.setSupervisionName(rs.getString("supervisionName"));//����λȫ��
				quality.setSupervisionStaff(rs.getString("supervisionStaff"));//����λ��Ŀ�ܼ�����
				quality.setSupervisionNum(rs.getString("supervisionNum"));//����λ��Ŀ�ܼ�ע��֤���
				quality.setSupervisionPhone(rs.getString("supervisionPhone"));//����λ��Ŀ�ܼ���ϵ�绰
				quality.setProbationStaff(rs.getString("probationStaff"));//����λ��ȫ�ල����
				quality.setProbationPhone(rs.getString("probationPhone"));//����λ��ȫ�ල��ϵ�绰
				quality.setProbationNum(rs.getString("probationNum"));//����λ��ȫ�ලע��֤���
				quality.setProbationSafeNum(rs.getString("probationSafeNum"));//����λ��ȫ�ල��ȫ����֤��
				quality.setContractName(rs.getString("contractName"));//ʩ���ܳа���λȫ��
				quality.setContractAdmin(rs.getString("contractAdmin"));//ʩ���ܳа���λ��˾��ȫ����
				quality.setContractPhone(rs.getString("contractPhone"));//ʩ���ܳа���λ��ϵ�绰
				quality.setContractStaff(rs.getString("contractStaff"));//ʩ���ܳа���λ������
				quality.setContractSafeNum(rs.getString("contractSafeNum"));//ʩ���ܳа���λ��ȫ����֤��
				quality.setContractProStaff(rs.getString("contractProStaff"));//ʩ���ܳа���λ��Ŀ����������
				quality.setContractProStaffPhone(rs.getString("contractProStaffPhone"));//ʩ���ܳа���λ��Ŀ��������ϵ�绰
				quality.setContractStaffRegNum(rs.getString("contractStaffRegNum"));//ʩ���ܳа���λ��Ŀ������ע��֤��
				quality.setContractStaffNum(rs.getString("contractStaffNum"));//ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
				//quality.setSingleNum(rs.getString("singleNum"));//��λ���̱��
				quality.setUnitProject(rs.getString("unitProject"));//��λ����
				quality.setScale(rs.getString("scale"));//������ģ
				quality.setCost(rs.getString("cost"));//�������
				quality.setStructure(rs.getString("structure"));//�ṹ/���
				quality.setHeight(rs.getString("height"));//�����߶�
				quality.setOversightNum(rs.getString("oversightNum"));//���
				quality.setSafetyNum(rs.getString("safetyNum"));
				//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
				List<ConstructionSafety> cs = new ArrayList<ConstructionSafety>();
				pstmt = conn.prepareStatement("select * from CONSTRUCTION_SAFETY "
								+ "where safetyId=?");
				pstmt.setString(1,safetyId);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					ConstructionSafety constructionSafety = new ConstructionSafety();
					constructionSafety.setConsId(rs.getString("consId"));
					constructionSafety.setPrjId(rs.getString("prjId"));
					constructionSafety.setSafetyId(safetyId);
					constructionSafety.setSafetyManagecheckNum(rs.getString("safetyManagecheckNum"));
					constructionSafety.setSafetyManageNum(rs.getString("safetyManageNum"));
					constructionSafety.setSafetyManageName(rs.getString("SafetyManageName"));
					cs.add(constructionSafety);
				}
				
				
				//רҵ�ְ���λ
				List<Major> majors = new ArrayList<Major>(); 
				pstmt = conn.prepareStatement("select * from SAFETY_MAJOR where safetyId=?");
				pstmt.setString(1,safetyId);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Major major = new Major();
					major.setMajorId(rs.getString("majorId"));
					major.setMajorLicenseDate(rs.getDate("majorLicenseDate"));
					major.setMajorCardNum(rs.getString("majorCardNum"));
					major.setMajorName(rs.getString("majorName"));
					major.setMajorPhone(rs.getString("majorPhone"));
					major.setMajorProject(rs.getString("majorProject"));
					major.setMajorStaff(rs.getString("majorStaff"));
					major.setPrjId(rs.getString("prjId"));
					major.setSafetyId(safetyId);
					majors.add(major);
				}
				
				
				//����ְ���λ
				List<Labour> labours = new ArrayList<Labour>(); 
				pstmt = conn.prepareStatement("select * from SAFETY_LABOURS "
						+ "where safetyId=?");
				pstmt.setString(1,safetyId);	
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					Labour labour = new Labour();
					labour.setLabourId(rs.getString("labourId"));
					labour.setLabourLicenseDate(rs.getDate("labourLicenseDate"));
					labour.setLabourName(rs.getString("labourName"));
					labour.setLabourPhone(rs.getString("labourPhone"));
					labour.setLabourStaff(rs.getString("labourStaff"));
					labour.setPrjId(rs.getString("prjId"));
					labour.setSafetyId(safetyId);
					labours.add(labour);
				}
				
				quality.setCsList(cs);
				quality.setMajors(majors);
				quality.setLabours(labours);
			}
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,safetyId);
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
			quality.setList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
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

	//��������
		public List<DictionaryClass> queryProjectTypes()
		{
			String sql = "select * from PROJECT_TYPE";
			List<DictionaryClass> list = new ArrayList<DictionaryClass>();
			try {
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DictionaryClass dictionaryClass = new DictionaryClass();
					dictionaryClass.setCode(rs.getString("code").trim());
					dictionaryClass.setName(rs.getString("NAMES"));
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
