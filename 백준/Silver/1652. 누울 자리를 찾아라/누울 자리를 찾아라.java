

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int row = 0, col = 0;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    if (arr[i][j] == '.' && arr[i][j + 1] == '.' &&
                        (j == n - 2 || arr[i][j + 2] == 'X')) {
                        row++;
                    }
                }
                if (i + 1 < n) {
                    if (arr[i][j] == '.' && arr[i + 1][j] == '.' &&
                        (i == n - 2 || arr[i + 2][j] == 'X')) {
                        col++;
                    }
                }
            }
        }

        System.out.println(row + " " + col);
    }
}