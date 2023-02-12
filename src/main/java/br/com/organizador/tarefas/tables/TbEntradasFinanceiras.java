package br.com.organizador.tarefas.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Table(name = "TB_ENTRADAS_FINANCEIRAS")
public class TbEntradasFinanceiras {

    @Id
    @Column(name = "COD_ENTRADA_FINANCEIRA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_entrada_financeira;
    @ManyToOne // essa notacao significa que muitas entradas financeiras estarao associados a um mesmo e unico login
    @NotNull(message = "Toda entrada financeira precisa de um login associado (login_id)")
    @Column(name = "LOGIN_ID")
    public TbLogins login_id;

    @Column(name = "DATA_INCLUSAO_RENDA")
    @NotBlank(message = "O campo dataInclusaoRenda não pode estar em branco")
    public LocalDateTime dataInclusaoRenda;

    @Column(name = "DATA_ALTERACAO_RENDA")
    @NotBlank(message = "O campo dataAlteracaoRenda não pode estar em branco")
    public LocalDateTime dataAlteracaoRenda;

    @Column(name = "RENDA_FIXA_LIQUIDA")
    private BigDecimal rendaFixaLiquida;

    @Column(name = "RENDA_FIXA_BRUTA")
    private BigDecimal rendaFixaBruta;

    @Column(name = "DESCRICAO_RENDA_FIXA")
    private String descricaoRendaFixa;

    @Column(name = "RENDA_VARIAVEL_LIQUIDA")
    private BigDecimal rendaVariavelLiquida;

    @Column(name = "RENDA_VARIAVEL_BRUTA")
    private BigDecimal rendaBrutaLiquida;

    @Column(name = "DESCRICAO_RENDA_VARIAVEL")
    private String descricaoRendaVariavel;

    @Column(name = "VALE_REFEICAO")
    private BigDecimal valeRefeicao;

    @Column(name = "VALE_ALIMENTACAO")
    private BigDecimal valeAlimentacao;

    @Column(name = "OUTRAS_RENDAS")
    private BigDecimal outrasRendas;

}
