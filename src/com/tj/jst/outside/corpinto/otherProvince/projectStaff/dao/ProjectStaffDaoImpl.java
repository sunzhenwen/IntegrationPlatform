package com.tj.jst.outside.corpinto.otherProvince.projectStaff.dao;

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
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.corpinto.otherProvince.projectStaff.model.ProjectPerson;

/**
 * 外省项目,人员备案
 * @author Administrator
 *
 */
public class ProjectStaffDaoImpl extends BaseDao implements IProjectStaffDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
	/**
	 * 项目添加人员
	 * @return
	 */
	public String add(String projectPersons,String corpId,String otherPrjId)
	{
		try{
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into project_staffs "
            		+ "(PERSONID,PERSONNAME,IDCARD,CORPID,"
					+ "OTHERPRJID,STATE,CREATEDATE) "
					+ "values (?,?,?,?,?,?,?)";
            
            pstmt = conn.prepareStatement(sql);

            
            String[] persons = projectPersons.split(",");
            for(int i=0;i<persons.length;i++){
            	int pers = persons[i].trim().indexOf("^");
            	String personId = UUID.randomUUID().toString();
                pstmt.setString(1,personId);
            	pstmt.setString(2,persons[i].trim().substring(0, pers));
                pstmt.setString(3,persons[i].trim().substring(pers+1, persons[i].trim().length()));
                pstmt.setString(4,corpId);
                pstmt.setString(5,otherPrjId);
                pstmt.setString(6,"0");
                pstmt.setDate(7,new Date(new java.util.Date().getTime()));
                pstmt.addBatch();     
            }
            pstmt.executeBatch();     
            conn.commit();     
        }catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return otherPrjId;
	}
	
	/**
	 * 查询项目下的人员
	 * @return
	 */
	public Construction queryById(Construction construction)
	{
		String sql = "select t.*,p.name as staffTypeName from project_staffs t "
				+ "left join PROJECT_STAFF_TYPE p "
				+ "on t.stafftype=p.code where t.otherPrjId=? and t.STATE='0' ";
		List<ProjectPerson> list = new ArrayList<ProjectPerson>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
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
	 * 删除
	 * @return
	 */
	public void deletePerson(String personId)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			//删除人员表
            String sql1 = "update project_staffs set "
            		+ "state=? where personId=?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,"1");
			pstmt.setString(2,personId);
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	//已经备案的项目列表
	public List<Construction> queryProject(String corpId)
	{
		String sql = "select * from OTHER_PROJECT where CORPID=?";
		List<Construction> list = new ArrayList<Construction>();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corpId);
			rs = pstmt.executeQuery();
			while(rs.next())
			{                
				Construction construction = new Construction();
				construction.setOtherPrjId(rs.getString("otherPrjId"));//主键
				construction.setPrjName(rs.getString("prjName"));//项目名称
				list.add(construction);
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
	 * 人员编辑
	 * @return
	 */
	public ProjectPerson personDetailed(String personId)
	{
		String sql = "select * from PROJECT_STAFFS where personId=? ";

		ProjectPerson projectPerson = new ProjectPerson();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, personId);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				projectPerson.setPersonId(rs.getString("PERSONID"));
				projectPerson.setPersonName(rs.getString("PERSONNAME"));
				projectPerson.setOtherPrjId(rs.getString("OTHERPRJID"));
				projectPerson.setCardNum(rs.getString("IDCARD"));
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
	
	/**
	 * 人员修改
	 * @return
	 */
	public void modify(ProjectPerson projectPerson)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			//删除人员表
            String sql1 = "update project_staffs set "
            		+ "STAFFTYPE=? where personId=?";
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,projectPerson.getStaffType());
			pstmt.setString(2,projectPerson.getPersonId());
			pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
}
