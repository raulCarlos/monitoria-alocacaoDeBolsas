package br.com.unb.entity;

import java.util.Comparator;

public class ComparatorOffer implements Comparator<Offer> {

	@Override
	public int compare(Offer off1, Offer off2) {
		return off1.getStudentsAmount() < off2.getStudentsAmount() ? -1 : (off1.getStudentsAmount() > off2.getStudentsAmount() ? +1 : 0);
	}

}
