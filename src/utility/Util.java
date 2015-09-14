package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Util {

	//read all file lines
	public static List<String> readFileLines(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			while(sc.hasNextLine()){
				listaLeida.add(sc.nextLine());
			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}

	//read ontology data
	public static List<String> readData(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			//Search start point
			boolean isntStartYet = true;
			while(isntStartYet && sc.hasNextLine()){
				isntStartYet = !sc.nextLine().contains("data");
			}
			//saving information
			boolean isntEnd = true;
			String line;
			while(isntEnd && sc.hasNextLine()){
				line = sc.nextLine();
				if(line.contains("protocol"))
					isntEnd = false; //end
				else if(!line.isEmpty())
					listaLeida.add(line);
			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}

	//read ontology state
	public static List<String> readState(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			//Search start point
			boolean isntStartYet = true;
			while(isntStartYet && sc.hasNextLine()){
				isntStartYet = !sc.nextLine().contains("state");
			}
			//saving information
			boolean isntEnd = true;
			String line;
			while(isntEnd && sc.hasNextLine()){
				line = sc.nextLine();
				if(line.contains("}"))
					isntEnd = false;
				else if(!line.isEmpty()){
					listaLeida.add(line);
				}
			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}

	//read ontology events
	public static List<String> readEvents(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			//Search start point
			boolean isntStartYet = true;
			while(isntStartYet && sc.hasNextLine()){
				isntStartYet = !sc.nextLine().contains("events");
			}
			//Saving information
			boolean isntEnd = true;
			String line;
			while(isntEnd && sc.hasNextLine()){
				line = sc.nextLine();
				if(line.contains("data"))
					isntEnd = false;
				else if(!line.isEmpty()){
					listaLeida.add(line);
				}

			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}

	//read ontology protocol
	public static List<String> readProtocol(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			//Search start point
			boolean isntStartYet = true;
			while(isntStartYet && sc.hasNextLine()){
				isntStartYet = !sc.nextLine().contains("protocol");
			}
			//saving information
			boolean isntEnd = true;
			String line;
			while(isntEnd && sc.hasNextLine()){
				line = sc.nextLine();
				if(line.equals("ontology"))
					isntEnd = false; //end
				else if(!line.isEmpty())
					listaLeida.add(line);
			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}
	
	//read ontology pathway
	public static List<String> readPathway(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			//Search start point
			boolean isntStartYet = true;
			while(isntStartYet && sc.hasNextLine()){
				isntStartYet = !sc.nextLine().contains("ism_transition");
			}
			//saving information
			boolean isntEnd = true;
			String line;
			while(isntEnd && sc.hasNextLine()){
				line = sc.nextLine();
				if(line.equals("protocol"))
					isntEnd = false; //end
				else if(!line.isEmpty())
					listaLeida.add(line);
			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}

	//read description`s ontology
	public static List<String> readOntology(String nomFich){
		List<String> listaLeida = new LinkedList<String>();
		try{
			Scanner sc = new Scanner(new File(nomFich));
			//Search start point
			boolean isntStartYet = true;
			while(isntStartYet && sc.hasNextLine()){
				isntStartYet = !sc.nextLine().equals("ontology");
			}
			//saving information
			boolean isntEnd = true;
			String line;
			while(isntEnd && sc.hasNextLine()){
				line = sc.nextLine();
				listaLeida.add(line);
			}
			sc.close();
		}catch (FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
		return listaLeida;
	}
}
