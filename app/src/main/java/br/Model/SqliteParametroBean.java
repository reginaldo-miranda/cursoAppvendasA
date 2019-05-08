package br.Model;


public class SqliteParametroBean {

    public static final String P_CODIGO_USUARIO = "p_usu_codigo";
    public static final String P_IMPORTAR_CLIENTE = "p_importar_cliente";
    public static final String P_ENDERECO_IP_LOCAL = "p_end_ip_local";
    public static final String P_ENDERECO_IP_REMOTO = "p_end_ip_remoto";
    public static final String P_ESTOQUE_NEGATIVO = "p_trabalhar_com_estoque_negatico";
    public static final String P_DESCONTO_VENDEDOR = "p_desconto_do_vendedor";
    public static final String P_USUARIO = "p_usuario";
    public static final String P_SENHA = "p_senha";

    private Integer p_usu_codigo;
    private String p_importar_cliente;
    private String p_end_ip_local;
    private String p_end_ip_remoto;
    private String p_trabalhar_com_estoque_negatico;
    private Integer p_desconto_do_vendedor;
    private String p_usuario;
    private String p_senha;

    public Integer getP_usu_codigo() {
        return p_usu_codigo;
    }

    public void setP_usu_codigo(Integer p_usu_codigo) {
        this.p_usu_codigo = p_usu_codigo;
    }

    public String getP_importar_cliente() {
        return p_importar_cliente;
    }

    public void setP_importar_cliente(String p_importar_cliente) {
        this.p_importar_cliente = p_importar_cliente;
    }

    public String getP_end_ip_local() {
        return p_end_ip_local;
    }

    public void setP_end_ip_local(String p_end_ip_local) {
        this.p_end_ip_local = p_end_ip_local;
    }

    public String getP_end_ip_remoto() {
        return p_end_ip_remoto;
    }

    public void setP_end_ip_remoto(String p_end_ip_remoto) {
        this.p_end_ip_remoto = p_end_ip_remoto;
    }

    public String getP_trabalhar_com_estoque_negatico() {
        return p_trabalhar_com_estoque_negatico;
    }

    public void setP_trabalhar_com_estoque_negatico(String p_trabalhar_com_estoque_negatico) {
        this.p_trabalhar_com_estoque_negatico = p_trabalhar_com_estoque_negatico;
    }

    public Integer getP_desconto_do_vendedor() {
        return p_desconto_do_vendedor;
    }

    public void setP_desconto_do_vendedor(Integer p_desconto_do_vendedor) {
        this.p_desconto_do_vendedor = p_desconto_do_vendedor;
    }

    public String getP_usuario() {
        return p_usuario;
    }

    public void setP_usuario(String p_usuario) {
        this.p_usuario = p_usuario;
    }

    public String getP_senha() {
        return p_senha;
    }

    public void setP_senha(String p_senha) {
        this.p_senha = p_senha;
    }
}
