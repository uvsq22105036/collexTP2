package fr.uvsq.cprog.collex.exo2;
import java.util.*;
import java.io.*;
public class UI implements Serializable {
    private String[] commandes;
    private String[] figures;
    private Figures[] dessin;
    private int nbfigure;
    public UI(){
        commandes = new String[] {"new","show","move","clear","save","quit"};
        figures = new String[] {"rectangle","cercle"};
        dessin = new Figures[10];
        nbfigure = 0;
    }
    public void getFigure_saved(){
        try {
            File fichier = new File("/Users/theobruant/Desktop/DESSIN_JAVA/figures.ser");
            ObjectInputStream oos =  new ObjectInputStream(new FileInputStream(fichier)) ;
            Figures[] f = (Figures[])oos.readObject();
            dessin = f;
            nbfigure = 0;
            for (int i=0;i<dessin.length;i++)
            {
                if (dessin[i] instanceof Figures)
                {
                    nbfigure += 1;
                }
            }
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void printcommande()
    {
        System.out.println("[1] new: créer une nouvelle figure ");
        System.out.println("[2] show : afficher le dessin en ligne de console ");
        System.out.println("[3] move : déplacer une figure ");
        System.out.println("[4] clear : efface tous les dessins ");
        System.out.println("[5] save : sauvegarde le dessin ");
        System.out.println("[6] quit : au revoir :( ");

        
    }
    public void printFigures(){
        System.out.println("Figures disponibles : ");
        System.out.println("[1] Rectangle ");
        System.out.println("[2] Cercle");
    }
    public void show(){
        System.out.println("Figures présentes : ");
        for (int i=0;i<nbfigure;i++){
            System.out.print("["+Integer.toString(i+1)+"] ");
            dessin[i].print();
        }
        System.out.println("Nb figures : "+nbfigure);
    }
    public Point newPoint()
    {
        System.out.print("X :");
        Scanner scan = new Scanner(System.in);
        String in = scan.nextLine();
        int x = Integer.parseInt(in);
        System.out.print("Y :");
        scan = new Scanner(System.in);
        in = scan.nextLine();
        int y = Integer.parseInt(in);
        return new Point(x,y);
    }
    public void newFig()
    {
        System.out.println("Création d'une nouvelle figure...");
        printFigures();
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int input = Integer.parseInt(in);
        switch (input)
        {
            case 1:
                System.out.println("Rectangle##");
                System.out.println("Coin infèrieur gauche : ");
                Point bg = newPoint();
                System.out.println("Coin supèrieur droit :");
                Point hd = newPoint();
                dessin[nbfigure] = new Rectangle(bg,hd);
                dessin[nbfigure].print();
                nbfigure += 1;
                break;
            case 2:
                System.out.println("Cercle##");
                System.out.println("Centre : ");
                Point centre = newPoint();
                System.out.println("Rayon :");
                scanner = new Scanner(System.in);
                in = scanner.nextLine();
                int rayon = Integer.parseInt(in);
                dessin[nbfigure] = new Cercle(centre,rayon);
                dessin[nbfigure].print();
                nbfigure +=1;
                break;
            default:
                System.out.println("Choix invalide.");
                printFigures();
        }

    }
    
    public void move()
    {
        show();
        List<Integer> figabouger = new ArrayList<Integer>();
        int input = 1;
        do {
            System.out.println("Quelle figure souhaitez-vous bouger ? ( tapez 0 pour arrêter )");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            if (input > 0 && input <= nbfigure)
                figabouger.add(input);
        }while(input!=0);
        System.out.println(figabouger);
        for (int i=0;i<figabouger.size();i++){
            System.out.println("Move de la Figure "+figabouger.get(i));
            System.out.print("dX : ");
            Scanner scanner = new Scanner(System.in);
            int dx = scanner.nextInt();
            System.out.print("dY : ");
            scanner = new Scanner(System.in);
            int dy = scanner.nextInt();
            dessin[figabouger.get(i)-1].move(dx,dy);
        }
        
    }
    public void save() {
        System.out.println("Sauvegarde des données ...");
        try {
            File fichier = new File("/Users/theobruant/Desktop/DESSIN_JAVA/figures.ser");
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier));
            oos.writeObject(dessin);
            oos.close();
        }catch(FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void read(){
        printcommande();
        System.out.println("Votre choix : ");
        Scanner scanner = new Scanner(System.in);
        String in = scanner.nextLine();
        int input = Integer.parseInt(in);
        switch (input)
        {
            case 1:
                newFig();
                break;
            case 2:
                show();
                break;
            case 3:
                move();
                break;
            case 4:
                dessin = new Figures[10];
                nbfigure = 0;
                break;
            case 5: 
                save();
                break;
            case 6:
                System.out.println("Arrêt du programme...");
                getFigure_saved();  
                System.exit(0);
                break;
            default:
                System.out.println("Choix invalide.");
                printcommande();
        }

    }
}