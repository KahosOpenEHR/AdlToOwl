package adl2owl.parser;

import java.util.Iterator;
import java.util.List;

import org.openehr.am.archetype.Archetype;
import org.openehr.am.archetype.constraintmodel.ArchetypeInternalRef;
import org.openehr.am.archetype.ontology.ArchetypeOntology;
import org.openehr.am.archetype.ontology.ArchetypeTerm;
import org.openehr.am.archetype.ontology.OntologyDefinitions;

/**
 * @author Guillermo Garzón
 */

public class ArchetypesUtils {

	public static String idiom = "en";

	public static String getTermDefinitionFor(String isoLanguageCode, String id, Archetype a){
		ArchetypeOntology ao = a.getOntology();
		List<OntologyDefinitions> odefs = ao.getTermDefinitionsList();
		Iterator it = odefs.iterator();
		while (it.hasNext()){
			OntologyDefinitions od = (OntologyDefinitions)it.next();    
			if (od.getLanguage().equals(isoLanguageCode)){
				List<ArchetypeTerm> aterms = od.getDefinitions();
				Iterator it2 = aterms.iterator();
				while (it2.hasNext()){
					ArchetypeTerm at =(ArchetypeTerm)it2.next();
					if (at.getCode().equals(id)){
						return at.getItem("text");
					}
				}
			}
		}           
		return "";
	}
	public static String getConstraintDefinitionFor(String isoLanguageCode,
			String id, Archetype a){
		ArchetypeOntology ao = a.getOntology();
		List<OntologyDefinitions> odefs = ao.getConstraintDefinitionsList();
		Iterator it = odefs.iterator();
		while (it.hasNext()){
			OntologyDefinitions od = (OntologyDefinitions)it.next();    
			if (od.getLanguage().equals(isoLanguageCode)){
				List<ArchetypeTerm> aterms = od.getDefinitions();
				Iterator it2 = aterms.iterator();
				while (it2.hasNext()){
					ArchetypeTerm at =(ArchetypeTerm)it2.next();
					if (at.getCode().equals(id)){
						return at.getItem("text");
					}
				}
			}
		}           
		return "";
	}
	/**
	 * Extracts node ID from the entire path or node address.
	 */
	public static String PathID(ArchetypeInternalRef ar)
	{
		String total=ar.getTargetPath();
		int i=total.length()-1;
		String aux="";
		boolean flag=false;
		while(i>0)
		{
			if((char)total.charAt(i)==']')
			{
				flag=true;
				i--;
				continue;
			}
			if((char)total.charAt(i)=='[')
				break;            
			if(flag)
				aux=(char)total.charAt(i) + aux;                     
			i--;  
		}
		return aux;
	}
}

