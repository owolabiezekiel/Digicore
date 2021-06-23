package owolabi.ezekiel.digicore;

public class PerfectSquareCount {
  public static void main(String[] args) {
    int [][] numbersArrayOne = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
    int [][] numbersArrayTwo = {{9,1,2,8,4},{128,256,189,81,22},{67,69,20,49,45}};
    int [][] numbersArrayThree = {{196,225,4,9,16},{25,36,49,64,81},{100,121,144,169,324}};

    System.out.println(calculatePerfectSquare(numbersArrayOne));
    System.out.println(calculatePerfectSquare(numbersArrayTwo));
    System.out.println(calculatePerfectSquare(numbersArrayThree));
  }
  public static int calculatePerfectSquare(int[][] numbersArray){
    int numberOfPerfectSquares = 0;
    for(int i = 0; i < numbersArray.length; i++){
      for(int j = 0; j < numbersArray[i].length; j++){
        if (isPerfectSquare(numbersArray[i][j])) {
          numberOfPerfectSquares++;
        }
      }
    }
    return numberOfPerfectSquares;
  }

  public static boolean isPerfectSquare(int number){
    int numberSquareRoot = (int) Math.sqrt(number);
    return numberSquareRoot * numberSquareRoot == number;
  }
}
