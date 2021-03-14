public class Patterns{
	public static void main(String args[]){
		int rows=5;
		for(int i=0;i<rows;i++){
			for(int j=i;j<=(rows/2)+1;j++){
				System.out.print(" ");
			}
			for(int j=0;j<=i;j++) System.out.print("* ");
			System.out.println();
		}
		System.out.println();
		char ch='A';
		for(int i=0;i<rows;i++){
			for(int j=i;j<rows-1;j++) System.out.print("  ");
			for(int j=0;j<=i;j++,ch++) System.out.print(ch+" ");
			System.out.println();
		}
	}
}
