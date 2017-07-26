package com.tj.jst.outside.business.design.dao;

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
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.design.model.Design;
import com.tj.jst.outside.business.design.model.DesignQualification;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * 设计
 * @author hhc
 *
 */
public class DesignDaoImpl extends BaseDao implements IDesignDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
					Design design = new Design();
					
					design.setPrjId(rs.getString("prjId"));//主键
					design.setPrjNum(rs.getString("prjNum"));//项目编号
					design.setPrjName(rs.getString("prjName"));//项目名称
					design.setCreateDate(rs.getDate("createDate"));//记录登记时间
					/**
					 * 审批状态
					 * 项目报建：0、申请，1、审批通过，2、审批未通过
					 */
					design.setAppType(rs.getString("appType").trim());//审批状态
					/**
					 * 流程步骤
					 * 1:项目报建
					 * 2:勘察阶段、设计阶段
					 * 3:合同备案、施工图审查备案
					 * 4:质量监督、安全监督
					 * 5:施工许可
					 * 6:竣工验收
					 */
					design.setProcessSteps(rs.getString("processSteps").trim());
					//------------------------------------------设计-------------------------------------------
					design.setDesignId(rs.getString("designId"));//设计主键
					design.setDesignNum(rs.getString("designNum"));//设计编码
					design.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
					design.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
					design.setIsUnits(rs.getString("isUnits"));//设计单位是否填写资质 0:是 1:否
					design.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
					page.getData().add(design);
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
	 * 设计申请
	 * @return
	 */
	public String add(Design design,List<DesignQualification> designQualifications)
	{
		String designId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into DESIGN_BUSINESS(designId,prjNum,prjName,"
					+ "designCorpName,DESIGNCORPCODE,appType,processSteps,applyCorpCode,"
					+ "createDate,appDept,appDeptName,isUnits,PRJID,corpName,designNum) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,designId);	//主键
			pstmt.setString(2, design.getPrjNum());//项目编号
			pstmt.setString(3, design.getPrjName()); //项目名称
			pstmt.setString(4, design.getDesignCorpName()); //设计单位名称
			pstmt.setString(5, design.getDesignCorpCode()); //设计单位组织机构代码
			/**
			 * 审批状态
			 * 项目报建：0、申请，1、审批通过，2、审批未通过
			 */
			pstmt.setString(6, "0");//审批状态
			/**
			 * 流程步骤
			 * 1:项目报建
			 * 2:勘察阶段、设计阶段
			 * 3:合同备案、施工图审查备案
			 * 4:质量监督、安全监督
			 * 5:施工许可
			 * 6:竣工验收
			 */
			pstmt.setString(7, "2");
			pstmt.setString(8, design.getApplyCorpCode());//申请企业组织机构代码
			pstmt.setDate(9, new Date(new java.util.Date().getTime()));//记录登记时间
			pstmt.setString(10, design.getAppDept().trim());//审批单位id
			pstmt.setString(11, design.getAppDeptName());//审批单位名称
			pstmt.setString(12, design.getIsUnits().trim());//是否单位工程   0：是，1：否
			pstmt.setString(13, design.getPrjId());//项目报建id
			pstmt.setString(14, design.getCorpName());//建设单位
			pstmt.setString(15, design.getDesignNum());//设计编码
			pstmt.executeUpdate();
			if(design.getIsUnits().equals("0"))
			{
				for(int i=0;i<designQualifications.size();i++)
				{
					if(designQualifications.get(i)!=null)
					{
						String id = UUID.randomUUID().toString();
						pstmt = conn.prepareStatement("insert into DESIGN_QUALIFICATION(ID,DESIGNID,"
								+ "CERTTYPENAME,TITLELEVELNAME,CERTID,QUALIFNAME) values(?,?,?,?,?,?)");
						pstmt.setString(1,id);	
						pstmt.setString(2,designId); 
						pstmt.setString(3,designQualifications.get(i).getCertTypeName()); 
						pstmt.setString(4,designQualifications.get(i).getTitleLevelName()); 
						pstmt.setString(5,designQualifications.get(i).getCertId()); 
						pstmt.setString(6, designQualifications.get(i).getQualifName());
						pstmt.executeUpdate();
					}
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
		return designId;
	}
	
	/**
	 * 查询单挑数据
	 * @param construction
	 * @return
	 */
	public Design queryById(String designId)
	{

		Design design = new Design();
		try {
			
			String qsql = "select * from DESIGN_BUSINESS where designId=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, designId);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				design.setDesignId(rs.getString("designId"));//主键
				design.setPrjNum(rs.getString("prjNum"));//项目编号
				design.setPrjName(rs.getString("prjName"));//项目名称
				design.setDesignNum(rs.getString("designNum"));//设计编码
				design.setDesignCorpName(rs.getString("designCorpName"));//设计单位名称
				design.setDesignCorpCode(rs.getString("designCorpCode"));//设计单位组织机构代码
				/**
				 * 审批状态
				 * 项目报建：0、申请，1、审批通过，2、审批未通过
				 */
				design.setAppType(rs.getString("appType"));//审批状态
				/**
				 * 流程步骤
				 * 1:项目报建
				 * 2:勘察阶段、设计阶段
				 * 3:合同备案、施工图审查备案
				 * 4:质量监督、安全监督
				 * 5:施工许可
				 * 6:竣工验收
				 */
				design.setProcessSteps(rs.getString("processSteps"));
				design.setApplyCorpCode(rs.getString("applyCorpCode"));//申请企业组织机构代码
				design.setCreateDate(rs.getDate("createDate"));//记录登记时间
				design.setAppDept(rs.getString("appDept").trim());//审批单位id
				design.setAppDeptName(rs.getString("appDeptName"));//审批单位名称
				design.setIsUnits(rs.getString("isUnits").trim());//是否单位工程   0：是，1：否
				design.setPrjId(rs.getString("prjId"));//项目报建id
				design.setCorpName(rs.getString("corpName"));//建设单位
			}
			
			if(design.getIsUnits().equals("0"))
			{
				pstmt = conn.prepareStatement("select * from DESIGN_QUALIFICATION where DESIGNID=?");
				pstmt.setString(1, designId);
				rs = pstmt.executeQuery();
				while(rs.next())
				{
					DesignQualification designQualification = new DesignQualification();
					designQualification.setId(rs.getString("id"));
					designQualification.setDesignId(rs.getString("designId"));
					designQualification.setTitleLevelName(rs.getString("titleLevelName"));
					designQualification.setCertTypeName(rs.getString("certTypeName"));
					designQualification.setCertId(rs.getString("certId"));
					designQualification.setQualifName(rs.getString("qualifName"));
					design.getDesignQualifications().add(designQualification);
				}
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,designId);
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
			design.setList(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return design;
	}
	
	/**
	 * 设计申请修改
	 * @return
	 */
	public void modify(Design design,List<DesignQualification> designQualifications)
	{
		
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update DESIGN_BUSINESS set designCorpName=?,designCorpCode=?,appDept=?,"
					+ "APPDEPTNAME=?,isUnits=? where designId=? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, design.getDesignCorpName());
			pstmt.setString(2, design.getDesignCorpCode());
			pstmt.setString(3, design.getAppDept());
			pstmt.setString(4, design.getAppDeptName());
			pstmt.setString(5, design.getIsUnits());
			pstmt.setString(6, design.getDesignId());
			pstmt.executeUpdate();
			
			if(design.getIsUnits().trim().equals("0"))
			{
				
				pstmt = conn.prepareStatement("delete from DESIGN_QUALIFICATION where designId=?");
				pstmt.setString(1,design.getDesignId());	
				pstmt.executeUpdate();
				
				for(int i=0;i<designQualifications.size();i++)
				{
					if(designQualifications.get(i)!=null)
					{
						String id = UUID.randomUUID().toString();
						pstmt = conn.prepareStatement("insert into DESIGN_QUALIFICATION(ID,DESIGNID,"
								+ "CERTTYPENAME,TITLELEVELNAME,CERTID,qualifName) values(?,?,?,?,?,?)");
						pstmt.setString(1,id);	
						pstmt.setString(2,design.getDesignId()); 
						pstmt.setString(3,designQualifications.get(i).getCertTypeName()); 
						pstmt.setString(4,designQualifications.get(i).getTitleLevelName()); 
						pstmt.setString(5,designQualifications.get(i).getCertId()); 
						pstmt.setString(6,designQualifications.get(i).getQualifName());
						pstmt.executeUpdate();
					}
				}
			}else
			{
				pstmt = conn.prepareStatement("delete from DESIGN_QUALIFICATION where DESIGNID=?");
				pstmt.setString(1,design.getDesignId());	
				pstmt.executeUpdate();
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
	 * 删除
	 * @return
	 */
	public void delete(String designId)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from DESIGN_QUALIFICATION where designId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, designId);//主键
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from DESIGN_BUSINESS where designId=? ");
			pstmt.setString(1, designId);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,designId);	
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
			pstmt.setString(1,designId);	
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
	 * 查询审批部门
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//查询黑龙江
		String sql = "select * from TBXZQDMDIC where name like '%黑龙江%'";
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
				regional.setId(rs.getString("code"));
				regional.setpId("-1");
				regional.setName(rs.getString("name"));
				regional.setOpen("true");
				prId = regional.getId();
				list.add(regional);
			}
			//查询市
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
			//查询区县
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
}
