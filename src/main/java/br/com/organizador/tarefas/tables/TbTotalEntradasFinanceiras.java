package br.com.organizador.tarefas.tables;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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

@Table(name = "TB_TOTAL_ENTRADAS_FINANCEIRAS")
public class TbTotalEntradasFinanceiras {

    @Id
    @Column(name = "COD_TOTAL_ENTRADA_FINANCEIRA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codTotalEntradaFinanceira;
    @OneToOne // essa notacao significa que um unico total de entradas financeiras estara associado a um unico login
    @JoinColumn(name = "LOGIN_ID")
    public TbLogins loginId;

    @OneToOne // essa notacao significa que um unico total de entradas financeiras estara associado a uma uma entrada financeira
    @JoinColumn(name = "LOGIN_ID")
    public TbEntradasFinanceiras entradaFinanceiraId;

    @Column(name = "DATA_INCLUSAO_TOTAL_RENDA")
    @NotBlank(message = "O campo dataInclusaoRenda não pode estar em branco")
    public LocalDateTime dataInclusaoRenda;

    @Column(name = "DATA_ALTERACAO_TOTAL_RENDA")
    @NotBlank(message = "O campo dataAlteracaoRenda não pode estar em branco")
    public LocalDateTime dataAlteracaoRenda;

    @Column(name = "VALOR_CONSOLIDADO_LIQUIDO")
    private BigDecimal valorConsolidadoLiquido;

    @Column(name = "DESCRICAO_TOTAL")
    private BigDecimal descricaoTotal;
}
