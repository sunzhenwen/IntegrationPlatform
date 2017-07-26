package com.tj.jst.outside.business.construction.dao;

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
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 项目报建
 * @author hhc
 *
 */
public class ConstructionDaoImpl extends BaseDao implements IConstructionDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
	/**
	 * 查询
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
					Construction construction = new Construction();
					
					construction.setPrjId(rs.getString("prjId"));//主键
					construction.setPrjNum(rs.getString("prjNum"));//项目编号
					construction.setPrjName(rs.getString("prjName"));//项目名称
					construction.setPrjTypeNum(rs.getString("prjTypeNum"));//项目分类(字典表：TBPRJTYPEDIC)
					construction.setPrjTypeName(rs.getString("prjTypeName"));
					construction.setBuildCorpName(rs.getString("buildCorpName"));//建设单位名称
					construction.setBuildCorpCode(rs.getString("buildCorpCode"));//建设单位组织机构代码
					construction.setProvinceNum(rs.getString("provinceNum"));//项目所在省(字典表：TBXZQDMDIC)
					construction.setProvinceName(rs.getString("provinceName"));
					construction.setCityNum(rs.getString("cityNum"));//项目所在市(字典表：TBXZQDMDIC)
					construction.setCityName(rs.getString("cityName"));
					construction.setCountyNum(rs.getString("countyNum"));//项目所在区县(字典表：TBXZQDMDIC)
					construction.setCountyName(rs.getString("countyName"));
					construction.setPrjApprovalNum(rs.getString("prjApprovalNum"));//立项文号
					construction.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));//立项级别
					construction.setBuldPlanNum(rs.getString("buldPlanNum"));//建设用地规划许可证编号
					construction.setProjectPlanNum(rs.getString("projectPlanNum"));//建设工程规划许可证编号
					construction.setAllInvest(rs.getString("allInvest"));//总投资（万元）
					construction.setAllArea(rs.getString("allArea"));//总面积（平方米）
					construction.setPrjSize(rs.getString("prjSize"));//建设规模
					construction.setPrjPropertyNum(rs.getString("prjPropertyNum"));//建设性质(字典表：TBPRJPORPERTYDIC)
					construction.setPrjFuncitonNum(rs.getString("PRJFUNCTIONNUM"));//工程用途(字典表：TBPRJFUNCTIONDIC)
					construction.setBDate(rs.getDate("bDate"));//实际开工日期；竣工备案环节为M
					construction.setEDate(rs.getDate("eDate"));//实际竣工验收日期；竣工备案环节为M
					construction.setCreateDate(rs.getDate("createDate"));//记录登记时间
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					construction.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					construction.setProcessSteps(rs.getString("processSteps"));
					construction.setAppDept(rs.getString("appDept"));//审批单位id
					construction.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
					page.getData().add(construction);
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
	 * 添加报建
	 * @param construction
	 * @return
	 */
	public String add(Construction construction)
	{
		String prjId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBPROJECTINFO_S(prjId,prjNum,prjName,prjTypeNum,buildCorpName,"
					+ "buildCorpCode,provinceNum,cityNum,countyNum,prjApprovalNum,prjApprovalLevelNum,"
					+ "buldPlanNum,projectPlanNum,allInvest,allArea,prjSize,prjPropertyNum,"
					+ "PRJFUNCTIONNUM,BDATE,EDATE,createDate,appType,processSteps,appDept,"
					+ "APPDEPTNAME,address,projectManager,unitPhone) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,prjId);	//主键
			pstmt.setString(2, construction.getPrjNum());//项目编号
			pstmt.setString(3, construction.getPrjName()); //项目名称
			pstmt.setString(4, construction.getPrjTypeNum()); //项目分类(字典表：TBPRJTYPEDIC)
			pstmt.setString(5, construction.getBuildCorpName()); //建设单位名称
			pstmt.setString(6, construction.getBuildCorpCode()); //建设单位组织机构代码
			pstmt.setInt(7, Integer.parseInt(construction.getProvinceNum())); //项目所在省(字典表：TBXZQDMDIC)
			pstmt.setInt(8, Integer.parseInt(construction.getCityNum())); //项目所在市(字典表：TBXZQDMDIC)
			pstmt.setInt(9, Integer.parseInt(construction.getCountyNum())); //项目所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(10, construction.getPrjApprovalNum()); //立项文号
			pstmt.setString(11, construction.getPrjApprovalLevelNum()); //立项级别
			pstmt.setString(12, construction.getBuldPlanNum()); //建设用地规划许可证编号
			pstmt.setString(13, construction.getProjectPlanNum()); //建设工程规划许可证编号
			pstmt.setDouble(14, Double.parseDouble(construction.getAllInvest())); //总投资（万元）
			pstmt.setDouble(15, Double.parseDouble(construction.getAllArea())); //总面积（平方米）
			pstmt.setString(16, construction.getPrjSize()); //建设规模
			pstmt.setString(17, construction.getPrjPropertyNum()); //建设性质(字典表：TBPRJPORPERTYDIC)
			pstmt.setString(18, construction.getPrjFuncitonNum()); //工程用途(字典表：TBPRJFUNCTIONDIC)
			pstmt.setDate(19, construction.getBDate());//实际开工日期；竣工备案环节为M
			pstmt.setDate(20, construction.getEDate());//实际竣工验收日期；竣工备案环节为M
			pstmt.setDate(21, new Date(new java.util.Date().getTime()));//记录登记时间
			/**
			 * 审批状态
			 * 项目报建：0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(22, "0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(23, "1");
			pstmt.setString(24, construction.getAppDept().trim());//审批单位id
			pstmt.setString(25, construction.getAppDeptName());//审批单位名称
			pstmt.setString(26, construction.getAddress());//建设地址
			pstmt.setString(27, construction.getProjectManager());//建设单位项目负责人
			pstmt.setString(28, construction.getUnitPhone());//建设单位联系电话
			pstmt.executeUpdate();
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
		return prjId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId)
	{

		Construction construction = new Construction();
		try {
			
			String qsql = "select * from V_TBPROJECTINFO_S where prjId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, prjId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				construction.setPrjId(rs.getString("prjId"));//主键
				construction.setPrjNum(rs.getString("prjNum"));//项目编号
				construction.setPrjName(rs.getString("prjName"));//项目名称
				construction.setPrjTypeNum(rs.getString("prjTypeNum").trim());//项目分类(字典表：TBPRJTYPEDIC)
				construction.setPrjTypeName(rs.getString("prjTypeName"));
				construction.setBuildCorpName(rs.getString("buildCorpName"));//建设单位名称
				construction.setBuildCorpCode(rs.getString("buildCorpCode"));//建设单位组织机构代码
				construction.setProvinceNum(rs.getString("provinceNum"));//项目所在省(字典表：TBXZQDMDIC)
				construction.setProvinceName(rs.getString("provinceName"));
				construction.setCityNum(rs.getString("cityNum"));//项目所在市(字典表：TBXZQDMDIC)
				construction.setCityName(rs.getString("cityName"));
				construction.setCountyNum(rs.getString("countyNum"));//项目所在区县(字典表：TBXZQDMDIC)
				construction.setCountyName(rs.getString("countyName"));
				construction.setPrjApprovalNum(rs.getString("prjApprovalNum"));//立项文号
				construction.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));//立项级别
				construction.setBuldPlanNum(rs.getString("buldPlanNum"));//建设用地规划许可证编号
				construction.setProjectPlanNum(rs.getString("projectPlanNum"));//建设工程规划许可证编号
				construction.setAllInvest(rs.getString("allInvest"));//总投资（万元）
				construction.setAllArea(rs.getString("allArea"));//总面积（平方米）
				construction.setPrjSize(rs.getString("prjSize"));//建设规模
				construction.setPrjPropertyNum(rs.getString("prjPropertyNum").trim());//建设性质(字典表：TBPRJPORPERTYDIC)
				construction.setPrjFuncitonNum(rs.getString("PRJFUNCTIONNUM").trim());//工程用途(字典表：TBPRJFUNCTIONDIC)
				construction.setBDate(rs.getDate("BDate"));//实际开工日期；竣工备案环节为M
				construction.setEDate(rs.getDate("EDate"));//实际竣工验收日期；竣工备案环节为M
				construction.setCreateDate(rs.getDate("createDate"));//记录登记时间
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				construction.setAppType(rs.getString("appType").trim());//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				construction.setProcessSteps(rs.getString("processSteps").trim());
				construction.setAppDept(rs.getString("appDept").trim());//审批单位id
				construction.setAppDeptName(rs.getString("appDeptName").trim());//审批单位名称
				construction.setAddress(rs.getString("address"));//建设地址
				construction.setProjectManager(rs.getString("PROJECTMANAGER"));//建设单位项目负责人
				construction.setUnitPhone(rs.getString("UNITPHONE"));//建设单位联系电话
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
			construction.setAccessoryList(accessoryList);
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
		return construction;
	}
	
	/**
	 * 修改报建
	 * @param construction
	 * @return
	 */
	public void modify(Construction construction)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBPROJECTINFO_S set prjNum=?,prjName=?,prjTypeNum=?,buildCorpName=?,"
					+ "buildCorpCode=?,provinceNum=?,cityNum=?,countyNum=?,prjApprovalNum=?,"
					+ "prjApprovalLevelNum=?,buldPlanNum=?,projectPlanNum=?,allInvest=?,allArea=?,"
					+ "prjSize=?,prjPropertyNum=?,PRJFUNCTIONNUM=?,BDATE=?,EDATE=?,appType=?,"
					+ "processSteps=?,appDept=?,APPDEPTNAME=?,address=?,projectManager=?,"
					+ "unitPhone=? "
					+ " where prjId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, construction.getPrjNum());//项目编号
			pstmt.setString(2, construction.getPrjName()); //项目名称
			pstmt.setString(3, construction.getPrjTypeNum()); //项目分类(字典表：TBPRJTYPEDIC)
			pstmt.setString(4, construction.getBuildCorpName()); //建设单位名称
			pstmt.setString(5, construction.getBuildCorpCode()); //建设单位组织机构代码
			pstmt.setInt(6, Integer.parseInt(construction.getProvinceNum())); //项目所在省(字典表：TBXZQDMDIC)
			pstmt.setInt(7, Integer.parseInt(construction.getCityNum())); //项目所在市(字典表：TBXZQDMDIC)
			pstmt.setInt(8, Integer.parseInt(construction.getCountyNum())); //项目所在区县(字典表：TBXZQDMDIC)
			pstmt.setString(9, construction.getPrjApprovalNum()); //立项文号
			pstmt.setString(10, construction.getPrjApprovalLevelNum()); //立项级别
			pstmt.setString(11, construction.getBuldPlanNum()); //建设用地规划许可证编号
			pstmt.setString(12, construction.getProjectPlanNum()); //建设工程规划许可证编号
			pstmt.setDouble(13, Double.parseDouble(construction.getAllInvest())); //总投资（万元）
			pstmt.setDouble(14, Double.parseDouble(construction.getAllArea())); //总面积（平方米）
			pstmt.setString(15, construction.getPrjSize()); //建设规模
			pstmt.setString(16, construction.getPrjPropertyNum()); //建设性质(字典表：TBPRJPORPERTYDIC)
			pstmt.setString(17, construction.getPrjFuncitonNum()); //工程用途(字典表：TBPRJFUNCTIONDIC)
			pstmt.setDate(18, construction.getBDate());//实际开工日期；竣工备案环节为M
			pstmt.setDate(19, construction.getEDate());//实际竣工验收日期；竣工备案环节为M
			/**
			 * 审批状态
			 * 项目报建：0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(20, "0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(21, "1");
			pstmt.setString(22, construction.getAppDept().trim());//审批单位id
			pstmt.setString(23, construction.getAppDeptName());//审批单位名称
			pstmt.setString(24, construction.getAddress());//建设地址
			pstmt.setString(25, construction.getProjectManager());//建设单位项目负责人
			pstmt.setString(26, construction.getUnitPhone());//建设单位联系电话
			pstmt.setString(27,construction.getPrjId());	//主键
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
	
	/**
	 * 删除
	 * @return
	 */
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTINFO_S where prjId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,id);	
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
			pstmt.setString(1,id);	
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
	
	//项目分类(字典表：TBPRJTYPEDIC)
	public List<DictionaryClass> queryPrjTypeNums()
	{
		String sql = "select * from TBPRJTYPEDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("PROCLASSIFICATION"));
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
	//建设性质(字典表：TBPRJPROPERTYDIC)
	public List<DictionaryClass> queryPrjPropertyNums()
	{
		String sql = "select * from TBPRJPROPERTYDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("NATURE"));
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
	//工程用途(字典表：TBPRJFUNCTIONDIC)
	public List<DictionaryClass> queryPrjFuncitonNums()
	{
		String sql = "select * from TBPRJFUNCTIONDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("ENGINEERUSE"));
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
	/**
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//查询黑龙江
		String sql = "select * from TBXZQDMDIC_APP where name like '%黑龙江%'";
		List<Regional> list = new ArrayList<Regional>();
		//省Id
		String prId = "";
		//市Id
		List<String> citys = new ArrayList<String>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("sortnum"));
				regional.setpId("-1");
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				prId = regional.getId();
				list.add(regional);
			}
			//查询市
			pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where "
					+ "(sortnum like '400%00' and sortnum !='400000') "
					+ "or (sortnum like '4000%' and sortnum !='400000') "
					+ "or (sortnum like '40%000' and sortnum !='400000') "
					+ "or (sortnum like '401100' and sortnum !='400000') "
					+ "or (sortnum like '401200' and sortnum !='400000') "
					+ "or (sortnum like '402700' and sortnum !='400000')");
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				Regional regional = new Regional();
				regional.setId(rs.getString("sortnum"));
				regional.setpId(prId);
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				citys.add(regional.getId());
				list.add(regional);
			}
			//查询区县
			for(int i=0;i<citys.size();i++)
			{
				String star = citys.get(i).substring(0, 4);
				if(!star.equals("4000"))
				{
					pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where sortnum like '"+star+"%' and sortnum != '"+citys.get(i)+"'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						Regional regional = new Regional();
						regional.setId(rs.getString("sortnum"));
						regional.setpId(citys.get(i));
						regional.setName(rs.getString("name"));
						list.add(regional);
					}
				}else if(citys.get(i).equals("400021"))
				{
					//森工
					pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where pid = '400021'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						Regional regional = new Regional();
						regional.setId(rs.getString("sortnum"));
						regional.setpId("400021");
						regional.setName(rs.getString("name"));
						list.add(regional);
					}
				}else if(citys.get(i).equals("400020"))
				{
					//农垦
					pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where pid = '400020'");
					rs = pstmt.executeQuery();
					while(rs.next())
					{
						Regional regional = new Regional();
						regional.setId(rs.getString("sortnum"));
						regional.setpId("400020");
						regional.setName(rs.getString("name"));
						list.add(regional);
					}
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
	 * 根据树形排序id查询区域编码
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
	
	//查询省
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

	//查询市
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

	//查询区
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
	//立项级别
	public List<DictionaryClass> queryPrjApprovalLevelNums()
	{
		String sql = "select * from TBLXJBDIC";
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setName(rs.getString("PROLEVEL"));
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
}
