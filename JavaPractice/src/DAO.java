import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class STUDENT {
	private int id = 0;
	private String subject = "";
	private int score = 0;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

public class DAO {
	List<STUDENT> studentObjectArray = new ArrayList<STUDENT>();
	String params;

	public DAO(String param) {
		super();
		this.params = param;
	}

	public void readXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse("src/resources/"+params);
			doc.getDocumentElement().normalize();

			NodeList studentList = doc.getElementsByTagName("student");

			for (int i = 0; i < studentList.getLength(); i++) {
				NodeList sList = studentList.item(i).getChildNodes();
				STUDENT person = new STUDENT();
				for (int j = 0; j < sList.getLength(); j++) {
					Node cNode = sList.item(j);
					if (cNode.getNodeName().equalsIgnoreCase("id")) {
						person.setId(Integer.parseInt(cNode.getTextContent()));
						System.out.print(cNode.getTextContent() + " ");
					}
					if (cNode.getNodeName().equalsIgnoreCase("subject")) {
						person.setSubject(cNode.getTextContent());
						System.out.print(cNode.getTextContent() + " ");
					}
					if (cNode.getNodeName().equalsIgnoreCase("score")) {
						person.setScore(Integer.parseInt(cNode.getTextContent()));
						System.out.print(cNode.getTextContent() + " ");
					}
				}
				studentObjectArray.add(person);
				System.out.println();
			}
			System.out.println("Success LOAD " + params);
		} catch (FileNotFoundException e){
			System.out.println("지정된 파일을 찾을 수 없습니다.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void pMax(String idValue) {
		STUDENT pmaxSTUDENT = new STUDENT();
		int maxScore = 0;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (idValue.equals(String.valueOf(studentObjectArray.get(indexI).getId()))) {
				if (studentObjectArray.get(indexI).getScore() >= maxScore) {
					maxScore = studentObjectArray.get(indexI).getScore();
					pmaxSTUDENT = studentObjectArray.get(indexI);
				}
			}
		}
		System.out.println(pmaxSTUDENT.getSubject() + " " + pmaxSTUDENT.getScore());
	}

	public void pMin(String idValue) {
		STUDENT pminSTUDENT = new STUDENT();

		int minScore = -1;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (idValue.equals(String.valueOf(studentObjectArray.get(indexI).getId()))) {
				if (minScore == -1) {
					minScore = studentObjectArray.get(indexI).getScore();
					pminSTUDENT = studentObjectArray.get(indexI);
				} else if (studentObjectArray.get(indexI).getScore() <= minScore) {
					minScore = studentObjectArray.get(indexI).getScore();
					pminSTUDENT = studentObjectArray.get(indexI);
				}
			}
		}
		System.out.println(pminSTUDENT.getSubject() + " " + pminSTUDENT.getScore());
	}

	public void pAvg(String idValue) {
		int sumScore = 0;
		int count = 0;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (idValue.equals(String.valueOf(studentObjectArray.get(indexI).getId()))) {
				sumScore += studentObjectArray.get(indexI).getScore();
				count++;
			}
		}
		System.out.println(idValue + " " + String.valueOf(sumScore / count));
	}

	public void sMax(String subjectValue) {
		STUDENT smaxSTUDENT = new STUDENT();
		int maxScore = 0;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				if (studentObjectArray.get(indexI).getScore() >= maxScore) {
					maxScore = studentObjectArray.get(indexI).getScore();
					smaxSTUDENT = studentObjectArray.get(indexI);
				}
			}
		}
		System.out.println(smaxSTUDENT.getId() + " " + smaxSTUDENT.getScore());
	}

	public void sMin(String subjectValue) {
		STUDENT sminSTUDENT = new STUDENT();

		int minScore = -1;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				if (minScore == -1) {
					minScore = studentObjectArray.get(indexI).getScore();
					sminSTUDENT = studentObjectArray.get(indexI);
				} else if (studentObjectArray.get(indexI).getScore() <= minScore) {
					minScore = studentObjectArray.get(indexI).getScore();
					sminSTUDENT = studentObjectArray.get(indexI);
				}
			}
		}
		System.out.println(sminSTUDENT.getId() + " " + sminSTUDENT.getScore());
	}

	public void sAvg(String subjectValue) {
		int sumScore = 0;
		int count = 0;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				sumScore += studentObjectArray.get(indexI).getScore();
				count++;
			}
		}
		System.out.println(subjectValue + " " + String.valueOf(sumScore / count));
	}
	
	public void searchPerson(String idValue){
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (idValue.equals(String.valueOf(studentObjectArray.get(indexI).getId()))) {
				System.out.println(studentObjectArray.get(indexI).getSubject()+" "+studentObjectArray.get(indexI).getScore());
			}
		}
	}
	public void	searchSubject(String subjectValue){
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				System.out.println(studentObjectArray.get(indexI).getId()+" "+studentObjectArray.get(indexI).getScore());
			}
		}
	}
}
