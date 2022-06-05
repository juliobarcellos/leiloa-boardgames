package br.com.LeiloaBoardgames.domain.entities;

public enum StatusEnum {

    ATIVO, INATIVO, CANCELADO;

    public static StatusEnum getStatus(String status) {
        switch (status) {
            case "ATIVO":
                return ATIVO;
            case "INATIVO":
                return INATIVO;
            case "CANCELADO":
                return CANCELADO;
            default:
                return null;
        }
    }
}
