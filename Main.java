import java.util.*;

public class Main {
   public static ArrayList<Object> automat;
   public static ArrayList<Object> automati_determinist;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        automat = new ArrayList<>();
        automati_determinist = new ArrayList<>();
        boolean determinist = false;
        int index_gabimi = 0;
        boolean vazhdo = true;
        boolean shto = false;
        int index_ri = 0;
        int gjatesi_kontrolli = 99;
        ArrayList<String> gjithe_gjendjet = new ArrayList<>();
        ArrayList<ArrayList<String>> gjithe_funded = new ArrayList<>();
        int controll_gjendjesh = 0;
        boolean fundore = false;
        String fund_ri = "";
        boolean kaEpsilon = false;
        String gjendjeRe = "";
        String gjendje_re = "";
        boolean heraPare = true;

        System.out.println("Numri i gjendjeve ne automat");
        int nrGjendeve = reader.nextInt();
        System.out.println("Numri i elemnteve ne gjuhe");
        int nrElementeve = reader.nextInt();
        String[] elementet = new String[nrElementeve];

        for (int i = 0; i < nrGjendeve; i++) {
            System.out.println("Emri i gjendjes ");
            String emri_gjendjes = reader.next();
            gjendjet emri = new gjendjet(emri_gjendjes);
            automat.add(emri);
            System.out.println("Fundore per ta bere gjendje fundore \nfillim per ta bere gjendje fillimi \n");
            String fund_fillim = reader.next();
            if (fund_fillim.contains("fund")) {
                ((gjendjet) automat.get(i)).Beje_gjendje_fundore();
            } else if (fund_fillim.contains("fillim")) {
                ((gjendjet) automat.get(i)).Beje_gjendje_fillestare();
            }

        }
        for (int i = 0; i < nrElementeve; i++) {
            System.out.println("Vendos elment te gjuhes");
            String element_ri = reader.next();
            elementet[i] = element_ri;
        }
        for (int i = 0; i < nrGjendeve; i++) {

            for (int j = 0; j <= nrElementeve; j++) {
                kaEpsilon = false;
                if (j == nrElementeve) {
                    System.out.println("Doni te shtoni elementin eplsilon ne lidhje");
                    System.out.println("Shto nese doni te shtoni epsilon");
                    String epsilon = reader.next();
                    if (epsilon.contains("shto") || epsilon.equals("1")){
                        kaEpsilon = true;
                        ((gjendjet)automat.get(i)).shtoLidhje("E", kaEpsilon);
                    } else if (epsilon.contains("-1")) {

                    }
                }else {
                    System.out.println("Vendos lidhje per gjendjen " + ((gjendjet) automat.get(i)).emri());
                    System.out.println("-1 nëse nuk doni te shtoni lidhje per gjendjen ");
                    System.out.println("1 nëse doni te shtoni elementin ne gjendje " + elementet[j]);
                    String vendos_lidhjes = reader.next();
                    if (vendos_lidhjes.contains("-1")) {
                        continue;
                    } else if (vendos_lidhjes.contains("1")) {
                        ((gjendjet) automat.get(i)).shtoLidhje(elementet[j], kaEpsilon);
                    }
                }
            }

        }
        for (int i = 0; i < automat.size(); i++) {
            ((gjendjet) automat.get(i)).shtoFunde(nrGjendeve);
        }

        for (int i = 0; i < nrGjendeve; i++) {
            gjithe_gjendjet.add(((gjendjet) automat.get(i)).emri());
        }
        for (int i = 0; i < nrGjendeve; i++) {
            gjithe_funded.add(((gjendjet) automat.get(i)).gjendjet());
        }

        System.out.println(gjithe_funded);
        System.out.println(gjithe_gjendjet);

        System.out.println("Automati eshte me poshte");

        for (int i = 0; i < automat.size(); i++) {
            ((gjendjet) automat.get(i)).Printo(false);
        }
        for (int i = 0; i < automat.size(); i++) {

            if (((gjendjet) automat.get(i)).Determinist()) {
                determinist = true;
            } else {
                determinist = false;
                break;
            }
            index_gabimi++;

        }

        System.out.println("Perfundoi printimi");
        controll_gjendjesh = index_gabimi;

