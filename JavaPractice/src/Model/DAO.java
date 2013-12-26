package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DAO {
	List<STUDENT> studentObjectArray = new ArrayList<STUDENT>();
	String params;

	public DAO(String param) {
		super();
		this.params = param;
	}

	public void readXML() {
		try {
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			Document doc = docBuilder.parse("src/resources/" + params);
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
		} catch (FileNotFoundException e) {
			System.out.println("������ ������ ã�� �� �����ϴ�.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// id : �й��� ���� �л��� �ֻ��� ������ ����� ������ ����մϴ�."
	public void pMax(String idValue) {
		System.out.println(" " + idValue + " �й��� ���� �л��� �ֻ��� ������ ����� ������ ����մϴ�.");
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

	// id : �й��� ���� �л��� ������ ������ ����� ������ ����մϴ�."
	public void pMin(String idValue) {
		System.out.println(" " + idValue + " �й��� ���� �л��� ������ ������ ����� ������ ����մϴ�.");
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

	// id : �й��� ���� �л��� �� ������ ��� ������ ����մϴ�."
	public void pAvg(String idValue) {
		System.out.println(" " + idValue + " �й��� ���� �л��� �� ������ ��� ������ ����մϴ�.");
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

	// subject : ������ ������ �л� �� �ֻ��� ������ �й��� ������ ����մϴ�."
	public void sMax(String subjectValue) {
		System.out.println(" " + subjectValue + " ������ ������ �л� �� �ֻ��� ������ �й��� ������ ����մϴ�.");
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

	// subject : ������ ������ �л� �� ������ ������ �й��� ������ ����մϴ�."
	public void sMin(String subjectValue) {
		System.out.println(" " + subjectValue + " ������ ������ �л� �� ������ ������ �й��� ������ ����մϴ�.");
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

	// subject : ������ ������ ��� �л��� ��� ������ ����մϴ�."
	public void sAvg(String subjectValue) {
		System.out.println(" " + subjectValue + " ������ ������ ��� �л��� ��� ������ ����մϴ�.");
		int sumScore = 0;
		int count = 0;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				sumScore += studentObjectArray.get(indexI).getScore();
				count++;
			}
		}
		System.out.println(subjectValue + " " + String.valueOf(sumScore / count) + " ��");
	}

	// id : ���� ������ ��� ����� ������ ����մϴ�."
	public void searchPerson(String idValue) {
		System.out.println(" " + idValue + " ���� ������ ��� ����� ������ ����մϴ�.");
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (idValue.equals(String.valueOf(studentObjectArray.get(indexI).getId()))) {
				System.out.println(studentObjectArray.get(indexI).getSubject() + " " + studentObjectArray.get(indexI).getScore());
			}
		}
	}

	// subject : �� ������ ��� �й��� ������ ����մϴ�."
	public void searchSubject(String subjectValue) {
		System.out.println(" " + subjectValue + " �� ������ ��� �й��� ������ ����մϴ�.");
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				System.out.println(studentObjectArray.get(indexI).getId() + " " + studentObjectArray.get(indexI).getScore());
			}
		}
	}
}
