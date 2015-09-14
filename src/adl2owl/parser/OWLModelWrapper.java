package adl2owl.parser;

import java.util.*;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import utility.Util;

/**
 * @author Guillermo Garzón
 */

public class OWLModelWrapper {

	protected String nomFile;
	protected OWLOntologyManager manager;
	protected IRI ontologyIRI;
	protected OWLOntology ontology;
	protected OWLClass parentClass;
	protected OWLDataFactory factory;
	
	private String concept;
	private String concept_Description;
	private String archetype_ID;
	private String purpose;
	private String use;
	private String misuse;
	private String copyright;
	private List<String> author;
	private List<String> other_Contributors;
	private List<String> keywords;
	
	public OWLModelWrapper(String nomFich){
		nomFile=nomFich;
		
		List<String> lista = Util.readFileLines(nomFile);
		
		for(int i=0;i<lista.size();i++){
			if(lista.get(i).trim().startsWith("concept")){
				List<String> lc = Arrays.asList(lista.get(i+1).trim().split("--"));
				if(lc.get(1).trim().contains(" ")){
					concept = lc.get(1).trim().replace(" ", "_");
				}else{
					concept=lc.get(1).trim();
				}
			}
			archetype_ID=lista.get(1).trim();
			if(lista.get(i).trim().startsWith("purpose")){
				List<String> la = Arrays.asList(lista.get(i).trim().split("\""));
				purpose=la.get(1);
			}
			if(lista.get(i).trim().startsWith("use =")){
				List<String> la = Arrays.asList(lista.get(i).trim().split("\""));
				use=la.get(1);
			}
			if(lista.get(i).trim().startsWith("misuse")){
				List<String> la = Arrays.asList(lista.get(i).trim().split("\""));
				misuse=la.get(1);
			}
			if(lista.get(i).trim().startsWith("copyright")){
				List<String> la = Arrays.asList(lista.get(i).trim().split("\""));
				copyright=la.get(1);
			}
			if(lista.get(i).trim().startsWith("original_author")){
				List<String> loa = new ArrayList<String>();
				List<String> lname = Arrays.asList(lista.get(i+1).trim().split("\""));
				String name = lname.get(1).trim()+": "+lname.get(3).trim();
				List<String> lorganisation = Arrays.asList(lista.get(i+2).trim().split("\""));
				String organisation = lorganisation.get(1).trim()+": "+lorganisation.get(3).trim();
				List<String> lemail = Arrays.asList(lista.get(i+3).trim().split("\""));
				String email = lemail.get(1).trim()+": "+lemail.get(3).trim();
				List<String> ldate = Arrays.asList(lista.get(i+4).trim().split("\""));
				String date = ldate.get(1).trim()+": "+ldate.get(3).trim();
				loa.add(name);
				loa.add(organisation);
				loa.add(email);
				loa.add(date);
				author=loa;
			}
			if(lista.get(i).trim().startsWith("other_contributors")){
				List<String> loc = new ArrayList<String>();
				List<String> la = Arrays.asList(lista.get(i).trim().split("\""));
				for(int j=1;j<la.size();j=j+2){
					loc.add(la.get(j));
				}
				other_Contributors=loc;
			}
			if(lista.get(i).trim().startsWith("keywords")){
				List<String> lk = new ArrayList<String>();
				List<String> lkeys = Arrays.asList(lista.get(i).trim().split("\""));
				for(int j=1;j<lkeys.size();j=j+2){
					lk.add(lkeys.get(j));
				}
				keywords=lk;
			}
			if(lista.get(i).trim().startsWith("[\"at0000\"]")){
				List<String> lcondes = Arrays.asList(lista.get(i+2).split("\""));
				concept_Description = lcondes.get(1);
			}
		}
		/*try {
			manager = OWLManager.createOWLOntologyManager();
			ontologyIRI = IRI.create("http://www.semanticweb.org/irene/ontologies/2015/3/"+this.getArchetypeID());
			ontology = manager.createOntology(ontologyIRI);
			factory = manager.getOWLDataFactory();
		} catch (OWLOntologyCreationException e) {
			e.printStackTrace();
		}
		parentClass = factory.getOWLClass(IRI.create(ontologyIRI + "#"+this.getConcept()));
		*/
	}
	public String getConcept(){
		return concept;
	}
	public String getConceptDescription(){
		return concept_Description;
	}
	public String getArchetypeID(){
		return archetype_ID;
	}
	public String getPurpose(){
		return purpose;
	}
	public String getUse(){
		return use;
	}
	public String getMisuse(){
		return misuse;
	}
	public String getCopyright(){
		return copyright;
	}
	public List<String> getAuthor(){
		return author;
	}
	public List<String> getOtherContributors(){
		return other_Contributors;
	}
	public List<String> getKeywords(){
		return keywords;
	}
	public OWLClass getParentClass(){
		return parentClass;
	}
}
