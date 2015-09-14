package adl2owl.translator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import adl2owl.parser.OWLModelWrapper;

public class InstructionTranslator extends OWLModelWrapper{

	public InstructionTranslator(String nomFich){
		super(nomFich);
	}
	//PUT the IRI of the archetype.
	IRI nullIRI = IRI.create("http://www.semanticweb.org/irene/ontologies/2015/3/openEHR-EHR-OBSERVATION.acoustic_reflex_result.v1.adl#null");

	public void Translate() throws OWLOntologyStorageException, FileNotFoundException{

		File file = new File(nomFile.substring(0, nomFile.length() - 4) + ".owl");
		FileOutputStream fout = new FileOutputStream(file);

		List<String> lisData = utility.Util.readData(nomFile);
		List<String> lisProtocol = utility.Util.readProtocol(nomFile);
		List<String> lisState = utility.Util.readState(nomFile);
		List<String> lisEvents = utility.Util.readEvents(nomFile);

		try {
			manager = OWLManager.createOWLOntologyManager();
			ontologyIRI = IRI.create("http://www.semanticweb.org/irene/ontologies/2015/3/"+this.getArchetypeID());
			ontology = manager.createOntology(ontologyIRI);
			factory = manager.getOWLDataFactory();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}

		parentClass = factory.getOWLClass(IRI.create(ontologyIRI+"#"+this.getConcept()));

		ActivitiesTranslator actt = new ActivitiesTranslator();
		actt.Translate(manager, ontologyIRI, ontology, factory, parentClass, lisData);

		ProtocolTranslator ptt = new ProtocolTranslator();
		ptt.Translate(manager, ontologyIRI, ontology, factory, parentClass, lisProtocol);

		DefinitionTranslator dft = new DefinitionTranslator();
		dft.Translate(manager, ontology, ontologyIRI, factory, parentClass, super.getConceptDescription(), super.getArchetypeID(), super.getPurpose(), super.getUse(), super.getMisuse(), super.getCopyright(), super.getAuthor(), super.getOtherContributors(), super.getKeywords());

		Set<OWLAxiom> axiomsToRemove = new HashSet<OWLAxiom>();
		for (OWLAxiom ax : ontology.getAxioms()) {
			//System.out.println(ax.getSignature().toString());
			if (ax.getSignature().contains(factory.getOWLClass(nullIRI))) {
				axiomsToRemove.add(ax);
				//System.out.println("to remove from " + ontology.getOntologyID().getOntologyIRI() + ": " + ax);
			}
		}
		//System.out.println("Before: " + ontology.getAxiomCount());
		manager.removeAxioms(ontology, axiomsToRemove);
		//System.out.println("After: " + ontology.getAxiomCount());

		manager.saveOntology(ontology, fout);
	}

}
