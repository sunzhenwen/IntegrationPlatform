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
 * ��Ŀ�����޸�,���ܲ����޸�
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
	 * ��ҳ��ѯ
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
					project.setPrjId(rs.getString("prjId"));// ����
					project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
					project.setPrjName(rs.getString("prjName"));// ��Ŀ����
					project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
					project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
					project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
					project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
					project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
					project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
					project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
					project.setPrjApprovalLevelNum(rs// �����
							.getString("prjApprovalLevelNum"));
					project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
					project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
					project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
					project.setAllArea(rs.getString("allArea"));// �����
					project.setPrjSize(rs.getString("prjSize"));// �����ģ
					project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
					project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// ������;
					project.setBeginDate(rs.getDate("bDate"));// ��ʼʱ��
					project.setEndDate(rs.getDate("eDate"));// ����ʱ��
					project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
					project.setAppType(rs.getString("appType"));
					project.setProcessSteps(rs.getString("processSteps"));
					project.setProjectManager(rs.getString("projectManager"));// ���赥λ��Ŀ������
					project.setUnitPhone(rs.getString("unitPhone"));// ���赥λ��ϵ�绰
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
	 * ��ת�޸�ҳ��
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
				project.setPrjId(rs.getString("prjId"));// ����
				project.setPrjNum(rs.getString("prjNum"));// ��Ŀ���
				project.setPrjName(rs.getString("prjName"));// ��Ŀ����
				project.setPrjTypeName(rs.getString("prjTypeName"));// ��Ŀ����
				project.setPrjTypeNum(rs.getString("prjTypeNum"));// ��Ŀ����
				project.setBuildCorpName(rs.getString("buildCorpName"));// ���赥λ����
				project.setBuildCorpCode(rs.getString("buildCorpCode"));// ���赥λ��֯��������֤
				project.setProvinceName(rs.getString("provinceName"));// ��Ŀ����ʡ
				project.setProvinceNum(rs.getString("provinceNum"));// ��Ŀ����ʡ
				project.setCityName(rs.getString("cityName"));// ��Ŀ������
				project.setCityNum(rs.getString("cityNum"));// ��Ŀ������
				project.setCountyName(rs.getString("countyName"));// ��Ŀ������
				project.setCountyNum(rs.getString("countyNum"));// ��Ŀ������
				project.setPrjApprovalNum(rs.getString("prjApprovalNum"));// �����ĺ�
				project.setPrjApprovalLevelName(rs// �����
						.getString("prjApprovalLevelName"));
				project.setPrjApprovalLevelNum(rs// �����
						.getString("prjApprovalLevelNum"));
				project.setBuldPlanNum(rs.getString("buldPlanNum"));// �����õع滮���֤���
				project.setProjectPlanNum(rs.getString("projectPlanNum"));// ���蹤�̹滮���֤���
				project.setAllInvest(rs.getString("allInvest"));// ��Ͷ��
				project.setAllArea(rs.getString("allArea"));// �����
				project.setPrjSize(rs.getString("prjSize"));// �����ģ
				project.setPrjPropertyName(rs.getString("prjPropertyName"));// ��������
				project.setPrjPropertyNum(rs.getString("prjPropertyNum"));// ��������
				project.setPrjFunctionName(rs.getString("prjFunctionName"));// ������;
				project.setPrjFunctionNum(rs.getString("prjFunctionNum"));// ������;
				project.setBeginDate(rs.getDate("bDate"));// ��ʼʱ��
				project.setEndDate(rs.getDate("eDate"));// ����ʱ��
				project.setCreateDate(rs.getDate("createDate"));// ��¼�Ǽ�ʱ��
				project.setAppDept(rs.getString("appDept"));// ��ȡ����PrjNum��ֵ
				project.setAppType(rs.getString("appType"));
				project.setProcessSteps(rs.getString("processSteps"));
				project.setAddress(rs.getString("address"));
				project.setProjectManager(rs.getString("projectManager"));// ���赥λ��Ŀ������
				project.setUnitPhone(rs.getString("unitPhone"));// ���赥λ��ϵ�绰
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
	 * �޸�
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
			pstmt.setString(1, project.getPrjName()); //��Ŀ����
			pstmt.setString(2, project.getPrjTypeNum()); //��Ŀ����(�ֵ��TBPRJTYPEDIC)
			pstmt.setString(3, project.getBuildCorpName()); //���赥λ����
			pstmt.setString(4, project.getBuildCorpCode()); //���赥λ��֯��������
			pstmt.setInt(5, Integer.parseInt(project.getProvinceNum())); //��Ŀ����ʡ(�ֵ��TBXZQDMDIC)
			pstmt.setInt(6, Integer.parseInt(project.getCityNum())); //��Ŀ������(�ֵ��TBXZQDMDIC)
			pstmt.setInt(7, Integer.parseInt(project.getCountyNum())); //��Ŀ��������(�ֵ��TBXZQDMDIC)
			pstmt.setString(8, project.getPrjApprovalNum()); //�����ĺ�
			pstmt.setString(9, project.getPrjApprovalLevelNum()); //�����
			pstmt.setString(10, project.getBuldPlanNum()); //�����õع滮���֤���
			pstmt.setString(11, project.getProjectPlanNum()); //���蹤�̹滮���֤���
			pstmt.setDouble(12, Double.parseDouble(project.getAllInvest())); //��Ͷ�ʣ���Ԫ��
			pstmt.setDouble(13, Double.parseDouble(project.getAllArea())); //�������ƽ���ף�
			pstmt.setString(14, project.getPrjSize()); //�����ģ
			pstmt.setString(15, project.getPrjPropertyNum()); //��������(�ֵ��TBPRJPORPERTYDIC)
			pstmt.setString(16, project.getPrjFunctionNum()); //������;(�ֵ��TBPRJFUNCTIONDIC)
			pstmt.setDate(17, project.getBeginDate());//ʵ�ʿ������ڣ�������������ΪM
			pstmt.setDate(18, project.getEndDate());//ʵ�ʿ����������ڣ�������������ΪM
			pstmt.setString(19, project.getAddress());//�����ַ
			pstmt.setString(20,project.getPrjId());	//����
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
