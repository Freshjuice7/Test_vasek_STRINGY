public class Uzivatel {
    private String jmeno;
    private String prijmeni;
    private String datumNarozeni;
    private StringBuffer email;
    private int hesloSlozitost;
    private int hesloDelka;
    private StringBuffer heslo;


    public Uzivatel(String jmeno, String prijmeni, String datumNarozeni, int hesloDelka, int hesloSlozitost) {
        this.jmeno = String.valueOf(upravJmeno(jmeno));
        this.prijmeni = String.valueOf(upravPrijmeni(prijmeni));
        this.datumNarozeni = datumNarozeni;
        this.email = sifraEmail();
        this.heslo = generujHeslo(hesloDelka, hesloSlozitost);
    }


    public StringBuffer upravPrijmeni(String prijmeni) {
        StringBuffer sb = new StringBuffer(prijmeni);
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i <= sb.length() - 1; i++) {
            if (Character.isLetter(sb.charAt(i))) {
                sb2.append(sb.charAt(i));
            } else {

            }
        }
        return sb2;
    }


    public StringBuffer upravJmeno(String jmeno) {
        StringBuffer sb = new StringBuffer(jmeno);
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i <= sb.length() - 1; i++) {
            if (Character.isLetter(sb.charAt(i))) {
                sb2.append(sb.charAt(i));
            } else if (sb.charAt(i) == ' ' && sb.charAt(i + 1) != ' ') {
                sb2.append(sb.charAt(i));
            } else {

            }

        }
        return sb2;
    }

    public void kontrolaNarozenin() {

    }

    public void kdyNarozeniny() {

    }


    public StringBuffer udelejEmail() {
        StringBuffer sbPrijmeni = new StringBuffer(upravPrijmeni(prijmeni));
        StringBuffer sbJmeno = new StringBuffer(upravJmeno(jmeno));
        StringBuffer mail = new StringBuffer();
        mail.append(sbPrijmeni.substring(0, 3));
        mail.append(sbJmeno.substring(0, 3));
        int randomNum = (int) (Math.random() * 200);
        mail.append(randomNum);
        mail.append("@");
        mail.append("seznam.cz");
        return mail;

    }

    public Boolean zkontrolujEmail(String email) {
        StringBuffer sbmail = new StringBuffer(email);
        Boolean ok = true;
        String zatecka;
        if (sbmail.isEmpty()) {
            ok = false;
        }
        if (sbmail.indexOf("@") == -1) {
            ok = false;
        }

        if (sbmail.indexOf(".") != -1) {
            for (int i = sbmail.indexOf("."); i < sbmail.length(); i++) {
                if (sbmail.charAt(i) == ' ') {
                    ok = false;
                }
                if (sbmail.charAt(i) == '@') {
                    ok = false;
                }
            }

        } else {
            ok = false;
        }


        return ok;
    }

    public StringBuffer sifraEmail() {
        StringBuffer sifra = new StringBuffer();
        String email = String.valueOf(udelejEmail());
        if (zkontrolujEmail(email)) {
            String uzivatel = email.substring(0, email.indexOf("@"));
            String domena = email.substring(email.indexOf("@") + 1, email.indexOf("."));
            String tld = email.substring(email.indexOf("."));

            sifra.append(uzivatel.substring(0, Math.min(2, uzivatel.length())));
            for (int i = 0; i < uzivatel.length() - 2; i++) {
                sifra.append("*");
            }
            sifra.append("@");
            sifra.append(domena.substring(0, 1));
            for (int i = 0; i < domena.length() - 2; i++) {
                sifra.append("*");
            }
            sifra.append(domena.substring(domena.length() - 1));
            sifra.append(tld);
        }
        return sifra;
    }


    public StringBuffer generujHeslo(int Delka, int slozitost) {
        StringBuffer sb = new StringBuffer();
        switch (slozitost) {
            case 1: {
                for (int i = 0; i < Delka; i++) {
                    int randomNum = (int) (Math.random() * 9);
                    sb.append(randomNum);
                }
                break;
            }
            case 2: {
                for (int i = 0; i < Delka; i++) {
                    int randomNeco = (int) (Math.random() * 2);
                    if (randomNeco == 0) {
                        int randomNum = (int) (Math.random() * (90 - 65) + 65);
                        char neco = (char) randomNum;
                        sb.append(neco);
                    } else {
                        int randomNum = (int) (Math.random() * 9);
                        sb.append(randomNum);
                    }

                }
                break;
            }
            case 3: {
                for (int i = 0; i < Delka; i++) {
                    int randomNeco = (int) (Math.random() * 5);
                    if (randomNeco == 0) {
                        int randomNum = (int) (Math.random() * (90 - 65) + 65);
                        char neco = (char) randomNum;
                        sb.append(neco);
                    } else if (randomNeco == 1) {
                        int randomNum = (int) (Math.random() * 9);
                        sb.append(randomNum);
                    } else if (randomNeco == 2) {
                        int randomNum = (int) (Math.random() * (122 - 97) + 97);
                        char neco = (char) randomNum;
                        sb.append(neco);
                    } else {
                        int randomNum = (int) (Math.random() * (47 - 33) + 33);
                        char neco = (char) randomNum;
                        sb.append(neco);
                    }

                }
            break;
            }

        }
        return sb;
    }


    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = String.valueOf(upravJmeno(jmeno));
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = String.valueOf(upravPrijmeni(prijmeni));
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public StringBuffer getEmail() {
        return email;
    }

    public void setEmail(StringBuffer email) {

        if (zkontrolujEmail(email.toString())) {
            System.out.print("Korektnost Eemailu je: " + zkontrolujEmail(email.toString()));
            this.email = email;
        }
    }

    public StringBuffer getHeslo() {
        return heslo;
    }

    public void setHeslo(int hesloDelka, int hesloSlozitost) {
        this.heslo = generujHeslo(hesloDelka, hesloSlozitost);
    }

    public String toString() {
        return "Jméno: " + jmeno + " Příjmení: " + prijmeni + " Datum Narození: " + datumNarozeni + " Email: " + email + " heslo: " + heslo;
    }
}
