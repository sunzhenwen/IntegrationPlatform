package com.tj.jst.inner.constrModify.dao;

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
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 项目报建修改,主管部门修改
 * 
 * @author hhc
 *
 */
public class ConstrModifyDaoImpl extends BaseDao implements IConstrModifyDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;

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
	 * 跳转修改页面
	 * 
	 * @return
	 */
	@Override
	public ProjectConstruction queryById(String prjId) {
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
			
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=1 order by num");
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
				pstmt.setString(1,prjId);
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
			project.setAccessoryList(accessoryList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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
		
		
		return project;
	}

	/**
	 * 修改
	 */
	public void update(ProjectConstruction project)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTINFO_S set prjName=?,prjTypeNum=?,buildCorpName=?,"
					+ "buildCorpCode=?,provinceNum=?,cityNum=?,countyNum=?,prjApprovalNum=?,"
					+ "prjApprovalLevelNum=?,buldPlanNum=?,projectPlanNum=?,allInvest=?,"
					+ "allArea=?,prjSize=?,prjPropertyNum=?,PRJFUNCTIONNUM=?,BDATE=?,"
					+ "EDATE=?,address=? where prjId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, project.getPrjName()); //项目名称
			pstmt.setString(2, project.getPrjTypeNum()); //项目分类(字典表：TBPRJTYPEDIC)
			pstmt.setString(3, project.getBuildCorpName()); //建设单位名称
			pstmt.setString(4, project.getBuildCorpCode()); //建设单位组织机构代码
			pstmt.setInt(5, Integer.parseInt(project.getProvinceNum())); //项目所在省(字典表：TBXZQDMDIC)
			pstmt.setInt(6, Integer.parseInt(project.getCityNum())); //项目所在市(字典表：TBXZQDMDIC)
			pstmt.setInt(7, Integer.parseInt(project.getCountyNum())); //项目所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(8, project.getPrjApprovalNum()); //立项文号
			pstmt.setString(9, project.getPrjApprovalLevelNum()); //立项级别
			pstmt.setString(10, project.getBuldPlanNum()); //建设用地规划许可证编号
			pstmt.setString(11, project.getProjectPlanNum()); //建设工程规划许可证编号
			pstmt.setDouble(12, Double.parseDouble(project.getAllInvest())); //总投资（万元）
			pstmt.setDouble(13, Double.parseDouble(project.getAllArea())); //总面积（平方米）
			pstmt.setString(14, project.getPrjSize()); //建设规模
			pstmt.setString(15, project.getPrjPropertyNum()); //建设性质(字典表：TBPRJPORPERTYDIC)
			pstmt.setString(16, project.getPrjFunctionNum()); //工程用途(字典表：TBPRJFUNCTIONDIC)
			pstmt.setDate(17, project.getBeginDate());//实际开工日期；竣工备案环节为M
			pstmt.setDate(18, project.getEndDate());//实际竣工验收日期；竣工备案环节为M
			pstmt.setString(19, project.getAddress());//建设地址
			pstmt.setString(20,project.getPrjId());	//主键
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
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
}
