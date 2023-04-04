package observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import mvc.DrawingFrame;

public class UpdateBtnObserver implements PropertyChangeListener {

	private DrawingFrame frame;

	public UpdateBtnObserver(DrawingFrame frame) {
		this.frame = frame;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if (evt.getPropertyName().equals("selectBtn")) {
			frame.getBtnSelect().setEnabled((boolean) evt.getNewValue());
		}
		if (evt.getPropertyName().equals("deleteBtn")) {
			frame.getBtnDelete().setEnabled((boolean) evt.getNewValue());
		}
		if (evt.getPropertyName().equals("modifyBtn")) {
			frame.getBtnModify().setEnabled((boolean) evt.getNewValue());
		}

	}
}
