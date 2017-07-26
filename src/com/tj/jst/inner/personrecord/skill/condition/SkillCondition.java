package com.tj.jst.inner.personrecord.skill.condition;

import com.tj.jst.base.page.Condition;

/**
 * ������Ա��ҳ��
 * 
 * @author DarkFlameMaster
 *
 */
public class SkillCondition extends Condition {
	// ��Ա����
	private String personName;
	// ���֤����
	private String identityCard;
	// ������Ա����
	private String skilledTypeNum;
	// ������Ա����
	private String skilledLevelNum;
	// ��Ա���ڹ�˾����
	private String corpName;

	public SkillCondition() {

	}

	@Override
	public String getInitialSql() {
		// TODO Auto-generated method stub
		// ��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (personName != null && !"".equals(personName)) {
			sb.append(" and personName like '" + personName.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '" + corpName.trim() + "%'");
		}
		if (identityCard != null && !"".equals(identityCard)) {
			sb.append(" and identityCard like '" + identityCard.trim() + "%'");
		}
		if (skilledLevelNum != null && !"".equals(skilledLevelNum)) {
			sb.append(" and SKILLEDLEVELNUM = '"
					+ Integer.parseInt(skilledLevelNum.trim()) + "'");
		}
		if (skilledTypeNum != null && !"".equals(skilledTypeNum)) {
			sb.append(" and SKILLEDTYPENUM = '"
					+ Integer.parseInt(skilledTypeNum.trim()) + "'");
		}
		String sql = "select * from V_SKILLEDWORKER" + sb.toString();
		return sql;
	}

	@Override
	public String getCountSql() {
		// TODO Auto-generated method stub//��������
		// this.setOrderByItem("onIsTop desc,onPbsStartTime desc");
		// ��ѯ��ǰ���õ�λ��
		StringBuffer sb = new StringBuffer(" where 1=1 ");
		if (personName != null && !"".equals(personName)) {
			sb.append(" and personname like '" + personName.trim() + "%'");
		}
		if (corpName != null && !"".equals(corpName)) {
			sb.append(" and corpName like '" + corpName.trim() + "%'");
		}
		if (identityCard != null && !"".equals(identityCard)) {
			sb.append(" and identityCard like '" + identityCard.trim() + "%'");
		}
		if (skilledLevelNum != null && !"".equals(skilledLevelNum)) {
			sb.append(" and SKILLEDLEVELNUM = '"
					+ Integer.parseInt(skilledLevelNum.trim()) + "'");
		}
		if (skilledTypeNum != null && !"".equals(skilledTypeNum)) {
			sb.append(" and SKILLEDTYPENUM = '"
					+ Integer.parseInt(skilledTypeNum.trim()) + "'");
		}

		String sqlCount = "select count(*) from V_SKILLEDWORKER"
				+ sb.toString();
		return sqlCount;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getSkilledTypeNum() {
		return skilledTypeNum;
	}

	public void setSkilledTypeNum(String skilledTypeNum) {
		this.skilledTypeNum = skilledTypeNum;
	}

	public String getSkilledLevelNum() {
		return skilledLevelNum;
	}

	public void setSkilledLevelNum(String skilledLevelNum) {
		this.skilledLevelNum = skilledLevelNum;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

}
