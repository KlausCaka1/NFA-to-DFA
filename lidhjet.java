import java.util.*;
import java.util.stream.Collectors;

public class lidhjet {
    private String emri_lidhje;
    private ArrayList<String> fundet;
    private ArrayList<String> gjendjet_re;

    public lidhjet(String emri) {
        this.emri_lidhje = emri;
        fundet = new ArrayList<>();
        gjendjet_re = new ArrayList<>();
    }
    public void shtoFunde(int nrGjendesh) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Lidhja me emer " + emri_lidhje);
        for (int i = 0; i < nrGjendesh; i++) {
            System.out.println("Shto fund te lidhjes ");
            System.out.println("-1 nëse nuk doni te shtoni funde");
            String fundi = reader.next();
            if (fundet.size() >= 1) {
                for (int j = 0; j < fundet.size(); j++) {
                    if (fundi.contains("-1") || fundi.contains(fundet.get(j))){
                        break;
                    } else  {
                        fundet.add(fundi);
                        break;
                    }
                }

            } else {
                if (fundi.equals("-1")){
                    continue;
                } else  {
                    fundet.add(fundi);
                }
            }

        }
    }
    public void shtoFundePerseritje(ArrayList<String> element) {
        for (int i = 0; i < element.size(); i++) {
                if (!fundet.contains(element.get(i)) ){
                    fundet.add(element.get(i));
                }
        }
        for (int i = 0 ; i < fundet.size(); i++) {
            for (int j = 0; j < fundet.size(); j++){

                if (fundet.size() == 1) {
                break;
            }
                if (fundet.get(j).contains(fundet.get(i))) {
                    fundet.remove(i);
                }
            }
        }

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
        String controll = "";
        ArrayList<String> gjendja_re = new ArrayList<>();

            for (int i = 0 ;i < fundet.size(); i++) {
              gjendja_re.add(fundet.get(i));
              controll += gjendja_re.get(i);
            }
           for (int i = 0; i < gjendja_re.size(); i++) {
               gjendje_re += gjendja_re.get(i);
           }
        return gjendje_re;
    }

    public int gjatesia() {
        return fundet.size();
    }

}
