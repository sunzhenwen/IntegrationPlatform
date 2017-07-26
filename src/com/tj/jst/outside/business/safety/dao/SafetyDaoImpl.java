package com.tj.jst.outside.business.safety.dao;

import java.io.File;
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
import com.tj.jst.inner.accessory.model.Accessory;
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
public class SafetyDaoImpl extends BaseDao implements ISafetyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
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
	 * ��ȫ�ල����
	 * @return
	 */
	public String add(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours)
	{
		String safetyId = UUID.randomUUID().toString();
		//System.out.println(quality.getContractorCorpCode());
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TB_SAFETYSUPERVISION(SAFETYID,PRJNUM,PRJNAME,"
					+ "prjId,createDate,applyCorpCode,applyCorpName,appType,processSteps,"
					+ "appDept,appDeptName,projectName,projectAddress,"
					+ "proStartDate,proEndDate,projectType,safetyTarget,newlyBuild,"
					+ "extend,other,policingName,policingStaff,designName,designStaff,"
					+ "buildingName,buildingStaff,buildingPhone,supervisionName,"
					+ "supervisionStaff,supervisionNum,supervisionPhone,probationStaff,"
					+ "probationPhone,probationNum,probationSafeNum,contractName,"
					+ "contractAdmin,contractPhone,contractStaff,contractSafeNum,"
					+ "contractProStaff,contractProStaffPhone,contractStaffRegNum,"
					+ "contractStaffNum,UNITPROJECT,SCALE,COST,STRUCTURE,"
					+ "HEIGHT,safetyNum,contractorCorpCode,expankj) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,safetyId);//����
			pstmt.setString(2,quality.getPrjNum());//��Ŀ���
			pstmt.setString(3,quality.getPrjName());//��Ŀ����
			pstmt.setString(4,quality.getPrjId());//��Ŀ��������
			pstmt.setDate(5,new Date(new java.util.Date().getTime())); //��¼�Ǽ�����
			pstmt.setString(6,quality.getApplyCorpCode()); //������ҵ��֯��������
			pstmt.setString(7,quality.getApplyCorpName()); //������ҵ����
			/**
			 * ����״̬
			 * 0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(8,"0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(9,"4");
			pstmt.setString(10,quality.getAppDept());//������λid
			pstmt.setString(11,quality.getAppDeptName());//������λ����
			//pstmt.setString(12, quality.getOversightNum());//��ȫ�ල�ǼǱ��
			pstmt.setString(12, quality.getProjectName());//��������
			pstmt.setString(13, quality.getProjectAddress());//���̵ص�
			pstmt.setDate(14, quality.getProStartDate());//��ͬ��������
			pstmt.setDate(15, quality.getProEndDate());//��ͬ��������
			pstmt.setString(16, quality.getProjectType());//��������
			pstmt.setString(17,quality.getSafetyTarget());//��ȫ������׼������Ŀ��
			pstmt.setString(18,quality.getNewlyBuild());//�½�
			pstmt.setString(19,quality.getExtend());//������
			pstmt.setString(20,quality.getOther());//����
			pstmt.setString(21,quality.getPolicingName());//���쵥λȫ��
			pstmt.setString(22,quality.getPolicingStaff());//���쵥λ��Ŀ������
			pstmt.setString(23,quality.getDesignName());//��Ƶ�λȫ��
			pstmt.setString(24,quality.getDesignStaff());//��Ƶ�λ��Ŀ������
			pstmt.setString(25,quality.getBuildingName());//���赥λȫ��
			pstmt.setString(26,quality.getBuildingStaff());//���赥λ��Ŀ������
			pstmt.setString(27,quality.getBuildingPhone());//���赥λ��ϵ�绰
			pstmt.setString(28,quality.getSupervisionName());//����λȫ��
			pstmt.setString(29,quality.getSupervisionStaff());//����λ��Ŀ�ܼ�����
			pstmt.setString(30,quality.getSupervisionNum());//����λ��Ŀ�ܼ�ע��֤���
			pstmt.setString(31,quality.getSupervisionPhone());//����λ��Ŀ�ܼ���ϵ�绰
			pstmt.setString(32,quality.getProbationStaff());//����λ��ȫ�ල����
			pstmt.setString(33,quality.getProbationPhone());//����λ��ȫ�ල��ϵ�绰
			pstmt.setString(34,quality.getProbationNum());//����λ��ȫ�ලע��֤���
			pstmt.setString(35,quality.getProbationSafeNum());//����λ��ȫ�ල��ȫ����֤��
			pstmt.setString(36,quality.getContractName());//ʩ���ܳа���λȫ��
			pstmt.setString(37,quality.getContractAdmin());//ʩ���ܳа���λ��˾��ȫ����
			pstmt.setString(38,quality.getContractPhone());//ʩ���ܳа���λ��ϵ�绰
			pstmt.setString(39,quality.getContractStaff());//ʩ���ܳа���λ������
			pstmt.setString(40,quality.getContractSafeNum());//ʩ���ܳа���λ��ȫ����֤��
			pstmt.setString(41,quality.getContractProStaff());//ʩ���ܳа���λ��Ŀ����������
			pstmt.setString(42,quality.getContractProStaffPhone());//ʩ���ܳа���λ��Ŀ��������ϵ�绰
			pstmt.setString(43,quality.getContractStaffRegNum());//ʩ���ܳа���λ��Ŀ������ע��֤��
			pstmt.setString(44,quality.getContractStaffNum());//ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
			//pstmt.setString(46, quality.getSingleNum());//��λ���̱��
			pstmt.setString(45, quality.getUnitProject());//��λ����
			pstmt.setString(46, quality.getScale());//������ģ
			pstmt.setString(47, quality.getCost());//�������
			pstmt.setString(48, quality.getStructure());//�ṹ/���
			pstmt.setString(49, quality.getHeight());//�����߶�
			pstmt.setString(50, quality.getSafetyNum());
			pstmt.setString(51, quality.getContractorCorpCode());//������֯�������� 
			pstmt.setString(52, quality.getExpankj());//����
			pstmt.executeUpdate();
			
			//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
			for(int i=0;i<constructionSafety.size();i++)
			{
				if(!"".equals(constructionSafety.get(i).getSafetyManageName().trim()))
				{
					String id = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into CONSTRUCTION_SAFETY(CONSID,"
							+ "PRJID,safetyManageName,safetyManageNum,"
							+ "safetyManagecheckNum,createDate,safetyId) "
							+ "values(?,?,?,?,?,?,?)");
					pstmt.setString(1,id);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,constructionSafety.get(i).getSafetyManageName()); 
					pstmt.setString(4,constructionSafety.get(i).getSafetyManageNum()); 
					pstmt.setString(5,constructionSafety.get(i).getSafetyManagecheckNum());
					pstmt.setDate(6,new Date(new java.util.Date().getTime()));
					pstmt.setString(7, safetyId);
					pstmt.executeUpdate();
				}
			}
			
			//רҵ�ְ���λ
			for(int i=0;i<majors.size();i++)
			{
				if(!"".equals(majors.get(i).getMajorName().trim()))
				{
					String majorId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_MAJOR(MAJORID,"
							+ "PRJID,safetyId,majorName,majorProject,majorLicenseDate,"
							+ "majorStaff,majorCardNum,majorPhone,createDate) "
							+ "values(?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1,majorId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,safetyId); 
					pstmt.setString(4,majors.get(i).getMajorName()); 
					pstmt.setString(5,majors.get(i).getMajorProject());
					pstmt.setDate(6,majors.get(i).getMajorLicenseDate());
					pstmt.setString(7,majors.get(i).getMajorStaff());
					pstmt.setString(8,majors.get(i).getMajorCardNum());
					pstmt.setString(9,majors.get(i).getMajorPhone());
					pstmt.setDate(10,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
				}
			}
			
			//����ְ���λ
			for(int i=0;i<labours.size();i++)
			{
				if(!"".equals(labours.get(i).getLabourName().trim()))
				{
					String labourId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_LABOURS(labourId,"
							+ "prjId,safetyId,labourName,labourLicenseDate,labourStaff,"
							+ "labourPhone,createDate) values(?,?,?,?,?,?,?,?)");
					pstmt.setString(1,labourId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,safetyId); 
					pstmt.setString(4,labours.get(i).getLabourName()); 
					pstmt.setDate(5,labours.get(i).getLabourLicenseDate());
					pstmt.setString(6,labours.get(i).getLabourStaff());
					pstmt.setString(7,labours.get(i).getLabourPhone());
					pstmt.setDate(8,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
				}
			}
			
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
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return safetyId;
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
				//quality.setOversightNum(rs.getString("oversightNum"));//��ȫ�ල�ǼǱ��
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
				if(rs.getString("expankj") != null)
				{
					quality.setExpankj(rs.getString("expankj").trim());//����
				}else
				{
					quality.setExpankj(rs.getString("expankj"));//����
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
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=5 order by num");
			rs = pstmt.executeQuery();
			List<Accessory> accessoryList = new ArrayList<Accessory>();
			while(rs.next())
			{
				Accessory acc = new Accessory();
				acc.setId(rs.getString("id"));
				acc.setLinkNum(rs.getString("linkNum"));
				acc.setLinkName(rs.getString("linkName"));
				acc.setMessage(rs.getString("message"));
				
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? and ACCESSOTYID=? ");
				pstmt.setString(1,safetyId);
				pstmt.setString(2, acc.getId());
				uploadRs = pstmt.executeQuery();
				List<Upload> list = new ArrayList<Upload>();
				while(uploadRs.next())
				{
					Upload upload = new Upload();
					upload.setUploadId(uploadRs.getString("uploadId"));
					upload.setRoot(uploadRs.getString("root"));
					upload.setNewName(uploadRs.getString("newName"));
					upload.setLinkName(uploadRs.getString("linkName"));
					upload.setIsUnits(uploadRs.getString("isUnits"));
					upload.setId(uploadRs.getString("id"));
					upload.setFileFileName(uploadRs.getString("fileFileName"));
					list.add(upload);
				}
				acc.setList(list);
				accessoryList.add(acc);
			}
			quality.setAccessoryList(accessoryList);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			if(uploadRs!=null)
			{
				try {
					uploadRs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	/**
	 * ��ȫ�ල�����޸�
	 * @return
	 */
	public void modify(Safety quality,List<ConstructionSafety> constructionSafety,List<Major> majors,List<Labour> labours)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TB_SAFETYSUPERVISION set PRJNUM=?,PRJNAME=?,"
					+ "prjId=?,"
					+ "projectName=?,projectAddress=?,"
					+ "proStartDate=?,proEndDate=?,projectType=?,safetyTarget=?,newlyBuild=?,"
					+ "extend=?,other=?,policingName=?,policingStaff=?,designName=?,designStaff=?,"
					+ "buildingName=?,buildingStaff=?,buildingPhone=?,supervisionName=?,"
					+ "supervisionStaff=?,supervisionNum=?,supervisionPhone=?,probationStaff=?,"
					+ "probationPhone=?,probationNum=?,probationSafeNum=?,contractName=?,"
					+ "contractAdmin=?,contractPhone=?,contractStaff=?,contractSafeNum=?,"
					+ "contractProStaff=?,contractProStaffPhone=?,contractStaffRegNum=?,"
					+ "contractStaffNum=?,UNITPROJECT=?,SCALE=?,COST=?,STRUCTURE=?,"
					+ "HEIGHT=?,EXPANKJ=? where SAFETYID=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,quality.getPrjNum());//��Ŀ���
			pstmt.setString(2,quality.getPrjName());//��Ŀ����
			pstmt.setString(3,quality.getPrjId());//��Ŀ��������
			//pstmt.setString(4, quality.getOversightNum());//��ȫ�ල�ǼǱ��
			pstmt.setString(4, quality.getProjectName());//��������
			pstmt.setString(5, quality.getProjectAddress());//���̵ص�
			pstmt.setDate(6, quality.getProStartDate());//��ͬ��������
			pstmt.setDate(7, quality.getProEndDate());//��ͬ��������
			pstmt.setString(8, quality.getProjectType());//��������
			pstmt.setString(9,quality.getSafetyTarget());//��ȫ������׼������Ŀ��
			pstmt.setString(10,quality.getNewlyBuild());//�½�
			pstmt.setString(11,quality.getExtend());//�Ľ�
			pstmt.setString(12,quality.getOther());//����
			pstmt.setString(13,quality.getPolicingName());//���쵥λȫ��
			pstmt.setString(14,quality.getPolicingStaff());//���쵥λ��Ŀ������
			pstmt.setString(15,quality.getDesignName());//��Ƶ�λȫ��
			pstmt.setString(16,quality.getDesignStaff());//��Ƶ�λ��Ŀ������
			pstmt.setString(17,quality.getBuildingName());//���赥λȫ��
			pstmt.setString(18,quality.getBuildingStaff());//���赥λ��Ŀ������
			pstmt.setString(19,quality.getBuildingPhone());//���赥λ��ϵ�绰
			pstmt.setString(20,quality.getSupervisionName());//����λȫ��
			pstmt.setString(21,quality.getSupervisionStaff());//����λ��Ŀ�ܼ�����
			pstmt.setString(22,quality.getSupervisionNum());//����λ��Ŀ�ܼ�ע��֤���
			pstmt.setString(23,quality.getSupervisionPhone());//����λ��Ŀ�ܼ���ϵ�绰
			pstmt.setString(24,quality.getProbationStaff());//����λ��ȫ�ල����
			pstmt.setString(25,quality.getProbationPhone());//����λ��ȫ�ල��ϵ�绰
			pstmt.setString(26,quality.getProbationNum());//����λ��ȫ�ලע��֤���
			pstmt.setString(27,quality.getProbationSafeNum());//����λ��ȫ�ල��ȫ����֤��
			pstmt.setString(28,quality.getContractName());//ʩ���ܳа���λȫ��
			pstmt.setString(29,quality.getContractAdmin());//ʩ���ܳа���λ��˾��ȫ����
			pstmt.setString(30,quality.getContractPhone());//ʩ���ܳа���λ��ϵ�绰
			pstmt.setString(31,quality.getContractStaff());//ʩ���ܳа���λ������
			pstmt.setString(32,quality.getContractSafeNum());//ʩ���ܳа���λ��ȫ����֤��
			pstmt.setString(33,quality.getContractProStaff());//ʩ���ܳа���λ��Ŀ����������
			pstmt.setString(34,quality.getContractProStaffPhone());//ʩ���ܳа���λ��Ŀ��������ϵ�绰
			System.out.println(quality.getContractProStaffPhone());
			pstmt.setString(35,quality.getContractStaffRegNum());//ʩ���ܳа���λ��Ŀ������ע��֤��
			pstmt.setString(36,quality.getContractStaffNum());//ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
			//pstmt.setString(38, quality.getSingleNum());//��λ���̱��
			pstmt.setString(37, quality.getUnitProject());//��λ����
			pstmt.setString(38, quality.getScale());//������ģ
			pstmt.setString(39, quality.getCost());//�������
			pstmt.setString(40, quality.getStructure());//�ṹ/���
			pstmt.setString(41, quality.getHeight());//�����߶�
			pstmt.setString(42,quality.getExpankj());//���� 
			pstmt.setString(43,quality.getSafetyId());//����

			pstmt.executeUpdate();
			
			//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
			pstmt = conn.prepareStatement("delete from CONSTRUCTION_SAFETY where safetyId=?");
			pstmt.setString(1,quality.getSafetyId()); 
			pstmt.executeUpdate();
			for(int i=0;i<constructionSafety.size();i++)
			{
				if(!constructionSafety.get(i).getSafetyManageName().trim().equals(""))
				{
					String id = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into CONSTRUCTION_SAFETY(CONSID,"
							+ "PRJID,safetyManageName,safetyManageNum,"
							+ "safetyManagecheckNum,createDate,safetyId) "
							+ "values(?,?,?,?,?,?,?)");
					pstmt.setString(1,id);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,constructionSafety.get(i).getSafetyManageName()); 
					pstmt.setString(4,constructionSafety.get(i).getSafetyManageNum()); 
					pstmt.setString(5,constructionSafety.get(i).getSafetyManagecheckNum());
					pstmt.setDate(6,new Date(new java.util.Date().getTime()));
					pstmt.setString(7, quality.getSafetyId());
					pstmt.executeUpdate();
				}
			}
			
			//רҵ�ְ���λ
			pstmt = conn.prepareStatement("delete from SAFETY_MAJOR where safetyId=?");
			pstmt.setString(1,quality.getSafetyId()); 
			pstmt.executeUpdate();
			for(int i=0;i<majors.size();i++)
			{
				if(!"".equals(majors.get(i).getMajorName().trim()))
				{
					String majorId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_MAJOR(MAJORID,"
							+ "PRJID,safetyId,majorName,majorProject,majorLicenseDate,"
							+ "majorStaff,majorCardNum,majorPhone,createDate) "
							+ "values(?,?,?,?,?,?,?,?,?,?)");
					pstmt.setString(1,majorId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,quality.getSafetyId()); 
					pstmt.setString(4,majors.get(i).getMajorName()); 
					pstmt.setString(5,majors.get(i).getMajorProject());
					pstmt.setDate(6,majors.get(i).getMajorLicenseDate());
					pstmt.setString(7,majors.get(i).getMajorStaff());
					pstmt.setString(8,majors.get(i).getMajorCardNum());
					pstmt.setString(9,majors.get(i).getMajorPhone());
					pstmt.setDate(10,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
					
				}
			}
			
			//����ְ���λ
			pstmt = conn.prepareStatement("delete from SAFETY_LABOURS where safetyId=?");
			pstmt.setString(1,quality.getSafetyId()); 
			pstmt.executeUpdate();
			for(int i=0;i<labours.size();i++)
			{
				if(!labours.get(i).getLabourName().trim().equals(""))
				{
					String labourId = UUID.randomUUID().toString();
					pstmt = conn.prepareStatement("insert into SAFETY_LABOURS(labourId,"
							+ "prjId,safetyId,labourName,labourLicenseDate,labourStaff,"
							+ "labourPhone,createDate) values(?,?,?,?,?,?,?,?)");
					pstmt.setString(1,labourId);	
					pstmt.setString(2,quality.getPrjId()); 
					pstmt.setString(3,quality.getSafetyId()); 
					pstmt.setString(4,labours.get(i).getLabourName()); 
					pstmt.setDate(5,labours.get(i).getLabourLicenseDate());
					pstmt.setString(6,labours.get(i).getLabourStaff());
					pstmt.setString(7,labours.get(i).getLabourPhone());
					pstmt.setDate(8,new Date(new java.util.Date().getTime()));
					pstmt.executeUpdate();
				}
			}
			
			
			conn.commit();
			
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
	}
	
	/**
	 * ɾ��
	 * @return
	 */
	public void delete(String safetyId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TB_SAFETYSUPERVISION where SAFETYID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, safetyId);//����
			pstmt.executeUpdate();
			
			//ʩ���ܳа���λ�ֳ�רְ��ȫ������Ա
			pstmt = conn.prepareStatement("delete from CONSTRUCTION_SAFETY where safetyId=?");
			pstmt.setString(1, safetyId);
			pstmt.executeUpdate();
			
			//רҵ�ְ���λ
			pstmt = conn.prepareStatement("delete from SAFETY_MAJOR where safetyId=?");
			pstmt.setString(1, safetyId);
			pstmt.executeUpdate();
			
			//����ְ���λ
			pstmt = conn.prepareStatement("delete from SAFETY_LABOURS where safetyId=?");
			pstmt.setString(1, safetyId);
			pstmt.executeUpdate();
			
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,safetyId);	
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				try {
					File myDelFile = new File(rs.getString("root")+"\\"+rs.getString("newName"));
					if (myDelFile.exists())
						myDelFile.delete();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			pstmt = conn.prepareStatement("delete from UPLOAD_FILE where id=?");
			pstmt.setString(1,safetyId);	
			pstmt.executeUpdate();
			
			conn.commit();
			
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
