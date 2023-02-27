package br.com.organizador.tarefas.tables.entradas;


import br.com.organizador.tarefas.tables.TbLogins;
import br.com.organizador.tarefas.tables.entradas.TbEntradasFinanceiras;
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

@Table(name = "TB_TOTAL_ENTRADAS_FINANCEIRAS")
public class TbTotalEntradasFinanceiras {

    @Id
    @Column(name = "TOTAL_ENTRADA_FINANCEIRA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long totalEntradaFinanceiraId;
    @OneToOne // essa notacao significa que um unico total de entradas financeiras estara associado a um unico login
    @JoinColumn(name = "LOGIN_ID")
    public TbLogins loginId;

    @OneToMany // essa notacao significa que um unico totalEntradaFinanceiraId pode ser associado a varias entradaFinanceiraId
    @JoinColumn(name = "ENTRADA_FINANCEIRA_ID")
    public List<TbEntradasFinanceiras> entradaFinanceiraId;

    @Column(name = "DATA_INCLUSAO_TOTAL_RENDA")
    @NotBlank(message = "O campo dataInclusaoRenda não pode estar em branco")
    public LocalDateTime dataInclusaoTotalRenda;

    @Column(name = "DATA_ALTERACAO_TOTAL_RENDA")
    @NotBlank(message = "O campo dataAlteracaoRenda não pode estar em branco")
    public LocalDateTime dataAlteracaoTotalRenda;

    @Column(name = "VALOR_TOTAL_ENTRADA_FINANCEIRA")
    private BigDecimal valorTotalEntradaFinanceira;

    @Column(name = "DESCRICAO_TOTAL")
    private BigDecimal descricaoTotal;
}
