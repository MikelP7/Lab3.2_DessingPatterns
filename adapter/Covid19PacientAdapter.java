package adapter;
import java.util.ArrayList;
import java.util.List;

import domain.*;

public class Covid19PacientAdapter implements InvertedIterator {
	
    private List<Symptom> symptomsList;
    private int index;

    public Covid19PacientAdapter(Covid19Pacient pacient) {
        this.symptomsList = new ArrayList<>(pacient.getSymptoms());
        this.index = symptomsList.size();
    }

    public void goLast() {
        index = symptomsList.size() - 1;
    }

    public boolean hasPrevious() {
        return index >= 0;
    }

    public Object previous() {
        if (!hasPrevious()) {
        	return null;
        }
        return symptomsList.get(index--);
    }
}
