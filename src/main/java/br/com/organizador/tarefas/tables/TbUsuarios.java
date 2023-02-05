package br.com.organizador.tarefas.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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

@Table(name = "TB_PESSOAS")
public class TbUsuarios {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cod_pessoa;

    @Column(name = "NOME", nullable=false, length=5000)
    private String nome;

    @Column(name = "email")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name = "TELEFONE_CELULAR")
    private String telefoneCelular;

    @Column(name = "TIPO_PESSOA")
    private String tipoPessoa;

    @Column(name = "CPF_CNPJ")
    private String cpfCnpj;

    @Column(name = "NIVEL_ACESSO")
    private String nivelAcesso;

    @Column(name = "DATA_INCLUSAO")
    public LocalDateTime dataInclusao;

    @Column(name = "DATA_ALTERACAO")
    public LocalDateTime dataAlteracao;

}
