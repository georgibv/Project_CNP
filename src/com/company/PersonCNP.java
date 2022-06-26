package com.company;

public class PersonCNP {

    String cnp;

    char genreCode;
    String genre;
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

        this.genreCode = this.cnp.charAt(0);
        switch (this.genreCode)
        {
            case '1':
            case '3':
            case '5':
            case '7':
               this.genre = "Male";
               break;
            case '2':
            case '4':
            case '6':
            case '8':
                this.genre = "Female";
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

    public String getGenre() {
        return genre;
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
        switch (this.genreCode)
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


        }
        return "";

    }



}
