package pojo;

public class TBTenderInfo {
	private String 	FID;
	private String 	FBidID;
	private String 	FSectionID;
	private String  FSectionName;
	private String  PrjName;
	private String 	TenderNum;
	private String 	PrjNum;
	private String 	TenderClassNum;
	private String 	TenderTypeNum;
	private String 	TenderResultDate;
	private String 	TenderMoney;
	private String 	PrjSize;
	private String 	Area;
	private String 	AgencyCorpName;
	private String 	AgencyCorpCode;
	private String 	TenderCorpName;
	private String 	TenderCorpCode;
	private String 	ConstructorName;
	private String 	IDCardTypeNum;
	private String 	ConstructorIDCard;
	private String 	CreateDate;
	private String 	UpdateDate;
	private String  State;//0为传输  1已传输
	
	private String  PropietorCorpName;
	private String  PropietorCorpCode;
	private String  ProjectAddress;
	private String  ProjectCost;
	
	
	
	private String	TechnicalName;//技术负责人姓名
	private String	TechnicalIDCardTypeNum;//技术负责人证件类型
	private String	TechnicalIDCard;//技术负责人证件号码
	private String	TechnicalCertNum;//技术负责人证书号
	private String	QualityName;//质量检查员姓名
	private String	QualityIDCardTypeNum;//质量检查员证件类型
	private String	QualityIDCard;//质量检查员证件号码
	private String	QualityCertNum;//质量检查员证书号
	private String	SecurityName;//安全员姓名
	private String	SecurityIDCardTypeNum;//安全员证件类型
	private String	SecurityIDCard;//安全员证件号码
	private String	SecurityCertNum;//安全员证书号
	private String	ConstructionName;//施工员（工长）姓名
	private String	ConstructionIDCardTypeNum;//施工员（工长）证件类型
	private String	ConstructionIDCard;//施工员（工长）证件号码
	private String	ConstructionCertNum;//施工员（工长）证书号
	private String	DirectorName;//（监理人员）总监姓名
	private String	DirectorIDCardTypeNum;//（监理人员）总监证件类型
	private String	DirectorIDCard;//（监理人员）总监证件号码
	private String	DirectorCertNum;//（监理人员）总监证书号
	private String	RepresentativeName;//总监代表姓名
	private String	RepresentativeIDCardTypeNum;//总监代表证件类型
	private String	RepresentativeIDCard;//总监代表证件号码
	private String	RepresentativeCertNum;//总监代表证书号
	private String	SafetyName;//安全监理姓名
	private String	SafetyIDCardTypeNum;//安全监理证件类型
	private String	SafetyIDCard;//安全监理证件号码
	private String	SafetyCertNum;//安全监理证书号
	private String	Isdelete;//删除状态 0正常在用 1已删除
	