        if (kaEpsilon && !determinist) {
            gjithe_gjendjet.clear();
            index_gabimi = 0;
            ArrayList<String> afjd = new ArrayList<>();
            for (int i = 0; i < automat.size(); i++) {
                gjendjeRe = "";
                gjendjeRe += ((gjendjet)automat.get(i)).emri();
                for (int j = i; j < automat.size(); j++){
                        if (((gjendjet)automat.get(j)).kaEpsilon() &&
                                !gjendjeRe.contains(((gjendjet)automat.get(j)).funderEpsilon())) {
                            gjendjeRe +=  ((gjendjet)automat.get(j)).funderEpsilon();
                        }
                }
                System.out.println(gjendjeRe);
                gjendjet gjendja_re = new gjendjet(gjendjeRe);
                automati_determinist.add(gjendja_re);
                break;
            }

            kaEpsilon = false;

            for (int i = 0; i < automati_determinist.size(); i++) {
                for (int j = 0; j < nrElementeve; j++){
                    ((gjendjet)automati_determinist.get(i)).shtoLidhje(elementet[j],kaEpsilon);
                }
            }

            shtoFunde(nrElementeve,0,fund_ri);

            for (int i = 0; i < automati_determinist.size(); i++) {
                gjithe_gjendjet.add(((gjendjet)automati_determinist.get(i)).emri());
            }

            while (vazhdo) {
                if (automati_determinist.size() >= automat.size()){
                    vazhdo = false;
                }
                shkiopergjendjeRe(gjendje_re,index_gabimi,controll_gjendjesh,nrElementeve,afjd,heraPare);

                heraPare = false;
                System.out.println(afjd);
                int index_gjendje_pershtim = 0;
                int index_shtimi = 0;
                System.out.println("gjendjet e reja "+afjd);
                for (int i = 0; i < gjithe_gjendjet.size(); i++) {
                    for (int j = 0; j < afjd.size(); j++) {
                        if (!gjithe_gjendjet.contains(afjd.get(j)) ) {
                            gjithe_gjendjet.add(afjd.get(j));
                            shto = true;
                            index_shtimi++;
                            index_gjendje_pershtim = j;
                            vazhdo = true;
                            break;
                        }
                    }
                }
                if (shto){
                    shto = false;
                    index_gabimi++;
                    if (index_shtimi == 1) {
                        gjendjet gjendjet_re = new gjendjet(afjd.get(index_gjendje_pershtim));
                        automati_determinist.add(gjendjet_re);
                    } else {
                        for (int i = gjithe_gjendjet.size() - index_shtimi; i < gjithe_gjendjet.size(); i++) {
                            gjendjet gjendjet_re = new gjendjet(gjithe_gjendjet.get(i));
                            automati_determinist.add(gjendjet_re);
                        }
                    }

                    System.out.println(automati_determinist.size());

                    for (int i = index_gabimi; i < automati_determinist.size(); i++) {
                        for (int j = 0; j < nrElementeve; j++){
                            ((gjendjet)automati_determinist.get(i)).shtoLidhje(elementet[j],kaEpsilon);
                        }
                    }

                    shtoFunde(nrElementeve,index_gabimi,fund_ri);
                }
            }

            printoAutomatin(fundore);

        } else if (!determinist && !kaEpsilon) {
            System.out.println("Automati eshte jodeterminist");
            System.out.println("Jodeterminizim ndodh ne indeks " + index_gabimi);
            if (index_gabimi == 0) {
                for (int i = 0; i <= index_gabimi; i++) {
                    automati_determinist.add(automat.get(i));
                }
            } else {
                for (int i = 0; i <= index_gabimi; i++) {
                    automati_determinist.add(automat.get(i));
                }
            }
            ArrayList<String> gjithesej = new ArrayList<>();
            while (vazhdo) {
                if (index_gabimi == automat.size()) {
                    vazhdo = false;
                } else {
                    gjithesej.clear();
                    shkiopergjendjeRe(gjendje_re,index_gabimi,
                                       controll_gjendjesh,nrElementeve,gjithesej,
                                       heraPare);
                    heraPare = false;
                    int index_gjendje_pershtim = 0;
                    int index_shtimi = 0;
                    System.out.println(gjithesej);
                    for (int i = 0; i < gjithe_gjendjet.size(); i++) {
                        for (int j = 0; j < gjithesej.size(); j++) {
                            if (!gjithe_gjendjet.contains(gjithesej.get(j)) ) {
                                gjithe_gjendjet.add(gjithesej.get(j));
                                shto = true;
                                index_gjendje_pershtim = j;
                                index_shtimi++;
                                vazhdo = true;
                                break;
                            }
                        }
                    }
                        if (index_gabimi <= 0) {
                            shto = true;
                        }
                        if (shto) {
                            shto = false;
                            if (index_shtimi == 1) {
                                gjendjet gjendjet_re = new gjendjet(gjithesej.get(index_gjendje_pershtim));
                                automati_determinist.add(gjendjet_re);
                            } else {
                                for (int i = gjithe_gjendjet.size() - index_shtimi; i < gjithe_gjendjet.size(); i++) {
                                    gjendjet gjendjet_re = new gjendjet(gjithesej.get(i));
                                    automati_determinist.add(gjendjet_re);
                                }
                            }
                            shtoLidhje(nrElementeve,elementet,kaEpsilon);
                            if (index_gabimi == 0) {
                                ((gjendjet) automati_determinist.get(0))
                                        .shtoFundePerseritje(gjithe_gjendjet.get(gjithe_gjendjet.size() - 1));
                                ((gjendjet) automati_determinist.get(automati_determinist.size() - 1))
                                        .shtoFundePerseritje(gjithe_gjendjet.get(gjithe_gjendjet.size() - 1));
                            } else {
                               shtoFunde(nrElementeve,index_gabimi,fund_ri);
                            }
                            printoAutomatin(fundore);

                        }
                        index_gabimi++;
                        index_ri++;
                    }
                }


            } else{
                System.out.println("Automati eshte determinist");
            }
        }
        public static void shtoFunde (int nrElementeve, int index_gabimi, String fund_ri){
            for (int j = 0; j < nrElementeve; j++){
                fund_ri = "";
                for (int i = index_gabimi; i < automati_determinist.size(); i++) {
                    fund_ri = "";
                    for (int c = 0; c < automat.size(); c++) {
                        if (((gjendjet)automati_determinist.get(i)).emri()
                                .contains(((gjendjet) automat.get(c)).emri())) {
                            if (!fund_ri.contains(((gjendjet)automat.get(c)).gjendje_re(j))){
                                fund_ri += ((gjendjet)automat.get(c)).gjendje_re(j);
                            }
                            ((gjendjet)automati_determinist.get(i)).shtoFundePerseritjePerFillimi(fund_ri, j);
                        }
                    }
                }
            }
        }
        public static void printoAutomatin(boolean fundore) {

            for (int i = 0; i < automati_determinist.size(); i++) {
                fundore = false;
                for (int j = 0; j < automat.size(); j++) {
                    if (((gjendjet) automat.get(j)).getFundore() ||
                            ((gjendjet) automati_determinist.get(i)).emri().contains(((gjendjet) automat.get(j)).emri())) {
                        fundore = true;
                        break;
                    }
                }
                if (fundore) {
                    ((gjendjet) automati_determinist.get(i)).Printo(fundore);
                } else {
                    ((gjendjet) automati_determinist.get(i)).Printo(fundore);
                }
            }
        }

        public static void shtoLidhje(int nrElementeve, String[] elementet,boolean kaEpsilon){
            for (int i = 0; i < nrElementeve; i++) {
                ((gjendjet) automati_determinist.get(automati_determinist.size() - 1)).shtoLidhje(elementet[i], kaEpsilon);
            }
        }
        //Algorimi per te pare gjendje te reja
        public static void shkiopergjendjeRe(String gjendje_re,
                                             int index_gabimi,
                                             int controll_gjendjesh,
                                             int nrElementeve,
                                             ArrayList<String> gjithesej,
                                             boolean herapare) {
            gjendje_re = "";
            if (herapare && index_gabimi == 0) {
                for (int i = 0 ;i < nrElementeve; i++) {
                    gjendje_re =  "";
                    gjendje_re += ((gjendjet)automati_determinist.get(index_gabimi)).gjendje_re(i);
                    if (!gjithesej.contains(gjendje_re)){
                        gjithesej.add(gjendje_re);
                    }
                }

            } else if (index_gabimi >= 1) {
                for (int j = 0; j < nrElementeve; j++) {
                    gjendje_re = "";
                    for (int c = 0; c < automati_determinist.size(); c++) {
                        gjendje_re = "";
                        for (int i = 0; i < automat.size(); i++) {
                            if ( ((gjendjet)automati_determinist.get(c)).emri()
                                    .contains(((gjendjet) automat.get(i)).emri()) &&
                                    !gjendje_re.contains(((gjendjet)automat.get(i)).gjendje_re(j)) ) {
                                gjendje_re += ((gjendjet)automat.get(i)).gjendje_re(j);
                                if (!gjithesej.contains(gjendje_re)) {
                                    gjithesej.add(gjendje_re);
                                }
                            }
                        }
                    }

                }
            }
        }
    }

