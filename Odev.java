public class Odev {
    private String[] isimler;

    public Odev(String[] array){
        isimler = array;
    }
    public void siniflandirma(){
        int sinifA = 0;
        int sinifB = 0;
        int sinifC = 0;

        for (String isim : isimler) {
            String[] parcalanmisIsim = isim.split("\\(");
            int dakika = Integer.parseInt(parcalanmisIsim[1].substring(0, parcalanmisIsim[1].length() - 1));

            if (dakika >= 200 && dakika <= 299) {
                sinifA++;
            } else if (dakika >= 300 && dakika <= 399) {
                sinifB++;
            } else if (dakika >= 400) {
                sinifC++;
            }
        }
        System.out.println("A -> " + sinifA);
        System.out.println("B -> " + sinifB);
        System.out.println("C -> " + sinifC);
    }
    public static String[] enAzDakika(String[] isimler) {
        String enAzDakikaIsmi = "";
        int enAzDakika = Integer.MAX_VALUE;

        for (String isim : isimler) {
            String[] parcalanmisIsim = isim.split("\\(");
            String sadeIsim = parcalanmisIsim[0];
            int dakika = Integer.parseInt(parcalanmisIsim[1].substring(0, parcalanmisIsim[1].length() - 1));

            if (dakika < enAzDakika) {
                enAzDakika = dakika;
                enAzDakikaIsmi = sadeIsim;
            }
        }return new String[]{enAzDakikaIsmi, String.valueOf(enAzDakika)};
    }
    public static String[] ikinciEnAzDakika(String[] isimler) {
        String[] enAzDakikaBilgisi = enAzDakika(isimler);
        String enAzDakikaIsmi = enAzDakikaBilgisi[0];

        String[] isimlerKopya = new String[isimler.length - 1];
        int j = 0;
        for (String isim : isimler) {
            if (!isim.trim().startsWith(enAzDakikaIsmi) && !isim.isEmpty()) {
                isimlerKopya[j++] = isim;
            }
        }return enAzDakika(isimlerKopya);
    }
    public static String[] ucuncuEnAzDakika(String[] isimler) {
        String[] enAzDakikaBilgisi = enAzDakika(isimler);
        String[] ikinciEnAzDakikaBilgisi = ikinciEnAzDakika(isimler);

        String enAzDakikaIsmi = enAzDakikaBilgisi[0];
        String ikinciEnAzDakikaIsmi = ikinciEnAzDakikaBilgisi[0];

        String[] isimlerKopya = new String[isimler.length - 2];
        int j = 0;

        for (String isim : isimler) {
            if (!isim.trim().startsWith(enAzDakikaIsmi) && !isim.trim().startsWith(ikinciEnAzDakikaIsmi)) {
                isimlerKopya[j++] = isim;
            }
        }return enAzDakika(isimlerKopya);
    }

    public static void main(String[] args) {
        String[] isimler = {"Kadir(341)", "Gökhan(273)", "Hakan(278)", "Suzan(329)", "Pınar(445)", "Mehmet(402)", "Ali(388)", "Emel(270)", "Fırat(243)", "James(334)", "Jale(412)", "Ersin(393)", "Deniz(299)", "Gözde(343)", "Anıl(317)", "Burak(265)"};

        Odev odev = new Odev(isimler);
        odev.siniflandirma();

        String[] enAzDakikaBilgisi = enAzDakika(isimler);
        String[] ikinciEnAzDakikaBilgisi = ikinciEnAzDakika(isimler);
        String[] ucuncuEnAzDakikaBilgisi = ucuncuEnAzDakika(isimler);

        System.out.println("Birinci kişi = " + enAzDakikaBilgisi[0] + " " + enAzDakikaBilgisi[1] + "'");
        System.out.println("İkinci kişi = " + ikinciEnAzDakikaBilgisi[0] + " " + ikinciEnAzDakikaBilgisi[1] + "'" );
        System.out.println("Üçüncü kişi = " + ucuncuEnAzDakikaBilgisi[0] + " " + ucuncuEnAzDakikaBilgisi[1] + "'" );
    }
}


