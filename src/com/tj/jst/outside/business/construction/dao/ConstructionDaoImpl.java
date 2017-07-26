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
 * ��Ŀ����
 * @author hhc
 *
 */
public class ConstructionDaoImpl extends BaseDao implements IConstructionDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ResultSet uploadRs = null;
	
	/**
	 * ��ѯ
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
					
					construction.setPrjId(rs.getString("prjId"));//����
					construction.setPrjNum(rs.getString("prjNum"));//��Ŀ���
					construction.setPrjName(rs.getString("prjName"));//��Ŀ����
					construction.setPrjTypeNum(rs.getString("prjTypeNum"));//��Ŀ����(�ֵ��TBPRJTYPEDIC)
					construction.setPrjTypeName(rs.getString("prjTypeName"));
					construction.setBuildCorpName(rs.getString("buildCorpName"));//���赥λ����
					construction.setBuildCorpCode(rs.getString("buildCorpCode"));//���赥λ��֯��������
					construction.setProvinceNum(rs.getString("provinceNum"));//��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
					construction.setProvinceName(rs.getString("provinceName"));
					construction.setCityNum(rs.getString("cityNum"));//��Ŀ������(�ֵ��TBXZQDMDIC)
					construction.setCityName(rs.getString("cityName"));
					construction.setCountyNum(rs.getString("countyNum"));//��Ŀ��������(�ֵ��TBXZQDMDIC)
					construction.setCountyName(rs.getString("countyName"));
					construction.setPrjApprovalNum(rs.getString("prjApprovalNum"));//�����ĺ�
					construction.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));//�����
					construction.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
					construction.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
					construction.setAllInvest(rs.getString("allInvest"));//��Ͷ�ʣ���Ԫ��
					construction.setAllArea(rs.getString("allArea"));//�������ƽ���ף�
					construction.setPrjSize(rs.getString("prjSize"));//�����ģ
					construction.setPrjPropertyNum(rs.getString("prjPropertyNum"));//��������(�ֵ��TBPRJPORPERTYDIC)
					construction.setPrjFuncitonNum(rs.getString("PRJFUNCTIONNUM"));//������;(�ֵ��TBPRJFUNCTIONDIC)
					construction.setBDate(rs.getDate("bDate"));//ʵ�ʿ������ڣ�������������ΪM
					construction.setEDate(rs.getDate("eDate"));//ʵ�ʿ����������ڣ�������������ΪM
					construction.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
					/**
					 * ����״̬
					 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
					 */
					construction.setAppType(rs.getString("appType").trim());//����״̬
					/**
					 * ���̲���
					 * 1:��Ŀ����
					 * 2:����׶Ρ���ƽ׶�
					 * 3:��ͬ������ʩ��ͼ��鱸��
					 * 4:�����ල����ȫ�ල
					 * 5:ʩ�����
					 * 6:��������
					 */
					construction.setProcessSteps(rs.getString("processSteps"));
					construction.setAppDept(rs.getString("appDept"));//������λid
					construction.setAppDeptName(rs.getString("appDeptName"));//������λ����
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
	 * ��ӱ���
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
			pstmt.setString(1,prjId);	//����
			pstmt.setString(2, construction.getPrjNum());//��Ŀ���
			pstmt.setString(3, construction.getPrjName()); //��Ŀ����
			pstmt.setString(4, construction.getPrjTypeNum()); //��Ŀ����(�ֵ��TBPRJTYPEDIC)
			pstmt.setString(5, construction.getBuildCorpName()); //���赥λ����
			pstmt.setString(6, construction.getBuildCorpCode()); //���赥λ��֯��������
			pstmt.setInt(7, Integer.parseInt(construction.getProvinceNum())); //��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setInt(8, Integer.parseInt(construction.getCityNum())); //��Ŀ������(�ֵ��TBXZQDMDIC)
			pstmt.setInt(9, Integer.parseInt(construction.getCountyNum())); //��Ŀ��������(�ֵ��TBXZQDMDIC)
			pstmt.setString(10, construction.getPrjApprovalNum()); //�����ĺ�
			pstmt.setString(11, construction.getPrjApprovalLevelNum()); //�����
			pstmt.setString(12, construction.getBuldPlanNum()); //�����õع滮���֤���
			pstmt.setString(13, construction.getProjectPlanNum()); //���蹤�̹滮���֤���
			pstmt.setDouble(14, Double.parseDouble(construction.getAllInvest())); //��Ͷ�ʣ���Ԫ��
			pstmt.setDouble(15, Double.parseDouble(construction.getAllArea())); //�������ƽ���ף�
			pstmt.setString(16, construction.getPrjSize()); //�����ģ
			pstmt.setString(17, construction.getPrjPropertyNum()); //��������(�ֵ��TBPRJPORPERTYDIC)
			pstmt.setString(18, construction.getPrjFuncitonNum()); //������;(�ֵ��TBPRJFUNCTIONDIC)
			pstmt.setDate(19, construction.getBDate());//ʵ�ʿ������ڣ�������������ΪM
			pstmt.setDate(20, construction.getEDate());//ʵ�ʿ����������ڣ�������������ΪM
			pstmt.setDate(21, new Date(new java.util.Date().getTime()));//��¼�Ǽ�ʱ��
			/**
			 * ����״̬
			 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(22, "0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(23, "1");
			pstmt.setString(24, construction.getAppDept().trim());//������λid
			pstmt.setString(25, construction.getAppDeptName());//������λ����
			pstmt.setString(26, construction.getAddress());//�����ַ
			pstmt.setString(27, construction.getProjectManager());//���赥λ��Ŀ������
			pstmt.setString(28, construction.getUnitPhone());//���赥λ��ϵ�绰
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public Construction queryById(String prjId)
	{

		Construction construction = new Construction();
		try {
			
			String qsql = "select * from V_TBPROJECTINFO_S where prjId=?";
			//��ȡ�������ݿ����ӣ����ȴӻ������ݿ��ѯ
			conn = ConnectionFactory.getBasicConnection();
			pstmt = conn.prepareStatement(qsql);
			pstmt.setString(1, prjId);
			rs = pstmt.executeQuery();
			
			//����������ݿ���ڣ����ز�������ҵ�ٴ�ע��
			if(rs.next())
			{
				construction.setPrjId(rs.getString("prjId"));//����
				construction.setPrjNum(rs.getString("prjNum"));//��Ŀ���
				construction.setPrjName(rs.getString("prjName"));//��Ŀ����
				construction.setPrjTypeNum(rs.getString("prjTypeNum").trim());//��Ŀ����(�ֵ��TBPRJTYPEDIC)
				construction.setPrjTypeName(rs.getString("prjTypeName"));
				construction.setBuildCorpName(rs.getString("buildCorpName"));//���赥λ����
				construction.setBuildCorpCode(rs.getString("buildCorpCode"));//���赥λ��֯��������
				construction.setProvinceNum(rs.getString("provinceNum"));//��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
				construction.setProvinceName(rs.getString("provinceName"));
				construction.setCityNum(rs.getString("cityNum"));//��Ŀ������(�ֵ��TBXZQDMDIC)
				construction.setCityName(rs.getString("cityName"));
				construction.setCountyNum(rs.getString("countyNum"));//��Ŀ��������(�ֵ��TBXZQDMDIC)
				construction.setCountyName(rs.getString("countyName"));
				construction.setPrjApprovalNum(rs.getString("prjApprovalNum"));//�����ĺ�
				construction.setPrjApprovalLevelNum(rs.getString("prjApprovalLevelNum"));//�����
				construction.setBuldPlanNum(rs.getString("buldPlanNum"));//�����õع滮���֤���
				construction.setProjectPlanNum(rs.getString("projectPlanNum"));//���蹤�̹滮���֤���
				construction.setAllInvest(rs.getString("allInvest"));//��Ͷ�ʣ���Ԫ��
				construction.setAllArea(rs.getString("allArea"));//�������ƽ���ף�
				construction.setPrjSize(rs.getString("prjSize"));//�����ģ
				construction.setPrjPropertyNum(rs.getString("prjPropertyNum").trim());//��������(�ֵ��TBPRJPORPERTYDIC)
				construction.setPrjFuncitonNum(rs.getString("PRJFUNCTIONNUM").trim());//������;(�ֵ��TBPRJFUNCTIONDIC)
				construction.setBDate(rs.getDate("BDate"));//ʵ�ʿ������ڣ�������������ΪM
				construction.setEDate(rs.getDate("EDate"));//ʵ�ʿ����������ڣ�������������ΪM
				construction.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				/**
				 * ����״̬
				 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
				 */
				construction.setAppType(rs.getString("appType").trim());//����״̬
				/**
				 * ���̲���
				 * 1:��Ŀ����
				 * 2:����׶Ρ���ƽ׶�
				 * 3:��ͬ������ʩ��ͼ��鱸��
				 * 4:�����ල����ȫ�ල
				 * 5:ʩ�����
				 * 6:��������
				 */
				construction.setProcessSteps(rs.getString("processSteps").trim());
				construction.setAppDept(rs.getString("appDept").trim());//������λid
				construction.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
				construction.setAddress(rs.getString("address"));//�����ַ
				construction.setProjectManager(rs.getString("PROJECTMANAGER"));//���赥λ��Ŀ������
				construction.setUnitPhone(rs.getString("UNITPHONE"));//���赥λ��ϵ�绰
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
	 * �޸ı���
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
			pstmt.setString(1, construction.getPrjNum());//��Ŀ���
			pstmt.setString(2, construction.getPrjName()); //��Ŀ����
			pstmt.setString(3, construction.getPrjTypeNum()); //��Ŀ����(�ֵ��TBPRJTYPEDIC)
			pstmt.setString(4, construction.getBuildCorpName()); //���赥λ����
			pstmt.setString(5, construction.getBuildCorpCode()); //���赥λ��֯��������
			pstmt.setInt(6, Integer.parseInt(construction.getProvinceNum())); //��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setInt(7, Integer.parseInt(construction.getCityNum())); //��Ŀ������(�ֵ��TBXZQDMDIC)
			pstmt.setInt(8, Integer.parseInt(construction.getCountyNum())); //��Ŀ��������(�ֵ��TBXZQDMDIC)
			pstmt.setString(9, construction.getPrjApprovalNum()); //�����ĺ�
			pstmt.setString(10, construction.getPrjApprovalLevelNum()); //�����
			pstmt.setString(11, construction.getBuldPlanNum()); //�����õع滮���֤���
			pstmt.setString(12, construction.getProjectPlanNum()); //���蹤�̹滮���֤���
			pstmt.setDouble(13, Double.parseDouble(construction.getAllInvest())); //��Ͷ�ʣ���Ԫ��
			pstmt.setDouble(14, Double.parseDouble(construction.getAllArea())); //�������ƽ���ף�
			pstmt.setString(15, construction.getPrjSize()); //�����ģ
			pstmt.setString(16, construction.getPrjPropertyNum()); //��������(�ֵ��TBPRJPORPERTYDIC)
			pstmt.setString(17, construction.getPrjFuncitonNum()); //������;(�ֵ��TBPRJFUNCTIONDIC)
			pstmt.setDate(18, construction.getBDate());//ʵ�ʿ������ڣ�������������ΪM
			pstmt.setDate(19, construction.getEDate());//ʵ�ʿ����������ڣ�������������ΪM
			/**
			 * ����״̬
			 * ��Ŀ������0�����룬1������ͨ����2������δͨ��
			 */
			pstmt.setString(20, "0");//����״̬
			/**
			 * ���̲���
			 * 1:��Ŀ����
			 * 2:����׶Ρ���ƽ׶�
			 * 3:��ͬ������ʩ��ͼ��鱸��
			 * 4:�����ල����ȫ�ල
			 * 5:ʩ�����
			 * 6:��������
			 */
			pstmt.setString(21, "1");
			pstmt.setString(22, construction.getAppDept().trim());//������λid
			pstmt.setString(23, construction.getAppDeptName());//������λ����
			pstmt.setString(24, construction.getAddress());//�����ַ
			pstmt.setString(25, construction.getProjectManager());//���赥λ��Ŀ������
			pstmt.setString(26, construction.getUnitPhone());//���赥λ��ϵ�绰
			pstmt.setString(27,construction.getPrjId());	//����
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
	 * ɾ��
	 * @return
	 */
	public void delete(String id)
	{
		try {
			conn = ConnectionFactory.getBasicConnection();
			conn.setAutoCommit(false);
			String sql = "delete from TBPROJECTINFO_S where prjId=? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);//����
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
	
	//��Ŀ����(�ֵ��TBPRJTYPEDIC)
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
	//��������(�ֵ��TBPRJPROPERTYDIC)
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
	//������;(�ֵ��TBPRJFUNCTIONDIC)
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
	 * ��ѯ��������
	 * @param construction
	 * @return
	 */
	public List<Regional> queryAppDept()
	{
		//��ѯ������
		String sql = "select * from TBXZQDMDIC_APP where name like '%������%'";
		List<Regional> list = new ArrayList<Regional>();
		//ʡId
		String prId = "";
		//��Id
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
			//��ѯ��
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
			//��ѯ����
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
					//ɭ��
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
					//ũ��
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
	 * ������������id��ѯ�������
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
	
	//��ѯʡ
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

	//��ѯ��
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

	//��ѯ��
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
	//�����
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
