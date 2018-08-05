
public class Testing{

	public static void main(String[] args) {
		ArrayUnorderedList<Integer> list = new ArrayUnorderedList<>(5);
		list.addToRear(10);
		list.addToRear(12);
		list.addToRear(10);
		list.addToRear(10);
		list.addToRear(10);
		System.out.println(list);
		list.addToRear(10);
		System.out.println(list);
		list.addToFront(15);
		System.out.println(list);
	}

}
