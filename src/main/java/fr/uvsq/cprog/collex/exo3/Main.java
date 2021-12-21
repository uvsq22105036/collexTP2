package fr.uvsq.cprog.collex.exo3;
import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class Main {
    public static void main( String[] args) {
        List<Employee> employee = new ArrayList<>();
        Employee Bob = new Employee("Bob",21,2000,Esexe.masculin,Eservice.admin,LocalDate.of(2021,2,11));
        Employee Alice = new Employee("Alice",24,2600,Esexe.feminin,Eservice.comm,LocalDate.of(2020,12,9));
        Employee Margaux = new Employee("Margaux",30,3000,Esexe.feminin,Eservice.admin,LocalDate.of(2015,2,12));
        Employee Theo = new Employee("Theo",22,2800,Esexe.masculin,Eservice.tech,LocalDate.of(2021,8,21));
        Employee Pierre = new Employee("Pierre",55,3400,Esexe.masculin,Eservice.admin,LocalDate.of(2016,6,16));
        Employee Paul = new Employee("Paul",30,3400,Esexe.masculin,Eservice.rh,LocalDate.of(2011,10,2));
        Employee Anaelle = new Employee("Anaelle",22,2800,Esexe.feminin,Eservice.comm,LocalDate.of(2020,10,10));
        Employee Emma = new Employee("Emma",18,200,Esexe.feminin,Eservice.tech,LocalDate.of(2017,7,8));
        Employee Marc = new Employee("Marc",62,5000,Esexe.masculin,Eservice.rh,LocalDate.of(2010,8,7));
        employee.add(Bob);
        employee.add(Alice);
        employee.add(Margaux);
        employee.add(Theo);
        employee.add(Pierre);
        employee.add(Paul);
        employee.add(Anaelle);
        employee.add(Emma);
        employee.add(Marc);
        
        //Afficher tous les employes
        System.out.println("Liste de tous les employés : ");
        employee.stream().forEach(System.out::println);  //pour chaque employé du stream, on affiche ses infos avec println
        System.out.println("\n");

        //Afficher tous les employes de moins de 30 ans
        System.out.println("Liste de tous les employés de moins de 30 ans");
        List<Employee> jeunes = employee.stream().filter(e -> e.getAge() < 30).collect(Collectors.toList()); //On collecte suivant le filtre d'age
        for (int i = 0; i<jeunes.size();i++)
            System.out.println(jeunes.get(i).toString());
        System.out.println("\n");

        //Le nom de tous les hommes
        System.out.println("Le nom de tous les hommes : ");
        employee.stream().filter(e -> e.getSexe() == Esexe.masculin).map(e -> e.getName()).forEach(System.out::println);
        System.out.println("\n");

        //Le nom et le salaire triés par salaire décroissant
        List<Employee> result = employee.stream().sorted(Comparator.comparing(Employee::getSalaire).reversed()).collect(Collectors.toList());
        for (int i = 0; i<result.size();i++)
            System.out.println(result.get(i).toString());
        System.out.println("\n");


        //Moyenne de salaire des employés 
        System.out.println("Moyenne de salaire de tous les employés : ");
        Double Avg_salaire = employee.stream().collect(Collectors.averagingInt(e->e.getSalaire()));
        System.out.println(Avg_salaire);
        System.out.println("\n");


        //Les employés regroupées selon leur sexe :
        List<Employee> hommes = employee.stream().filter(e -> e.getSexe() == Esexe.masculin).collect(Collectors.toList());//On filtre selon le sexe et on collect
        System.out.println("Hommes : ");
        for (int i = 0; i<hommes.size();i++)
            System.out.println(hommes.get(i).toString());
        List<Employee> femmes = employee.stream().filter(e -> e.getSexe() == Esexe.feminin).collect(Collectors.toList());
        System.out.println("Femmes : ");
        for (int i = 0; i<femmes.size();i++)
            System.out.println(femmes.get(i).toString());
        System.out.println("\n");
        
        
        //Moyenne des salaires par sexe 
        System.out.println("Moyenne de salaire par sexe : ");
        Double Avg_salaire_men = employee.stream().filter(e -> e.getSexe() == Esexe.masculin).collect(Collectors.averagingInt(e->e.getSalaire()));//on filtre suivant l'enum sexe et on effectue la moyenne
        Double Avg_salaire_women = employee.stream().filter(e -> e.getSexe() == Esexe.feminin).collect(Collectors.averagingInt(e->e.getSalaire()));
        System.out.println("Salaire : (Homme) "+Avg_salaire_men+" (Femme) "+Avg_salaire_women);
        System.out.println("\n");
        
        //Nom et salaire par service :
        Map<Eservice, String> map = employee.stream().collect(Collectors.toMap(e -> e.getService(),e -> e.getName(),(name1, name2) -> name1 + ";" + name2));
        Map<Eservice, String> map2 = employee.stream().collect(Collectors.toMap(e -> e.getService(),e -> Integer.toString(e.getSalaire()),(name1, name2) -> name1 + ";" + name2));
        System.out.println(map);
        System.out.println(map2); //je n'arrive pas à les charger en même temps, j'affiche donc deux maps.



    }
}