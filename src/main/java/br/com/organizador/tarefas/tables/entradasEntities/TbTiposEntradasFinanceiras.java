package br.com.organizador.tarefas.tables.entradasEntities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter

@Table(name = "TB_TIPOS_ENTRADAS_FINANCEIRAS")
public class TbTiposEntradasFinanceiras {

    @Id
    @Column(name = "TIPO_ENTRADA_FINANCEIRA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoEntradaFinanceiraId;

    @OneToOne // essa notacao significa que um tipoSaidaFinanceira esta associado a uma saida financeira
    @JoinColumn(name = "ENTRADA_FINANCEIRA_ID")
    public TbEntradasFinanceiras entradaFinanceiraId;
    @Column(name = "NOME_TIPO_SAIDA")
    public LocalDateTime nomeTipoSaida;

    @Column(name = "DESCRICAO_TIPO_SAIDA")
    public LocalDateTime descricaoTipoSaida;

    @Column(name = "DATA_INCLUSAO")
    @NotBlank(message = "O campo dataInclusao não pode estar em branco")
    public LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    @NotBlank(message = "O campo dataAlteracao não pode estar em branco")
    public LocalDateTime dataAlteracao;

}
