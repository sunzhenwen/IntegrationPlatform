package com.tj.jst.outside.corpinto.notforeign.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.corpinto.notforeign.model.Corp;

public class CorpDaoImpl implements ICorpDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
//	//企业组织机构代码查询
//	@Override
//	public Corp queryCorpCode(String corpCode) {
//		
//		Corp corp = new Corp();
//		try {
//			
//			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
//			//获取基础数据库链接，首先从基础数据库查询
//			conn = ConnectionFactory.getBasicConnection();
//			pstmt = conn.prepareStatement(qsql);
//			pstmt.setString(1, corpCode);
//			rs = pstmt.executeQuery();
//			
//			//如果基础数据库存在，返回不允许企业再次注册
//			if(rs.next())
//			{
//				String appType = rs.getString("appType");
//				if(appType!=null)
//				{
//					if(appType.equals("0"))
//					{
//						//如果数据库存在且未经过审批，返回修改页面
//						corp.setCorpId(rs.getString("corpId"));		//主键	
//						corp.setCorpName(rs.getString("corpName"));	//企业名称
//						corp.setCorpCode(rs.getString("corpCode")); 	//组织机构代码
//						corp.setLicenseNum(rs.getString("licenseNum"));//工商营业执照注册号
//						corp.setProvinceNum(rs.getString("provinceNum"));//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
//						corp.setCityNum(rs.getString("cityNum"));		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
//						corp.setCountyNum(rs.getString("countyNum"));	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
//						corp.setAddress(rs.getString("address"));		//企业营业地址
//						corp.setPostalCode(rs.getString("postalCode"));//企业营业地址邮政编码
//						corp.setLegalMan(rs.getString("legalMan"));	//法定代表人姓名
//						corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
//						corp.setLegalManIdCard(rs.getString("legalManIdCard"));//法定代表人证件号码
//						corp.setLegalManDuty(rs.getString("legalManDuty"));//法定代表人职务
//						corp.setLegaManProtitle(rs.getString("legaManProtitle"));//法定代表人职称
//						corp.setEconomicNum(rs.getString("economicNum"));	//企业登记注册类型(字典表：TBECONTYPEDIC)
//						corp.setRegPrin(rs.getString("regPrin")); 		//注册资本(万元)
//						corp.setFactRegPrin(rs.getString("factRegPrin"));	//实收资本(万元)
//						corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));//注册资本币种(字典表：TBPRINCIPALUNITDIC)
//						corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//成立日期
//						corp.setOfficePhone(rs.getString("officePhone"));//办公电话
//						corp.setFax(rs.getString("fax"));				//传真号码
//						corp.setLinkMan(rs.getString("linkMan")); 		//联系人姓名
//						corp.setLinkTel(rs.getString("linkTel"));		//联系人办公电话
//						corp.setLinkPhone(rs.getString("linkPhone"));	//联系人手机号码
//						corp.setEmail(rs.getString("email"));			//联系邮箱
//						corp.setUrl(rs.getString("url"));				//企业网址
//						corp.setDescription(rs.getString("description"));	//备注
//						corp.setAssets(rs.getString("assets"));	
//						corp.setMachinery(rs.getString("machinery"));
//						corp.setSpare1(rs.getString("spare1"));//企业归属地
//						corp.setForeignCorpName(rs.getString("foreignCorpName"));//外商投资者名称
//						corp.setNationNume(rs.getString("nationnum"));//国籍或地区(字典表：TBNATIONALDIC)
//						corp.setPercentTage(rs.getString("percentTage"));//外商投资所占比例(%)
//						corp.setForeignIvestor(rs.getString("foreignIvestor"));	//外商投资这类型         0:境外企业；1：境外自然人
//						corp.setCheckForeign(rs.getString("checkForeign"));//是否外商投资	   0:是；1：否
//						corp.setEnterpriseType(rs.getString("enterpriseType"));
//						//数据库中存在，未经审批跳转修改页面
//						corp.setCheckType(1);
//					}else
//					{
//						//数据库中已经存在跳转登陆页面
//						corp.setCheckType(0);
//						corp.setMessage("您所查询的企业已经注册并经过审核，请使用UKey登陆！");
//					}
//				}else
//				{
//					//appType为null为老数据,默认经过审核
//					corp.setCheckType(0);
//					corp.setMessage("您所查询的企业已经注册并经过审核，请使用UKey登陆！");
//				}
//			}else
//			{
//				//数据库中不存在跳转添加页面
//				corp.setCheckType(2);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally
//		{
//			ConnectionFactory.closeConn(conn, pstmt, rs);
//		}
//		return corp;
//	}

	//企业组织机构代码查询
	@Override
	public Corp queryCorpCode(String corpCode) {
		
		Corp corp = new Corp();
		
		try {
			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				//如果数据库存在且未经过审批，返回修改页面
				corp.setCorpId(rs.getString("corpId"));		//主键	
				corp.setCorpName(rs.getString("corpName"));	//企业名称
				corp.setCorpCode(rs.getString("corpCode")); 	//组织机构代码
				corp.setLicenseNum(rs.getString("licenseNum"));//工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum"));//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum"));		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countyNum"));	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corp.setAddress(rs.getString("address"));		//企业营业地址
				corp.setPostalCode(rs.getString("postalCode"));//企业营业地址邮政编码
				corp.setLegalMan(rs.getString("legalMan"));	//法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));//法定代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty"));//法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));//法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum"));	//企业登记注册类型(字典表：TBECONTYPEDIC)
				corp.setRegPrin(rs.getString("regPrin")); 		//注册资本(万元)
				corp.setFactRegPrin(rs.getString("factRegPrin"));	//实收资本(万元)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));//注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//成立日期
				corp.setOfficePhone(rs.getString("officePhone"));//办公电话
				corp.setFax(rs.getString("fax"));				//传真号码
				corp.setLinkMan(rs.getString("linkMan")); 		//联系人姓名
				corp.setLinkTel(rs.getString("linkTel"));		//联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone"));	//联系人手机号码
				corp.setEmail(rs.getString("email"));			//联系邮箱
				corp.setUrl(rs.getString("url"));				//企业网址
				corp.setDescription(rs.getString("description"));	//备注
				corp.setAssets(rs.getString("assets"));	
				corp.setMachinery(rs.getString("machinery"));
				corp.setSpare1(rs.getString("spare1"));//企业归属地
				corp.setForeignCorpName(rs.getString("foreignCorpName"));//外商投资者名称
				corp.setNationNume(rs.getString("nationnum"));//国籍或地区(字典表：TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));//外商投资所占比例(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor"));	//外商投资这类型         0:境外企业；1：境外自然人
				corp.setCheckForeign(rs.getString("checkForeign"));//是否外商投资	   0:是；1：否
				corp.setEnterpriseType(rs.getString("enterpriseType"));
				corp.setAppType(rs.getString("appType"));//审批标识
				corp.setLockNumber1(rs.getString("lockNumber1"));//UKey号
				corp.setLockNumber1_Date(rs.getString("lockNumber1_Date"));//发UKey日期
				
				if( corp.getLockNumber1() != null ) {
					corp.setCheckType(0);
					corp.setMessage("企业已经拥有UKey，请使用UKey登陆！");
				} else {
					if(corp.getAppType()==null)
					{
						//如果审批标识为null,说明是老数据,不需要进行审批,跳转修改页面
						corp.setCheckType(1);
					}else if(corp.getAppType().equals("0"))
					{
						//如果审批标识为0,说明是新用户注册,未经过审批,跳转修改页面
						corp.setCheckType(1);
					}else if(corp.getAppType().equals("1"))
					{
						//如果审批标识为1,说明新用户经过审批,跳转登陆页面
						//corp.setCheckType(0);
						//corp.setMessage("您所查询的企业已经注册并经过审核，请使用UKey登陆！");
						//审批标识为1，也让修改
						corp.setCheckType(1);
					}else
					{
						//如果审批标识为2,说明新用户审批未通过,重新提交信息,跳转添加页面
						corp.setCheckType(2);
					}
				}
				
			}else
			{
				//数据库中不存在跳转添加页面
				corp.setCheckType(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
	
	//企业组织机构代码查询
	public Corp queryCorpTypeCode(String corpCode)
	{
		Corp corp = new Corp();
		try {
			
			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				//如果数据库存在且未经过审批，返回修改页面
				corp.setCorpName(rs.getString("corpName"));//企业名称
				corp.setCorpCode(rs.getString("corpCode"));//企业组织机构代码
				corp.setCorpId(rs.getString("corpId"));		//主键
				corp.setEnterpriseType(rs.getString("enterpriseType"));
			}else
			{
				//数据库中不存在跳转添加页面
				corp.setCheckType(2);
				corp.setMessage("您所查询的企业信息不存在,请进行亲企业录入操作!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	}
	
	//添加企业
	@Override
	public String addCorp(Corp corp) {
		String message = "";
		int checkNum1 = 0;
		int checkNum2 = 0;
		String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
				+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
				+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
				+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
				+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN,enterpriseType) "
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String corpId = UUID.randomUUID().toString();
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//企业名称
			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
			pstmt.setString(3,corp.getLicenseNum());//工商营业执照注册号
			pstmt.setString(4,corp.getProvinceNum());//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//企业营业地址
			pstmt.setString(8,corp.getPostalCode());//企业营业地址邮政编码
			pstmt.setString(9,corp.getLegalMan());	//法定代表人姓名
			pstmt.setString(10,corp.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//法定代表人证件号码
			pstmt.setString(12,corp.getLegalManDuty());//法定代表人职务
			pstmt.setString(13,corp.getLegaManProtitle());//法定代表人职称
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//注册资本(万元)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//实收资本(万元)
			pstmt.setString(17,corp.getPrincipalUnitNum());//注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//成立日期
			pstmt.setString(19,corp.getOfficePhone());//办公电话
			pstmt.setString(20,corp.getFax());				//传真号码
			pstmt.setString(21,corp.getLinkMan()); 		//联系人姓名
			pstmt.setString(22,corp.getLinkTel());		//联系人办公电话
			pstmt.setString(23,corp.getLinkPhone());	//联系人手机号码
			pstmt.setString(24,corp.getEmail());			//联系邮箱
			pstmt.setString(25,corp.getUrl());				//企业网址
			pstmt.setString(26,corp.getDescription());	//备注
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//添加时间
			pstmt.setString(28, corpId);				//主键
			pstmt.setString(29, "1");				//新老数据，0老数据，1新数据
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());//企业归属地
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.setString(34, corp.getEnterpriseType().replace(" ", ""));
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
					+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,appType,"
					+ "spare1,CREATEDATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,corpId);	
			pstmt.setString(2,corp.getCorpName()); 
			pstmt.setString(3,corp.getCorpCode()); 
			pstmt.setString(4,corp.getApplyOpinion()); 
			pstmt.setString(5,corp.getApplyStaffId()); 
			pstmt.setString(6,corp.getApplyStaffName());
			pstmt.setString(7,corp.getApplyDept());
			pstmt.setString(8,corp.getApplyDeptName());
			pstmt.setString(9,"1");
			pstmt.setString(10,corp.getSpare1());
			pstmt.setDate(11,new Date(new java.util.Date().getTime())); //创建时间
			checkNum2 = pstmt.executeUpdate();
			conn.commit();
			if(checkNum1 > 0 && checkNum2 > 0)
			{
				message = "企业添加成功!";
			}else
			{
				message = "企业添加失败!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, null);
		}
		
		return message;
	}
	
	//保存外商企业
	@Override
	public String addForeignCorp(Corp corp) {
		String corpId = UUID.randomUUID().toString();
		String message = "";
		int checkNum1 = 0;
		int checkNum2 = 0;
		int checkNum3 = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "insert into TBCorpBasicinfo(CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
					+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
					+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
					+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
					+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN,enterpriseType) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//企业名称
			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
			pstmt.setString(3,corp.getLicenseNum());//工商营业执照注册号
			pstmt.setString(4,corp.getProvinceNum());//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//企业营业地址
			pstmt.setString(8,corp.getPostalCode());//企业营业地址邮政编码
			pstmt.setString(9,corp.getLegalMan());	//法定代表人姓名
			pstmt.setString(10,corp.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//法定代表人证件号码
			pstmt.setString(12,corp.getLegalManDuty());//法定代表人职务
			pstmt.setString(13,corp.getLegaManProtitle());//法定代表人职称
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//注册资本(万元)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//实收资本(万元)
			pstmt.setString(17,corp.getPrincipalUnitNum());//注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//成立日期
			pstmt.setString(19,corp.getOfficePhone());//办公电话
			pstmt.setString(20,corp.getFax());				//传真号码
			pstmt.setString(21,corp.getLinkMan()); 		//联系人姓名
			pstmt.setString(22,corp.getLinkTel());		//联系人办公电话
			pstmt.setString(23,corp.getLinkPhone());	//联系人手机号码
			pstmt.setString(24,corp.getEmail());			//联系邮箱
			pstmt.setString(25,corp.getUrl());				//企业网址
			pstmt.setString(26,corp.getDescription());	//备注
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//添加时间
			pstmt.setString(28, corpId);				//主键
			pstmt.setString(29, "1");				//新老数据，0老数据，1新数据
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());//企业归属地
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.setString(34, corp.getEnterpriseType().replace(" ", ""));//企业类型
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into T_TBCORPBUSINESS(CORPID,CORPNAME,CORPCODE,"
					+ "APPLYOPINION,APPLYSTAFFID,APPLYSTAFFNAME,APPLYDEPT,APPLYDEPTNAME,appType,"
					+ "spare1,CREATEDATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,corpId);	
			pstmt.setString(2,corp.getCorpName()); 
			pstmt.setString(3,corp.getCorpCode()); 
			pstmt.setString(4,corp.getApplyOpinion()); 
			pstmt.setString(5,corp.getApplyStaffId()); 
			pstmt.setString(6,corp.getApplyStaffName());
			pstmt.setString(7,corp.getApplyDept());
			pstmt.setString(8,corp.getApplyDeptName());
			pstmt.setString(9,"1");
			pstmt.setString(10, corp.getSpare1());
			pstmt.setDate(11,new Date(new java.util.Date().getTime())); //创建时间
			checkNum2 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("insert into TBCorpForeigninfo(CORPID,CORPNAME,CORPCODE,"
					+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,FOREIGNIVESTOR,"
					+ "CREATEDATE) "
					+ "values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setString(1,corpId);	
			pstmt.setString(2,corp.getCorpName()); 
			pstmt.setString(3,corp.getCorpCode()); 
			pstmt.setString(4,corp.getForeignCorpName()); 
			pstmt.setString(5,corp.getNationNume()); 
			pstmt.setString(6,corp.getPrincipalUnitNum());
			pstmt.setString(7,corp.getRegPrin());
			pstmt.setString(8,corp.getPercentTage());
			pstmt.setString(9,corp.getForeignIvestor());
			pstmt.setDate(10,new Date(new java.util.Date().getTime())); //创建时间
			checkNum3 = pstmt.executeUpdate();
			
			conn.commit();
			if(checkNum1 > 0 && checkNum2 > 0 && checkNum3 > 0)
			{
				message = "企业添加成功!";
			}else
			{
				message = "企业添加失败!";
			}
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
		return message;
	}
	


	//修改企业
	@Override
	public String modifyCorp(Corp corp) 
	{
		//企业基本信息修改备案
		this.modifyCorpInfoLog(corp);
		
		String message = "";
		int checkNum1 = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
					+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
					+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
					+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=?,spare1=?,"
					+ "checkForeign=?,enterpriseType=? where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//企业名称
			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
			pstmt.setString(3,corp.getLicenseNum());//工商营业执照注册号
			pstmt.setString(4,corp.getProvinceNum());//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//企业营业地址
			pstmt.setString(8,corp.getPostalCode());//企业营业地址邮政编码
			pstmt.setString(9,corp.getLegalMan());	//法定代表人姓名
			pstmt.setString(10,corp.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//法定代表人证件号码
			pstmt.setString(12,corp.getLegalManDuty());//法定代表人职务
			pstmt.setString(13,corp.getLegaManProtitle());//法定代表人职称
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//注册资本(万元)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//实收资本(万元)
			pstmt.setString(17,corp.getPrincipalUnitNum());//注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//成立日期
			pstmt.setString(19,corp.getOfficePhone());//办公电话
			pstmt.setString(20,corp.getFax());				//传真号码
			pstmt.setString(21,corp.getLinkMan()); 		//联系人姓名
			pstmt.setString(22,corp.getLinkTel());		//联系人办公电话
			pstmt.setString(23,corp.getLinkPhone());	//联系人手机号码
			pstmt.setString(24,corp.getEmail());			//联系邮箱
			pstmt.setString(25,corp.getUrl());				//企业网址
			pstmt.setString(26,corp.getDescription());	//备注
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//修改时间
			pstmt.setString(28, corp.getAssets());
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getSpare1());
			pstmt.setString(31, corp.getCheckForeign());
			pstmt.setString(32, corp.getEnterpriseType().replace(" ", ""));
			pstmt.setString(33, corp.getCorpId());	//主键
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("delete from TBCorpForeigninfo where corpId=?");
			pstmt.setString(1,corp.getCorpId());	
			pstmt.executeUpdate();
			
			
//			pstmt = conn.prepareStatement("update T_TBCORPBUSINESS set CORPNAME=?,CORPCODE=?,"
//					+ "spare1=? where CORPID=?");
//			pstmt.setString(1,corp.getCorpName());	//企业名称
//			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
//			pstmt.setString(3, corp.getSpare1());
//			pstmt.setString(4,corp.getCorpId());	//主键
//			checkNum3 = pstmt.executeUpdate();
			
			
			conn.commit();
			if(checkNum1 > 0)
			{
				message = "企业修改成功!";
			}else
			{
				message = "企业修改失败!";
			}
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
		return message;
	}
	
	/**
	 * 企业基本信息修改备案
	 * @param corp
	 */
	private void modifyCorpInfoLog(Corp corp) {
		// TODO Auto-generated method stub
		String sql = "select * from TBCORPBASICINFO where corpId = ?" ;
		Corp corpOldInfo = new Corp() ;
		try {
			
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getCorpId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				corpOldInfo.setCorpName(rs.getString("corpName"));
				corpOldInfo.setLicenseNum(rs.getString("licenseNum"));
				corpOldInfo.setProvinceNum(rs.getString("provinceNum"));
				corpOldInfo.setCityNum(rs.getString("cityNum"));
				corpOldInfo.setCountyNum(rs.getString("countyNum"));
				corpOldInfo.setAddress(rs.getString("address"));
				corpOldInfo.setLegalMan(rs.getString("legalMan"));
				corpOldInfo.setIdCardTypeNum(rs.getString("idCardTypeNum"));
				corpOldInfo.setLegalManIdCard(rs.getString("legalManIdCard"));
				corpOldInfo.setLegalManDuty(rs.getString("legalManDuty"));
				corpOldInfo.setLegaManProtitle(rs.getString("legaManProtitle"));
				corpOldInfo.setEconomicNum(String.valueOf(rs.getInt("economicNum")));
				corpOldInfo.setRegPrin(String.valueOf(rs.getDouble("regPrin")));
				corpOldInfo.setFactRegPrin(String.valueOf(rs.getDouble("factRegPrin")));
				corpOldInfo.setCorpBirthDate(rs.getDate("corpBirthDate"));
				corpOldInfo.setSpare1(rs.getString("spare1"));
				corpOldInfo.setAssets(rs.getString("assets"));
				corpOldInfo.setCreateDate(rs.getDate("creatDate"));
				corpOldInfo.setLockNumber1(rs.getString("lockNumber1"));
				corpOldInfo.setLockNumber1_Date(rs.getString("lockNumber1_Date"));
			}
			
			sql = "insert into MODIFYCORPINFO_LOG (CORPNAME,CORPCODE,LICENSENUM,PROVINCENUM,CITYNUM,"
					+ "COUNTYNUM,ADDRESS,POSTALCODE,LEGALMAN,IDCARDTYPENUM,LEGALMANIDCARD,LEGALMANDUTY,"
					+ "LEGAMANPROTITLE,ECONOMICNUM,REGPRIN,FACTREGPRIN,PRINCIPALUNITNUM,CORPBIRTHDATE,"
					+ "OFFICEPHONE,FAX,LINKMAN,LINKTEL,LINKPHONE,EMAIL,URL,DESCRIPTION,CREATDATE,"
					+ "CORPID,OLDORNEW,ASSETS,MACHINERY,spare1,CHECKFOREIGN,enterpriseType,LOGID,MODIFYDATE," +
					"CORPNAME1,LICENSENUM1,PROVINCENUM1,CITYNUM1,COUNTYNUM1,ADDRESS1,LEGALMAN1,IDCARDTYPENUM1," +
					"LEGALMANIDCARD1,LEGALMANDUTY1,LEGAMANPROTITLE1,ECONOMICNUM1,REGPRIN1,FACTREGPRIN1," +
					"CORPBIRTHDATE1,SPARE11,ASSETS1,LOCKNUMBER1,LOCKNUMBER1_DATE,MODIFYINGLOCATION) "
					+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//企业名称
			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
			pstmt.setString(3,corp.getLicenseNum());//工商营业执照注册号
			pstmt.setString(4,corp.getProvinceNum());//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//企业营业地址
			pstmt.setString(8,corp.getPostalCode());//企业营业地址邮政编码
			pstmt.setString(9,corp.getLegalMan());	//法定代表人姓名
			pstmt.setString(10,corp.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//法定代表人证件号码
			pstmt.setString(12,corp.getLegalManDuty());//法定代表人职务
			pstmt.setString(13,corp.getLegaManProtitle());//法定代表人职称
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//注册资本(万元)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//实收资本(万元)
			pstmt.setString(17,corp.getPrincipalUnitNum());//注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//成立日期
			pstmt.setString(19,corp.getOfficePhone());//办公电话
			pstmt.setString(20,corp.getFax());				//传真号码
			pstmt.setString(21,corp.getLinkMan()); 		//联系人姓名
			pstmt.setString(22,corp.getLinkTel());		//联系人办公电话
			pstmt.setString(23,corp.getLinkPhone());	//联系人手机号码
			pstmt.setString(24,corp.getEmail());			//联系邮箱
			pstmt.setString(25,corp.getUrl());				//企业网址
			pstmt.setString(26,corp.getDescription());	//备注
			pstmt.setDate(27,corpOldInfo.getCreateDate());	//添加时间
			pstmt.setString(28, corp.getCorpId());				//主键
			pstmt.setString(29, "1");				//新老数据，0老数据，1新数据
			pstmt.setString(30, corp.getAssets());
			pstmt.setString(31, corp.getMachinery());
			pstmt.setString(32, corp.getSpare1());//企业归属地
			pstmt.setString(33, corp.getCheckForeign());
			pstmt.setString(34, corp.getEnterpriseType());
			pstmt.setString(35, UUID.randomUUID().toString());//日志主键
			pstmt.setDate(36, new Date(new java.util.Date().getTime()));//修改时间
			pstmt.setString(37, corpOldInfo.getCorpName());
			pstmt.setString(38, corpOldInfo.getLicenseNum());
			pstmt.setString(39, corpOldInfo.getProvinceNum());
			pstmt.setString(40, corpOldInfo.getCityNum());
			pstmt.setString(41, corpOldInfo.getCountyNum());
			pstmt.setString(42, corpOldInfo.getAddress());
			pstmt.setString(43, corpOldInfo.getLegalMan());
			pstmt.setString(44, corpOldInfo.getIdCardTypeNum());
			pstmt.setString(45, corpOldInfo.getLegalManIdCard());
			pstmt.setString(46, corpOldInfo.getLegalManDuty());
			pstmt.setString(47, corpOldInfo.getLegaManProtitle());
			pstmt.setInt(48, Integer.parseInt(corpOldInfo.getEconomicNum()));
			pstmt.setDouble(49, Double.parseDouble(corpOldInfo.getRegPrin()));
			pstmt.setDouble(50, Double.parseDouble(corpOldInfo.getFactRegPrin()));
			pstmt.setDate(51, corpOldInfo.getCorpBirthDate());
			pstmt.setString(52, corpOldInfo.getSpare1());
			pstmt.setString(53, corpOldInfo.getAssets());
			pstmt.setString(54,corpOldInfo.getLockNumber1());
			pstmt.setString(55, corpOldInfo.getLockNumber1_Date());
			pstmt.setString(56, "黑龙江省建筑一体化平台");

			pstmt.executeUpdate();
			conn.commit();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
	}

	//修改外商企业
	@Override
	public String modifyForeignCorp(Corp corp) 
	{
		String message = "";
		int checkNum1 = 0;
		int checkNum2 = 0;
		int checkNum3 = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBCorpBasicinfo set CORPNAME=?,CORPCODE=?,LICENSENUM=?,PROVINCENUM=?,CITYNUM=?,"
					+ "COUNTYNUM=?,ADDRESS=?,POSTALCODE=?,LEGALMAN=?,IDCARDTYPENUM=?,LEGALMANIDCARD=?,LEGALMANDUTY=?,"
					+ "LEGAMANPROTITLE=?,ECONOMICNUM=?,REGPRIN=?,FACTREGPRIN=?,PRINCIPALUNITNUM=?,CORPBIRTHDATE=?,OFFICEPHONE=?,"
					+ "FAX=?,LINKMAN=?,LINKTEL=?,LINKPHONE=?,EMAIL=?,URL=?,DESCRIPTION=?,UPDATETIME=?,ASSETS=?,MACHINERY=?,spare1=?,"
					+ "checkForeign=?,enterpriseType=? where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,corp.getCorpName());	//企业名称
			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
			pstmt.setString(3,corp.getLicenseNum());//工商营业执照注册号
			pstmt.setString(4,corp.getProvinceNum());//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
			pstmt.setString(5,corp.getCityNum());		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
			pstmt.setString(6,corp.getCountyNum());	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
			pstmt.setString(7,corp.getAddress());		//企业营业地址
			pstmt.setString(8,corp.getPostalCode());//企业营业地址邮政编码
			pstmt.setString(9,corp.getLegalMan());	//法定代表人姓名
			pstmt.setString(10,corp.getIdCardTypeNum());//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
			pstmt.setString(11,corp.getLegalManIdCard());//法定代表人证件号码
			pstmt.setString(12,corp.getLegalManDuty());//法定代表人职务
			pstmt.setString(13,corp.getLegaManProtitle());//法定代表人职称
			pstmt.setInt(14,Integer.parseInt(corp.getEconomicNum()));	//企业登记注册类型(字典表：TBECONTYPEDIC)
			pstmt.setDouble(15,Double.parseDouble(corp.getRegPrin())); 		//注册资本(万元)
			pstmt.setDouble(16,Double.parseDouble(corp.getFactRegPrin()));	//实收资本(万元)
			pstmt.setString(17,corp.getPrincipalUnitNum());//注册资本币种(字典表：TBPRINCIPALUNITDIC)
			pstmt.setDate(18,corp.getCorpBirthDate());//成立日期
			pstmt.setString(19,corp.getOfficePhone());//办公电话
			pstmt.setString(20,corp.getFax());				//传真号码
			pstmt.setString(21,corp.getLinkMan()); 		//联系人姓名
			pstmt.setString(22,corp.getLinkTel());		//联系人办公电话
			pstmt.setString(23,corp.getLinkPhone());	//联系人手机号码
			pstmt.setString(24,corp.getEmail());			//联系邮箱
			pstmt.setString(25,corp.getUrl());				//企业网址
			pstmt.setString(26,corp.getDescription());	//备注
			pstmt.setDate(27,new Date(new java.util.Date().getTime()));	//修改时间
			pstmt.setString(28, corp.getAssets());
			pstmt.setString(29, corp.getMachinery());
			pstmt.setString(30, corp.getSpare1());
			pstmt.setString(31, corp.getCheckForeign());
			pstmt.setString(32, corp.getEnterpriseType().replace(" ", ""));
			pstmt.setString(33,corp.getCorpId());	//主键
			checkNum1 = pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement("select * from TBCorpForeigninfo where corpId=?");
			pstmt.setString(1,corp.getCorpId());	
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				String foreignSql = "update TBCorpForeigninfo set CORPNAME=?,CORPCODE=?,"
						+ "foreignCorpName=?,nationNum=?,principalUnitNum=?,regPrin=?,percentTage=?,"
						+ "FOREIGNIVESTOR=?,MODIFYDATE=? where CORPID=? ";
				pstmt = conn.prepareStatement(foreignSql);
				pstmt.setString(1,corp.getCorpName());	//企业名称
				pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
				pstmt.setString(3,corp.getForeignCorpName());
				pstmt.setString(4,corp.getNationNume());
				pstmt.setString(5,corp.getPrincipalUnitNum());
				pstmt.setString(6,corp.getRegPrin());
				pstmt.setString(7,corp.getPercentTage());
				pstmt.setString(8,corp.getForeignIvestor());
				pstmt.setDate(9,new Date(new java.util.Date().getTime()));	//修改时间
				pstmt.setString(10,corp.getCorpId());
				checkNum2 = pstmt.executeUpdate();
			}else
			{
				pstmt = conn.prepareStatement("insert into TBCorpForeigninfo(CORPID,CORPNAME,CORPCODE,"
						+ "FOREIGNCORPNAME,NATIONNUM,PRINCIPALUNITNUM,REGPRIN,PERCENTTAGE,FOREIGNIVESTOR,"
						+ "CREATEDATE) "
						+ "values(?,?,?,?,?,?,?,?,?,?)");
				pstmt.setString(1,corp.getCorpId());	
				pstmt.setString(2,corp.getCorpName()); 
				pstmt.setString(3,corp.getCorpCode()); 
				pstmt.setString(4,corp.getForeignCorpName()); 
				pstmt.setString(5,corp.getNationNume()); 
				pstmt.setString(6,corp.getPrincipalUnitNum());
				pstmt.setString(7,corp.getRegPrin());
				pstmt.setString(8,corp.getPercentTage());
				pstmt.setString(9,corp.getForeignIvestor());
				pstmt.setDate(10,new Date(new java.util.Date().getTime())); //创建时间
				checkNum2 = pstmt.executeUpdate();
			}
			
			pstmt = conn.prepareStatement("update T_TBCORPBUSINESS set CORPNAME=?,CORPCODE=?,"
					+ "spare1=? where CORPID=?");
			pstmt.setString(1,corp.getCorpName());	//企业名称
			pstmt.setString(2,corp.getCorpCode()); 	//组织机构代码
			pstmt.setString(3, corp.getSpare1());
			pstmt.setString(4,corp.getCorpId());	//主键
			checkNum3 = pstmt.executeUpdate();
			
			conn.commit();
			if(checkNum1 > 0 && checkNum2 > 0 && checkNum3 > 0)
			{
				message = "企业修改成功!";
			}else
			{
				message = "企业修改失败!";
			}
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
		return message;
	}

	//修改企业类型
	public String modifyCorpType(Corp corp)
	{
		String message = "";
		int checkNum = 0;
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "update TBCorpBasicinfo set enterpriseType=? where CORPID=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, corp.getEnterpriseType());
			pstmt.setString(2,corp.getCorpId());	//主键
			checkNum = pstmt.executeUpdate();
			conn.commit();
			if(checkNum > 0)
			{
				message = "修改成功!";
			}else
			{
				message = "修改失败!";
			}
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
		return message;
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

	//建设单位跳转修改页面，查询一个企业基本信息
	@Override
	public Corp queryCorpCode1(String corpCode) {
		// TODO Auto-generated method stub
		Corp corp = new Corp();
		
		try {
			//判断企业是否有资质存在
			conn = ConnectionFactory.getQualityConnection();
			pstmt = conn.prepareStatement("select * from TBQUALIFICATIONAPPLY where corpCode=? " +
					" and (qualiftype='a' or qualiftype='1' or qualiftype='3' or qualiftype='5' or qualiftype='7' or qualiftype='9')");
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return null;
			}
			
			String qsql = "select * from V_TBCORPFOREIGNINFO where corpCode=?";
			//获取基础数据库链接，首先从基础数据库查询
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, corpCode);
			rs = pstmt.executeQuery();
			
			//如果基础数据库存在，返回不允许企业再次注册
			if(rs.next())
			{
				//如果数据库存在且未经过审批，返回修改页面
				corp.setCorpId(rs.getString("corpId"));		//主键	
				corp.setCorpName(rs.getString("corpName"));	//企业名称
				corp.setCorpCode(rs.getString("corpCode")); 	//组织机构代码
				corp.setLicenseNum(rs.getString("licenseNum"));//工商营业执照注册号
				corp.setProvinceNum(rs.getString("provinceNum"));//注册所在省(自治区、直辖市)(字典表：TBXZQDMDIC)
				corp.setCityNum(rs.getString("cityNum"));		//注册所在地(市、州、盟)(字典表：TBXZQDMDIC)
				corp.setCountyNum(rs.getString("countyNum"));	//注册所在县(区、市、旗)(字典表：TBXZQDMDIC)
				corp.setAddress(rs.getString("address"));		//企业营业地址
				corp.setPostalCode(rs.getString("postalCode"));//企业营业地址邮政编码
				corp.setLegalMan(rs.getString("legalMan"));	//法定代表人姓名
				corp.setIdCardTypeNum(rs.getString("idCardTypeNum"));//法定代表人证件类型(字典表：TBIDCARDTYPEDIC)
				corp.setLegalManIdCard(rs.getString("legalManIdCard"));//法定代表人证件号码
				corp.setLegalManDuty(rs.getString("legalManDuty"));//法定代表人职务
				corp.setLegaManProtitle(rs.getString("legaManProtitle"));//法定代表人职称
				corp.setEconomicNum(rs.getString("economicNum"));	//企业登记注册类型(字典表：TBECONTYPEDIC)
				corp.setRegPrin(rs.getString("regPrin")); 		//注册资本(万元)
				corp.setFactRegPrin(rs.getString("factRegPrin"));	//实收资本(万元)
				corp.setPrincipalUnitNum(rs.getString("principalUnitNum"));//注册资本币种(字典表：TBPRINCIPALUNITDIC)
				corp.setCorpBirthDate(rs.getDate("corpBirthDate"));//成立日期
				corp.setOfficePhone(rs.getString("officePhone"));//办公电话
				corp.setFax(rs.getString("fax"));				//传真号码
				corp.setLinkMan(rs.getString("linkMan")); 		//联系人姓名
				corp.setLinkTel(rs.getString("linkTel"));		//联系人办公电话
				corp.setLinkPhone(rs.getString("linkPhone"));	//联系人手机号码
				corp.setEmail(rs.getString("email"));			//联系邮箱
				corp.setUrl(rs.getString("url"));				//企业网址
				corp.setDescription(rs.getString("description"));	//备注
				corp.setAssets(rs.getString("assets"));	
				corp.setMachinery(rs.getString("machinery"));
				corp.setSpare1(rs.getString("spare1"));//企业归属地
				corp.setForeignCorpName(rs.getString("foreignCorpName"));//外商投资者名称
				corp.setNationNume(rs.getString("nationnum"));//国籍或地区(字典表：TBNATIONALDIC)
				corp.setPercentTage(rs.getString("percentTage"));//外商投资所占比例(%)
				corp.setForeignIvestor(rs.getString("foreignIvestor"));	//外商投资这类型         0:境外企业；1：境外自然人
				corp.setCheckForeign(rs.getString("checkForeign"));//是否外商投资	   0:是；1：否
				corp.setEnterpriseType(rs.getString("enterpriseType"));
				corp.setAppType(rs.getString("appType"));//审批标识
				
//				if(corp.getAppType()==null)
//				{
//					//如果审批标识为null,说明是老数据,不需要进行审批,跳转修改页面
//					corp.setCheckType(1);
//				}else if(corp.getAppType().equals("0"))
//				{
//					//如果审批标识为0,说明是新用户注册,未经过审批,跳转修改页面
//					corp.setCheckType(1);
//				}else if(corp.getAppType().equals("1"))
//				{
//					//如果审批标识为1,说明新用户经过审批,跳转登陆页面
//					corp.setCheckType(0);
//					corp.setMessage("您所查询的企业已经注册并经过审核，请使用UKey登陆！");
//				}else
//				{
//					//如果审批标识为2,说明新用户审批未通过,重新提交信息,跳转添加页面
//					corp.setCheckType(2);
//				}
//			}else
//			{
//				//数据库中不存在跳转添加页面
//				corp.setCheckType(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return corp;
	
	}
	
}
