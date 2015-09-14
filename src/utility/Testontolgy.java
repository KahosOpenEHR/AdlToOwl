package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class Testontolgy {

	public static void main(String[] args) throws OWLOntologyCreationException, OWLOntologyStorageException, FileNotFoundException{
		
		/*
		File file = new File("//Users//Irene//Desktop//test.owl");
		FileOutputStream ou = new FileOutputStream(file);
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		IRI ontologyIRI = IRI.create("http://www.semanticweb.org/irene/ontologies/2015/3/untitled-ontology-9");
		OWLOntology ontology = manager.createOntology(ontologyIRI);
		OWLDataFactory factory = manager.getOWLDataFactory();
		OWLClass clsA = factory.getOWLClass(IRI.create(ontologyIRI + "#A"));
        OWLClass clsB = factory.getOWLClass(IRI.create(ontologyIRI + "#B"));
        OWLAxiom axiom = factory.getOWLSubClassOfAxiom(clsA, clsB);
        AddAxiom addAxiom = new AddAxiom(ontology, axiom);
        manager.applyChange(addAxiom);
		//File file = new File(".//ficheros//owlapiexamples_saving.owl");
        manager.saveOntology(ontology, ou);
		*/
		File file = new File("//Users//Irene//Desktop//test.owl");
		FileOutputStream fout = new FileOutputStream(file);
		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
		IRI ontologyIRI = IRI.create("http://www.semanticweb.org/irene/ontologies/2015/3/"+"EVALUATION");
		OWLOntology ontology = manager.createOntology(ontologyIRI);
		OWLDataFactory factory = manager.getOWLDataFactory();
		OWLClass cDescription = factory.getOWLClass(IRI.create(ontologyIRI + "#"+"Description"));
		OWLClass cConcept = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Concept"));
		OWLClass cArchID = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Archetype_ID"));
		OWLClass cPurpose = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Purpose"));
		OWLClass cUse = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Use"));
		OWLClass cMisuse = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Misuse"));
		OWLClass cCopyright = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Copyright"));
		OWLClass cAuthor = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Author"));
		OWLClass cOther_contributors = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Other_Contributors"));
		OWLClass cKeywords = factory.getOWLClass(IRI.create(ontologyIRI+"#"+"Keywords"));
		
		OWLAxiom axiom = factory.getOWLSubClassOfAxiom(cConcept,cDescription);
		OWLAxiom axiom1 = factory.getOWLSubClassOfAxiom(cArchID,cDescription);
		OWLAxiom axiom2 = factory.getOWLSubClassOfAxiom(cPurpose,cDescription);
		OWLAxiom axiom3 = factory.getOWLSubClassOfAxiom(cUse,cDescription);
		OWLAxiom axiom4 = factory.getOWLSubClassOfAxiom(cMisuse,cDescription);
		OWLAxiom axiom5 = factory.getOWLSubClassOfAxiom(cCopyright,cDescription);
		OWLAxiom axiom6 = factory.getOWLSubClassOfAxiom(cAuthor,cDescription);
		OWLAxiom axiom7 = factory.getOWLSubClassOfAxiom(cOther_contributors,cDescription);
		OWLAxiom axiom8 = factory.getOWLSubClassOfAxiom(cKeywords,cDescription);
		
		AddAxiom addAxiom = new AddAxiom(ontology, axiom);
		AddAxiom addAxiom1 = new AddAxiom(ontology, axiom1);
		AddAxiom addAxiom2 = new AddAxiom(ontology, axiom2);
		AddAxiom addAxiom3 = new AddAxiom(ontology, axiom3);
		AddAxiom addAxiom4 = new AddAxiom(ontology, axiom4);
		AddAxiom addAxiom5 = new AddAxiom(ontology, axiom5);
		AddAxiom addAxiom6 = new AddAxiom(ontology, axiom6);
		AddAxiom addAxiom7 = new AddAxiom(ontology, axiom7);
		AddAxiom addAxiom8 = new AddAxiom(ontology, axiom8);
		
		manager.applyChange(addAxiom);
		manager.applyChange(addAxiom1);
		manager.applyChange(addAxiom2);
		manager.applyChange(addAxiom3);
		manager.applyChange(addAxiom4);
		manager.applyChange(addAxiom5);
		manager.applyChange(addAxiom6);
		manager.applyChange(addAxiom7);
		manager.applyChange(addAxiom8);
		
		manager.saveOntology(ontology, fout);
	}
}
