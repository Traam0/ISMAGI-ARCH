#include "Technicien.h"

string Technicien::getMatricule() const {
	return this->_matricule;
}

string Technicien::getNom() const {
	return this->_nom;
}

string Technicien::getPrenom() const {
	return this->_prenom;
}

double Technicien::getNombreHeure() const {
	return this->_nomber_heure;
}

double Technicien::getSalaireParHeure() const {
	return this->_salaire_par_heure;
}

Date Technicien::getDateEmbauche() const {
	return this->_date_embauche;
}

void Technicien::setMatricule(const string& value) {
	this->_matricule = value;
}

void Technicien::setNom(const string& value) {
	this->_nom = value;
}

void Technicien::setPrenom(const string& value) {
	this->_prenom = value;
}

void Technicien::setNombreHeure(double value) {
	if (value < 0) throw new exception("value must be nonnogative >= 0");
	this->_nomber_heure = value;
}

void Technicien::setSalaireParHeure(double value) {
	if (value < 0) throw new exception("value must be nonnogative >= 0");
	this->_salaire_par_heure = value;
}

void Technicien::setDateEmbauche(const Date& value) {
	this->_date_embauche = value;
}

double Technicien::CalculerSalaire() const {
	return this->_nomber_heure * this->_salaire_par_heure;
}

void Technicien::Show() const {
	cout << this->_nom << this->_prenom << "startetd at " << this->_date_embauche.Show() << " with salary of " << this->CalculerSalaire() << endl;
}

Technicien::Technicien(const string& matricule, const string& nom, const string& prenom, double salaireParHeure, double nombreHeure, const Date& dateEmbauche) {
	this->setMatricule(matricule);
	this->setNom(nom);
	this->setPrenom(prenom);
	this->setSalaireParHeure(salaireParHeure);
	this->setNombreHeure(nombreHeure);
	this->setDateEmbauche(dateEmbauche);
}

Technicien::Technicien(const Technicien& technicien) {
	this->setMatricule(technicien.getMatricule());
	this->setNom(technicien.getNom());
	this->setPrenom(technicien.getPrenom());
	this->setSalaireParHeure(technicien.getSalaireParHeure());
	this->setNombreHeure(technicien.getNombreHeure());
	this->setDateEmbauche(technicien.getDateEmbauche());
}

Technicien::~Technicien() {
	cout << "instance Technicien : " << this->_matricule << "has been destroyed" << endl;
}