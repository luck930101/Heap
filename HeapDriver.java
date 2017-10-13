//Assignment satisfies extra credits;
import java.util.Scanner;

public class HeapDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Heap hp = new Heap();
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()){
			String[] stringlist = scanner.nextLine().split(" ");
			if (stringlist[0].equals("insert")){
				hp.insert(Integer.parseInt(stringlist[1]));
			}
			else if (stringlist[0].equals("findMin")){
				hp.findMin();
			}
			else if (stringlist[0].equals("removeMin")){
				hp.removeMin();
			}
			else if (stringlist[0].equals("display")){
				hp.display();
			}
		}
		scanner.close();

	}

}
