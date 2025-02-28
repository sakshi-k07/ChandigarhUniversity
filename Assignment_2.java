/*
 * Aim: 
 * To create a program that collects and stores all the cards, assisting users in finding all the 
 * cards with a given symbol using the Collection interface.
 *
 * Objectives:
 * 1. Implement a Card class to store details of each card.
 * 2. Use a Collection interface (ArrayList) to store multiple cards.
 * 3. Allow users to add cards dynamically.
 * 4. Implement a method to retrieve all cards based on a given symbol.
 * 5. Provide a user-friendly interface for searching and displaying cards.
 */
//Code
import java.util.*;

class Card {
    private String symbol;
    private String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[" + symbol + " " + value + "]";
    }
}

public class CardCollection {
    private Collection<Card> cards;

    public CardCollection() {
        cards = new ArrayList<>();
    }

    public void addCard(String symbol, String value) {
        cards.add(new Card(symbol, value));
    }
    
    public List<Card> findCardsBySymbol(String symbol) {
        List<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getSymbol().equalsIgnoreCase(symbol)) {
                result.add(card);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollection collection = new CardCollection();

        collection.addCard("Hearts", "A");
        collection.addCard("Spades", "10");
        collection.addCard("Hearts", "K");
        collection.addCard("Diamonds", "5");
        collection.addCard("Clubs", "Q");

        System.out.println("Name: Sakshi, UID: 22BCS12824");
        System.out.print("Enter a symbol to find all matching cards: ");
        String symbol = scanner.nextLine();
        List<Card> foundCards = collection.findCardsBySymbol(symbol);

        if (foundCards.isEmpty()) {
            System.out.println("No cards found with symbol " + symbol);
        } else {
            System.out.println("Cards found: " + foundCards);
        }

        scanner.close();
    }
}
