#pragma once
#include <iostream>;
#include "Date.h";
using namespace std;

class Technicien
{
private:
	string _matricule;
	string _nom;
	string _prenom;
	double _salaire_par_heure;
	double _nomber_heure;
	Date _date_embauche;

public:
	Technicien()
	{
		this->_matricule = "";
		this->_nom = "";
		this->_prenom = "";
		this->_nomber_heure = 0;
		this->_salaire_par_heure = 0;
		this->_date_embauche = Date();
	}

	Technicien(const string& matricule, const string& nom, const string& prenom, double salaire, double nombreHeure, const Date& date);
	Technicien(const Technicien& technicien);
	~Technicien();

public:
	string getMatricule() const;
	void setMatricule(const string& value);
	string getNom() const;
	void setNom(const string& value);
	string getPrenom() const;
	void setPrenom(const string& value);
	double getNombreHeure() const;
	void setNombreHeure(double value);
	double getSalaireParHeure() const;
	void setSalaireParHeure(double value);
	Date getDateEmbauche() const;
	void setDateEmbauche(const Date& value);

public:
	void Show() const;
	double CalculerSalaire() const;

};

