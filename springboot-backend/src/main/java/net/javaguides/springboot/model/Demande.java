package net.javaguides.springboot.model;

import jakarta.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Demandes")
public class Demande {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank
    @Column(name = "type_Contact")
    private String typeContact;

    @NotBlank
    @Column(name = "Prenom_")
    private String prenom;

    @NotBlank
    @Column(name = "Nom_")
    private String nom;

    @NotBlank
    @Column(name = "raisonSociale")
    private String raisonSociale;

    @NotNull
    
    @NotBlank
    // @Digits(integer = 15, fraction = 0)
    @Max(value = 999999999999999L, message = "ICE doit être inférieur ou égal à 999,999,999,999,999")
    @Min(value = 111111111111111L, message = "ICE doit être supérieur ou égal à 111,111,111,111,111")
    @Column(name = "ice")
    private Long ice;

    @NotBlank
    @Column(name = "Adresse")
    private String adresse;

    @Column(name = "Telephone")
    private Integer telephone;

    @Column(name = "Mobile")
    private Integer mobile;

    @NotBlank
    @Email
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Column(name = "type_demande")
    private String typeDemande;

    @NotBlank
    @Column(name = "Description")
    private String description;
	
	public Demande() {
		
	}
	
	public Demande(String typeContact, String prenom, String nom,  String raisonSociale, Long ice, String adresse ,
	Integer telephone,Integer mobile , String email, String typeDemande , String description) {
	super();
		this.typeContact = typeContact;
		this.prenom = prenom;
		this.nom = nom;
		this.raisonSociale=raisonSociale; 
		this.ice=ice;
		this.adresse=adresse;
		this.telephone=telephone;
		this.mobile=mobile ;
		this.email=email;
		this.typeDemande=typeDemande;
		this.description=description;
	}

    
	

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String getTypeContact() {
		return typeContact;
	}
	public void setTypeContact(String typeContact) {
		this.typeContact = typeContact;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRaisanSociale() {
		return raisonSociale;
	}
	public void setRaisanSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}


	public Long getICE() {
        return ice;
    }

    public void setICE(Long ice) {
        this.ice = ice;
    }


    public boolean isValidIce() {
        return ice != null && ice >= 111111111111111L && ice <= 999999999999999L;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(String typeDemande) {
        this.typeDemande = typeDemande;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}






