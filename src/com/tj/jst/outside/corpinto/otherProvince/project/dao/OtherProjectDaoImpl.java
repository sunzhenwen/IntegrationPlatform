package com.tj.jst.outside.corpinto.otherProvince.project.dao;

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
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.upload.model.Upload;
import com.tj.jst.outside.staffmanage.constructor.model.Constructor;

/**
 * 外省项目备案
 * @author Administrator
 *
 */
public class OtherProjectDaoImpl extends BaseDao implements IOtherProjectDao {
	
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
	 * 添加
	 * @return
	 */
	public String add(Construction construction)
	{
		String otherPrjId = UUID.randomUUID().toString();
		try{
			conn = ConnectionFactory.getBasicConnection();
			
            String sql = "insert into OTHER_PROJECT "
            		+ "(PRJID,PRJNUM,PRJNAME,CORPNAME,"
					+ "CORPCODE,CORPID,CREATEDATE,APPDEPT,APPDEPTNAME,otherPrjId) "
					+ "values (?,?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            //姓名
            pstmt.setString(1,construction.getPrjId());
            pstmt.setString(2,construction.getPrjNum());
            pstmt.setString(3,construction.getPrjName());
            pstmt.setString(4,construction.getCorpName());
            pstmt.setString(5,construction.getCorpCode());
            pstmt.setString(6,construction.getCorpId() );
            pstmt.setDate(7,new Date(new java.util.Date().getTime()));
            pstmt.setString(8,construction.getAppDept());
            pstmt.setString(9,construction.getAppDeptName());
            pstmt.setString(10,otherPrjId);
            pstmt.executeUpdate();
        }catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return otherPrjId;
	}
	
	/**
	 * 跳转修改页面
	 * @return
	 */
	public Construction queryById(String otherPrjId)
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
	 * 修改
	 * @return
	 */
	public void modify(Construction construction)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
			
            String sql = "update OTHER_PROJECT set"
            		+ " PRJID=?,PRJNAME=?,PRJNUM=?,APPDEPT=?,APPDEPTNAME=?"
            		+ " where otherPrjId=? ";

            pstmt = conn.prepareStatement(sql);
            
            pstmt.setString(1,construction.getPrjId());
            pstmt.setString(2,construction.getPrjName());
            pstmt.setString(3,construction.getPrjNum());
            pstmt.setString(4,construction.getAppDept());
            pstmt.setString(5,construction.getAppDeptName());
            pstmt.setString(6,construction.getOtherPrjId());
            
            pstmt.executeUpdate();
        }catch (SQLException e) {
			e.printStackTrace();
			
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	/**
	 * 删除
	 * @return
	 */
	public void delete(String otherPrjId)
	{
		try{
			conn = ConnectionFactory.getBasicConnection();
		    String sql = "delete from OTHER_PROJECT where otherPrjId=? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,otherPrjId);
            pstmt.executeUpdate();
        }catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//查询详细
	@Override
	public Constructor queryDetailed(String idCard,String corpCode) {
		String sql = "select t.*,"
				+ "(select a.papertype from TBIDCARDTYPEDIC a where a.code=t.idcardtypenum) as idCardTypeName,"
				+ "(select b.typelevel from TBSPECIALTYTYPEDIC b where b.code=t.specialtytypnum) as sepecialtyTypName,"
				+ "(select c.type from TBCALLINGTYPEDIC c where c.code=t.callingtypenum) as callingTypeName,"
				+ "(select d.discipline from TBREGTRADETYPEDIC d where d.code=t.regtradetypenum) as regTradeTypeName,"
				+ "(select e.status from TBQSTATEDIC e where e.code=t.qstate) as qStateName "
				+ "from TBREGPERSONREGINFO t where t.idCard18=? and t.corpCode=? ";

		Constructor constructor = new Constructor();
		try {
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idCard);
			pstmt.setString(2, corpCode);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				constructor.setPersonId(rs.getString("personId"));
				constructor.setPersonName(rs.getString("personName"));
				constructor.setIdCardTypeName(rs.getString("idCardTypeName"));
				constructor.setIdCard(rs.getString("idCard18"));
				constructor.setSepecialtyTypName(rs.getString("sepecialtyTypName"));
				constructor.setCertNum(rs.getString("certNum"));
				constructor.setAwardDate(rs.getDate("awardDate"));
				constructor.setAwardDepart(rs.getString("awardDepart"));
				constructor.setStampNum(rs.getString("stampNum"));
				constructor.setEffectDate(rs.getDate("effectDate"));
				constructor.setCallingTypeName(rs.getString("callingTypeName"));
				constructor.setCorpName(rs.getString("corpName"));
				constructor.setCorpCode(rs.getString("corpCode"));
				constructor.setCertId(rs.getString("certId"));
				constructor.setRegTradeTypeName(rs.getString("regTradeTypeName"));
				constructor.setRegTradeTypeNum(rs.getString("REGTRADETYPENUM"));
				constructor.setTradeTypeAwardDate(rs.getDate("TRADETYPEAWARDDATE"));
				constructor.setTradeTypeEffectDate(rs.getDate("TRADETYPEEFFECTDATE"));
				constructor.setStateName(rs.getString("qStateName"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		
		return constructor;
	}
	

}