	public String getFID() {
		return FID;
	}
	public void setFID(String fID) {
		FID = fID;
	}
	public String getFBidID() {
		return FBidID;
	}
	public void setFBidID(String fBidID) {
		FBidID = fBidID;
	}
	public String getFSectionID() {
		return FSectionID;
	}
	public void setFSectionID(String fSectionID) {
		FSectionID = fSectionID;
	}
	public String getTenderNum() {
		return TenderNum;
	}
	public void setTenderNum(String tenderNum) {
		TenderNum = tenderNum;
	}
	public String getPrjNum() {
		return PrjNum;
	}
	public void setPrjNum(String prjNum) {
		PrjNum = prjNum;
	}
	public String getTenderClassNum() {
		return TenderClassNum;
	}
	public void setTenderClassNum(String tenderClassNum) {
		TenderClassNum = tenderClassNum;
	}
	public String getTenderTypeNum() {
		return TenderTypeNum;
	}
	public void setTenderTypeNum(String tenderTypeNum) {
		TenderTypeNum = tenderTypeNum;
	}
	public String getTenderResultDate() {
		return TenderResultDate;
	}
	public void setTenderResultDate(String tenderResultDate) {
		TenderResultDate = tenderResultDate;
	}
	public String getTenderMoney() {
		return TenderMoney;
	}
	public void setTenderMoney(String tenderMoney) {
		TenderMoney = tenderMoney;
	}
	public String getPrjSize() {
		return PrjSize;
	}
	public void setPrjSize(String prjSize) {
		PrjSize = prjSize;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getAgencyCorpName() {
		return AgencyCorpName;
	}
	public void setAgencyCorpName(String agencyCorpName) {
		AgencyCorpName = agencyCorpName;
	}
	public String getAgencyCorpCode() {
		return AgencyCorpCode;
	}
	public void setAgencyCorpCode(String agencyCorpCode) {
		AgencyCorpCode = agencyCorpCode;
	}
	public String getTenderCorpName() {
		return TenderCorpName;
	}
	public void setTenderCorpName(String tenderCorpName) {
		TenderCorpName = tenderCorpName;
	}
	public String getTenderCorpCode() {
		return TenderCorpCode;
	}
	public void setTenderCorpCode(String tenderCorpCode) {
		TenderCorpCode = tenderCorpCode;
	}
	public String getConstructorName() {
		return ConstructorName;
	}
	public void setConstructorName(String constructorName) {
		ConstructorName = constructorName;
	}
	public String getIDCardTypeNum() {
		return IDCardTypeNum;
	}
	public void setIDCardTypeNum(String iDCardTypeNum) {
		IDCardTypeNum = iDCardTypeNum;
	}
	public String getConstructorIDCard() {
		return ConstructorIDCard;
	}
	public void setConstructorIDCard(String constructorIDCard) {
		ConstructorIDCard = constructorIDCard;
	}
	public String getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(String createDate) {
		CreateDate = createDate;
	}
	public String getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(String updateDate) {
		UpdateDate = updateDate;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getFSectionName() {
		return FSectionName;
	}
	public void setFSectionName(String fSectionName) {
		FSectionName = fSectionName;
	}
	public String getPrjName() {
		return PrjName;
	}
	public void setPrjName(String prjName) {
		PrjName = prjName;
	}
	public String getTechnicalName() {
		return TechnicalName;
	}
	public void setTechnicalName(String technicalName) {
		TechnicalName = technicalName;
	}
	public String getTechnicalIDCardTypeNum() {
		return TechnicalIDCardTypeNum;
	}
	public void setTechnicalIDCardTypeNum(String technicalIDCardTypeNum) {
		TechnicalIDCardTypeNum = technicalIDCardTypeNum;
	}
	public String getTechnicalIDCard() {
		return TechnicalIDCard;
	}
	public void setTechnicalIDCard(String technicalIDCard) {
		TechnicalIDCard = technicalIDCard;
	}
	public String getTechnicalCertNum() {
		return TechnicalCertNum;
	}
	public void setTechnicalCertNum(String technicalCertNum) {
		TechnicalCertNum = technicalCertNum;
	}
	public String getQualityName() {
		return QualityName;
	}
	public void setQualityName(String qualityName) {
		QualityName = qualityName;
	}
	public String getQualityIDCardTypeNum() {
		return QualityIDCardTypeNum;
	}
	public void setQualityIDCardTypeNum(String qualityIDCardTypeNum) {
		QualityIDCardTypeNum = qualityIDCardTypeNum;
	}
	public String getQualityIDCard() {
		return QualityIDCard;
	}
	public void setQualityIDCard(String qualityIDCard) {
		QualityIDCard = qualityIDCard;
	}
	public String getQualityCertNum() {
		return QualityCertNum;
	}
	public void setQualityCertNum(String qualityCertNum) {
		QualityCertNum = qualityCertNum;
	}
	public String getSecurityName() {
		return SecurityName;
	}
	public void setSecurityName(String securityName) {
		SecurityName = securityName;
	}
	public String getSecurityIDCardTypeNum() {
		return SecurityIDCardTypeNum;
	}
	public void setSecurityIDCardTypeNum(String securityIDCardTypeNum) {
		SecurityIDCardTypeNum = securityIDCardTypeNum;
	}
	public String getSecurityIDCard() {
		return SecurityIDCard;
	}
	public void setSecurityIDCard(String securityIDCard) {
		SecurityIDCard = securityIDCard;
	}
	public String getSecurityCertNum() {
		return SecurityCertNum;
	}
	public void setSecurityCertNum(String securityCertNum) {
		SecurityCertNum = securityCertNum;
	}
	public String getConstructionName() {
		return ConstructionName;
	}
	public void setConstructionName(String constructionName) {
		ConstructionName = constructionName;
	}
	public String getConstructionIDCardTypeNum() {
		return ConstructionIDCardTypeNum;
	}
	public void setConstructionIDCardTypeNum(String constructionIDCardTypeNum) {
		ConstructionIDCardTypeNum = constructionIDCardTypeNum;
	}
	public String getConstructionIDCard() {
		return ConstructionIDCard;
	}
	public void setConstructionIDCard(String constructionIDCard) {
		ConstructionIDCard = constructionIDCard;
	}
	public String getConstructionCertNum() {
		return ConstructionCertNum;
	}
	public void setConstructionCertNum(String constructionCertNum) {
		ConstructionCertNum = constructionCertNum;
	}
	public String getDirectorName() {
		return DirectorName;
	}
	public void setDirectorName(String directorName) {
		DirectorName = directorName;
	}
	public String getDirectorIDCardTypeNum() {
		return DirectorIDCardTypeNum;
	}
	public void setDirectorIDCardTypeNum(String directorIDCardTypeNum) {
		DirectorIDCardTypeNum = directorIDCardTypeNum;
	}
	public String getDirectorIDCard() {
		return DirectorIDCard;
	}
	public void setDirectorIDCard(String directorIDCard) {
		DirectorIDCard = directorIDCard;
	}
	public String getDirectorCertNum() {
		return DirectorCertNum;
	}
	public void setDirectorCertNum(String directorCertNum) {
		DirectorCertNum = directorCertNum;
	}
	public String getRepresentativeName() {
		return RepresentativeName;
	}
	public void setRepresentativeName(String representativeName) {
		RepresentativeName = representativeName;
	}
	public String getRepresentativeIDCardTypeNum() {
		return RepresentativeIDCardTypeNum;
	}
	public void setRepresentativeIDCardTypeNum(String representativeIDCardTypeNum) {
		RepresentativeIDCardTypeNum = representativeIDCardTypeNum;
	}
	public String getRepresentativeIDCard() {
		return RepresentativeIDCard;
	}
	public void setRepresentativeIDCard(String representativeIDCard) {
		RepresentativeIDCard = representativeIDCard;
	}
	public String getRepresentativeCertNum() {
		return RepresentativeCertNum;
	}
	public void setRepresentativeCertNum(String representativeCertNum) {
		RepresentativeCertNum = representativeCertNum;
	}
	public String getSafetyName() {
		return SafetyName;
	}
	public void setSafetyName(String safetyName) {
		SafetyName = safetyName;
	}
	public String getSafetyIDCardTypeNum() {
		return SafetyIDCardTypeNum;
	}
	public void setSafetyIDCardTypeNum(String safetyIDCardTypeNum) {
		SafetyIDCardTypeNum = safetyIDCardTypeNum;
	}
	public String getSafetyIDCard() {
		return SafetyIDCard;
	}
	public void setSafetyIDCard(String safetyIDCard) {
		SafetyIDCard = safetyIDCard;
	}
	public String getPropietorCorpName() {
		return PropietorCorpName;
	}
	public void setPropietorCorpName(String propietorCorpName) {
		PropietorCorpName = propietorCorpName;
	}
	public String getPropietorCorpCode() {
		return PropietorCorpCode;
	}
	public void setPropietorCorpCode(String propietorCorpCode) {
		PropietorCorpCode = propietorCorpCode;
	}
	public String getProjectAddress() {
		return ProjectAddress;
	}
	public void setProjectAddress(String projectAddress) {
		ProjectAddress = projectAddress;
	}
	public String getProjectCost() {
		return ProjectCost;
	}
	public void setProjectCost(String projectCost) {
		ProjectCost = projectCost;
	}
	public String getSafetyCertNum() {
		return SafetyCertNum;
	}
	public void setSafetyCertNum(String safetyCertNum) {
		SafetyCertNum = safetyCertNum;
	}
	public String getIsdelete() {
		return Isdelete;
	}
	public void setIsdelete(String isdelete) {
		Isdelete = isdelete;
	}
}
