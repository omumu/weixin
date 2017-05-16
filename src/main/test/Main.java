import java.util.Scanner;

/**
 * Created by 木木高 on 2017/4/27.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int[] price=new int[N];
        for(int i=0;i<N;i++){
            price[i]=in.nextInt();
        }
        for(int i=0;i<price.length-1;i++){
            for(int j=0;j<price.length-1-i;j++){
                if(price[j]>price[j+1]){
                int temp=price[j+1];
                price[j+1]=price[j];
                price[j]=temp;
            }
        }}
        if(N>=3){

            System.out.println(price[N-3]);}else{
            System.out.println(-1);
        }

    }

}
