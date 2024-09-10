import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class EventEmitter {
    private final PropertyChangeSupport support;

    public EventEmitter() {
        support = new PropertyChangeSupport(this);
    }

    public void addListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public void emitEvent(String event) {
        support.firePropertyChange("event", null, event);
    }
}

// Example usage