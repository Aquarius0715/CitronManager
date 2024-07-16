import org.springframework.security.core.parameters.P;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //hangman();
        //hitAndBlow();
        Scanner scanner = new Scanner(System.in);
        String input = "hello";
        char[] chars = input.toCharArray();
        System.out.println(chars);
/*
        String a = "hello!!!!";
        char[] disp = new char[a.length()];
        char[] ans = a.toCharArray();

        for (int i = 0 ; i < a.length(); i++) {
            disp[i] = '*';
        }

        System.out.println(a);
        for (char c : ans) {
            System.out.println(c);
        }
        System.out.println();

 */
    }


    public static int[] parseArray(int a) {
        int[] my = new int[3]; //output
        for (int i = 2; a != 0; i--) {
            my[i] = a % 10;
            a /= 10;
        }
        return my;
    }



    public static void dice(int d, int m) {
        int rnd = new Random().nextInt(d) + 1;
        System.out.println(d + "面サイコロをふって" + rnd + "が出ました。");
        if (rnd == m) {
            System.out.println("あたり！");
        } else {
            System.out.println("ハズレ");

        }
    }


    public static void PlacingMarbles() {
        Scanner sc = new Scanner(System.in);
        char[] marble = sc.next().toCharArray();
        int marbleCounter = 0;
        for (char c : marble) {
            if (c == '1') {
                marbleCounter += 1;
            }
        }
        System.out.println(marbleCounter);
    }

    public static void Product() {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if (a * b % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    public static void WelcomeToAtCoder() {
        Scanner sc = new Scanner(System.in);
        // 整数の入力
        int a = sc.nextInt();
        // スペース区切りの整数の入力
        int b = sc.nextInt();
        int c = sc.nextInt();
        // 文字列の入力
        String s = sc.next();
        // 出力
        System.out.println((a+b+c) + " " + s);
    }



    public static void blackJack() throws InterruptedException {
        final char[] symbols = {'♡', '♢', '♧', '♤'};
        final String[] numbers = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        while (true) {
            ArrayList<String> deck = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 13; j++) {
                    String card = symbols[i] + numbers[j];
                    deck.add(card);
                }
            }
            Collections.shuffle(deck);

            ArrayList<String> playerHand = new ArrayList<>();
            ArrayList<String> dealerHand = new ArrayList<>();
            System.out.println("BLACKJACK PAYS 3 TO 2");
            System.out.println("Dealer must stand on 17 and must draw to 16");
            System.out.println("INSURANCE PAYS 2 TO 1");
            System.out.println("PLAY: TYPE 'P'");
            System.out.println("LEAVE TABLE: TYPE 'L'");
            Scanner scn =  new Scanner(System.in);
            char selection = scn.next().charAt(0);
            switch (selection) {
                case 'P':
                    break;
                case 'L':
                    System.out.println("Come Again!!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection");
                    Thread.sleep(2000L);
                    continue;
            }
            playerHand.add(deck.removeLast());
            dealerHand.add(deck.removeLast());
            playerHand.add(deck.removeLast());
            dealerHand.add(deck.removeLast());
        }

    }
    public static void matchingGame() {
        String[][] table = new String[4][13];
        final char[] symbols = {'♡', '♢', '♧', '♤'};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                String card;
                if (j + 1 < 10) {
                    card = symbols[i] + String.valueOf(j + 1) + " ";
                } else {
                    card = symbols[i] + String.valueOf(j + 1);
                }
                table[i][j] = card;
            }
        }

        Random random = new Random();

        for (int i = table.length - 1; i > 0; i--) {
            for (int j = table[i].length - 1; j > 0; j--) {
                int m = random.nextInt(i + 1);
                int n = random.nextInt(j + 1);

                String temp = table[i][j];
                table[i][j] = table[m][n];
                table[m][n] = temp;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void hangman() {
        while (true) {
            final String ansWord = "efficiency";
            char[] ans = ansWord.toCharArray();
            char[] display = new char[ans.length];
            Arrays.fill(display, '*');

            int tryCount = 1;
            while (!Arrays.equals(ans, display) && tryCount <= 7) {
                System.out.println(tryCount + "回目");
                System.out.println(display);
                System.out.print("Type character: ");
                char input = new Scanner(System.in).next().toLowerCase().charAt(0);
                for (int i = 0; i < ans.length; i++) {
                    if (ans[i] == input) {
                        display[i] = ans[i];
                    }
                }
                tryCount += 1;
            }

            System.out.println("答え：" + ansWord);
            if (Arrays.equals(ans, display)) {
                System.out.println("成功！おめでとう！");
            } else {
                System.out.println("失敗…またチャレンジしてね！");
            }

            char restart;
            do {
                System.out.println("再プレイしますか？Y/n");
                restart = new Scanner(System.in).next().toUpperCase().charAt(0);
            } while (restart != 'Y' && restart != 'N');
            if (restart == 'N') {
                break;
            }
        }
    }

    public static void hitAndBlow() {
        Random random = new Random();
        ArrayList<Integer> numberTable = new ArrayList<>();
        ArrayList<Character> answerNumber = new ArrayList<Character>();
        for (int i = 0; i < 10; i++) {
            numberTable.add(i);
        }
        for (int i = 0; i < 3; i++) {
            int rnd = random.nextInt(numberTable.size());
            answerNumber.add(numberTable.get(rnd).toString().charAt(0));
            numberTable.remove(rnd);
        }
        int gameCounter = 1;
        while (true) {
            System.out.println(gameCounter + "回目");
            System.out.print("数字を入力して下さい: ");
            Scanner scn = new Scanner(System.in);
            char[] input = scn.next().toCharArray();
            int hitCounter = 0;
            int blowCounter = 0;
            for (int i = 0; i < 3; i++) {
                char ansCharacter = answerNumber.get(i);
                char inputCharacter = input[i];
                if (ansCharacter == inputCharacter) {
                    hitCounter += 1;
                } else if (answerNumber.contains(inputCharacter)) {
                    blowCounter += 1;
                }
            }
            if (hitCounter == 3) {
                break;
            }
            System.out.println("Hit: " + hitCounter);
            System.out.println("Blow: " + blowCounter);
            gameCounter += 1;
        }
    }

    public static void RPS() throws InterruptedException {
        ArrayList<Character> hands = new ArrayList<>(Arrays.asList('R', 'P', 'S'));
        char chooseHand = 0;
        while (!hands.contains(chooseHand)) {
            System.out.print("手を入力して下さい[R, P, S]: ");
            chooseHand = new Scanner(System.in).next().toUpperCase().charAt(0);
        }
        System.out.print("じゃんけん...");
        Thread.sleep(1500L);
        System.out.println("ポイ！");
        char enemyHand = hands.get(new Random().nextInt(3));
        String result = "";
        if (chooseHand == 'R') {
            if (enemyHand == 'R') {
                result = "あいこ";
            } else if (enemyHand == 'P') {
                result = "まけ";
            } else {
                result = "かち";
            }
        } else if (chooseHand == 'P') {
            if (enemyHand == 'R') {
                result = "かち";
            } else if (enemyHand == 'P') {
                result = "あいこ";
            } else {
                result = "まけ";
            }
        } else if (chooseHand == 'S') {
            if (enemyHand == 'R') {
                result = "まけ";
            } else if (enemyHand == 'P') {
                result = "かち";
            } else {
                result = "あいこ";
            }
        }

        System.out.println("相手: " + enemyHand);

        System.out.println(result);



    }
}
