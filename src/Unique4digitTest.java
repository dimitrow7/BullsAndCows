
public class Unique4digitTest {

	public static void main(String[] args) {
		System.out.println( generateNumber(4));

	}
	
	static int generateNumber(int length){
        String result = "";
        int random;
        while(true){
            random  = (int) ((Math.random() * (10 )));
            if(result.length() == 0 && random == 0){//when parsed this insures that the number doesn't start with 0
                random+=1;
                result+=random;
            }
            else if(!result.contains(Integer.toString(random))){//if my result doesn't contain the new generated digit then I add it to the result
                result+=Integer.toString(random);
            }
            if(result.length()>=length){//when i reach the number of digits desired i break out of the loop and return the final result
                break;
            }
        }

        return Integer.parseInt(result);
    }

}
