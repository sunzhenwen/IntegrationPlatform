package com.tj.jst.inner.otherPrjConstructor.dao;

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
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * 外省项目备案内网查看
 * @author Administrator
 *
 */
public class OtherPrjConstructorDaoImpl extends BaseDao implements IOtherPrjConstructorDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
	public Page pagedQuery(Condition condition) {
		
		Page page = super.basePagedQuery(condition);
		ResultSet rs = page.getRs();
		try {
			if(rs!=null)
			{
				while (rs.next()) { 
					Construction construction = new Construction();
					construction.setPrjId(rs.getString("prjId"));
					construction.setPrjName(rs.getString("prjName"));
					construction.setPrjNum(rs.getString("prjNum"));
					construction.setCreateDate(rs.getDate("createDate"));
					construction.setOtherPrjId(rs.getString("otherPrjId"));
					construction.setCorpName(rs.getString("CORPNAME"));
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

	public Construction projectById(String otherPrjId)
	{
		String sql = "select * from OTHER_PROJECT where otherPrjId=? ";

		Construction construction = new Construction();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, otherPrjId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				construction.setPrjId(rs.getString("prjId"));
				construction.setPrjName(rs.getString("prjName"));
				construction.setPrjNum(rs.getString("prjNum"));
				construction.setCorpName(rs.getString("corpName"));
				construction.setCorpCode(rs.getString("corpCode"));
				construction.setAppDept(rs.getString("appDept"));
				construction.setAppDeptName(rs.getString("appDeptName"));
				construction.setOtherPrjId(rs.getString("otherPrjId"));
			}
			
			//查询建筑企业外省项目
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=? order by num");
			pstmt.setString(1, "14");
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
				pstmt.setString(1,otherPrjId);
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
			
			
			//监理企业外省项目
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=? order by num");
			pstmt.setString(1, "16");
			rs = pstmt.executeQuery();
			List<Accessory> accessoryLists = new ArrayList<Accessory>();
			
			while(rs.next())
			{
				Accessory acc = new Accessory();
				acc.setId(rs.getString("id"));
				acc.setLinkNum(rs.getString("linkNum"));
				acc.setLinkName(rs.getString("linkName"));
				acc.setMessage(rs.getString("message"));
				
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? and ACCESSOTYID=? ");
				pstmt.setString(1,otherPrjId);
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
				accessoryLists.add(acc);
			}
			construction.setAccessoryLists(accessoryLists);
			
			//查询项目下的人员信息
			List<ProjectPerson> list = new ArrayList<ProjectPerson>();
			pstmt = conn.prepareStatement("select t.*,p.name as staffTypeName from project_staffs t "
					+ "left join PROJECT_STAFF_TYPE p "
					+ "on t.stafftype=p.code where t.otherPrjId=? and t.STATE='0' ");
			pstmt.setString(1, construction.getOtherPrjId());
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				ProjectPerson projectPerson = new ProjectPerson();
				projectPerson.setPersonId(rs.getString("personId"));
				projectPerson.setPersonName(rs.getString("personName"));
				projectPerson.setCardNum(rs.getString("IDCARD"));
				projectPerson.setCorpId(rs.getString("CORPID"));
				projectPerson.setOtherPrjId(rs.getString("OTHERPRJID"));
				projectPerson.setStaffTypeName(rs.getString("staffTypeName"));
	            list.add(projectPerson);
	        }
			construction.setStaffList(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(conn, pstmt, uploadRs);
		}
		
		return construction;
	}
	
	/**
	 * 人员编辑
	 * @return
	 */
	public ProjectPerson personDetailed(String personId)
	{
		String sql = "select t.*,p.name as staffTypeName from project_staffs t "
		+ "left join PROJECT_STAFF_TYPE p "
		+ "on t.stafftype=p.code where t.personId=?";
		ProjectPerson projectPerson = new ProjectPerson();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				projectPerson.setPersonId(rs.getString("personId"));
				projectPerson.setPersonName(rs.getString("personName"));
				projectPerson.setCardNum(rs.getString("IDCARD"));
				projectPerson.setCorpId(rs.getString("CORPID"));
				projectPerson.setOtherPrjId(rs.getString("OTHERPRJID"));
				projectPerson.setStaffTypeName(rs.getString("staffTypeName"));
			}
			
			//查询建筑企业外省人员附件
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=? order by num");
			pstmt.setString(1, "17");
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
				pstmt.setString(1,personId);
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
			projectPerson.setAccessoryList(accessoryList);
			
			
			//监理企业外省人员附件
			pstmt = conn.prepareStatement("select * from v_ACCESSORY_linkname where linkNum=? order by num");
			pstmt.setString(1, "15");
			rs = pstmt.executeQuery();
			List<Accessory> accessoryLists = new ArrayList<Accessory>();
			
			while(rs.next())
			{
				Accessory acc = new Accessory();
				acc.setId(rs.getString("id"));
				acc.setLinkNum(rs.getString("linkNum"));
				acc.setLinkName(rs.getString("linkName"));
				acc.setMessage(rs.getString("message"));
				
				
				pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=? and ACCESSOTYID=? ");
				pstmt.setString(1,personId);
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
				accessoryLists.add(acc);
			}
			projectPerson.setAccessoryLists(accessoryLists);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
			ConnectionFactory.closeConn(conn, pstmt, uploadRs);
		}
		
		return projectPerson;
	}
}
