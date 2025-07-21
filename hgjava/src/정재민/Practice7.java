package 정재민;

public class Practice7 {

	public static void main(String[] args) {
		// 연습
		//
		int[] ranNums = new int[10];
		Label : for (int i = 0; i < ranNums.length; i++) {
			int ranNum = 0;
			ranNum = (int) (Math.random() * 100) + 1;
			for (int j = 0; j <= i; j++) {
				if (ranNum == ranNums[j]) {
					i--;
					continue Label;
				}
			}
			ranNums[i] = ranNum;
			
			System.out.print(ranNums[i] + "\s");
		}
		
		
//		int[] ranNums = new int[10];
//		for (int i = 0; i < ranNums.length; i++) {
//			int ranNum = 0;
//			ranNum = (int) (Math.random() * 100) + 1;
//			for (int j = 0; j <= i; j++) {
//				if (ranNum != ranNums[j]) {
//					ranNums[i] = ranNum;
//				} else if(ranNum == ranNums[j]) {
//					i--;
//					break;
//				}
//			}
//			
//			System.out.print(ranNums[i] + "\s");
//		}

	}// end main

}// end class
