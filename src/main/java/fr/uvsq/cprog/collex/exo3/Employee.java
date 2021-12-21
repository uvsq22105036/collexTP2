package fr.uvsq.cprog.collex.exo3;
import java.time.LocalDate;
enum Esexe {
    masculin, feminin,
};
enum Eservice {
    admin,comm,tech,rh
}
public class Employee {
    private String nom;
    private int age;
    private Esexe sexe;
    private int salaire; 
    private LocalDate date;
    private Eservice service;
    public Employee(String nom, int age,int salaire,Esexe sexe,Eservice service, LocalDate date)
    {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
        this.sexe = sexe;
        this.service = service;
        this.date = date;
    }
    public String toString() {
        return "Nom : "+this.nom+" | Age : "+this.age+" | Sexe : "+this.sexe+"  | Service : "+this.service+" | Embauche : "+this.date+" | Salaire : "+this.salaire;
    }
    public int getAge()
    {
        return this.age;
    }
    public int getSalaire()
    {
        return this.salaire;
    }
    public Esexe getSexe()
    {
        return this.sexe;
    }
    public Eservice getService(){
        return this.service;
    }
    public String getName()
    {
        return this.nom;
    }
}