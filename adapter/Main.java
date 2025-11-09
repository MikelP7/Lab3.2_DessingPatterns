package adapter;

import java.util.Iterator;

import domain.Covid19Pacient;
import domain.Symptom;

public class Main {

	public static void main(String[] args) {
		
		Covid19Pacient pacient = new Covid19Pacient("ana", 35);

		pacient.addSymptomByName("disnea", 2);
		pacient.addSymptomByName("cefalea", 1);
		pacient.addSymptomByName("astenia", 3);
		
		pacient.addSymptomByName("mareos", 1);
		pacient.addSymptomByName("nauseas", 2);
		pacient.addSymptomByName("vómitos", 3);

        
		InvertedIterator adapter = new Covid19PacientAdapter(pacient);

        System.out.println("Ordenados por nombre:");
        Iterator<Object> itName = Sorting.sortedIterator(adapter, new SymptomNameComparator());
        while (itName.hasNext()) {
            Symptom s = (Symptom) itName.next();
            System.out.println(s.getName());
        }
        

        System.out.println("\nOrdenados por severidad:");
        Iterator<Object> itSeverity = Sorting.sortedIterator(adapter, new SymptomSeverityComparator());
        while (itSeverity.hasNext()) {
            Symptom s = (Symptom) itSeverity.next();
            System.out.println(s.getName() + " - severidad: " + s.getSeverityIndex());
        }
	}

}
