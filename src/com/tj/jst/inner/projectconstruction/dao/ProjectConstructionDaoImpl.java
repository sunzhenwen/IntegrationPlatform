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
	 * 分页查询
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
					project.setPrjId(rs.getString("prjId"));// 主键
					project.setPrjNum(rs.getString("prjNum"));// 项目编号
					project.setPrjName(rs.getString("prjName"));// 项目名称
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
					project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
					project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
					project.setCityNum(rs.getString("cityNum"));// 项目所在市
					project.setCountyNum(rs.getString("countyNum"));// 项目所在区
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
					project.setPrjApprovalLevelNum(rs// 立项级别
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
					project.setAllInvest(rs.getString("allInvest"));// 总投资
					project.setAllArea(rs.getString("allArea"));// 总面积
					project.setPrjSize(rs.getString("prjSize"));// 建设规模
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// 工程用途
					project.setBeginDate(rs.getDate("bDate"));// 开始时间
					project.setEndDate(rs.getDate("eDate"));// 结束时间
					project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
					project.setAppType(rs.getString("appType"));
					project.setProcessSteps(rs.getString("processSteps"));
					project.setProjectManager(rs.getString("projectManager"));// 建设单位项目负责人
					project.setUnitPhone(rs.getString("unitPhone"));// 建设单位联系电话
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
	 * 查询审批
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
				project.setPrjId(rs.getString("prjId"));// 主键
				project.setPrjNum(rs.getString("prjNum"));// 项目编号
				project.setPrjName(rs.getString("prjName"));// 项目名称
				project.setPrjTypeName(rs.getString("prjTypeName"));// 项目分类
				project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
				project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
				project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
				project.setProvinceName(rs.getString("provinceName"));// 项目所在省
				project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
				project.setCityName(rs.getString("cityName"));// 项目所在市
				project.setCityNum(rs.getString("cityNum"));// 项目所在市
				project.setCountyName(rs.getString("countyName"));// 项目所在区
				project.setCountyNum(rs.getString("countyNum"));// 项目所在区
				project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
				project.setPrjApprovalLevelName(rs// 立项级别
						.getString("prjApprovalLevelName"));
				project.setPrjApprovalLevelNum(rs// 立项级别
						.getString("prjApprovalLevelNum"));
				project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
				project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
				project.setAllInvest(rs.getString("allInvest"));// 总投资
				project.setAllArea(rs.getString("allArea"));// 总面积
				project.setPrjSize(rs.getString("prjSize"));// 建设规模
				project.setPrjPropertyName(rs.getString("prjPropertyName"));// 建设性质
				project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
				project.setPrjFunctionName(rs.getString("prjFunctionName"));// 工程用途
				project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// 工程用途
				project.setBeginDate(rs.getDate("bDate"));// 开始时间
				project.setEndDate(rs.getDate("eDate"));// 结束时间
				project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
				project.setAppDept(rs.getString("appDept"));// 获取计算PrjNum的值
				project.setAppType(rs.getString("appType"));
				project.setProcessSteps(rs.getString("processSteps"));
				project.setAddress(rs.getString("address"));
				project.setProjectManager(rs.getString("projectManager"));// 建设单位项目负责人
				project.setUnitPhone(rs.getString("unitPhone"));// 建设单位联系电话
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
	 * 审批通过
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
			message = "成功";
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
	 * 审批未通过
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
			message = "成功";
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
	 * 批量审批
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
					project.setPrjId(rs.getString("prjId"));// 主键
					project.setPrjNum(rs.getString("prjNum"));// 项目编号
					project.setPrjName(rs.getString("prjName"));// 项目名称
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
					project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
					project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
					project.setCityNum(rs.getString("cityNum"));// 项目所在市
					project.setCountyNum(rs.getString("countyNum"));// 项目所在区
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
					project.setPrjApprovalLevelNum(rs// 立项级别
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
					project.setAllInvest(rs.getString("allInvest"));// 总投资
					project.setAllArea(rs.getString("allArea"));// 总面积
					project.setPrjSize(rs.getString("prjSize"));// 建设规模
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// 工程用途
					project.setBeginDate(rs.getDate("bDate"));// 开始时间
					project.setEndDate(rs.getDate("eDate"));// 结束时间
					project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
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
	 * 根据项目编号查找项目
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
				project.setPrjId(rs.getString("prjId"));// 主键
				project.setPrjNum(rs.getString("prjNum"));// 项目编号
				project.setPrjName(rs.getString("prjName"));// 项目名称
				project.setPrjTypeName(rs.getString("prjTypeName"));// 项目分类
				project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
				project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
				project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
				project.setProvinceName(rs.getString("provinceName"));// 项目所在省
				project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
				project.setCityName(rs.getString("cityName"));// 项目所在市
				project.setCityNum(rs.getString("cityNum"));// 项目所在市
				project.setCountyName(rs.getString("countyName"));// 项目所在区
				project.setCountyNum(rs.getString("countyNum"));// 项目所在区
				project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
				project.setPrjApprovalLevelName(rs// 立项级别
						.getString("prjApprovalLevelName"));
				project.setPrjApprovalLevelNum(rs// 立项级别
						.getString("prjApprovalLevelNum"));
				project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
				project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
				project.setAllInvest(rs.getString("allInvest"));// 总投资
				project.setAllArea(rs.getString("allArea"));// 总面积
				project.setPrjSize(rs.getString("prjSize"));// 建设规模
				project.setPrjPropertyName(rs.getString("prjPropertyName"));// 建设性质
				project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
				project.setPrjFunctionName(rs.getString("prjFunctionName"));// 工程用途
				project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// 工程用途
				project.setBeginDate(rs.getDate("bDate"));// 开始时间
				project.setEndDate(rs.getDate("eDate"));// 结束时间
				project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
				project.setAppDept(rs.getString("appDept"));// 获取计算PrjNum的值
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
	// * 审批分项
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
	// project.setPrjId(rs.getString("prjId"));// 主键
	// project.setPrjName(rs.getString("prjName"));// 项目名称
	// project.setPliesNum(rs.getString("PLIESNUM"));// 层数
	// project.setPrjSize(rs.getString("PRJSIZE"));// 建筑规模
	// project.setPrjNvest(rs.getString("PRJINVEST"));// 投资
	// project.setPrjBuild(rs.getString("PRJINVEST"));// 结构
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
	 * 审批历史查询
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
					project.setPrjId(rs.getString("prjId"));// 主键
					project.setPrjNum(rs.getString("prjNum"));// 项目编号
					project.setPrjName(rs.getString("prjName"));// 项目名称
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// 项目分类
					project.setBuildCorpName(rs.getString("buildCorpName"));// 建设单位名称
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// 建设单位组织机构代码证
					project.setProvinceNum(rs.getString("provinceNum"));// 项目所在省
					project.setCityNum(rs.getString("cityNum"));// 项目所在市
					project.setCountyNum(rs.getString("countyNum"));// 项目所在区
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// 立项文号
					project.setPrjApprovalLevelNum(rs// 立项级别
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// 建设用地规划许可证编号
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// 建设工程规划许可证编号
					project.setAllInvest(rs.getString("allInvest"));// 总投资
					project.setAllArea(rs.getString("allArea"));// 总面积
					project.setPrjSize(rs.getString("prjSize"));// 建设规模
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// 建设性质
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// 工程用途
					project.setBeginDate(rs.getDate("bDate"));// 开始时间
					project.setEndDate(rs.getDate("eDate"));// 结束时间
					project.setCreateDate(rs.getDate("createDate"));// 记录登记时间
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
	 * 查看是否有上传的信息
	 */
	@Override
	public List downloadInfo(String prjId) {
		// TODO Auto-generated method stub
		String sql = "select * from UPLOAD_FILE where LINKNAME='项目报建' and ID = '"
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
	 * 上传到授权库
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
			message = "成功";
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
