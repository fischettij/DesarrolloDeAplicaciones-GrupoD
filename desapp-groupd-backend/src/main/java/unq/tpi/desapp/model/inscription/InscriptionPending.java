package unq.tpi.desapp.model.inscription;

import unq.tpi.desapp.model.Inscription;

public class InscriptionPending extends InscriptionState {

	private static final long serialVersionUID = 6660286536120519913L;

	public InscriptionPending() {
	}

	@Override
	public void accepted(Inscription inscription) {
		inscription.setInscriptionState(new InscriptionAccepted());
	}
	
	public String getName(){
		return "Pending";
	}


}
