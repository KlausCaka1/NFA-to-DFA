import java.util.*;
import java.util.stream.Collectors;

public class lidhjet {
    private String emri_lidhje;
    private ArrayList<String> fundet;
    private ArrayList<String> gjendjet_re;
    private boolean eplison;

    public lidhjet(String emri) {
        this.emri_lidhje = emri;
        fundet = new ArrayList<>();
        gjendjet_re = new ArrayList<>();
        eplison = false;
    }
    public void shtoFunde(int nrGjendesh) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Lidhja me emer " + emri_lidhje);
        String fundi;
        for (int i = 0; i < nrGjendesh; i++) {
            System.out.println("Shto fundin per lidhje");
            System.out.println("-1 nese nuk doni te shtoni elemnt");
            fundi = reader.next();
            if (fundi.contains("-1")) {
                continue;
            } else if (!fundet.contains(fundi)) {
                fundet.add(fundi);
            }
        }
    }
    public void shtoFundePerseritje(String element) {
        if (fundet.size() == 0) {
            fundet.add(element);
        }
      else if (fundet.size() > 1) {
         fundet.clear();
          fundet.add(element);
      }
    }
    public void shtoFundePerseritjeVazhdim(String element) {
            fundet.clear();
            fundet.add(element);
    }

    public void printo(){
        for (int i = 0; i < fundet.size(); i++ ){
            System.out.print(fundet.get(i));
            System.out.println("\n");
        }
    }
    public String printoEmer(){
        return this.emri_lidhje;
    }

    public boolean Deteminist() {
       if (fundet.size() == 1) {
           return true;
       } else {
           return false;
       }
    }

    public String gjendjet() {
        String gjendja = "";
        for (int i = 0; i < fundet.size(); i++) {
             gjendjet_re.add(fundet.get(i));
             gjendja += gjendjet_re.get(i);
        }
        return gjendja;
    }

    public String merr_gjendje_re(){
        String gjendje_re = "";
           for (int i = 0; i < fundet.size(); i++) {
               gjendje_re += fundet.get(i);
           }
        return gjendje_re;
    }

}
