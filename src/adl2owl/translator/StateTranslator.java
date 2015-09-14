package adl2owl.translator;

import java.util.Arrays;
import java.util.List;

import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class StateTranslator {

	private String nod0;
	private String nod10;
	private String nomClass;

	public void Translate(OWLOntologyManager manager, IRI ontologyIRI, OWLOntology ontology, OWLDataFactory factory, OWLClass parentClass, List<String> lisState){

		factory = manager.getOWLDataFactory();
		OWLClass state = factory.getOWLClass(IRI.create(ontologyIRI+"#State"));
		OWLAxiom prtAxiom = factory.getOWLSubClassOfAxiom(state,parentClass);
		AddAxiom addPrtAxiom = new AddAxiom(ontology, prtAxiom);
		manager.applyChange(addPrtAxiom);

		for(String linea : lisState){
			for(int i=0; i<10;i++){
				nod0 = "[at000"+i+"]";
				if(linea.contains(nod0)){
					List<String> lisNode = Arrays.asList(linea.trim().split("--"));
					nomClass = lisNode.get(1).trim();
					if(!(nomClass.equals("Tree") || nomClass.equals("List") || nomClass.equals("Cluster"))){
						if(nomClass.contains(" ")){
							nomClass = nomClass.replace(" ", "_");
							manager.applyChange(new AddAxiom(ontology, 
									factory.getOWLSubClassOfAxiom(factory.getOWLClass(IRI.create(ontologyIRI+"#"+nomClass)),state)));
						}else{
							manager.applyChange(new AddAxiom(ontology, 
									factory.getOWLSubClassOfAxiom(factory.getOWLClass(IRI.create(ontologyIRI+"#"+nomClass)),state)));
						}
					}
				}
			}
			for(int i=10;i<100;i++){
				nod10 = "[at00"+i+"]";
				if(linea.contains(nod10)){
					List<String> lisNode = Arrays.asList(linea.trim().split("--"));
					nomClass = lisNode.get(1).trim();
					if(!(nomClass.equals("Tree") || nomClass.equals("List") || nomClass.equals("Cluster"))){
						if(nomClass.contains(" ")){
							nomClass = nomClass.replace(" ", "_");
							manager.applyChange(new AddAxiom(ontology, 
									factory.getOWLSubClassOfAxiom(factory.getOWLClass(IRI.create(ontologyIRI+"#"+nomClass)),state)));
						}else{
							manager.applyChange(new AddAxiom(ontology, 
									factory.getOWLSubClassOfAxiom(factory.getOWLClass(IRI.create(ontologyIRI+"#"+nomClass)),state)));
						}
					}
				}
			}
		}
	}
}
