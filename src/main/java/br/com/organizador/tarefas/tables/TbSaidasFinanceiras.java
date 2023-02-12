package br.com.organizador.tarefas.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

@Table(name = "TB_SAIDAS_FINANCEIRAS")
public class TbSaidasFinanceiras {
    @Id
    @Column(name = "SAIDA_FINANCEIRA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long saidaFinanceiraId;

    @ManyToOne // essa notacao significa que muitas saidas financeiras estarao associados a um login
    @NotNull(message = "Toda entrada financeira precisa de um login associado (login_id)")
    @JoinColumn(name = "LOGIN_ID")
    public TbLogins loginId;

    @ManyToOne // muitas saidas financeiras fazem parte de apenas um total de saida financeira
    @JoinColumn(name = "TOTAL_SAIDA_FINANCEIRA_ID")
    public TbTotalSaidasFinanceiras totalSaidasFinanceirasId;

    @Column(name = "DATA_INCLUSAO_SAIDA_FINANCEIRA")
    @NotBlank(message = "O campo dataInclusaoSaidaFinanceira não pode estar em branco")
    public LocalDateTime dataInclusaoSaidaFinanceira;

    @Column(name = "DATA_ALTERACAO_SAIDA_FINANCEIRA")
    @NotBlank(message = "O campo dataAlteracaoSaidaFinanceira não pode estar em branco")
    public LocalDateTime dataAlteracaoSaidaFinanceira;

    @Column(name = "VALOR_OPERACAO")
    private BigDecimal valorOperacao;

    @Column(name = "DESCRICAO_OPERACAO")
    private String descricaoOperacao;


}
