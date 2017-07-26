package com.tj.jst.inner.accessory.action;

import java.util.List;

import com.tj.jst.base.action.BaseAction;
import com.tj.jst.base.util.dictionary.DictionaryClass;
import com.tj.jst.inner.accessory.condition.AccessoryCondition;
import com.tj.jst.inner.accessory.model.Accessory;
import com.tj.jst.inner.accessory.service.AccessoryServiceImol;
import com.tj.jst.inner.accessory.service.IAccessoryService;
import com.tj.jst.login.model.Login;

/**
 * ��������
 * 
 * @author Administrator
 *
 */
public class AccessoryAction extends BaseAction {

	private String id;// ����
	private String message;// ��ʾ��Ϣ
	private Accessory accessory;// model
	private List<DictionaryClass> linkNames;

	private AccessoryCondition condition = new AccessoryCondition(
			((Login) this.get("login")).getDepartmentID());

	public void setCondition(AccessoryCondition condition) {
		this.condition = condition;
	}

	public AccessoryCondition getCondition() {
		AccessoryCondition sessionCondition = (AccessoryCondition) get(getActionName());
		if (sessionCondition != null) {
			condition = sessionCondition;
		}
		return condition;
	}

	/**
	 * ��ҳ��ѯ
	 * 
	 * @return
	 */
	public String queryPage() {
		IAccessoryService service = new AccessoryServiceImol();
		currentPage = service.queryPage(condition);
		linkNames = service.queryLinkName();
		this.set(getActionName(), condition);
		return "queryPage";
	}

	/**
	 * ����ҳ��
	 * 
	 * @return
	 */
	public String addPage() {
		IAccessoryService service = new AccessoryServiceImol();
		linkNames = service.queryLinkName();
		return "addPage";
	}

	/**
	 * ���ӷ���
	 * 
	 * @return
	 */
	public String addMethod() {
		IAccessoryService service = new AccessoryServiceImol();
//		Login login = (Login) this.get("login");
//		accessory.setDepartmentId(login.getDepartmentID());
		message = service.addPage(accessory);
		return "query";
	}

	/**
	 * �޸�ҳ��
	 * 
	 * @return
	 */
	public String modifyPage() {
		IAccessoryService service = new AccessoryServiceImol();
		accessory = service.queryById(id);
		linkNames = service.queryLinkName();
		return "modifyPage";
	}

	/**
	 * �޸ķ���
	 * 
	 * @return
	 */
	public String modifyMethod() {
		IAccessoryService service = new AccessoryServiceImol();
		message = service.modifyPage(accessory);
		return "query";
	}

	/**
	 * ɾ������
	 * 
	 * @return
	 */
	public String deleteMethod() {
		IAccessoryService service = new AccessoryServiceImol();
		message = service.deletePage(id);
		return "query";
	}

	/**
	 * ����
	 * 
	 * @return
	 */
	public String goBack() {
		return "query";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}

	public List<DictionaryClass> getLinkNames() {
		return linkNames;
	}

	public void setLinkNames(List<DictionaryClass> linkNames) {
		this.linkNames = linkNames;
	}

}
