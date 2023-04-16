package com.example.compendium;

public class BookCharacter {
    private int id;
    private String name;
    private String appearanceDesc;
    private String characterDesc;
    private String rank;
    private String conflictSide;

    public BookCharacter(String name, String appearanceDesc, String characterDesc, String rank, String conflictSide) {
        this.name = name;
        this.appearanceDesc = appearanceDesc;
        this.characterDesc = characterDesc;
        this.rank = rank;
        this.conflictSide = conflictSide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAppearanceDesc() {
        return appearanceDesc;
    }

    public void setAppearanceDesc(String appearanceDesc) {
        this.appearanceDesc = appearanceDesc;
    }

    public String getCharacterDesc() {
        return characterDesc;
    }

    public void setCharacterDesc(String characterDesc) {
        this.characterDesc = characterDesc;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getConflictSide() {
        return conflictSide;
    }

    public void setConflictSide(String conflictSide) {
        this.conflictSide = conflictSide;
    }
}
