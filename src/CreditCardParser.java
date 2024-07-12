import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreditCardParser {

    public enum CardType {
        AMEX      ("Amex",       1121),
        MASTERCARD("Mastercard", 1111),
        VISA      ("Visa",       3796);


        final String name;
        final int number;

        CardType(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public static CardType getCardType(int number) {
            for (CardType value : CardType.values()) {
                if (value.number == number) {
                    return value;
                }
            }
            return null;
        }
    }

    public static CardType isCreditCardValid(String input) {
        String[] numberGroups = input.split("-");
        System.out.println("Number of groups: " + numberGroups.length);

        //Validate card type
        CardType cardType = CardType.getCardType(Integer.parseInt(numberGroups[0]));

        if (cardType == null) {
            throw new IllegalArgumentException("Invalid card type number: " + numberGroups[0]);
        }
        System.out.println("Card type: " + cardType.name);

        //Validate card expiration date
        SimpleDateFormat formatter = new SimpleDateFormat("MMyy");
        Date cardDate = null;
        try {
            cardDate = formatter.parse(numberGroups[3]);
            System.out.println(formatter.format(cardDate));
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }

        //Validate card number
        int cardNumberLength = input.length();
        System.out.println("Card number length: " + cardNumberLength);

        //Validate card number characters
//        boolean isDigits = true;
//        for (int i = 0; i < input.length(); i++) {
//            if (input.charAt(i) == '-') {
//                continue;
//            }
//            if (Character.isLetter(input.charAt(i))) {
//                isDigits = false;
//            }
//        }
        boolean isDigits = input.replace("-", "").matches("\\d+");

        CardType result = numberGroups.length == 4 &&
                input.length() == 19 &&
                cardDate != null &&
                cardDate.after(new Date()) &&
                isDigits ? cardType : null;
        System.out.println("Result: " + result);
        System.out.println("____________________");

        return result;
    }

    public static CardType isCreditCardValid() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input credit card number:");
        String input = scanner.next();
        return isCreditCardValid(input);
    }

    private static boolean validateLuhn(String cardNumber) {
        int sum = 0;
        boolean alternate = false;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));
            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n = (n % 10) + 1;
                }
            }
            sum += n;
            alternate = !alternate;
        }
        return (sum % 10 == 0);
    }

    public static void main(String[] args) {
        //Positive tests
        System.out.println("Positive tests:");
        CreditCardParser.isCreditCardValid("1121-1111-1111-0624");
        CreditCardParser.isCreditCardValid("1111-1111-1111-0625");
        CreditCardParser.isCreditCardValid("3796-1111-1111-0726");
        //Negative tests
        System.out.println("Negative tests:");
        CreditCardParser.isCreditCardValid("1121-1111-1111-0524");
        CreditCardParser.isCreditCardValid("1111-1111-1111-0424");
        CreditCardParser.isCreditCardValid("3796-1111-1111-0323");
        CreditCardParser.isCreditCardValid("3796-1111-111A-0726");
        isCreditCardValid();
        isCreditCardValid();
    }
}
