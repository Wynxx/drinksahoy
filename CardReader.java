package cards;

public class CardReader {

    private String card;
    private String description;

    public CardReader() {
    }

    public CardReader(String card, String description) {
        this.card = card;

        this.description = description;
    }

    public String getCard() {
        return card;
    }

    public String getDescription() {
        return description;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "StadardDeck{" + "card=" + getCard() + ", description=" + getDescription() + '}';
    }

}
