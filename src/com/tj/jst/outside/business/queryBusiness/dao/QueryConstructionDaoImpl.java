package com.tj.jst.outside.business.queryBusiness.dao;

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
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.outside.business.construction.model.Construction;
import com.tj.jst.outside.business.construction.model.Regional;
import com.tj.jst.outside.business.upload.model.Upload;

/**
 * ��Ŀ����
 * @author hhc
 *
 */
public class QueryConstructionDaoImpl extends BaseDao implements IQueryConstructionDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
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
					construction.setProcessSteps(rs.getString("processSteps").trim());
					construction.setAppDept(rs.getString("appDept").trim());//������λid
					construction.setAppDeptName(rs.getString("appDeptName").trim());//������λ����
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
				construction.setBDate(rs.getDate("BDate"));//ʵ�ʿ������ڣ�������������ΪM
				construction.setEDate(rs.getDate("EDate"));//ʵ�ʿ����������ڣ�������������ΪM
				construction.setCreateDate(rs.getDate("createDate"));//��¼�Ǽ�ʱ��
				construction.setAddress(rs.getString("address"));
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
				construction.setProjectManager(rs.getString("projectManager"));
				construction.setUnitPhone(rs.getString("unitPhone"));
			}
			
			pstmt = conn.prepareStatement("select * from UPLOAD_FILE where id=?");
			pstmt.setString(1,prjId);
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
			construction.setList(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			ConnectionFactory.closeConn(conn, pstmt, rs);
		}
		return construction;
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
			pstmt = conn.prepareStatement("select * from TBXZQDMDIC_APP where (sortnum like '400%00' and sortnum !='400000') or (sortnum like '4000%' and sortnum !='400000') or (sortnum like '40%000' and sortnum !='400000')");
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
	
}
