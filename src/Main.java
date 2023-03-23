import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        long idNum = scanner.nextLong();
        int age = scanner.nextInt();
        System.out.println("Мазе бот v1 на Вашите услуги");
        System.out.println("Добре дошъл в мазето на баба " + firstName + " " + lastName);
        System.out.println("Ти се идентифицира с номер " + idNum);
        System.out.println("Ти си на " + age + " години");
        String applesWine = "ябълково вино";
        String smokedMeat = "пушено месо";
        String plumJam = "сливов мармалад";
        String marinatedPeppers = "мариновани чушки";
        String piggyBank = "прасенце касичка";
        int applesWineQuantity = 10;
        int smokedMeatQuantity = 5;
        int plumJamQuantity = 9;
        int marinatedPeppersQuantity = 4;
        double piggyBankQuantity = 184.35;
        String applesWineId = "C7544_10";
        String smokedMeatId = "M7441_5";
        String plumJamId = "S6491_9";
        String marinatedPeppersId = "P7485_4";
        String piggyBankId = "B6584_184.35";
        System.out.println("Отчет на продуктите в мазето");
        System.out.println("==================================================");
        System.out.println("|продукт           |брой      |нов сериен номер" + "  |");
        System.out.println("==================================================");
        System.out.println("|" + applesWine + "  " + "   |" +applesWineQuantity + "        " + "|" +applesWineId + "          |");
        System.out.println("|" + smokedMeat + "    " + "   |" +smokedMeatQuantity + "         " + "|" +smokedMeatId + "           |");
        System.out.println("|" + plumJam + "  " + " |" +plumJamQuantity + "        " + " |" +plumJamId + "           |");
        System.out.println("|" + marinatedPeppers + "  " + "|" +marinatedPeppersQuantity + "        " + " |" +marinatedPeppersId + "           |");
        System.out.println("|" + piggyBank + "  " + "|" +piggyBankQuantity + "    " + "|" +piggyBankId + "      |");
        System.out.println("==================================================");
        System.out.println(".");
    }
}