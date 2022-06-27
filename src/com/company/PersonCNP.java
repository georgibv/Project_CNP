package com.company;

public class PersonCNP {

    String cnp;

    char genderCode;
    String gender;
    String year;
    String month;
    String day;
    String regionCode;
    String region;
    int age;

    public String getRegion() {

        return region;
    }
    public int getAge() {
        return age;
    }

    public String getMonth() {

        return month;
    }

    public String getDay() {

        return day;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;

        this.genderCode = this.cnp.charAt(0);
        switch (this.genderCode)
        {
            case '1':
            case '3':
            case '5':
            case '7':
               this.gender = "Male";
               break;
            case '2':
            case '4':
            case '6':
            case '8':
                this.gender = "Female";
                break;

        }

        int tmpyear = this.getStartYearbyGenre()+ Integer.parseInt(this.cnp.substring(1,3));
        this.year= String.valueOf(tmpyear);
        this.month= this.cnp.substring(3,5);
        this.day= this.cnp.substring(5,7);
        this.regionCode = this.cnp.substring(7,9);
        this.region = this.getContryFromContryCode();

        UserAge tmp = new UserAge();
        String userBirth = this.day+"-"+this.month+"-"+this.year;
        this.age =  tmp.getUserAge(userBirth);


    }

    public String getGender() {
        return gender;
    }

    public String getYear() {
        return year;
    }

    public String getBirthDate(){
         return this.year +"-"+  this.month + "-" + this.day;
    }

    // returns reference year by genre
    // example:
    // 1,2 -> 1900
    // 3,4 -> 1800
    private Integer getStartYearbyGenre()
    {
        switch (this.genderCode)
        {
            case '1':
            case '2':
                return 1900;
            case '3':
            case '4':
                return 1800;
            case '5':
            case '6':
                return 2000;
            case '7':
            case '8':
                return 0;//? we do not know;
        }
        return 0;


    }

    private String getContryFromContryCode(){
        switch ( this.regionCode){
            case "01":
                return "Alba";
            case "02":
                return "Arad";
            case "03":
                return "Arges";
            case "04":
                return "Bacau";
            case "05":
                return "Bihor";
            case "06":
                return "Bistrita-Nasaud";
            case "07":
                return "Botosani";
            case "08":
                return "Brasov";
            case "09":
                return "Braila";
            case "10":
                return "Buzau";
            case "11":
                return "Caras-Severin";
            case"12":
                return "Cluj";
            case "13":
                return "Constanta";
            case "14":
                return "Covasna";
            case "15":
                return "Dambovita";
            case "16":
                return "Dolj";
            case "17":
                return "Galati";
            case "18":
                return "Gorj";
            case "19":
                return "Harghita";
            case "20":
                return "Hunedoara";
            case "21":
                return "Ialomita";
            case "22":
                return "Iasi";
            case "23":
                return "Ilfov";
            case "24":
                return "Maramures";
            case "25":
                return "Mehedinti";
            case "26":
                return "Mures";
            case "27":
                return "Neamt";
            case "28":
                return "Olt";
            case "29":
                return "Prahova";
            case "30":
                return "Satu Mare";
            case "31":
                return "Salaj";
            case "32":
                return "Sibiu";
            case "33":
                return "Suceava";
            case "34":
                return "Teleormsn";
            case "35":
                return "Timis";
            case "36":
                return "Tulcea";
            case "37":
                return "Vaslui";
            case "38":
                return "Valcea";
            case "39":
                return "Vrancea";
            case "40":
                return "Bucuresti";
            case "41":
                return "Bucuresti-Sector 1";
            case "42":
                return "Bucuresti-Sector 2";
            case "43":
                return "Bucuresti-Sector 3";
            case "44":
                return "Bucuresti-Sector 4";
            case "45":
                return "Bucuresti-Sector 5";
            case "46":
                return "Bucuresti-Sector 6";
            case "47":
                return "Bucuresti-Sector 7 desfiintat";
            case "48":
                return "Bucuresti-Sector 8 desfiintat";
            case "51":
                return "Calarasi";
            case "52":
                return "Giurgiu";

        }
        return "";

    }



}
