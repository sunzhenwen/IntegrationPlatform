package com.tj.jst.inner.integrity.corpBadIntegrity.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tj.jst.base.connection.ConnectionFactory;
import com.tj.jst.base.dao.BaseDao;
import com.tj.jst.base.page.Condition;
import com.tj.jst.base.page.Page;
import com.tj.jst.inner.projectconstruction.model.ProjectConstruction;

/**
 * ��ѯ��Ŀ������Ϣ���ݿ���
 * 
 * @author DarkFlameMaster
 *
 */
public class QueryProjectInfoDaoImpl extends BaseDao implements
		IQueryProjectInfoDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	/**
	 * ��ҳ����
	 */
	@Override
	public Page queryPage(Condition condition) {
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
					project.setAddress(rs.getString("address"));
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

}
