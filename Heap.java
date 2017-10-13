//Assignment satisfies extra credits;
public class Heap {
	int size = 0;
	int[] Heap = new int [size];
	int position_lastnode = -1;

	
	public int leftchild(int i){
		//get left child
		return i * 2 + 1;
	}
	public int rightchild(int i){
		//get right child
		return i * 2 + 2;
	}
	public int parent(int i){
		//get its parent
		return (i - 1) / 2;
	}
	
	
	public void insert(int i){
		position_lastnode += 1;
		extendHeap();
		Heap[position_lastnode] = i;
		upheapbubbling(position_lastnode);
		System.out.println(i +" was inserted successfully! ");


	}
	
	private void downheapbubbling(int i) {
		//downheapbubbling for removal
		int leftchild_position = leftchild(i);
		int rightchild_position = rightchild(i);
		int min_position= i;
		if(leftchild_position < Heap.length && Heap[i]>Heap[leftchild_position]){
			min_position = leftchild_position;
		}
		if(rightchild_position < Heap.length && Heap[rightchild_position]<Heap[min_position]){
			min_position = rightchild_position;
		}
		if(i == min_position){
			//find smallest value,get its position
			if (leftchild_position < Heap.length){
				downheapbubbling(leftchild_position);
			}
			if (rightchild_position  < Heap.length){
				downheapbubbling(rightchild_position);
			}
			return;
		}

		swap(i,min_position);

		downheapbubbling(min_position);

		
	}
	
	private void upheapbubbling(int i) {
		//upheapbubbling for insertion
		int parent_position = parent(i);
		int min_position= i;
		if(parent_position >= 0 && Heap[parent_position]>Heap[min_position]){
			min_position = parent_position;
		}
		if(i == min_position){
			return;
		}

		swap(i,min_position);

		upheapbubbling(parent_position);

		
	}
	
	
	public void findMin(){
		if (size ==0){
			System.out.println("Heap is empty");
		}
		else{
			System.out.println("Minimun value is " +Heap[0]);
		}
	}
	
	public void removeMin(){
		if (size ==0){
			System.out.println("Heap is empty");
		}
		else{
			Heap[0] = Heap[position_lastnode];
			shrinkHeap();
			position_lastnode-=1;
			downheapbubbling(0);
			System.out.println("removeMin successfully!");
		}
		
	}
	
	public void swap(int position_a, int position_b){
		//swap two values in Heap[position_a] and Heap[position_b]
		int temp;
		temp = Heap[position_a];
		Heap[position_a] = Heap[position_b];
		Heap[position_b] = temp;

	}
	
	public void extendHeap(){
		//extend array by 1
		size +=1;
		int extendedHeap[]=new int[size];
		for(int i =0;i<Heap.length;i++){
			extendedHeap[i] = Heap[i];
			}
		Heap =extendedHeap;
	}
	
	public void shrinkHeap(){
		//reduce array by 1
		size -=1;
		int shrinkHeap[]=new int[size];
		for(int i =0;i<shrinkHeap.length;i++){
			shrinkHeap[i] = Heap[i];
		}
		Heap =shrinkHeap;
	}
	
	public void display(){
		// display the array
		for(int i = 0;i < size;i++){
			System.out.print(Heap[i] +" ");
		}
	}
	


}
