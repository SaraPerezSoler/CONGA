package generator;

import java.util.List;

public interface Comparable {
	
	boolean isSimilarTo(Comparable other);
	
	public static boolean isSimilarStatic (List<? extends Comparable> list1, List<? extends Comparable> list2){
		if (list1.size() != list2.size()) {
			return false;
		}
		boolean containInput = false;
		for (Comparable element1: list1) {
			containInput = false;
			for (Comparable element2: list2) {
				if (element1.isSimilarTo(element2)) {
					containInput = true;
					break;
				}
			}
			if (containInput == false) {
				return false;
			}
		}
		return true;
	}
	default boolean isSimilar (List<? extends Comparable> list1, List<? extends Comparable> list2){
		return isSimilarStatic(list1, list2);
	}
}
