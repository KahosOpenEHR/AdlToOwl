package utility;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
   
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import adl2owl.translator.EvaluationTranslator;
import adl2owl.translator.ObservationTranslator;

public class Test {

	public static void main(String[] args) throws OWLOntologyStorageException, OWLOntologyCreationException, FileNotFoundException {

		//String nomFich="/Users/Irene/Desktop/openEHR-EHR-EVALUATION.absence.v1.adl";
		//String nomFich1=".//ficheros//openEHR-EHR-ACTION.imaging_exam.v1.adl";
		String nomFich="C:\\desarrollo\\DESA_JAVA\\KhaosAdlToOwl\\ficheros\\openEHR-EHR-INSTRUCTION.care_plan.v1.adl";
		//String nomFich3="/Users/Irene/Desktop/openEHR-EHR-OBSERVATION.acoustic_reflex_result.v1.adl";
	
		//EvaluationTranslator dt = new EvaluationTranslator(nomFich);
		//dt.Translate();
		
		ObservationTranslator ot = new ObservationTranslator(nomFich);
		ot.Translate();
	}
}
