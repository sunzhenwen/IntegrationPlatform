package com.tj.jst.inner.integrity.corpBadIntegrity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * 查询项目基本信息数据库类
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryProjectInfoDaoImpl extends BaseDao implements
		IQueryProjectInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * 分页方法
	 */
	@Override
	public Page queryPage(Condition condition) {
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
					project.setAddress(rs.getString("address"));
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

}
