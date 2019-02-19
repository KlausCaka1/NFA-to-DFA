import java.util.*;

public class perfundimet {
    private ArrayList<String> perfundimet;

    public perfundimet () {
        perfundimet = new ArrayList<>();
    }
    public void shtoPerfundimet(int nrGjendjesh) {
        Scanner reader = new Scanner(System.in);
        for (int i = 0; i < nrGjendjesh; i++) {
            String perfundimi = reader.next();
            perfundimet.add(perfundimi);
        }

    }
}
