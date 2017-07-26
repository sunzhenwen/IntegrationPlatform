package pojo;

public class TBTenderPersonInfo {
	
	private String	fid;
	private String	TenderNum;
	private String  UserName;
	private String  IDCard;
	private String  CorpName;
	private String  CorpCode;
	private String  PersonType;
	private String  CertID;
	private String  State;
	private String	Isdelete;//删除状态 0正常在用 1已删除
	public String getTenderNum() {
		return TenderNum;
	}
	public void setTenderNum(String tenderNum) {
		TenderNum = tenderNum;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getIDCard() {
		return IDCard;
	}
	public void setIDCard(String iDCard) {
		IDCard = iDCard;
	}
	public String getCorpName() {
		return CorpName;
	}
	public void setCorpName(String corpName) {
		CorpName = corpName;
	}
	public String getCorpCode() {
		return CorpCode;
	}
	public void setCorpCode(String corpCode) {
		CorpCode = corpCode;
	}
	public String getPersonType() {
		return PersonType;
	}
	public void setPersonType(String personType) {
		PersonType = personType;
	}
	public String getCertID() {
		return CertID;
	}
	public void setCertID(String certID) {
		CertID = certID;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getIsdelete() {
		return Isdelete;
	}
	public void setIsdelete(String isdelete) {
		Isdelete = isdelete;
	}


}
