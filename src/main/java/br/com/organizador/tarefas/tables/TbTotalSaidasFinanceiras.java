package br.com.organizador.tarefas.tables;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Table(name = "TB_TOTAL_SAIDAS_FINANCEIRAS")
public class TbTotalSaidasFinanceiras {

    @Id
    @Column(name = "TOTAL_SAIDA_FINANCEIRA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalSaidaFinanceiraId;
    @OneToOne // essa notacao significa que um unico total de saidas financeiras estara associado a um login
    @JoinColumn(name = "LOGIN_ID")
    public TbLogins loginId;
    @OneToMany // essa notacao significa que um unico totalSaidaFinanceira pode ser associado a varias saidaFinanceiraId
    @JoinColumn(name = "SAIDA_FINANCEIRA_ID")
    public List<TbSaidasFinanceiras> saidasFinanceirasId;

    @Column(name = "DATA_INCLUSAO_TOTAL_RENDA")
    @NotBlank(message = "O campo dataInclusaoRenda não pode estar em branco")
    public LocalDateTime dataInclusaoRenda;

    @Column(name = "DATA_ALTERACAO_TOTAL_RENDA")
    @NotBlank(message = "O campo dataAlteracaoRenda não pode estar em branco")
    public LocalDateTime dataAlteracaoRenda;

    @Column(name = "VALOR_CONSOLIDADO_SAIDA")
    private BigDecimal valorConsolidadoSaida;

    @Column(name = "DESCRICAO_TOTAL")
    private BigDecimal descricaoTotal;
}
