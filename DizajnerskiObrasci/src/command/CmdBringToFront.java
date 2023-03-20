package command;

import java.util.Collections;

import geometry.Shape;
import mvc.DrawingModel;

public class CmdBringToFront implements Command {
	private DrawingModel model;
	private Shape shape;
	
	private int last;
	private int index;

	public CmdBringToFront(DrawingModel model, Shape shape) {
		this.model = model;
		this.shape = shape;
		index = model.getShapes().indexOf(shape);
		last = model.getShapes().size() - 1;
	}

	@Override
	public void execute() {
		for (int i = index; i < last; i++) {
			Collections.swap(model.getShapes(), i, i + 1);
		}
		

	}

	@Override
	public void unexecute() {
		for (int i = last; i > index; i--) {
			Collections.swap(model.getShapes(), i, i - 1);
		}

	}

	@Override
	public String toString() {
		return "Brought to front --> " + this.shape + "\n";
	}
}
