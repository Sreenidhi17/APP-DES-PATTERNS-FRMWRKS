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
public enum Pre_Req {

    OOPS(1),
    DATABASE(3),
    FRAMEWORKS(2),
    MOBILE_COMPUTING(4),
    GDP_1(5),
    GDP_2(6);

    public final int code;

    private Pre_Req(int code) {
        this.code = code;
    }

}
