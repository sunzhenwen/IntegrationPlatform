package com.tj.jst.outside.business.tenderInfo.dao;

import java.sql.Connection;
import java.sql.Date;
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
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfo;
import com.tj.jst.outside.business.tenderInfo.model.TenderInfoAdd;

/**
 * 招投标
 * @author hhc
 *
 */
public class TenderInfoDaoImpl extends BaseDao implements ITenderInfoDao {

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
					TenderInfo tenderInfo = new TenderInfo();
					tenderInfo.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
					tenderInfo.setPrjNum(rs.getString("prjNum"));//项目编号
					tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));//招标类型(TBTENDERCLASSDIC)
					tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
					tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));//招标方式(TBTENDERTYPEDIC)
					tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
					tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));//中标日期
					tenderInfo.setTenderMoney(rs.getString("tenderMoney"));//中标金额
					tenderInfo.setPrjSize(rs.getString("prjSize"));//建设规模
					tenderInfo.setArea(rs.getString("area"));//面积(平方米)
					tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));//招标代理单位名称
					tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));//招标代理单位组织机构代码
					tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));//中标单位名称
					tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));//中标单位组织机构代码
					tenderInfo.setConstructorName(rs.getString("constructorName"));//项目经理/总监理工程师姓名
					tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));//项目经理/总监理工程师证件类型
					tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
					tenderInfo.setConstructorIdCard(rs.getString("constructorIdCard"));//项目经理/总监理工程师证件号码
					tenderInfo.setCreateDate(rs.getDate("createDate"));
					page.getData().add(tenderInfo);
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

	public List<Construction> queryProjectInfo(String corpCode)
	{
		List<Construction> list = new ArrayList<Construction>();
		try {
			
			String qsql = "select prjNum,prjName from TBPROJECTINFO_S where buildCorpCode=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				Construction construction = new Construction();
				construction.setPrjNum(rs.getString("prjNum"));
				construction.setPrjName(rs.getString("prjName"));
				list.add(construction);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	public TenderInfo queryTenderById(String tenderNum)
	{
		TenderInfo tenderInfo = new TenderInfo();
		try {
			
			String qsql = "select * from V_TBTENDERINFO where tenderNum=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, tenderNum);
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				tenderInfo.setTenderNum(rs.getString("tenderNum"));//中标通知书编号
				tenderInfo.setPrjNum(rs.getString("prjNum"));//项目编号
				tenderInfo.setTenderClassNum(rs.getString("tenderClassNum"));//招标类型(TBTENDERCLASSDIC)
				tenderInfo.setTenderClassName(rs.getString("tenderClassName"));
				tenderInfo.setTenderTypeNum(rs.getString("tenderTypeNum"));//招标方式(TBTENDERTYPEDIC)
				tenderInfo.setTenderTypeName(rs.getString("tenderTypeName"));
				tenderInfo.setTenderResultDate(rs.getDate("tenderResultDate"));//中标日期
				tenderInfo.setTenderMoney(rs.getString("tenderMoney"));//中标金额
				tenderInfo.setPrjSize(rs.getString("prjSize"));//建设规模
				tenderInfo.setArea(rs.getString("area"));//面积(平方米)
				tenderInfo.setAgencyCorpName(rs.getString("agencyCorpName"));//招标代理单位名称
				tenderInfo.setAgencyCorpCode(rs.getString("agencyCorpCode"));//招标代理单位组织机构代码
				tenderInfo.setTenderCorpName(rs.getString("tenderCorpName"));//中标单位名称
				tenderInfo.setTenderCorpCode(rs.getString("tenderCorpCode"));//中标单位组织机构代码
				tenderInfo.setConstructorName(rs.getString("constructorName"));//项目经理/总监理工程师姓名
				tenderInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));//项目经理/总监理工程师证件类型
				tenderInfo.setIdCardTypeName(rs.getString("idCardTypeName"));
				tenderInfo.setConstructorIdCard(rs.getString("constructorIdCard"));//项目经理/总监理工程师证件号码
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
	
	public String add(TenderInfoAdd tenderInfoAdd)
	{
		int i = 0;
		String message = "";
		try {
			conn = ConnectionFactory.getBasicConnection();
			String sql = "insert into TBTENDERINFO"
					+ "(tenderNum,prjName,prjNum,tenderClassNum,tenderTypeNum,"
					+ "tenderResultDate,tenderMoney,prjSize,area,agencyCorpName,"
					+ "agencyCorpCode,tenderCorpName,tenderCorpCode,constructorName,"
					+ "idCardTypeNum,constructorIdCard,createDate,sectionName,"
					+ "unionCOrpName,unionCorpCode,projectAddress,projectCost,"
					+ "propietorCorpName,propietorCorpCode,ISDELETE,STATE) " 
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,tenderInfoAdd.getTenderNum());//中标通知书编号
			pstmt.setString(2,tenderInfoAdd.getPrjName());//项目名称
			pstmt.setString(3,tenderInfoAdd.getPrjNum());//项目编号
			pstmt.setString(4,tenderInfoAdd.getTenderClassNum());//招标类型(TBTENDERCLASSDIC)
			pstmt.setString(5,tenderInfoAdd.getTenderTypeNum());//招标方式(TBTENDERTYPEDIC)
			pstmt.setDate(6,tenderInfoAdd.getTenderResultDate());//中标日期
			pstmt.setString(7,tenderInfoAdd.getTenderMoney());//中标金额
			pstmt.setString(8,tenderInfoAdd.getPrjSize());//建设规模(施工许可)
			pstmt.setString(9,tenderInfoAdd.getArea());//建筑面积(平方米)
			pstmt.setString(10,tenderInfoAdd.getAgencyCorpName());//招标代理单位名称
			pstmt.setString(11,tenderInfoAdd.getAgencyCorpCode());//招标代理单位组织机构代码
			pstmt.setString(12,tenderInfoAdd.getTenderCorpName());//中标单位名称
			pstmt.setString(13,tenderInfoAdd.getTenderCorpCode());//中标单位组织机构代码
			pstmt.setString(14,tenderInfoAdd.getConstructorName());//项目经理姓名
			pstmt.setString(15,tenderInfoAdd.getIdCardTypeNum());//安全生产管理证件类型(TBIDCARDTYPEDIC)
			pstmt.setString(16,tenderInfoAdd.getConstructorIdCard());//项目经理证件号码
			pstmt.setDate(17,new Date(new java.util.Date().getTime()));//记录登记时间
			pstmt.setString(18,tenderInfoAdd.getSectionName());//标段名称
			pstmt.setString(19,tenderInfoAdd.getUnionCorpName());//联合体承包单位名称
			pstmt.setString(20,tenderInfoAdd.getUnionCorpCode());//联合体承包单位组织代码
			pstmt.setString(21,tenderInfoAdd.getProjectAddress());//项目地址
			pstmt.setString(22,tenderInfoAdd.getProjectCost());//工程造价
			pstmt.setString(23,tenderInfoAdd.getPropietorCorpName());//发包单位名称
			pstmt.setString(24,tenderInfoAdd.getPropietorCorpCode());//发包单位住组织代码
			pstmt.setInt(25,0);//删除状态 0正常在用 1已删除
			pstmt.setInt(26,0);//传输状态 0未传输 1已传输 2测试
			i = pstmt.executeUpdate();
			if(i>0)
			{
				message = "success!";
			}else
			{
				message = "failed!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		return message;
	}
	
	//招标类型
	public List<DictionaryClass> queryTenderClassNum()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			
			String qsql = "select * from TBTENDERCLASSDIC";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("contracttype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//招标方式(TBTENDERTYPEDIC)
	public List<DictionaryClass> queryTenderTypeNum()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			
			String qsql = "select * from TBTENDERTYPEDIC";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("tender"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
	
	//安全生产管理证件类型(TBIDCARDTYPEDIC)
	public List<DictionaryClass> queryIdCardTypeNum()
	{
		List<DictionaryClass> list = new ArrayList<DictionaryClass>();
		try {
			
			String qsql = "select * from TBIDCARDTYPEDIC";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				DictionaryClass dictionaryClass = new DictionaryClass();
				dictionaryClass.setCode(rs.getString("code"));
				dictionaryClass.setName(rs.getString("papertype"));
				list.add(dictionaryClass);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return list;
	}
}
