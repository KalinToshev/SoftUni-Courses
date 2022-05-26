import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Създаваме и "пълним" нашата 2Д матрица, с размери 8х8 винаги
        String[][] arr_2D = new String[8][8];
        fillMatrix(scanner, arr_2D);
        //Обхождаме през всеки един ред и всяка една колона
        //Търсим елемента "q" и правим "претърсване" през неговите диагонали, след него, преди него, над и под него
        //за друг елемент "q". Ако не се намери друг елемент "q" по описаните горе посоки, принтираме неговите кординати и спираме
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if("q".equals(arr_2D[i][j])) {
                    boolean queen = true;
                    for (int a=0; a<8;a++){
                        if(("q".equals(arr_2D[a][j]) && a!=i)
                                || ("q".equals(arr_2D[i][a]) && a!=j)){
                            queen = false;
                            break;
                        }
                    }
                    int diagonalRow=0;
                    int diagonalCol=0;
                    int cycle = 8;
                    if(i<j){
                        diagonalCol = j - i;
                        cycle = 8-diagonalCol;
                    }
                    if(i>j){
                        diagonalRow = i-j;
                        cycle = 8-diagonalRow;
                    }
                    for (int a=0; a<cycle;a++){
                        if("q".equals(arr_2D[diagonalRow][diagonalCol]) && diagonalRow!=i){
                            queen = false;
                            break;
                        }
                        diagonalRow++;
                        diagonalCol++;
                    }
                    if(i+j<8){
                        diagonalRow = 0;
                        diagonalCol = i+j;
                        cycle = i+j+1;
                    } else {
                        diagonalRow = i+j-7;
                        diagonalCol = 7;
                        cycle = 8- diagonalRow;
                    }
                    for (int a=0; a<cycle;a++){
                        if("q".equals(arr_2D[diagonalRow][diagonalCol]) && diagonalRow!=i){
                            queen = false;
                            break;
                        }
                        diagonalRow++;
                        diagonalCol--;
                    }
                    if (queen) {
                        System.out.println(i + " " + j);
                    }
                }
            }
        }
    }

    private static void fillMatrix(Scanner scanner, String[][] arr_2D) {
        for (int i = 0; i < 8; i++) {
            arr_2D[i] = scanner.nextLine().split("\\s+");
        }
    }
}
