/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

/**
 *
 * @author Sreenidhi Madala
 */
public enum Proff_Recommend {
    F("Pre Requisite compulsory", 1),
    ADB("Pre Requisite manditory", 3),
    GDP_1("Pre Requisite compulsory", 1),
    GDP_2("No Pre req done, do not allow", 5),
    R_1("Restricted", 7);

    private String description;
    private int code;

    private Proff_Recommend(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public static Proff_Recommend getF() {
        return F;
    }

    public static Proff_Recommend getADB() {
        return ADB;
    }

    public static Proff_Recommend getGDP_1() {
        return GDP_1;
    }

    public static Proff_Recommend getGDP_2() {
        return GDP_2;
    }

    public static Proff_Recommend getR_1() {
        return R_1;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }

}
