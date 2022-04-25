package bg.softuni.ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArticlesTwo {
    static class article {
        String title;
        String content;
        String author;

        public article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        void printArticle() {
            System.out.printf("%s - %s: %s%n", this.title, this.content, this.author);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<article> allArticles = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            article article = new article(data[0], data[1], data[2]);
            allArticles.add(article);
        }

        String inputs = scanner.nextLine();

        allArticles.forEach(article::printArticle);
    }
}
