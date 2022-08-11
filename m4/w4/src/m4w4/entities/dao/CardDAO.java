package m4w4.entities.dao;

import m4w4.entities.Card;

public class CardDAO extends JpaUtil<Card> {
	public CardDAO() {
		super(Card.class);
	}

}
