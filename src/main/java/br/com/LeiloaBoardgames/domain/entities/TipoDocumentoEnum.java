package br.com.LeiloaBoardgames.domain.entities;

public enum TipoDocumentoEnum {

    RG(1, "RG"),
    CNH(2, "CNH"),
    PASSAPORTE(3, "Passaporte");

    private int codigo;
    private String descricao;

    private TipoDocumentoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoDocumentoEnum toEnum(Integer codigo) {
        if (codigo == null) {
            return null;
        }

        for (TipoDocumentoEnum tipoDocumento : TipoDocumentoEnum.values()) {
            if (codigo.equals(tipoDocumento.getCodigo())) {
                return tipoDocumento;
            }
        }

        throw new IllegalArgumentException("Id inválido: " + codigo);
    }
}
