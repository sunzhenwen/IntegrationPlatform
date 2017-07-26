package com.tj.jst.inner.projectconstruction.dao;

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
import com.tj.jst.inner.projectconstruction.model.Author;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.inner.projectconstruction.model.SingleSerialnum;
import com.tj.jst.outside.business.upload.model.Upload;

public class ProjectConstructionDaoImpl extends BaseDao implements
		IProjectConstructionDao {

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
					ProjectConstruction project = new ProjectConstruction();
					project.setPrjId(rs.getString("prjId"));// ����
					project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					project.setPrjName(rs.getString("prjName"));// ��Ŀ����
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
					project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
					project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
					project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
					project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
					project.setPrjApprovalLevelNum(rs// �����
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
					project.setAllArea(rs.getString("allArea"));// �����
					project.setPrjSize(rs.getString("prjSize"));// �����ģ
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// ������;
					project.setBeginDate(rs.getDate("bDate"));// ��ʼʱ��
					project.setEndDate(rs.getDate("eDate"));// ����ʱ��
					project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					project.setAppType(rs.getString("appType"));
					project.setProcessSteps(rs.getString("processSteps"));
					project.setProjectManager(rs.getString("projectManager"));// ���赥λ��Ŀ������
					project.setUnitPhone(rs.getString("unitPhone"));// ���赥λ��ϵ�绰
					page.getData().add(project);
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
	 * ��ѯ����
	 */
	@Override
	public ProjectConstruction queryApproval(String prjId) {
		// TODO Auto-generated method stub
		ProjectConstruction project = new ProjectConstruction();
		
		try {
			String sql = "select t.*, "
					+ "(select a.PROCLASSIFICATION from TBPRJTYPEDIC a where t.prjTypeNum=a.code) as prjTypeName,"
					+ "(select b.name from TBXZQDMDIC b where t.provinceNum=b.code) as provinceName,"
					+ "(select c.name from TBXZQDMDIC c where t.cityNum=c.code) as cityName,"
					+ "(select d.name from TBXZQDMDIC d where t.countyNum=d.code) as countyName,"
					+ "(select e.PROLEVEL from TBLXJBDIC e where t.prjApprovalLevelNum=e.code) as prjApprovalLevelName,"
					+ "(select f.NATURE from TBPRJPROPERTYDIC f where t.prjPropertyNum=f.code) as prjPropertyName,"
					+ "(select g.ENGINEERUSE from TBPRJFUNCTIONDIC g where t.prjFunctionNum=g.code) as prjFunctionName"
					+ " from  TBPROJECTINFO_S t where t.prjId='" + prjId + "'";
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				project.setAppDeptName(rs.getString("appDeptName"));
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
				project.setAppType(rs.getString("appType"));
				project.setProcessSteps(rs.getString("processSteps"));
				project.setAddress(rs.getString("address"));
				project.setProjectManager(rs.getString("projectManager"));// ���赥λ��Ŀ������
				project.setUnitPhone(rs.getString("unitPhone"));// ���赥λ��ϵ�绰
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		
		return project;
	}

	/**
	 * ����ͨ��
	 */
	@Override
	public String applySuccess(ProjectConstruction project) {
		// TODO Auto-generated method stub
		String message = "";

		// Calendar c = Calendar.getInstance();
		// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMdd");
		// String fDate = simpleDateFormat.format(c.getTime());
		// String serNum = PrjNum.querySerNuma(project.getCreateDate());
		// String prjNum = project.getAppDept() + fDate +
		// project.getPrjTypeNum()
		// + serNum;
		// System.out.println("appdept = " + project.getAppDept());
		// System.out.println(prjNum);

		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  TBPROJECTINFO_S set OPINION=?,APPTYPE=1,PROCESSSTEPS=3 where PRJID=?");
			pstmt.setString(1, project.getOpinion());
			pstmt.setString(2, project.getPrjId());
			pstmt.executeUpdate();
			conn.commit();
			message = "�ɹ�";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		String sql = "insert into SINGLE_SERIALNUM (PRJNUM,SERIALNUM) values(?,?)";
		SingleSerialnum singleSerialnum = new SingleSerialnum();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project.getPrjNum());
			pstmt.setInt(2, 1);
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt,null);
		}
		
		return message;
	}

	/**
	 * ����δͨ��
	 */
	@Override
	public String applyFaile(ProjectConstruction project) {
		// TODO Auto-generated method stub
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn
					.prepareStatement("update  TBPROJECTINFO_S set OPINION=?,APPTYPE=2"
							+ "where PRJID=?");
			pstmt.setString(1, project.getOpinion());
			pstmt.setString(2, project.getPrjId());
			pstmt.executeUpdate();
			conn.commit();
			message = "�ɹ�";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}

	/**
	 * ��������
	 */
	@Override
	public List<ProjectConstruction> batchApplythrough(String[] ids) {
		// TODO Auto-generated method stub
		List<ProjectConstruction> list = new ArrayList<ProjectConstruction>();
		try {
			for (int i = 0; i < ids.length; i++) {
				String sql = "select * from TBProjectInfo_S where prjId='"
						+ ids[i] + "'";
				conn = ConnectionFactory.getBasicConnection();
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					ProjectConstruction project = new ProjectConstruction();
					project.setPrjId(rs.getString("prjId"));// ����
					project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					project.setPrjName(rs.getString("prjName"));// ��Ŀ����
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
					project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
					project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
					project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
					project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
					project.setPrjApprovalLevelNum(rs// �����
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
					project.setAllArea(rs.getString("allArea"));// �����
					project.setPrjSize(rs.getString("prjSize"));// �����ģ
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// ������;
					project.setBeginDate(rs.getDate("bDate"));// ��ʼʱ��
					project.setEndDate(rs.getDate("eDate"));// ����ʱ��
					project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					list.add(project);
				}
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
	 * ������Ŀ��Ų�����Ŀ
	 */
	@Override
	public ProjectConstruction getProjectInfo(String prjNum) {
		// TODO Auto-generated method stub
		String sql = "select t.*, "
				+ "(select a.PROCLASSIFICATION from TBPRJTYPEDIC a where t.prjTypeNum=a.code) as prjTypeName,"
				+ "(select b.name from TBXZQDMDIC b where t.provinceNum=b.code) as provinceName,"
				+ "(select c.name from TBXZQDMDIC c where t.cityNum=c.code) as cityName,"
				+ "(select d.name from TBXZQDMDIC d where t.countyNum=d.code) as countyName,"
				+ "(select e.PROLEVEL from TBLXJBDIC e where t.prjApprovalLevelNum=e.code) as prjApprovalLevelName,"
				+ "(select f.NATURE from TBPRJPROPERTYDIC f where t.prjPropertyNum=f.code) as prjPropertyName,"
				+ "(select g.ENGINEERUSE from TBPRJFUNCTIONDIC g where t.prjFunctionNum=g.code) as prjFunctionName"
				+ " from TBProjectInfo_S t where t.PRJNUM = '" + prjNum + "'";
		ProjectConstruction project = new ProjectConstruction();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				project.setAppDeptName(rs.getString("appDeptName"));
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
				project.setAddress(rs.getString("address"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return project;
	}

	// /**
	// * ��������
	// */
	// @Override
	// public Page projectPage(Condition condition) {
	// // TODO Auto-generated method stub
	// Page page = super.basePagedQuery(condition);
	// ResultSet rs = page.getRs();
	// try {
	// if (rs != null) {
	// while (rs.next()) {
	// ProjectPage project = new ProjectPage();
	// project.setPrjId(rs.getString("prjId"));// ����
	// project.setPrjName(rs.getString("prjName"));// ��Ŀ����
	// project.setPliesNum(rs.getString("PLIESNUM"));// ����
	// project.setPrjSize(rs.getString("PRJSIZE"));// ������ģ
	// project.setPrjNvest(rs.getString("PRJINVEST"));// Ͷ��
	// project.setPrjBuild(rs.getString("PRJINVEST"));// �ṹ
	// page.getData().add(project);
	// }
	// }
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } finally {
	// ConnectionFactory.closeConn(page.getConn(), page.getPstmt(),
	// page.getRs());
	// }
	// return page;
	// }

	/**
	 * ������ʷ��ѯ
	 */
	@Override
	public Page historyPagedQuery(Condition condition) {
		// TODO Auto-generated method stub
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if (rs != null) {
				while (rs.next()) {
					ProjectConstruction project = new ProjectConstruction();
					project.setPrjId(rs.getString("prjId"));// ����
					project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					project.setPrjName(rs.getString("prjName"));// ��Ŀ����
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
					project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
					project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
					project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
					project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
					project.setPrjApprovalLevelNum(rs// �����
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
					project.setAllArea(rs.getString("allArea"));// �����
					project.setPrjSize(rs.getString("prjSize"));// �����ģ
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// ������;
					project.setBeginDate(rs.getDate("bDate"));// ��ʼʱ��
					project.setEndDate(rs.getDate("eDate"));// ����ʱ��
					project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					project.setAppType(rs.getString("appType"));
					project.setProcessSteps(rs.getString("processSteps"));
					page.getData().add(project);
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
	 * �鿴�Ƿ����ϴ�����Ϣ
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='��Ŀ����' and ID = '"
				+ prjId + "'";
		List<Upload> list = new ArrayList<Upload>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Upload upload = new Upload();
				upload.setUploadId(rs.getString("uploadId"));
				upload.setFileFileName(rs.getString("fileFileName"));
				upload.setIsUnits(rs.getString("isUnits"));
				upload.setLinkName(rs.getString("linkName"));
				upload.setNewName(rs.getString("newName"));
				upload.setRoot(rs.getString("root"));
				upload.setId(rs.getString("id"));
				list.add(upload);
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
	 * �ϴ�����Ȩ��
	 */
	@Override
	public String updateAuthor(ProjectConstruction project) {
		// TODO Auto-generated method stub
		String sql = "insert into TO_AUTHORIZATION(ID,PRJID,PRJNUM,PRJNAME,APPDEPT,APPDEPTNAME,CORPNAME,CORPCODE,AUCORPNAME,AUCORPCODE,CREATEDATE,ENTERPRISETYPE) values(?,?,?,?,?,?,?,?,?,?,?,?) ";
		Author au = new Author();
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, UUID.randomUUID().toString());
			pstmt.setString(2, project.getPrjId());
			pstmt.setString(3, project.getPrjNum());
			pstmt.setString(4, project.getPrjName());
			pstmt.setString(5, project.getAppDept());
			pstmt.setString(6, project.getAppDeptName());
			pstmt.setString(7, project.getBuildCorpName());
			pstmt.setString(8, project.getBuildCorpCode());
			pstmt.setString(9, project.getBuildCorpName());
			pstmt.setString(10, project.getBuildCorpCode());
			pstmt.setDate(11, new Date(new java.util.Date().getTime()));
			pstmt.setString(12, "1");
			pstmt.executeUpdate();
			conn.commit();
			message = "�ɹ�";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
}
