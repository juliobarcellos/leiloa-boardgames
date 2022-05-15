package br.com.LeiloaBoardgames.domain;


public enum EstadoEnum {

    AC,
    AL,
    AM,
    AP,
    BA,
    CE,
    DF,
    ES,
    GO,
    MA,
    MT,
    MS,
    MG,
    PA,
    PB,
    PE,
    PI,
    PR,
    RJ,
    RN,
    RO,
    RR,
    RS,
    SC,
    SE,
    SP,
    TO;

    public static EstadoEnum getEstado(String sigla) {
        for (EstadoEnum estado : EstadoEnum.values()) {
            if (estado.toString().equals(sigla)) {
                return estado;
            }
        }
        return null;
    }
}
