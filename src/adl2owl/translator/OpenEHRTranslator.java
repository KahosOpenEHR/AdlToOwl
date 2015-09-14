package adl2owl.translator;

import adl2owl.parser.OWLModelWrapper;

public class OpenEHRTranslator extends OWLModelWrapper {

	public OpenEHRTranslator(String nomFich) {
		super(nomFich);
	}
	public void Translate(){
		if(super.getArchetypeID().contains("EVALUATION")){
			
		}else if(super.getArchetypeID().contains("OBSERVATION")){

		}else if(super.getArchetypeID().contains("ACTION")){

		}else if(super.getArchetypeID().contains("INSTRUCTION")){

		}
	}

}
