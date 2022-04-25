package bg.softuni.ObjectsAndClassesExercise;

import java.util.Scanner;

public class Articles {
    static class article {
        String title;
        String content;
        String author;

        public article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }


        public void setTitle(String title) {
            this.title = title;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        void printArticle() {
            System.out.printf("%s - %s: %s%n", this.title, this.content, this.author);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArticle = scanner.nextLine().split(", ");

        article article = new article(firstArticle[0], firstArticle[1], firstArticle[2]);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(": ");
            String command = tokens[0];
            switch (command) {
                case "Edit":
                    article.setContent(tokens[1]);
                    break;
                case "ChangeAuthor":
                    article.setAuthor(tokens[1]);
                    break;
                case "Rename":
                    article.setTitle(tokens[1]);
                    break;
            }
        }

        article.printArticle();
    }
}
