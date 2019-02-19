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

        System.out.println("Numri i gjendjeve ne automat");
        int nrGjendeve = reader.nextInt();
        System.out.println("Numri i elemnteve ne gjuhe");
        int nrElementeve = reader.nextInt();
        String[] elementet = new String[nrElementeve];

        for (int i = 0; i < nrGjendeve; i++){
            System.out.println("Emri i gjendjes ");
            String emri_gjendjes = reader.next();
            gjendjet emri = new gjendjet(emri_gjendjes);
            automat.add(emri);
            System.out.println("Fundore per ta bere gjendje fundore \nfillim per ta bere gjendje fillimi \n");
            String fund_fillim = reader.next();
            if (fund_fillim.contains("fund")){
                ((gjendjet)automat.get(i)).Beje_gjendje_fundore();
            }else if (fund_fillim.contains("fillim")) {
                ((gjendjet)automat.get(i)).Beje_gjendje_fillestare();
            }


        }
        for(int i = 0; i < nrElementeve; i++) {
            System.out.println("Vendos elment te gjuhes");
            String element_ri = reader.next();
            elementet[i] = element_ri;
        }
        for (int i = 0 ; i < nrGjendeve; i++){

            for (int j = 0 ; j < nrElementeve; j++){
                System.out.println("Vendos lidhje per gjendjen "+((gjendjet)automat.get(i)).emri());
                System.out.println("-1 nëse nuk doni te shtoni lidhje per gjendjen ");
                System.out.println("1 nëse doni te shtoni elementin ne gjendje " + elementet[j]);
                String vendos_lidhjes = reader.next();
                if (vendos_lidhjes.contains("-1")) {
                    continue;
                }else if (vendos_lidhjes.contains("1")) {
                    ((gjendjet)automat.get(i)).shtoLidhje(elementet[j]);
                }
            }
        }
        for (int i = 0; i < automat.size() ; i++) {
            ((gjendjet)automat.get(i)).shtoFunde(nrGjendeve);
        }

        for (int i = 0 ; i < nrGjendeve; i++) {
            gjithe_gjendjet.add(((gjendjet)automat.get(i)).emri());
        }
        for (int i = 0; i < nrGjendeve; i++) {
                gjithe_funded.add(((gjendjet)automat.get(i)).gjendjet());
        }

        System.out.println(gjithe_funded);
        System.out.println(gjithe_gjendjet);

        System.out.println("Automati eshte me poshte");

        for (int i = 0 ; i < automat.size(); i++){
            ((gjendjet)automat.get(i)).Printo();
        }
        for (int i = 0; i < automat.size(); i++) {

            if(((gjendjet)automat.get(i)).Determinist()) {
                determinist = true;
            } else {
                determinist = false;
                break;
            }
            index_gabimi++;

        }
            if (!determinist ) {
                System.out.println("Automati eshte jodeterminist");
                System.out.println("Jodeterminizim ndodh ne indeks "+index_gabimi);
                if (index_gabimi == 0) {
                    for (int i = 0 ; i <= index_gabimi; i++) {
                        automati_determinist.add(automat.get(i));
                    }
                } else if (index_gabimi > 0) {
                    for (int i = 0 ; i < index_gabimi; i++) {
                        automati_determinist.add(automat.get(i));
                    }
                }
                ArrayList<ArrayList<String>> nej_per_nje = new ArrayList<>();

                for (int i = 0 ; i < nrGjendeve; i++) {
                    if (!gjithe_funded.contains(gjithe_funded.get(i)) || nej_per_nje.size() <= 0 || !gjithe_funded.equals(gjithe_funded.get(i))){
                        nej_per_nje.add(gjithe_funded.get(i));
                    }
                }
                System.out.println("nje "+nej_per_nje);
                ArrayList<ArrayList<String>> controllo = new ArrayList<>();
                while (vazhdo) {
                    if (index_gabimi == automat.size()) {
                        break;
                    } else {

                        String gjendje_re = "";
                        gjendje_re += ((gjendjet) automat.get(index_gabimi)).gjendje_re();

                            for (int i = 0; i < gjithe_gjendjet.size(); i++) {
                                    if (!gjithe_gjendjet.contains(gjendje_re))
                                    {
                                        gjithe_gjendjet.add(gjendje_re);
                                        shto = true;
                                        break;
                                    }
                                }
                            System.out.println(gjithe_gjendjet);
                            if (index_ri >= 1){
                                 gjatesi_kontrolli = nej_per_nje.size();
                            }
                            if (index_gabimi <= 0) {
                                shto = true;
                            }
                        if (shto) {
                            shto = false;
                            for (int i = 0 ; i < nej_per_nje.size(); i++) {
                                if (!nej_per_nje.contains(nej_per_nje.get(i))){
                                    nej_per_nje.add(((gjendjet) automat.get(index_gabimi)).gjendjet());
                                }
                            }
                            gjendjet gjendjet_re = new gjendjet(gjendje_re);
                            automati_determinist.add(gjendjet_re);
                            for (int i = 0; i < nrElementeve; i++) {
                                ((gjendjet) automati_determinist.get(automati_determinist.size() - 1)).shtoLidhje(elementet[i]);
                            }
                            System.out.println(nej_per_nje);
                            if (index_gabimi == 0) {
                                for (int i = 0; i < automati_determinist.size(); i++) {
                                    if (nej_per_nje.size() == 0) {
                                        ((gjendjet)automati_determinist.get(i)).shtoFundePerseritje(nej_per_nje.get(0));
                                    } else if (nej_per_nje.size() == automati_determinist.size()) {
                                        ((gjendjet)automati_determinist.get(i)).shtoFundePerseritje(nej_per_nje.get(i));
                                    }else if (nej_per_nje.size() < automati_determinist.size()) {
                                        for (int j = 0; j < nej_per_nje.size(); j++) {
                                            ((gjendjet)automati_determinist.get(i)).shtoFundePerseritje(nej_per_nje.get(j));
                                        }
                                    }

                                }
                            } else {
                                for (int j = 0; j < nej_per_nje.size(); j++) {
                                    if (nej_per_nje.size() == 0) {
                                        ((gjendjet)automati_determinist.get(j)).shtoFundePerseritje(nej_per_nje.get(0));
                                    } else {
                                        ((gjendjet)automati_determinist.get(index_gabimi)).shtoFundePerseritje(nej_per_nje.get(j));
                                    }

                                }
                            }


                        }
                        if (gjatesi_kontrolli < nej_per_nje.size()) {
                            break;
                        }
                        for (int i = 0; i < automati_determinist.size(); i++) {
                            boolean fundore = ((gjendjet)automat.get(i)).getFundore();
                            if (((gjendjet) automati_determinist.get(i)).emri().contains(((gjendjet)automat.get(i)).emri())) {
                                ((gjendjet) automati_determinist.get(i)).PrintoDeterminist(fundore);
                            } else {
                                ((gjendjet) automati_determinist.get(i)).Printo();
                            }

                        }
                        for (int i = 0; i < automati_determinist.size(); i++) {
                            if (((gjendjet) automat.get(i)).Determinist()) {
                                vazhdo = false;
                            } else {
                                vazhdo = true;
                                break;
                            }
                        }
                        index_gabimi++;
                        index_ri++;
                    }
                }


            } else {
                System.out.println("Automati eshte determinist");
            }


    }
}

