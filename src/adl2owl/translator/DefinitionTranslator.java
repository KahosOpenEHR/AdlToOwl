package adl2owl.translator;

import java.util.List;

import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationProperty;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 * 
 * @author Guillermo Garzón
 *
 */

public class DefinitionTranslator{

	public void Translate(OWLOntologyManager manager, OWLOntology ontology, IRI ontologyIRI, OWLDataFactory factory, OWLClass parentClass, String concept_Description, String archetype_ID, String purpose, String use, String misuse, String copyright, List<String> author, List<String> other_Contributors, List<String> keywords){
		
		//AÑADIR LAS ANOTACIONES A LA CLASE PADRE
		factory = manager.getOWLDataFactory();
		OWLAnnotationProperty conDes = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Concept_Description"));
		OWLAnnotation commentConDes = factory.getOWLAnnotation(conDes, factory.getOWLLiteral(concept_Description, "en"));
	    OWLAxiom axCD = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentConDes);
	    manager.applyChange(new AddAxiom(ontology, axCD));
	    
	    OWLAnnotationProperty arID = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Archetype_ID"));
		OWLAnnotation commentArID = factory.getOWLAnnotation(arID, factory.getOWLLiteral(archetype_ID, "en"));
	    OWLAxiom axAID = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentArID);
	    manager.applyChange(new AddAxiom(ontology, axAID));
	    
	    OWLAnnotationProperty purp = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Purpose"));
		OWLAnnotation commentPurp = factory.getOWLAnnotation(purp, factory.getOWLLiteral(purpose, "en"));
	    OWLAxiom axP = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentPurp);
	    manager.applyChange(new AddAxiom(ontology, axP));
	    
	    OWLAnnotationProperty us = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Use"));
		OWLAnnotation commentUse = factory.getOWLAnnotation(us, factory.getOWLLiteral(use, "en"));
	    OWLAxiom axU = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentUse);
	    manager.applyChange(new AddAxiom(ontology, axU));
	    
	    OWLAnnotationProperty miUs = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Misuse"));
		OWLAnnotation commentMis = factory.getOWLAnnotation(miUs, factory.getOWLLiteral(misuse, "en"));
	    OWLAxiom axMU = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentMis);
	    manager.applyChange(new AddAxiom(ontology, axMU));
	    
	    OWLAnnotationProperty copy = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Copyright"));
		OWLAnnotation commentCopy = factory.getOWLAnnotation(copy, factory.getOWLLiteral(copyright, "en"));
	    OWLAxiom axCopy = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentCopy);
	    manager.applyChange(new AddAxiom(ontology, axCopy));
	    
	    OWLAnnotationProperty aut = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Author"));
		OWLAnnotation commentAut = factory.getOWLAnnotation(aut, factory.getOWLLiteral(author.toString(), "en"));
	    OWLAxiom axA = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentAut);
	    manager.applyChange(new AddAxiom(ontology, axA));
	    
	    OWLAnnotationProperty otherCon = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Other_Contributors"));
		OWLAnnotation commentOtherCon = factory.getOWLAnnotation(otherCon, factory.getOWLLiteral(other_Contributors.toString(), "en"));
	    OWLAxiom axOC = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentOtherCon);
	    manager.applyChange(new AddAxiom(ontology, axOC));
	    
	    OWLAnnotationProperty keyw = factory.getOWLAnnotationProperty(IRI.create(ontologyIRI+"#Keywords"));
		OWLAnnotation commentKey = factory.getOWLAnnotation(keyw, factory.getOWLLiteral(keywords.toString(), "en"));
	    OWLAxiom axKW = factory.getOWLAnnotationAssertionAxiom(parentClass.getIRI(), commentKey);
	    manager.applyChange(new AddAxiom(ontology, axKW));

	}
}

