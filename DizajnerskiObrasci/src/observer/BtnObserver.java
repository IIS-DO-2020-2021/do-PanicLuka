package observer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BtnObserver {
	
	private PropertyChangeSupport propertyChangeSupport; 
	
	private boolean btnDeleteActivated;
	private boolean btnSelectActivated;
	private boolean btnModifyActivated;
	
	private boolean btnBringToBackActivated;
	private boolean btnBringToFrontActivated;
	private boolean btnToBackActivated;
	private boolean btnToFrontActivated;
	
	public BtnObserver() {
		
		propertyChangeSupport = new PropertyChangeSupport(this);
	}
	
	public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.addPropertyChangeListener(propertyChangeListener);
	}

	public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {
		propertyChangeSupport.removePropertyChangeListener(propertyChangeListener);
	}

	public void setBtnDeleteActivated(boolean deleteBtnActivated) {
		propertyChangeSupport.firePropertyChange("deleteBtn", this.btnDeleteActivated, deleteBtnActivated);
		this.btnDeleteActivated = deleteBtnActivated;
	}

	public void setModifyBtnActivated(boolean modifyBtnActivated) {
		propertyChangeSupport.firePropertyChange("modifyBtn", this.btnModifyActivated, modifyBtnActivated);
		this.btnModifyActivated = modifyBtnActivated;
	}

	public void setSelectBtnActivated(boolean selectBtnActivated) {
		propertyChangeSupport.firePropertyChange("selectBtn", this.btnSelectActivated, selectBtnActivated);
		this.btnSelectActivated = selectBtnActivated;
	}



}
