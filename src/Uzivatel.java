import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Uzivatel {
    private String jmeno;
    private String prijmeni;
    private String datumNarozeni;
    private String email;
    private String heslo;


    public Uzivatel(String jmeno, String prijmeni, String datumNarozeni, String email, String heslo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.email = email;
        this.heslo = heslo;
    }


    public StringBuffer upravPrijmeni() {
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


    public StringBuffer upravJmeno() {
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
        StringBuffer sbPrijmeni = new StringBuffer(upravPrijmeni());
        StringBuffer sbJmeno = new StringBuffer(upravJmeno());
        StringBuffer mail = new StringBuffer();
        mail.append(sbPrijmeni.substring(0, 3));
        mail.append(sbJmeno.substring(0, 3));
        int randomNum = (int) (Math.random() * 200);
        mail.append(randomNum);
        mail.append("@");
        mail.append("seznam.cz");
       return mail;

    }

   public Boolean zkontrolujEmail() {
        StringBuffer sbmail = new StringBuffer(email);
        Boolean ok = true;
        String zatecka;
        if(sbmail.isEmpty()){
            ok=false;
        }
        if(sbmail.indexOf("@")==-1){
            ok=false;
        }

        if(sbmail.indexOf(".")!=-1){
            for(int i=sbmail.indexOf(".");i<sbmail.length();i++){
                if(sbmail.charAt(i)==' '){
                    ok=false;
                }
                if(sbmail.charAt(i) == '@'){
                    ok=false;
                }
        }

        }
        else{
            ok=false;
        }




        return ok;
    }

    public void sifraEmail() {
        if(zkontrolujEmail()) {
            StringBuffer sb = new StringBuffer(email);
            StringBuffer sifra = new StringBuffer();
            String sb2;
            String sb3;
            String sb4;


            sb2 = sb.substring(0, sb.indexOf("@"));
            sb3 = sb.substring(sb.indexOf("@"), sb.indexOf("."));
            sb4 = sb.substring(sb.indexOf("."), sb.length());

            sifra.append(sb2.substring(0, 2));
            sifra.append("*****");
            sifra.append(sb3.substring(0, 1));
            sifra.append(sb3.substring(sb3.length() - 1, sb3.length()));
            sifra.append("*****");
            sifra.append(sb4);

            System.out.println(sifra);
        }
    }

    public String toString ="Jméno: "+ upravJmeno().toString()+" Přijmení:" + upravPrijmeni().toString()+" Email:"+ email.toString()+ " Heslo: "+ heslo.toString() ;


    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public String getDatumNarozeni() {
        return datumNarozeni;
    }

    public void setDatumNarozeni(String datumNarozeni) {
        this.datumNarozeni = datumNarozeni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }
}
