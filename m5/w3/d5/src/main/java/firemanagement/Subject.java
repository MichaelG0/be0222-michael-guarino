package firemanagement;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public abstract class Subject {
	private List<IObserver> observers = new ArrayList<IObserver>();

	public void register(IObserver o) {
		this.getObservers().add(o);
	}

	public void notifyObservers() {
		for (IObserver obs : this.getObservers()) {
			obs.update(this);
		}
	}

}
