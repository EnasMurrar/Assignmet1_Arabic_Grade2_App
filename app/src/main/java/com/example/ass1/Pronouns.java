package com.example.ass1;

public class Pronouns {

    private String name;
    private int imageID;

    public static final Pronouns[] pronouns = {
            new Pronouns("ضمائر المخاطب", R.drawable.pronouns1),
            new Pronouns("ضمائر المتكلم", R.drawable.pronouns2),
            new Pronouns("ضمائر الغائب", R.drawable.pronouns3),

    };
    private Pronouns(String name, int imageID){
        this.name = name;
        this.imageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }
}
