package com.tj.jst.outside.business.queryprojection.dao;

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
import com.tj.jst.outside.business.complete.model.Complete;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.contractFiling.model.ContractFiling;
import com.tj.jst.outside.business.quality.model.Quality;
import com.tj.jst.outside.business.queryprojection.model.Filing;
import com.tj.jst.outside.business.queryprojection.model.Permit;
import com.tj.jst.outside.business.queryprojection.model.Plan;
import com.tj.jst.outside.business.queryprojection.model.ProjectModel;
import com.tj.jst.outside.business.queryprojection.model.Ready;
import com.tj.jst.outside.business.queryprojection.model.Tender;
import com.tj.jst.outside.business.safety.model.ConstructionSafety;
import com.tj.jst.outside.business.safety.model.Labour;
import com.tj.jst.outside.business.safety.model.Major;
import com.tj.jst.outside.business.safety.model.Safety;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ҵ���ѯ
 * 
 * @author Administrator
 *
 */
public class QueryProjectDaoImpl extends BaseDao implements IQueryProjectDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ��ѯ
	 */
	@Override
	public Page queryPage(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Construction construction = new Construction();

					construction.setPrjId(rs.getString("prjId"));// ����
					construction.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					construction.setPrjName(rs.getString("prjName"));// ��Ŀ����
					construction.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����(�ֵ��TBPRJTYPEDIC)
					construction.setPrjTypeName(rs.getString("prjTypeName"));
					construction
							.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
					construction
							.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������
					construction.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
					construction.setProvinceName(rs.getString("provinceName"));
					construction.setCityNum(rs.getString("cityNum"));// ��Ŀ������(�ֵ��TBXZQDMDIC)
					construction.setCityName(rs.getString("cityName"));
					construction.setCountyNum(rs.getString("countyNum"));// ��Ŀ��������(�ֵ��TBXZQDMDIC)
					construction.setCountyName(rs.getString("countyName"));
					construction.setPrjApprovalNum(rs
							.getString("prjApprovalNum"));// �����ĺ�
					construction.setPrjApprovalLevelNum(rs
							.getString("prjApprovalLevelNum"));// �����
					construction.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					construction.setProjectPlanNum(rs
							.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					construction.setAllInvest(rs.getString("allInvest"));// ��Ͷ�ʣ���Ԫ��
					construction.setAllArea(rs.getString("allArea"));// �������ƽ���ף�
					construction.setPrjSize(rs.getString("prjSize"));// �����ģ
					construction.setPrjPropertyNum(rs
							.getString("prjPropertyNum"));// ��������(�ֵ��TBPRJPORPERTYDIC)
					construction.setPrjFuncitonNum(rs
							.getString("PRJFUNCTIONNUM"));// ������;(�ֵ��TBPRJFUNCTIONDIC)
					construction.setBDate(rs.getDate("bDate"));// ʵ�ʿ������ڣ�������������ΪM
					construction.setEDate(rs.getDate("eDate"));// ʵ�ʿ����������ڣ�������������ΪM
					construction.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
//					/**
//					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
//					 */
//					construction.setAppType(rs.getString("appType").trim());// ����״̬
//					/**
//					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
//					 * 6:��������
//					 */
//					construction.setProcessSteps(rs.getString("processSteps"));
//					construction.setAppDept(rs.getString("appDept"));// ������λid
//					construction.setAppDeptName(rs.getString("appDeptName"));// ������λ����
					page.getData().add(construction);
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

	@Override
	public ProjectModel queryProjectInfo(String prjName) {
		// TODO Auto-generated method stub
		String sql = "select t.*, "
				+ "(select a.PROCLASSIFICATION from TBPRJTYPEDIC a where t.prjTypeNum=a.code) as prjTypeName,"
				+ "(select b.name from TBXZQDMDIC b where t.provinceNum=b.code) as provinceName,"
				+ "(select c.name from TBXZQDMDIC c where t.cityNum=c.code) as cityName,"
				+ "(select d.name from TBXZQDMDIC d where t.countyNum=d.code) as countyName,"
				+ "(select e.PROLEVEL from TBLXJBDIC e where t.prjApprovalLevelNum=e.code) as prjApprovalLevelName,"
				+ "(select f.NATURE from TBPRJPROPERTYDIC f where t.prjPropertyNum=f.code) as prjPropertyName,"
				+ "(select g.ENGINEERUSE from TBPRJFUNCTIONDIC g where t.prjFunctionNum=g.code) as prjFunctionName"
				+ " from TBProjectInfo_S t where t.PRJNUM = '" + prjName + "'";
		ProjectModel project = new ProjectModel();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				project.setPrjId(rs.getString("prjId"));// ����
				project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				project.setPrjName(rs.getString("prjName"));// ��Ŀ����
				project.setPrjTypeName(rs.getString("prjTypeName"));// ��Ŀ����
				project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
				project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
				project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
				project.setProvinceName(rs.getString("provinceName"));// ��Ŀ����ʡ
				project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
				project.setCityName(rs.getString("cityName"));// ��Ŀ������
				project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
				project.setCountyName(rs.getString("countyName"));// ��Ŀ������
				project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
				project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
				project.setPrjApprovalLevelName(rs// �����
						.getString("prjApprovalLevelName"));
				project.setPrjApprovalLevelNum(rs// �����
						.getString("prjApprovalLevelNum"));
				project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
				project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
				project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
				project.setAllArea(rs.getString("allArea"));// �����
				project.setPrjSize(rs.getString("prjSize"));// �����ģ
				project.setPrjPropertyName(rs.getString("prjPropertyName"));// ��������
				project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
				project.setPrjFunctionName(rs.getString("prjFunctionName"));// ������;
				project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// ������;
				project.setBeginDate(rs.getDate("bDate"));// ��ʼʱ��
				project.setEndDate(rs.getDate("eDate"));// ����ʱ��
				project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
				project.setAppDept(rs.getString("appDept"));// ��ȡ����PrjNum��ֵ
				project.setBuldPlanNum(rs.getString("BULDPLANNUM"));//�����õع滮���֤���
				project.setProjectPlanNum(rs.getString("PROJECTPLANNUM"));//���蹤�̹滮���֤���
				project.setBeginDate(rs.getDate("BDATE"));//ʵ�ʿ������ڣ�������������ΪM
				project.setEndDate(rs.getDate("EDATE"));//ʵ�ʿ����������ڣ�������������ΪM
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return project;
	}

	@Override
	public Page queryPlanInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Plan plan = new Plan();
					plan.setCensorId(rs.getString("censorId"));// ����
					plan.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�֤����
					plan.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					plan.setPrjName(rs.getString("prjName"));// ��Ŀ����
					plan.setCensorCorpName(rs.getString("censorCorpName"));// ʩ��ͼ����������
					plan.setCensorCorpCode(rs.getString("censorCorpCode"));// ʩ��ͼ��������֯��������
					plan.setCensorEDate(rs.getDate("censorEDate"));// ����������
					plan.setPrjSize(rs.getString("prjSize"));// �����ģ
					plan.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
					plan.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
					plan.setEconCorpName2(rs.getString("econCorpName2"));// ���쵥λ����2
					plan.setEconCorpCode2(rs.getString("econCorpCode2")); // ���쵥λ��֯��������2
					plan.setEconCorpName3(rs.getString("econCorpName3"));// ���쵥λ����3
					plan.setEconCorpCode3(rs.getString("econCorpCode3")); // ���쵥λ��֯��������3
					plan.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
					plan.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
					plan.setDesignCorpName2(rs.getString("designCorpName2"));// ��Ƶ�λ����2
					plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// ��Ƶ�λ��֯��������2
					plan.setDesignCorpName3(rs.getString("designCorpName3"));// ��Ƶ�λ����3
					plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// ��Ƶ�λ��֯��������3
					plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// һ������Ƿ�ͨ��
																				// ͨ��1����ͨ��0
					plan.setOneCensorWfqtCount(rs
							.getString("oneCensorWfqtCount"));// һ�����ʱΥ��ǿ����
					plan.setOneCensorWfqtContent(rs
							.getString("oneCensorWfqtContent"));// һ�����ʱΥ����ǿ����Ŀ
					plan.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					plan.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					plan.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					plan.setAppSteffId(rs.getString("appSteffId"));// ������id
					plan.setAppSteffName(rs.getString("appSteffName"));// ����������
					plan.setAppDate(rs.getDate("appDate"));// ����ʱ��
					plan.setAppOpinion(rs.getString("appOpinion"));// �������
					/**
					 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					plan.setAppType(rs.getString("appType").trim());// ����״̬
					/**
					 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
					 * 6:��������
					 */
					plan.setProcessSteps(rs.getString("processSteps").trim());
					plan.setAppDept(rs.getString("appDept").trim());// ������λid
					plan.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
					page.getData().add(plan);
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

	@Override
	public Page queryFilingInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Filing filing = new Filing();
					filing.setRecordId(rs.getString("recordId"));// ����
					filing.setRecordNum(rs.getString("recordNum"));// ��ͬ�������
					filing.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					filing.setPrjName(rs.getString("prjName"));// ��Ŀ����
					filing.setContractNum(rs.getString("contractNum"));// ��ͬ���
					filing.setContractTypeNum(rs.getString("contractTypeNum"));// ��ͬ���(TBCONTRACTTYPEDIC)
					filing.setContractTypeName(rs.getString("contractTypeName"));// ��ͬ�������
					filing.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
					filing.setPrjSize(rs.getString("prjSize"));// �����ģ
					filing.setContractDate(rs.getDate("contractDate"));// ��ͬǩ������
					filing.setPropietorCorpName(rs
							.getString("propietorCorpName"));// ������λ����
					filing.setPropietorCorpCode(rs
							.getString("propietorCorpCode"));// ������λס��֯����
					filing.setContractorCorpName(rs
							.getString("contractorCorpName"));// �а���λ����
					filing.setContractorCorpCode(rs
							.getString("contractorCorpCode"));// �а���λ��֯����
					filing.setUnionCorpName(rs.getString("unionCorpName"));// ������а���λ����
					filing.setUnionCorpCode(rs.getString("unionCorpCode"));// ������а���λ��֯����
					filing.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					filing.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					filing.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					filing.setAppSteffId(rs.getString("appSteffId"));// ������id
					filing.setAppSteffName(rs.getString("appSteffName"));// ����������
					filing.setAppDate(rs.getDate("appDate"));// ����ʱ��
					filing.setAppOpinion(rs.getString("appOpinion"));// �������
					page.getData().add(filing);
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

	@Override
	public Page queryPermitInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Permit permit = new Permit();
					permit.setPermitId(rs.getString("permitId"));// ����
					permit.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					permit.setPrjName(rs.getString("prjName"));// ��Ŀ����
					permit.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// ʩ�����֤���
					permit.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					permit.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					permit.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�����
					permit.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
					permit.setArea(rs.getString("area"));// ���(ƽ����)
					permit.setPrjSize(rs.getString("prjSize"));// �����ģ
					permit.setIssueCertDate(rs.getDate("issueCertDate"));// ��֤����
					permit.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
					permit.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
					permit.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
					permit.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
					permit.setConsCorpname(rs.getString("consCorpname"));// ʩ����λ����
					permit.setConsCorpCode(rs.getString("consCorpCode"));// ʩ����λ��֯��������
					permit.setSafetyCerId(rs.getString("safetyCerId"));// ʩ����λ��ȫ�������֤���
					permit.setSuperCorpName(rs.getString("superCorpName"));// ����λ����
					permit.setSuperCorpCode(rs.getString("superCorpCode"));// ����λ��֯��������
					permit.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
					permit.setCidCardTypeNum(rs.getString("cidCardTypeNum"));// ��Ŀ����֤������(TBIDCARDTYPEDIC)
					permit.setConstructorIdCard(rs
							.getString("constructorIdCard"));// ��Ŀ����֤������
					permit.setSupervisionName(rs.getString("supervisionName"));// �ܼ�����ʦ����
					permit.setSidCardTypeNum(rs.getString("sidCardTypeNum"));// �ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
					permit.setSupervisionIdCard(rs
							.getString("supervisionIdCard"));// �ܼ�����ʦ����
					permit.setUserName(rs.getString("userName"));// ��ȫ����������Ա����
					permit.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ��ȫ��������֤������(TBIDCARDTYPEDIC)
					permit.setIdCard(rs.getString("idCard"));// ��ȫ����������Ա֤����
					permit.setCertId(rs.getString("certId"));// ��ȫ�������˺ϸ�֤����
					permit.setUserType(rs.getString("userType"));// ��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
					permit.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					permit.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					permit.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					permit.setAppSteffId(rs.getString("appSteffId"));// ������id
					permit.setAppSteffName(rs.getString("appSteffName"));// ����������
					permit.setAppDate(rs.getDate("appDate"));// ����ʱ��
					permit.setAppOpinion(rs.getString("appOpinion"));// �������
					page.getData().add(permit);
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

	@Override
	public Page queryReadyInfo(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					Ready complete = new Ready();
					complete.setCompleteId(rs.getString("completeId"));// ����
					complete.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					complete.setPrjName(rs.getString("prjName"));// ��Ŀ����
					complete.setBuilderLicenceNum(rs
							.getString("builderLicenceNum"));// ʩ�����֤���
					complete.setQcCorpName(rs.getString("qcCorpName"));
					complete.setQcCorpCode(rs.getString("qcCorpCode"));
					complete.setFactCost(rs.getString("factCost"));
					complete.setFactArea(rs.getString("factArea"));
					complete.setFactSize(rs.getString("factSize"));
					complete.setPrjStructureTypeNum(rs
							.getString("prjStructureTypeNum"));
					complete.setBDate(rs.getDate("bDate"));
					complete.setEDate(rs.getDate("eDate"));
					complete.setMark(rs.getString("mark"));
					complete.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
					complete.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
					complete.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
					complete.setAppSteffId(rs.getString("appSteffId"));// ������id
					complete.setAppSteffName(rs.getString("appSteffName"));// ����������
					complete.setAppDate(rs.getDate("appDate"));// ����ʱ��
					complete.setAppOpinion(rs.getString("appOpinion"));// �������
					page.getData().add(complete);
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

	@Override
	public List<Filing> queryFilingList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from v_tbcontractrecordmanage where prjNum='"
				+ prjNum + "'";
		List<Filing> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Filing filing = new Filing();
				filing.setRecordId(rs.getString("recordId"));// ����
				filing.setRecordNum(rs.getString("recordNum"));// ��ͬ�������
				filing.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				filing.setPrjName(rs.getString("prjName"));// ��Ŀ����
				filing.setContractNum(rs.getString("contractNum"));// ��ͬ���
				filing.setContractTypeNum(rs.getString("contractTypeNum"));// ��ͬ���(TBCONTRACTTYPEDIC)
				filing.setContractTypeName(rs.getString("contractTypeName"));// ��ͬ�������
				filing.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
				filing.setPrjSize(rs.getString("prjSize"));// �����ģ
				filing.setContractDate(rs.getDate("contractDate"));// ��ͬǩ������
				filing.setPropietorCorpName(rs.getString("propietorCorpName"));// ������λ����
				filing.setPropietorCorpCode(rs.getString("propietorCorpCode"));// ������λס��֯����
				filing.setContractorCorpName(rs.getString("contractorCorpName"));// �а���λ����
				filing.setContractorCorpCode(rs.getString("contractorCorpCode"));// �а���λ��֯����
				filing.setUnionCorpName(rs.getString("unionCorpName"));// ������а���λ����
				filing.setUnionCorpCode(rs.getString("unionCorpCode"));// ������а���λ��֯����
				filing.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
				filing.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				filing.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				filing.setAppSteffId(rs.getString("appSteffId"));// ������id
				filing.setAppSteffName(rs.getString("appSteffName"));// ����������
				filing.setAppDate(rs.getDate("appDate"));// ����ʱ��
				filing.setAppOpinion(rs.getString("appOpinion"));// �������
				list.add(filing);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Permit> queryPermitList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from tbbuilderlicencemanage where prjNum='"
				+ prjNum + "'";
		List<Permit> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Permit permit = new Permit();
				permit.setPermitId(rs.getString("permitId"));// ����
				permit.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				permit.setPrjId(rs.getString("prjId"));
				permit.setPrjName(rs.getString("prjName"));// ��Ŀ����
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// ʩ�����֤���
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
				permit.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�����
				permit.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
				permit.setArea(rs.getString("area"));// ���(ƽ����)
				permit.setPrjSize(rs.getString("prjSize"));// �����ģ
				permit.setIssueCertDate(rs.getDate("issueCertDate"));// ��֤����
				permit.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
				permit.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
				permit.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
				permit.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
				permit.setConsCorpname(rs.getString("consCorpname"));// ʩ����λ����
				permit.setConsCorpCode(rs.getString("consCorpCode"));// ʩ����λ��֯��������
				permit.setSafetyCerId(rs.getString("safetyCerId"));// ʩ����λ��ȫ�������֤���
				permit.setSuperCorpName(rs.getString("superCorpName"));// ����λ����
				permit.setSuperCorpCode(rs.getString("superCorpCode"));// ����λ��֯��������
				permit.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum").trim());// ��Ŀ����֤������(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));// ��Ŀ����֤������
				permit.setSupervisionName(rs.getString("supervisionName"));// �ܼ�����ʦ����
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum").trim());// �ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));// �ܼ�����ʦ����
//				permit.setUserName(rs.getString("userName"));// ��ȫ����������Ա����
//				permit.setIdCardTypeNum(rs.getString("IDCARDTYPENUM").trim());// ��ȫ��������֤������(TBIDCARDTYPEDIC)
//				permit.setIdCard(rs.getString("idCard"));// ��ȫ����������Ա֤����
//				permit.setCertId(rs.getString("certId"));// ��ȫ�������˺ϸ�֤����
//				permit.setUserType(rs.getString("userType").trim());// ��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
				permit.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				permit.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				permit.setAppSteffId(rs.getString("appSteffId"));// ������id
				permit.setAppSteffName(rs.getString("appSteffName"));// ����������
				permit.setAppDate(rs.getDate("appDate"));// ����ʱ��
				permit.setAppOpinion(rs.getString("appOpinion"));// �������
				list.add(permit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Plan> queryPlanList(String prjID) {
		// TODO Auto-generated method stub
		String sql = "select * from TBPROJECTCENSORINFO where prjID = '"
				+ prjID + "'";
		List<Plan> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Plan plan = new Plan();
				plan.setCensorId(rs.getString("censorId"));// ����
				plan.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�֤����
				plan.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				plan.setPrjName(rs.getString("prjName"));// ��Ŀ����
				plan.setCensorCorpName(rs.getString("censorCorpName"));// ʩ��ͼ����������
				plan.setCensorCorpCode(rs.getString("censorCorpCode"));// ʩ��ͼ��������֯��������
				plan.setCensorEDate(rs.getDate("censorEDate"));// ����������
				plan.setPrjSize(rs.getString("prjSize"));// �����ģ
				plan.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
				plan.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
				plan.setEconCorpName2(rs.getString("econCorpName2"));// ���쵥λ����2
				plan.setEconCorpCode2(rs.getString("econCorpCode2")); // ���쵥λ��֯��������2
				plan.setEconCorpName3(rs.getString("econCorpName3"));// ���쵥λ����3
				plan.setEconCorpCode3(rs.getString("econCorpCode3")); // ���쵥λ��֯��������3
				plan.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
				plan.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
				plan.setDesignCorpName2(rs.getString("designCorpName2"));// ��Ƶ�λ����2
				plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// ��Ƶ�λ��֯��������2
				plan.setDesignCorpName3(rs.getString("designCorpName3"));// ��Ƶ�λ����3
				plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// ��Ƶ�λ��֯��������3
				plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// һ������Ƿ�ͨ��
																			// ͨ��1����ͨ��0
				plan.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));// һ�����ʱΥ��ǿ����
				plan.setOneCensorWfqtContent(rs
						.getString("oneCensorWfqtContent"));// һ�����ʱΥ����ǿ����Ŀ
//				plan.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
//				plan.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
//				plan.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
//				plan.setAppSteffId(rs.getString("appSteffId"));// ������id
//				plan.setAppSteffName(rs.getString("appSteffName"));// ����������
//				plan.setAppDate(rs.getDate("appDate"));// ����ʱ��
//				plan.setAppOpinion(rs.getString("appOpinion"));// �������
				list.add(plan);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Ready> queryReadyList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TBPROJECTFINISHMANAGE where prjNum='"
				+ prjNum + "'";
		List<Ready> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Ready complete = new Ready();
				complete.setCompleteId(rs.getString("completeId"));// ����
				complete.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				complete.setPrjId(rs.getString("prjId"));
				complete.setPrjName(rs.getString("prjName"));// ��Ŀ����
				complete.setPrjFinishNum(rs.getString("PRJFINISHNUM"));
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// ʩ�����֤���
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs
						.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				complete.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				complete.setAppSteffId(rs.getString("appSteffId"));// ������id
				complete.setAppSteffName(rs.getString("appSteffName"));// ����������
				complete.setAppDate(rs.getDate("appDate"));// ����ʱ��
				complete.setAppOpinion(rs.getString("appOpinion"));
				list.add(complete);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public List<Tender> queryTenderList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from V_TBTENDERINFO where prjNum = '" + prjNum
				+ "'";
		List<Tender> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Tender tenderInfo = new Tender();
				tenderInfo.setTenderNum(rs.getString("tenderNum"));// �б�֪ͨ����
				tenderInfo.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));// �б�����(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));// �б귽ʽ(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));// �б�����
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));// �б���
				tenderInfo.setPrjSize(rs.getString("prjSize"));// �����ģ
				tenderInfo.setArea(rs.getString("area"));// ���(ƽ����)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));// �б����λ����
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));// �б����λ��֯��������
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));// �б굥λ����
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));// �б굥λ��֯��������
				tenderInfo.setConstructorName(rs.getString("constructorName"));// ��Ŀ����/�ܼ�����ʦ����
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs
						.getString("constructorIdCard"));// ��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setCreateDate(rs.getDate("createDate"));
				list.add(tenderInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Filing queryFilingInfo(String filingId) {
		// TODO Auto-generated method stub
		Filing filing = new Filing();
		String sql = "select * from v_tbcontractrecordmanage where recordId = '"
				+ filingId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				filing.setRecordId(rs.getString("recordId"));// ����
				filing.setRecordNum(rs.getString("recordNum"));// ��ͬ�������
				filing.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				filing.setPrjName(rs.getString("prjName"));// ��Ŀ����
				filing.setContractNum(rs.getString("contractNum"));// ��ͬ���
				filing.setContractTypeNum(rs.getString("contractTypeNum"));// ��ͬ���(TBCONTRACTTYPEDIC)
				filing.setContractTypeName(rs.getString("contractTypeName"));// ��ͬ�������
				filing.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
				filing.setPrjSize(rs.getString("prjSize"));// �����ģ
				filing.setContractDate(rs.getDate("contractDate"));// ��ͬǩ������
				filing.setPropietorCorpName(rs.getString("propietorCorpName"));// ������λ����
				filing.setPropietorCorpCode(rs.getString("propietorCorpCode"));// ������λס��֯����
				filing.setContractorCorpName(rs.getString("contractorCorpName"));// �а���λ����
				filing.setContractorCorpCode(rs.getString("contractorCorpCode"));// �а���λ��֯����
				filing.setUnionCorpName(rs.getString("unionCorpName"));// ������а���λ����
				filing.setUnionCorpCode(rs.getString("unionCorpCode"));// ������а���λ��֯����
				filing.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
				filing.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				filing.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				filing.setAppSteffId(rs.getString("appSteffId"));// ������id
				filing.setAppSteffName(rs.getString("appSteffName"));// ����������
				filing.setAppDate(rs.getDate("appDate"));// ����ʱ��
				filing.setAppOpinion(rs.getString("appOpinion"));// �������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return filing;
	}

	@Override
	public Permit queryPermitInfo(String permitId) {
		// TODO Auto-generated method stub
		Permit permit = new Permit();
		try {

			String qsql = "select * from tbbuilderlicencemanage where permitId=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, permitId);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				permit.setPermitId(rs.getString("permitId"));// ����
				permit.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				permit.setPrjName(rs.getString("prjName"));// ��Ŀ����
				permit.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// ʩ�����֤���
				permit.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
				permit.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
				permit.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�����
				permit.setContractMoney(rs.getString("contractMoney"));// ��ͬ���(��Ԫ)
				permit.setArea(rs.getString("area"));// ���(ƽ����)
				permit.setPrjSize(rs.getString("prjSize"));// �����ģ
				permit.setIssueCertDate(rs.getDate("issueCertDate"));// ��֤����
				permit.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
				permit.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
				permit.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
				permit.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
				permit.setConsCorpname(rs.getString("consCorpname"));// ʩ����λ����
				permit.setConsCorpCode(rs.getString("consCorpCode"));// ʩ����λ��֯��������
				permit.setSafetyCerId(rs.getString("safetyCerId"));// ʩ����λ��ȫ�������֤���
				permit.setSuperCorpName(rs.getString("superCorpName"));// ����λ����
				permit.setSuperCorpCode(rs.getString("superCorpCode"));// ����λ��֯��������
				permit.setConstructorName(rs.getString("constructorName"));// ��Ŀ��������
				permit.setCidCardTypeNum(rs.getString("cidCardTypeNum").trim());// ��Ŀ����֤������(TBIDCARDTYPEDIC)
				permit.setConstructorIdCard(rs.getString("constructorIdCard"));// ��Ŀ����֤������
				permit.setSupervisionName(rs.getString("supervisionName"));// �ܼ�����ʦ����
				permit.setSidCardTypeNum(rs.getString("sidCardTypeNum").trim());// �ܼ�����ʦ֤������(TBIDCARDTYPEDIC)
				permit.setSupervisionIdCard(rs.getString("supervisionIdCard"));// �ܼ�����ʦ����
				permit.setUserName(rs.getString("userName"));// ��ȫ����������Ա����
				permit.setIdCardTypeNum(rs.getString("idCardTypeNum").trim());// ��ȫ��������֤������(TBIDCARDTYPEDIC)
				permit.setIdCard(rs.getString("idCard"));// ��ȫ����������Ա֤����
				permit.setCertId(rs.getString("certId"));// ��ȫ�������˺ϸ�֤����
				permit.setUserType(rs.getString("userType").trim());// ��ȫ����������Ա����(1��Ҫ�����ˡ�2��Ŀ�����ˡ�3��ȫԱ)
				permit.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				permit.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				permit.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				permit.setAppSteffId(rs.getString("appSteffId"));// ������id
				permit.setAppSteffName(rs.getString("appSteffName"));// ����������
				permit.setAppDate(rs.getDate("appDate"));// ����ʱ��
				permit.setAppOpinion(rs.getString("appOpinion"));// �������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}

	@Override
	public Plan queryPlanInfo(String planId) {
		// TODO Auto-generated method stub
		Plan plan = new Plan();
		String sql = "select * from TBPROJECTCENSORINFO where censorId = '"
				+ planId + "'";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				plan.setCensorId(rs.getString("censorId"));// ����
				plan.setCensorNum(rs.getString("censorNum"));// ʩ��ͼ���ϸ�֤����
				plan.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				plan.setPrjName(rs.getString("prjName"));// ��Ŀ����
				plan.setCensorCorpName(rs.getString("censorCorpName"));// ʩ��ͼ����������
				plan.setCensorCorpCode(rs.getString("censorCorpCode"));// ʩ��ͼ��������֯��������
				plan.setCensorEDate(rs.getDate("censorEDate"));// ����������
				plan.setPrjSize(rs.getString("prjSize"));// �����ģ
				plan.setEconCorpName(rs.getString("econCorpName"));// ���쵥λ����
				plan.setEconCorpCode(rs.getString("econCorpCode"));// ���쵥λ��֯��������
				plan.setEconCorpName2(rs.getString("econCorpName2"));// ���쵥λ����2
				plan.setEconCorpCode2(rs.getString("econCorpCode2")); // ���쵥λ��֯��������2
				plan.setEconCorpName3(rs.getString("econCorpName3"));// ���쵥λ����3
				plan.setEconCorpCode3(rs.getString("econCorpCode3")); // ���쵥λ��֯��������3
				plan.setDesignCorpName(rs.getString("designCorpName"));// ��Ƶ�λ����
				plan.setDesignCorpCode(rs.getString("designCorpCode"));// ��Ƶ�λ��֯��������
				plan.setDesignCorpName2(rs.getString("designCorpName2"));// ��Ƶ�λ����2
				plan.setDesignCorpCode2(rs.getString("designCorpCode2"));// ��Ƶ�λ��֯��������2
				plan.setDesignCorpName3(rs.getString("designCorpName3"));// ��Ƶ�λ����3
				plan.setDesignCorpCode3(rs.getString("designCorpCode3"));// ��Ƶ�λ��֯��������3
				plan.setOneCensorIsPass(rs.getString("oneCensorIsPass"));// һ������Ƿ�ͨ��
																			// ͨ��1����ͨ��0
				plan.setOneCensorWfqtCount(rs.getString("oneCensorWfqtCount"));// һ�����ʱΥ��ǿ����
				plan.setOneCensorWfqtContent(rs
						.getString("oneCensorWfqtContent"));// һ�����ʱΥ����ǿ����Ŀ
				plan.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				plan.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				plan.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				plan.setAppSteffId(rs.getString("appSteffId"));// ������id
				plan.setAppSteffName(rs.getString("appSteffName"));// ����������
				plan.setAppDate(rs.getDate("appDate"));// ����ʱ��
				plan.setAppOpinion(rs.getString("appOpinion"));// �������
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return plan;
	}

	@Override
	public Ready queryReadyInfo(String readyId) {
		// TODO Auto-generated method stub
		Ready complete = new Ready();
		try {
			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, readyId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				complete.setCompleteId(rs.getString("completeId"));// ����
				complete.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				complete.setPrjName(rs.getString("prjName"));// ��Ŀ����
				complete.setPrjFinishNum(rs.getString("PRJFINISHNUM"));
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));// ʩ�����֤���
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs
						.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				complete.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				complete.setAppSteffId(rs.getString("appSteffId"));// ������id
				complete.setAppSteffName(rs.getString("appSteffName"));// ����������
				complete.setAppDate(rs.getDate("appDate"));// ����ʱ��
				complete.setAppOpinion(rs.getString("appOpinion"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
	}

	@Override
	public Tender queryTenderInfo(String tenderId) {
		// TODO Auto-generated method stub
		Tender tenderInfo = new Tender();
		try {

			String qsql = "select * from V_TBTENDERINFO where tenderId=?";
			// ��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, tenderId);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				tenderInfo.setTenderId(rs.getString("tenderId"));// ����
				tenderInfo.setTenderNum(rs.getString("tenderNum"));// �б�֪ͨ����
				tenderInfo.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));// �б�����(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));// �б귽ʽ(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));// �б�����
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));// �б���
				tenderInfo.setPrjSize(rs.getString("prjSize"));// �����ģ
				tenderInfo.setArea(rs.getString("area"));// ���(ƽ����)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));// �б����λ����
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));// �б����λ��֯��������
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));// �б굥λ����
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));// �б굥λ��֯��������
				tenderInfo.setConstructorName(rs.getString("constructorName"));// ��Ŀ����/�ܼ�����ʦ����
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));// ��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs
						.getString("constructorIdCard"));// ��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setCreateDate(rs.getDate("createDate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return tenderInfo;
	}

	@Override
	public List<Quality> queryQualityList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_QUALITYSUPERVISION where prjNum = '"
				+ prjNum + "'";
		List<Quality> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Quality quality = new Quality();
				quality.setQualityId(rs.getString("qualityId"));// ����
				quality.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				quality.setPrjName(rs.getString("prjName"));// ��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));// ������id
				quality.setAppSteffName(rs.getString("appSteffName"));// ����������
				quality.setAppDate(rs.getDate("appDate"));// ����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));// �������
				/**
				 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());// ����״̬
				/**
				 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());// ������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
				quality.setPrjId(rs.getString("prjId"));
				quality.setProjectName(rs.getString("projectName"));// ��������
				quality.setConfiguration(rs.getString("configuration"));// �ṹ/����
				quality.setProjectAddress(rs.getString("projectAddress"));// ���̵ص�
				quality.setContact(rs.getString("contact"));// ��ϵ��
				quality.setConstructionArea(rs.getString("constructionArea"));// �������(ƽ����)
				quality.setQuantities(rs.getString("quantities"));// ��װ������(��Ԫ)
				quality.setExpensive(rs.getString("expensive"));// ���������(��Ԫ)
				quality.setSuperviseCost(rs.getString("superviseCost"));// �ල��(Ԫ)
				quality.setStartDate(rs.getDate("startDate"));// �ƻ���������
				quality.setEndDate(rs.getDate("endDate"));// �ƻ���������
				quality.setDevelopmentOrganization(rs
						.getString("developmentOrganization"));// ���赥λ
				quality.setDevelopmentQualificationLevel(rs
						.getString("developmentQualificationLevel"));// ���赥λ���ʵȼ�
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));// ���赥λ��Ŀ������
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));// ���赥λ��ϵ�绰
				quality.setSurveyUnit(rs.getString("surveyUnit"));// ���쵥λ
				quality.setSurveyUnitQualificationLevel(rs
						.getString("surveyUnitQualificationLevel"));// ���쵥λ���ʵȼ�
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));// ���쵥λ��Ŀ������
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));// ���쵥λ��ϵ�绰
				quality.setDesignUnit(rs.getString("designUnit"));// ��Ƶ�λ
				quality.setDesignUnitQualificationLevel(rs
						.getString("designUnitQualificationLevel"));// ��Ƶ�λ���ʵȼ�
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));// ��Ƶ�λ��Ŀ������
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));// ��Ƶ�λ��ϵ�绰
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));// ����λ
				quality.setSupervisionUnitQualLevel(rs
						.getString("supervisionUnitQualLevel"));// ����λ���ʵȼ�
				quality.setSupervisionUnitEngineer(rs
						.getString("supervisionUnitEngineer"));// �ܼ�����ʦ
				quality.setSupervisionUnitPhone(rs
						.getString("supervisionUnitPhone"));// ����λ��ϵ�绰
				quality.setConstructionUnit(rs.getString("constructionUnit"));// ʩ����λ
				quality.setConstructionUnitQualLevel(rs
						.getString("constructionUnitQualLevel"));// ʩ����λ���ʵȼ�
				quality.setConstructionUnitProjectManager(rs
						.getString("constructionUnitProjectManager"));// ʩ����λ��Ŀ����
				quality.setConstructionUnitPhone(rs
						.getString("constructionUnitPhone"));// ʩ����λ��ϵ�绰
				quality.setConstructionPlans(rs.getString("constructionPlans"));// ʩ��ͼ������
				quality.setConstructionPlansType(rs
						.getString("constructionPlansType"));// ʩ��ͼ���������
				quality.setConstructionPlansCharge(rs
						.getString("constructionPlansCharge"));// ʩ��ͼ��������Ŀ������
				quality.setConstructionPlansPhone(rs
						.getString("constructionPlansPhone"));// ʩ��ͼ��������ϵ�绰
				quality.setConstructionContractFileNum(rs
						.getString("constructionContractFileNum"));// ʩ����ͬ�ļ���
				quality.setConstructionOrganFileNum(rs
						.getString("constructionOrganFileNum"));// ʩ����֯����ļ���
				quality.setConstructionPlansFileNum(rs
						.getString("constructionPlansFileNum"));// ʩ��ͼ��鱨�����׼���ļ���
				quality.setSupervisionContractFileNum(rs
						.getString("supervisionContractFileNum"));// �����ͬ�ļ���
				quality.setSupervisionPlanFileNum(rs
						.getString("supervisionPlanFileNum"));// ����滮�ļ���
				quality.setFireControlFileNum(rs
						.getString("FireControlFileNum"));// ����������ϸ�����֤���ļ��ļ���
				quality.setDevelopmentOrganFileNum(rs
						.getString("DevelopmentOrganFileNum"));// ���赥λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setOnstructionUnitFileNum(rs
						.getString("OnstructionUnitFileNum"));// ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setSupervisionUnitFileNum(rs
						.getString("SupervisionUnitFileNum"));// ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setConstructionSiteFileNum(rs
						.getString("ConstructionSiteFileNum"));// ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
				quality.setQualityTestingFileNum(rs
						.getString("QualityTestingFileNum"));// �������Ա��λ֤���ļ���
				quality.setFieldSupervisionFileNum(rs
						.getString("FieldSupervisionFileNum"));// �ֳ�������Աע��ִҵ֤���ļ���
				quality.setQualityNum(rs.getString("qualityNum"));
				quality.setSectionName(rs.getString("sectionName"));
				quality.setTenderNum(rs.getString("tenderNum"));
				list.add(quality);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Quality queryQualityInfo(String qualityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Safety> querySafetyList(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select * from TB_SAFETYSUPERVISION where prjNum = '"
				+ prjNum + "'";
		List<Safety> list = new ArrayList<>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Safety quality = new Safety();
				quality.setSafetyId(rs.getString("SAFETYID"));// ����
				quality.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				quality.setPrjName(rs.getString("prjName"));// ��Ŀ����
				quality.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�����
				quality.setApplyCorpCode(rs.getString("applyCorpCode"));// ������ҵ��֯��������
				quality.setApplyCorpName(rs.getString("applyCorpName"));// ������ҵ����
				quality.setAppSteffId(rs.getString("appSteffId"));// ������id
				quality.setAppSteffName(rs.getString("appSteffName"));// ����������
				quality.setAppDate(rs.getDate("appDate"));// ����ʱ��
				quality.setAppOpinion(rs.getString("appOpinion"));// �������
				/**
				 * ����״̬ ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				quality.setAppType(rs.getString("appType").trim());// ����״̬
				/**
				 * ���̲��� 1:��Ŀ���� 2:����׶Ρ���ƽ׶� 3:��ͬ������ʩ��ͼ��鱸�� 4:�����ල����ȫ�ල 5:ʩ�����
				 * 6:��������
				 */
				quality.setProcessSteps(rs.getString("processSteps").trim());
				quality.setAppDept(rs.getString("appDept").trim());// ������λid
				quality.setAppDeptName(rs.getString("appDeptName").trim());// ������λ����
				quality.setPrjId(rs.getString("prjId"));
				// quality.setOversightNum(rs.getString("oversightNum"));//��ȫ�ල�ǼǱ��
				quality.setProjectName(rs.getString("projectName"));// ��������
				quality.setProjectAddress(rs.getString("projectAddress"));// ���̵ص�
				quality.setProStartDate(rs.getDate("proStartDate"));// ��ͬ��������
				quality.setProEndDate(rs.getDate("proEndDate"));// ��ͬ��������
				quality.setProjectType(rs.getString("projectType"));// ��������
				quality.setSafetyTarget(rs.getString("safetyTarget"));// ��ȫ������׼������Ŀ��
				if (rs.getString("newlyBuild") != null) {
					quality.setNewlyBuild(rs.getString("newlyBuild").trim());// �½�
				} else {
					quality.setNewlyBuild(rs.getString("newlyBuild"));// �½�
				}
				if (rs.getString("extend") != null) {
					quality.setExtend(rs.getString("extend").trim());// ������
				} else {
					quality.setExtend(rs.getString("extend"));// ������
				}
				if (rs.getString("other") != null) {
					quality.setOther(rs.getString("other").trim());// ����
				} else {
					quality.setOther(rs.getString("other"));// ����
				}
				quality.setPolicingName(rs.getString("policingName"));// ���쵥λȫ��
				quality.setPolicingStaff(rs.getString("policingStaff"));// ���쵥λ��Ŀ������
				quality.setDesignName(rs.getString("designName"));// ��Ƶ�λȫ��
				quality.setDesignStaff(rs.getString("designStaff"));// ��Ƶ�λ��Ŀ������
				quality.setBuildingName(rs.getString("buildingName"));// ���赥λȫ��
				quality.setBuildingStaff(rs.getString("buildingStaff"));// ���赥λ��Ŀ������
				quality.setBuildingPhone(rs.getString("buildingPhone"));// ���赥λ��ϵ�绰
				quality.setSupervisionName(rs.getString("supervisionName"));// ����λȫ��
				quality.setSupervisionStaff(rs.getString("supervisionStaff"));// ����λ��Ŀ�ܼ�����
				quality.setSupervisionNum(rs.getString("supervisionNum"));// ����λ��Ŀ�ܼ�ע��֤���
				quality.setSupervisionPhone(rs.getString("supervisionPhone"));// ����λ��Ŀ�ܼ���ϵ�绰
				quality.setProbationStaff(rs.getString("probationStaff"));// ����λ��ȫ�ල����
				quality.setProbationPhone(rs.getString("probationPhone"));// ����λ��ȫ�ල��ϵ�绰
				quality.setProbationNum(rs.getString("probationNum"));// ����λ��ȫ�ලע��֤���
				quality.setProbationSafeNum(rs.getString("probationSafeNum"));// ����λ��ȫ�ල��ȫ����֤��
				quality.setContractName(rs.getString("contractName"));// ʩ���ܳа���λȫ��
				quality.setContractAdmin(rs.getString("contractAdmin"));// ʩ���ܳа���λ��˾��ȫ����
				quality.setContractPhone(rs.getString("contractPhone"));// ʩ���ܳа���λ��ϵ�绰
				quality.setContractStaff(rs.getString("contractStaff"));// ʩ���ܳа���λ������
				quality.setContractSafeNum(rs.getString("contractSafeNum"));// ʩ���ܳа���λ��ȫ����֤��
				quality.setContractProStaff(rs.getString("contractProStaff"));// ʩ���ܳа���λ��Ŀ����������
				quality.setContractProStaffPhone(rs
						.getString("contractProStaffPhone"));// ʩ���ܳа���λ��Ŀ��������ϵ�绰
				quality.setContractStaffRegNum(rs
						.getString("contractStaffRegNum"));// ʩ���ܳа���λ��Ŀ������ע��֤��
				quality.setContractStaffNum(rs.getString("contractStaffNum"));// ʩ���ܳа���λ��Ŀ�����˰�ȫ����֤��
				// quality.setSingleNum(rs.getString("singleNum"));//��λ���̱��
				quality.setUnitProject(rs.getString("unitProject"));// ��λ����
				quality.setScale(rs.getString("scale"));// ������ģ
				quality.setCost(rs.getString("cost"));// �������
				quality.setStructure(rs.getString("structure"));// �ṹ/���
				quality.setHeight(rs.getString("height"));// �����߶�
				quality.setSafetyNum(rs.getString("safetyNum"));
				list.add(quality);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}

	@Override
	public Safety querySafetyInfo(String safetyId) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��Ͷ����ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public TenderInfo queryTenderById(String tenderNum)
	{
		TenderInfo tenderInfo = new TenderInfo();
		try {
			
			String qsql = "select * from V_TBTENDERINFO where tenderNum=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, tenderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				tenderInfo.setTenderNum(rs.getString("tenderNum"));//�б�֪ͨ����
				tenderInfo.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));//�б�����(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));//�б귽ʽ(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));//�б�����
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));//�б���
				tenderInfo.setPrjSize(rs.getString("prjSize"));//�����ģ
				tenderInfo.setArea(rs.getString("area"));//���(ƽ����)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));//�б����λ����
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));//�б����λ��֯��������
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));//�б굥λ����
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));//�б굥λ��֯��������
				tenderInfo.setConstructorName(rs.getString("constructorName"));//��Ŀ����/�ܼ�����ʦ����
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));//��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs.getString("constructorIdCard"));//��Ŀ����/�ܼ�����ʦ֤������
				tenderInfo.setCreateDate(rs.getDate("createDate"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return tenderInfo;
	}
	
	/**
	 *��ͬ������ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public ContractFiling queryFilingById(String recordId)
	{
		ContractFiling contractFiling = new ContractFiling();
		try {
			
			String qsql = "select * from v_tbcontractrecordmanage where recordId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, recordId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				contractFiling.setRecordId(rs.getString("recordId"));//����
				contractFiling.setRecordNum(rs.getString("recordNum"));//��ͬ�������
				contractFiling.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				contractFiling.setPrjName(rs.getString("prjName"));//��Ŀ����
				contractFiling.setContractNum(rs.getString("contractNum"));//��ͬ���
				contractFiling.setContractTypeNum(rs.getString("contractTypeNum"));//��ͬ���(TBCONTRACTTYPEDIC)
				contractFiling.setContractTypeName(rs.getString("contractTypeName"));//��ͬ�������
				contractFiling.setContractMoney(rs.getString("contractMoney"));//��ͬ���(��Ԫ)
				contractFiling.setPrjSize(rs.getString("prjSize"));//�����ģ
				contractFiling.setContractDate(rs.getDate("contractDate"));//��ͬǩ������
				contractFiling.setPropietorCorpName(rs.getString("propietorCorpName"));//������λ����
				contractFiling.setPropietorCorpCode(rs.getString("propietorCorpCode"));//������λס��֯����
				contractFiling.setContractorCorpName(rs.getString("contractorCorpName"));//�а���λ����
				contractFiling.setContractorCorpCode(rs.getString("contractorCorpCode"));//�а���λ��֯����
				contractFiling.setUnionCorpName(rs.getString("unionCorpName"));//������а���λ����
				contractFiling.setUnionCorpCode(rs.getString("unionCorpCode"));//������а���λ��֯����
				contractFiling.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				contractFiling.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				contractFiling.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				contractFiling.setAppSteffId(rs.getString("appSteffId"));//������id
				contractFiling.setAppSteffName(rs.getString("appSteffName"));//����������
				contractFiling.setAppDate(rs.getDate("appDate"));//����ʱ��
				contractFiling.setAppOpinion(rs.getString("appOpinion"));//�������
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				contractFiling.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				contractFiling.setProcessSteps(rs.getString("processSteps").trim());
				contractFiling.setAppDept(rs.getString("appDept").trim());//������λid
				contractFiling.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				contractFiling.setSectionName(rs.getString("sectionName"));
				contractFiling.setTenderNum(rs.getString("tenderNum"));
				contractFiling.setProjectAddress(rs.getString("projectAddress"));
				contractFiling.setProjectCost(rs.getString("projectCost"));
				contractFiling.setArea(rs.getString("area"));
				contractFiling.setConstructorName(rs.getString("constructorName"));//��Ŀ��������
				contractFiling.setTitleLeve(rs.getString("titleLeve"));//���ʵȼ�
				contractFiling.setPhone(rs.getString("phone"));//��ϵ�绰
				contractFiling.setQualificationsType(rs.getString("qualificationsType"));
				contractFiling.setQualificationsTypeName(rs.getString("qualificationsTypeName"));
				contractFiling.setSpecialtyType(rs.getString("specialtyType"));
				contractFiling.setSpecialtyTypeName(rs.getString("specialtyTypeName"));
				contractFiling.setRating(rs.getString("rating"));
				contractFiling.setRatingName(rs.getString("ratingName"));
				contractFiling.setContrType(rs.getString("contrType"));
				
				//-------------------------------��Ա-----------------------------------	
				contractFiling.setTechnicalName(rs.getString("technicalName"));//��������������
				contractFiling.setTechnicalIdCardTypeNum(rs.getString("technicalIdCardTypeNum"));//����������֤������
				contractFiling.setTechnicalIdCard(rs.getString("technicalIdCard"));//����������֤������
				contractFiling.setTechnicalCertNum(rs.getString("technicalCertNum"));//����������֤���
				contractFiling.setQualityName(rs.getString("qualityName"));//�������Ա����
				contractFiling.setQualityIdCardTypeNum(rs.getString("qualityIdCardTypeNum"));//�������Ա֤������
				contractFiling.setQualityIdCard(rs.getString("qualityIdCard"));//�������Ա֤������
				contractFiling.setQualityCertNum(rs.getString("qualityCertNum"));//�������Ա֤���
				contractFiling.setSecurityName(rs.getString("securityName"));//��ȫԱ����
				contractFiling.setSecurityIdCardTypeNum(rs.getString("securityIdCardTypeNum"));//��ȫԱ֤������
				contractFiling.setSecurityIdCard(rs.getString("securityIdCard"));//��ȫԱ֤������
				contractFiling.setSecurityCertNum(rs.getString("securityCertNum"));//��ȫԱ֤���
				contractFiling.setConstructionName(rs.getString("constructionName"));//ʩ��Ա������������
				contractFiling.setConstructionIdCardTypeNum(rs.getString("constructionIdCardTypeNum"));//ʩ��Ա��������֤������
				contractFiling.setConstructionIdCard(rs.getString("constructionIdCard"));//ʩ��Ա��������֤������
				contractFiling.setConstructionCertNum(rs.getString("constructionCertNum"));//ʩ��Ա��������֤���
				contractFiling.setDirectorName(rs.getString("directorName"));//��������Ա���ܼ�����
				contractFiling.setDirectorIdCardTypeNum(rs.getString("directorIdCardTypeNum"));//��������Ա���ܼ�֤������
				contractFiling.setDirectorIdCard(rs.getString("directorIdCard"));//��������Ա���ܼ�֤������
				contractFiling.setDirectorCertNum(rs.getString("directorCertNum"));//��������Ա���ܼ�֤���
				contractFiling.setRepresEntativeName(rs.getString("represEntativeName"));//�ܼ��������
				contractFiling.setRepresEntativeIdCardTypeNum(rs.getString("represEntativeIdCardTypeNum"));//�ܼ����֤������
				contractFiling.setRepresEntativeIdCard(rs.getString("represEntativeIdCard"));//�ܼ����֤������
				contractFiling.setRepresEntativeCertNum(rs.getString("represEntativeCertNum"));//�ܼ����֤���
				contractFiling.setSafetyName(rs.getString("safetyName"));//��ȫ��������
				contractFiling.setSafetyIdCardTypeNum(rs.getString("safetyIdCardTypeNum"));//��ȫ����֤������
				contractFiling.setSafetyIdCard(rs.getString("safetyIdCard"));//��ȫ����֤������
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return contractFiling;
	}
	
	/**
	 *������ϸ
	 * 
	 * @param tenderId
	 * @return
	 */
	public Quality queryQualityById(String qualityId)
	{
		Quality quality = new Quality();
		try {
			
			String qsql = "select * from TB_QUALITYSUPERVISION where qualityId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, qualityId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				quality.setQualityId(rs.getString("qualityId"));//����
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
				quality.setConfiguration(rs.getString("configuration"));//�ṹ/����
				quality.setProjectAddress(rs.getString("projectAddress"));//���̵ص�
				quality.setContact(rs.getString("contact"));//��ϵ��
				quality.setConstructionArea(rs.getString("constructionArea"));//�������(ƽ����)
				quality.setQuantities(rs.getString("quantities"));//��װ������(��Ԫ)
				quality.setExpensive(rs.getString("expensive"));//���������(��Ԫ)
				quality.setSuperviseCost(rs.getString("superviseCost"));//�ල��(Ԫ)
				quality.setStartDate(rs.getDate("startDate"));//�ƻ���������
				quality.setEndDate(rs.getDate("endDate"));//�ƻ���������
				quality.setDevelopmentOrganization(rs.getString("developmentOrganization"));//���赥λ
				quality.setDevelopmentQualificationLevel(rs.getString("developmentQualificationLevel"));//���赥λ���ʵȼ�
				quality.setDevelopmentCharge(rs.getString("developmentCharge"));//���赥λ��Ŀ������
				quality.setDevelopmentPhone(rs.getString("developmentPhone"));//���赥λ��ϵ�绰
				quality.setSurveyUnit(rs.getString("surveyUnit"));//���쵥λ
				quality.setSurveyUnitQualificationLevel(rs.getString("surveyUnitQualificationLevel"));//���쵥λ���ʵȼ�
				quality.setSurveyUnitCharge(rs.getString("surveyUnitCharge"));//���쵥λ��Ŀ������
				quality.setSurveyUnitPhone(rs.getString("surveyUnitPhone"));//���쵥λ��ϵ�绰
				quality.setDesignUnit(rs.getString("designUnit"));//��Ƶ�λ
				quality.setDesignUnitQualificationLevel(rs.getString("designUnitQualificationLevel"));//��Ƶ�λ���ʵȼ�
				quality.setDesignUnitCharge(rs.getString("designUnitCharge"));//��Ƶ�λ��Ŀ������
				quality.setDesignUnitPhone(rs.getString("designUnitPhone"));//��Ƶ�λ��ϵ�绰
				quality.setSupervisionUnit(rs.getString("supervisionUnit"));//����λ
				quality.setSupervisionUnitQualLevel(rs.getString("supervisionUnitQualLevel"));//����λ���ʵȼ�
				quality.setSupervisionUnitEngineer(rs.getString("supervisionUnitEngineer"));//�ܼ�����ʦ
				quality.setSupervisionUnitPhone(rs.getString("supervisionUnitPhone"));//����λ��ϵ�绰
				quality.setConstructionUnit(rs.getString("constructionUnit"));//ʩ����λ
				quality.setConstructionUnitQualLevel(rs.getString("constructionUnitQualLevel"));//ʩ����λ���ʵȼ�
				quality.setConstructionUnitProjectManager(rs.getString("constructionUnitProjectManager"));//ʩ����λ��Ŀ����
				quality.setConstructionUnitPhone(rs.getString("constructionUnitPhone"));//ʩ����λ��ϵ�绰
				quality.setConstructionPlans(rs.getString("constructionPlans"));//ʩ��ͼ������
				quality.setConstructionPlansType(rs.getString("constructionPlansType"));//ʩ��ͼ���������
				quality.setConstructionPlansCharge(rs.getString("constructionPlansCharge"));//ʩ��ͼ��������Ŀ������
				quality.setConstructionPlansPhone(rs.getString("constructionPlansPhone"));//ʩ��ͼ��������ϵ�绰
				quality.setConstructionContractFileNum(rs.getString("constructionContractFileNum"));//ʩ����ͬ�ļ���
				quality.setConstructionOrganFileNum(rs.getString("constructionOrganFileNum"));//ʩ����֯����ļ���
				quality.setConstructionPlansFileNum(rs.getString("constructionPlansFileNum"));//ʩ��ͼ��鱨�����׼���ļ���
				quality.setSupervisionContractFileNum(rs.getString("supervisionContractFileNum"));//�����ͬ�ļ���
				quality.setSupervisionPlanFileNum(rs.getString("supervisionPlanFileNum"));//����滮�ļ���
				quality.setFireControlFileNum(rs.getString("FireControlFileNum"));//����������ϸ�����֤���ļ��ļ���
				quality.setDevelopmentOrganFileNum(rs.getString("DevelopmentOrganFileNum"));//���赥λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setOnstructionUnitFileNum(rs.getString("OnstructionUnitFileNum"));//ʩ����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setSupervisionUnitFileNum(rs.getString("SupervisionUnitFileNum"));//����λ��Ŀ�����˼���Ŀ��������ļ���
				quality.setConstructionSiteFileNum(rs.getString("ConstructionSiteFileNum"));//ʩ���ֳ���Ŀ�����ˡ�������Ա�ʸ�֤���ļ���
				quality.setQualityTestingFileNum(rs.getString("QualityTestingFileNum"));//�������Ա��λ֤���ļ���
				quality.setFieldSupervisionFileNum(rs.getString("FieldSupervisionFileNum"));//�ֳ�������Աע��ִҵ֤���ļ���
				quality.setQualityNum(rs.getString("qualityNum"));
				quality.setSectionName(rs.getString("sectionName"));
				quality.setTenderNum(rs.getString("tenderNum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return quality;
	}
	
	/**
	 * ��ѯ��ȫ��ϸҳ��
	 * @return
	 */
	public Safety querySafetyById(String safetyId)
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
	 * ��ѯʩ�������ϸҳ��
	 * @return
	 */
	public Permit queryPermitById(String permitId)
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
				permit.setProjectName(rs.getString("projectName"));//��������
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
				permit.setTenderNum(rs.getString("tenderNum"));
				permit.setSectionName(rs.getString("sectionName"));
				permit.setQualityNum(rs.getString("qualityNum"));
				permit.setSafetyNum(rs.getString("safetyNum"));
				permit.setStarDate(rs.getDate("starDate"));
				permit.setEndDate(rs.getDate("endDate"));
				permit.setTimeLimit(rs.getString("timeLimit"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return permit;
	}
	
	/**
	 * ��ѯ����������ϸҳ��
	 * @return
	 */
	public Complete queryCompleteById(String completeId)
	{
		Complete complete = new Complete();
		try {
			
			String qsql = "select * from TBPROJECTFINISHMANAGE where completeId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, completeId);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				complete.setCompleteId(rs.getString("completeId"));//����
				complete.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				complete.setPrjId(rs.getString("prjId"));
				complete.setPrjName(rs.getString("prjName"));//��Ŀ����
				complete.setBuilderLicenceNum(rs.getString("builderLicenceNum"));//ʩ�����֤���
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setQcCorpName(rs.getString("qcCorpName"));
				complete.setQcCorpCode(rs.getString("qcCorpCode"));
				complete.setFactCost(rs.getString("factCost"));
				complete.setFactArea(rs.getString("factArea"));
				complete.setFactSize(rs.getString("factSize"));
				complete.setPrjStructureTypeNum(rs.getString("prjStructureTypeNum"));
				complete.setBDate(rs.getDate("bDate"));
				complete.setEDate(rs.getDate("eDate"));
				complete.setMark(rs.getString("mark"));
				complete.setApplyCorpCode(rs.getString("applyCorpCode"));//������ҵ��֯��������
				complete.setApplyCorpName(rs.getString("applyCorpName"));//������ҵ����
				complete.setAppDept(rs.getString("appDept").trim());//������λid
				complete.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				complete.setProjectName(rs.getString("projectName"));//��������
				complete.setPrjFinishNum(rs.getString("prjFinishNum"));
				complete.setTenderNum(rs.getString("tenderNum"));
				complete.setSectionName(rs.getString("sectionName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return complete;
	}

	
	/**
	 * ��ѯ��������
	 */
	@Override
	public List<DictionaryClass> queryProjectTypes() {
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
