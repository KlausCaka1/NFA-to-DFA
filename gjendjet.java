import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;


public class gjendjet {
    private String emri;
    private ArrayList<Object> lidhje;
    private Boolean fillimi = false;
    private Boolean fundore = false;
    private String gjendje_re = "";
    private ArrayList<String> gjendjet;
    public gjendjet(String emri){
        this.emri = emri;
        lidhje = new ArrayList<>();
        gjendjet = new ArrayList<>();
    }
    public void shtoLidhje( String emriGjendje) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Gjendejes " + this.emri + " Shtua elmenti "+ emriGjendje);
            lidhjet emri = new lidhjet(emriGjendje);
            lidhje.add(emri);
    }
    public void shtoFunde(int nrGjendjesh) {
        System.out.println("Gjendja "+ this.emri+ " shto fundet ");
        for (int i = 0 ; i < lidhje.size(); i++ ) {

            ((lidhjet)lidhje.get(i)).shtoFunde(nrGjendjesh);
        }

    }
    public void shtoFundePerseritje(ArrayList<String > elemntet) {
        for (int i = 0 ; i < lidhje.size(); i++ ) {
            ((lidhjet)lidhje.get(i)).shtoFundePerseritje(elemntet);
        }

    }
    public void Printo() {
        if (fundore == true) {
            System.out.println("Gjendja " +this.emri +" eshte fundore");
        } else if (fillimi == true) {
            System.out.println("Gjendja " +this.emri +" eshte fillestare ");
        } else if (fundore == false && fillimi == false ) {
            System.out.println("Gjendja " +this.emri);
        }
        for(int i = 0 ; i < lidhje.size(); i++ ){
            String emri = ((lidhjet)lidhje.get(i)).printoEmer();
            System.out.println("Lidhja "+emri+" ka funde ne "  );
            ((lidhjet)lidhje.get(i)).printo();
        }
    }
    public void PrintoDeterminist(boolean fundi) {
        if (fundore == true || fundi == true) {
            System.out.println("Gjendja " +this.emri +" eshte fundore");
        } else if (fillimi == true) {
            System.out.println("Gjendja " +this.emri +" eshte fillestare ");
        } else if (fundore == false && fillimi == false ) {
            System.out.println("Gjendja " +this.emri);
        }
        for(int i = 0 ; i < lidhje.size(); i++ ){
            String emri = ((lidhjet)lidhje.get(i)).printoEmer();
            System.out.println("Lidhja "+emri+" ka funde ne "  );
            ((lidhjet)lidhje.get(i)).printo();
        }
    }
    public String emri() {
        return this.emri;
    }
    public void Beje_gjendje_fundore() {
        fundore = true;
    }
    public void Beje_gjendje_fillestare() {
        fillimi = true;
    }
    public boolean Determinist() {
        for (int i = 0; i < lidhje.size(); i++){
            return ((lidhjet)lidhje.get(i)).Deteminist();
        }
        return true;
    }
    public Boolean asnje_gjendje_re () {
        return true;
    }
    public String gjendje_re(){
        ArrayList<String> gjendja_re = new ArrayList<>();
        String controll = "";
        for (int i = 0 ; i < lidhje.size(); i++) {
            gjendja_re.add(((lidhjet)lidhje.get(i)).merr_gjendje_re());
        }
        for (int i = 0; i < gjendja_re.size(); i++) {
            if (!controll.contains(gjendja_re.get(i))) {
                controll += gjendja_re.get(i);
            }

        }
        return controll;
    }
    public ArrayList<String> gjendjet(){
        for (int i = 0; i < lidhje.size(); i++){
             gjendjet.add(((lidhjet)lidhje.get(i)).gjendjet());
        }
        return gjendjet;
    }
    public boolean getFundore() {
        return fundore;
    }
}
