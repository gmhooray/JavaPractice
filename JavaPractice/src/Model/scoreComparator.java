package Model;

import java.util.Comparator;

public class scoreComparator implements Comparator<STUDENT> {

	@Override
	public int compare(STUDENT o1, STUDENT o2) {
		// TODO Auto-generated method stub
		return o1.getScore() > o2.getScore() ? -1 : o1.getScore() == o2.getScore() ? 0 : 1;
	}

}
