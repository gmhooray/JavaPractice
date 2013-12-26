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
			System.out.println("지정된 파일을 찾을 수 없습니다.");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// id : 학번을 가진 학생의 최상위 성적의 과목과 점수를 출력합니다."
	public void pMax(String idValue) {
		System.out.println(" " + idValue + " 학번을 가진 학생의 최상위 성적의 과목과 점수를 출력합니다.");
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

	// id : 학번을 가진 학생의 최하위 성적의 과목과 점수를 출력합니다."
	public void pMin(String idValue) {
		System.out.println(" " + idValue + " 학번을 가진 학생의 최하위 성적의 과목과 점수를 출력합니다.");
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

	// id : 학번을 가진 학생의 전 과목의 평균 점수를 출력합니다."
	public void pAvg(String idValue) {
		System.out.println(" " + idValue + " 학번을 가진 학생의 전 과목의 평균 점수를 출력합니다.");
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

	// subject : 과목을 수강한 학생 중 최상위 성적의 학번과 점수를 출력합니다."
	public void sMax(String subjectValue) {
		System.out.println(" " + subjectValue + " 과목을 수강한 학생 중 최상위 성적의 학번과 점수를 출력합니다.");
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

	// subject : 과목을 수강한 학생 중 최하위 성적의 학번과 점수를 출력합니다."
	public void sMin(String subjectValue) {
		System.out.println(" " + subjectValue + " 과목을 수강한 학생 중 최하위 성적의 학번과 점수를 출력합니다.");
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

	// subject : 과목을 수강한 모든 학생의 평균 점수를 출력합니다."
	public void sAvg(String subjectValue) {
		System.out.println(" " + subjectValue + " 과목을 수강한 모든 학생의 평균 점수를 출력합니다.");
		int sumScore = 0;
		int count = 0;
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				sumScore += studentObjectArray.get(indexI).getScore();
				count++;
			}
		}
		System.out.println(subjectValue + " " + String.valueOf(sumScore / count) + " 점");
	}

	// id : 님이 수강한 모든 과목과 점수을 출력합니다."
	public void searchPerson(String idValue) {
		System.out.println(" " + idValue + " 님이 수강한 모든 과목과 점수을 출력합니다.");
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (idValue.equals(String.valueOf(studentObjectArray.get(indexI).getId()))) {
				System.out.println(studentObjectArray.get(indexI).getSubject() + " " + studentObjectArray.get(indexI).getScore());
			}
		}
	}

	// subject : 를 수강한 모든 학번과 점수을 출력합니다."
	public void searchSubject(String subjectValue) {
		System.out.println(" " + subjectValue + " 를 수강한 모든 학번과 점수을 출력합니다.");
		for (int indexI = 0; indexI < studentObjectArray.size(); indexI++) {
			if (subjectValue.equals(studentObjectArray.get(indexI).getSubject())) {
				System.out.println(studentObjectArray.get(indexI).getId() + " " + studentObjectArray.get(indexI).getScore());
			}
		}
	}
}
