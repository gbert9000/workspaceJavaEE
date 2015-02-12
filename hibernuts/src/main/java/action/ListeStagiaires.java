package action;

import java.util.List;

import modelDAO.HibernateUtils;
import action.Stagiaire;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class ListeStagiaires extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Stagiaire stagiaire;
	private List<Stagiaire> stagiaires;

	public ListeStagiaires() {}
	
	@Override
    public String execute() {
		String SQL_QUERY ="from Stagiaire";
		Session session = HibernateUtils.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		List<Stagiaire> liste = session.createQuery(SQL_QUERY).list();
		if(!liste.isEmpty()) {
			setStagiaires(liste);
			return SUCCESS;
		}
		else {
			addActionError("Pas de stagiaires dans la bdd");
			return ERROR;
		}
    }

	public Stagiaire getStagiaire() {
		return stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
}
