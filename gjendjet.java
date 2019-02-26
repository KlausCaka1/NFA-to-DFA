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
    private boolean Epsilon;

    public gjendjet(String emri){
        this.emri = emri;
        lidhje = new ArrayList<>();
        gjendjet = new ArrayList<>();
        Epsilon = false;
    }
    public void shtoLidhje( String emriGjendje,  boolean KaEpsilon) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Gjendejes " + this.emri + " Shtua elmenti "+ emriGjendje);
            lidhjet emri = new lidhjet(emriGjendje);
            lidhje.add(emri);
            if (KaEpsilon) {
            Epsilon = true;
        }
    }
    public void shtoFunde(int nrGjendjesh) {
        System.out.println("Gjendja "+ this.emri+ " shto fundet ");
        for (int i = 0 ; i < lidhje.size(); i++ ) {
            ((lidhjet) lidhje.get(i)).shtoFunde(nrGjendjesh);

        }

    }
    public void shtoFundePerseritje(String elemntet) {
        for (int i = 0 ; i < lidhje.size(); i++ ) {
            ((lidhjet)lidhje.get(i)).shtoFundePerseritje(elemntet);
        }

    }
    public void shtoFundePerseritjePerFillimi(String elemntet, int index) {

            ((lidhjet)lidhje.get(index)).shtoFundePerseritjeVazhdim(elemntet);


    }
    public void Printo(boolean fund) {
        if (fundore || fund) {
            System.out.println("Gjendja " +this.emri +" eshte fundore");
        } else if (fillimi || !fund) {
            System.out.println("Gjendja " +this.emri +" eshte fillestare ");
        } else if ((!fundore && !fillimi) || !fund ) {
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
    public Boolean kaEpsilon () {
        return Epsilon;
    }

    public String gjendje_re(int index){
        String controll = "";
            controll += ((lidhjet)lidhje.get(index)).merr_gjendje_re();
        return controll;
    }

    public String gjendjetona() {
        ArrayList<String> gjendja_re = new ArrayList<>();
        String controll = "";
        String perfundim = "";
        for (int i = 0 ; i < lidhje.size(); i++) {
            gjendja_re.add(((lidhjet)lidhje.get(i)).merr_gjendje_re());
        }

        for (int i = 0; i < gjendja_re.size(); i++) {
            if (!controll.contains(gjendja_re.get(i))) {
                controll += gjendja_re.get(i);
            }
        }
        System.out.println(controll);
        return controll;
    }

    public ArrayList<String> gjendjet(){
        for (int i = 0; i < lidhje.size(); i++){
             gjendjet.add(((lidhjet)lidhje.get(i)).gjendjet());
        }
        return gjendjet;
    }
    public String funderEpsilon() {
        return ((lidhjet)lidhje.get(lidhje.size() - 1)).merr_gjendje_re();
    }
    public boolean getFundore() {
        return fundore;
    }


}
